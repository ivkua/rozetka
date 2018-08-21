import org.testng.Assert;
import pageObject.BasePage;
import pageObject.MainPage;
import pageObject.SmartphonesListPage;
import utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pageObject.HomePage;
import utils.PropertiesLoader;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    private String url = PropertiesLoader.getInstance().getresourceByName("url");

    private BasePage basePage;
    private MainPage mainPage;

    @BeforeTest
    public void beforeTest() {
        driver = DriverManager.getINSTANCE().createChromeDriver().getDriver();
        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
          mainPage = new MainPage();

        driver.get(url);

        if (method.getDeclaringClass().equals(PhoneCommentsTest.class)) {
            driver.findElement(By.xpath("//a[@class='logo-link']")).click();
            basePage = mainPage.goToSmartphonePage();
            Assert.assertTrue(basePage instanceof SmartphonesListPage);

        }

    }

    @AfterMethod
    public void afterMethod(Method method) {
        if(method.getDeclaringClass().equals(HomePage.class)) {
            if (method.getName().equals("loginWithCorrectCredentials")) {
                WebElement profileMenu = driver.findElement(By.xpath("//a[@name='profile']"));
                Actions act = new Actions(driver);
                act.moveToElement(profileMenu).build().perform();
                driver.findElement(By.xpath("//a[@name='signout']")).click();
            }
        }
    }

    @AfterTest
    public void afterTest() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}

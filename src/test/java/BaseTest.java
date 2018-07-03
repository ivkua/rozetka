import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pageObject.HomePage;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
    private String url = "https://my.rozetka.com.ua/";

    @BeforeTest
    public void beforeTest() {
        driver = DriverManager.getINSTANCE().createChromeDriver().getDriver();
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(url);
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

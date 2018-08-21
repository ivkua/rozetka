package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {
    public MainPage() { PageFactory.initElements(this.driver, this); }

    @FindBy (xpath = "//a[@class='logo-link']/img")  //change locator
    private WebElement mainBtn;

    @FindBy (xpath = "//a[@name='signin']")
    private WebElement singInBtn;

    @FindBy (xpath = "//input[@name='login']")
    private WebElement emailInput;

    @FindBy (xpath = "//input[@name='password']")
    private WebElement passwordInput;

    @FindBy (xpath = "//button[@name='auth_submit']")
    private WebElement loginInBtn;

    String s = "//a[@name='profile']";

    public BasePage loginIn(String login, String password) {
        //driver.findElement(By.xpath("//a[@class='logo-link']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='logo-link']"))).click();
        mainBtn.click();
        singInBtn.click();
        emailInput.sendKeys(login);
        passwordInput.sendKeys(password);
        loginInBtn.click();
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(s)));
            return new HomePage();
        } catch (TimeoutException e) {
            return new MainPage();
        }
    }

    public BasePage goToSmartphonePage() {
        WebElement smartPhoneMenuButton = driver.findElement(By.xpath("//a[@href='https://rozetka.com.ua/telefony-tv-i-ehlektronika/c4627949/']"));
        Actions act = new Actions(driver);
        act.moveToElement(smartPhoneMenuButton).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()=' Смартфоны ']"))).click();
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[@itemprop='item']")));
            return new SmartphonesListPage();
        } catch (TimeoutException e) {
            return new MainPage();
        }
    }

}
// TODO static locator for every page
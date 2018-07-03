package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {
    public MainPage() { PageFactory.initElements(this.driver, this); }

    @FindBy (xpath = "//img[@alt='Интернет магазин Rozetka.ua™ - №1']")
    private WebElement mainBtn;

    @FindBy (xpath = "//a[@name='signin']")
    private WebElement singInBtn;

    @FindBy (xpath = "//input[@name='login']")
    private WebElement emailInput;

    @FindBy (xpath = "//input[@name='password']")
    private WebElement passwordInput;

    @FindBy (xpath = "//button[@name='auth_submit']")
    private WebElement loginInBtn;

    String s = "//span[@id='header_user_menu_parent']";

    public BasePage loginIn(String login, String password) {
        mainBtn.click();
        singInBtn.click();
        emailInput.sendKeys(login);
        passwordInput.sendKeys(password);
        loginInBtn.click();
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(s)));
            return new HomePage();
        } catch (RuntimeException e) {
            return new MainPage();
        }
    }

}

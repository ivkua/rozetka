package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    public HomePage() { PageFactory.initElements(this.driver, this); }

    public BasePage logOut() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@name='profile']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='profile_signout']"))).click();
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@name='auth-btn']/a")));
            return new MainPage();
        } catch (TimeoutException e) {
            return new BasePage();
        }
    }
}

package pageObject;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver = DriverManager.getINSTANCE().getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 10, 250);
}

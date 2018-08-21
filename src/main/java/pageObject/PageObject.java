package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

public class PageObject {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public PageObject() {
       driver = DriverManager.getINSTANCE().createChromeDriver().getDriver();
       wait = new WebDriverWait(driver, 15, 250);
    }

}

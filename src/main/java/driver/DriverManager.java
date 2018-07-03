package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private static final String PATH_TO_CHROME_DRIVER = "src/main/resources/chromedriver";

    private static DriverManager INSTANCE = new DriverManager();

    private ThreadLocal<WebDriver> localDriver = new ThreadLocal<>();

    private DriverManager() {}

    public static DriverManager getINSTANCE() { return INSTANCE; }

    public DriverManager createChromeDriver() {
        System.setProperty("webdriver.chrome.driver", PATH_TO_CHROME_DRIVER);
        localDriver.set(new ChromeDriver());
        return this;
    }

    public WebDriver getDriver() {return localDriver.get(); }

}

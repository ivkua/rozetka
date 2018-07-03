package pageObject;

import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    public HomePage() { PageFactory.initElements(this.driver, this); }
}

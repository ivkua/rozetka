import org.testng.annotations.DataProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.BasePage;
import pageObject.HomePage;
import pageObject.MainPage;
import utils.PropertiesLoader;

public class LoginInTest extends BaseTest {
    private BasePage basePage;
    private MainPage mainPage;
    private HomePage homePage;

    private String email = PropertiesLoader.getInstance().getresourceByName("email");
    private String password = PropertiesLoader.getInstance().getresourceByName("password");
    private String wrongEmail = "wrong@i.ua";
    private String wrongPassword = "270495";

    @BeforeMethod
    public void BeforeLoginIn() {
        mainPage = new MainPage();
        homePage = new HomePage();
    }

    @Test
    public void loginWithCorrectCredentials() {
        basePage = mainPage.loginIn(email, password);
        Assert.assertTrue(basePage instanceof HomePage);
        basePage = homePage.logOut();
        Assert.assertTrue(basePage instanceof MainPage);
    }


    @Test(dataProvider = "provideData")
    public void loginWithWrongCredentials(String login, String password) {
        basePage = mainPage.loginIn(login, password);
        Assert.assertTrue(basePage instanceof MainPage);

    }

    @DataProvider
    private Object[][] provideData() {
        return new Object[][]{
                {wrongEmail, password},
                {email, wrongPassword},
                {wrongEmail, wrongPassword}
                };
    }
}

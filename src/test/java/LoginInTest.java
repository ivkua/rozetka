import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.BasePage;
import pageObject.HomePage;
import pageObject.MainPage;

public class LoginInTest extends BaseTest {
    private BasePage basePage;
    private MainPage mainPage;
    private HomePage homePage;

    private String email = "ivkua@i.ua";
    private String password = "270494I";
    private String wrongEmail = "wrong@i.ua";
    private String wrongPassword = "270495";

    @BeforeMethod
    public void BeforeLoginIn() {
        mainPage = new MainPage();
    }

    @Test
    public void loginWithCorrectCredentials() {
        basePage = mainPage.loginIn(email, password);
        Assert.assertTrue(basePage instanceof HomePage);
    }

    @Test(dataProvider = "provideData")
    public void loginWithWrongCredentials(String login, String password) {
        basePage = mainPage.loginIn(login,password);
        Assert.assertTrue(basePage instanceof MainPage);
    }

    @DataProvider
    private Object[][] provideData() {
        return new Object[][]{{"", password},
                {email, ""},
                {wrongEmail, password},
                {email, wrongPassword},
                {wrongEmail, wrongPassword},
                {"", ""}};
    }
}

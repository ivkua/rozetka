import org.testng.annotations.Test;
import pageObject.BasePage;
import pageObject.PhonePage;
import pageObject.SmartphonesListPage;

import java.util.List;

public class PhoneCommentsTest extends BaseTest {
    private SmartphonesListPage smartphonesListPage = new SmartphonesListPage();
    private PhonePage phonePage = new PhonePage();

    @Test
    public void method () {
        smartphonesListPage.setModelFilter("Apple");
        smartphonesListPage.setDiagonalFilter("5.1\" - 5.5\"");
        smartphonesListPage.setPriceFilter("10000", "25000");
        List<String> applePhoneList = smartphonesListPage.collectSmartphoneLinks();
        for (String hrefPhone : applePhoneList) {
            driver.get(hrefPhone);
            phonePage.clickOnCommentsPage();

        }

    }

}

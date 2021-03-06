package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class SmartphonesListPage extends BasePage {
    @FindBy(xpath = "//span[text()='Apple']")
    WebElement appleFilter;

    @FindBy(xpath = "//i[text()='5.1\" - 5.5\"']")
    WebElement diagonalFilter;

    @FindBy(xpath = "//input[@name='price[max]']")
    WebElement priceMaxInput;

    @FindBy(xpath = "//button[@id='submitprice']")
    WebElement priceSubmitBtn;

    public void setModelFilter(String model) {
        delay(1500);
        if (model.equalsIgnoreCase("apple")) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[text()='Apple']"))).click();
        }
    }

    public void setPriceFilterMax(String max) {
        delay(1500);
        WebElement maxValue = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='price[max]']")));
        maxValue.sendKeys(max);
        delay(2000);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='submitprice']")));
        element.click();
    }

    public void setDiagonalFilter(String diagonalDiapazon) {
        delay(1500); // TODO сделать JS клик
        if (diagonalDiapazon.equalsIgnoreCase("5.1\" - 5.5\"")) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[text()='5.1\" - 5.5\"']"))).click();
        }
    }

    public List<String> collectSmartphoneLinks() {
        delay(1500);
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='g-i-tile-i-box-desc']/div/a"))).stream().map(w -> w.getAttribute("href")).collect(Collectors.toList()); //TODO почитать о синтаксисе сыллок на метод (вместе с лямбдами)
    }
    
}

package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class PhonePage extends BasePage {
    @FindBy(xpath = "//li[@name='comments'/a]")
    WebElement commets;

    public BasePage clickOnCommentsPage() {
        commets.click();
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[@href='#comment_form']")));
            return new CommentsPage();
        } catch (TimeoutException e) {
            return new PhonePage();
        }
    }

    public List<String> getComments(String href) {
        driver.get(href);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@name='comments']"))).click();
        return driver.findElements(By.xpath("//div[@class='pp-review-text-i']")).stream().map(w -> w.getText()).collect(Collectors.toList());
    }
}

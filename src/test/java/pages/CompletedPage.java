package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompletedPage extends BasePage {
    private final By completeMessage = By.cssSelector(DATA_TEST_PATTERN.formatted("complete-header"));

    public CompletedPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверка успешного завершения заказа")
    public boolean isOrderCompleted() {
        return driver.findElement(completeMessage).isDisplayed();
    }
}

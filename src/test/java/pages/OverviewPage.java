package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage extends BasePage {
    private final By total = By.cssSelector(DATA_TEST_PATTERN.formatted("total-label"));
    private final By finishButton = By.cssSelector(DATA_TEST_PATTERN.formatted("finish"));
    private final By cancelButton = By.cssSelector(DATA_TEST_PATTERN.formatted("cancel"));
    private final By pageName = By.cssSelector(DATA_TEST_PATTERN.formatted("title"));

    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    @Step("Получение итоговой суммы")
    public String getTotal() {
        return driver.findElement(total).getText();
    }

    @Step("Завершение заказа")
    public void clickFinish() {
        driver.findElement(finishButton).click();
    }

    @Step("Отмена заказа")
    public void clickCancel() {
        driver.findElement(cancelButton).click();
    }

    @Step("Получение название страницы")
    public String getTitle() {
        return driver.findElement(pageName).getText();
    }
}

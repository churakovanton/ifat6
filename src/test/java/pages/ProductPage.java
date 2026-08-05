package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    private static final String ADD_TO_CART = "//*[text()='%s']//ancestor::div" +
            "[@class='inventory_item']//child::*[text()='Add to cart']";

    private final By pageName = By.cssSelector(DATA_TEST_PATTERN.formatted("title"));
    private final By counter = By.cssSelector(DATA_TEST_PATTERN.formatted("shopping-cart-badge"));
    private final By cartLink = By.cssSelector(DATA_TEST_PATTERN.formatted("shopping-cart-link"));
    private final By addToCartBnt = By.xpath(TEXT_LOCATOR_PATTERN.formatted("Add to cart"));

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Step("Получение название страницы")
    public String getTitle() {
        return driver.findElement(pageName).getText();
    }

    @Step("Добавляем товар в корзину по имени")
    public void addToCart(final String goodsName) {
        By goods = By.xpath(ADD_TO_CART.formatted(goodsName));
        driver.findElement(goods).click();
    }

    @Step("Добавляем товар в корзину используя индукс")
    public void addToCart(int goodsIndex) {
        driver.findElements(addToCartBnt).get(goodsIndex).click();
    }

    @Step("Проверяем количество товаров в корзине - целое число")
    public int checkCounterValue() {
        return Integer.parseInt(driver.findElement(counter).getText());
    }

    public String checkCounterColor() {
        return driver.findElement(counter).getCssValue("background-color");
    }

    @Step("Переходим в корзину")
    public void switchToCart() {
        driver.findElement(cartLink).click();
    }
}

package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {
    final By inventoryItem = By.cssSelector(".inventory_item_name");
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Получение список названий товаров")
    public ArrayList<String> getProductsName() {
        List<WebElement> allProductsNames = driver.findElements
                (inventoryItem);
        ArrayList<String> names = new ArrayList<>();

        for (WebElement productBlock : allProductsNames) {
            names.add(productBlock.getText());
        }
        return names;
    }
}

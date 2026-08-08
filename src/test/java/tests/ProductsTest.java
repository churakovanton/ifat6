package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import java.util.List;
import static org.testng.Assert.assertEquals;
import static user.UserFactory.withAdminPermission;

@Epic("Интернет-магазин")
@Feature("Товары")
@Owner("Антон Чураков my@email.com")
public class ProductsTest extends BaseTest {
    List<String> goodsList =
            List.of("Sauce Labs Bolt T-Shirt",
                    "Sauce Labs Bike Light",
                    "Sauce Labs Fleece Jacket");

    @Story("Добавление товаров в корзину")
    @Test(description = "Проверка что товар(ы) добавлен в корзину")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("ifat6")
    @Issue("ifat6")
    public void checkGoodsAdded() {
        loginPage.open();
        loginPage.login(withAdminPermission());
        productPage.isOpen();
        productPage.addToCart(5);
        for (String goodName : goodsList) {
            productPage.addToCart(goodName);
        }
        assertEquals(productPage.checkCounterValue(), 4);
        assertEquals(productPage.checkCounterColor(), "rgb(226, 35, 26)");
    }
}

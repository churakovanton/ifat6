package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import java.util.List;
import static org.testng.Assert.*;
import static user.UserFactory.withAdminPermission;

@Epic("Интернет-магазин")
@Feature("Корзина")
@Owner("Антон Чураков my@email.com")
public class CartTest extends BaseTest {
    List<String> goodsList =
            List.of("Sauce Labs Bolt T-Shirt",
                    "Sauce Labs Bike Light",
                    "Sauce Labs Fleece Jacket");

    @Story("Добавление в корзину")
    @Test(description = "Проверека что товар добавлен в корзину")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("ifat6")
    @Issue("ifat6")
    public void checkGoodsAdded() {
        loginPage.open();
        loginPage.login(withAdminPermission());
        for (String goodName : goodsList) {
            productPage.addToCart(goodName);
        }
        productPage.switchToCart();
        assertFalse(cartPage.getProductsName().isEmpty());
        assertEquals(cartPage.getProductsName().size(), 3);
        assertTrue(cartPage.getProductsName().contains("Sauce Labs Bike Light"));
        assertEquals(cartPage.getProductsName(), goodsList);
    }
}

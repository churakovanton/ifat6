package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import java.util.List;
import static org.testng.Assert.*;
import static user.UserFactory.withAdminPermission;

@Epic("Интернет-магазин")
@Feature("Оформление заказа")
@Owner("Антон Чураков моя@почта.ру")
public class BasketTest extends BaseTest {
    List<String> goodsList = List.of(
            "Sauce Labs Bolt T-Shirt",
            "Sauce Labs Bike Light",
            "Sauce Labs Fleece Jacket");

    @Story("Успешное оформление заказа")
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка оформления заказа с 3-мя товарами")
    public void checkout() {
        loginPage.open();
        loginPage.login(withAdminPermission());
        assertEquals(
                productPage.getTitle(),
                "Products",
                "Name of the page doesn't correspond to the expected");

        for (String goodName : goodsList) {
            productPage.addToCart(goodName);
        }

        productPage.switchToCart();
        assertEquals(cartPage.getProductsName().size(), 3,
                "Кол-во товаров в корзине не соответствует фактическому");

        cartPage.clickCheckout();
        basketPage.fillCustomerInfo(
                "Anton",
                "Churakov",
                "426000");

        basketPage.clickContinueCheckOrder();
        assertEquals(overviewPage.getTotal(),
                "Total: $82.05",
                "Total doesn't correspond to the expected");

        overviewPage.clickFinish();
        assertTrue(completedPage.isOrderCompleted());
    }
}

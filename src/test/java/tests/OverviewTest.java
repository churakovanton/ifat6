package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import java.util.List;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.withAdminPermission;

@Epic("Интернет-магазин")
@Feature("Проверка корзины")
@Owner("Антон Чураков моя@почта.ру")
public class OverviewTest extends BaseTest {
    private final List<String> goodsList = List.of(
            "Sauce Labs Bolt T-Shirt",
            "Sauce Labs Bike Light",
            "Sauce Labs Fleece Jacket"
    );

    private void openOverview() {
        loginPage.open();
        loginPage.login(withAdminPermission());

        for (String goodsName : goodsList) {
            productPage.addToCart(goodsName);
        }
        productPage.switchToCart();
        cartPage.clickCheckout();
        basketPage.fillCustomerInfo(
                "Anton",
                "Churakov",
                "426000");
        basketPage.clickContinueCheckOrder();
    }

    @Test(priority = 1)
    @Story("Проверка страницы Overview")
    public void checkOverview() {
        openOverview();
        assertEquals(overviewPage.getTitle(),
                "Checkout: Overview");
        assertEquals(overviewPage.getTotal(),
                "Total: $82.05");
    }

    @Test(priority = 2)
    @Story("Успешное завершение заказа")
    public void checkFinish() {
        openOverview();
        overviewPage.clickFinish();
        assertTrue(completedPage.isOrderCompleted());
    }

    @Test(priority = 3)
    @Story("Отмена заказа")
    public void checkCancel() {
        openOverview();
        overviewPage.clickCancel();
        assertEquals(productPage.getTitle(),
                "Products");
    }
}

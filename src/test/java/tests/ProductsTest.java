package tests;

import org.testng.annotations.Test;
import java.util.List;
import static org.testng.Assert.assertEquals;
import static user.UserFactory.withAdminPermission;

public class ProductsTest extends BaseTest {
    List<String> goodsList =
            List.of("Sauce Labs Bolt T-Shirt",
                    "Sauce Labs Bike Light",
                    "Sauce Labs Fleece Jacket");

    @Test
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

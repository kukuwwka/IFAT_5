import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest {
    @Test
    public void checkGoodsAdded() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        productsPage.isPageLoaded();
        productsPage.addToCart("Test.allTheThings() T-Shirt (Red)");
        productsPage.addToCart("Sauce Labs Onesie");
        assertEquals(productsPage.checkGoodsQuantity(), "2");
       // assertEquals(productsPage.checkGoodsQuantityyy(), "egwe32weg");
    }
}

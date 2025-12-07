package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static user.UserFactory.withAdminPermission;

public class ProductsTest extends BaseTest {
    @Test
    public void checkGoodsAdded() {
        loginPage.open();
        loginPage.login(withAdminPermission());

        productsPage.isPageLoaded("Products");
        productsPage.addToCart("Test.allTheThings() T-Shirt (Red)");
        productsPage.addToCart("Sauce Labs Onesie");
        productsPage.addToCart("Sauce Labs Bolt T-Shirt");
        productsPage.addToCart(2);
        assertEquals(productsPage.checkGoodsQuantity(), "4");

//         assertEquals(productsPage.checkGoodsQuantityyy(), "egwe32weg");
    }
}
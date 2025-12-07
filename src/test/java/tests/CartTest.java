package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static user.UserFactory.withAdminPermission;

public class CartTest extends BaseTest {

    @Test
    public void checkGoodsInCart() {
        loginPage.open();
        loginPage.login(withAdminPermission());

        productsPage.isPageLoaded("Products");
        productsPage.addToCart("Test.allTheThings() T-Shirt (Red)");
        productsPage.addToCart("Sauce Labs Onesie");
        productsPage.addToCart("Sauce Labs Bolt T-Shirt");
//        loginPage.open("cart.html");
        productsPage.switchToCart();

        cartPage.isPageLoaded("Your Cart");
        assertEquals(cartPage.getProductNames().size(), 3);
        assertFalse(cartPage.getProductNames().isEmpty());
        assertTrue(cartPage.getProductNames().contains("Test.allTheThings() T-Shirt (Red)"));
    }
}
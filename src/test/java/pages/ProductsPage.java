package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    By pageTitle = By.xpath("//*[@data-test='title']");
    private static final String ADD_TO_CART_BUTTON_PATTERN =
            "//div[text()='%s']//ancestor::div[@class='inventory_item']//button";

    private static final String DATA_TEST_PATTERN =
            "[data-test='%s']";

    By cartBadge = By.xpath("//*[@data-test='shopping-cart-badge']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Добавляем товар в корзину")
    public void addToCart(final String goodsName) {
        //By addGoodsToCart = By.xpath(String.format(ADD_TO_CAR_BUTTON_PATTERN, "Sauce Labs Bike Light"));
        By addGoodsToCart = By.xpath(ADD_TO_CART_BUTTON_PATTERN.formatted(goodsName));
        driver.findElement(addGoodsToCart).click();
    }

    @Step("Добавляем товар в корзину по индексу")
    public void addToCart(final int goodsOrder) {
        driver.findElements(By.xpath(TEXT_LOCATOR_PATTERN.formatted("Add to cart"))).get(goodsOrder).click();
    }

    @Step("Возвращаем количество товаров в корзине")
    public String checkGoodsQuantity() {
        return driver.findElement(cartBadge).getText();
    }

    @Step("Открываем страницу корзины")
    public void switchToCart() {
        driver.findElement(cartBadge).click();
    }

}
/*    public String checkGoodsQuantityyy() {
        return driver.findElement(cartBadge).getDomAttribute("data-test");
    }*/
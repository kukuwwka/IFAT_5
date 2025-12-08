package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TitleName {
    PRODUCTS("Products"),
    CARTS("Your Cart"),
    CHECKOUT("Checkout: Your Information");

    private final String displayName;
}

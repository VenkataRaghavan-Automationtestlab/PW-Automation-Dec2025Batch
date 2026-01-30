package tests;

import base.BaseTest;
import pages.*;

public class PlaceOrderTest extends BaseTest {

    public static void main(String[] args) {

        PlaceOrderTest test = new PlaceOrderTest();
        test.setup();

        // Create Page Objects
        LoginPage loginPage = new LoginPage(test.page);
        ProductPage productPage = new ProductPage(test.page);
        CartPage cartPage = new CartPage(test.page);
        CheckoutPage checkoutPage = new CheckoutPage(test.page);

        // Test Flow
        loginPage.open();
        loginPage.login("admin", "admin123");

        productPage.addFirstProductToCart();
        productPage.goToCart();

        cartPage.clickCheckout();

        checkoutPage.enterPaymentDetails(
                "Ramesh",
                "1st Cross Street, Chennai",
                "1234 5647 4856 4656",
                "12/26",
                "123"
        );

        checkoutPage.payAndConfirm();

        String orderDetails = checkoutPage.getOrderDetails();
        System.out.println("Order Details:\n" + orderDetails);

        test.tearDown();
    }
}

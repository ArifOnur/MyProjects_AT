package Automation_Exercise.A2_AddCartPage;

import Automation_Exercise.Page;
import org.openqa.selenium.WebDriver;

public class CartPageLocators extends Page {

    public final String productsButton = "//a[@href='/products']";
    public final String continueShopping = "//button[text()='Continue Shopping']";
    public final String viewCartButton = "//u[text()='View Cart']";
    public final String verifyFistProduct = "(//td[@class='cart_product'])[1]";
    public final String verifySecondProduct = "(//td[@class='cart_product'])[2]";
    public final String priceFirstProduct = "Rs. 500";
    public final String priceSecondProduct = "Rs. 400";





    public CartPageLocators(WebDriver driver) {
        super(driver);
    }
}

package Automation_Exercise.CartPage;

import Automation_Exercise.Page;
import org.openqa.selenium.WebDriver;

public class CartPageLocators extends Page {

    public final String productsButton = "//a[@href='/products']";
    public final String continueShopping = "//button[text()='Continue Shopping']";
    public final String viewCartButton = "//u[text()='View Cart']";
    public final String verifyFistProduct = "(//td[@class='cart_product'])[1]";
    public final String verifySecondProduct = "(//td[@class='cart_product'])[2]";
    public final String priceFirstProductXpath = "Rs. 500";
    public final String priceSecondProductXpath = "Rs. 400";
    public final String cartButton = "(//a[@href='/view_cart'])[1]";
    public final String shoppingCart = "//li[text()='Shopping Cart']";
    public final String cartQuantityDeleteButton = "//a[@class='cart_quantity_delete']";
    public final String myCartDeleteMassage = "Cart is empty!";
    public final String womenCategory = "(//span[@class='badge pull-right'])[1]";
    public final String dress = "(//a[@href='/category_products/1'])[1]";
    public final String womenPage = "Automation Exercise - Dress Products";
    public final String menCategory = "(//span[@class='badge pull-right'])[2]";
    public final String tshirts = "//a[@href='/category_products/3']";
    public final String tshirtsTitle = "Automation Exercise - Tshirts Products";








    public CartPageLocators(WebDriver driver) {
        super(driver);
    }
}

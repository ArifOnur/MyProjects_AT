package Automation_Exercise.CartPage;

import Automation_Exercise.MainPage;
import Automation_Exercise.Page;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCase03_RemoveProductFromCart {

    private MainPage mainPage;
    private Page page;
    private CartPageLocators cartPageLocators;
    private WebDriver driver;
    private Actions actions;


    @BeforeEach
    void setUp(){


        driver = new ChromeDriver();
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
        actions = new Actions(driver);
        cartPageLocators = new CartPageLocators(driver);
        driver.get("https://automationexercise.com/");

    }

    @Test
    void RemoveProductsFromCartTest () throws InterruptedException {

        //Verify that home page is visible successfully
        mainPage.waitUntilTheElementAppear(mainPage.homePage);
        System.out.println("Actual Result 1: Verified that home page is visible successfully");

        //Click 'Products' button
        cartPageLocators.waitUntilTheElementAppear(cartPageLocators.productsButton);
        cartPageLocators.clickToTheElement(cartPageLocators.productsButton);

        //Add products to cart
        List<WebElement> viewProducts = driver.findElements(By.xpath("//div[@class='productinfo text-center']"));
        List<WebElement> addToCartButton = driver.findElements(By.xpath("//a[@class='btn btn-default add-to-cart']"));
        if (!addToCartButton.isEmpty()){
            actions.moveToElement(viewProducts.getFirst()).perform();
            addToCartButton.getFirst().click();
            System.out.println("Actual Result 2: Added to cart");
        }
        Thread.sleep(1500);

        //Click 'Continue Shopping' button
        cartPageLocators.waitUntilTheElementAppear(cartPageLocators.continueShopping);
        cartPageLocators.clickToTheElement(cartPageLocators.continueShopping);


        //Click 'Cart' button
        cartPageLocators.waitUntilTheElementAppear(cartPageLocators.cartButton);
        cartPageLocators.clickToTheElement(cartPageLocators.cartButton);


        //Verify that cart page is displayed
        cartPageLocators.waitUntilTheElementAppear(cartPageLocators.shoppingCart);

        //Click 'X' button corresponding to particular product
        cartPageLocators.waitUntilTheElementAppear(cartPageLocators.cartQuantityDeleteButton);
        cartPageLocators.clickToTheElement(cartPageLocators.cartQuantityDeleteButton);
        Thread.sleep(1500);

        //Verify that product is removed from the cart
        WebElement myCartDelete = driver.findElement(By.xpath("//b[text()='Cart is empty!']"));
        assertEquals(cartPageLocators.myCartDeleteMassage,myCartDelete.getText());
        System.out.println(myCartDelete.getText());

    }

    @AfterEach void tearDown (){

        driver.quit();


    }

}

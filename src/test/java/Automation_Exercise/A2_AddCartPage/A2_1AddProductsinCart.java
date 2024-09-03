package Automation_Exercise.A2_AddCartPage;

import Automation_Exercise.MainPage;
import Automation_Exercise.Page;
import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class A2_1AddProductsinCart {

    private MainPage mainPage;
    private Page page;
    private CartPageLocators cartPageLocators;
    private WebDriver driver;
    private Actions actions;



    @BeforeEach
    void setUp (){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
        actions = new Actions(driver);
        cartPageLocators = new CartPageLocators(driver);
        driver.get("https://automationexercise.com/");


    }

    @Test
    void AddProductsCart() throws InterruptedException {

        //Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));
        //assertTrue(homePage.isDisplayed());
        //System.out.println("Actual Result 1: Verified that home page is visible successfully");
        if (homePage.isDisplayed()){
            System.out.println("Actual Result 1: Verified that home page is visible successfully");
        }else {
            System.out.println("Home page is not visible");
        }

        //Click 'Products' button
        cartPageLocators.waitUntilTheElementAppear(cartPageLocators.productsButton);
        cartPageLocators.clickToTheElement(cartPageLocators.productsButton);

        //Hover over first product and click 'Add to cart'
        List<WebElement> viewProducts = driver.findElements(By.xpath("//div[@class='productinfo text-center']"));
        actions.moveToElement(viewProducts.getFirst()).perform();

        List<WebElement> addToCartButton = driver.findElements(By.xpath("//a[@class='btn btn-default add-to-cart']"));
        if (!addToCartButton.isEmpty()){
            addToCartButton.getFirst().click();
            System.out.println("Actual Result 2: Added to cart");
        }
        Thread.sleep(3000);

        //Click 'Continue Shopping' button
        cartPageLocators.waitUntilTheElementAppear(cartPageLocators.continueShopping);
        cartPageLocators.clickToTheElement(cartPageLocators.continueShopping);

        //Hover over second product and click 'Add to cart'
        if (!addToCartButton.isEmpty()){
            actions.moveToElement(viewProducts.get(1)).pause(1000).perform();
            addToCartButton.get(3).click();
            System.out.println("Actual Result 3: Second product added to cart");
        }
        Thread.sleep(1000);

        //Click 'View Cart' button
        cartPageLocators.waitUntilTheElementAppear(cartPageLocators.viewCartButton);
        cartPageLocators.clickToTheElement(cartPageLocators.viewCartButton);
        Thread.sleep(1000);

        //Verify both products are added to Cart
        cartPageLocators.waitUntilTheElementAppear(cartPageLocators.verifyFistProduct);
        cartPageLocators.waitUntilTheElementAppear(cartPageLocators.verifySecondProduct);
        System.out.println("Actual Result 4: Verified both products are added to Cart");

        //Verify their prices, quantity and total price
        WebElement priceFirstProduct = driver.findElement(By.xpath("(//p[text()='Rs. 500'])[1]"));
        System.out.println("Price : " + priceFirstProduct.getText());
        assertEquals(cartPageLocators.priceFirstProduct,priceFirstProduct.getText());

        WebElement priceSecondProduct = driver.findElement(By.xpath("(//p[text()='Rs. 400'])[1]"));
        System.out.println("Other Price  : " + priceSecondProduct.getText());
        assertEquals(cartPageLocators.priceSecondProduct,priceSecondProduct.getText());

        List<WebElement> quantities = driver.findElements(By.xpath("(//button[@class='disabled' and text()='1'])"));
        actions.moveToElement(quantities.get(1)).perform();

        WebElement totalPriceFirstProduct = driver.findElement(By.xpath("(//p[text()='Rs. 500'])[1]"));
        System.out.println("Total Price : " + totalPriceFirstProduct.getText());
        assertEquals(cartPageLocators.priceFirstProduct,totalPriceFirstProduct.getText());

        WebElement totalPriceSecondProduct = driver.findElement(By.xpath("(//p[text()='Rs. 400'])[1]"));
        System.out.println("Other Total Price  : " + totalPriceSecondProduct.getText());
        assertEquals(cartPageLocators.priceSecondProduct,totalPriceSecondProduct.getText());

    }



    @AfterEach
    void tearDown(){

        driver.quit();
    }



}

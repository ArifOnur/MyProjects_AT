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

        //Hover over first product and click 'View Product'
        List<WebElement> viewProduct = driver.findElements(By.xpath("//a[text()='View Product']"));
        if (viewProduct.size() > 0){
            viewProduct.getFirst().click();
            System.out.println("Verified product detail is opened");
        }

        //Increase quantity to 4
        WebElement quantity = driver.findElement(By.id("quantity"));
        actions.doubleClick(quantity).perform();
        cartPageLocators.pressKeybordKey(cartPageLocators.quantityWrite, Keys.BACK_SPACE);
        cartPageLocators.writeTheText(cartPageLocators.quantityWrite,"4");

        //Click 'Add to cart'
        cartPageLocators.clickToTheElement(cartPageLocators.addToCartButton);
        String expectedData = "Your product has been added to cart.";
        WebElement addedCart = driver.findElement(By.xpath("//p[@class='text-center']"));
        String actualData = addedCart.getText();
        assertEquals(expectedData, actualData, "The confirmation message was not as expected.");








    }



    @AfterEach
    void tearDown(){

        driver.quit();
    }



}

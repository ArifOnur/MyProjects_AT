package Automation_Exercise.ViewCategory;

import Automation_Exercise.CartPage.CartPageLocators;
import Automation_Exercise.MainPage;
import Automation_Exercise.Page;
import dev.failsafe.internal.util.Assert;
import org.checkerframework.dataflow.qual.AssertMethod;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestCase04_ViewCategoryProducts {


    private MainPage mainPage;
    private CartPageLocators cartPageLocators;
    private WebDriver driver;
    private JavascriptExecutor js;


    @BeforeEach
    void setUp(){


        driver = new ChromeDriver();
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
        actions = new Actions(driver);
        js = (JavascriptExecutor) driver;
        cartPageLocators = new CartPageLocators(driver);
        driver.get("https://automationexercise.com/");

    }

    @Test void ViewCategoryProducts () throws InterruptedException {

        //Verify that home page is visible successfully
        mainPage.waitUntilTheElementAppear(mainPage.homePage);
        System.out.println("Actual Result 1: Verified that home page is visible successfully");

        //Scroll down category
        WebElement category = driver.findElement(By.xpath("//div[@class='panel-group category-products']"));
        js.executeScript("arguments[0].scrollIntoView();", category);

        //Click on 'Women' category
        cartPageLocators.waitUntilTheElementAppear(cartPageLocators.womenCategory);
        cartPageLocators.clickToTheElement(cartPageLocators.womenCategory);
        Thread.sleep(3000);

        //Click on any category link under 'Women' category, for example: Dress
        cartPageLocators.waitUntilTheElementAppear(cartPageLocators.dress);
        cartPageLocators.clickToTheElement(cartPageLocators.dress);

        //Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
        Assertions.assertEquals(cartPageLocators.womenPage, driver.getTitle());
        System.out.println(driver.getTitle());

        //On left sidebar, click on any sub-category link of 'Men' category
        cartPageLocators.waitUntilTheElementAppear(cartPageLocators.menCategory);
        cartPageLocators.clickToTheElement(cartPageLocators.menCategory);
        Thread.sleep(1000);
        cartPageLocators.waitUntilTheElementAppear(cartPageLocators.tshirts);
        cartPageLocators.clickToTheElement(cartPageLocators.tshirts);

        //Verify that user is navigated to that category page
        Assertions.assertEquals(cartPageLocators.tshirtsTitle,driver.getTitle());
        System.out.println(driver.getTitle());


    }

    @AfterEach void tearDown (){

        driver.quit();


    }


}

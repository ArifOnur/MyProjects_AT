package Automation_Exercise.A1_Register_User;

import Automation_Exercise.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterUserTest {

    private MainPage mainPage;
    private Register_Page registerPage;
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void setUp(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
        registerPage = new Register_Page(driver);
        driver.get("https://automationexercise.com/");
    }

    @Test
    void RegisterUser() throws InterruptedException {


        mainPage.waitUntilTheElementAppear(mainPage.homePage);
        System.out.println("Actual Result 1: Verified that home page is visible successfully");

        mainPage.waitUntilTheElementAppear(mainPage.loginButton);
        mainPage.clickToTheElement(mainPage.loginButton);
        System.out.println("Actual Result 2: Verified 'New User Signup!' is visible");

        registerPage.waitUntilTheElementAppear(registerPage.singupName);
        registerPage.writeTheText(registerPage.singupName, "Onur");
        Thread.sleep(1000);
        registerPage.waitUntilTheElementAppear(registerPage.singupEmail);
        registerPage.writeTheText(registerPage.singupEmail, "onurtest@test1.com");
        System.out.println("Actual Result 3: Name and email address written successfully");

        registerPage.waitUntilTheElementAppear(registerPage.singupButton);
        registerPage.clickToTheElement(registerPage.singupButton);
        registerPage.waitUntilTheElementAppear(registerPage.titleEnterAccount);
        System.out.println("Actual Result 4: 'ENTER ACCOUNT INFORMATION' is visible");

        registerPage.radioSelect(registerPage.titleRadio);

        registerPage.waitUntilTheElementAppear(registerPage.password);
        registerPage.writeTheText(registerPage.password, "123Aoo");


        registerPage.clickToTheElement(registerPage.days);
        registerPage.waitUntilTheElementAppear(registerPage.daysValue);
        registerPage.writeTheText(registerPage.days, "15");


        registerPage.waitUntilTheElementAppear(registerPage.months);
        registerPage.clickToTheElement(registerPage.months);
        registerPage.selectValue(registerPage.months, "2");


        registerPage.waitUntilTheElementAppear(registerPage.year);
        registerPage.clickToTheElement(registerPage.year);
        registerPage.selectValue(registerPage.year, "1989");
        System.out.println("Actual Result 5: Filled details: Title, Name, Email, Password, Date of birth");

        registerPage.waitUntilTheElementAppear(registerPage.checkboxNewsletter);
        registerPage.clickToTheElement(registerPage.checkboxNewsletter);
        System.out.println("Actual Result 6: Selected checkbox 'Sign up for our newsletter!'");

        registerPage.waitUntilTheElementAppear(registerPage.checkboxOptin);
        registerPage.clickToTheElement(registerPage.checkboxOptin);
        System.out.println("Actual Result 7: Selected checkbox 'Receive special offers from our partners!'");

        registerPage.waitUntilTheElementAppear(registerPage.firstName);
        registerPage.writeTheText(registerPage.firstName, "Arif");
        registerPage.waitUntilTheElementAppear(registerPage.lastName);
        registerPage.writeTheText(registerPage.lastName, "Onhan");
        registerPage.waitUntilTheElementAppear(registerPage.company);
        registerPage.writeTheText(registerPage.company, "Test Company");
        registerPage.waitUntilTheElementAppear(registerPage.adress1);
        registerPage.writeTheText(registerPage.adress1, "Çankaya, Test Street, Box:1");
        registerPage.waitUntilTheElementAppear(registerPage.countryCombobox);
        registerPage.selectValue(registerPage.countryCombobox, "United States");
        registerPage.waitUntilTheElementAppear(registerPage.state);
        registerPage.writeTheText(registerPage.state, "Test");
        registerPage.waitUntilTheElementAppear(registerPage.city);
        registerPage.writeTheText(registerPage.city, "Test");
        registerPage.waitUntilTheElementAppear(registerPage.zipcode);
        registerPage.writeTheText(registerPage.zipcode, "12345");
        registerPage.waitUntilTheElementAppear(registerPage.mobileNumber);
        registerPage.writeTheText(registerPage.mobileNumber, "5331234568");
        System.out.println("Actual Result 8: Filled details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number");


        registerPage.waitUntilTheElementAppear(registerPage.createAccountButton);
        registerPage.clickToTheElement(registerPage.createAccountButton);
        registerPage.waitUntilTheElementAppear(registerPage.accountCreated);
        System.out.println("Actual Result 9: Verified that 'ACCOUNT CREATED!' is visible");

        registerPage.waitUntilTheElementAppear(registerPage.continueButton);
        registerPage.clickToTheElement(registerPage.continueButton);
        registerPage.waitUntilTheElementAppear(registerPage.loggedIn);
        System.out.println("Actual Result 10: Verified that 'Logged in as username' is visible");

        registerPage.clickToTheElement(registerPage.deleteAccount);
        registerPage.waitUntilTheElementAppear(registerPage.accountDeleted);
        registerPage.clickToTheElement(registerPage.continueButton);
        mainPage.waitUntilTheElementAppear(mainPage.homePage);
        System.out.println("Actual Result 11: Verified that 'ACCOUNT DELETED!' is visible and clicked 'Continue' button");
    }

    @AfterEach
    void tearDown(){

        driver.quit();
    }



}

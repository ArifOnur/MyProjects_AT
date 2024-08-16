package Automation_Exercise.Register_User;

import Automation_Exercise.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.layertree.model.StickyPositionConstraint;

public class Register_Page extends Page {

    public final String singupName = "//input[@type='text']";
    public final String singupEmail = "//input[@data-qa='signup-email']";
    public final String singupButton = "//button[@data-qa='signup-button']";
    public final String titleEnterAccount = "//h2//b[text()='Enter Account Information']";
    public final String titleRadio = "//input[@type='radio']";
    public final String password = "//input[@id='password']";
    public final String days = "//select[@id='days']";
    public final String daysValue = "//select[@id='days']//option";
    public final String months = "//select[@id='months']";
    public final String year = "//select[@id='years']";
    public final String checkboxNewsletter = "//input[@id='newsletter']";
    public final String checkboxOptin = "//input[@id='optin']";
    public final String firstName = "//input[@id='first_name']";
    public final String lastName = "//input[@id='last_name']";
    public final String company = "//input[@id='company']";
    public final String adress1 = "//input[@id='address1']";
    public final String countryCombobox = "//select[@id='country']";
    public final String state = "//input[@id='state']";
    public final String city = "//input[@id='city']";
    public final String zipcode = "//input[@id='zipcode']";
    public final String mobileNumber = "//input[@id='mobile_number']";
    public final String createAccountButton = "//button[text()='Create Account']";
    public final String accountCreated = "//b[contains(text(), 'Account Created!')]";
    public final String continueButton = "//a[@class='btn btn-primary']";
    public final String loggedIn = "//b[contains(text(), 'Onur')]";
    public final String deleteAccount = "//a[contains(text(), 'Delete Account')]";
    public final String accountDeleted = "//b[contains(text(), 'Account Deleted!')]";









    public Register_Page(WebDriver driver) {
        super(driver);
    }
}

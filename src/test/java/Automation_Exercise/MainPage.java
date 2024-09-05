package Automation_Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends Page{

public final String homePage="//img[@alt='Website for automation practice']";
public final String loginButton="//a[@href='/login']";




    public MainPage(WebDriver driver) {
        super(driver);
    }
}

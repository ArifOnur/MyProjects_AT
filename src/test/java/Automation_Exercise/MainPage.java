package Automation_Exercise;

import org.openqa.selenium.WebDriver;

public class MainPage extends Page{

public final String homePage="//img[@alt='Website for automation practice']";
public final String loginButton="//a[@href='/login']";






    public MainPage(WebDriver driver) {
        super(driver);
    }
}

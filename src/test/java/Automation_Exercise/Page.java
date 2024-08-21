package Automation_Exercise;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Page {

    WebDriver driver;

    public Page(WebDriver driver){
        this.driver = driver;

    }

    public void waitUntilTheElementAppear(String elementXpath){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20L));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath)));

    }

    public void clickToTheElement(String elementXpath){

        driver.findElement(By.xpath(elementXpath)).click();

    }

    public void writeTheText(String elementXpath, String text){

        driver.findElement(By.xpath(elementXpath)).sendKeys(text);

    }

    public void selectValue(String elementXpath, String value){

        Select select = new Select(driver.findElement(By.xpath(elementXpath)));
        select.selectByValue(value);

    }

    public void pressKeybordKey(String elementXpath, Keys keybordKey){

        driver.findElement(By.xpath(elementXpath)).sendKeys(keybordKey);

    }

    public void radioSelect(String elementXpath){

        WebElement radioElement = driver.findElement(By.xpath(elementXpath));
        boolean selectState = radioElement.isSelected();

        if (selectState == false){

            radioElement.click();
            System.out.println("Radio selected");

        }

    }
    public void checkboxSelect(String elementXpath) {
        WebElement checkbox = driver.findElement(By.xpath(elementXpath));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }

    }






}

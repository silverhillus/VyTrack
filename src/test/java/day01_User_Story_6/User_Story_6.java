package day01_User_Story_6;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class User_Story_6 extends TestBase {

    @Test(priority = 1)
    public void vehicleCostsPage(){

        WebElement fleetModule = driver.findElement(By.xpath("//span[@class='title title-level-1' and contains (text(),'Fleet')]"));
/*
        String actualDropdown = fleetModule.getText();
        String expectedDropdown = "Fleet";
        Assert.assertEquals(actualDropdown, expectedDropdown);
 */
        Actions action = new Actions(driver);
        action.moveToElement(fleetModule);
        action.perform();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        WebElement vehicleCostModule = driver.findElement(By.xpath("//*[text()='Vehicle Costs']"));
        vehicleCostModule.click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }









}

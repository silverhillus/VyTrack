package day01;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;
import utilities.Driver;
import utilities.ConfigurationReader;

import java.util.concurrent.TransferQueue;

public class UserStory_3 {
    WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        driver = Driver.getDriver();
        driver.get(ConfigurationReader.getProperty("url"));
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }
    @Test
    public void UserStory3_testcase_89_step1(){
        //Step1:Go to login page.
        //Expected result: System should display login page.
        String currentTitle = driver.getTitle();
        String expectedTitle = "Login";
        Assert.assertTrue(currentTitle.equals(expectedTitle),"step1");
    }
    @Test
    public void UserStory3_testcase_89_step2() throws InterruptedException {
        //Step2:Enter valid Truck Driver credentials and click Log In button.
        //Expected result: System should display Fleet Management Dashboard page.
        WebElement username = driver.findElement(By.id("prependedInput"));
        username.sendKeys(ConfigurationReader.getProperty("username_truckDriver"));
        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys(ConfigurationReader.getProperty("password"));
        WebElement logIn = driver.findElement(By.id("_submit"));
        logIn.click();
        Thread.sleep(3000);
        String currentTitle = driver.getTitle();
        String expectedTitle = "Dashboard";
        Assert.assertTrue(expectedTitle.equals(currentTitle),"step2");
    }
    @Test
    public void UserStory3_testcase_89_step3() throws InterruptedException {
        //Step3:Hover over Fleet module.
        //Expected result: System should display Fleet module's drop-down menu.
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        WebElement fleetModule = driver.findElement(By.xpath("//span[@class='title title-level-1' and contains(text(),'Fleet')]"));
        actions.moveToElement(fleetModule).perform();
        Thread.sleep(1000);
        WebElement VehicleOdometer = driver.findElement(By.xpath("//span[.='Vehicle Odometer']"));
        Assert.assertTrue(VehicleOdometer.isDisplayed(),"step3");
    }
    @Test
    public void UserStory3_testcase_89_step4() throws InterruptedException {
        //Step4:Click on "Vehicles Odometers" button
        //Expected result: System should display All Vehicles Odometers on the page.
        WebElement VehicleOdometerModule = driver.findElement(By.xpath("//span[.='Vehicle Odometer']"));
        VehicleOdometerModule.click();
        Thread.sleep(3000);
        String currentTitle = driver.getTitle();
        String expectedTitle = "Vehicle Odometer - Entities - System - Car - Entities - System";
        Assert.assertTrue(currentTitle.equals(expectedTitle),"step4");
    }
    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }
}












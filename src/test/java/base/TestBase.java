package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver driver;

    @BeforeClass
    public void setUp(){
        //WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver","C:\\Users\\__{{ KoxaL }}__\\IdeaProjects\\seleniumprojectb18\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa2.vytrack.com/user/login");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        login();
    }

    @AfterClass
    public void tearDown() throws InterruptedException{

        Thread.sleep(5000);
        driver.close(); // to close the chrome driver
        // driver.quit();  //  to quit from the tab
    }

    private void login(){

        WebElement username = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        username.sendKeys(ConfigurationReader.getProprty("username"));

        WebElement password = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        password.sendKeys(ConfigurationReader.getProprty("password"));

        WebElement loginButton = driver.findElement(By.xpath("//button[@id='_submit']"));
        loginButton.click();

    }

}

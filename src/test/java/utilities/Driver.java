package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;

public class Driver {
    private Driver(){

    }

    private static WebDriver driver;

    public static WebDriver getDriver(){

        if ( driver == null ){
            String browser = ConfigurationReader.getProprty("browser");
            switch (browser){
                case "chrome":
                    System.setProperty("webdriver.chrome.driver","C:\\Users\\__{{ KoxaL }}__\\IdeaProjects\\seleniumprojectb18\\chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
            }
        }

        driver.manage().window().maximize();

        return driver;
    }

    public void closeDriver(){
        if(driver != null){
            driver.close();
            driver = null;
        }
    }

}

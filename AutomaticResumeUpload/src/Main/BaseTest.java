package Main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.logging.Logger;


public class BaseTest {

    protected ChromeDriver driver;
    public Logger logger;
    public String driverPath="C:\\Users\\ankit.deshmukh\\Downloads\\chromedriver_win32\\chromedriver.exe";

    @BeforeTest
    public void Setup(){
        System.setProperty("webdriver.chrome.driver",driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void Quit(){
        driver.quit();
    }

}

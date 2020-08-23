package Test;

import Main.TestUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.logging.Logger;


public class NaukriProfile extends TestUtilities {


    public String urlPath="https://www.naukri.com/nlogin/login";
    By NaukriUsername= By.id("usernameField");
    By NaukriPassword=By.id("passwordField");
    By NaukriSubmitBtn = By.xpath("//button[@type='submit']");
    By UpdateResumeBtn = By.xpath("//a[text()='Update']");
    By AttachCVBtn = By.id("attachCV");

    @Test
    public void UploadResume() throws IOException {

        logger = Logger.getLogger(logger.GLOBAL_LOGGER_NAME);

        GetUrl(urlPath);
        logger.info("Entering Username...");
        WebElement username= FindElement(NaukriUsername);
        username.click();
        username.sendKeys(readData(1,0));

        logger.info("Entering Password");
        WebElement password = FindElement(NaukriPassword);
        password.click();
        password.sendKeys(readData(1,1));

        Click(NaukriSubmitBtn);
        logger.info("Login Successful...");
        Sleep(2000);

        driver.findElementByXPath("//div[@class='user-name roboto-bold-text']").click();

        Sleep(2000);

        //Attaching Resume
        logger.info("Attaching Resume...");
        Click(UpdateResumeBtn);
        WebElement uploadelement= FindElement(AttachCVBtn);
        //uploadelement.click();
        uploadelement.sendKeys(readData(1,8));
        logger.info("Resume Attached...");
        Sleep(3000);

    }
}

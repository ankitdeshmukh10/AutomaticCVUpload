package Test;

import Main.TestUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.logging.Logger;

public class ShineProfile extends TestUtilities {

    public String urlPath = "https://www.shine.com/myshine/login/";
    By ShineUsername = By.name("email");
    By ShinePassword = By.name("password");
    By LoginBtn = By.id("btn_login");
    By MyprofileBtn = By.xpath("//a[@href='/myshine/myprofile/']");
    By UploadResumeBtn = By.xpath("//div[@class='additional2 cls_editlink']");
    By BrowseFileBtn = By.id("id_file");
    By SubmitBtn = By.xpath("//input[@type='submit']");

    @Test
    public void UploadResume() throws IOException {

        logger = Logger.getLogger(logger.GLOBAL_LOGGER_NAME);

        GetUrl(urlPath);

        logger.info("Entering Username...");
        WebElement username = FindElement(ShineUsername);
        username.click();
        username.sendKeys(readData(1,6));

        logger.info("Entering Password...");
        WebElement password = FindElement(ShinePassword);
        password.click();
        password.sendKeys(readData(1,7));

        Click(LoginBtn);
        logger.info("Login Successful...");
        Sleep(2000);

        Click(MyprofileBtn);
        Sleep(3000);
        Click(UploadResumeBtn);

        logger.info("Attaching Resume...");
        WebElement browseFileBtn = FindElement(BrowseFileBtn);
        browseFileBtn.sendKeys(readData(1,8));
        logger.info("Resume Attached...");
        Sleep(1000);

        Click(SubmitBtn);

        Sleep(5000);

    }
}

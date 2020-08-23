package Test;

import Main.TestUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.logging.Logger;

public class MonstersIndiaProfile extends TestUtilities {

    public String urlPath = "https://www.monsterindia.com/rio/login";
    By MonsterUsername = By.id("signInName");
    By MonsterPassword = By.id("password");
    By LoginBtn = By.id("signInbtn");
    By UpdateProfileBtn = By.xpath("//a[@class='line-btn btn-update-profile w100 text-center']");
    By Uploadlogo = By.xpath("//i[@class='mqfi-upload']");
    By FileUpload = By.id("resume");
    By SaveBtn = By.xpath("(//button[@class='btn wt-100 pt10 pb10 no-radius'])[2]");

    @Test
    public void UploadResume() throws IOException {

        logger = Logger.getLogger(logger.GLOBAL_LOGGER_NAME);

        GetUrl(urlPath);

        logger.info("Entering Username...");
        WebElement username = FindElement(MonsterUsername);
        username.click();
        username.sendKeys(readData(1,4));

        logger.info("Entering Password");
        WebElement password = FindElement(MonsterPassword);
        password.click();
        password.sendKeys(readData(1,5));

        Click(LoginBtn);
        logger.info("Login Successful...");
        Sleep(6000);

        Click(UpdateProfileBtn);
        Sleep(3000);

        Click(Uploadlogo);
        logger.info("Attaching Resume...");
        Sleep(3000);

        WebElement fileUpload = FindElement(FileUpload);
        fileUpload.sendKeys(readData(1,8));
        logger.info("Resume Attached...");
        Click(SaveBtn);
        Sleep(5000);

    }
}

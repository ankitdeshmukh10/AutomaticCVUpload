package Main;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TestUtilities extends BaseTest{

    protected String FilePath = "C:\\Users\\ankit.deshmukh\\IdeaProjects\\AutomaticResumeUpload\\Data.xlsx";

    public void GetUrl(String url){
        driver.get(url);
    }

    public WebElement FindElement(By locator){
        return driver.findElement(locator);
    }

    public void Click(By locator){
        driver.findElement(locator).click();
    }


    public String readData( int rownum, int colnum) throws IOException {

        //Create an object of File class to open xlsx file
        File file =    new File(FilePath);

        //Create an object of FileInputStream class to read excel file
        FileInputStream fs = new FileInputStream(file);

        //If it is xlsx file then create object of XSSFWorkbook class
        Workbook wb = new XSSFWorkbook(fs);

        //Read sheet inside the workbook by its name
        Sheet sheet = wb.getSheet("Sheet1");

        Row row = sheet.getRow(rownum);

        //System.out.println(rownum+" "+colnum+" "+row.getCell(colnum).getStringCellValue());

        return row.getCell(colnum).getStringCellValue();


    }

    public void Sleep(int n){

        try{
            Thread.sleep(n);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

}

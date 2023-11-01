import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;

public class BaseTest {
//    @DataProvider(name="LoginData")
//    public Object[][] getDataFromDataProvider() {
//        return new Object[][]{
//                {"demo@class.com", "te$t$tudent"},
//                {"invalidemail@class.com", "te$t$tudent"},
//                {"demo@class.com", "InvalidPassword"},
//                {"", ""}
//        };
//    }

//    @DataProvider(name="excelData")
//    public Object[][] excelDP() throws IOException{
//        Object[][] arrObj = getExcelData("LocationFile","Name of the File");
//        return arrObj;
//    }
    public WebDriver driver = null;
    public String url = "https://qa.koel.app/";
    public String loggedInURL = "https://qa.koel.app/#!/home";
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser (String BaseURL) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        url = BaseURL;
        navigateToLoginPage();
    }
    public void navigateToLoginPage(){
        String url = "https://qa.koel.app/";
        driver.get(url);
    }
    public void provideEmail(String email){
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }
    public void providePassword(String password){
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void clickSubmit() {
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

//    public String[][] getExcelData(String fileName, String sheetName){
//       String[][] data = null;
//       try{
//           FileInputStream fileInputStream = new FileInputStream(fileName);
//           XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
//           XSSFSheet sheet = workbook.getSheet(sheetName);
//           XSSFRow row = sheet.getRow(0);
//
//           int numOfRows = sheet.getPhysicalNumberOfRows();
//           int numOfColumns = row.getLastCellNum();
//
//           XSSFCell cell;
//
//           data = new String[numOfRows-1][numOfColumns];
//
//           for(int i = 1; i < numOfRows; i++){
//               for(int j=0; j < numOfColumns; j++){
//                   row = sheet.getRow(i);
//                   cell = row.getCell(j);
//                   data[i-1][j]=cell.getStringCellValue();
//               }
//           }
//       }
//       catch (Exception e) {
//           System.out.println("Something went wrong."+e);
//       }
//       return data;
//    }
}
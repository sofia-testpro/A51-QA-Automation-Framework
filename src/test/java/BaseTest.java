import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.jcajce.BCLoadStoreParameter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;

public class BaseTest {
    //data providers start here
    @DataProvider(name="LoginData")
    public Object[][] getDataFromDataProvider() {
        return new Object[][]{
                {"demo@class.com", "te$t$tudent"},
                {"invalidemail@class.com", "te$t$tudent"},
                {"demo@class.com", "InvalidPassword"},
                {"", ""}
        };
    }
    @DataProvider(name="excelData")
    public Object[][] excelDP() throws IOException{
        Object[][] arrObj = getExcelData("LocationFile","Name of the File");
        return arrObj;
    }
    // data provider end here


    // references start here
    public static WebDriver driver = null;
    public static String url = "http://qa.koel.app/";
    public static String loggedInURL = "https://qa.koel.app/#!/home";
    public static WebDriverWait wait;
    public static Actions actions;
    //references end here



    @BeforeSuite
    static void setupClass() {
        // WebDriverManager.chromedriver().setup();
        // WebDriverManager.firefoxdriver().setup();
        // WebDriverManager.safaridriver().setup();
    }
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser (String BaseURL) throws MalformedURLException {
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow-origins=*");
        //driver = new ChromeDriver(options);
        driver = pickBrowser(System.getProperty("browser"));
        //driver = new FirefoxDriver();
        //driver = new SafariDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        actions = new Actions(driver);
        driver.manage().window().maximize();
        url = BaseURL;
        navigateToLoginPage();
    }

    public static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL ="http:/http://192.168.1.90:4444/";

        switch (browser){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();

            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver(edgeOptions);

            case"grid-edge": // gradle clean test -Dbrowser=grid-edge
                    caps.setCapability("browser","MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);

            case"grid-firefox": // gradle clean test -Dbrowser=firefox
                caps.setCapability("browserName","firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);

            case"grid-chrome": // gradle clean test -Dbrowser=chrome
                caps.setCapability("browserName","chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);

            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(options);
        }

    }
    public void navigateToLoginPage(){
        String url = "https://qa.koel.app/";
        driver.get(url);
    }
    public void provideEmail(String email){
        //WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);
    }
    public void providePassword(String password){
        //WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void clickSubmit() {
        //WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        submit.click();
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    public String[][] getExcelData(String fileName, String sheetName){
       String[][] data = null;
       try{
           FileInputStream fileInputStream = new FileInputStream(fileName);
           XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
           XSSFSheet sheet = workbook.getSheet(sheetName);
           XSSFRow row = sheet.getRow(0);

           int numOfRows = sheet.getPhysicalNumberOfRows();
           int numOfColumns = row.getLastCellNum();

           XSSFCell cell;

           data = new String[numOfRows-1][numOfColumns];

           for(int i = 1; i < numOfRows; i++){
               for(int j=0; j < numOfColumns; j++){
                   row = sheet.getRow(i);
                   cell = row.getCell(j);
                   data[i-1][j]=cell.getStringCellValue();
               }
           }
       }
       catch (Exception e) {
           System.out.println("Something went wrong."+e);
       }
       return data;
    }

}
import com.sun.jdi.request.DuplicateRequestException;
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
import java.net.URL;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;

import static java.sql.DriverManager.getDriver;

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
    // data provider end here


    // references start here
    public static WebDriver driver = null;
    public static String url = "https://qa.koel.app/";
    public static String loggedInURL = "https://qa.koel.app/#!/home";
    public static WebDriverWait wait;
    public static Actions actions;

    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    //references end here



    @BeforeSuite
    static void setupClass() {
        // WebDriverManager.chromedriver().setup();
        // WebDriverManager.firefoxdriver().setup();
        // WebDriverManager.safaridriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void setupBrowser(String BaseURL) throws MalformedURLException {
        threadDriver.set(pickBrowser(System.getProperty("browser")));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        navigateToLoginPage(BaseURL);
    }
    public static WebDriver getDriver(){
        return threadDriver.get();
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
        navigateToLoginPage(BaseURL);
    }

    public WebDriver pickBrowser(String browser) throws MalformedURLException {
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

            case "cloud":
                return lambdaTest();

            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(options);
        }

    }
    public void navigateToLoginPage(){
        driver.get(url);
    }
    public void navigateToLoginPage(String BaseURL){
        driver.get(BaseURL);
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

    public WebDriver lambdaTest() throws MalformedURLException {
        String username = "lolitamantsiuk";
        String authKey = "lbML3dcaXJBvJIy9SbPQ6K0K2AdvgIlecTl2FHkzwBXwreEVsh";
        String hub ="@hub.lambdatest.com/wd/hub";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform","macOS Monterey 12.3.1");
        caps.setCapability("browserName","Chrome 119");
        caps.setCapability("resolution","12024x76");
        caps.setCapability("build","TestNG with Java");
        caps.setCapability("name",this.getClass().getName());
        caps.setCapability("plugin","java-testNG");

        return new RemoteWebDriver(new URL("https://" +username+ ":" +authKey+ hub), caps);
    }
    @AfterMethod
   public void closeBrowser(){
        driver.quit();
    }

//    @AfterMethod
//    public void tearDown(){
//        threadDriver.get().close();
//        threadDriver.remove();
//    }


}
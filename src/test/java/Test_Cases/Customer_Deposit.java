package Test_Cases;
import Base_Class.Base_Class;
import Test_Data.import_excel;
import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Customer_Deposit extends Base_Class{
    //Config Extent Report
    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("Reports/Customer_Deposit_Report.html");  // Report location
    //Extent Report config

    public WebDriver driver = new ChromeDriver();
    @BeforeTest
    public void Open_Browser(){
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();

        // config extent report
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Customer_Deposit_Report");
        extent.attachReporter(spark);
        // config extent report
    }

    @Test(dataProvider ="test_data" , priority=0)
    public void Deposit_With_Zero(String First_Name,String Last_Name,String Post_Code) throws IOException {

        // config extent report
        ExtentTest test = extent.createTest("Deposit_With_Zero");
        test.info("open website");
        test.info("click on customer login button");
        test.info("select user then login");
        test.info("choose deposit option");
        test.info("enter amount then submit");
        test.info("expected result = user see message like 'amount can not be zero'");
        test.info("actual result = nothing happen");
        test.fail("test is failed");
        // config extent report

        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login"); // open website
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));   // implicit wait
        driver.findElement(Customer_Login_Btn).click(); // click on customer login btn
        Select s1 = new Select(driver.findElement(User_Select_Box));   // select box "choosing user"
        s1.selectByVisibleText("Ron Weasly"); // select the user
        driver.findElement(Login_Btn).click(); // click on login btn
        driver.findElement(Deposit_Option).click();  // click on deposit option
        driver.findElement(Amount).sendKeys("0"); // enter amount
        driver.findElement(Submit).click();  // click on deposit btn to submit

        // take screenshot
        WebElement my_element = driver.findElement(By.xpath("/html/body/div/div"));
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
                .coordsProvider(new WebDriverCoordsProvider())
                .takeScreenshot(driver,my_element);
        ImageIO.write(screenshot.getImage(), "jpg", new File(("./Screenshots/Deposit_With_Zero.jpg")));
        // take screenshot

        //Assertion
        String Error_Message = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/label")).getText();
        Assert.assertEquals( Error_Message , "amount can not be zero " );
        //Assertion
    }

    @Test(dataProvider ="test_data" , priority=1)
    public void Deposit_With_Negative_Amount(String First_Name, String Last_Name, String Post_Code) throws IOException {

        // config extent report
        ExtentTest test = extent.createTest("Deposit_With_Negative_Amount");
        test.info("open website");
        test.info("click on customer login button");
        test.info("select user then login");
        test.info("choose deposit option");
        test.info("enter amount then submit");
        test.info("expected result = user see message like 'amount can not be negative'");
        test.info("actual result = nothing happen");
        test.fail("test is failed");
        // config extent report

        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login"); // open website
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));   // implicit wait
        driver.findElement(Customer_Login_Btn).click(); // click on customer login btn
        Select s1 = new Select(driver.findElement(User_Select_Box));   // select box "choosing user"
        s1.selectByVisibleText("Ron Weasly"); // select the user
        driver.findElement(Login_Btn).click(); // click on login btn
        driver.findElement(Deposit_Option).click();  // click on deposit option
        driver.findElement(Amount).sendKeys("-100"); // enter amount
        driver.findElement(Submit).click();  // click on deposit btn to submit

        // take screenshot
        WebElement my_element = driver.findElement(By.xpath("/html/body/div/div"));
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
                .coordsProvider(new WebDriverCoordsProvider())
                .takeScreenshot(driver,my_element);
        ImageIO.write(screenshot.getImage(), "jpg", new File(("./Screenshots/Deposit_With_Negative_Amount.jpg")));
        // take screenshot

        //Assertion
        String Error_Message = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/label")).getText();
        Assert.assertEquals( Error_Message , "amount can not be negative " );
        //Assertion
    }

    @Test(dataProvider ="test_data" , priority=2)
    public void Deposit_With_Positive_Amount(String First_Name, String Last_Name, String Post_Code) throws IOException {

        // config extent report
        ExtentTest test = extent.createTest("Deposit_With_Positive_Amount");
        test.info("open website");
        test.info("click on customer login button");
        test.info("select user then login");
        test.info("choose deposit option");
        test.info("enter amount then submit");
        test.info("expected result = user see message = 'Deposit Successful'");
        test.info("actual result = expected result");
        test.pass("test is passed");
        // config extent report

        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login"); // open website
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));   // implicit wait
        driver.findElement(Customer_Login_Btn).click(); // click on customer login btn
        Select s1 = new Select(driver.findElement(User_Select_Box));   // select box "choosing user"
        s1.selectByVisibleText("Ron Weasly"); // select the user
        driver.findElement(Login_Btn).click(); // click on login btn
        driver.findElement(Deposit_Option).click();  // click on deposit option
        driver.findElement(Amount).sendKeys("140"); // enter amount
        driver.findElement(Submit).click();  // click on deposit btn to submit

        //Assertion
        String Message_After_Submit = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/span")).getText();
        Assert.assertEquals( Message_After_Submit , "Deposit Successful" );
        //Assertion
    }

    @AfterTest
    public void Close_Browser(){
        extent.flush(); // will erase all data on the report
        driver.quit();
    }

    @DataProvider
    public Object[][]test_data() throws Exception {
        import_excel obj = new import_excel();  // create object  from excelsheet function
        return obj.data_import();   // return object from the inside function
    }

}


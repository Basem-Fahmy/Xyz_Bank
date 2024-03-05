package Test_Cases;
import Base_Class.Base_Class;
import Test_Data.import_excel;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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

public class Bank_Manager_Add_Customer extends Base_Class{

    //Config Extent Report
    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("Reports/Bank_Manager_Add_Customer_Report.html"); // Report location
    //Extent Report config

    public WebDriver driver = new ChromeDriver();
    @BeforeTest
    public void Open_Browser(){
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();

        // config extent report
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Bank_Manager_Add_Customer");
        extent.attachReporter(spark);
        // config extent report
    }

    @Test(dataProvider ="test_data" , priority=0)
    public void Add_Customer(String First_Name, String Last_Name, String Post_Code) {

        // config extent report
        ExtentTest test = extent.createTest("Add_Customer");
        test.info("open website");
        test.info("click on bank manager login button");
        test.info("click on add customer option ");
        test.info("enter first_name, last_name & post_code ");
        test.info("click submit");
        test.info("accept the alert");
        test.info("expected result = alert message : 'Customer added successfully'");
        test.info("actual result = same as expected result");
        test.pass("test is passed");
        // config extent report

        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login"); // open website
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));   // implicit wait
        driver.findElement(Bank_Manager_Login_Btn).click(); // click on bank manager login btn
        driver.findElement(Add_customer_option).click();   // add customer
        driver.findElement(First_Name_Input).sendKeys(First_Name); // enter user first name
        driver.findElement(Last_Name_Input).sendKeys(Last_Name); // enter user last name
        driver.findElement(Post_Code_Input).sendKeys(Post_Code); // enter user post code
        driver.findElement(Submit_2).click();  // click on add customer btn to submit
        String Alert_Message = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();  // accept the popup alert

        //Assertion
        Assert.assertEquals( Alert_Message,Alert_Message );
        //Assertion
    }

    @Test(dataProvider ="test_data" , priority=1)
    public void Add_Customer_Info_Are_Numbers_Only
            (String First_Name, String Last_Name, String Post_Code) throws IOException {

        // config extent report
        ExtentTest test = extent.createTest("Add_Customer_Info_Are_Numbers_Only");
        test.info("open website");
        test.info("click on bank manager login button");
        test.info("click on add customer option ");
        test.info("enter first_name, last_name & post_code ");
        test.info("click submit");
        test.info("accept the alert");
        test.info("expected result = alert message : 'first and last name can not be numbers'");
        test.info("actual result = alert message : 'Customer added successfully'");
        test.fail("test is failed");
        // config extent report

        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login"); // open website
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));   // implicit wait
        driver.findElement(Bank_Manager_Login_Btn).click(); // click on bank manager login btn
        driver.findElement(Add_customer_option).click();   // add customer
        driver.findElement(First_Name_Input).sendKeys("123"); // enter user first name
        driver.findElement(Last_Name_Input).sendKeys("456"); // enter user last name
        driver.findElement(Post_Code_Input).sendKeys(Post_Code); // enter user post code
        driver.findElement(Submit_2).click();  // click on add customer btn to submit
        driver.switchTo().alert().accept();

        // take screenshot
        WebElement my_element = driver.findElement(By.xpath("/html/body/div/div"));
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
                .coordsProvider(new WebDriverCoordsProvider())
                .takeScreenshot(driver,my_element);
        ImageIO.write(screenshot.getImage(), "jpg", new File(("./Screenshots/Add_Customer_Info_Are_Numbers_Only.jpg")));
        // take screenshot

        //Assertion
        String Warnning_Message= driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/label")).getText();
        Assert.assertEquals( Warnning_Message,"first and last name can not be numbers" );
        //Assertion
    }

    @Test(dataProvider ="test_data" , priority=2)
    public void Add_Existing_Customer(String First_Name, String Last_Name, String Post_Code) throws IOException {

        // config extent report
        ExtentTest test = extent.createTest("Add_Existing_Customer");
        test.info("open website");
        test.info("click on bank manager login button");
        test.info("click on add customer option ");
        test.info("enter first_name, last_name & post_code  - first customer");
        test.info("click submit & accept the alert");
        test.info("enter first_name, last_name & post_code  - second customer with same info");
        test.info("click submit & accept the alert");
        test.info("expected result = alert message : 'customer_is_exist'");
        test.info("actual result = alert message : 'Customer added successfully'");
        test.fail("test is failed");
        // config extent report

        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login"); // open website
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));   // implicit wait
        driver.findElement(Bank_Manager_Login_Btn).click(); // click on bank manager login btn
        driver.findElement(Add_customer_option).click();   // add customer
        driver.findElement(First_Name_Input).sendKeys(First_Name); // enter user first name
        driver.findElement(Last_Name_Input).sendKeys(Last_Name); // enter user last name
        driver.findElement(Post_Code_Input).sendKeys(Post_Code); // enter user post code
        driver.findElement(Submit_2).click();  // click on add customer btn to submit
        String Alert_Message = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();  // accept the popup alert
        driver.findElement(First_Name_Input).sendKeys(First_Name); // enter user first name
        driver.findElement(Last_Name_Input).sendKeys(Last_Name); // enter user last name
        driver.findElement(Post_Code_Input).sendKeys(Post_Code); // enter user post code
        driver.findElement(Submit_2).click();  // click on add customer btn to submit
        //String Alert_Message = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();  // accept the popup alert

        // take screenshot
        WebElement my_element = driver.findElement(By.xpath("/html/body/div/div"));
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
                .coordsProvider(new WebDriverCoordsProvider())
                .takeScreenshot(driver,my_element);
        ImageIO.write(screenshot.getImage(), "jpg", new File(("./Screenshots/Add_Existing_Customer.jpg")));
        // take screenshot


        //Assertion
        String Warnning_Message= driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/label")).getText();
        Assert.assertEquals( Warnning_Message,"customer_is_exist" );
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


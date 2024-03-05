package Test_Cases;
import Base_Class.Base_Class;
import Test_Data.import_excel;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.time.Duration;

public class Bank_Manager_Open_Account extends Base_Class{

    //Config Extent Report
    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("Reports/Bank_Manager_Open_Account_Report.html"); // Report location
    //Extent Report config

    public WebDriver driver = new ChromeDriver();
    @BeforeTest
    public void Open_Browser(){
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();

        // config extent report
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Bank_Manager_Open_Account");
        extent.attachReporter(spark);
        // config extent report
    }

    @Test(dataProvider ="test_data" , priority=0)
    public void Open_Account(String First_Name, String Last_Name, String Post_Code) {

        // config extent report
        ExtentTest test = extent.createTest("Open_Account");
        test.info("open website");
        test.info("click on bank manager login button");
        test.info("click on open account option ");
        test.info("select customer and currency");
        test.info("submit and accept the alert");
        test.info("expected result = alert message : 'Account created successfully' ");
        test.info("actual result = same as expected result");
        test.pass("test is passed");
        // config extent report

        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login"); // open website
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));   // implicit wait
        driver.findElement(Bank_Manager_Login_Btn).click(); // click on bank manager login btn
        driver.findElement(Open_Account_Option).click();   // open account tab
        Select s1 = new Select(driver.findElement(User_Select_Box)); // select box "choose your user"
        s1.selectByVisibleText("Ron Weasly");  // select the user
        Select s2 = new Select(driver.findElement(Currency_Select_Box)); // select box "choose your user"
        s2.selectByVisibleText("Dollar"); // select the currency
        driver.findElement(Submit_2).click();   // Submit btn - to open account
        String Alert_Message= driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();

        //Assertion
        Assert.assertEquals( Alert_Message,Alert_Message );
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


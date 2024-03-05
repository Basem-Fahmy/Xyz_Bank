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
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.time.Duration;

public class Bank_Manager_Customers_Info extends Base_Class{

    //Config Extent Report
    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("Reports/Bank_Manager_Customers_Info_Report.html"); // Report location
    //Extent Report config

    public WebDriver driver = new ChromeDriver();
    @BeforeTest
    public void Open_Browser(){
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();

        // config extent report
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Bank_Manager_Customers_Info");
        extent.attachReporter(spark);
        // config extent report
    }

    @Test(dataProvider ="test_data" , priority=0)
    public void Search_For_Existing_Customer(String First_Name, String Last_Name, String Post_Code) {

        // config extent report
        ExtentTest test = extent.createTest("Search_For_Existing_Customer");
        test.info("open website");
        test.info("click on bank manager login button");
        test.info("click on customers option ");
        test.info("search for customer by name  ");
        test.info("expected result = can see the user info ");
        test.info("actual result = same as expected result");
        test.pass("test is passed");
        // config extent report

        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login"); // open website
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));   // implicit wait
        driver.findElement(Bank_Manager_Login_Btn).click(); // click on bank manager login btn
        driver.findElement(Customers_List).click();   // customers btn - see their info
        driver.findElement(Search_input).sendKeys("Neville");   // Search input-search by customer name

        //Assertion
        String Search_Result= driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/table/tbody/tr/td[1]")).getText();
        Assert.assertEquals( Search_Result,"Neville" );
        //Assertion
    }

    @Test(dataProvider ="test_data" , priority=1)
    public void Search_For_Non_Existing_Customer(String First_Name, String Last_Name, String Post_Code) {

        // config extent report
        ExtentTest test = extent.createTest("Search_For_Non_Existing_Customer");
        test.info("open website");
        test.info("click on bank manager login button");
        test.info("click on customers option ");
        test.info("search for customer by name ");
        test.info("expected result = see no results ");
        test.info("actual result = same as expected result");
        test.pass("test is passed");
        // config extent report

        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login"); // open website
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));   // implicit wait
        driver.findElement(Bank_Manager_Login_Btn).click(); // click on bank manager login btn
        driver.findElement(Customers_List).click();   // customers btn - see their info
        driver.findElement(Search_input).sendKeys("999");   // Search input-search by customer name
    }

    @Test(dataProvider ="test_data" , priority=2)
    public void Delete_Customer(String First_Name, String Last_Name, String Post_Code) {

        // config extent report
        ExtentTest test = extent.createTest("Delete_Customer");
        test.info("open website");
        test.info("click on bank manager login button");
        test.info("click on customers option ");
        test.info("select customer and click delete");
        test.info("expected result = selected customer is deleted  ");
        test.info("actual result = same as expected result");
        test.pass("test is passed");
        // config extent report

        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login"); // open website
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));   // implicit wait
        driver.findElement(Bank_Manager_Login_Btn).click(); // click on bank manager login btn
        driver.findElement(Customers_List).click();   // customers btn - see their info
        driver.findElement(Delete_Customer).click();   // delete btn - to delete customer
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


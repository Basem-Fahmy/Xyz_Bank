package Base_Class;
import org.openqa.selenium.By;
public class Base_Class {

    // page objects - TC = Customer_Deposit
    public By Customer_Login_Btn = By.xpath("/html/body/div/div/div[2]/div/div[1]/div[1]/button");
    public By User_Select_Box = By.xpath("//*[@id=\"userSelect\"]");
    public By Login_Btn= By.xpath("/html/body/div/div/div[2]/div/form/button");
    public By Deposit_Option= By.xpath("/html/body/div/div/div[2]/div/div[3]/button[2]");
    public By Amount= By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input");
    public By Submit= By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button");
    // page objects - TC = Customer_Deposit

    // page objects - TC = Customer_Withdraw
    public By Withdraw_Option= By.xpath("/html/body/div/div/div[2]/div/div[3]/button[3]");
    public By Logout_Btn = By.xpath("/html/body/div/div/div[1]/button[2]");
    // page objects - TC = Customer_Withdraw

    // page objects - TC = Customer_Transactions
    public By Transactions_Option= By.xpath("/html/body/div/div/div[2]/div/div[3]/button[1]");
    public By Transactions_Reset= By.xpath("/html/body/div/div/div[2]/div/div[1]/button[2]");
    public By Back= By.xpath("/html/body/div/div/div[2]/div/div[1]/button[1]");
    // page objects - TC = Customer_Transactions

    //page objects - TC = Bank_Manager_Add_Customer
    public By Bank_Manager_Login_Btn = By.xpath("/html/body/div/div/div[2]/div/div[1]/div[2]/button");
    public By Add_customer_option = By.xpath("/html/body/div/div/div[2]/div/div[1]/button[1]");
    public By First_Name_Input  = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/input");
    public By Last_Name_Input  = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[2]/input");
    public By Post_Code_Input  = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[3]/input");
    public By Submit_2 = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button");
    //page objects - TC = Bank_Manager_Add_Customer

    //page objects - TC = Bank_Manager_open_Account
    public By Open_Account_Option =By.xpath("/html/body/div/div/div[2]/div/div[1]/button[2]");
    public By Currency_Select_Box= By.xpath("//*[@id=\"currency\"]");
    //page objects - TC = Bank_Manager_open_Account

    //page objects - TC =     Bank Manager_Customers_info
    public By Customers_List =By.xpath("/html/body/div/div/div[2]/div/div[1]/button[3]");
    public By Search_input= By.xpath("/html/body/div/div/div[2]/div/div[2]/div/form/div/div/input");
    public By Delete_Customer = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/table/tbody/tr[3]/td[5]/button");
    //page objects - TC =     Bank Manager_Customers_info

}

package TestCases;
import PageBase.PageBase;
import Pages.*;
import Utiles.DataFaker;
import Utiles.UserData;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestCase extends TestBase
{
    PageBase baseObj;
    RegisterPage regObj;
    Account accountObj;
    CreateAccount createObj;
    TransferFund fundObj;
    ContactPage contactObj;
    LoginPage loginObj;

    @Test(priority = 1)
    public void userRegister()
    {
        regObj =new RegisterPage(driver);
        baseObj =new PageBase(driver);
        // Get fake data
        String firstName = DataFaker.getFirstName();
        String lastName = DataFaker.getLastName();
        String address = DataFaker.getStreetAddress();
        String city = DataFaker.getCity();
        String state = DataFaker.getState();
        String zip = DataFaker.getZipCode();
        String phone = DataFaker.getPhoneNumber();
        String ssn = DataFaker.getSSN();
        String username = DataFaker.getUsername();
        String password = DataFaker.getPassword();
        UserData.registeredUsername=username;
        UserData.registeredPassword=password;
        System.out.println(UserData.registeredUsername);
        System.out.println(UserData.registeredPassword);

        Allure.step("Go To Register Page");
        regObj.registerBTN.click();
        Allure.step("Enter Valid Data and Create New account");
        regObj.registerAccount(firstName,lastName,address,city,state,zip,phone,ssn,username,password,password);
        baseObj.waitForElementVisibility(regObj.welcomeUser, 5);
        Allure.step("Assertion that account created done by verify Success Message Appears");
        Assert.assertTrue(regObj.welcomeUser.isDisplayed());
        Allure.step("Take Screenshots");
        try{
        Utils.Screenshots.takeScreenshot(driver, "User Create Account Done", regObj.welcomeUser);
        } catch (IOException e) {System.out.println("Screenshot capture failed: " + e.getMessage());}
    }

    @Test(priority = 2,dependsOnMethods = {"userRegister"})
    public void getAccountData()
    {
        accountObj = new Account(driver);
        Allure.step("Go to Account Overview page");
        accountObj.accountPage.click();
        Allure.step("Verify there is account exits");
        Assert.assertTrue(accountObj.totalElement.isDisplayed());
        Allure.step("get all account data by row number");
        accountObj.getAccountInfoByRowNumber(0);
        Allure.step("Take Screenshots");
        try{
            Utils.Screenshots.takeScreenshot(driver, "Account Total", accountObj.totalElement);
        } catch (IOException e) {System.out.println("Screenshot capture failed: " + e.getMessage());}
    }

    @Test(priority = 3, dependsOnMethods = {"userRegister"})
    public void openNewAccount()
    {
        baseObj =new PageBase(driver);
        createObj =new CreateAccount(driver);
        Allure.step("Go to Page of Create New Account");
        createObj.newAccountPage.click();
        Allure.step("Select Account type, [Savings / Checking]");
        Allure.step("click on the button of create account");
        createObj.createNewAccount("SAVINGS");
        Allure.step("click on the button of create account");
        Allure.step("Waiting loader");
        baseObj.waitForElementVisibility(createObj.createSucMSG,10);
        Allure.step("Validate if the Account create");

        Assert.assertTrue(createObj.accountId.isDisplayed());
        try{
            Utils.Screenshots.takeScreenshot(driver, "create account", createObj.createSucMSG);
        } catch (IOException e) {System.out.println("Screenshot capture failed: " + e.getMessage());}
    }

    @Test(priority = 4,dependsOnMethods = {"openNewAccount"})
    public void transferFundToNewAccountId()
    {

        accountObj = new Account(driver);
        createObj = new CreateAccount(driver);
        fundObj = new TransferFund(driver);
        baseObj =new PageBase(driver);
        String newAccountId = createObj.accountId.getText().trim();
        fundObj.transferPage.click();
        fundObj.transfer("50",UserData.AccountID,newAccountId);
        baseObj.waitForElementVisibility(fundObj.sucMSGFund,5);
        Assert.assertTrue(fundObj.sucMSGFund.isDisplayed());
        Assert.assertEquals(fundObj.transferAmount.getText().trim(),"$50.00");
        Allure.step("Take Screenshots");
        try{
            Utils.Screenshots.takeScreenshot(driver, "Transfer Fund made Successfully", fundObj.sucMSGFund);
        } catch (IOException e) {System.out.println("Screenshot capture failed: " + e.getMessage());}
    }
    @Test(priority = 5,dependsOnMethods = {"userRegister"})
    public void updateUserData()
    {
        contactObj =new ContactPage(driver);
        baseObj =new PageBase(driver);
        loginObj = new LoginPage(driver);
        String firstName = DataFaker.getFirstName();
        String lastName = DataFaker.getLastName();
        String address = DataFaker.getStreetAddress();
        String city = DataFaker.getCity();
        String state = DataFaker.getState();
        String zip = DataFaker.getZipCode();
        String phone = DataFaker.getPhoneNumber();
        Allure.step("open Contact Info page");
        contactObj.updateLink.click();
        Allure.step("Get Current User name");
        String currentUser = baseObj.currentUserName.getText().trim();
        Allure.step("Clear All Data");
        contactObj.clearFieldForUpdate();
        Allure.step("Adding new data for user");
        contactObj.update(firstName,lastName,address,city,state,zip,phone);
        Allure.step("Save Changes");
        contactObj.updateBTN.click();
        baseObj.waitForElementVisibility(contactObj.updateMSG,10);
        Assert.assertTrue(contactObj.updateMSG.isDisplayed());
        try{
            Utils.Screenshots.takeScreenshot(driver, "Contact Update done", contactObj.updateMSG);
        } catch (IOException e) {System.out.println("Screenshot capture failed: " + e.getMessage());}
        Allure.step("Logout");
        baseObj.logout.click();
        Allure.step("Login Again");
        loginObj.login(UserData.registeredUsername,UserData.registeredPassword);
        baseObj.waitForElementVisibility(baseObj.currentUserName,5);
        String newUser = baseObj.currentUserName.getText().trim();
        Allure.step("Check Current user with old one");
        Assert.assertNotEquals(currentUser,newUser);

    }

}

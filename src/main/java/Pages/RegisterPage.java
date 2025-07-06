package Pages;

import PageBase.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends PageBase {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    //Register Icon for Create account
    @FindBy(linkText = "Register")
    public WebElement registerBTN;
    //Firstname Field
    @FindBy(id = "customer.firstName")
     WebElement firstName;
    //Lastname Field
    @FindBy(id = "customer.lastName")
    WebElement lastName;
    //address Field
    @FindBy(id = "customer.address.street")
    WebElement address;
    //City Field
    @FindBy(id = "customer.address.city")
    WebElement city;
    //State Field
    @FindBy(id = "customer.address.state")
    WebElement state;
    //ZipCode Field
    @FindBy(id = "customer.address.zipCode")
    WebElement zipCode;
    //Phone Number Field
    @FindBy(id = "customer.phoneNumber")
    WebElement phoneNumber;
    //SSN Field
    @FindBy(id = "customer.ssn")
    WebElement ssn;
    // username field
    @FindBy(id = "customer.username")
    WebElement username;
    // password field
    @FindBy(id = "customer.password")
    WebElement password;
    // Confirm password field
    @FindBy(id = "repeatedPassword")
    WebElement confirmPassword;
    //Button of Register
    @FindBy(xpath = "//input[@type='submit' and @value='Register']")
    WebElement registerButton;

    //Welcome
    @FindBy(xpath = "//div[@id='rightPanel']/p[contains(text(), 'Your account was created successfully')]")
    public WebElement welcomeUser;

    public void registerAccount(String FN, String LN, String add, String cities, String State, String
      Code, String Phone, String SSN, String user, String Pass, String ConfPass)
    {
        firstName.sendKeys(FN);
        lastName.sendKeys(LN);
        address.sendKeys(add);
        city.sendKeys(cities);
        state.sendKeys(State);
        zipCode.sendKeys(Code);
        phoneNumber.sendKeys(Phone);
        ssn.sendKeys(SSN);
        username.sendKeys(user);
        password.sendKeys(Pass);
        confirmPassword.sendKeys(ConfPass);
        registerButton.click();
    }

}

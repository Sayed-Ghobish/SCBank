package Pages;

import PageBase.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ContactPage extends PageBase {
    public RegisterPage RegisterObj;
    public ContactPage(WebDriver driver) {
        super(driver);
        RegisterObj = new RegisterPage(driver);
    }

    @FindBy(linkText = "Update Contact Info")
    public WebElement updateLink;


    @FindBy(xpath = "//input[@type='button' and @value='Update Profile']")
    public WebElement updateBTN;

    @FindBy(xpath = "//*[@id=\"updateProfileResult\"]/p")
    public WebElement updateMSG;

    public void clearFieldForUpdate()
    {
        RegisterObj.firstName.clear();
        RegisterObj.lastName.clear();
        RegisterObj.address.clear();
        RegisterObj. city.clear();
        RegisterObj. state.clear();
        RegisterObj.zipCode.clear();
        RegisterObj. phoneNumber.clear();
    }
    public void update(String FN, String LN, String add, String cities, String State, String
            Code, String Phone)
    {
        RegisterObj.firstName.sendKeys(FN);
        RegisterObj.lastName.sendKeys(LN);
        RegisterObj.address.sendKeys(add);
        RegisterObj. city.sendKeys(cities);
        RegisterObj. state.sendKeys(State);
        RegisterObj.zipCode.sendKeys(Code);
        RegisterObj. phoneNumber.sendKeys(Phone);
        updateBTN.click();
    }
}

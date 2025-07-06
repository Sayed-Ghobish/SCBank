package Pages;

import PageBase.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount extends PageBase {
    public CreateAccount(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Open New Account")
    public WebElement newAccountPage;

    @FindBy(id="type")
    WebElement typeOfAccount;

    @FindBy(xpath = "//input[@type='button' and @value='Open New Account']")
    WebElement openAccount;

    @FindBy(id="openAccountResult")
    public WebElement createSucMSG;

    @FindBy(id="newAccountId")
    public WebElement accountId;

    public void selectAccountType(String accountTypeText) {
        Select dropdown = new Select(typeOfAccount);
        dropdown.selectByVisibleText(accountTypeText);
    }

    public void createNewAccount(String accountTypeText)
    {
        selectAccountType(accountTypeText);
        openAccount.click();
    }




}

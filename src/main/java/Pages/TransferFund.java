package Pages;

import PageBase.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class TransferFund extends PageBase {
    public TransferFund(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText="Transfer Funds")
    public WebElement transferPage;

    @FindBy(id="amount")
    WebElement amountField;
    @FindBy(id="fromAccountId")
    WebElement fromAccount;
    @FindBy(id="toAccountId")
    WebElement toAccount;
    @FindBy(xpath = "//input[@type='submit' and @value='Transfer']")
    WebElement transferBTN;
    @FindBy(id ="amountResult")
    public WebElement transferAmount;
    @FindBy(id ="showResult")
    public WebElement sucMSGFund;

    public void selectfromID(String oldID) {
        Select dropdown = new Select(fromAccount);
        dropdown.selectByVisibleText(oldID);
    }

    public void selectToId(String newID) {
        Select dropdown = new Select(toAccount);
        dropdown.selectByVisibleText(newID);
    }

    public void transfer(String amounts, String oldID, String newID)
    {
        amountField.sendKeys(amounts);
        selectfromID(oldID);
        selectToId(newID);
        transferBTN.click();

    }
}

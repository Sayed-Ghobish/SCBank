package Pages;

import PageBase.PageBase;
import Utiles.UserData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Account extends PageBase {
    public Account(WebDriver driver) {
        super(driver);
    }
    @FindBy(linkText = "Accounts Overview")
    public WebElement accountPage;

    @FindBy(xpath = "//table[@id='accountTable']//tbody/tr[td[1][a]]")
    public List<WebElement> accountRows;

    @FindBy(xpath = "//table[@id='accountTable']//tbody/tr[td[1][b[contains(text(), 'Total')]]]/td[2]/b")
    public WebElement totalElement;


    public void getAccountInfoByRowNumber(int rowIndex)
    {

        if (rowIndex < 0 || rowIndex >= accountRows.size()) {
            System.out.println("Invalid Row, The Available Rows: " + accountRows.size());
            return;
        }

        WebElement row = accountRows.get(rowIndex);
        String accountId = row.findElement(By.xpath("./td[1]/a")).getText();
        String balance = row.findElement(By.xpath("./td[2]")).getText();
        String total = totalElement.getText();
        UserData.AccountID = accountId;
        System.out.println("Row " + rowIndex + " Account ID: " + accountId + " Balance: " + balance);
        System.out.println("Total Balance: " + total);
    }

}

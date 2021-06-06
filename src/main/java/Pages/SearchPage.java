package Pages;

import BaseTest.BaseTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

public class SearchPage extends BaseTest {
    public SearchPage() throws IOException {
        PageFactory.initElements( driver,this );
    }

    @FindBy(xpath = "//input[@id='search']")
    public WebElement searchBoxMM;
    @FindBy(xpath = "//button[@title='Search']")
    public WebElement searchButtonMM;
    public String searchQuery="*";
    @FindBy(xpath = "//div[@unbxdparam_sku='WOCC84380']")
    public WebElement searchPageProductClick;

    public void searchBoxIsDisplayOrNot()
    {
        Assert.assertEquals(searchBoxMM.isDisplayed(),true,"Search Box is not getting displayed.");
    }
    public void searchEnterKeyIsWorkingOrNot()
    {
        searchBoxMM.sendKeys(searchQuery+ Keys.ENTER);
        String newURL=driver.getCurrentUrl();
        Assert.assertEquals(newURL.contains("searchresults"),true,"Search using enter key is not working");
    }

    public void searchIconClickIsWorkingOrNot()
    {
        searchBoxMM.sendKeys(searchQuery);
        searchButtonMM.click();
        String newURL=driver.getCurrentUrl();
        Assert.assertEquals(newURL.contains("searchresults"),true,"Search using enter key is not working");
    }
}

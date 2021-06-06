package Pages;

import BaseTest.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

public class HomePage extends BaseTest {
    public HomePage() throws IOException {
        PageFactory.initElements( driver,this );
    }
    @FindBy(xpath="//h1[@class='logo']//a[@title]")
    public WebElement homePageLogo;
    @FindBy(xpath = "//a[text()='Wishlist']")
    public WebElement homeWishListTitle;
    @FindBy(xpath = "//a[text()='Cart']")
    public WebElement homePageCart;
    @FindBy(xpath = "//h2[@class='block-title']")
    public WebElement homePageNewArrival;
    public String homePageNewAr="New Arrivals";

    @FindBy (xpath = "//input[@id='search']")
    public WebElement searchBoxMM;
    @FindBy(xpath = "//button[@title='Search']")
    public WebElement searchButtonMM;
    public String searchQuery="*";


    public void verifyThePageTitle()
    {
        Assert.assertEquals(homePageLogo.getAttribute("title"),"Miniature Market","Page title is not correct");
    }

    public void verifyTheWishlist()
    {
        Assert.assertEquals(homeWishListTitle.getText(),"Wishlist","Whish list is not getting displayed");
    }

    public void verifyTheCart()
    {
        Assert.assertEquals(homePageCart.getText(),"Cart","Cart is not getting displayed");
    }

    public void verifyNewArrival()
    {
        Assert.assertEquals(homePageNewArrival.getText(),homePageNewAr,"New Arrivals is not getting displayed");
    }
    public SearchPage homePageSearch() throws IOException {
        searchBoxMM.sendKeys(searchQuery);
        searchButtonMM.click();
        return new SearchPage();
    }


}

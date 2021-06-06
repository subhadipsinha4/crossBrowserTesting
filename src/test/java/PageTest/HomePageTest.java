package PageTest;

import BaseTest.BaseTest;
import Pages.HomePage;
import Pages.SearchPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest extends BaseTest {
    HomePage homePage;
    SearchPage searchPage;
    public HomePageTest() throws IOException {
        super();
    }
    @Parameters("browser")
    @BeforeMethod(groups = {"smock","sanity"})
    public void setUp(String browser) throws IOException {
        intilize(browser);
        homePage=new HomePage();
        searchPage=new SearchPage();
    }
    @Test(priority = 1, groups = {"smock"})
    public void testPageTitle(){
        homePage.verifyThePageTitle();
    }
    @Test(priority = 2, groups = {"sanity"})
    public void testPageWishlist(){
        homePage.verifyTheWishlist();
    }
    @Test(priority = 3, groups = {"smock"})
    public void testPageCart(){
        homePage.verifyTheCart();
    }
    @Test(priority = 4, groups = {"sanity"})
    public void testPageNewArrival(){
        homePage.verifyNewArrival();
    }
    @Test(priority = 5, groups = {"smock"})
    public void testHomePageSearch() throws IOException {
        searchPage=homePage.homePageSearch();
    }
    @AfterMethod(groups = {"smock","sanity"})
    public void tearDown()
    {
        driver.quit();
    }
}

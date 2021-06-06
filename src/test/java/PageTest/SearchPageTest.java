package PageTest;

import BaseTest.BaseTest;
import Pages.HomePage;
import Pages.SearchPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class SearchPageTest extends BaseTest {

    SearchPage searchPage;
    public SearchPageTest() throws IOException {
        super();
    }
    @Parameters("browser")
    @BeforeMethod(groups = {"smock","sanity"})
    public void setUp(String browser) throws IOException {
        intilize(browser);
        searchPage=new SearchPage();
    }

    @Test(priority = 6, groups = {"sanity"})
    public void testsearchBoxIsDisplayOrNot(){
        searchPage.searchBoxIsDisplayOrNot();
    }

    @Test(priority = 7, groups = {"smock"})
    public void testsearchEnterKeyIsWorkingOrNot(){
        searchPage.searchEnterKeyIsWorkingOrNot();
    }

    @Test(priority = 8, groups = {"sanity"})
    public void testsearchIconClickIsWorkingOrNot(){
        searchPage.searchIconClickIsWorkingOrNot();
    }
    @AfterMethod(groups = {"smock","sanity"})
    public void tearDown()
    {
        driver.quit();
    }
}

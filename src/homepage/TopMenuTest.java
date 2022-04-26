package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToShippingPageSuccessfully() {
        //click on the "Shipping" link
        clickOnElement(By.xpath("(//span[contains(text(),'Shipping')])[2]"));
        //verify the text "Shipping"
        String expectedMessage = "Shipping";
        String actualMessage = getTextFromElement(By.xpath("//h1[@id='page-title']"));
    }

    @Test
    public void verifyUserShouldNavigateToNewPageSuccessfully() {
        //click on the "New!" link
        clickOnElement(By.xpath("(//span[contains(text(),'New!')])[2]"));
        //verify the text "New arrivals"
        String expectedMessage = "New!";
        String actualMessage = getTextFromElement(By.xpath("//h1[@id='page-title']"));
    }

    @Test
    public void verifyUserShouldNavigateToComingSoonPageSuccessfully() {
        //click on the "coming soon" link
        clickOnElement(By.xpath("(//span[contains(text(),'Coming soon')])[2]"));
        //verify the text "coming soon"
        String expectedMessage = "Coming Soon";
        String actualMessage = getTextFromElement(By.xpath("//h1[@id='page-title']"));
    }

    @Test
    public void verifyUserShouldNavigateToContactUsPageSuccessfully() {
        //click on the "Contact us" link
        clickOnElement(By.xpath("(//span[contains(text(),'Contact us')])[2]"));
        //verify the text "Contact Us"
        String expectedMessage = "Contact Us";
        String actualMessage = getTextFromElement(By.xpath("//h1[@id='page-title']"));
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}




package hotdeals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class HotDealsTest extends Utility {
    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifySaleProductsArrangeAlphabetically() throws InterruptedException {
        //1.1 Mouse hover on the “Hot deals” link
        mouseHoverOnly(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"));
        //1.2 Mouse hover on the “Sale”  link and click
        mouseHoverClick(By.xpath("(//span[contains(text(),'Sale')])[2]"));
        //1.3 Verify the text “Sale”
        verifyText("Sale", getTextFromElement(By.xpath("//h1[@id='page-title']")), "Error-Message not displayed");
        //1.4 Mouse hover on “Sort By” and select “Name A-Z”
        mouseHoverOnly(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverClick(By.xpath("//a[normalize-space()='Name A - Z']"));
        //	1.5 Verify that the product arrange alphabetically
        verifyText("Name A - Z", getTextFromElement(By.xpath("//span[contains(text(),'Name A - Z')]")), "Error-Message not displayed");
    }

    @Test
    public void verifySaleProductsArrangeLowToHigh() throws InterruptedException {
        //2.1 Mouse hover on the “Hot deals” link
        mouseHoverOnly(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"));
        //2.2 Mouse hover on the “Sale”  link and click
        mouseHoverClick(By.xpath("(//span[contains(text(),'Sale')])[2]"));
        //3 Verify the text “Sale”
        verifyText("Sale", getTextFromElement(By.xpath("//h1[@id='page-title']")), "Error-Message not displayed");
        //2.4 Mouse hover on “Sort By” and select “Price Low-High”
        mouseHoverOnly(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverClick(By.xpath("//a[normalize-space()='Price Low - High']"));
        //	2.5 Verify that the product’s price arrange Low to High
        verifyText("Price Low - High", getTextFromElement(By.xpath("//span[contains(text(),'Price Low - High')]")), "Error-Message not displayed");
    }

    @Test
    public void verifySaleProductsArrangeByRates() throws InterruptedException {
       //3.1 Mouse hover on the “Hot deals” link
        mouseHoverOnly(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"));
        //3.2 Mouse hover on the “Sale”  link and click
        mouseHoverClick(By.xpath("(//span[contains(text(),'Sale')])[2]"));
        //3.3 Verify the text “Sale”
        verifyText("Sale", getTextFromElement(By.xpath("//h1[@id='page-title']")), "Error-Message not displayed");
        //	3.4 Mouse hover on “Sort By” and select “Rates”
        mouseHoverOnly(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverClick(By.xpath("//a[normalize-space()='Rates']"));
        //	3.4 Mouse hover on “Sort By” and select “Rates”
        verifyText("Rates", getTextFromElement(By.xpath("//span[contains(text(),'Rates')]")), "Error-Message not displayed");
    }

    @Test
    public void verifyBestSellersProductsArrangeByZToA() throws InterruptedException {
        //	1.1 Mouse hover on the “Hot deals” link
        mouseHoverOnly(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"));
        //	1.2 Mouse hover on the “Bestsellers”  link and click
        mouseHoverClick(By.xpath("(//span[contains(text(),'Bestsellers')])[2]"));
        //	1.3 Verify the text “Bestsellers”
        verifyText("Bestsellers", getTextFromElement(By.xpath("//h1[@id='page-title']")), "Error-Message not displayed");
        //	1.4 Mouse hover on “Sort By” and select “Name Z-A”
        mouseHoverOnly(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverClick(By.xpath("(//a[normalize-space()='Name Z - A'])[1]"));
        //	1.5 Verify that the product arrange by Z to A
        verifyText("Name Z - A", getTextFromElement(By.xpath("//span[contains(text(),'Name Z - A')]")), "Error-Message not displayed");
    }

    @Test
    public void verifyBestSellersProductsArrangeHighToLow() throws InterruptedException {
        //2.1 Mouse hover on the “Hot deals” link
        mouseHoverOnly(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"));
        //2.2 Mouse hover on the “Bestsellers” link and click
        mouseHoverClick(By.xpath("(//span[contains(text(),'Bestsellers')])[2]"));
        //	2.3 Verify the text “Bestsellers”
        verifyText("Bestsellers", getTextFromElement(By.xpath("//h1[@id='page-title']")), "Error-Message not displayed");
        //	2.4 Mouse hover on “Sort By” and select “Price High-Low”
        mouseHoverOnly(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverClick(By.xpath("//a[normalize-space()='Price High - Low']"));
        //2.5 Verify that the product’s price arrange High to Low
        verifyText("Price High - Low", getTextFromElement(By.xpath("//span[contains(text(),'Price High - Low')]")), "Error-Message not displayed");
    }

    @Test
    public void verifyBestSellersProductsArrangeByRates() throws InterruptedException {
        //3.1 Mouse hover on the “Hot deals” link
        mouseHoverOnly(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"));
        //3.2 Mouse hover on the “Bestsellers”  link and click
        mouseHoverClick(By.xpath("(//span[contains(text(),'Bestsellers')])[2]"));
       //3.3 Verify the text “Bestsellers”
        verifyText("Bestsellers", getTextFromElement(By.xpath("//h1[@id='page-title']")), "Error-Message not displayed");
        //3.4 Mouse hover on “Sort By” and select “Rates”
        mouseHoverOnly(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverClick(By.xpath("//a[normalize-space()='Rates']"));
        //3.5 Verify that the product’s arrange Rates
        verifyText("Rates", getTextFromElement(By.xpath("//span[contains(text(),'Rates')]")), "Error-Message not displayed");
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}





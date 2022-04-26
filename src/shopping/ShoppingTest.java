package shopping;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.Utility;

public class ShoppingTest extends Utility {
    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatUserShouldPlaceOrderSuccessfullyForAvengersFabrikationsPlush() throws InterruptedException {
        //1.1 Mouse hover on the “Hot deals” link
        mouseHoverOnly(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"));
        //	1.2 Mouse hover on the “Bestsellers”  link and click
        mouseHoverClick(By.xpath("(//span[contains(text(),'Bestsellers')])[2]"));
        //1.3 Verify the text “Bestsellers”
        verifyText("Bestsellers", getTextFromElement(By.xpath("//h1[@id='page-title']")), "Error-Message not displayed");
        //1.4 Mouse hover on “Sort By” and select “Name A-Z”
        mouseHoverOnly(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverClick(By.xpath("//a[normalize-space()='Name A - Z']"));
        //1.5 Click on “Add to cart” button of the product
        mouseHoverOnly(By.xpath("//*[@id=content]/div/div/div[2]/div/div/div[3]/ul/li[1]/div/div[2]/div[4]/div/button/span"));
        mouseHoverClick(By.xpath("//*[@id=content]/div/div/div[2]/div/div/div[3]/ul/li[1]/div/div[2]/div[4]/div/button/span"));
        //1.6 Verify the message “Product has been added to your cart” display in  green bar
        String actualMessage = getTextFromElement(By.xpath("//li[@class='info']"));
        verifyText("Product has been added to your cart", actualMessage, "Failed to add");
        //1.7 Click on X sign to close the message
        clickOnElement(By.xpath("//a[@title='Close']"));
        //1.8 Click on “Your cart” icon and Click on “View cart” button
        clickOnElement(By.xpath("//div[@title='Your cart']"));
        Thread.sleep(3000);
        //1.9 Verify the text “Your shopping cart - 1 item”
        mouseHoverOnly(By.xpath("//*[@id=\"header\"]/div[4]/div[3]/div/a[1]/span"));
        mouseHoverClick(By.xpath("//*[@id='header']/div[4]/div[3]/div/a[1]/span"));
        verifyText("Your shopping cart - 1 item", getTextFromElement(By.xpath("//h1[contains(text(),'Your shopping cart - 1 item')]")), "Error, Message not displayed as expected");
        //1.10 Verify the Subtotal &
        //1.11 Verify the total
        verifyText("$299.00", getTextFromElement(By.xpath("//p[@class='subtotal']")), "Error, Message not displayed as expected");
        //1.12 Click on “Go to checkout” button
        clickOnElement(By.xpath("//button[contains(@class,'regular-button regular-main-button checkout')]"));
        // 1.13 Verify the text “Log in to your account”
        verifyText("Log in to your account", getTextFromElement(By.xpath("//h3[contains(text(),'Log in to your account')]")), "Page not found");
        // 1.14 Enter Email address
        sendTextToElement(By.xpath("//input[@id='email']"), "shahbella55@gmail.com");
        //1.15 Click on “Continue” Button
        clickOnElement(By.xpath("//button[contains(@class,'regular-button anonymous-continue-button submit')]"));
        //1.16 Verify the text “Secure Checkout”
        verifyText("Secure Checkout", getTextFromElement(By.xpath("//h1[normalize-space()='Secure Checkout']")), "Page not founf");
        //1.17 Fill all the mandatory fields
        sendTextToElement(By.xpath("//input[@id='shippingaddress-firstname']"), "Bella");
        sendTextToElement(By.xpath("//input[@id='shippingaddress-lastname']"), "Shah");
        sendTextToElement(By.xpath("//input[@id='shippingaddress-street']"), "156 Ealing Road");
        sendTextToElement(By.xpath("//input[@id='shippingaddress-city']"), Keys.BACK_SPACE + "London");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='shippingaddress-country-code']"), "United Kingdom");
        sendTextToElement(By.xpath("//input[@id='shippingaddress-custom-state']"), "London");
        //1.18 Check the check box “Create an account for later use”
        sendTextToElement(By.xpath("//input[@id='shippingaddress-zipcode']"), Keys.BACK_SPACE + "6");
        clickOnElement(By.xpath("//input[@id='create_profile']"));
        //1.19 Enter the password
        sendTextToElement(By.xpath("//input[@id='password']"), "Bella123");
        //1.20 Select the Delivery Method to “Local Shipping”
        clickOnElement(By.xpath("//span[normalize-space()='Local shipping']"));
        //1.21 Select Payment Method “COD”
        clickOnElement(By.xpath("//span[normalize-space()='COD']"));
        verifyText("Place order: $311.03", getTextFromElement(By.xpath("//span[contains(text(),'$311.03')]")), "Error, Message not displayed as expected");
        //1.23 Click on “Place Order” Button
        clickOnElement(By.xpath("//button[@class='btn regular-button regular-main-button place-order submit']"));
        //1.24 Verify the text “Thank you for your order”
        verifyText("Thank you for your order", getTextFromElement(By.xpath("//h1[contains(.,'Thank you for your order')]")), "Error, Message not displayed as expected");
    }

    @Test
    public void verifyThatUserShouldClearShoppingCartSuccessfully() throws InterruptedException {
        //1.1 Mouse hover on the “Hot deals” link
        mouseHoverOnly(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"));
        //	1.2 Mouse hover on the “Bestseller”  link and click
        mouseHoverClick(By.xpath("(//span[contains(text(),'Bestsellers')])[2]"));
        //	1.3 Verify the text “Bestsellers”
        verifyText("Bestsellers", getTextFromElement(By.xpath("//h1[@id='page-title']")), "Error-Message not displayed");
       // 1.4 Mouse hover on “Sort By” and select “Name A-Z”
        mouseHoverOnly(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverClick(By.xpath("//a[normalize-space()='Name A - Z']"));
        Thread.sleep(3000);
        //	1.5 Click on “Add to cart” button of the product “Vinyl Idolz: Ghostbusters”
        mouseHoverOnly(By.xpath("//a[@class='product-thumbnail next-previous-assigned']"));
        Thread.sleep(3000);
        //1.6 Verify the message “Product has been added to your cart” display in  green bar
        mouseHoverClick(By.xpath("//button[contains(@class,'btn  regular-button add-to-cart product-add2cart productid-13')]"));
        verifyText("Product has been added to your cart", getTextFromElement(By.xpath("//li[contains(text(),'Product has been added to your cart')]")), "Error, Message not displayed");
        //1.7 Click on X sign to close the message
        clickOnElement(By.xpath("//a[@title='Close']"));
        //1.8 Click on “Your cart” icon and Click on “View cart” button
        clickOnElement(By.xpath("//div[@title='Your cart']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[@class='regular-button cart']"));
        //1.9 Verify the text “Your shopping cart - 1 item”
        verifyText("Your shopping cart - 1 item", getTextFromElement(By.xpath("//h1[contains(text(),'Your shopping cart - 1 item')]")), "Error, Message not displayed as expected");
        //1.10 Click on “Empty your cart” link
        clickOnElement(By.xpath("//a[normalize-space()='Empty your cart']"));
        Thread.sleep(2000);
        //1.11 Verify the text “Are you sure you want to clear your cart?” on alert &
        //1.12 Click “Ok” on alert
        String Message = getTextAlert();
        verifyText("Are you sure you want to clear your cart?", Message, "Error, Message not displayed as expected");
        acceptAlert();
        //1.13 Verify the message “Item(s) deleted from your cart”
        verifyText("Item(s) deleted from your cart", getTextFromElement(By.xpath("//li[contains(.,'Item(s) deleted from your cart')]")), "Error, Message not displayed");
        Thread.sleep(2000);
        //     //1.15 Verify the text “Your cart is empty”
        clickOnElement(By.xpath("//a[@title='Close']"));
        Thread.sleep(2000);
        verifyText("Your cart is empty", getTextFromElement(By.xpath("//h1[contains(.,'Your cart is empty')]")), "Error, Message not displayed");

    }

    @After
    public void tearDown() {
        closeBrowser();
    }


}





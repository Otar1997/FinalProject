package org.example.tests;

import org.example.Base;
import org.example.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOutTest extends Base {

    @Test
    public void checkout() {
        //Get to the checkout page with correct login information
        getCheckoutPage("correct");
        CheckoutPage checkoutPage=new CheckoutPage(driver);
        //Fill in the first name field
        checkoutPage.fillFirstName("Otar");
        //Fill in the last name field
        checkoutPage.fillLastName("Kvelidze");
        //Fill in the postal code field
        checkoutPage.fillPostalCode("0173");
        //Click on the 'Continue' button to proceed with the checkout process
        checkoutPage.clickContinue();
        //Click Finish
        FinishPage finishPage=new FinishPage(driver);
        finishPage.clickFinish();
        CheckoutCompletePage checkoutCompletePage=new CheckoutCompletePage(driver);
        //Define the expected result after completing the checkout process
        String expectedResult = "CHECKOUT: Complete!";
        //Get the actual result of the checkout process
        String actualResult = checkoutCompletePage.getCheckoutText();
        //Assert that the actual result matches the expected result
        Assert.assertTrue(expectedResult.equalsIgnoreCase(actualResult));
    }

    @Test
    public void emptyStringCheckOut() {
        getCheckoutPage("correct");

        CheckoutPage checkoutPage=new CheckoutPage(driver);
        String resultText;

        //1) Click with empty data
        checkoutPage.fillLastName("");
        checkoutPage.clickContinue();
        resultText=checkoutPage.getFirstnameError();
        //Check if we get first name error
        Assert.assertEquals("First Name is required", resultText);

        //2)Click with only name
        checkoutPage.fillFirstName("name");

        checkoutPage.fillLastName("");
        checkoutPage.clickContinue();
        resultText=checkoutPage.getLastNameError();

        //Check if we get last name error
        Assert.assertEquals("Last Name is required", resultText);

        //3)Click with name and lastname filled
        checkoutPage.fillLastName("last");
        checkoutPage.fillPostalCode("");
        checkoutPage.clickContinue();
        resultText=checkoutPage.getPostalCodeError();

        //Check if we get postal code error
        Assert.assertEquals("Postal Code is required", resultText);
    }

    @Test
    public void problemUserCheckout() {
        //Log in with problem user credentials and add a product to the cart
        getCheckoutPage("problem");
        CheckoutPage checkoutPage=new CheckoutPage(driver);
        //Fill in the first name field
        checkoutPage.fillFirstName("Otar");
        //Fill in the last name field
        checkoutPage.fillLastName("Kvelidze");
        //Assert that the first name field value is equal to the last name field value
        Assert.assertEquals(checkoutPage.getFirstNameText(), checkoutPage.getLastNameText());
    }
    //Method to navigate to the checkout page
    private void getCheckoutPage(String loginInfo) {
        logIn(loginInfo);
        //Add a product to the cart
        addProduct(1);
        //Navigate to the checkout page
        goToCheckout();
    }
    //Method to navigate to the checkout page from the cart
    private void goToCheckout() {
        MainPage mainPage=new MainPage(driver);
        //Navigate to the cart page
        mainPage.goToCart();
        CartPage cartPage=new CartPage(driver);
        //Proceed to the checkout page from the cart
        cartPage.goToCheckoutPage();
    }


}

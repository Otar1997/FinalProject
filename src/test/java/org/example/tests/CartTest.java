package org.example.tests;

import org.example.Base;
import org.example.pages.MainPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.WebElement;

public class CartTest extends Base {
    @Test
    public void standardUserCart() {
        //Define the names of the items to be added to the cart
        String firstItemName = "Sauce Labs Backpack";
        String secondItemName = "Sauce Labs Bike Light";
        //Log in with correct credentials
        logIn("correct");
        MainPage mainPage = new MainPage(driver);
        //Add the first item to the cart
        mainPage.addToCartButtonClick(1);
        // Add the second item to the cart
        mainPage.addToCartButtonClick(1);
        //Go to the cart page
        mainPage.goToCart();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Wait until the first item is visible in the cart
        WebElement item1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Sauce Labs Backpack\"]")));
        //Wait until the second item is visible in the cart
        WebElement item2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Sauce Labs Bike Light\"]")));
        // Verify that the first item name matches the expected name
        Assert.assertEquals(item1.getText(), firstItemName);
        // Verify that the second item name matches the expected name
        Assert.assertEquals(item2.getText(), secondItemName);
    }
}


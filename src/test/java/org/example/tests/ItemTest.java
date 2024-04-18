package org.example.tests;

import org.example.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class ItemTest extends Base {
    @Test
    public void AddItem() {
        //Log in with problem user credentials
        logIn("problem");
        // Add item
        addProduct(1);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Find and click on the remove button to remove the item
        WebElement removeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"REMOVE\"]")));
        removeButton.click();
        // Assert that the remove button is still displayed after clicking it
        Assert.assertTrue(removeButton.isDisplayed());
    }

    @Test
    public void insideItem() {
        //Log in with problem user credentials
        logIn("problem");
        String imageBeforeTap = "(//android.view.ViewGroup[@content-desc=\"test-Item\"])[1]";

        // Wait for the parent element to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement parentElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(imageBeforeTap)));
        parentElement.click();

        // Image to be present after tapping
        Assert.assertNotEquals(imageBeforeTap,"//android.view.ViewGroup[@content-desc=\"test-Image Container\"]/android.widget.ImageView","images dont match");
    }
}










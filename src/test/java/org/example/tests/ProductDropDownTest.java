package org.example.tests;

import org.example.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;


public class ProductDropDownTest extends Base {
    @Test
    public void DropDownFilter() {
        //Log in with correct credentials
        logIn("correct");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //wait until filter elements is clickable
        String[] sortFilterXpaths = conf.read("sortFilters").split("#");

        for (String sortFilterXpath : sortFilterXpaths) {
            //Wait until the dropdown button is clickable
            WebElement sort = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Modal Selector Button\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")));
            //Click on the dropdown button
            sort.click();
            //Wait until the filter element is clickable
            WebElement filter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sortFilterXpath)));
            //Click on the filter element
            filter.click();
        }
    }
}

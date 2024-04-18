package org.example.pages;

import io.appium.java_client.android.AndroidDriver;
import org.example.pages.Helper.Helper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    protected AndroidDriver driver;
    @FindBy(xpath = "//android.widget.TextView[@text=\"CHECKOUT\"]")
    private WebElement checkoutButton;

    public CartPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void goToCheckoutPage() {
        Helper.clickToBtn(checkoutButton, driver);
    }
}

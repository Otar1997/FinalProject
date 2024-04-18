package org.example.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutCompletePage {
    protected AndroidDriver driver;
    private final WebDriverWait wait;
    @FindBy(xpath = "//android.widget.TextView[@text=\"CHECKOUT: COMPLETE!\"]")
    private WebElement checkoutCompleteElement;
    public CheckoutCompletePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds wait
        PageFactory.initElements(driver, this);
    }
    public String getCheckoutText(){
        wait.until(ExpectedConditions.visibilityOf(checkoutCompleteElement));
        return checkoutCompleteElement.getText();
    }
}

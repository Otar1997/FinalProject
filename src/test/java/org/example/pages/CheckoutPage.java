package org.example.pages;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.example.pages.Helper.Helper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    protected AndroidDriver driver;
    private final WebDriverWait wait;
    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-First Name\"]")
    private WebElement firstNameField;
    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Last Name\"]")
    private WebElement lastNameField;
    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Zip/Postal Code\"]")
    private WebElement postalCodeField;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-CONTINUE\"]")
    private WebElement continueButton;
    @FindBy(xpath = "//android.widget.TextView[@text=\"First Name is required\"]")
    private WebElement firstNameError;
    @FindBy(xpath = "//android.widget.TextView[@text=\"Last Name is required\"]")
    private WebElement lastNameError;
    @FindBy(xpath = "//android.widget.TextView[@text=\"Postal Code is required\"]")
    private WebElement postalCodeError;

    public CheckoutPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds wait
        PageFactory.initElements(driver, this);
    }
    @Step
    public void fillFirstName(String username) {
        sendKey(username, firstNameField);
    }
    @Step
    public void fillLastName(String lastname) {
        sendKey(lastname, lastNameField);
    }
    @Step
    public void fillPostalCode(String postalCode) {
        sendKey(postalCode, postalCodeField);
    }

    public String getFirstNameText() {
        return firstNameField.getText();
    }

    public String getLastNameText() {
        return lastNameField.getText();
    }

    public void clickContinue() {
        Helper.clickToBtn(continueButton, driver);
    }

    public void sendKey(String txt, WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(txt);
    }

    public String getFirstnameError() {
        wait.until(ExpectedConditions.visibilityOf(firstNameError));
        return firstNameError.getText();
    }

    public String getLastNameError() {
        wait.until(ExpectedConditions.visibilityOf(lastNameError));
        return lastNameError.getText();
    }

    public String getPostalCodeError() {
        wait.until(ExpectedConditions.visibilityOf(postalCodeError));
        return postalCodeError.getText();
    }
}

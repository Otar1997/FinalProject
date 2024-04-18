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

public class LoginPage {
    protected AndroidDriver driver;
    private final WebDriverWait wait;

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds wait
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Username\"]")
    private WebElement username;

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Password\"]")
    private WebElement password;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]")
    private WebElement loginBtn;
    @Step("ეს მეთოდი ავსებს ინფორმაციას მომხამრებელს და პაროლს")
    public void fillUsernameWithPassword(String user, String pass, boolean clickToBtn) {

        sendKey(user, username); // text  -  webElement
        sendKey(pass, password);// text  -  webElement

        if (clickToBtn) {
            clickToLogin();
        }
    }

    public void sendKey(String txt, WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(txt);
    }
    public void clickToLogin() {
        Helper.clickToBtn(loginBtn, driver);
    }
}
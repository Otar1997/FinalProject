package org.example.pages;

import io.appium.java_client.android.AndroidDriver;
import org.example.pages.Helper.Helper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinishPage {
    protected AndroidDriver driver;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-FINISH\"]")
    private WebElement finishButton;

    public FinishPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickFinish() {
        Helper.clickToBtn(finishButton, driver);
    }
}

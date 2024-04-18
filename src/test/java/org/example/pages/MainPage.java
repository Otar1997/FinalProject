package org.example.pages;

import io.appium.java_client.android.AndroidDriver;
import org.example.pages.Helper.Helper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    protected AndroidDriver driver;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView")
    private WebElement cart;
    @FindBy(xpath = "(//android.widget.TextView[@text=\"ADD TO CART\"])[1]")
    private WebElement item1AddToCart;
    @FindBy(xpath = "(//android.widget.TextView[@text=\"ADD TO CART\"])[2]")
    private WebElement item2AddToCart;
    @FindBy(xpath = "(//android.widget.TextView[@text=\"ADD TO CART\"])[3]")
    private WebElement item3AddToCart;
    @FindBy(xpath = "(//android.widget.TextView[@text=\"ADD TO CART\"])[4]")
    private WebElement item4AddToCart;
    @FindBy(xpath = "(//android.widget.TextView[@text=\"ADD TO CART\"])[5]")
    private WebElement item5AddToCart;
    @FindBy(xpath = "(//android.widget.TextView[@text=\"ADD TO CART\"])[6]")
    private WebElement item6AddToCart;

    public MainPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addToCartButtonClick(int itemNumber) {
        WebElement addToCart = item1AddToCart;
        if (itemNumber == 2) {
            addToCart = item2AddToCart;
        } else if (itemNumber == 3) {
            addToCart = item3AddToCart;
        } else if (itemNumber == 4) {
            addToCart = item4AddToCart;
        } else if (itemNumber == 5) {
            addToCart = item5AddToCart;
        } else if (itemNumber == 6) {
            addToCart = item6AddToCart;
        }
        Helper.clickToBtn(addToCart, driver);
    }

    public void goToCart() {
        Helper.clickToBtn(cart, driver);
    }
}

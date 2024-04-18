package org.example.tests;

import com.github.javafaker.Faker;
import io.qameta.allure.*;
import org.example.Base;
import org.example.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import static io.qameta.allure.SeverityLevel.CRITICAL;


public class LoginTest extends Base {


    @Test
    public void loginWithIncorrectUser() {
        LoginPage page = new LoginPage(driver);
        Faker faker = new Faker();
        String user = faker.name().firstName();
        String pass = faker.name().lastName();
        String expectedResult = "Username and password do not match any user in this service.";

        // Use the generated username and password for login
        page.fillUsernameWithPassword(user, pass, true);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Username and password do not match any user in this service.\"]")));
        Assert.assertEquals(error.getText(), expectedResult);
    }

    @Test
    @Description("This test attempts to log into the website using a login and a password. Fails if any error happens.\n\nNote that this test does not test 2-Factor Authentication.")
    @Severity(CRITICAL)
    @Owner("John Doe")
    @Link(name = "Website", url = "https://dev.example.com/")
    @Issue("AUTH-123")
    public void loginWithLockedUser() {
        LoginPage page = new LoginPage(driver);
        page.fillUsernameWithPassword("locked_out_user", "secret_sauce", true); // with locked user and correct password
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Sorry, this user has been locked out.\"]")));

        Assert.assertEquals(error.getText(), "Sorry, this user has been locked out.");
    }

    @Test
    public void loginWithCorrectUser() {
        LoginPage page = new LoginPage(driver);
        String user = conf.read("standardUser");
        String pass = conf.read("standardUserPass");
        page.fillUsernameWithPassword(user, pass, true);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc='test-Cart']")));

        Assert.assertNotNull(cart);
    }
}

package org.example;

import io.appium.java_client.android.AndroidDriver;
import org.example.config.Config;
import org.example.pages.LoginPage;
import org.example.pages.MainPage;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;

public class Base {
    public static AndroidDriver driver;

    public static Config conf = Config.getInstance();
    //Method to restart the app before each test method
    @BeforeMethod
    public static void restartApp() {
        driver.terminateApp(conf.read("appPackage"));
        driver.activateApp(conf.read("appPackage"));
    }
    //Method to set up the driver before test suite execution
    @BeforeSuite
    public static void setUp() throws MalformedURLException {
        System.out.println("დავიწყე კავშირის დამყარება");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("appium:automationName", "UiAutomator2"); // განვსაზღრეთ დრაივერის ტიპი.
        cap.setCapability("appium:udid", conf.read("udid")); // განვსაზღრეთ  მოწყობილობა
        cap.setCapability("appium:appPackage", conf.read("appPackage")); // განვსაზღრეთ აპლიკაციის ფექიჯის სახელი
        cap.setCapability("appium:appActivity", conf.read("appActivity")); // განვსაზღრეთ აპლიკაციის ექთივითი

        cap.setCapability("appium:skipUnlock", true); // მოვხსენით ბლოკი
        cap.setCapability("appium:noReset", true); // რესეთისგან თავის აცილება.
        cap.setCapability("appium:autoGrantPermissions", true); //  წვდომების მიცემა შესაბამის მოთხოვნებზე
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
        System.out.println("დავასრულე დრაივერის გამართვა");
    }

    //Method to tear down the driver after test suite execution
    @AfterSuite
    public void tearDown() {

        System.out.println("დავიწყე დრაივერის შემოწმება");
        if (driver != null) {
            System.out.println("დავიწყე დრაივერის გაუქმება");
            driver.quit(); // ხურავს დრაივერს.
            System.out.println("დრაივერი გაუქმებულია");
        }

    }
    //Method to add a product to the cart
    protected void addProduct(int itemNumber) {
        MainPage page = new MainPage(driver);
        page.addToCartButtonClick(itemNumber);
    }
    //Method to log in with provided credentials
    protected void logIn(String info) {
        if (info.equals("correct")) {
            LoginPage page = new LoginPage(driver);
            String user = conf.read("standardUser");
            String pass = conf.read("standardUserPass");
            page.fillUsernameWithPassword(user, pass, true);
        } else if (info.equals("problem")) {
            LoginPage page = new LoginPage(driver);
            String user = conf.read("problemUser");
            String pass = conf.read("problemUserPass");
            page.fillUsernameWithPassword(user, pass, true);
        }
    }
}

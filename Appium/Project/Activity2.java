package Project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Pipe;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Activity2 {
    AndroidDriver driver;
    WebDriverWait wait;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    // Test method
    @Test
    public void contactsTest() {

        driver.findElement(AppiumBy.id("new_note_button")).click();
        driver.findElement(AppiumBy.id("editable_title")).sendKeys("Tittle for Mobile testing");
        driver.findElement(AppiumBy.id("edit_note_text")).sendKeys("Boby for Mobile testing Google keep");

        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc='Navigate up']")).click();
        // Assertion
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.google.android.keep:id/index_note_title']")).click();

        String Tittle=driver.findElement(AppiumBy.id("editable_title")).getText();
        Assert.assertEquals(Tittle, "Tittle for Mobile testing");

           }

    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}

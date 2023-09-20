package Project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Activity1 {
    AndroidDriver driver;
    WebDriverWait wait;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
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

        // Create an ArrayList
        List<String> listStrings = new ArrayList<String>();
// Add values to it
        listStrings.add("Complete Activity with Google Tasks");
        listStrings.add("Complete Activity with Google Keep");
        listStrings.add("Complete the second Activity Google Keep");

//Create an Iterator
        Iterator<String> iterator = listStrings.iterator();

// Use it to loop through the ArrayList
        while (iterator.hasNext()) {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(AppiumBy.accessibilityId("Create new task")));
            driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(AppiumBy.id("add_task_title")));
            driver.findElement(AppiumBy.id("add_task_title")).sendKeys(iterator.next());
            driver.findElement(AppiumBy.id("add_task_done")).click();
        }

        List<WebElement> tasklist =driver.findElements(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.google.android.apps.tasks:id/task_name']"));
        Assert.assertEquals(tasklist.size(),3);

    }

    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}

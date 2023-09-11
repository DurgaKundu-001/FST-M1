package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;

public class Activity13_Java {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/tables");

        System.out.println("The title of the page is : " + driver.getTitle());
        List<WebElement> rows= driver.findElements(By.xpath("//div[2]/div[2]/table/tbody/tr"));
        System.out.println("The number of rows are : "+rows.size());

        List<WebElement> columns = driver.findElements(By.xpath("//div[2]/div[2]/table/tbody/tr[1]/td"));
        System.out.println("The number of columns  are : "+columns.size());

        List<WebElement> thirdrow=driver.findElements(By.xpath("//div[2]/div[2]/table/tbody/tr[3]"));
        System.out.println("The cell values in the third row of the table are: ");
        for(WebElement row3 : thirdrow){
            System.out.println(row3.getText());
        }
        String cell22=driver.findElement(By.xpath("//div[2]/div[2]/table/tbody/tr[2]/td[2]")).getText();
        System.out.println("The cell value at the second row second column is : "+cell22);
        driver.close();
    }
}

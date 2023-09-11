package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;

public class Activity14_Java {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/tables");
        System.out.println("The title of the page is : " + driver.getTitle());

        List<WebElement> row= driver.findElements(By.xpath("//div[3]/div[2]/table/tbody/tr"));
        System.out.println("The no of rows in the second table is : "+row.size());

        List<WebElement> col= driver.findElements(By.xpath("//div[3]/div[2]/table/tbody/tr[1]/td"));
        System.out.println("The no of rows in the second table is : "+col.size());

        WebElement cell22= driver.findElement(By.xpath("//div[3]/div[2]/table/tbody/tr[2]/td[2]"));
        System.out.println("The cell value at the second row second column is : "+cell22.getText());

        driver.findElement(By.xpath("//div[3]/div[2]/table/thead/tr/th[1]")).click();

        WebElement cell2= driver.findElement(By.xpath("//div[3]/div[2]/table/tbody/tr[2]/td[2]"));
        System.out.println("The cell value at the second row second column after sort is : "+cell2.getText());

        List<WebElement> footer= driver.findElements(By.xpath("//div[2]/div/div[3]/div[2]/table/tfoot/tr/th"));
        System.out.println("The cell values of the table footer are: ");
        for(WebElement value: footer){
            System.out.println(value.getText());
        }
        driver.close();
    }
}

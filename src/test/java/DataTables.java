import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class DataTables {
    private static final String URL = "http://the-internet.herokuapp.com/tables";
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(URL);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();

    }

    @Test
    public void talesTests() {
        String cell = driver.findElement(By.xpath("//table//tr[1]//td[1]")).getText();
        Assert.assertEquals(cell, "Smith");
        String cell1 = driver.findElement(By.xpath("//table//tr[1]//td[2]")).getText();
        Assert.assertEquals(cell1, "John");
        String cell2 = driver.findElement(By.xpath("//table//tr[2]//td[2]")).getText();
        Assert.assertEquals(cell2, "Frank");
        String cell3 = driver.findElement(By.xpath("//table//tr[3]//td[2]")).getText();
        Assert.assertEquals(cell3, "Jason");
        String cell4 = driver.findElement(By.xpath("//table//tr[4]//td[4]")).getText();
        Assert.assertEquals(cell4, "$50.00");


    }
}

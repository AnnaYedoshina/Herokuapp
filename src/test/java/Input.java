import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Input {
    private static final String URL = "http://the-internet.herokuapp.com/inputs";
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
    public void InputTests(){
        WebElement input;
        input = driver.findElement(By.tagName("input"));
        input.sendKeys("12");
        String keyResult = driver.findElement(By.tagName("input")).getAttribute("value");
        Assert.assertEquals(keyResult, "12");
        input.sendKeys(Keys.ARROW_UP);
        String upKeyResult = driver.findElement(By.tagName("input")).getAttribute("value");
        Assert.assertEquals(upKeyResult, "13");
        input.sendKeys(Keys.ARROW_DOWN);
        String downKeyResult = driver.findElement(By.tagName("input")).getAttribute("value");
        Assert.assertEquals(downKeyResult, "12");

        input.clear();
        input.sendKeys("asdsdvdfnbslfkg");
        String lettersResult = driver.findElement(By.tagName("input")).getAttribute("value");
        Assert.assertEquals(lettersResult, "");









    }
}

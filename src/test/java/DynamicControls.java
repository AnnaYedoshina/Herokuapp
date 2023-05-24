import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DynamicControls {
    private static final String URL = "http://the-internet.herokuapp.com/dynamic_controls";
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(URL);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();

    }

    public boolean isCheckboxIsNotPresent() {
        List<WebElement> checkboxes = driver.findElements(By.id("checkbox"));
        return checkboxes.size() == 0;

    }

    @Test
    public void dynamicControlTests() {
        WebElement removeButton = driver.findElement(By.xpath("//button[text() = 'Remove']"));
        removeButton.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//button[@autocomplete='off']//following-sibling::p")));
        Assert.assertTrue(isCheckboxIsNotPresent());
        WebElement input = driver.findElement(By.cssSelector("input[type=text]"));
        Assert.assertFalse(input.isEnabled());
        WebElement enableButton = driver.findElement(By.xpath("//button[text() = 'Enable']"));
        enableButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//button[@autocomplete='off']//following-sibling::p")));
        Assert.assertTrue(input.isEnabled());
    }
}
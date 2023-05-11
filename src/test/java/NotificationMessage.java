import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class NotificationMessage {
    private static final String URL = "http://the-internet.herokuapp.com/notification_message_rendered";
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
    public void notificationMessageTest(){
        WebElement notificationButton = driver.findElement(By.cssSelector(".example"));
        notificationButton.click();
        String notificationMessage = driver.findElement(By.id(".flash")).getText();
        Assert.assertEquals(notificationMessage, "Action successful");


    }
}

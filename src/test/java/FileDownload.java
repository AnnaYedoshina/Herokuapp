import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class FileDownload {
    private static final String URL = "http://the-internet.herokuapp.com/download";
    private WebDriver driver;
    private WebDriverWait wait;
    private ChromeOptions chromeOptions;

    public static boolean isFileExists(File file) {
        return file.isFile();
    }

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

    @Test
    public void fileDownloadTest() {
        WebElement link = driver.findElement(By.xpath("//a[text() = 'text.txt']"));
        link.click();
        ChromeOptions options = new ChromeOptions();
        options.setCapability("download.default_directory", System.getProperty("user.dir") + "/target/downloads");
        String filePath = "System.getProperty(user.dir) + /target/downloads";
        File file = new File(filePath);
        Assert.assertTrue(file.exists());
    }
}


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
import java.util.HashMap;

public class FileDownload {
    private static final String URL = "http://the-internet.herokuapp.com/download";
    private WebDriver driver;
    private WebDriverWait wait;

    public static boolean isFileExists(File file) {
        return file.isFile();
    }

    @BeforeClass
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        String downloadFilepath = System.getProperty("user.dir") + File.separator + "target/downloads";
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadFilepath);
        options.setExperimentalOption("prefs", chromePrefs);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(URL);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();

    }

    @Test
    public void fileDownloadTest() throws InterruptedException {
        String fileName = "test.txt";
        WebElement fileLink = driver.findElement(By.xpath(String.format("//a[text () = '%s']", fileName)));
        fileLink.click();
        Thread.sleep(3000);
        String filePath = System.getProperty("user.dir") + File.separator + "/target/downloads" + File.separator
                + fileName;
        File file = new File(filePath);
        Assert.assertTrue(file.exists());
    }
}


import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Dropdown {
    private static final String URL = "http://the-internet.herokuapp.com/dropdown";
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
    public void dropDown() {
//        WebElement dropdown = driver.findElement(By.id("dropdown"));
//        Select select = new Select(dropdown);
//        List<WebElement> optionsList = select.getAllSelectedOptions();
//        List<String> optionTexts = new ArrayList<>();
//        for (WebElement option : optionsList) {
//            optionTexts.add(option.getText());
//        }
//        String[] options = {"Option 1","Option 2"};
//        Assert.assertEquals(optionTexts, options);
//        optionsList.get(0).click();
//        Assert.assertTrue(optionsList.get(0).isSelected());
//        optionsList.get(1).click();
//        Assert.assertTrue(optionsList.get(1).isSelected());

        WebElement dropdown = driver.findElement(By.cssSelector("#dropdown"));
        Select select = new Select(dropdown);
        List<WebElement> optionsList = select.getOptions();
        optionsList.get(0).click();
        Assert.assertTrue(optionsList.get(0).isSelected());
        optionsList.get(1).click();
        Assert.assertTrue(optionsList.get(1).isSelected());
        Assert.assertEquals(optionsList.size(), 3);
        Assert.assertEquals(optionsList.get(0).getText(), "Please select an option");
        Assert.assertEquals(optionsList.get(1).getText(), "Option 1");
        Assert.assertEquals(optionsList.get(2).getText(), "Option 2");

        select.selectByVisibleText("Option 1");
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Option 1");

        select.selectByVisibleText("Option 2");
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Option 2");



    }


}

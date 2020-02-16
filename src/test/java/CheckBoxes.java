import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class CheckBoxes {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    /*
    Проверить, что первый чекбокс unchecked, отметить первый чекбокс, проверить что он checked.
    Проверить, что второй чекбокс checked, сделать unсheck, проверить, что он unchecked

     */
    @Test
    public void checkBoxesTest() {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        By checkboxes = By.tagName("input");
        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));
        assertEquals(checkBoxes.get(0).isSelected(), false, "the 1st checkbox is unchecked");
        checkBoxes.get(0).click();
        assertEquals(checkBoxes.get(0).isSelected(), true, "the 1st checkbox is checked");
        assertEquals(checkBoxes.get(1).isSelected(), true, "the 2nd checkbox is checked");
        checkBoxes.get(1).click();
        assertEquals(checkBoxes.get(1).isSelected(), false, "the 2nd checkbox is unchecked");
    }
}
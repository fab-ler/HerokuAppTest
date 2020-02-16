import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class Inputs {
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
    Проверить на возможность ввести различные цифровые и нецифровые значения, используя Keys.ARROW_UP  И Keys.ARROW_DOWN
     */

    @Test
    public void inputsTest() {
        driver.get("http://the-internet.herokuapp.com/inputs");
        driver.findElement(By.xpath("//input")).sendKeys(Keys.ARROW_UP);
        String firstResult = driver.findElement(By.xpath("//input")).getAttribute("value");
        assertEquals(firstResult, "1");
        driver.findElement(By.xpath("//input")).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN);
        String secondResult = driver.findElement(By.xpath("//input")).getAttribute("value");
        assertEquals(secondResult, "-3");

        // проверить ручной ввод буквенных симолов
        driver.navigate().refresh();
        driver.findElement(By.xpath("//input")).sendKeys("two");
        String thirdResult = driver.findElement(By.xpath("//input")).getAttribute("value");
        assertEquals(thirdResult, "", "Manual input of chars is disabled");
    }
}
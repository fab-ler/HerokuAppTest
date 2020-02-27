import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Typos {
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
     Проверить соответствие параграфа орфографии
     */

    @Test
    public void typosTest() {
        driver.get("http://the-internet.herokuapp.com/typos");
        for (int i = 0; i < 10; i++) {
            driver.navigate().refresh();
            String withOrWithoutTypoText = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p[2]")).getText();
            assertEquals(withOrWithoutTypoText, "Sometimes you'll see a typo, other times you won't.", "Error: the word 'won,t' is misspelled");
        }
    }
}
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class NotificationMessages {
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
    кликнуть на кнопку, дождаться появления нотификации, проверить соответствие текста ожиданиям
     */


    //"не сработал клик по кнопке, либо не верное сообщение"
    @Test
    public void notificationMessagesTest() {
        driver.get("http://the-internet.herokuapp.com/notification_message");
        driver.findElement(By.cssSelector(".example a")).click();
        String message = driver.findElement(By.cssSelector(".flash")).getText();
        assertEquals(message, "Action unsuccesful, please try again\n" + "×");
    }
}
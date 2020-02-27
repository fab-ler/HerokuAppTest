import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AddRemoveElements {
    private WebDriver browser;

    @BeforeTest
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        browser = new ChromeDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        browser.quit();
    }

    /*
    добавить 2 элемента, удалить элемент, проверить количество элементов
    Локаторы xpath:
    By.xpath(“//button[text()=’Add Element’]”)
    By.xpath(“//*[text()=’Add Element’]”)
    By.xpath(“//*[@onclick=’addElement()’]”)
     */

    @Test
    public void addRemoveElementsTest() {
        browser.get("http://the-internet.herokuapp.com/add_remove_elements/");
        By addManually = By.xpath("//button[text()='Add Element']");
        browser.findElement(addManually).click();
        browser.findElement(addManually).click();
        browser.findElement(By.className("added-manually")).click();
        int deletedButtonsQuantity = browser.findElements(By.className("added-manually")).size();
        assertEquals(deletedButtonsQuantity, 1, "One button is remaining");
    }
}

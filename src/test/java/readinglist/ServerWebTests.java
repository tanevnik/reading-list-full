package readinglist;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ServerWebTests {

    private static ChromeDriver chrome;

    @BeforeClass
    public static void openBrowser() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ntanev\\Downloads\\chromedriver.exe");
        chrome = new ChromeDriver();
        chrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterClass
    public static void closeBrowser() {
        chrome.quit();
    }

    @Test
    public void addBookToEmptyList() {
        String baseUrl = "http://localhost:8080";

        chrome.get(baseUrl);
        Assert.assertEquals("Login With Username and Password", chrome.findElementByTagName("h3").getText());

        chrome.findElementByName("username").sendKeys("user");
        chrome.findElementByName("password").sendKeys("user");
        chrome.findElementByTagName("form").submit();

        Assert.assertEquals("Add a book", chrome.findElementByTagName("h3").getText());
    }

}

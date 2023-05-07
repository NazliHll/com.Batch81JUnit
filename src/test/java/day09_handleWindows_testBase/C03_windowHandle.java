package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_windowHandle {
     /*
    1.https://the-internet.herokuapp.com/windows adresine gidin
    2.Sayfadaki textin "Opening a new window" olduğunu doğrulayın.
    3.Sayfa başlığının "The Internet" olduğunu doğrulayın.
    4.Click here butonuna basın.
    5.Açılan yeni pencerinin sayfa başlığının "New Windoww" olduğunu doğrulayın.
    6.Saydaki textin "New Window" olduğunu doğrulayın.
    7.Bir önceki pencereye geri döndükten sonra sayfa başlığının "The Internet" olduğunu doğrulayın.
     */

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test1() {

        // 1.https://the-internet.herokuapp.com/windows adresine gidin
        driver.get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaWindowHandleDegeri = driver.getWindowHandle();
        //2.Sayfadaki textin "Opening a new window" olduğunu doğrulayın.
        WebElement sayfadakiYaziElementi = driver.findElement(By.xpath("//h3"));
        String expectedYazi = "Opening a new window";
        String actualYazi = sayfadakiYaziElementi.getText();
        Assert.assertEquals(expectedYazi, actualYazi);

    }
}

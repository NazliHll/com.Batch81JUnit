package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_handleWindows {
    /*
   1. amazon sayfasına gidelim.
   2.url'in amazon içerdiğini test edelim.
   3.yeni bir sayfa açıp bestbuy anasayfasına gidelim.
   4.title'ın Best Buy içerdiğini test edelim.
   5.ilk sayfaya dönüp sayfada java aratalım.
   6.arama sonuçlarının java içerdiğini test edelim.
   7.yeniden bestbuy'ın açık olduğu sayfaya gidelim.
   8.logonun göründüğünü test edelim.
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
       // driver.quit();
    }
    @Test
    public void test1() {
        //1-amazona gidin.
        driver.get("https://amazon.com");
        String istenenKelime="amazon";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(istenenKelime));
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://bestbuy.com");
        String actualTitle= driver.getTitle();
        String arananKelime="Best Buy";
        Assert.assertTrue(actualTitle.contains(arananKelime));


    }
}

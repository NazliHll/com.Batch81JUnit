package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.Temperature;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BeforeAfter {
    /*
Before-After Notasyonları ile testimizden önce ve sonra çalışacakları organize edebiliyoruz.
 */
    WebDriver driver=new ChromeDriver();
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        driver.close();
    }
    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
    }
    @Test
    public void test02(){
        driver.get("https://www.instagram.com");
    }
    @Test
    public void test03(){
        driver.get("https://www.facebook.com");
    }
}

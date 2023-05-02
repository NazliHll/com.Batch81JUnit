package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {
    /*
    Amazon sayfasına gidin
    3 farklı test methodu oluşturarak aşağıdaki görevleri yapın
    1-Url'nin amazon içerdiğini test edin
    2-Title'ın facebook içermediğini test edin
    3-sol üst köşede amazon logosunun göründüğünü test edin.
            */

   static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }
    @AfterClass
    public static void tearDown(){
       driver.close();
    }

    @Test
    public void test01(){
        String arananKelime="amazon";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(arananKelime));

    }
    @Test
    public void test02(){
        String istenmeyenKelime="facebook";
        String actualTitle= driver.getTitle();
        Assert.assertFalse(actualTitle.contains(istenmeyenKelime));
    }
    @Test
    public void test03(){
        WebElement logo=driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed());

    }


}

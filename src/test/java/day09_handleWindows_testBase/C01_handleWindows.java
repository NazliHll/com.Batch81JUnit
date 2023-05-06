package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_handleWindows {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        System.out.println(driver.getWindowHandle());
         /*
        736BDF8004415AE2D76DAB9226777825 bu kod açılan sayfanın unique hash kodudur.
        Selenium sayfalar arası geçişte bu handle değerini kullanır.
        Eğer sayfalar arasında driverımızı gezdiriyorsak veya herhangi bir sayfadan
        şuanda bulunduğumuz sayfaya geçmek istiyorsak
        driver.switchTo().window("736BDF8004415AE2D76DAB9226777825");
        bu sayfanın window handle değerini girerek bu sayfaya geçiş yapabiliriz.
         */

        driver.switchTo().window()
    }
}

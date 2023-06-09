package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

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
        String ilkSayfaHandleDegeri = driver.getWindowHandle();
         /*
       BE8073589DB381F0A21AB696BCFD96A6 bu kod açılan sayfanın unique hash kodudur.
        Selenium sayfalar arası geçişte bu handle değerini kullanır.
        Eğer sayfalar arasında driverımızı gezdiriyorsak veya herhangi bir sayfadan
        şuanda bulunduğumuz sayfaya geçmek istiyorsak
        driver.switchTo().window("BE8073589DB381F0A21AB696BCFD96A6");
        bu sayfanın window handle değerini girerek bu sayfaya geçiş yapabiliriz.
         */
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);

        WebElement ilElementFoto=driver.findElement(By.xpath("(//img[@class='s-image'])[1]"));

        driver.switchTo().newWindow(WindowType.TAB);
        System.out.println("driver'in urlsi"+ driver.getCurrentUrl());

         /*
        Bu komutu kullandığımızda driver otomatik olarak oluşturulannew Tab a tıklar
        yeni Tab'da görevi gerçekleştirmek için adımları baştan almamız gerekir.
         */
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();

        WebElement urunTitle= driver.findElement(By.xpath("//span[@id='productTitle']"));
        System.out.println(urunTitle.getText());

        driver.switchTo().window(ilkSayfaHandleDegeri);
        System.out.println(driver.getCurrentUrl());




    }
}

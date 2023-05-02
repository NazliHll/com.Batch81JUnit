package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertions {
    /*
   JUnit'in bize getirdiği 2 tane yenilik vardı
   ı.Before-After
   ıı.Assertion-if-else tarih oldu artık assertionlarla bu işlemleri yapacağız
    */
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
        driver.close();
    }
    @Test
    public void test01(){
         /*
        Eğer test methodumuzda hiçbir test yoksa test çalıştıktan sonra
        hiçbir problemle karşılaşılmadığını raporlamak için"test passed" yazısı çıkar.
        Eğer testlerii if ile yaparsak test failed olsa bile kodlar problemsiz çalıştığı için ekranın sol alt tarafında test passed yapar.
         */
        driver.get("https://www.amazon.com");

         /*url'nin https://facebook.com olduğunu test edin.
        if(driver.getCurrentUrl().equals("https://facebook.com")){
            System.out.println("url testi PASSED");
        }else {
            System.out.println("url testi FAILED");
        }*/

        String expectedUrl="https://www.facebook.com";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("Url beklenenden farklı :", expectedUrl, actualUrl);//istersek başa bir mesaj yazabiliriz/bu mesaj sadece failed olduğunda çıkar
        //Assert Classı JUnit'den geliyor artık if-else bloklarına ihtiyacımız kalmadı.
        /*
        Assert ile yaptığımız testlerde assertion failed olursa Java
        kodları çalışmayı durdurur ve Assert Classı bizi hata konusunda bilgilendirir.

        org.junit.ComparisonFailure: Url beklenenden farklı :
        Expected :https://facebook.com
        Actual   :https://www.amazon.com/
        <Click to see difference>
         */
        /*
         Kod hiçbir assertion ile karşılaşmayıp doğru olarak çalıştığından istediğimiz test failed olsa da
         test passed dedi.
          */
    }
}

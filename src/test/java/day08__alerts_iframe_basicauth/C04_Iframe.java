package day08__alerts_iframe_basicauth;

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

public class C04_Iframe {
     /*
    bir method oluşturun: iframetest
    *An IFrame containing... ." textinin erişilebilir olduğunu test edin ve konsolda yazdırın
    *text box'a  "Merhaba Dunya!" yazın.
    *Text Box'ın altında bulunan "Elemental Selenium" linkinin textinin görünür olduğunu doğrulayın ve konsolda yazdırın
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
      //  driver.quit();
    }
    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement baslikElement=driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(baslikElement.isEnabled());
        System.out.println(baslikElement.getText());

        // *text box'a  "Merhaba Dunya!" yazın.
        //*text box'ı doğru locate etmemize rağmen driver bulamadı
        //bunun üzerine html kodlarını incelediğimizde  text box'ın aslında bir iframe içerisinde olduğunu gördük
        //bu durumda önce iframe i locate edip switchTo ile o iframe e geçmeliyiz.

        WebElement iframeElementi=driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframeElementi);

        WebElement textKutusu=driver.findElement(By.xpath("//body[@id='tinymce']"));
        textKutusu.clear();
        textKutusu.sendKeys("Merhaba Dünya");

        //*Text Box'ın altında bulunan "Elemental Selenium" linkinin textinin görünür olduğunu doğrulayın ve konsolda yazdırın
        //Link yazı elementini doğru olmasına ragmen yazdırmadı, çünkü yukarıda ifram'e geçis yapmıştık
        // bu durumda önce iframe i locate edip switchTo ile o iframe e geçmeliyiz.
        driver.switchTo().defaultContent();


        WebElement linkYazi=driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(linkYazi.isDisplayed());
        System.out.println(linkYazi.getText());

    }
}

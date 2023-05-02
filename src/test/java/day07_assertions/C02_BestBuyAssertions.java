package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BestBuyAssertions {
     /*
     https://www.bestbuy.com/ adresine gidin farkli test method’lari olusturarak asagidaki
    testleri yapin
     -sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
     - titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
     -logoTest => BestBuy logosunun görüntülendigini test edin
     - FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
     */
     static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.bestbuy.com/");
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    @Test
    public void test01(){
        String expectedUrl="https://www.bestbuy.com/";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }
    @Test
    public void test02(){
        String istenmeyenKelime="Rest";
        String actualTitle=driver.getTitle();
        Assert.assertFalse(actualTitle.contains(istenmeyenKelime));
    }
    @Test
    public void test03(){
        WebElement logoElement= driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logoElement.isDisplayed());
    }
    @Test
    public void test04(){
        WebElement francaisElement= driver.findElement(By.xpath("//*[text()='Français']"));
        Assert.assertTrue(francaisElement.isDisplayed());
    }
}

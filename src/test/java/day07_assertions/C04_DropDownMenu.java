package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_DropDownMenu {
     /*
    ı.Amazon'a gidip dropdown'dan books seçeneğini seçip   "Java" aratalım.
    Ve arama sonuçlarının Java içerdiğini test edelim.
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
       driver.quit();
    }
    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        /*
        dropdown dan bir options seçmek için 3adım vardır.
        1.adım : Dropdown'ı locate edelim.
         */
        WebElement ddm=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
         /*
        2.adım : Bir select objesi oluşturup parametre olarak bir önceki adımda locate'ini aldığımız
        "ddm"'yi girelim
         */
        Select select=new Select(ddm);


        //3. adım : Dropdown'da var olan option'lardan istediğimiz bir taneyi seçelim.
        select.selectByVisibleText("Books");
       // select.selectByIndex(5);
        //select.selectByValue("search-alias=stripbooks-intl-ship");

    }

}

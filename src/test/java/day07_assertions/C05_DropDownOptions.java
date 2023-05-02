package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C05_DropDownOptions {
    /*
    1-Amazon anasayfaya gidip dropdown menuden books'u seçelim
    seçtiğimiz option'u yazdıralım
    2-Dropdowndaki options'ların sayısının 20 olduğunu test edelim.
     */

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://amazon.com");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void test01(){
        WebElement ddm=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(ddm);
        select.selectByVisibleText("Books");

        System.out.println(select.getFirstSelectedOption().getText());//son seçilen option->getFirstSelectedOption(). dediğimizde bize WebElement döndürür ,referans yazdırır
        //getText() yazdığımızda seçtiğimiz option'u yazdırırız

       ///2-Dropdowndaki options'ların sayısının 28 olduğunu test edelim
        // select.getOptions();list döndürür--> WebElementlerden oluşan bir liste yapalım

        List<WebElement> optionList=select.getOptions();

        int actualOptionSayisi=optionList.size();
        int expectedOptionSayisi=28;

        Assert.assertEquals(expectedOptionSayisi,actualOptionSayisi);


        /*
                        DropDown menuye ulasmak icin select class'indan bir obje olustururuz
                        ve locate ettigimiz dropdown webelement'inin select class'ina tanimlariz
                        ve getOption methodunu kullanarak dropdown'u bir liste atarak dropdown menunun
                        butun elemanlarının sayısına ulasabiliriz
         */

    }

}

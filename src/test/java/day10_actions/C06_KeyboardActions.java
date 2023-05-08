package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_KeyboardActions extends TestBase {
    //facebook anasayfaya gidip
    //yeni kayıt oluştur butonuna basın
    //isim kutusunu locate edip
    //geriye kalanları TAB ile dolasarak
    //formu doldursun

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://facebook.com");
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
        WebElement isimKutusu=driver.findElement(By.xpath("//input[@name='firstname']"));

        Actions actions=new Actions(driver);
        actions.click(isimKutusu)
                .sendKeys("Nazlı")
                .sendKeys(Keys.TAB)
                .sendKeys("YAŞAR")
                .sendKeys(Keys.TAB)
                .sendKeys("nazli@gmail.com").perform();
        Thread.sleep(5000);
    }
}



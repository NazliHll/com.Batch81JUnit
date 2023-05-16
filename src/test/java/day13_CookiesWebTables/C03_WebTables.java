package day13_CookiesWebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_WebTables extends TestBase {
    @Test
    public void dinamikYazici() {


        //onceki classtaki adrese gidip
        //girisYap methodunu kullanarak sayfaya giris yapin
        //input olarak verilen satir sayisi ve sutun sayisina sahip
        //celldeki texti yazdirin

        int satir = 3;
        int sutun = 5;
        girisYap();

        WebElement arananCell=driver.findElement(By.xpath("//tbody//tr[3]//td[5]"));
        System.out.println(arananCell.getText());


    }
    public void girisYap() {
        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.xpath("//button[@id='details-button']")).click();
        driver.findElement(By.xpath("//a[@id='proceed-link']")).click();
        driver.findElement(By.linkText("Log in")).click();
        Actions actions =new Actions(driver);
        WebElement username=driver.findElement(By.id("UserName"));
        actions.click(username).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).
                perform();
    }
}

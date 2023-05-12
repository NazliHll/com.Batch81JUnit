package day13_CookiesWebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C02_WebTables extends TestBase {
      /*
     login( ) metodun oluşturun ve oturum açın.
     https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
     Username : manager
     Password : Manager1!
     table( ) metodu oluşturun
     Tüm table body’sinin boyutunu(sutun sayisi) bulun.
     Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
     printRows( ) metodu oluşturun //tr table body’sinde bulunan toplam satir(row) sayısını bulun.
     Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
     4.satirdaki(row) elementleri konsolda yazdırın.
     */

    @Test
    public void webTables() {

        girisYap();

        List<WebElement> sutunBasliklari=driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("sutun sayisi: "+sutunBasliklari.size());

        WebElement tumBody=driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBody.getText());

        List<WebElement>satirlarListesi=driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("satir sayisi: "+satirlarListesi.size());
        for (WebElement each:satirlarListesi
             ) {
            System.out.println(each.getText());
        }
        List<WebElement>cellList=driver.findElements(By.xpath("//tbody//tr[4]//td"));
        for (WebElement each:cellList
             ) {
            System.out.println(each.getText());
        }
        //email basligindaki tum elementleri(sutun) konsolda yazdirin.
        List<WebElement>basliklar=driver.findElements(By.xpath("//thead//tr[1]//th"));
        int emailSutunNo=0;
        for (int i = 0; i < basliklar.size() ; i++) {
            if (basliklar.get(i).getText().equals("Email")){
                emailSutunNo=i;
            }
        }
        List<WebElement>emailSutun=driver.findElements(By.xpath("//tbody//td["+(emailSutunNo+1)+"]"));
        

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

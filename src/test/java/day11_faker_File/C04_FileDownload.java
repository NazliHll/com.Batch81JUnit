package day11_faker_File;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {
     /*

    1.downloadTest() methodunun içindei testi yapalım:
    --https://the-internet.herokuapp.com/download adresine gidelim
    --some-file.txt dosyasını indirelim
    2.Ardından isExist() methodunda dosyanın başarıyla indirilip indirilmediğini test edelim.
     */

    @Test
    public void test01() throws InterruptedException {
      driver.get("https://the-internet.herokuapp.com/download");

        WebElement someFileLinki= driver.findElement(By.xpath("//a[text()='some-file.txt']"));
        someFileLinki.click();
        Thread.sleep(5000);

        String farkliKisim=System.getProperty("user.home");
        String ortakKisim="\\Downloads\\some-file.txt";

        String arananDosyaYolu=farkliKisim+ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(arananDosyaYolu)));



    }
}

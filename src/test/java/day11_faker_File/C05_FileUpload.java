package day11_faker_File;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_FileUpload extends TestBase {
     /*
    -https://the-internet.herokuapp.com/upload sayfasına git
    -chooseFile butonuna basalım.
    -Yüklemek istediğimiz dosyayı seçelim*(Bu işlemi selenium ile yapma şansımız yok)

   **
   Çünkü web tabanlı bir uygulama değil. sendKeys methodu imdadımıza yetişir.
   eğer chooseFile butonun var olan bi dosyanın dosya yolunu yollarsanız
   seçme işlemi otomatik olarak yapılmış olacaktır.

   **

    -Upload butonuna basalım
    -"File Uploaded!" textinin görüntülendiğini test edelim.
     */
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement dosyaSec= driver.findElement(By.id("file-upload"));
        String farkliKisim=System.getProperty("user.home");
        String ortakKisim="\\OneDrive\\Masaüstü\\text.txt";

        String yuklenecekDosya=farkliKisim+ortakKisim;
        dosyaSec.sendKeys(yuklenecekDosya);

        Thread.sleep(5000);
    }

}

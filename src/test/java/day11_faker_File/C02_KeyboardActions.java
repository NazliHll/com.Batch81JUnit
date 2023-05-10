package day11_faker_File;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_KeyboardActions extends TestBase {
     /*
        1.https://html.com/tags/iframe/ sayfasına gidelim
        2.videoyu görecek kadar aşağıya in
        3.videoyu izlemek için play tuşuna basın
        4.videoyu çalıştırdığınızı test edin
         */
    @Test
    public void test01(){

        driver.get("https://html.com/tags/iframe/");
        WebElement iframe=driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();


    }


}

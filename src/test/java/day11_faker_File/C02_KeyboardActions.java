package day11_faker_File;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .perform();
        WebElement iframe=driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();

        WebElement youTubeLinki = driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youTubeLinki.isDisplayed());


    }


}

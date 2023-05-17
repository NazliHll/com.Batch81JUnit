package day15_writeExcel_screenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C02_TumSayfaScreenShot extends TestBase {
    @Test
    public void tumSayfa() throws IOException {
        driver.get("https://www.amazon.com");
        TakesScreenshot ts= (TakesScreenshot) driver;
        LocalDateTime date=LocalDateTime.now();
        System.out.println(date);
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih=date.format(dtf);
        System.out.println(tarih);
        File tumSayfaResim=new File("target/ekranGoruntuleri/tumSayfa"+tarih+".jpeg");
        File resimGecici=ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(resimGecici,tumSayfaResim);
    }
}

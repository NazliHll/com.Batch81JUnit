package day12_Synchronization_Waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_ExplicitlyWait extends TestBase {
     /*
    iki method oluşturun implicitWait(),explicitWait()
    iki method için aşağıdaki adımları test edin

    1.https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    2.Remove butonuna basin.
    3.“It’s gone!” mesajinin goruntulendigini dogrulayin.
    4.Add buttonuna basin
    5.It’s back mesajinin gorundugunu test edin
     */
    @Test
    public void implicitWaitTest(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
        WebElement itsGone=driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        Assert.assertTrue(itsGone.isDisplayed());
        driver.findElement(By.xpath("//button[text()=\"Add\"]")).click();
        WebElement itsBack= driver.findElement(By.xpath("//p[text()=\"It's back!\"]"));
        Assert.assertTrue(itsBack.isDisplayed());








    }
}

package day12_Synchronization_Waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_ExplicitlyWait extends TestBase {
    /*bir class olusturun:EnableTest
    bir method olusturun:isEnabled()
    https://the-internet.herokuapp.com/dynamic_controls adresine gidin
    Textbox'in etkin olmadigini(enabled) dogrulayin
    Enable butonuna tiklayin ve textbox etkin oluncaya kadar bekleyin
    "It's enabled!" mesajinin goruntulendigini dogrulayin
    TextBox'in etkin oldugunu(enabled)dogrulayin
     */

    @Test
    public void enableTest() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement enableKutusu= driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(enableKutusu.isEnabled());
        driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(enableKutusu));

        WebElement itsEnable= driver.findElement(By.xpath("//p[text()=\"It's enabled!\"]"));
        Assert.assertTrue(itsEnable.isDisplayed());
        Assert.assertTrue(enableKutusu.isEnabled());
    }
}

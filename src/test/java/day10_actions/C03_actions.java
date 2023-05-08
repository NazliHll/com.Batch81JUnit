package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C03_actions extends TestBase {
     /*
    1.https://the-internet.herokuapp.com/context_menu sitesine gidelim
    2.Cizili alan uzerinde sag click yapalim
    3.Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
    4.Tamam diyerek alert’i kapatalim
    5.Elemental Selenium linkine tiklayalim
    6.Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
     */

    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/context_menu");
        Actions actions=new Actions(driver);
        WebElement cizgiliAlan=driver.findElement(By.id("hot-spot"));
        actions.contextClick(cizgiliAlan).perform();

        String expectedYazi="You selected a context menu";
        String actualYazi=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedYazi,actualYazi);

        driver.switchTo().alert().accept();
        
        String ilkSayfaDegeri= driver.getWindowHandle();
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        Set<String> handleSet=driver.getWindowHandles();
        String ikinciSayfaDegeri="";
        System.out.println(handleSet);

        for (String each:handleSet
             ) {
            if (!each.equals(ilkSayfaDegeri)){
                ikinciSayfaDegeri=each;
            }
        }

        driver.switchTo().window(ikinciSayfaDegeri);
        WebElement yaziElementi= driver.findElement(By.xpath("//h1"));
        String expectedIkinciYazi="Elemental Selenium";
        String actualIkinciYazi=yaziElementi.getText();
        Assert.assertEquals(expectedIkinciYazi,actualIkinciYazi);

        

    }

}

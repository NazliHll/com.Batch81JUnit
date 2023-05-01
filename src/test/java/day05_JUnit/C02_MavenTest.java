package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_MavenTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. http://zero.webappsecurity.com/ sayfasına gidin
        driver.get(" http://zero.webappsecurity.com/");
        //2. Signin butonuna tıklayın
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
        //3. Login alanına "username" yazdırın.
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");
        //4. Password alanına "password" yazdırın.
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");
        //5. Signin butonuna tıklayın.
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        driver.navigate().back();
        //6. Pay Bills sayfasına gidin.
        driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();
        //7. amaunt kısmına yazdırmak istediğiniz miktarı yazdırın
        driver.findElement(By.xpath("//input[@name='amount']")).sendKeys("500");
        //8. Tarih kısmına "2023-05-01" yazdırın
        driver.findElement(By.xpath("//input[@id='sp_date']")).sendKeys("2023-05-01");
        //9. Pay butonuna tıklayın.
        driver.findElement(By.id("pay_saved_payees")).click();

        //10. "The payment was succesfully submitted." mesajının çıktığını kontrol edin.
        WebElement sonucYazisi= driver.findElement(By.xpath("//div[@id='alert_content']"));

        if (sonucYazisi.isDisplayed()){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
        }
        driver.close();

    }
}

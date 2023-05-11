package day13_CookiesWebTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C01_CookiesAutomation extends TestBase {
    /*
    1-Amazon anasayfaya gidin
    2-tum cookie’leri listeleyin
    3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
    4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
    5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
    6-eklediginiz cookie’nin sayfaya eklendigini test edin
    7-ismi skin olan cookie’yi silin ve silindigini test edin
    8-tum cookie’leri silin ve silindigini test edin
     */

    @Test
    public void cookiesTest() {
        driver.get("https://www.amazon.com");
        Set<Cookie> cookieSet=driver.manage().getCookies();
        System.out.println(cookieSet);
        int sayac=1;
        for (Cookie each:cookieSet
             ) {
            System.out.println(sayac+".ci cookie: "+ each);
            System.out.println("name: "+each.getName());
            System.out.println("value: "+each.getValue());
            sayac++;
        }

        int cookieSayisi=cookieSet.size();
        Assert.assertTrue(cookieSayisi>5);

        for (Cookie each:cookieSet
             ) {
            if (each.getName().equals("i18n-prefs")){
                Assert.assertEquals("USD",each.getValue());
            }
        }
        Cookie cookie=new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(cookie);
        cookieSet=driver.manage().getCookies();
        sayac=1;
        for (Cookie each:cookieSet
        ) {
            System.out.println(sayac+".ci cookie: "+ each);
            sayac++;
        }
        Assert.assertTrue(cookieSet.contains(cookie));
        driver.manage().deleteCookieNamed("skin");
        Assert.assertFalse(cookieSet.contains("skin"));
        driver.manage().deleteAllCookies();
        cookieSet=driver.manage().getCookies();
        Assert.assertTrue(cookieSet.isEmpty());

    }
}

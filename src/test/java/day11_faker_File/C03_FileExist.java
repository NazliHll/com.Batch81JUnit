package day11_faker_File;

import org.junit.Test;

public class C03_FileExist {
    @Test
    public void test01(){
        System.out.println(System.getProperty("user.dir"));
        //C:\Users\nazli\IdeaProjects\com.Batch81JUnit
        System.out.println(System.getProperty("user.home"));
        //C:\Users\nazli

        //masaüstümüzdeki text dosyasının varlığını test edelim
        //"C:\Users\nazli\OneDrive\Masaüstü\text.txt"
        String dosyaYolu=System.getProperty("user.home")+"\\OneDrive\\Masaüstü\\text.txt";
        System.out.println(dosyaYolu);

         /*
        bilgisayramızdaki bir dosyanın varlığını test etmemiz için once o dosyaya ulaşmamız gerekir

        Javada dosya erişimi için dosya yoluna (path) ihtiyaç vardır.

        Her bilgisayarın kullanıcı adı farklı olacağından masaustu dosya yolu birbirinden farklı olacaktır

        Testlerimizn tüm bilgisayarlarda çalışması için dosya yolunu dinamik yapmak zorundayız.

        Bunun için
            her bilgisayarın birbirinden farklı olan yolunu bulmak adına

         */
    }
}

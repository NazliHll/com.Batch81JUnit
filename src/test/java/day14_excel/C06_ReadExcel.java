package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C06_ReadExcel {
    @Test
    public void readExcelTest() throws IOException {
         /*
    Excel dosyasındaki tüm verileri clasımıza alıp bir Java objesine store edelim
    böylece her seferinde excel'e ulaşıp satır,sutun vs... uğraşmayalım
    Bunun için map yapıcaz : key ve valuelere ihtiyacımız var

    Database yapısında olan exceli koyabileceğimiz en uygun Java objesi Map
     */
        Map<String,String> ulkelerMap=new HashMap<>();
        String dosyaYolu="src/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        int sonSatirIndex=workbook.getSheet("Sayfa1").getLastRowNum();

        for (int i = 0; i <=sonSatirIndex ; i++) {
            String key=workbook.getSheet("Sayfa1")
                    .getRow(i).getCell(0).toString();

            String value=workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()
                    +", "
                    +workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()
                    +", "
                    +workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            ulkelerMap.put(key,value);
            System.out.println(key+ " , "+value);

        }
        System.out.println(ulkelerMap);

        //


    }
}

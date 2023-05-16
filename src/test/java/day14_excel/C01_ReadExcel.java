package day14_excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {
    @Test
    public void readExcelTest() throws IOException {
        /* Dosya yolunu bir String degiskene atayalim
         FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
         Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Sheet objesi olusturun workbook.getSheetAt(index)
         Row objesi olusturun sheet.getRow(index)
        Cell objesi olusturun row.getCell(index)
        3.index'deki satırın  3. indexindeki datanın Cezayir olduğunu test edin.*/

        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        Sheet sheet=workbook.getSheet("Sayfa1");
        Row row=sheet.getRow(3);
        Cell cell=row.getCell(3);

        System.out.println(cell);

        String expectedData="Cezayir";
        String actualData=cell.toString();
        Assert.assertEquals(expectedData,actualData);






    }
}

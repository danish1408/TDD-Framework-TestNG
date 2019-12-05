package WebManager;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

public class ExcelDemo {

   static FileInputStream fis;
   static String username[];
    static String password[];

    public static void main(String[] args) throws Exception {



      File  src = new File("C:\\Users\\DANISH\\Documents\\TestData.xlsx");

        try {
            fis= new FileInputStream(src);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        XSSFWorkbook wb= new XSSFWorkbook(fis);

        wb.createSheet("test");

       XSSFSheet sh1= wb.getSheetAt(0);

        password = new String[sh1.getLastRowNum()];
        username = new String[sh1.getLastRowNum()];


        Iterator<Row> rowit = sh1.iterator();

        rowit.next();

        int i=0;

        while (rowit.hasNext()){




         username[i]=   rowit.next().getCell(0).getStringCellValue();



         i++;
        }

        Iterator<Row> cellit = sh1.iterator();
          cellit.next();

        int k=0;
        while (cellit.hasNext()){




            password[k]=   cellit.next().getCell(1).getStringCellValue();

            k++;
        }
             for (int j=0; j<username.length; j++) {

            System.out.println("User Name is " + username[j]);


        }
            for (int a = 0; a<password.length; a++){
                System.out.println("User Name is " + password[a]);


                }



           }

        }

   /* for( Row row : sh1){

        for( Cell cell : row){
         String s=   cell.getStringCellValue();

            System.out.println(s);


        } */









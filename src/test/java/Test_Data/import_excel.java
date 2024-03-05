package Test_Data;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;

public class import_excel{
    public String[][]data_import() throws Exception {
        FileInputStream my_data_file = new FileInputStream("src\\test\\java\\Test_Data\\Data_Sheet01.xlsx"); // import excelsheet file
        XSSFWorkbook myworkbook = new XSSFWorkbook(my_data_file);
        XSSFSheet mysheet=myworkbook.getSheet("Sheet1");
        int n_of_rows = mysheet.getPhysicalNumberOfRows();
        int n_of_columns = mysheet.getRow(0).getLastCellNum();

        String[][]array_for_data =new String[n_of_rows - 1][n_of_columns];
        // n_o_rows-1   //  -1 as we will not use first row "use for heading like password, email "
        for(int i=0;i<n_of_rows;i++) {
            for(int x=0;x<n_of_columns;x++)
            {
                XSSFRow my_row = mysheet.getRow(i);
                try {
                    array_for_data[i - 1][x] = my_row.getCell(x).getStringCellValue();
                }
                catch (Exception m){
                    System.out.print(m.getMessage());
                }
            }
        }
        return array_for_data;

    }

}



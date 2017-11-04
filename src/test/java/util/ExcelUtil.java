package util;


import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.SimpleTimeZone;

/**
 * Created by lenovo on 2017/9/15.
 */
public class ExcelUtil {

    private static XSSFSheet excelWSheet;
    private static XSSFWorkbook excelWbook;
    private static XSSFCell cell;
    private static XSSFRow row;
    /*
    * 初始方法，在读写Excel文件时，需先调用此方法
    * */
    public static void setExcelFile(String path,String sheetName) throws Exception {
        FileInputStream excelFile;
        try {
            excelFile = new FileInputStream(path);
            excelWbook = new XSSFWorkbook(excelFile);
            excelWSheet = excelWbook.getSheet(sheetName);
        }catch (Exception e) {
            throw (e);
        }
    }

    public static String getCellData(int rowNum,int colNum) throws Exception {
        String data = null;
        try {
            cell = excelWSheet.getRow(rowNum-1).getCell(colNum-1);
            if (cell.getCellTypeEnum().equals(CellType.STRING)){
                data = cell.getStringCellValue();
            }else {
                data = String.valueOf(cell.getNumericCellValue());
            }
            return data;
        }catch (Exception e) {
            throw new Exception("cell not data");
        }
    }

    public static boolean setCellData(int rowNum,int colNum,String data,String path) throws Exception {
        boolean flag = false;
        try {
            row = excelWSheet.getRow(rowNum-1);
            //如果单元格为空，返回null
            cell = row.getCell(rowNum-1,row.RETURN_BLANK_AS_NULL);
            if (cell == null){
                cell = row.createCell(colNum);
                cell.setCellValue(data);
            }else {
                cell.setCellValue(data);
            }

            FileOutputStream fileOut = new FileOutputStream(path);
            excelWbook.write(fileOut);
            fileOut.flush();
            fileOut.close();
            flag = true;
        }catch (Exception e) {
            throw (e);
        }
        return  flag;
    }

    public static Object[][] getTestData(String excelFilePath,String sheetName) throws Exception {
        File file = new File(excelFilePath);
        FileInputStream inputStream = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheet(sheetName);
        //获取行数
        int rowNum = sheet.getLastRowNum() - sheet.getFirstRowNum();
        List<Object[]> records = new ArrayList<Object[]>();
        for (int i=1;i<rowNum+1;i++){
            Row row = sheet.getRow(i);
            String fields[] = new String[row.getLastCellNum()];
            for (int j=0;j<row.getLastCellNum();j++){
                if (row.getCell(j).getCellTypeEnum().equals(CellType.STRING)){
                    fields[j] = row.getCell(j).getStringCellValue();
                }else {
                    fields[j] = String.valueOf(row.getCell(j).getNumericCellValue());
                }
            }
            records.add(fields);
        }
        Object[][] results = new Object[records.size()][];
        for (int i=0;i<records.size();i++){
            results[i] = records.get(i);
        }
        return  results;
    }

}

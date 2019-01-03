package com.example.test.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * Excel工具类
 */
public class ExcelUtil {

    /*读取excel文件中的数据，并生成数组*/
    @SuppressWarnings("deprecation")
    public static Object[][] readExcel(String filePath,String sheetName) throws IOException {


        File file = new File(filePath);//获取文件
        FileInputStream fileInputStream = new FileInputStream(file);//读数据

        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet(sheetName);//读取指定标签页的数据
        int rowNum = sheet.getPhysicalNumberOfRows();//获取行数(获取的是物理行数，也就是不包括那些空行（隔行）的情况)
        int columNum = sheet.getRow(0).getPhysicalNumberOfCells();//获取列数

        Object[][]    data = new Object[rowNum-1][columNum];//因为第一行作为字段名，不需要记录，所以只有[rowNum-1]行
        for(int i=1;i<rowNum;i++) {///从第二行开始取值
            for (int h = 0; h < columNum; h++) {
                sheet.getRow(i).getCell(h).setCellType(Cell.CELL_TYPE_STRING);//先把类型设置为string
                data[i-1][h] = sheet.getRow(i).getCell(h).getStringCellValue();//填充数组
            }
        }
        workbook.close();
        return data;
    }

    /*读取excel文件中的数据，并生成数组*/
    @SuppressWarnings("deprecation")
    public static Map<String, List> readTestCase(String xlsFileName, String sheetName) throws IOException {

        Map<String, List> map = new HashMap<String, List>();

        List<String[]> list = new ArrayList<String[]>();

        File file = new File(System.getProperty("user.dir") + "\\testCase\\" +  xlsFileName + ".xlsx");//获取文件
        FileInputStream fileInputStream = new FileInputStream(file);//读数据

        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet(sheetName);//读取指定标签页的数据
        int rows = sheet.getPhysicalNumberOfRows();//获取行数(获取的是物理行数，也就是不包括那些空行（隔行）的情况)
        int coumns = sheet.getRow(0).getPhysicalNumberOfCells();//获取列数


        String[] strkey = new String[rows - 1];// 存取testCase的值

        for (int i = 1; i < rows; i++) {
            String[] strValue = new String[coumns - 1];// 存取每一行的数据
            strkey[i - 1] = sheet.getRow(i).getCell(0).getStringCellValue();
            for (int j = 1; j < coumns; j++) {
                Cell cell = sheet.getRow(i).getCell(j);
                strValue[j - 1] = (null == cell) ? null : cell.getStringCellValue();
            }
            list.add(strValue);
        }

        // 把行的数据加入map中
        for (int i = 0; i < strkey.length; i++) {
            map.put(strkey[i], new ArrayList(Arrays.asList(list.get(i))));
        }

        return map;
    }
}

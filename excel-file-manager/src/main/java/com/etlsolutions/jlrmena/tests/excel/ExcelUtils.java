package com.etlsolutions.jlrmena.tests.excel;

import java.io.*;
import java.util.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    public void read() throws IOException {
        
        FileInputStream file = new FileInputStream(new File(""));
        Workbook workbook = new XSSFWorkbook(file);

        Sheet sheet = workbook.getSheetAt(0);

        Map<Integer, List<String>> data = new HashMap<>();
        
        int firstRow = sheet.getFirstRowNum();
        Row titleRow = sheet.getRow(firstRow);
        
        
        int i = 0;
        
        
        
        for (int j = firstRow + 1; j < sheet.getLastRowNum(); j++) {
            
            for (Cell cell : sheet.getRow(j)) {
       
            }
            data.put(i, new ArrayList<>());
        }
    }
}

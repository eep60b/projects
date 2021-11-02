package com.etlsolutions.jlrmena.tests.excel;

import java.io.*;
import java.util.*;
import org.apache.poi.ss.usermodel.*;
import static org.apache.poi.ss.usermodel.Cell.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    private static final ExcelUtils INSTANCE = new ExcelUtils();

    private final Map<Short, String> columnNameMap = new HashMap<>();

    private ExcelUtils() {
    }

    public static ExcelUtils getInstance() {
        return INSTANCE;
    }

    public List<DataRow> loadData() {

        String path = System.getProperty("user.home") + File.separator + "Documents" + File.separator + "student-admin" + File.separator + "Project allocation students, Supervisor and 2nd maker.xlsx";

        try (FileInputStream fis = new FileInputStream(new File(path)); Workbook workbook = new XSSFWorkbook(fis);) {

            Sheet sheet = workbook.getSheetAt(0);
            List<DataRow> dataRows = new ArrayList<>();
            int firstRow = sheet.getFirstRowNum();
            Row titleRow = sheet.getRow(firstRow);
            for (short i = titleRow.getFirstCellNum(); i < titleRow.getLastCellNum(); i++) {

                Cell cell = titleRow.getCell(i);
                if (cell == null) {
                    continue;
                }

                String columnName = cell.getStringCellValue();
                columnNameMap.put(i, columnName);
            }
            for (int i = firstRow + 1; i < sheet.getLastRowNum(); i++) {

                Row row = sheet.getRow(i);

                if (row == null) {
                    continue;
                }
                DataRow dataRow = new DataRow();

                for (short j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {

                    Cell cell = row.getCell(j);
                    if (cell != null) {

                        String columnName = columnNameMap.get(j);

                        switch (columnName.toLowerCase()) {
                            
                            case "bid":
                                dataRow.setId(getStringCellValue(cell));
                                break;                                
                            case "name":
                                dataRow.setStudentName(getStringCellValue(cell));
                                break;
                            case "course":
                                dataRow.setCourseName(getStringCellValue(cell));
                                break;
                            case "email":
                                dataRow.setEmailAddress(getStringCellValue(cell));
                                break;
                            case "supervisor":
                                dataRow.setSupervisorName(getStringCellValue(cell));
                                break;
                            case "2nd marker":
                                dataRow.setSecondMarkerName(getStringCellValue(cell));
                                break;
                            default:
                                throw new IllegalStateException("Invalid column name.");
                        }

                    }
                }

                dataRows.add(dataRow);
            }
            return dataRows;
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }

    private String getStringCellValue(Cell cell) {

        int type = cell.getCellType();

        switch (type) {

            case CELL_TYPE_BLANK:
                return "";
            case CELL_TYPE_BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case CELL_TYPE_ERROR:
                throw new IllegalStateException("Invalid cell.");
            case CELL_TYPE_FORMULA:
                return cell.getCellFormula();
            case CELL_TYPE_NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            case CELL_TYPE_STRING:
                return cell.getStringCellValue();
//            case CELL_TYPE_NONE:
//                return "NONE";

            default:
                throw new IllegalStateException("Invalid cell type.");
        }

    }
}

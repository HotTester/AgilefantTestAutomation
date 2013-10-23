/**
 * T-76.5613 Software Testing and Quality Assurance P
 * School of Science
 * Aalto University
 * 
 * Group Exercise of Team Hotsters
 */

package fi.aalto.stqa.hotsters.agilefanttestautomation.smoketests;


import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFCell;
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;



public class TestData {

  private InputStream myxls;
  private HSSFWorkbook wb;
  private HSSFSheet sheet;
  private HSSFRow row;
  private HSSFCell cell;
  private String value;



  public TestData(final InputStream dataFileStream) {
    try {
      wb = new HSSFWorkbook(dataFileStream);
    }
    catch (final IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }



  String getValue(final String sheetName, final int rowIndex, final int cellnum) {
    sheet = wb.getSheet(sheetName);
    row = sheet.getRow(rowIndex);
    cell = row.getCell(cellnum);
    value = cell.toString();
    return value;
  }
}

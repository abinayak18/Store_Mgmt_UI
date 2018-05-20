package utilities;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;



public class DataProviderUsingJXL {
	
	/**
 	 * This method reads the data from the Sheet name "Data" of file
 	 * "testData.xls"
 	 * 
 	 * 
 	 * @param xlFilePath
 	 *            : Path of excel file
 	 * @param sheetName
 	 *            : Sheet name which contains test data
 	 * @param tableName
 	 *            : Table name is used to mark the start and end position of the
 	 *            test data table. The method will find the cell which contains
 	 *            the table name to find position of data table
 	 * @return a 2 dimensions array to store all the test data read from excel
     * @throws Exception 
   	 */
     
     public static String[][] getDatafromExcel(String xlFilePath, String sheetName, String tableName) throws Exception
     {
    	 //Declare a 2 dimensional array to store all the data read from excel
    	 String[][] tabArray = null;
    	File fi = new File(xlFilePath);
    	 
    	 //get the workbook file. Provide the path of excel file
    	 Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
    	 
    	 
    	 //get the sheetname
    	 Sheet sheet = workbook.getSheet(sheetName);
    	 
    	 int startRow, startCol, endRow, endCol, ci, cj;
    	 
    	 //find cell position which contains first appear table name
    	 Cell tableStart = sheet.findCell(tableName);
    	 
    	 //Row position of first appear table name
    	 startRow = tableStart.getRow();
    	 
    	 //Column position of first appear table name
    	 startCol = tableStart.getColumn();
    	 
    	 //find cell position which contains last appear table name
    	 Cell tableEnd = sheet.findCell(tableName, startCol+1, startRow+1, 100, 64000, false);
    	 
    	 //Row position of last appeared table name
    	 endRow = tableEnd.getRow();
    	 
    	 //Column position of lase appeared table name
    	 endCol = tableEnd.getColumn();
    	 
    	 tabArray = new String[endRow - startRow -1 ][endCol - startCol - 1];
    	 ci = 0;
    	 
    	 //Store all data in an array
    	 for (int i = startRow+1; i < endRow; i++, ci++)
    	 {
    	   cj = 0;
    	   System.out.println("row count "+ ci);
		   for (int j = startCol+1; j < endCol; j++, cj++)
		   {
			   //Get content of each cell and store to each array element.
			   tabArray[ci][cj] = sheet.getCell(j, i).getContents();
			
		   }
		 }
		return tabArray;
    	 
     }
     
     public static int getNoofrows(String xlFilePath, String sheetName, String tableName) throws Throwable, IOException
     {
     	File fi = new File(xlFilePath);
     	 
     	 //get the workbook file. Provide the path of excel file
     	 Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
     	 
     	 
     	 //get the sheetname
     	 Sheet sheet = workbook.getSheet(sheetName);
     	 
     	 int startRow, startCol, endRow, endCol, ci, cj;
     	 
     	 //find cell position which contains first appear table name
     	 Cell tableStart = sheet.findCell(tableName);
     	 
     	 //Row position of first appear table name
     	 startRow = tableStart.getRow();
     	 
     	 
     	 return startRow;
     }
    
     
}

package POM_Demo.POM_Devlabs;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

//parameterizing the data as per Test Methods to pull data from Excel sheet and provide it to test cases via TestNG DataProvider method 
public class DataProvider_POM {

@DataProvider
public static Object[][] get_data(Method m){
	XSSFWorkbook workbook=null;
	XSSFSheet concerned_sheet=null;
	DataFormatter dft=new DataFormatter();
	try {
		workbook=new XSSFWorkbook("./Data/Test_Data.xlsx");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.err.println("File not found");
	}
	int sheet_count=workbook.getNumberOfSheets();
	for(int i=0;i<sheet_count;i++)
	{
		if(workbook.getSheetName(i).equalsIgnoreCase(m.getName()))
		{
			concerned_sheet=workbook.getSheetAt(i);
			break;
		}
	}
	int row_count=concerned_sheet.getLastRowNum()-concerned_sheet.getFirstRowNum();
	int column_count=concerned_sheet.getRow(0).getLastCellNum()-concerned_sheet.getRow(0).getFirstCellNum();
	Object[][] obj=new Object[row_count][column_count];
	int l=0;
	for(int j=1;j<=row_count;j++)
	{
		for(int k=0;k<column_count;k++)
		{
			String cell_value=dft.formatCellValue(concerned_sheet.getRow(j).getCell(k));
			obj[l][k]=cell_value;
		}
		l++;
	}
	
	
	return obj;
	
}

}

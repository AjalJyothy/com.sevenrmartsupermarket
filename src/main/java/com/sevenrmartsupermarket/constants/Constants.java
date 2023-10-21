package com.sevenrmartsupermarket.constants;

import org.testng.annotations.DataProvider;

import com.sevenrmartsupermarket.utilities.ExcelReader;

public class Constants {
	
	ExcelReader excelreader=new ExcelReader();
	
public static final String CONFIG_FILE_PATH=System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties";
public static final String EXCEL_FILE_PATH=System.getProperty("user.dir")+"\\src\\main\\resources\\ExcelFiles\\";
public static final String EXTENT_REPORT_PATH=System.getProperty("user.dir")+"\\ExtentReport";                    
public static final String SCREENSHOT_FILE_PATH=System.getProperty("user.dir")+"\\screenshots\\";
/** Expected Results**/


                  /**Login Page expected Result(usually for negative scenario,remember me check box text)**/


                  /**Data Providers**/
@DataProvider (name="Grocery App")
public Object[][] datasevenrsupermart()
{
	excelreader.setExcelFile("LoginData","Set Of Valid Login Credentials");
	return excelreader.getMultidimentionalData(3,2);
}

}

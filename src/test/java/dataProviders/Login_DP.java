package dataProviders;

import generic.ExcelHandlerGeneric;
import generic.Utility_Class;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

public class Login_DP {
	@DataProvider(name = "valid_login")
	public static Object[][] DP_validlogin()
	{
		List<String> list = getXLdata("Valid_Login_test");
		System.out.println(list.size());
		Object[][] obj = new Object[list.size()][5];
		
		for(int i=0;i<list.size();i++)
		{
			obj[i][0] = list.get(i).split(";")[0];
			obj[i][1] = list.get(i).split(";")[1];
			obj[i][2] = list.get(i).split(";")[2];
			obj[i][3] = list.get(i).split(";")[3];
			obj[i][4] = list.get(i).split(";")[4];
		}	
		
		return obj;
	}
	
	@DataProvider(name = "invalid_login")
	public static Object[][] DP_invalidlogin()
	{
		List<String> list = getXLdata("Invalid_Login_test");
		System.out.println(list.size());
		Object[][] obj = new Object[list.size()][5];
		
		for(int i=0;i<list.size();i++)
		{
			obj[i][0] = list.get(i).split(";")[0];
			obj[i][1] = list.get(i).split(";")[1];
			obj[i][2] = list.get(i).split(";")[2];
			obj[i][3] = list.get(i).split(";")[3];
			obj[i][4] = list.get(i).split(";")[4];
		}	
		
		return obj;
	}
	
	public static List<String> getXLdata(String scriptname)
	{
		ExcelHandlerGeneric xl = new ExcelHandlerGeneric(Utility_Class.getConfigdata("XL_path"));
		String sheetname ="Scenario_Login";
		int rowcount = xl.getrowcount(sheetname);
		List<String> ls = new ArrayList<String>();
		for(int i = 1;i<=rowcount;i++)
		{
			if(xl.getXLcellvalue(sheetname, i, 2).equalsIgnoreCase("Y"))
			{
				if(xl.getXLcellvalue(sheetname, i, 3).equalsIgnoreCase(scriptname))
						{
							String TC_ID = xl.getXLcellvalue(sheetname, i, 0);
							String Order = xl.getXLcellvalue(sheetname, i, 1);
							String uname = xl.getXLcellvalue(sheetname, i, 4);
							String pwd = xl.getXLcellvalue(sheetname, i, 5);
							String expected = xl.getXLcellvalue(sheetname, i, 6);
							ls.add(TC_ID+";"+Order+";"+uname+";"+pwd+";"+expected);
						}
			}
				
		}return ls;
	}
	

}

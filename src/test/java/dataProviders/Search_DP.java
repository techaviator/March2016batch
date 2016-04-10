package dataProviders;

import generic.ExcelHandlerGeneric;
import generic.Utility_Class;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

public class Search_DP {
	
	@DataProvider(name= "valid_searchDP")
	public static Object[][] DP_validsearch()
	{
		List<String> list = getXLdata("Valid_Search");
		Object[][] obj = new Object[list.size()][4];
		for(int i=0;i<list.size();i++)
		{
			obj[i][0]= list.get(i).split(";")[0];
			obj[i][1] = list.get(i).split(";")[1];
			obj[i][2]= list.get(i).split(";")[2];
			obj[i][3] = list.get(i).split(";")[3];
		}
		
	
		return obj;
	}
	
	@DataProvider(name= "invalid_searchDP")
	public static Object[][] DP_invalidsearch()
	{
		List<String> list = getXLdata("Invalid_Search");
		
		Object[][] obj = new Object[list.size()][4];
		for(int i =0;i<list.size();i++)
		{
			obj[i][0]= list.get(i).split(";")[0];
			obj[i][1] = list.get(i).split(";")[1];
			obj[i][2]= list.get(i).split(";")[2];
			obj[i][3] = list.get(i).split(";")[3];
		}
		
		return obj;
	}
	
	public static List<String> getXLdata(String scriptname)
	{
		ExcelHandlerGeneric xl = new ExcelHandlerGeneric(Utility_Class.getConfigdata("XL_path"));
		String sheetname = "Scenario_Search";
		int rowcount = xl.getrowcount(sheetname );
		List<String> ls = new ArrayList<String>();
 		for(int i=1; i<=rowcount;i++)
		{
			if(xl.getXLcellvalue(sheetname, i, 2).equalsIgnoreCase("Y"))
			{
				if(xl.getXLcellvalue(sheetname, i, 3).equalsIgnoreCase(scriptname))
				{
					String TC_ID = xl.getXLcellvalue(sheetname, i, 0);
					String Order = xl.getXLcellvalue(sheetname, i, 1);
					String searchkey = xl.getXLcellvalue(sheetname, i, 4);
					String expected = xl.getXLcellvalue(sheetname, i, 5);
					ls.add(TC_ID+";"+Order+";"+searchkey+";"+expected);
				}
			}
		}return ls;
	
	}

}

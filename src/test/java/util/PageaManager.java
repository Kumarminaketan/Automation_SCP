package util;

import Pages.Login_page;

public class PageaManager extends TestBase {

	public Login_page Login_page() {
		Login_page Loginpage = new Login_page();
		return Loginpage;
	}

	public Pages.Vendor_Home_page Vendor_Home_page() {
		Pages.Vendor_Home_page Rccphomepage = new Pages.Vendor_Home_page();
		return Rccphomepage;

	}
	
	public Pages.Screen_selector_page Screen_selector_page()
	{
		Pages.Screen_selector_page Screenselectorpage = new Pages.Screen_selector_page();
		
		return Screenselectorpage;
		
	}
	
	/*public Screen_Selector_page Screen_Selector_page()
	{
		Screen_Selector_page Screenselector=new Screen_Selector_page();
		return Screenselector;
		
		
	}
public Order_To_Dispatch_Lead_Time_page Order_To_Dispatch_Lead_Time_page()
{
	Order_To_Dispatch_Lead_Time_page dipatch=new Order_To_Dispatch_Lead_Time_page();
	return dipatch;
	
}*/

public util.Read_excel Read_excel()
{
	Read_excel readexcel=new Read_excel();
	return readexcel;
}

public util.Latest_Modified_file Latest_Modified_file ()
{
Latest_Modified_file filepaths=new Latest_Modified_file();
return filepaths;
}
}
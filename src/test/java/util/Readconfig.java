package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Readconfig {
	
	
	
	
		Properties p;
		public Readconfig() 
		{
			File src=new File("./Configuration/config.properties");
			FileInputStream f = null;
			try {
				f = new FileInputStream(src);
			
				// TODO Auto-generated catch block
			
			
			p=new Properties();
		
				p.load(f);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	public String Url()
	{
		String Urls=p.getProperty("url");
		return Urls;
	}

	public String chromepath()
	{
		String chromepaths=p.getProperty("chromepath");
		return chromepaths;
	}
	
	public String Username()
	{
		String username=p.getProperty("Username");
		return username;
	}
	public String Password()
	{
		String password=p.getProperty("Password");
		return password;
	}
	public String Vendorname()
	{
		String Vendorname=p.getProperty("vendorname");
		return Vendorname;
	}
	public String Monthvalue()
	{
		String VendorValue=p.getProperty("value");
		return VendorValue;
	}
	
	public String vendorcode()
	{
		String VendorValue=p.getProperty("vendorcode");
		return VendorValue;
	}
	}


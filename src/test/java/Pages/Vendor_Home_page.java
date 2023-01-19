package Pages;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Actiondriver.Action;
import util.Read_excel;
import util.Readconfig;
import util.TestBase;

public class Vendor_Home_page extends TestBase {
	Action action = new Action();
	Readconfig read = new Readconfig();
	Read_excel r = new Read_excel();

	// Initializing the Page Objects:
	public Vendor_Home_page() {
		PageFactory.initElements(getdriver(), this);
	}

	@FindBy(xpath = "(//div[contains(@class,'ui-dropdown-trigger')]/span)[1]")
	WebElement Click_Vendor_dropdown;

	@FindBy(xpath = "//li[@role='option']/span")
	List<WebElement> Vendor_value;

	@FindBy(xpath = "(//div[contains(@class,'ui-dropdown-trigger')]/span)[2]")
	WebElement Click_Month_dropdown;

	@FindBy(xpath = "//li[@role='option']/span")
	List<WebElement> Month_value;

	@FindBy(xpath = "(//tr[@class='ng-star-inserted'])[2] //th")
	List<WebElement> header;

	@FindBy(xpath = "//tbody/tr //td[1]")
	List<WebElement> Plant_value;

	@FindBy(xpath = "//tbody/tr //td[2]")
	List<WebElement> Parts_value;

	@FindBy(xpath = "//tbody/tr //td[3]")
	List<WebElement> Part_description_value;

	@FindBy(xpath = "//tr[@class='ng-star-inserted'] //td[@class='text-center']/div[1]")
	List<WebElement> inward_consumption;

	@FindBy(xpath = "//tr[@class='ng-star-inserted'] //td[2]")
	List<WebElement> materialcode;

	public void select_vendor() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("click on the vendor dropdown button");
		action.explicitWait(getdriver(), Click_Vendor_dropdown, 5);
		action.checkEnable(getdriver(), Click_Vendor_dropdown);
		action.click(getdriver(), Click_Vendor_dropdown);
		for (WebElement e : Vendor_value) {
			System.out.println(e.getText());
			if (e.getText().contentEquals(read.Vendorname())) {
				e.click();
				break;
			}
		}

		System.out.println("Entered vendor dropdownvalue successfully");
		Thread.sleep(2000);
	}

	public void select_month() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("click on the Month dropdown button");
		action.explicitWait(getdriver(), Click_Month_dropdown, 5);
		action.checkEnable(getdriver(), Click_Month_dropdown);
		action.click(getdriver(), Click_Month_dropdown);
		for (WebElement e : Month_value) {
			System.out.println(e.getText());
			if (e.getText().contentEquals(read.Monthvalue())) {
				e.click();
				break;
			}
		}

	}

	public void plant_value() throws InterruptedException {
		System.out.println("Get the plant value");
		String s = action.getText(getdriver(), header.get(0));
		System.out.println(s);
		for (WebElement e : Plant_value) {
			System.out.println(e.getText());
			boolean a = e.getText().equalsIgnoreCase("");
			Assert.assertEquals(a, false);

		}

	}

	public void part_value() throws InterruptedException, IOException {
		System.out.println("Get the part code value");
		System.out.println(action.getText(getdriver(), header.get(1)));
		List<String> screen_material = new ArrayList<String>();
		String s = "";
		for (WebElement e : Parts_value) {
			screen_material.add(e.getText());
		}

		List<String> sheet_vendor = r.read_excel_Uniquedata(0, 4);
		List<String> sheet_material_All = r.read_excel_Uniquedata(0, 3);
		List<String> sheet_material_notfound = new ArrayList<String>();
		Set<String> found_material = new HashSet<String>();
		for (int i = 0; i <= sheet_vendor.size() - 1; i++) {
			if (sheet_vendor.get(i).equalsIgnoreCase(read.vendorcode())) {
				s = sheet_material_All.get(i);

				if (screen_material.contains(s)) {
					found_material.add(s);
					// System.out.println("Material displayed in the screen "+s);
				} else {
					sheet_material_notfound.add(sheet_material_All.get(i));
				}
			}

		}
		System.out.println("below mateial are not displayed in the screen        " + sheet_material_notfound);
		boolean a = sheet_material_notfound.size() == 0;
		Assert.assertEquals(a, true, " Some material are not available in the screen please check the data");

	}

	public void partdescription_value() throws InterruptedException {
		System.out.println("Get the part description value");
		System.out.println(action.getText(getdriver(), header.get(2)));
		for (WebElement e : Part_description_value) {
			System.out.println(e.getText());
			boolean a = e.getText().equalsIgnoreCase("");
			Assert.assertEquals(a, false);

		}
	}

	public void inword_consumption() throws IOException {
		
		List<String> screen_material = new ArrayList<String>();
		List<String> screen_value = new ArrayList<String>();
		for (int i = 0; i < materialcode.size(); i++) {

			System.out.println(action.getText(getdriver(), materialcode.get(i)));
			screen_material.add(action.getText(getdriver(), materialcode.get(i)));
			System.out.println(action.getText(getdriver(), inward_consumption.get(i)));
			screen_value.add(action.getText(getdriver(), inward_consumption.get(i)));

		}

		List<String> sheet_vendor = r.read_excel_Uniquedata(0, 4);
		List<String> sheet_material_All = r.read_excel_Uniquedata(0, 3);
		List<String> sheet_quantity = r.read_excel_Uniquedata(0, 6);
		List<String> sheet_material = new ArrayList<String>();
		List<String> sheet_material_quantity = new ArrayList<String>();

		for (int i = 0; i <= sheet_vendor.size() - 1; i++) {
			if (sheet_vendor.get(i).equalsIgnoreCase("A06123")) {

				sheet_material.add(sheet_material_All.get(i));
			}
		}

		for (String s : sheet_material) {
			int d = 0;

			for (int j = 0; j <= sheet_vendor.size() - 1; j++) {

				if (sheet_vendor.get(j).equalsIgnoreCase("A06123")) {
					if (sheet_material_All.get(j).equals(s)) {

						d = d + Integer.parseInt(sheet_quantity.get(j));

					}
				}
			}
			sheet_material_quantity.add(Integer.toString(d));
		}
		
		System.out.println(sheet_material);
		System.out.println(sheet_material_quantity);
		for (int k = 0; k <= screen_material.size() - 1; k++) {
			
			for (int l = 0; l <= sheet_material.size() - 1; l++) {
			
			if(screen_material.get(k).equalsIgnoreCase(sheet_material.get(l))) {
			System.out.println(screen_material.get(k));
			System.out.println(sheet_material.get(l));
			System.out.println("data of screen    "+screen_value.get(k));
			System.out.println("dta of shet     "+sheet_material_quantity.get(l));
			
			}
			else
			{
				System.out.println(screen_material.get(k));
			}
			}
		}
		}
	}


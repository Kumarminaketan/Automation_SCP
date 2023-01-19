package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Actiondriver.Action;
import util.TestBase;

public class Screen_selector_page extends TestBase {
	
	Action action=new Action();
	public Screen_selector_page()
	{
		PageFactory.initElements(getdriver(), this);
	}
	@FindBy(xpath = "//div[text()='Commercial Vehicle']")
	WebElement Click_CV;
	
	@FindBy(xpath = "//div[text()='Day Level Plan']")
	WebElement Click_DLP;
	
	@FindBy(xpath = "//h5[text()='Day Level Requirement vs Commitment']")
	WebElement Vendor_Screen;
	
	
	
	
	//Click on CV
		public void Click_on_CV() {
			System.out.println("Click on the CV button");
			action.click(getdriver(), Click_CV);
			action.checkEnable(getdriver(), Click_DLP);
			System.out.println("Navigate to CV Screen");
		}
		public void Click_DLP()
		{
			System.out.println("Click on the DP tab");
			action.click(getdriver(), Click_DLP);
			action.checkEnable(getdriver(), Vendor_Screen);
			System.out.println("DLP Screen opened");
		}
}

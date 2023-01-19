package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Actiondriver.Action;
import util.Readconfig;
import util.TestBase;

public class Login_page extends TestBase {
	Action action = new Action();
	Readconfig read = new Readconfig();

	@FindBy(xpath = "//input[@type='text']")
	WebElement Username_text;

	@FindBy(xpath = "//input[@type='password']")
	WebElement Password_text;

	@FindBy(xpath = "//button[text()=' Login ']")
	WebElement Click_login;

	@FindBy(xpath = "//button[text()='Ok']")
	WebElement Click_confirm;

	@FindBy(xpath = "//div[text()='Commercial Vehicle']")
	WebElement Click_CV;
//	
//	@FindBy(xpath = "//div[text()='View Run List']")
//	WebElement click_View_run_list;

	//// div[text()='View Run List']

// Initializing the Page Objects:
	public Login_page() {
		PageFactory.initElements(getdriver(), this);
	}

//	Get the title
	public void verifyEYTitle() {

		System.out.println("Print the title ");
		System.out.println(action.getTitle(getdriver()));
		action.checkEnable(getdriver(), Username_text);
		
	}

//enter the User name
	public void Username() {
		System.out.println("Enter the Username");
		action.type(Username_text, read.Username(), getdriver());
		action.checkEnable(getdriver(), Password_text);
		System.out.println("User name entered in the page successfully");
	}

//Enter the password
	public void Password() {
		System.out.println("Enter the assword");
		action.type(Password_text, read.Password(), getdriver());
		action.checkEnable(getdriver(), Click_login);
		System.out.println("Password entered in the page succesfully");
	}

//Click on the login button
	public void Clicklogin() throws InterruptedException {
		System.out.println("click on the login button");
		action.click1(Click_login, "CLick on the login button without any error", getdriver());
		System.out.println("clicked on the login button successfully");
	}

//Click on the OK button

	public void confirm() throws InterruptedException {

		Thread.sleep(200);
		if (action.isDisplayed(getdriver(), Click_CV) != true) {
			action.explicitWait(getdriver(), Click_confirm, 10);
			if (action.isDisplayed(getdriver(), Click_confirm) == true) {
				System.out.println("click on the OK button");
				action.checkEnable(getdriver(), Click_confirm);
				action.click1(Click_confirm, "CLick on the Ok button without any error", getdriver());
				System.out.println("clicked on the OK button successfully");

			}
		} else {
			System.out.println("Confirm window skipped, Home page should be dislayed");
			action.explicitWait(getdriver(), Click_CV, 10);
			action.checkEnable(getdriver(), Click_CV);
		}

	}

}

package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.PageaManager;

public class Login_To_SCP_Steps extends PageaManager {

	@Given("User is on SCP Login page")
	public void user_is_on_scp_login_page() {
		System.out.println("*****User is on login page******");
		Login_page().verifyEYTitle();
	}

	@When("User login with correct User name  and Pasword")
	public void user_login_with_correct_user_name_and_pasword() throws InterruptedException {

		System.out.println("*******User will enter the credentials and click on login button******");

		Login_page().Username();
		Login_page().Password();
		Login_page().Clicklogin();
	}

	@Then("Verify that CV home page should be displayed")
	public void verify_that_cv_home_page_should_be_displayed() throws InterruptedException {

		Login_page().confirm();
		Screen_selector_page().Click_on_CV();
		
		System.out.println("******User is on the home page******");

	}

	@Then("click on the DLP tab")
	public void click_on_the_dlp_tab() throws InterruptedException {
		
		System.out.println("****** Click on the DLP tab******");
		Screen_selector_page().Click_DLP();
	}
	@Given("check if")
	public void check_if() {
	    System.out.println("test");
	}

}

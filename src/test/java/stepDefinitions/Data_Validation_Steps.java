package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.PageaManager;

public class Data_Validation_Steps extends PageaManager {
	
	@Given("Select the vendor")
	public void select_the_vendor() throws InterruptedException {
		Vendor_Home_page().select_vendor();
	    
	}
	@When("user select the month")
	public void user_select_the_month() throws InterruptedException {
		Vendor_Home_page().select_month();
	    
	}
	@Then("Verify that the material details should be displayed")
	public void verify_that_the_material_details_should_be_displayed() throws InterruptedException {
	    Vendor_Home_page().plant_value();
	    
	}
	@Then("Verify the partcode details")
	public void verify_the_partcode_details() throws InterruptedException, IOException {
	   Vendor_Home_page().part_value();
	}
	@Then("Verify the partcode description")
	public void verify_the_partcode_description() throws InterruptedException {
	   Vendor_Home_page().partdescription_value();
	}
	@Then("Verify the Inward consumption")
	public void verify_the_inward_consumption() throws IOException {
		Vendor_Home_page().inword_consumption();	   
	}
	@Then("Verify the Commitment")
	public void verify_the_commitment() {
	    
	}
	@Then("Verify the Shortfall")
	public void verify_the_shortfall() {
	    
	}

}

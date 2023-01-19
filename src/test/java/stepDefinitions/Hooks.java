package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Actiondriver.Action;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import util.TestBase;

public class Hooks extends TestBase {
	Action action = new Action();
	
	@BeforeAll
	
	public static void before_or_after_all(){
		System.out.println("--------------------  Test Execution started  --------------------");
		initialization("chrome");
		System.out.println("Browser open succesfuly");
	}

	@Before
	public void executescenario(Scenario scenario){
		System.out.println("--------------------  Scenario Execution started for "+scenario.getName()+"--------------------");
		
	}

	@After
	public void closeBrowser(Scenario scenario) throws InterruptedException {
		Thread.sleep(1000);
		
		System.out.println("--------------------  Scenario execution completed successfully for "+scenario.getName()+"--------------------");

	}
	
	
	@AfterStep
	public void AddScreenshoot_fail(Scenario scenario) throws IOException, InterruptedException {
		if (scenario.isFailed()) {
			System.out.println("------- will take the screenshot for fail scenario -------");
			File sourcepath = ((TakesScreenshot) getdriver()).getScreenshotAs(OutputType.FILE);
			byte[] filecontent = FileUtils.readFileToByteArray(sourcepath);
			scenario.attach(filecontent, "image/png", "image");
			System.out.println("-------  Screenshot taken succesfully for fail scenario  -------");
		}

		else
		{
		System.out.println("------- will take the screenshot for pass scenario -------");
		Thread.sleep(1000);
			File sourcepath=((TakesScreenshot)getdriver()).getScreenshotAs(OutputType.FILE);
			byte[] filecontent=FileUtils.readFileToByteArray(sourcepath);
			scenario.attach(filecontent, "image/png", "image");
		System.out.println("------- Screenshot taken succesfully for pass scenario -------");
		}
	}
	
	@AfterAll
	public static void after_all(){
		getdriver().quit();
				System.out.println("--------------------  Driver close successfully  --------------------");
	}

}

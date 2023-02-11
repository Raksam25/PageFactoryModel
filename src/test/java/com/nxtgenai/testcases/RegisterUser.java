package com.nxtgenai.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.nxtgenai.pages.RegisterDemoPage;

public class RegisterUser {
	
	public WebDriver driver;

	@Test(priority=1)
	public void launchApplication() {
		// To Set System Property
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");

		// To Create Driver Object in Driver Interface
		driver = new ChromeDriver();

		// Step:2 Launch the Home URL"https://aiforevery1.com".

		// Launch the Home URL
		driver.get("https://nxtgenaiacademy.com/demo-site/");

		// To Maximize Window
		driver.manage().window().maximize();
		Reporter.log("Application is launched");	
	}

	@Test(priority=2)
	public void registerUser() {

		RegisterDemoPage registerUser = PageFactory.initElements(driver, RegisterDemoPage.class);
		registerUser.setFirstName("Vinoth");
		registerUser.setLastName("R");
		registerUser.selectMaleRadioBtn();
		registerUser.setEmailID("vinothrwins@gmail.com");
		registerUser.setVerificationNum("34");
		registerUser.clickSubmitBtn();		
		
	}


	@Test(priority=3)
	public void closeApplication() {
		driver.close();
	}




}

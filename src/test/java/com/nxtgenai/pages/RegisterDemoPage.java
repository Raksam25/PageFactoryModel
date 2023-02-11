package com.nxtgenai.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterDemoPage {

	WebDriver driver;
	// Initilize the webelements locators values using FINDBY class
	
	@FindBy(id="vfb-5") 
	@CacheLookup
	WebElement firstName;
	
	@FindBy(name="vfb-7")
	@CacheLookup
	WebElement lastName;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"vfb-8-1\"]")
	@CacheLookup
	WebElement genderMale;	
	
	@FindBy(how = How.CSS, using = "#vfb-14")
	@CacheLookup
	WebElement emailID;
	
	@FindBy(how = How.ID, using = "vfb-3")
	@CacheLookup
	WebElement verificationNum;
	
	@FindBy(how = How.ID,using = "vfb-4")
	@CacheLookup
	WebElement submitBtn;
	

	public RegisterDemoPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setFirstName(String fname) {
		firstName.sendKeys(fname);
		System.out.println("First Name is "+ fname);		
	}
	
	public void setLastName(String lname) {
		lastName.sendKeys(lname);
	}
	
	public void selectMaleRadioBtn() {
		genderMale.click();
	}
	
	public void setEmailID(String eid) {
		emailID.sendKeys(eid);
	}
	
	public void setVerificationNum(String vnum) {
		verificationNum.sendKeys(vnum);
	}
	
	public void clickSubmitBtn() {
		submitBtn.click();
		System.out.println("Submit button is clicked");
	}
		
}

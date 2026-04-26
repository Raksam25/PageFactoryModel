package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.CSVUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class LoginPageNegativeTest extends BaseTest{
	
	
	@DataProvider
	public Object[][] invalidLoginData() {
		return CSVUtil.csvData("login");
	}
		
	
	@Feature("Login")
	@Story("Invalid login attempts")
	@Severity(SeverityLevel.NORMAL)
	@Description("This test validates that invalid login attempts are handled correctly.")
	@Test(dataProvider = "invalidLoginData")
	public void invalidLoginTest(String username, String password) {
		Assert.assertTrue(loginPage.doInvalidLogin(username, password), "Invalid login should be handled properly");
	}
	

}

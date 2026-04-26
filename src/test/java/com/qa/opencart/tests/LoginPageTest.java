package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

//@Listeners({AnnotationTransformer.class, ExtentReportListener.class})


@Epic("Epic 100: design open cart login page")
@Feature("Feature 101: login feature")
@Story("US 120: All the features related to open cart login page")
@Owner("Naveen Automation Labs")
@Link(name = "LoginPage", url = "https://naveenautomationlabs.com/opencart/index.php?route=account/login")
public class LoginPageTest extends BaseTest {

	@Severity(SeverityLevel.MINOR)
	@Description("This test validates that the login page displays the correct title.")
	@Feature("Login")
	@Story("Login page display")
	@Test
	public void loginPageTitleTest() {
		String actTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actTitle, AppConstants.LOGIN_PAGE_TITLE, "Login page title should match the expected value");
	}

	@Severity(SeverityLevel.NORMAL)
	@Description("This test validates that the login page URL contains the expected fraction.")
	@Feature("Login")
	@Story("Login page navigation")
	@Test()
	public void loginPageURLTest() {
		String actURL = loginPage.getLoginPageURL();
		Assert.assertTrue(actURL.contains(AppConstants.LOGIN_PAGE_FRACTION_URL), "Login page URL should contain the expected fraction");
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("This test validates that the forgot password link exists on the login page.")
	@Feature("Login")
	@Story("Forgot password functionality")
	@Issue("Bug-123")
	@Test
	public void forgotPwdLinkExistTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist(), "Forgot password link should exist on the login page");
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("This test validates that the logo exists on the login page.")
	@Feature("Login")
	@Story("Login page display")
	@Test
	public void logoExistTest() {
		Assert.assertTrue(loginPage.isLogoExist(), "Logo should exist on the login page");
	}

	@Severity(SeverityLevel.MINOR)
	@Description("This test validates that a user can successfully log in with valid credentials.")
	@Feature("Login")
	@Story("User login")
	@Test(priority = Integer.MAX_VALUE)
	public void loginTest() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(accPage.getAccountsPageTitle(), AppConstants.ACCOUNTS_PAGE_TITLE, "Accounts page title should match after login");
	}
	
	
	@Test(enabled = false)
	public void naveentest() {
		// WIP
	}

}

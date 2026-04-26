package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ExcelUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

//SRP: 
public class AccountsPageTest extends BaseTest {

	@BeforeClass
	public void accSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Feature("Accounts")
	@Story("Accounts page display")
	@Severity(SeverityLevel.MINOR)
	@Description("This test validates that the accounts page title is correct.")
	@Test
	public void accPageTitleTest() {
		String actTitle = accPage.getAccountsPageTitle();
		Assert.assertEquals(actTitle, AppConstants.ACCOUNTS_PAGE_TITLE, "Accounts page title should match the expected value");
	}

	@Feature("Accounts")
	@Story("Accounts page display")
	@Severity(SeverityLevel.NORMAL)
	@Description("This test validates that the logout link exists on the accounts page.")
	@Test
	public void isLogoutLinkExistTest() {
		Assert.assertTrue(accPage.isLogoutLinkExist(), "Logout link should exist on the accounts page");
	}

	@Feature("Accounts")
	@Story("Accounts page headers")
	@Severity(SeverityLevel.NORMAL)
	@Description("This test validates the count of headers on the accounts page.")
	@Test
	public void accPageHeadersCountTest() {
		Assert.assertEquals(accPage.getTotalAccountsPageHeader(), AppConstants.ACCOUNTS_PAGE_HEADERS_COUNT, "Accounts page headers count should match the expected value");

	}

	@Feature("Accounts")
	@Story("Accounts page headers")
	@Severity(SeverityLevel.NORMAL)
	@Description("This test validates the list of headers on the accounts page.")
	@Test
	public void accPageHeadersTest() {
		List<String> actualHeadersList = accPage.getAccPageHeaders();
		Assert.assertEquals(actualHeadersList, AppConstants.EXPECTED_ACC_PAGE_HEADERS_LIST, "Accounts page headers should match the expected list");
	}
	
	
	@DataProvider
	public Object[][] getSearchKey() {
		return new Object[][] {
			{"macbook", 3},
			{"imac", 1},
			{"samsung", 2},
			
		};
	}

	@Feature("Search")
	@Story("Search results count")
	@Severity(SeverityLevel.CRITICAL)
	@Description("This test validates the search functionality by checking the count of search results.")
	@Test(dataProvider = "getSearchKey")
	public void searchCountTest(String searchKey, int searchCount) {
		resultsPage = accPage.doSearch(searchKey);
		Assert.assertEquals(resultsPage.getSearchResultsCount(), searchCount, "Search results count should match the expected value for " + searchKey);
	}
	
	
	@DataProvider
	public Object[][] getSearchData() {
		return new Object[][] {
			{"macbook", "MacBook Pro"},
			{"macbook", "MacBook Air"},
			{"imac", "iMac"},
			{"samsung", "Samsung SyncMaster 941BW"},
			{"samsung", "Samsung Galaxy Tab 10.1"}
		};
	}
	
	
	@DataProvider
	public Object[][] getSearcExcelData() {
		return ExcelUtil.getTestData(AppConstants.SEARCH_SHEET_NAME);
	}
	

	@Feature("Search")
	@Story("Product selection from search")
	@Severity(SeverityLevel.CRITICAL)
	@Description("This test validates searching for a product and selecting it from results.")
	@Test(dataProvider = "getSearcExcelData")
	public void searchTest(String searchKey, String productName) {
		resultsPage = accPage.doSearch(searchKey);
		productInfoPage = resultsPage.selectProduct(productName);
		Assert.assertEquals(productInfoPage.getProductHeader(), productName, "Product header should match the selected product name");
	}

}

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class Script {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	//Register success
	
	@Given("I am on the register page")
	def on_register_page() {
		WebUI.openBrowser('https://alta-shop.vercel.app/')
		WebUI.maximizeWindow()
		WebUI.click(findTestObject('Object Repository/Page_frontend-web/icon_homepage'))
		WebUI.click(findTestObject('Object Repository/Page_frontend-web/register_login_page'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Page_frontend-web/valtext_Register'), 2)
	}
	
	@When("I input (.*) and (.*) and (.*)")
	def input_register(String Nama_Lengkap, String Email, String Password) {
		WebUI.click(findTestObject('Object Repository/Page_frontend-web/field_nama_lengkap_register'))
		WebUI.setText(findTestObject('Object Repository/Page_frontend-web/field_nama_lengkap_register'), Nama_Lengkap)
		WebUI.click(findTestObject('Object Repository/Page_frontend-web/field_email_register'))
		WebUI.setText(findTestObject('Object Repository/Page_frontend-web/field_email_register'), Email)
		WebUI.click(findTestObject('Object Repository/Page_frontend-web/field_password_register'))
		WebUI.setText(findTestObject('Object Repository/Page_frontend-web/field_password_register'), Password)
	}
	
	@And("I Click register button")
	def click_register_button() {
		WebUI.click(findTestObject('Object Repository/Page_frontend-web/button_Register'))
	
		
	}
	
	//Register_Failed_With_Fullname_Not_Inputted
	
	@When("I enter (.*) and (.*) and let my nama lengkap empty")
	def nama_lengkap_empty(String Email, String Password){
		WebUI.click(findTestObject('Object Repository/Page_frontend-web/field_email_register'))
		WebUI.setText(findTestObject('Object Repository/Page_frontend-web/field_email_register'), Email)
		WebUI.click(findTestObject('Object Repository/Page_frontend-web/field_password_register'))
		WebUI.setText(findTestObject('Object Repository/Page_frontend-web/field_password_register'), Password)
		
	}
	
	@Then("I should verify error message that fullname is required")
	def fullname_is_required() {
		WebUI.click(findTestObject('Object Repository/Page_frontend-web/button_Register'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/Page_frontend-web/valtext_fullname is required'))
	}
	
	//Register_Failed_With_Email_Not_Inputted
	@When("I enter (.*) and (.*) and my email empty")
	def email_empty_register(String Nama_Lengkap, String Password) {
		
		WebUI.click(findTestObject('Object Repository/Page_frontend-web/field_nama_lengkap_register'))
		WebUI.setText(findTestObject('Object Repository/Page_frontend-web/field_nama_lengkap_register'), Nama_Lengkap)
		WebUI.click(findTestObject('Object Repository/Page_frontend-web/field_password_register'))
		WebUI.setText(findTestObject('Object Repository/Page_frontend-web/field_password_register'), Password)
		WebUI.click(findTestObject('Object Repository/Page_frontend-web/button_Register'))
		
	}
	
	//Register_Failed_With_Password_Not_Inputted
	@When("I enter (.*) and (.*) and the password is empty")
	def password_empty_register(String Nama_Lengkap, String Email) {
		WebUI.click(findTestObject('Object Repository/Page_frontend-web/field_nama_lengkap_register'))
		WebUI.setText(findTestObject('Object Repository/Page_frontend-web/field_nama_lengkap_register'), Nama_Lengkap)
		WebUI.click(findTestObject('Object Repository/Page_frontend-web/field_email_register'))
		WebUI.setText(findTestObject('Object Repository/Page_frontend-web/field_email_register'), Email)
		WebUI.click(findTestObject('Object Repository/Page_frontend-web/button_Register'))
		
	}
	
	//Login

	@Given("I am on the login page")
	def I_am_on_the_login_page() {

		WebUI.openBrowser('https://alta-shop.vercel.app/')

		WebUI.maximizeWindow()

		WebUI.click(findTestObject('Object Repository/Page_frontend-web/icon_homepage'))
	}

	@When("I enter my (.*) and (.*)")
	def Enter_credentials(String email, String password) {
		WebUI.click(findTestObject('Object Repository/Page_frontend-web/field_email_login'))

		WebUI.setText(findTestObject('Object Repository/Page_frontend-web/field_email_login'), email)

		WebUI.click(findTestObject('Object Repository/Page_frontend-web/field_password_login'))

		WebUI.setText(findTestObject('Object Repository/Page_frontend-web/field_password_login'), password)
	}

	@And("I click login button")
	def Click_login_button() {
		WebUI.click(findTestObject('Object Repository/Page_frontend-web/button_Login'))
	}

	@Then("I should succesfully log in to my account")
	def Success_login() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/Page_frontend-web/valicon_succes_login'), 2)
	}

	//Login invalid credential

	@When("I enter an invalid (.*) and (.*)")
	def Enter_invalid_credential(String email, String password) {

		WebUI.click(findTestObject('Object Repository/Page_frontend-web/field_email_login'))

		WebUI.setText(findTestObject('Object Repository/Page_frontend-web/field_email_login'), email)

		WebUI.click(findTestObject('Object Repository/Page_frontend-web/field_password_login'))

		WebUI.setText(findTestObject('Object Repository/Page_frontend-web/field_password_login'), password)
	}

	@Then("I should not be able to login succesfully")
	def FailedLoginWithInvalidCredential() {

		WebUI.verifyElementPresent(findTestObject("Object Repository/Page_frontend-web/valtext_record not found_login"), 0)
		WebUI.closeBrowser()
	}

	// Login failed with email not inputted

	@When("I enter (.*) and let my email empty")
	def NotEnteredEmail(String password) {

		WebUI.click(findTestObject('Object Repository/Page_frontend-web/field_password_login'))

		WebUI.setText(findTestObject('Object Repository/Page_frontend-web/field_password_login'), password)
	}

	@Then("I should receive error message that email is required")
	def ErrorMessageEmailIsRequired() {

		WebUI.verifyElementPresent(findTestObject('Object Repository/Page_frontend-web/valtext_email is required_login'), 0)
	}

	// Login failed with password not inputted

	@When("I enter (.*) and let my password empty")
	def NotEnteredPassword(String email) {

		WebUI.click(findTestObject('Object Repository/Page_frontend-web/field_email_login'))

		WebUI.setText(findTestObject('Object Repository/Page_frontend-web/field_email_login'), email)
	}

	@Then("I should receive error message that password is required")
	def ErrorMessagePasswordIsRequired() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/Page_frontend-web/valtext_password is required_login'), 0)
		WebUI.closeBrowser()
	}


	// Integration
	@Given("I am on the homepage")
	def I_am_on_the_homepage() {
		WebUI.callTestCase(findTestCase('Test Cases/Login/LoginSuccess'), null)
	}

	@When ("I add product to my cart")
	def add_product_to_my_cart() {
		WebUI.callTestCase(findTestCase('Test Cases/Add To Cart/AddToCart (integration)'), null)
	}

	@And ("I can pay for it")
	def pay_for_it() {
		WebUI.callTestCase(findTestCase('Test Cases/Pay for a product/User can pay for a product (integration)'), null)
	}

	@Then("I can see the histori on transaction page")
	def history_on_transaction_page() {
		WebUI.callTestCase(findTestCase('Test Cases/View Transactions/ViewTransactions (Integration)'), null)
		WebUI.closeBrowser()
	}

	//View Detail

	@When("I click detail on the spesific product")
	def click_detail() {
		WebUI.click(findTestObject('Object Repository/Page_frontend-web/button_Detail'))
	}
	@Then("I can see the detail of the product")
	def see_detail_of_product() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/Page_frontend-web/valicon_star_detail'), 2)
		WebUI.click(findTestObject('Object Repository/Page_frontend-web/header_AltaShop'))
	}

	//Add to cart
	@When("I click beli button on the spesific product")
	def click_beli() {
		WebUI.click(findTestObject('Object Repository/Page_frontend-web/button_Beli'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Page_frontend-web/valicon_cart'), 0)
	}
	@And ("i click cart icon")
	def click_cart_icon() {
		WebUI.click(findTestObject('Object Repository/Page_frontend-web/cart_icon'))
	}

	@Then ("I can see that product has been added to my cart")
	def see_that_product_has_bee_added_to_my_cart () {
		WebUI.verifyElementPresent(findTestObject('Object Repository/Page_frontend-web/valtext_Total Qty_cart'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Page_frontend-web/valtext_Total Bayar_cart'), 0)
	}

	//Pay for product
	@When ("I click bayar button")
	def click_bayar_button() {
		WebUI.click(findTestObject('Object Repository/Page_frontend-web/button_Bayar'))
	}

	@Then ("I can see the product on my transacton history")
	def see_the_product_on_my_transaction_history() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/Page_frontend-web/valtext_Transactions'), 0)
		WebUI.click(findTestObject('Object Repository/Page_frontend-web/header_AltaShop'))

	}

	//View Transaction
	@When ("I click profile icon")
	def click_profile_icon() {
		WebUI.click(findTestObject('Object Repository/Page_frontend-web/valicon_succes_login'))
	}

	@And ("I click transaction button")
	def click_transaction_button() {
		WebUI.click(findTestObject('Object Repository/Page_frontend-web/button_Transaksi'))
	}

	@Then ("I am on the transaction page")
	def on_the_transaction_page() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/Page_frontend-web/valtext_Transactions'), 0)

	}

	//Pagination of view transaction
	//next page
	@When ("I click next page button")
	def click_next_page() {
		WebUI.refresh()
		WebUI.click(findTestObject('Object Repository/Page_frontend-web/NextPage'))
	}

	@Then ("I am on the next page of transaction")
	def on_the_next_page() {

	}
	//previous page
	@When ("I click previous page button")
	def click_previous_page() {
		WebUI.click(findTestObject('Object Repository/Page_frontend-web/PreviousPage'))
	}

	@Then ("I am on the previous page of transaction")
	def on_the_previous_page() {
		WebUI.click(findTestObject('Object Repository/Page_frontend-web/header_AltaShop'))
	}

	//Logout
	@And ("I click logout button")
	def click_logout_button() {
		WebUI.click(findTestObject('Object Repository/Page_frontend-web/button_Logout'))
	}


}

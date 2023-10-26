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

	//Product
	//Get all product
	@Given("The API is available")
	def API_is_available() {

	}

	@When("I send request to endpoint get all products")
	def send_req_get_all_products() {
		WS.sendRequest(findTestObject('Products/GetAllProduct'))
	}

	@Then("the response should be 200")
	def response_200() {
		def response = WS.sendRequest(findTestObject('Products/GetAllProduct'))
		WS.verifyResponseStatusCode(response, 200)
	}

	//Create a new product

	@When("I send request to endpoint create a new product")
	def send_req_create_a_new_product() {
		WS.sendRequest(findTestObject('Products/CreateANewProduct', [('name') : 'Sony PS5', ('desc') : 'play has no limits']))

	}

	@Then("the response should contain name, description, price and categories")
	def response_contain_name_desc_price() {
		def response = WS.sendRequest(findTestObject('Products/CreateANewProduct', [('name') : 'Sony PS5', ('desc') : 'play has no limits']))
		WS.verifyElementPropertyValue(response, 'data.Name', 'Sony PS5')

		WS.verifyElementPropertyValue(response, 'data.Description', 'play has no limits')

		WS.verifyElementPropertyValue(response, 'data.Price', 299)

		WS.verifyResponseStatusCode(response, 200)
	}

	//Create a new product failed with price not inputted
	@When("I send request to endpoint create a new product  with price not inputted")
	def send_req_create_new_product_with_price_not_inputted() {
		WS.sendRequest(findTestObject('Object Repository/Products/CreateNewProductPriceNotInputted'))

	}

	@Then("the response should be 400")
	def response_400() {
		def response = WS.sendRequest(findTestObject('Object Repository/Products/CreateNewProductPriceNotInputted'))
		WS.verifyResponseStatusCode(response, 400)
	}

	//Get product by id
	@When("I send request to endpoint get product by ID")
	def send_req_get_product_by_ID() {
		WS.sendRequest(findTestObject('Products/GetProductByID'))
	}

	@Then ("the response should contain ID Product same with the request")
	def response_contain_ID_Product() {
		def response = WS.sendRequest(findTestObject('Products/GetProductByID'))
		WS.verifyElementPropertyValue(response, 'data.ID', 85531)
		WS.verifyResponseStatusCode(response, 200)
	}

	//Get product by id with ID not found
	@When("I send request to endpoint get product by ID Product with ID not found")
	def send_req_get_product_by_ID_with_ID_not_found() {
		WS.sendRequest(findTestObject('Object Repository/Products/get product by id with ID not found'))

	}

	@And("the response should be 404")
	def response_404() {

		def response = WS.sendRequest(findTestObject('Object Repository/Products/get product by id with ID not found'))
		WS.verifyResponseStatusCode(response, 404)

	}

	@Then("the response should contain error record not found")
	def response_record_not_found() {

		def response = WS.sendRequest(findTestObject('Object Repository/Products/get product by id with ID not found'))
		WS.verifyElementPropertyValue(response, 'error', 'record not found')
	}

	//Delete a product

	@When("I send request to endpoint delete a product")
	def send_req_delete_a_product() {
		WS.sendRequest(findTestObject('Products/DeleteAProduct'))
	}
	@Then ("the response should data null")
	def response_data_null() {
		def response = WS.sendRequest(findTestObject('Products/DeleteAProduct'))
		WS.verifyElementPropertyValue(response, 'data', null)
		WS.verifyResponseStatusCode(response, 200)
	}

	//----------------------------------------------------------------------------------------------------------//

	//Product Categories
	//Create a category

	@When("I send POST request to endpoint create a category")
	def send_req_create_a_category() {
		WS.sendRequest(findTestObject('Product Categories/CreateACategory', [('name') : 'gaming', ('desc') : 'for gaming purposes']))
	}

	@Then("the response should contain name and description")
	def response_contain_name_and_description() {
		def response = WS.sendRequest(findTestObject('Product Categories/CreateACategory', [('name') : 'gaming', ('desc') : 'for gaming purposes']))

		WS.verifyElementPropertyValue(response, 'data.Name', 'gaming')

		WS.verifyElementPropertyValue(response, 'data.Description', 'for gaming purposes')

		WS.verifyResponseStatusCode(response, 200)
	}

	//Get all categories
	@When("I send GET request to endpoint get all categories")
	def send_req_get_all_categories() {
		def response = WS.sendRequest(findTestObject('Product Categories/GetAllCategories'))
		WS.verifyResponseStatusCode(response, 200)
	}

	//get categories by ID
	@When("I send GET request to endpoint get categories by ID")
	def send_req_get_categories_by_ID() {
		WS.sendRequest(findTestObject('Product Categories/GetCategoriesByID'))
	}

	@Then("the response should show categories based on ID")
	def response_categorise_based_on_ID() {
		def response = WS.sendRequest(findTestObject('Product Categories/GetCategoriesByID'))

		WS.verifyResponseStatusCode(response, 200)

		WS.verifyElementPropertyValue(response, 'data.ID', '29721')
	}

	//get categories by ID not found
	@When ("I send GET request to endpoint get categories by ID with ID not found")
	def send_req_categories_by_ID_with_ID_not_found() {
		def response = WS.sendRequest(findTestObject('Object Repository/Product Categories/GetCategoriesByID with ID not found'))
		WS.verifyResponseStatusCode(response, 404)
	}

	//Delete a category
	@When("I send DELETE request to endpoint delete a category")
	def send_req_delete_a_category() {

		def response = WS.sendRequest(findTestObject('Product Categories/DeleteACategory'))

		WS.verifyResponseStatusCode(response, 200)

		WS.verifyElementPropertyValue(response, 'data', null)
	}

	//----------------------------------------------------------------------------------------------------------//
	//Authentication
	//Register
	@When("I send POST request to endpoint register")
	def send_req_register() {
		def response = WS.sendRequest(findTestObject('Authentication/Register',  [('email') : 'valenimutt.siahaan@gmail.com', ('pass') : 'siahaan', ('fullname') : 'valen siahaan']))

		WS.verifyResponseStatusCode(response, 200)

		WS.verifyElementPropertyValue(response, 'data.Email', 'valenimutt.siahaan@gmail.com')
	}
	@Then("the response should verify that email is same with the request")
	def verify_email_same() {

	}

	//Register with the same email
	@When("I send POST request to endpoint register with same email")
	def send_req_register_with_same_email() {
		WS.sendRequest(findTestObject('Authentication/Register',  [('email') : 'valentina.siahaan@gmail.com', ('pass') : 'siahaan', ('fullname') : 'valen siahaan']))

	}

	@Then("the response should show error message duplicate key")
	def duplicate_key() {
		def response = WS.sendRequest(findTestObject('Authentication/Register',  [('email') : 'valentina.siahaan@gmail.com', ('pass') : 'siahaan', ('fullname') : 'valen siahaan']))
		WS.verifyResponseStatusCode(response, 400)
		WS.verifyElementPropertyValue(response, 'error', "ERROR: duplicate key value violates unique constraint \"users_email_key\" (SQLSTATE 23505)")
	}

	//Login
	@When("I send POST request to endpoint Login")
	def send_req_login() {
		def response = WS.sendRequest(findTestObject('Authentication/Login', [('email') : 'valentina.siahaan@kawanlamacorp.com', ('pass') : 'siahaan']))
		WS.verifyResponseStatusCode(response, 200)
	}

	//Login with invalid email
	@When("I send POST request to endpoint Login with invalid email")
	def send_req_login_with_invalid_email() {
		def response = WS.sendRequest(findTestObject('Authentication/Login', [('email') : 'valentina.siahaan@gg.com', ('pass') : 'siahaan']))
		WS.verifyResponseStatusCode(response, 400)
	}

	//Login with invalid password
	@When("I send POST request to endpoint Login with invalid password")
	def send_req_login_invalid_password() {
		WS.sendRequest(findTestObject('Authentication/Login', [('email') : 'valentina.siahaan@kawanlamacorp.com', ('pass') : '123###']))

	}

	@Then("the response should show error message email or password invalid")
	def response_email_or_password_invalid() {
		def response = WS.sendRequest(findTestObject('Authentication/Login', [('email') : 'valentina.siahaan@kawanlamacorp.com', ('pass') : '123###']))
		WS.verifyResponseStatusCode(response, 400)
		WS.verifyElementPropertyValue(response, 'error', "email or password is invalid")
	}


	//----------------------------------------------------------------------------------------------------------//
	//Hello
	@When("I send GET request to endpoint index")
	def send_req_index() {
		WS.sendRequest(findTestObject('Hello/Index'))

	}

	@Then("the response should contain hello")
	def response_contain_hello() {
		def response = WS.sendRequest(findTestObject('Hello/Index'))

		WS.verifyResponseStatusCode(response, 200)

		WS.verifyElementPropertyValue(response, 'data', 'hello')
	}
}
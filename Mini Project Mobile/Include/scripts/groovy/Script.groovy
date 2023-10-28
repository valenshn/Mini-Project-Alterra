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

	//User success add new item

	@Given("I already open the application")
	def open_the_app() {
		Mobile.startApplication('C:\\Users\\I00886.valentina\\Downloads\\mobile-app\\app-debug.apk', true)
	}

	@When("I click add button, i direct to add new item page")
	def click_add_button() {
		Mobile.tap(findTestObject('Add_button'), 0)
	}


	@And("I input the name and quantity")
	def input_name_and_qty() {

		Mobile.tap(findTestObject('Object Repository/FieldName'), 0)

		Mobile.setText(findTestObject('Object Repository/FieldName'), "apel", 0)

		Mobile.tap(findTestObject('Object Repository/quantityItem'), 0)

		Mobile.clearText(findTestObject('Object Repository/quantityItem'), 0)

		Mobile.setText(findTestObject('Object Repository/quantityItem'), "3" , 0)

		Mobile.tap(findTestObject('Object Repository/Dropdown'), 0)

		Mobile.tap(findTestObject('Object Repository/Fruit'), 0)

	}

	@And("I click add new item button")
	def click_add_new_item_btn() {
		Mobile.tap(findTestObject('Object Repository/contoh/AddItemButton'), 0)
	}

	@Then("I success to add the item")
	def success_add_item() {
		println("succes add item")
	}

	//User add new item failed with "name " not inputted

	@When("I enter the quantity and let the name empty")
	def name_is_empty() {

		Mobile.tap(findTestObject('Object Repository/quantityItem'), 0)

		Mobile.clearText(findTestObject('Object Repository/quantityItem'), 0)

		Mobile.setText(findTestObject('Object Repository/quantityItem'), "3" , 0)

		Mobile.tap(findTestObject('Object Repository/Dropdown'), 0)

		Mobile.tap(findTestObject('Object Repository/Fruit'), 0)
	}


	@Then("I can view an error message in email field")
	def error_message_in_email_field() {

		Mobile.verifyElementVisible(findTestObject('Object Repository/ErrorMessageNameNotInputted'), 0)
	}

	//User add new item failed with "quantity " not inputted

	@When("I enter the name and let the quantity empty")
	def quantity_is_empty() {
		Mobile.tap(findTestObject('Add_button'), 0)

		Mobile.tap(findTestObject('Object Repository/FieldName'), 0)

		Mobile.setText(findTestObject('Object Repository/FieldName'), "rambutan", 0)

		Mobile.tap(findTestObject('Object Repository/quantityItem'), 0)

		Mobile.clearText(findTestObject('Object Repository/quantityItem'), 0)


	}
	@Then("I can view an error message in quantity field")
	def error_message_in_qty_field() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/ErrorMessageQuantity'), 0)
	}

	//User add new item failed with "name" and "quantity " not inputted

	@When("I let name and the quantity empty")
	def name_qty_empty() {
		Mobile.tap(findTestObject('Add_button'), 0)

		Mobile.tap(findTestObject('Object Repository/quantityItem'), 0)

		Mobile.clearText(findTestObject('Object Repository/quantityItem'), 0)
	}

	@Then("I can view an error message in quantity field and name field")
	def error_name_qty() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/ErrorMessageQuantity'), 0)
		Mobile.verifyElementVisible(findTestObject('Object Repository/ErrorMessageNameNotInputted'), 0)

	}

	// User add new item failed with "quantity " is negative

	@When("I enter the name and negative quantity")
	def negative_qty() {
		Mobile.tap(findTestObject('Add_button'), 0)

		Mobile.tap(findTestObject('Object Repository/FieldName'), 0)

		Mobile.setText(findTestObject('Object Repository/FieldName'), "rambutan", 0)

		Mobile.tap(findTestObject('Object Repository/quantityItem'), 0)

		Mobile.clearText(findTestObject('Object Repository/quantityItem'), 0)

		Mobile.setText(findTestObject('Object Repository/quantityItem'), "-1" , 0)

		Mobile.tap(findTestObject('Object Repository/Dropdown'), 0)

		Mobile.tap(findTestObject('Object Repository/Fruit'), 0)
	}

	//Reset
	@And("I click reset button")
	def click_reset_btn() {
		Mobile.tap(findTestObject('Object Repository/ResetButton'), 0)
	}

	@Then("name will be reseted")
	def name_reseted() {
		println("name reseted")
		Mobile.closeApplication()
	}
}

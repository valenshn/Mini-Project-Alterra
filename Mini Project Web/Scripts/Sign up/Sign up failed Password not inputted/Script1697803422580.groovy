import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('https://alta-shop.vercel.app/')
WebUI.maximizeWindow()
WebUI.click(findTestObject('Object Repository/Page_frontend-web/icon_homepage'))
WebUI.click(findTestObject('Object Repository/Page_frontend-web/register_login_page'))
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_frontend-web/valtext_Register'), 2)
WebUI.click(findTestObject('Object Repository/Page_frontend-web/field_nama_lengkap_register'))
WebUI.setText(findTestObject('Object Repository/Page_frontend-web/field_nama_lengkap_register'), "valen")
WebUI.click(findTestObject('Object Repository/Page_frontend-web/field_email_register'))
WebUI.setText(findTestObject('Object Repository/Page_frontend-web/field_email_register'), "valen@gmail.com")
WebUI.click(findTestObject('Object Repository/Page_frontend-web/button_Register'))
WebUI.click(findTestObject('Object Repository/Page_frontend-web/button_Register'))
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_frontend-web/valtext_password is required_login'), 0)
WebUI.closeBrowser()
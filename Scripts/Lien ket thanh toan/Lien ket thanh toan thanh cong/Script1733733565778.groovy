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

Mobile.startExistingApplication('com.viettel.VTHome.dev')

Mobile.tap(findTestObject('Share device/tab_ca_nhan'), 0)

Mobile.tap(findTestObject('Object Repository/Lien ket thanh toan/obj_Lien_ket_thanh_toan'), 0)

Mobile.tap(findTestObject('Object Repository/Lien ket thanh toan/obj_quan_ly_lienLket'), 0)

Mobile.tap(findTestObject('Object Repository/Lien ket thanh toan/btn_lien_ket_ngay'), 0)

Mobile.verifyElementVisible(findTestObject('Settings Cam/Luu tru Cloud/popup_Lien_ket_tai_khoan_VTMoney'), 0)

Mobile.sendKeys(findTestObject('Settings Cam/Luu tru Cloud/popup_Lien_ket_tai_khoan_VTMoney_textbox_SDT'), '0375217287')

Mobile.tap(findTestObject('Settings Cam/Luu tru Cloud/popup_Lien_ket_tai_khoan_VTMoney_btn_Tiep_tuc'), 0)

WebUI.callTestCase(findTestCase('TC reuse/Man Lien ket thanh toan/Lien ket thanh toan'), [:], FailureHandling.STOP_ON_FAILURE)


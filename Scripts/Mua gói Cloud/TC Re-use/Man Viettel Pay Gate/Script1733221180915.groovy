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

Mobile.startExistingApplication(GlobalVariable.appID, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Settings Cam/Luu tru Cloud/viettelpay_gate_title_viettelpay_gate'), 0)

Mobile.tap(findTestObject('Settings Cam/Luu tru Cloud/viettelpay_gate_chon_viettel_money'), 0)

Mobile.sendKeys(findTestObject('Settings Cam/Luu tru Cloud/viettelpay_gate_textbox_SDT'), '0366602050')

Mobile.sendKeys(findTestObject('Settings Cam/Luu tru Cloud/viettelpay_gate_textbox_Mat_khau'), '123123')

Mobile.tap(findTestObject('Settings Cam/Luu tru Cloud/viettelpay_gate_btn_dang_nhap'), 0)

Mobile.setText(findTestObject('Settings Cam/Luu tru Cloud/viettelpay_gate_nhap_otp_lan1'), '1111', 0)

Mobile.tap(findTestObject('Settings Cam/Luu tru Cloud/viettelpay_gate_nhap_otp_lan1_btn_Xac_nhan'), 15)

Mobile.tap(findTestObject('Settings Cam/Luu tru Cloud/Dang ky luu tru cloud/ViettelPay Logo'), 0)

Mobile.tap(findTestObject('Settings Cam/Luu tru Cloud/viettelpay_gate_btn_Thanh_toan'), 20)

Mobile.setText(findTestObject('Settings Cam/Luu tru Cloud/viettelpay_gate_nhap_otp_lan2'), '1234', 10)

Mobile.tap(findTestObject('Settings Cam/Luu tru Cloud/viettelpay_gate_nhap_otp_lan2_btn_Xac_nhan (1)'), 10)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('Settings Cam/Luu tru Cloud/viettelpay_gate_btn_Thanh_toan'), 0)


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

Mobile.startExistingApplication('com.viettel.vhome2')

Mobile.tap(findTestObject('Tab Thiết bị/Tab_Thietbi'), 0)

Mobile.tap(findTestObject('Tab Thiết bị/choncam - CNME00000586'), 0)

Mobile.tap(findTestObject('Tab Thiết bị/tab_tinh_nang'), 0)

Mobile.tap(findTestObject('Tab Thiết bị/btn_chiaseTB'), 0)

Mobile.verifyElementVisible(findTestObject('Share device/title_chia_se_thiet_bi'), 0)

Mobile.setText(findTestObject('Share device/textbox_st'), '0394361753', 0)

Mobile.tap(findTestObject('Share device/nhap_sdt_btn_Tiep_tuc'), 0)

Mobile.verifyElementVisible(findTestObject('Share device/popup_tk_khong_ton_tai'), 0)

Mobile.tap(findTestObject('Share device/btn_OK_tk_da_duoc_chia_se'), 0)

Mobile.verifyElementVisible(findTestObject('Share device/title_chia_se_thiet_bi'), 0)

Mobile.closeApplication()


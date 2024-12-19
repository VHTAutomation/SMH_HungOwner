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

Mobile.tap(findTestObject('Tab Thiết bị/tab_thiet_bi'), 0)

Mobile.tap(findTestObject('Tab Thiết bị/chon_cam_dau_tien_danh_sach'), 0)

ten_cam = Mobile.getText(findTestObject('Tab Thiết bị/liveview_title_ten_cam'), 0)

Mobile.tap(findTestObject('Tab Thiết bị/btn_cai_dat'), 0)

Mobile.scrollToText('Dịch vụ Camera', FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Settings Cam/btn_Dich_vu_camera'), 0)

Mobile.verifyElementText(findTestObject('Settings Cam/Luu tru Cloud/Dich vu Cloud/dich_vu_camera_ten_camera'), ten_cam)

Mobile.tap(findTestObject('Dich vu Camera/btn_Dang_ky_ngay'), 0)

WebUI.callTestCase(findTestCase('Mua gói Cloud/TC Re-use/Man dang ky luu tru cloud/Gia han tu dong bang VTPay Gate_co TKLK'), 
    [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Mua gói Cloud/TC Re-use/Man Dich vu Cloud/Dich vu Cloud_khi dang ky bat gia han'), [:], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Mua gói Cloud/TC Re-use/Man Lich su mua hang - Chi tiet mua hang'), [:], FailureHandling.STOP_ON_FAILURE)


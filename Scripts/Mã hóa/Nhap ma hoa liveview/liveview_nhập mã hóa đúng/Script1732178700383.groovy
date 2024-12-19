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

Mobile.startExistingApplication(GlobalVariable.appID)

Mobile.tap(findTestObject('Tab Thiết bị/Tab_Thietbi'), 0)

Mobile.tap(findTestObject('Tab Thiết bị/chon_cam_t2_trong_danh_sach'), 0)

Mobile.verifyElementExist(findTestObject('Tab Thiết bị/Liveview_title_nhap_mat_khau_ma_hoa_'), 0)

Mobile.tap(findTestObject('Tab Thiết bị/liveview_textbox_nhap_ma_hoa'), 0)

Mobile.setText(findTestObject('Tab Thiết bị/liveview_textbox_nhap_ma_hoa'), GlobalVariable.ma_hoa_live, 0)

Mobile.tap(findTestObject('Tab Thiết bị/liview_ma_hoa_btn_OK'), 0)

//verify button Đàm thoại
String button_damthoai = Mobile.getAttribute(findTestObject('Object Repository/Share device/liveview_icon_dam_thoai'), enable, 
    10)

if (button_damthoai == true) {
    println('button enable')
}

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Tab Thiết bị/btn_cai_dat'), 0)

Mobile.verifyElementExist(findTestObject('Settings Cam/cai_dat_thong_bao'), 0)

Mobile.closeApplication()


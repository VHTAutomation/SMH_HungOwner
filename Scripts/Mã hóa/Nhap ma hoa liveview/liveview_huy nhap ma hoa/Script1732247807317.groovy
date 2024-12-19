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

Mobile.sendKeys(findTestObject('Tab Thiết bị/liveview_textbox_nhap_ma_hoa'), '123')

Mobile.tap(findTestObject('Tab Thiết bị/liveview_ma_hoa_btn_huy'), 0)

Mobile.verifyElementText(findTestObject('Tab Thiết bị/liveview_text_video_da_duoc_ma_hoa'), 'Video đã được mã hóa')

'verify trạng thái button đàm thoại'
String damthoai_display = Mobile.getAttribute(findTestObject('Object Repository/Settings Cam/liveview_btn_dam_thoai'), 'enabled', 
    10)

//println (damthoai_display)
if (damthoai_display == 'false') {
    println('button disable')
} else {
    println('button enable')
}


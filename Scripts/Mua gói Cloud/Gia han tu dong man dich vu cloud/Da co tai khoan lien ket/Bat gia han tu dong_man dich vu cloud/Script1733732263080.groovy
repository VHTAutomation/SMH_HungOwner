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

Mobile.verifyElementVisible(findTestObject('Settings Cam/Luu tru Cloud/title_dich_vu_cloud'), 0)

Mobile.verifyElementText(findTestObject('Settings Cam/Luu tru Cloud/Dich vu Cloud/dich_vu_cloud_text_dang_su_dung'), 'Đang sử dụng')

Mobile.verifyElementText(findTestObject('Settings Cam/Luu tru Cloud/Dich vu Cloud/dich_vu_cloud_text_tra_truoc'), 'Trả trước')

Mobile.verifyElementText(findTestObject('Settings Cam/Luu tru Cloud/Dich vu Cloud/dich_vu_cloud_text_Viettel_money'), 'Viettel Money')

Mobile.verifyElementVisible(findTestObject('Settings Cam/Luu tru Cloud/Dich vu Cloud/dich_vu_cloud_title_gia_han_tu_dong'), 0)

dvcloud_giahan = Mobile.getAttribute(findTestObject('Settings Cam/Luu tru Cloud/Dich vu Cloud/dich_vu_cloud_switch_btn_gia_han_tu_dong'), 
    'checked', 10)

if (dvcloud_giahan == false) {
    println('off gia han tu dong')
}

Mobile.tap(findTestObject('Settings Cam/Luu tru Cloud/Dich vu Cloud/dich_vu_cloud_switch_btn_gia_han_tu_dong'), 0)

Mobile.verifyElementVisible(findTestObject('Settings Cam/Luu tru Cloud/popup_chon_tai_khoan_tru_tien'), 0)

Mobile.tap(findTestObject('Settings Cam/Luu tru Cloud/popup_chon_tk_tru_tien_btn_Xac_nhan'), 0)

Mobile.sendKeys(findTestObject('Settings Cam/Luu tru Cloud/textbox_nhap_otp'), '123123')

Mobile.tap(findTestObject('Settings Cam/Luu tru Cloud/btn_xac_nhan_otp'), 0)

Mobile.verifyElementText(findTestObject('Settings Cam/Luu tru Cloud/text_Bat_thanh_toan_tu_dong_thanh_cong'), 'Bật thanh toán tự động thành công')

Mobile.verifyElementVisible(findTestObject('Settings Cam/Luu tru Cloud/title_dich_vu_cloud'), 0)

dvcloud_giahan = Mobile.getAttribute(findTestObject('Settings Cam/Luu tru Cloud/Dich vu Cloud/dich_vu_cloud_switch_btn_gia_han_tu_dong'), 
    'checked', 10)

if (dvcloud_giahan == true) {
    println('on gia han tu dong')
}

Mobile.verifyElementNotVisible(findTestObject('Settings Cam/Luu tru Cloud/Dich vu Cloud/dich_vu_cloud_btn_mua_them_goi'), 0)


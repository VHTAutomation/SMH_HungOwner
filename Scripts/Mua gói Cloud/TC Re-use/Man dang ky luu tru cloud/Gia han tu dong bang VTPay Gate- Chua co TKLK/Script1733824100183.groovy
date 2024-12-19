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

//Mobile.verifyElementText(findTestObject('Settings Cam/Luu tru Cloud/ten_thiet_bi_dang_ky'), ten_cam)

goi_luu_tru = Mobile.getText(findTestObject('Settings Cam/Luu tru Cloud/btn_luu_tru_su_kien_3_ngay'), 0)

Mobile.tap(findTestObject('Settings Cam/Luu tru Cloud/chon_5_phut'), 0)

gia_goi_cuoc = Mobile.getText(findTestObject('Settings Cam/Luu tru Cloud/Dang ky luu tru cloud/Dang_ky_cloud_gia_goi'), 0)

Mobile.scrollToText('Điều khoản Viettel Home.', FailureHandling.STOP_ON_FAILURE)

btn_giahan = Mobile.getAttribute(findTestObject('Settings Cam/Luu tru Cloud/btn_gia_han_tu_dong'), 'checked', 10)

if (btn_giahan == false) {
    println('off gia han tu dong')
}

Mobile.tap(findTestObject('Settings Cam/Luu tru Cloud/chon_tk_viettelpay_gate'), 10)

Mobile.tap(findTestObject('Settings Cam/Luu tru Cloud/btn_gia_han_tu_dong'), 0)

Mobile.verifyElementVisible(findTestObject('Settings Cam/Luu tru Cloud/Dang ky luu tru cloud/dang_ky_cloud_title_tai_khoan_tru_tien'), 0)

Mobile.tap(findTestObject('Settings Cam/Luu tru Cloud/Dang ky luu tru cloud/dang_ky_cloud_chon_tai_khoan_tru_tien'), 0)

Mobile.verifyElementVisible(findTestObject('Settings Cam/Luu tru Cloud/popup_chon_tai_khoan_tru_tien'), 0)

Mobile.tap(findTestObject('Settings Cam/Luu tru Cloud/popup_chon_tai_khoan_tru_tien_btn_lien_ket_ngay'), 0)

Mobile.verifyElementVisible(findTestObject('Settings Cam/Luu tru Cloud/popup_Lien_ket_tai_khoan_VTMoney'), 0)

Mobile.sendKeys(findTestObject('Settings Cam/Luu tru Cloud/popup_Lien_ket_tai_khoan_VTMoney_textbox_SDT'), '0375217287')

Mobile.tap(findTestObject('Settings Cam/Luu tru Cloud/popup_Lien_ket_tai_khoan_VTMoney_btn_Tiep_tuc'), 0)

WebUI.callTestCase(findTestCase('TC reuse/Man Lien ket thanh toan/Lien ket thanh toan'), [:], FailureHandling.STOP_ON_FAILURE)


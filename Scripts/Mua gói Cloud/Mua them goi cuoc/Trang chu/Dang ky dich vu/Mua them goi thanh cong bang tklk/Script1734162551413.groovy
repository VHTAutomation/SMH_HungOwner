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
import com.kms.katalon.core.testobject.ConditionType as ConditionType

Mobile.startExistingApplication(GlobalVariable.appID, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Trang chu/Dich vu Camera/btn_Dich_vu_camera'), 0)

Mobile.tap(findTestObject('Trang chu/Dich vu Camera/btn_dang_ky_dich_vu'), 0)

// XPath tìm phần tử có icon X
TestObject element = new TestObject('a')

'tạo xpath tìm'
element.addProperty('xpath', ConditionType.EQUALS, '//android.widget.ImageView[@resource-id = \'com.viettel.VTHome.dev:id/ivService\']')

// Kiểm tra và click
'tìm và click'
if (Mobile.verifyElementExist(element, 10)) {
    Mobile.tap(element, 10)

    println('Tìm thấy và click vào đối tượng')
} else {
    println('Không tìm thấy đối tượng')
}

ten_cam = Mobile.getText(findTestObject('Dich vu Camera/ten_cam'), 0)

Mobile.tap(findTestObject('Dich vu Camera/luu_tru_cloud_icon_mo_rong'), 0)

Mobile.tap(findTestObject('Settings Cam/Luu tru Cloud/Dich vu Cloud/dich_vu_cloud_btn_mua_them_goi'), 0)

Mobile.verifyElementText(findTestObject('Settings Cam/Luu tru Cloud/ten_thiet_bi_dang_ky'), ten_cam)

goi_luu_tru = Mobile.getText(findTestObject('Settings Cam/Luu tru Cloud/btn_luu_tru_su_kien_3_ngay'), 0)

Mobile.tap(findTestObject('Settings Cam/Luu tru Cloud/chon_5_phut'), 0)

gia_goi_cuoc = Mobile.getText(findTestObject('Settings Cam/Luu tru Cloud/Dang ky luu tru cloud/Dang_ky_cloud_gia_goi'), 
    0)

Mobile.scrollToText('Điều khoản Viettel Home.', FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementNotExist(findTestObject('Settings Cam/Luu tru Cloud/btn_gia_han_tu_dong'), 0)

Mobile.tap(findTestObject('Object Repository/Settings Cam/Luu tru Cloud/Chon_tai_khoan_lien_ket'), 10)

Mobile.tap(findTestObject('Settings Cam/Luu tru Cloud/btn_thanh_toan'), 0)

Mobile.verifyElementVisible(findTestObject('Settings Cam/Luu tru Cloud/popup_thong_bao_ma_xac_minh'), 0)

Mobile.tap(findTestObject('Settings Cam/Luu tru Cloud/popup_ma_xac_minh_btn_OK'), 0)

Mobile.sendKeys(findTestObject('Settings Cam/Luu tru Cloud/textbox_nhap_otp'), '123123')

Mobile.tap(findTestObject('Settings Cam/Luu tru Cloud/btn_xac_nhan_otp'), 0)

Mobile.verifyElementExist(findTestObject('Settings Cam/Luu tru Cloud/title_dich_vu_cloud'), 0)

Mobile.verifyElementText(findTestObject('Settings Cam/Luu tru Cloud/Dich vu Cloud/dich_vu_cloud_trang_thai_chua_kich_hoat'), 
    'Chưa kích hoạt')

Mobile.verifyElementExist(findTestObject('Settings Cam/Luu tru Cloud/Dich vu Cloud/dich_vu_cloud_btn_mua_them_goi'), 0)

Mobile.tap(findTestObject('Settings Cam/Luu tru Cloud/Dich vu Cloud/Dich_vu_cloud_btn_Lich_su_mua_hang'), 0)

WebUI.callTestCase(findTestCase('Mua gói Cloud/TC Re-use/Man Lich su mua hang - Chi tiet mua hang'), [:], FailureHandling.STOP_ON_FAILURE)


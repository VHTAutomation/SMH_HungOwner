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

Mobile.startExistingApplication(GlobalVariable.Environment_stg, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('ObjectTangGoiCloud/txt_Dich_vu_Camera'), 0)

TestObject SeeMoreButton = new TestObject('SeeMoreButton')

SeeMoreButton.addProperty('xpath', ConditionType.EQUALS, '//android.widget.TextView[@text = \'Lưu trữ cloud\']/following-sibling::android.widget.TextView[@text=\'Xem thêm\']')

'clcik vào button xem thêm'
Mobile.tap(SeeMoreButton, 20)

Mobile.tap(findTestObject('ObjectTangGoiCloud/btn_tang_nguoi_than'), 0)

Mobile.setText(findTestObject('ObjectTangGoiCloud/txtbox_nhap_so_dien_thoi'), '0866617796', 0)

String SerialCamera = '755464c536defb73'

Mobile.setText(findTestObject('ObjectTangGoiCloud/txt_serial_camera'), SerialCamera, 0)

Mobile.tap(findTestObject('ObjectTangGoiCloud/btn_Tiep'), 0)

TestObject dongtruoccuoc = new TestObject('dongtruoccuoc')

dongtruoccuoc.addProperty('xpath', ConditionType.EQUALS, '//android.widget.TextView[@text=\'5 phút\']')

Mobile.tap(dongtruoccuoc, 0)

Mobile.scrollToText('Tài khoản đã liên kết', FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('ObjectTangGoiCloud/rdbtn_tai_khoan_da_lien_ket'), 0)

Mobile.tap(findTestObject('ObjectTangGoiCloud/btn_thanh_toan'), 0)

Mobile.tap(findTestObject('ObjectTangGoiCloud/popup_gui_ma_xac_minh_btn_OK'), 0)

Mobile.setText(findTestObject('ObjectTangGoiCloud/txtbox_nhap_ma_OTP'), '123123', 0)

Mobile.tap(findTestObject('ObjectTangGoiCloud/btn_xac_nhan'), 0)

Mobile.tap(findTestObject('ObjectTangGoiCloud/icon_lich_su_mua_hang'), 0)

TestObject historyObject = new TestObject('historyObject')

// XPath để kiểm tra các điều kiện của ImageView và TextView
historyObject.addProperty('xpath', ConditionType.EQUALS, '//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1][.//android.widget.ImageView and .//android.widget.TextView[1][@text=\'Lưu trữ sự kiện 3 ngày\'] and .//android.widget.TextView[2][@text=\'1.000đ\'] and .//android.widget.TextView[6][@text=\'Chưa kích hoạt\']]')

// Kiểm tra sự tồn tại của phần tử trong thời gian chờ 20 giây
Mobile.verifyElementExist(historyObject, 20)

Mobile.tap(historyObject, 0)

Mobile.verifyElementText(findTestObject('ObjectTangGoiCloud/txt_thiet_bi_dang_ky'), SerialCamera)

Mobile.verifyElementText(findTestObject('ObjectTangGoiCloud/txt_Goi_cuoc_luu_tru'), 'Lưu trữ sự kiện 3 ngày')

Mobile.verifyElementText(findTestObject('ObjectTangGoiCloud/txt_dong_truoc_cuoc'), '5 phút')

Mobile.verifyElementText(findTestObject('ObjectTangGoiCloud/txt_trang_thai_goi_cuoc'), 'Chưa kích hoạt')

Mobile.verifyElementText(findTestObject('ObjectTangGoiCloud/txt_tong_tien_thanh_toan'), '1.000đ')

Mobile.verifyElementText(findTestObject('ObjectTangGoiCloud/txt_sdt_duoc_tang'), '0866617796')

Mobile.tap(findTestObject('ObjectTangGoiCloud/icon_back'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('ObjectTangGoiCloud/icon_back'), 0)

Mobile.tap(findTestObject('ObjectTangGoiCloud/icon_back'), 0)

Mobile.tap(findTestObject('ObjectTangGoiCloud/icon_back'), 0)

Mobile.tap(findTestObject('ObjectTangGoiCloud/Tab_Ca_Nhan'), 0)

WebUI.callTestCase(findTestCase('DangXuat/Dang xuat thanh cong'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('DangNhap/Dang nhap thanh cong tk duoc tang goi Cloud'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('ObjectTangGoiCloud/Tab_Thiet_Bi'), 0)

TestObject CameraObject = new TestObject('CameraObject')

// XPath để kiểm tra các điều kiện của ImageView và TextView
CameraObject.addProperty('xpath', ConditionType.EQUALS, "//androidx.recyclerview.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[contains(@text,'$SerialCamera')]")

// Kiểm tra sự tồn tại của phần tử trong thời gian chờ 20 giây
Mobile.tap(CameraObject, 20)

Mobile.tap(findTestObject('ObjectTangGoiCloud/icon_cai_dat_camera'), 0)

Mobile.scrollToText('Lưu trữ Cloud', FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('ObjectTangGoiCloud/icon_xem_thong_tin_goi_Cloud'), 0)

Mobile.tap(findTestObject('ObjectTangGoiCloud/icon_lich_su_mua_hang'), 0)

Mobile.verifyElementExist(historyObject, 20)

Mobile.tap(historyObject, 0)

Mobile.verifyElementText(findTestObject('ObjectTangGoiCloud/txt_thiet_bi_dang_ky'), SerialCamera)

Mobile.verifyElementText(findTestObject('ObjectTangGoiCloud/txt_Goi_cuoc_luu_tru'), 'Lưu trữ sự kiện 3 ngày')

Mobile.verifyElementText(findTestObject('ObjectTangGoiCloud/txt_dong_truoc_cuoc'), '5 phút')

Mobile.verifyElementText(findTestObject('ObjectTangGoiCloud/txt_trang_thai_goi_cuoc'), 'Chưa kích hoạt')

Mobile.verifyElementText(findTestObject('ObjectTangGoiCloud/txt_tong_tien_thanh_toan'), '1.000đ')

Mobile.verifyElementText(findTestObject('ObjectTangGoiCloud/txt_sdt_tang_goi_cloud'), '0986784498')

Mobile.closeApplication()


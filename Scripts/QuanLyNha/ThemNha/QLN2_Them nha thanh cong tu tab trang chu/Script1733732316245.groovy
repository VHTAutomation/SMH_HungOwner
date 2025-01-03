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

tapDynamicObject('//android.widget.TextView[1]', 0)

Mobile.tap(findTestObject('ObjectThemNha/popup_chon _nha_Quan_Ly_Nha'), 0)

Mobile.tap(findTestObject('ObjectThemNha/btn_them_nha_tren_man_quan_ly_nha'), 0)

Mobile.setText(findTestObject('ObjectThemNha/txtbox_nhap_ten_nha'), 'auto_trang_chu', 0)

Mobile.tap(findTestObject('ObjectThemNha/txtbox_vi_tri_nha'), 0)

Mobile.tap(findTestObject('ObjectThemNha/btn_Luu_tren_man_chon_dia_diem'), 0)

Mobile.tap(findTestObject('ObjectThemNha/btn_Luu_tren_man_them_nha'), 0)

Mobile.verifyElementVisible(findTestObject('ObjectThemNha/popup_them_nha_thanh_cong_image'), 0)

Mobile.verifyElementVisible(findTestObject('ObjectThemNha/popup_them_nha_thanh_cong_title'), 0)

Mobile.verifyElementVisible(findTestObject('ObjectThemNha/popup_them_nha_thanh_cong_noi_dung'), 0)

Mobile.tap(findTestObject('ObjectThemNha/popup_them_nha_thanh_cong_btn_OK'), 0)

TestObject houseItem = new TestObject('houseItem')

houseItem.addProperty('xpath', ConditionType.EQUALS, "//android.widget.TextView[contains(@text, '$GlobalVariable.housename_trangchu')]")

'Kiểm tra nhà vừa tạo trên màn Quản lý nhà'
Mobile.verifyElementExist(houseItem, 10 // timeout 10s
    )

Mobile.tap(findTestObject('ObjectThemNha/icon_back'), 0)

tapDynamicObject('//android.widget.TextView[1]', 0)

'Kiểm tra nhà vừa tạo trên popup chọn nhà trên trang chủ'
Mobile.verifyElementExist(houseItem, 10)

Mobile.tap(houseItem, 0)

Mobile.tap(findTestObject('ObjectThemNha/Tab_Thiet_Bi'), 0)

'Kiểm tra nhà vừa tạo trên popup chọn nhà trên tab thiết bị'
Mobile.verifyElementExist(houseItem, 10)

//Mobile.verifyElementExist(findTestObject('null'), 0)
// Tạo Test Object động
//Tạo một Test Object với tên dynamicObject.Test Object này chỉ tồn tại trong bộ nhớ trong khi script chạy và không được lưu trong Object Repository.
// Sử dụng Khi không muốn lưu trữ quá nhiều Test Object trong Object Repository
//Khi phần tử có vị trí, tên, hoặc thuộc tính thay đổi theo ngữ cảnh.
// Khi cần kiểm thử động và linh hoạt với các điều kiện khác nhau
//XPath của phần tử đầu tiên cần thao tác.
// Thực hiện tap khi phần tử đã xuất hiện
//Hành động "tap" (nhấn) lên phần tử được đại diện bởi dynamicObject.Thời gian chờ (timeout) là 0 giây.
Mobile.closeApplication()

def tapDynamicObject(String xpath, int timeout) {
    TestObject dynamicObject = new TestObject('dynamicObject')

    dynamicObject.addProperty('xpath', ConditionType.EQUALS, xpath)

    Mobile.tap(dynamicObject, 0)
}


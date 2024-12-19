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

Mobile.startExistingApplication(GlobalVariable.Environment_pro, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/ObjectThemNha/Tab_Ca_Nhan'), 0)

Mobile.tap(findTestObject('Object Repository/ObjectThemNha/Menu_Quan_Ly_Chung'), 0)

Mobile.tap(findTestObject('Object Repository/ObjectThemNha/Mennu_Quan_Ly_Nha'), 0)

Mobile.tap(findTestObject('Object Repository/ObjectThemNha/btn_them_nha_tren_man_quan_ly_nha'), 0)

Mobile.setText(findTestObject('Object Repository/ObjectThemNha/txtbox_nhap_ten_nha'), 'auto_ca_nhan', 0)

Mobile.tap(findTestObject('Object Repository/ObjectThemNha/btn_Luu_tren_man_them_nha'), 0)

Mobile.verifyElementVisible(findTestObject('ObjectThemNha/popup_them_nha_thanh_cong_image'), 0)

Mobile.verifyElementVisible(findTestObject('ObjectThemNha/popup_them_nha_thanh_cong_title'), 0)

Mobile.verifyElementVisible(findTestObject('ObjectThemNha/popup_them_nha_thanh_cong_noi_dung'), 0)

Mobile.tap(findTestObject('ObjectThemNha/popup_them_nha_thanh_cong_btn_OK'), 0)

TestObject houseItem = new TestObject('houseItem')

houseItem.addProperty('xpath', ConditionType.EQUALS, "//android.widget.TextView[contains(@text, '$GlobalVariable.housename_canhan')]")

'Kiểm tra nha vừa tạo trên màn Quản lý nhà'
Mobile.verifyElementExist(houseItem, 10 // timeout 10s
    )

//Mobile.verifyElementExist(findTestObject('null'), 0)
'Nhan nut back tren man quan ly nha'
Mobile.tap(findTestObject('Object Repository/ObjectThemNha/icon_back'), 0)

'Nhan nut back tren man quan ly chung'
Mobile.tap(findTestObject('Object Repository/ObjectThemNha/icon_back'), 0)

'Nhan tab trang chu'
Mobile.tap(findTestObject('Object Repository/ObjectThemNha/Tab_Trang_Chu'), 0)

'Nhan chon nha dau danh sach de hien thi danh sách nha'
tapDynamicObject('//android.widget.TextView[1]', 0)

'Chọn nhà auto_ca_nhan vừa thêm'
Mobile.tap(houseItem, 0)

'Nhấn tab thiết bị để kiểm tra nhà vừa thêm'
Mobile.tap(findTestObject('ObjectThemNha/Tab_Thiet_Bi'), 0)

'Kiểm tra nhà vừa tạo trên tab thiết bị'
Mobile.verifyElementExist(houseItem, 10)

Mobile.closeApplication()

def tapDynamicObject(String xpath, int timeout) {
    TestObject dynamicObject = new TestObject('dynamicObject')

    dynamicObject.addProperty('xpath', ConditionType.EQUALS, xpath)

    Mobile.tap(dynamicObject, 0)
}


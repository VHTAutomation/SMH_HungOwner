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

Mobile.startExistingApplication('com.viettel.vhome2&hl=vi', FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('ObjectSuaNha/Tab_Thiet_Bi'), 0)

tapDynamicObject('//android.widget.TextView[1]', 0)

Mobile.tap(findTestObject('ObjectSuaNha/popup_chon _nha_Quan_Ly_Nha'), 0)

TestObject houseItem = new TestObject('houseItem')

houseItem.addProperty('xpath', ConditionType.EQUALS, "//android.widget.TextView[contains(@text, '$GlobalVariable.housename_thietbi')]")

Mobile.tap(houseItem, 0)

Mobile.tap(findTestObject('ObjectSuaNha/Menu_doi_ten_nha_tren_man_quan_ly_nha'), 0)


String updatedhousename_thietbi = "${GlobalVariable.housename_thietbi}_Update"

Mobile.setText(findTestObject('ObjectSuaNha/txtbox_nhap_ten_nha'), updatedhousename_thietbi, 0)
Mobile.tap(findTestObject('ObjectSuaNha/btn_Luu_tren_man_Doi_ ten_nha'), 0)

Mobile.verifyElementVisible(findTestObject('ObjectSuaNha/popup_doi_ten _nha_thanh_cong_image'), 0)

Mobile.verifyElementVisible(findTestObject('ObjectSuaNha/popup_doi_ten _nha_thanh_cong_title'), 0)

Mobile.verifyElementVisible(findTestObject('ObjectSuaNha/popup_doi_ten _nha_thanh_cong_noi dung'), 0)

Mobile.tap(findTestObject('ObjectSuaNha/btn_OK_tren_popup_edit_nha_thanh_cong'), 0)

Mobile.tap(findTestObject('ObjectSuaNha/icon_back'), 0)

Mobile.tap(findTestObject('ObjectSuaNha/icon_back'), 0)


TestObject houseItem_update = new TestObject('houseItem_update')

houseItem_update.addProperty('xpath', ConditionType.EQUALS, "//android.widget.TextView[contains(@text,'$updatedhousename_thietbi')]")
'Kiểm tra nhà vừa edit trên màn quản lý nhà'
Mobile.verifyElementExist(houseItem_update, 10)

Mobile.tap(findTestObject('ObjectSuaNha/icon_back'), 0)


tapDynamicObject('//android.widget.TextView[1]', 0)
'Chọn nhà vừa edit'
Mobile.tap(houseItem_update, 0)

Mobile.tap(findTestObject('ObjectSuaNha/Tab_Trang_Chu'), 0)
'Kiểm tra nhà vừa edit trên trang chủ'
Mobile.verifyElementVisible(houseItem_update, 0)

Mobile.closeApplication()

def tapDynamicObject(String xpath, int timeout) {
    TestObject dynamicObject = new TestObject('dynamicObject')

    dynamicObject.addProperty('xpath', ConditionType.EQUALS, xpath)

    Mobile.tap(dynamicObject, 0)
}


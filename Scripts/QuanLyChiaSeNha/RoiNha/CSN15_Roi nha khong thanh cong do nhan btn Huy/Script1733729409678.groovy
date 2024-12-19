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
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.android.AndroidDriver as AndroidDriver
import io.appium.java_client.android.AndroidElement as AndroidElement
import org.openqa.selenium.NoSuchElementException as NoSuchElementException
import org.openqa.selenium.support.ui.ExpectedConditions as ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait as WebDriverWait

Mobile.startExistingApplication(GlobalVariable.Environment_pro, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('ObjectChiaSeNha/Tab_Ca_Nhan'), 0)

Mobile.tap(findTestObject('ObjectChiaSeNha/Menu_Quan_Ly_Chung'), 0)

Mobile.tap(findTestObject('ObjectChiaSeNha/Menu_Quan_Ly_Nha'), 0)

TestObject houseObject = new TestObject('houseObject')

houseObject.addProperty('xpath', ConditionType.EQUALS, "//androidx.recyclerview.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[contains(@text,'$GlobalVariable.houseNameShared_Member')]")

'Nhấn vào nhà My Home'
Mobile.tap(houseObject, 0 // tap vào Nhà được chia sẻ:" Nhà Chia Sẻ"
    )

'Nhấn button rời nhà'
Mobile.tap(findTestObject('ObjectChiaSeNha/btn_roi_nha'), 0)

'Kiểm tra popup xác nhận rời nhà'
Mobile.verifyElementVisible(findTestObject('ObjectChiaSeNha/popup_thong_bao_roi-nha_txtfield_ban_co_chac_muon_roi_nha'), 0)

Mobile.verifyElementVisible(findTestObject('ObjectChiaSeNha/popup_thong_bao_roi_nha_btn_huy_bo'), 0)

Mobile.verifyElementVisible(findTestObject('ObjectChiaSeNha/popup_thong_bao_roi_nha_btn_OK'), 0)

Mobile.tap(findTestObject('ObjectChiaSeNha/popup_thong_bao_roi_nha_btn_huy_bo'), 0)

TestObject peopleObject = new TestObject('peopleObject')

peopleObject.addProperty('xpath', ConditionType.EQUALS, "//androidx.recyclerview.widget.RecyclerView//android.view.ViewGroup[.//android.widget.TextView[@text='$GlobalVariable.Bietdanh_Member'] and .//android.widget.TextView[@text='$GlobalVariable.user_shared']and .//android.widget.TextView[@text='Thành viên']]")

'Kiểm tra tồn tại thành viên sau khi nhấn huỷ trong mục Danh sách thành viên trong nhà được chia sẻ'
Mobile.verifyElementExist(peopleObject, 10 // timeout 10s
    )

Mobile.tap(findTestObject('ObjectChiaSeNha/icon_back'), 0)

'Kiểm tra sự tồn tại của nhà được chia sẻ trên màn quản lý nhà chứa danh sách nhà của tài khoản'
TestObject houseItem = new TestObject('houseItem')

houseItem.addProperty('xpath', ConditionType.EQUALS, "//android.widget.TextView[contains(@text, '$GlobalVariable.houseNameShared_Member')]")

Mobile.verifyElementExist(houseItem, 20)

Mobile.tap(findTestObject('ObjectChiaSeNha/icon_back'), 0)

Mobile.tap(findTestObject('ObjectChiaSeNha/icon_back'), 0)

Mobile.tap(findTestObject('ObjectChiaSeNha/Tab_Trang_Chu'), 0)

tapDynamicObject('//android.widget.TextView[1]', 0)

TestObject houseObject_home = new TestObject()

houseObject_home.addProperty('xpath', ConditionType.EQUALS, "//androidx.recyclerview.widget.RecyclerView//androidx.appcompat.widget.LinearLayoutCompat[ .//android.widget.TextView[@text='$GlobalVariable.houseNameShared_Member'] and .//android.widget.ImageView]")

'Kiểm tra tồn tại của nhà được chia sẻ trên popup chọn nhà trên trang chủ'
Mobile.verifyElementExist(houseObject_home, 10 // timeout 10s
    )

// Tap vào nhà chia sẻ trên popup chọn nhà trên tab trang chủ
Mobile.tap(houseObject_home, 10)

Mobile.tap(findTestObject('ObjectChiaSeNha/Tab_Thiet_Bi'), 0)

Mobile.verifyElementExist(findTestObject('ObjectChiaSeNha/txt_Nha_Chia_Se_tren_tab_thiet_bi'), 0)

Mobile.tap(findTestObject('ObjectChiaSeNha/Tab_Ca_Nhan'), 0)

'Đăng xuất khỏi tài khoản được chia sẻ'
WebUI.callTestCase(findTestCase('DangXuat/Dang xuat thanh cong'), [:], FailureHandling.STOP_ON_FAILURE)

'Đăng nhập vào tài khoản chia sẻ'
WebUI.callTestCase(findTestCase('DangNhap/Dang nhap thanh cong Tk chia se'), [:], FailureHandling.STOP_ON_FAILURE)

tapDynamicObject('//android.widget.TextView[1]', 0)

Mobile.tap(findTestObject('ObjectChiaSeNha/popup_chon _nha_Quan_Ly_Nha'), 0)

'Nhấn vào nhà chia sẻ trên màn Quản lý nhà chứa danh sách nhà của tài khoản chia sẻ'
Mobile.tap(houseObject, 0)

' Kiểm tra lại đối tượng nhà vừa chia sẻ với quyền member sau khi huỷ bỏ rời nhà từ tk được chia sẻ'
Mobile.verifyElementExist(peopleObject, 10 // timeout 10s
    )

Mobile.closeApplication()

def tapDynamicObject(String xpath, int timeout) {
    TestObject dynamicObject = new TestObject('dynamicObject')

    dynamicObject.addProperty('xpath', ConditionType.EQUALS, xpath)

    Mobile.tap(dynamicObject, 0)
}


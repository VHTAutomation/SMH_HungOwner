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

Mobile.startExistingApplication(GlobalVariable.Environment_pro, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('ObjectChiaSeNha/Tab_Ca_Nhan'), 0)

Mobile.tap(findTestObject('ObjectChiaSeNha/Menu_Quan_Ly_Chung'), 0)

Mobile.tap(findTestObject('ObjectChiaSeNha/Menu_Quan_Ly_Nha'), 0)

// Verify đối tượng nhà trong mục lời mời vào nhà
TestObject invitationObject = new TestObject()

invitationObject.addProperty('xpath', ConditionType.EQUALS, "//androidx.recyclerview.widget.RecyclerView[2]//android.view.ViewGroup[.//android.widget.TextView[@text='$GlobalVariable.houseNameShared_Member'] and .//android.widget.TextView[@text='Chấp nhận'] and .//android.widget.TextView[@text='Từ chối']]")
'Kiểm tra sự tồn tại của nhà được chia sẻ trong mục lời mời vào nhà'
Mobile.verifyElementExist(invitationObject, 20)

// Xây dựng XPath cho phần tử "Chấp nhận" dựa trên tên nhà
TestObject acceptButton = new TestObject()

acceptButton.addProperty('xpath', ConditionType.EQUALS, "//android.widget.TextView[@text = '$GlobalVariable.houseNameShared_Member']/following-sibling::android.widget.TextView[@text='Chấp nhận']")

// Kiểm tra xem phần tử có tồn tại không
Mobile.verifyElementExist(acceptButton, 10)

'Thực hiện tap vào phần tử "Chấp nhận"'
Mobile.tap(acceptButton, 10)

//  Kiểm tra trên danh sách nhà sau khi nhấn chấp nhận
TestObject houseItem = new TestObject()

houseItem.addProperty('xpath', ConditionType.CONTAINS, "//android.widget.TextView[contains(@text, '$GlobalVariable.houseNameShared_Member')]")

'Thực hiện tap vào nhà được chia sẻ vừa thực hiện nhấn chấp nhận'
Mobile.tap(houseItem, 10)

// Tạo đối tượng động với XPath thành viên trong danh sách
TestObject peopleObject = new TestObject()

peopleObject.addProperty('xpath', ConditionType.EQUALS, "//androidx.recyclerview.widget.RecyclerView//android.view.ViewGroup[.//android.widget.TextView[@text='$GlobalVariable.Bietdanh_Member'] and .//android.widget.TextView[@text='$GlobalVariable.user_shared'] and .//android.widget.TextView[@text='Thành viên']]")

' Kiểm tra sự tồn tại của thành viên sau khi nhấn xác nhận trên màn hình Quản lý nhà của nhà được chia sẻ'
Mobile.verifyElementExist(peopleObject, 10)

Mobile.tap(findTestObject('ObjectChiaSeNha/icon_back'), 0)

Mobile.tap(findTestObject('ObjectChiaSeNha/icon_back'), 0)

Mobile.tap(findTestObject('ObjectChiaSeNha/icon_back'), 0)

Mobile.tap(findTestObject('ObjectChiaSeNha/Tab_Trang_Chu'), 0)

tapDynamicObject('//android.widget.TextView[1]', 0)

TestObject houseObject_home = new TestObject()

houseObject_home.addProperty('xpath', ConditionType.EQUALS, "//androidx.recyclerview.widget.RecyclerView//androidx.appcompat.widget.LinearLayoutCompat[ .//android.widget.TextView[@text='$GlobalVariable.houseNameShared_Member'] and .//android.widget.ImageView]")

'Kiểm tra việc tồn tại của nhà được chia sẻ trên popup chọn nhà trên tab trang chủ'
Mobile.verifyElementExist(houseObject_home, 10 // timeout 10s
    )

'Tap vào nhà chia sẻ trên popup chọn nhà trên tab trang chủ'
Mobile.tap(houseObject_home, 10)

Mobile.tap(findTestObject('ObjectChiaSeNha/Tab_Thiet_Bi'), 0)
'Kiểm tra việc tồn tại của nhà được chia sẻ trên tab thiết bị'
Mobile.verifyElementVisible(findTestObject('ObjectChiaSeNha/txt_Nha_My_Home_tren_tab_thiet_bi'), 0)

Mobile.tap(findTestObject('ObjectChiaSeNha/Tab_Ca_Nhan'), 0)
'Đăng xuất khỏi tài khoản được chia sẻ'
WebUI.callTestCase(findTestCase('DangXuat/Dang xuat thanh cong'), [:], FailureHandling.STOP_ON_FAILURE)
'Đăng nhập vào tài khoản chia sẻ'
WebUI.callTestCase(findTestCase('DangNhap/Dang nhap thanh cong Tk chia se'), [:], FailureHandling.STOP_ON_FAILURE)

// Kiểm tra trạng thái thành viên bên tài khoản chia sẻ
tapDynamicObject('//android.widget.TextView[1]', 0)

Mobile.tap(findTestObject('ObjectChiaSeNha/popup_chon _nha_Quan_Ly_Nha'), 0)

// Sử dụng XPath để chọn phần tử nhà bất kỳ trên danh sách tại màn quản lý nhà
TestObject houseObject = new TestObject()

houseObject.addProperty('xpath', ConditionType.CONTAINS, "//androidx.recyclerview.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[contains(@text,'$GlobalVariable.houseNameShared_Member')]")
'Nhấn vào nhà chia sẻ trên màn Quản lý nhà chứa danh sách nhà của tài khoản'
Mobile.tap(houseObject, 0)

'Kiểm tra lại đối tượng nhà vừa chia sẻ với quyền Admin sau khi chấp nhận'
Mobile.verifyElementExist(peopleObject, 10 // timeout 10s
    )

Mobile.closeApplication()

def tapDynamicObject(String xpath, int timeout) {
    TestObject dynamicObject = new TestObject('dynamicObject')

    dynamicObject.addProperty('xpath', ConditionType.EQUALS, xpath)

    Mobile.tap(dynamicObject, 0)
}


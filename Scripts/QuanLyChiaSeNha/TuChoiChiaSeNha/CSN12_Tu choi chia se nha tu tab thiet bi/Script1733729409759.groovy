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

Mobile.tap(findTestObject('ObjectChiaSeNha/Tab_Thiet_Bi'), 0)

tapDynamicObject('//android.widget.TextView[1]', 0)

Mobile.tap(findTestObject('ObjectChiaSeNha/popup_chon _nha_Quan_Ly_Nha'), 0)

// Verify đối tượng nhà trong mục lời mời vào nhà
TestObject invitationObject = new TestObject('invitationObject')

invitationObject.addProperty('xpath', ConditionType.EQUALS, "//androidx.recyclerview.widget.RecyclerView[2]//android.view.ViewGroup[.//android.widget.TextView[@text='$GlobalVariable.houseNameShared_Member'] and .//android.widget.TextView[@text='Chấp nhận'] and .//android.widget.TextView[@text='Từ chối']]")

Mobile.verifyElementExist(invitationObject, 20)

// Xây dựng XPath cho phần tử "Từ chỗi" dựa trên tên nhà
TestObject rejectButton = new TestObject('rejectButton')

rejectButton.addProperty('xpath', ConditionType.EQUALS, "//android.widget.TextView[@text = '$GlobalVariable.houseNameShared_Member']/following-sibling::android.widget.TextView[@text='Từ chối']")

// Kiểm tra xem phần tử có tồn tại không
Mobile.verifyElementExist(rejectButton, 10)

// Thực hiện tap vào phần tử "Từ chối
Mobile.tap(rejectButton, 10)

//Kiểm tra trên danh sách nhà sau khi nhấn từ chối
TestObject houseItem = new TestObject('houseItem')

houseItem.addProperty('xpath', ConditionType.EQUALS, "//android.widget.TextView[contains(@text, '$GlobalVariable.houseNameShared_Member')]")

Mobile.verifyElementNotExist(houseItem, 20)

Mobile.tap(findTestObject('ObjectChiaSeNha/icon_back'), 0)

tapDynamicObject('//android.widget.TextView[1]', 0)

TestObject houseObject_home = new TestObject('houseObject_home')

houseObject_home.addProperty('xpath', ConditionType.EQUALS, "//androidx.recyclerview.widget.RecyclerView//androidx.appcompat.widget.LinearLayoutCompat[ .//android.widget.TextView[@text='$GlobalVariable.houseNameShared_Member'] and .//android.widget.ImageView]")

// Kiểm tra sự tồn tại
Mobile.verifyElementNotExist(houseObject_home, 10 // timeout 10s
    )

Mobile.tap(findTestObject('ObjectChiaSeNha/NhanRaNgoaiBottomSheet'), 0)

Mobile.tap(findTestObject('ObjectChiaSeNha/Tab_Trang_Chu'), 0)

tapDynamicObject('//android.widget.TextView[1]', 0)

Mobile.verifyElementNotExist(houseObject_home, 10)

'Tap ra vùng ngoài popup chọn nhà để đóng popup'
Mobile.tap(findTestObject('ObjectChiaSeNha/NhanRaNgoaiBottomSheet'), 0)

Mobile.tap(findTestObject('ObjectChiaSeNha/Tab_Ca_Nhan'), 0)

WebUI.callTestCase(findTestCase('DangXuat/Dang xuat thanh cong'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('DangNhap/Dang nhap thanh cong Tk chia se'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('ObjectChiaSeNha/Tab_Ca_Nhan'), 0)

Mobile.tap(findTestObject('ObjectChiaSeNha/Menu_Quan_Ly_Chung'), 0)

Mobile.tap(findTestObject('ObjectChiaSeNha/Menu_Quan_Ly_Nha'), 0)

TestObject houseObject = new TestObject('houseObject')

houseObject.addProperty('xpath', ConditionType.EQUALS, "//androidx.recyclerview.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[contains(@text,'$GlobalVariable.houseNameShared_Member')]")

Mobile.tap(houseObject, 0)

TestObject peopleObject = new TestObject('peopleObject')

peopleObject.addProperty('xpath', ConditionType.EQUALS, "//androidx.recyclerview.widget.RecyclerView//android.view.ViewGroup[.//android.widget.TextView[@text='$GlobalVariable.Bietdanh_Member'] and .//android.widget.TextView[@text='$GlobalVariable.user_shared']]")

// Kiểm tra sự tồn tại
Mobile.verifyElementNotExist(peopleObject, 10 // timeout 10s
    )

Mobile.closeApplication()

def tapDynamicObject(String xpath, int timeout) {
    TestObject dynamicObject = new TestObject('dynamicObject')

    dynamicObject.addProperty('xpath', ConditionType.EQUALS, xpath)

    Mobile.tap(dynamicObject, 0)
}


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

// Sử dụng XPath để chọn phần tử nhà bất kỳ trên danh sách tại màn quản lý nhà
TestObject houseObject = new TestObject()

houseObject.addProperty('xpath', ConditionType.EQUALS, "//androidx.recyclerview.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[contains(@text,'$GlobalVariable.houseNameShared_Member')]")

//String houseNameShared = Mobile.getText(houseObject, 10)
//GlobalVariable.houseNameShared_Admin = houseNameShared
// Kiểm tra biến houseNameShared có giá trị chưa
' Nhấn chọn nhà" Nhà Chia Sẻ"'
Mobile.tap(houseObject, 0)

TestObject peopleObject_noupdate = new TestObject()

peopleObject_noupdate.addProperty('xpath', ConditionType.EQUALS, "//androidx.recyclerview.widget.RecyclerView//android.view.ViewGroup[.//android.widget.TextView[@text='$GlobalVariable.Bietdanh_Member'] and .//android.widget.TextView[@text='$GlobalVariable.user_shared']]")

Mobile.tap(peopleObject_noupdate, 0)

String updatedBietdanhMember ="${GlobalVariable.Bietdanh_Member}_Update"

Mobile.setText(findTestObject('ObjectChiaSeNha/popup_cap _nhat _thanh _vien_txtbox_biet_danh'), updatedBietdanhMember, 0)

Mobile.pressBack()

'Chọn quyền quản trị viên'
Mobile.tap(findTestObject('ObjectChiaSeNha/popup_chia_se_nha_rdbtn_quan_tri_vien'), 0)

Mobile.tap(findTestObject('ObjectChiaSeNha/popup_cap _nhat _thanh _vien_btn_cap_nhat'), 0)

AndroidDriver<?> driver = ((MobileDriverFactory.getDriver()) as AndroidDriver<?>)

String expectedPartialMessage = 'Cập nhật chia sẻ nhà thành công' // Nội dung toast hiển thị

//Khối try-catch giúp quản lý lỗi trong quá trình kiểm tra. Nếu không tìm thấy Toast,
// mã sẽ ném ra ngoại lệ NoSuchElementException và in ra thông báo "Toast message không xuất hiện hoặc không tìm thấy XPath".
try {
    WebDriverWait wait = new WebDriverWait(driver, 15)

    AndroidElement toastElement = driver.findElementByXPath('//android.widget.Toast[1]')

    // AndroidElement toastElement = (AndroidElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Toast[1]")))
    assert toastElement.getText().equals(expectedPartialMessage)

    println('Toast message chứa nội dung mong đợi.')
}
catch (NoSuchElementException e) {
    println('Toast message không xuất hiện hoặc không tìm thấy XPath.')
} 

// Tạo đối tượng động với XPath thành viên trong danh sách
TestObject peopleObject_update = new TestObject()

peopleObject_update.addProperty('xpath', ConditionType.EQUALS, "//androidx.recyclerview.widget.RecyclerView//android.view.ViewGroup[.//android.widget.TextView[@text='$updatedBietdanhMember'] and .//android.widget.TextView[@text='$GlobalVariable.user_shared'] and .//android.widget.TextView[@text='Quản trị viên']]")

'Kiểm tra thành viên sau khi update tên biệt danh và quyền'
Mobile.verifyElementExist(peopleObject_update, 10 // timeout 10s
    )

Mobile.tap(findTestObject('ObjectChiaSeNha/icon_back'), 0)

Mobile.tap(findTestObject('ObjectChiaSeNha/icon_back'), 0)

Mobile.tap(findTestObject('ObjectChiaSeNha/icon_back'), 0)

'Đăng xuất khỏi tài khoản chia sẻ'
WebUI.callTestCase(findTestCase('DangXuat/Dang xuat thanh cong'), [:], FailureHandling.STOP_ON_FAILURE)

'Đăng nhập vào  tài khoản được chia sẻ'
WebUI.callTestCase(findTestCase('DangNhap/Dang nhap thanh cong Tk duoc chia se'), [:], FailureHandling.STOP_ON_FAILURE)

tapDynamicObject('//android.widget.TextView[1]', 0)

Mobile.tap(findTestObject('ObjectChiaSeNha/popup_chon _nha_Quan_Ly_Nha'), 0)

'Nhấn vào nhà chia sẻ trên màn Quản lý nhà chứa danh sách nhà của tài khoản'
Mobile.tap(houseObject, 0)

Mobile.verifyElementExist(peopleObject_update, 10 // timeout 10s
    )

Mobile.closeApplication()

def tapDynamicObject(String xpath, int timeout) {
    TestObject dynamicObject = new TestObject('dynamicObject')

    dynamicObject.addProperty('xpath', ConditionType.EQUALS, xpath)

    Mobile.tap(dynamicObject, 0)
}


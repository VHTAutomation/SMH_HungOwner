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

Mobile.startExistingApplication(GlobalVariable.appID, FailureHandling.STOP_ON_FAILURE)

tapDynamicObject('//android.widget.TextView[1]', 0)

Mobile.tap(findTestObject('ObjectChiaSeNha/popup_chon _nha_Quan_Ly_Nha'), 0)

// Sử dụng XPath để chọn phần tử nhà bất kỳ trên danh sách tại màn quản lý nhà
TestObject houseObject = new TestObject()

houseObject.addProperty('xpath', ConditionType.EQUALS, "//androidx.recyclerview.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[contains(@text,'$GlobalVariable.houseNameShared_Member')]")

//String houseNameShared = Mobile.getText(houseObject, 10)
//GlobalVariable.houseNameShared_Admin = houseNameShared
// Kiểm tra biến houseNameShared có giá trị chưa
' Nhấn chọn nhà" Nhà Chia Sẻ"'
Mobile.tap(houseObject, 0)

Mobile.tap(findTestObject('ObjectChiaSeNha/Menu_Chia_se_nha'), 0)

Mobile.verifyElementVisible(findTestObject('ObjectChiaSeNha/popup_chia_se _nha_title'), 0)

Mobile.verifyElementVisible(findTestObject('ObjectChiaSeNha/popup_chia_se_nha_txtbox_tai_khoan_duoc_chia_se'), 0)

Mobile.verifyElementVisible(findTestObject('ObjectChiaSeNha/popup_chia_se_nha_txtbox_biet_danh'), 0)

Mobile.verifyElementVisible(findTestObject('ObjectChiaSeNha/popup_chia_se_nha_txt_quyen_truy_cap'), 0)

Mobile.verifyElementVisible(findTestObject('ObjectChiaSeNha/popup_chia_se_nha_rdbtn_quan_tri_vien'), 0)

Mobile.verifyElementVisible(findTestObject('ObjectChiaSeNha/popup_chia_se_nha_rdbtn_thanh_vien'), 0)

Mobile.verifyElementVisible(findTestObject('ObjectChiaSeNha/popup_chia_se_nha_btn _huy'), 0)

Mobile.verifyElementVisible(findTestObject('ObjectChiaSeNha/popup_chia_se_nha_btn _xac_nhan'), 0)

Mobile.verifyElementNotChecked(findTestObject('ObjectChiaSeNha/popup_chia_se_nha_rdbtn_quan_tri_vien'), 0)

Mobile.verifyElementChecked(findTestObject('ObjectChiaSeNha/popup_chia_se_nha_rdbtn_thanh_vien'), 0)

Mobile.setText(findTestObject('ObjectChiaSeNha/popup_chia_se_nha_txtbox_tai_khoan_duoc_chia_se'), GlobalVariable.user_shared, 
    0)

Mobile.setText(findTestObject('ObjectChiaSeNha/popup_chia_se_nha_txtbox_biet_danh'), GlobalVariable.Bietdanh_Member, 0)

'Nhấn chọn quyền thành viên'
Mobile.tap(findTestObject('ObjectChiaSeNha/popup_chia_se_nha_rdbtn_thanh_vien'), 0)

//Mobile.hideKeyboard() : dùng lệnh này ẩn bàn phím và ẩn luôn cả popup chia sẻ nhà
//Sử dụng tổ hợp phím hoặc phím ảo để đóng bàn phím
//Thay vì sử dụng lệnh ẩn trực tiếp, bạn có thể mô phỏng việc nhấn nút Back để đóng bàn phím, điều này thường không ảnh hưởng đến popup.
Mobile.pressBack()

Mobile.tap(findTestObject('ObjectChiaSeNha/popup_chia_se_nha_btn _xac_nhan'), 0)

AndroidDriver<?> driver = ((MobileDriverFactory.getDriver()) as AndroidDriver<?>)

String expectedPartialMessage = 'Chia sẻ nhà thành công' // Nội dung toast hiển thị

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
TestObject peopleObject = new TestObject()

peopleObject.addProperty('xpath', ConditionType.EQUALS, "//androidx.recyclerview.widget.RecyclerView//android.view.ViewGroup[.//android.widget.TextView[@text='$GlobalVariable.Bietdanh_Member'] and .//android.widget.TextView[@text='$GlobalVariable.user_shared'] and .//android.widget.TextView[@text='Chưa xác nhận']]")

'Kiểm tra sự tồn tại của thành viên sau khi nhân xác nhận chia sẻ nhà'
Mobile.verifyElementExist(peopleObject, 10 // timeout 10s
    )


Mobile.closeApplication()

def tapDynamicObject(String xpath, int timeout) {
    TestObject dynamicObject = new TestObject('dynamicObject')

    dynamicObject.addProperty('xpath', ConditionType.EQUALS, xpath)

    Mobile.tap(dynamicObject, 0)
}


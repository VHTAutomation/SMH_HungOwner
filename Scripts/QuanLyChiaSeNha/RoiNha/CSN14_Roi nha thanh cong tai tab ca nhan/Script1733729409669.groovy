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
Mobile.verifyElementVisible(findTestObject('ObjectChiaSeNha/popup_thong_bao_roi-nha_txtfield_ban_co_chac_muon_roi_nha'), 
    0)

Mobile.verifyElementVisible(findTestObject('ObjectChiaSeNha/popup_thong_bao_roi_nha_btn_huy_bo'), 0)

Mobile.verifyElementVisible(findTestObject('ObjectChiaSeNha/popup_thong_bao_roi_nha_btn_OK'), 0)

'Nhấn button OK'
Mobile.tap(findTestObject('ObjectChiaSeNha/popup_thong_bao_roi_nha_btn_OK'), 0)

AndroidDriver<?> driver = ((MobileDriverFactory.getDriver()) as AndroidDriver<?>)

String expectedPartialMessage = 'Rời nhà thành công' // Nội dung toast hiển thị

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

'Check tồn tại nhà trên màn quản lý nhà sau khi rời nhà --> Không tồn tại'
Mobile.verifyElementNotExist(houseObject, 10)

Mobile.tap(findTestObject('ObjectChiaSeNha/icon_back_man_danh_sach_nha'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('ObjectChiaSeNha/icon_back_man_quan_ly_chung'), 0)

Mobile.tap(findTestObject('ObjectChiaSeNha/Tab_Trang_Chu'), 0)

tapDynamicObject('//android.widget.TextView[1]', 0)

TestObject houseObject_home = new TestObject()

houseObject_home.addProperty('xpath', ConditionType.EQUALS, "//androidx.recyclerview.widget.RecyclerView//androidx.appcompat.widget.LinearLayoutCompat[ .//android.widget.TextView[@text='$GlobalVariable.houseNameShared_Admin'] and .//android.widget.ImageView]")

// Kiểm tra sự tồn tại
'Check tồn tại nhà trên popup chọn nhà sau khi rời nhà  trên màn trang chủ--> Không tồn tại'
Mobile.verifyElementNotExist(houseObject_home, 10)

Mobile.tap(findTestObject('ObjectChiaSeNha/NhanRaNgoaiBottomSheet'), 0)

Mobile.tap(findTestObject('ObjectChiaSeNha/Tab_Thiet_Bi'), 0)

tapDynamicObject('//android.widget.TextView[1]', 0)

'CCheck tồn tại nhà trên popup chọn nhà sau khi rời nhà  trên màn thiết bị--> Không tồn tại'
Mobile.verifyElementNotExist(houseObject_home, 10)

'Tap ra vùng ngoài popup chọn nhà để đóng popup'
Mobile.tap(findTestObject('ObjectChiaSeNha/NhanRaNgoaiBottomSheet'), 0)

Mobile.tap(findTestObject('ObjectChiaSeNha/Tab_Ca_Nhan'), 0)

WebUI.callTestCase(findTestCase('DangXuat/Dang xuat thanh cong'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('DangNhap/Dang nhap thanh cong Tk chia se'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('ObjectChiaSeNha/Tab_Ca_Nhan'), 0)

Mobile.tap(findTestObject('ObjectChiaSeNha/Menu_Quan_Ly_Chung'), 0)

Mobile.tap(findTestObject('ObjectChiaSeNha/Menu_Quan_Ly_Nha'), 0)

Mobile.tap(houseObject, 0)

TestObject peopleObject = new TestObject('peopleObject')

peopleObject.addProperty('xpath', ConditionType.EQUALS, "//androidx.recyclerview.widget.RecyclerView//android.view.ViewGroup[.//android.widget.TextView[@text='$GlobalVariable.Bietdanh_Admin'] and .//android.widget.TextView[@text='$GlobalVariable.user_shared']]")

// Kiểm tra sự tồn tại
Mobile.verifyElementNotExist(peopleObject, 10 // timeout 10s
    )

Mobile.closeApplication()

def tapDynamicObject(String xpath, int timeout) {
    TestObject dynamicObject = new TestObject('dynamicObject')

    dynamicObject.addProperty('xpath', ConditionType.EQUALS, xpath)

    Mobile.tap(dynamicObject, 0)
}


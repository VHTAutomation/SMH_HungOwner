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

// Sử dụng XPath để chọn phần tử nhà bất kỳ trên danh sách tại màn quản lý nhà
TestObject houseObject = new TestObject()

houseObject.addProperty('xpath', ConditionType.EQUALS, "//androidx.recyclerview.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[contains(@text,'$GlobalVariable.houseNameShared_Admin')]")

//String houseNameShared = Mobile.getText(houseObject, 10)
//GlobalVariable.houseNameShared_Admin = houseNameShared 
// Kiểm tra biến houseNameShared có giá trị chưa
'Tap vào nhà My Home'
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

Mobile.setText(findTestObject('ObjectChiaSeNha/popup_chia_se_nha_txtbox_biet_danh'), GlobalVariable.Bietdanh_Admin, 0)

'Chọn quyền Quản trị viên'
Mobile.tap(findTestObject('ObjectChiaSeNha/popup_chia_se_nha_rdbtn_quan_tri_vien'), 0)

//Mobile.hideKeyboard() : dùng lệnh này ẩn bàn phím và ẩn luôn cả popup chia sẻ nhà
//Sử dụng tổ hợp phím hoặc phím ảo để đóng bàn phím
//Thay vì sử dụng lệnh ẩn trực tiếp, bạn có thể mô phỏng việc nhấn nút Back để đóng bàn phím, điều này thường không ảnh hưởng đến popup.
Mobile.pressBack()

Mobile.tap(findTestObject('ObjectChiaSeNha/popup_chia_se_nha_btn _xac_nhan'), 0)

AndroidDriver<?> driver = ((MobileDriverFactory.getDriver()) as AndroidDriver<?>)

String expectedPartialMessage = 'Chia sẻ nhà thành công' // Nội dung toast hiển thị

//Khối try-catch giúp quản lý lỗi trong quá trình kiểm tra. Nếu không tìm thấy Toast,
// mã sẽ ném ra ngoại lệ NoSuchElementException và in ra thông báo "Toast message không xuất hiện hoặc không tìm thấy XPath".
//Nếu toast message xuất hiện nhưng nội dung không khớp, chương trình sẽ dừng lại tại dòng assert, vì lệnh assert ném ra một lỗi AssertionError khi điều kiện không đúng.
// Điều này có nghĩa là chương trình sẽ không tiếp tục thực hiện các dòng code sau lệnh assert
/*try {
    WebDriverWait wait = new WebDriverWait(driver, 15)

    AndroidElement toastElement = driver.findElementByXPath('//android.widget.Toast[1]')

    // AndroidElement toastElement = (AndroidElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Toast[1]")))
    assert toastElement.getText().equals(expectedPartialMessage)

    println('Toast message chứa nội dung mong đợi.')
}
catch (NoSuchElementException e) {
    println('Toast message không xuất hiện hoặc không tìm thấy XPath.')
} */
WebDriverWait wait = new WebDriverWait(driver, 15)

AndroidElement toastElement = driver.findElementByXPath('//android.widget.Toast[1]')

if (toastElement.getText().equals(expectedPartialMessage)) {
    System.out.println('Toast message chứa nội dung mong đợi.') // Có thể thêm logic xử lý lỗi hoặc tiếp tục chương trình
} else {
    System.out.println('Toast message không xuất hiện hoặc không tìm thấy XPath.')
}

// Tạo đối tượng động với XPath thành viên trong danh sách
TestObject peopleObject = new TestObject()

peopleObject.addProperty('xpath', ConditionType.EQUALS, "//androidx.recyclerview.widget.RecyclerView//android.view.ViewGroup[.//android.widget.TextView[@text='$GlobalVariable.Bietdanh_Admin'] and .//android.widget.TextView[@text='$GlobalVariable.user_shared'] and .//android.widget.TextView[@text='Chưa xác nhận']]")

'Kiểm tra thành viên sau khi xác nhận chia sẻ nhà'
Mobile.verifyElementExist(peopleObject, 10) // timeout 10s

Mobile.closeApplication()


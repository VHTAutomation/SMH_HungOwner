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
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.exception.StepFailedException as StepFailedException
import com.kms.katalon.core.testobject.ConditionType as ConditionType

Mobile.startExistingApplication(GlobalVariable.Environment_pro, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('ObjectChiaSeNha/Tab_Ca_Nhan'), 0)

Mobile.tap(findTestObject('ObjectChiaSeNha/Menu_Quan_Ly_Chung'), 0)

Mobile.tap(findTestObject('ObjectChiaSeNha/Menu_Quan_Ly_Nha'), 0)

// Sử dụng XPath để chọn phần tử trong RecyclerView tại vị trí thứ 1
TestObject houseObject = new TestObject()
houseObject.addProperty(
	'xpath',
	ConditionType.EQUALS,
	"//androidx.recyclerview.widget.RecyclerView[1]//android.view.ViewGroup[1]//android.widget.TextView[1]"
)
Mobile.tap(houseObject,0)
Mobile.tap(findTestObject('ObjectChiaSeNha/Menu_Chia_se_nha'), 0)

Mobile.setText(findTestObject('ObjectChiaSeNha/popup_chia_se_nha_txtbox_tai_khoan_duoc_chia_se'), '0986784498', 0)

Mobile.setText(findTestObject('ObjectChiaSeNha/popup_chia_se_nha_txtbox_biet_danh'), 'Anh Hiến', 0)

Mobile.tap(findTestObject('ObjectChiaSeNha/popup_chia_se_nha_rdbtn_quan_tri_vien'), 0)

//Mobile.hideKeyboard() : dùng lệnh này ẩn bàn phím và ẩn luôn cả popup chia sẻ nhà
//Sử dụng tổ hợp phím hoặc phím ảo để đóng bàn phím
//Thay vì sử dụng lệnh ẩn trực tiếp, bạn có thể mô phỏng việc nhấn nút Back để đóng bàn phím, điều này thường không ảnh hưởng đến popup.
Mobile.pressBack()

Mobile.tap(findTestObject('ObjectChiaSeNha/popup_chia_se_nha_btn _huy'), 0)

TestObject dynamicObject = new TestObject()

dynamicObject.addProperty('xpath', ConditionType.EQUALS, '//androidx.recyclerview.widget.RecyclerView//android.view.ViewGroup[.//android.widget.TextView[@text=\'Anh Hiến\'] and .//android.widget.TextView[@text=\'0986784498\'] and .//android.widget.TextView[@text=\'Chưa xác nhận\']]')

// Kiểm tra sự tồn tại
Mobile.verifyElementNotExist(dynamicObject, 10 // timeout 10s
    )

Mobile.closeApplication()


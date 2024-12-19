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
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType

Mobile.startExistingApplication(GlobalVariable.appID, FailureHandling.STOP_ON_FAILURE)

// Tìm ViewGroup cuối cùng trong layout
TestObject lastViewGroup = new TestObject('Object Repository/LastViewGroup')
lastViewGroup.addProperty('xpath', ConditionType.EQUALS, "(//android.widget.RelativeLayout/android.view.ViewGroup)[last()]")

// Tìm TextView đầu tiên trong ViewGroup cuối cùng
TestObject textInLastViewGroup = new TestObject('Object Repository/TextInLastViewGroup')
textInLastViewGroup.addProperty('xpath', ConditionType.EQUALS, "(//android.widget.RelativeLayout/android.view.ViewGroup)[last()]//android.widget.TextView[6]")

// Lấy giá trị text
String ten_goi = Mobile.getText(textInLastViewGroup, 10)

// In ra text
println("Text trong phần tử con của ViewGroup cuối cùng là: " + ten_goi)



Mobile.verifyElementText(findTestObject('Settings Cam/Luu tru Cloud/Dich vu Cloud/dich_vu_cloud_trang_thai_chua_kich_hoat'),
	'Chưa kích hoạt')

Mobile.verifyElementExist(findTestObject('Settings Cam/Luu tru Cloud/Dich vu Cloud/dich_vu_cloud_btn_mua_them_goi'), 0)

WebUI.callTestCase(findTestCase('Mua gói Cloud/TC Re-use/Man Lich su mua hang - Chi tiet mua hang'), [:], FailureHandling.STOP_ON_FAILURE)


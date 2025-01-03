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
import io.appium.java_client.android.nativekey.AndroidKey as AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent as KeyEvent
import io.appium.java_client.AppiumDriver as AppiumDriver

Mobile.startExistingApplication(GlobalVariable.appID, FailureHandling.STOP_ON_FAILURE)

AppiumDriver driver = MobileDriverFactory.getDriver()

    ((driver) as AndroidDriver).openNotifications()

// Tạo TestObject để tìm icon mở nhóm thông báo
//TestObject groupIcon = new TestObject('groupIcon')
//groupIcon.addProperty('xpath', ConditionType.EQUALS, '//android.widget.FrameLayout[1]/android.widget.Button[1]')
// Đợi icon mở nhóm thông báo xuất hiện
//Mobile.waitForElementPresent(groupIcon, 10)
// Tap vào icon để mở nhóm thông báo
//Mobile.tap(groupIcon, 0)
' mở nhóm thông báo'
TestObject uudai = new TestObject()

uudai.addProperty('xpath', ConditionType.CONTAINS, '//android.widget.TextView[contains(@text,\'Chức năng AI\')]')

// tap vào noti
'tap vào noti ưu đãi dịch vụ'
Mobile.tap(uudai, 0)

Mobile.tap(findTestObject('ObjectThemGuongMat/btn_Trai_nghiem_mien_phi'), 0)

String cameraName = '3be642171135c7e8'

// XPath động để tìm Switch Button
TestObject switchButton = new TestObject('dynamicSwitchButton')

switchButton.addProperty('xpath', ConditionType.EQUALS, ('//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[.//android.widget.TextView[@text=\'' + 
    cameraName) + '\']]//android.widget.Switch')

// Chạm vào Switch Button
Mobile.tap(switchButton, 10)

Mobile.tap(findTestObject('ObjectThemGuongMat/btn_kich_hoat'), 0)

Mobile.tap(findTestObject('ObjectThemGuongMat/btn_Quan_ly_GM_tren_man_kich_hoat_dich_vu_AI'), 0)

Mobile.tap(findTestObject('ObjectManHinhChinh/ObjectManCaNhan/ObjectManQuanLyChung/ObjectManQuanLyGuongMat/opt_guong_mat'), 
    0)

Mobile.clearText(findTestObject('ObjectManHinhChinh/ObjectManCaNhan/ObjectManQuanLyChung/ObjectManQuanLyGuongMat/txt_ten_guong_mat'), 
    0)

Mobile.setText(findTestObject('ObjectManHinhChinh/ObjectManCaNhan/ObjectManQuanLyChung/ObjectManQuanLyGuongMat/txt_ten_guong_mat'), 
    'Sua guong mat 5', 0)

Mobile.tap(findTestObject('ObjectManHinhChinh/ObjectManCaNhan/ObjectManQuanLyChung/ObjectManQuanLyGuongMat/btn_luu_thay_doi_thong_tin_guong_mat'), 
    0)

Mobile.verifyElementText(findTestObject('ObjectManHinhChinh/ObjectManCaNhan/ObjectManQuanLyChung/ObjectManQuanLyGuongMat/txt_ten_guong_mat'), 
    'Sua guong mat 5')

Mobile.closeApplication()


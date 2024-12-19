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

Mobile.startExistingApplication('com.viettel.vhome2')

Mobile.tap(findTestObject('Tab Thiết bị/Tab_Thietbi'), 0)

Mobile.tap(findTestObject('Tab Thiết bị/choncam - CNME00000586'), 0)

Mobile.tap(findTestObject('Tab Thiết bị/tab_tinh_nang'), 0)

Mobile.tap(findTestObject('Tab Thiết bị/btn_chiaseTB'), 0)

Mobile.verifyElementVisible(findTestObject('Share device/title_chia_se_thiet_bi'), 0)

Mobile.tap(findTestObject('Share device/chiaseTB_btn_huychiase'), 0)

Mobile.tap(findTestObject('Share device/chitietchiase_btn_huy'), 0)

Mobile.verifyElementText(findTestObject('Share device/popup_xac_nhan_huy_sdt0969073634'), 'Bạn có chắc muốn hủy chia sẻ đến tài khoản 0394361750')

Mobile.tap(findTestObject('Share device/btn_Xac_nhan_Huy'), 0)

Mobile.verifyElementText(findTestObject('Share device/popup_thu_hoi_chia_se_tbi_X_den_tk_A'), 'Đã thu hồi lời mời chia sẻ thiết bị CNME00000586 đến tài khoản 0394361750')

Mobile.verifyElementVisible(findTestObject('Share device/title_chia_se_thiet_bi'), 0)

Mobile.verifyElementNotExist(findTestObject('Share device/title_thiet_bi_da_chia_se_den'), 0)

Mobile.closeApplication()


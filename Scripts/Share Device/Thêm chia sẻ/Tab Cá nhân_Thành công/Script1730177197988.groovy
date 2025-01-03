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

Mobile.startExistingApplication(GlobalVariable.appID, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Share device/tab_ca_nhan'), 0)

Mobile.tap(findTestObject('Object Repository/Share device/title_quanlychung'), 0)

Mobile.tap(findTestObject('Object Repository/Share device/tab_quan_ly_chia_se (1)'), 0)

Mobile.tap(findTestObject('Share device/btn_Them_chia_se'), 0)

Mobile.verifyElementVisible(findTestObject('Share device/title_chon_thiet_bi'), 0)

Mobile.tap(findTestObject('Share device/android.widget.TextView - CNME00000586'), 0)

Mobile.tap(findTestObject('Share device/chon_thietbi_btn_Tiep_tuc'), 0)

Mobile.verifyElementVisible(findTestObject('Share device/title_chia_se_thiet_bi'), 0)

Mobile.setText(findTestObject('Share device/textbox_st'), GlobalVariable.user_share, 0)

Mobile.tap(findTestObject('Share device/nhap_sdt_btn_Tiep_tuc'), 0)

Mobile.tap(findTestObject('Share device/chon_quyen_xem_lai'), 0)

Mobile.tap(findTestObject('Share device/btn_Chia_se'), 0)

Mobile.verifyElementVisible(findTestObject('Share device/popup_guichiasethanhcong'), 0)

Mobile.verifyElementVisible(findTestObject('Share device/title_QunaLychiase'), 0)

Mobile.tap(findTestObject('Share device/title_thiet_bi_da_chia_se'), 0)

Mobile.tap(findTestObject('Share device/thiet_bi_da_chia_se- CNME00000586'), 0)

Mobile.verifyElementText(findTestObject('Share device/sdtdachiase- 0394361750'), GlobalVariable.user_share)

Mobile.tap(findTestObject('Share device/btnBack'), 0)

Mobile.tap(findTestObject('Share device/btnBack'), 0)

Mobile.tap(findTestObject('Share device/btnBack'), 0)

Mobile.tap(findTestObject('Share device/btnBack'), 0)

Mobile.verifyElementExist(findTestObject('Share device/tab_ca_nhan'), 0)

WebUI.callTestCase(findTestCase('Đăng xuất/Đăng xuất thành công'), [:], FailureHandling.STOP_ON_FAILURE)


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

WebUI.callTestCase(findTestCase('Đăng nhập/Đăng nhập thành công'), [('username') : '0969073634', ('password') : 'Matkhau@1'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.startExistingApplication(GlobalVariable.appID, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Share device/title_ban_dang_co_thiet_bi_cho_chap_nhan'), 0)

Mobile.tap(findTestObject('Object Repository/Share device/tb_doi_chap_nhan_choncam - 46674403b7b6e043'), 0)

Mobile.tap(findTestObject('Share device/btn Tu_choi_chia_se'), 0)

Mobile.tap(findTestObject('Share device/Huy chia se/btn_xac_nhan_popup_tu_choi_chia_se'), 0)

Mobile.verifyElementExist(findTestObject('Share device/title_ban da tu choi tb X duoc chia se tu tk A'), 0)

Mobile.verifyElementExist(findTestObject('Share device/title Thiet bi doi chap nhan'), 0)

Mobile.closeApplication()


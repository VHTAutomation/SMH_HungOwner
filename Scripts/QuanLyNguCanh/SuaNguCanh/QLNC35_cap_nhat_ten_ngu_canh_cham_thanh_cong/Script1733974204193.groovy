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

Mobile.startExistingApplication('com.viettel.vhome2', FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('ObjectManHinhChinh/ObjectManTrangChu/ObjectTheYeuThich/tabTrangChu'), 0)

Mobile.tap(findTestObject('ObjectManHinhChinh/title_ngu_canh'), 0)

Mobile.tap(findTestObject('ObjectNguCanh/title_tab_cham_de_thuc_hien'), 0)

Mobile.tap(findTestObject('ObjectNguCanh/opt_lua_chon_ngu_canh_cham'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.clearText(findTestObject('ObjectNguCanh/ObjectManQuanLyNguCanh/txtfield_ten_ngu_canh'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.setText(findTestObject('ObjectNguCanh/ObjectManQuanLyNguCanh/txtfield_ten_ngu_canh'), 'ngu canh edited', 0)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('ObjectNguCanh/ObjectManQuanLyNguCanh/btn_luu_thay_doi_ngu_canh'), 0)

Mobile.scrollToText('ngu canh edited')

Mobile.closeApplication()


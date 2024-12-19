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

Mobile.startExistingApplication('com.viettel.VTHome.dev')

Mobile.verifyElementText(findTestObject('Settings Cam/Luu tru Cloud/title_Lien_ket_thanh_toan'), 'Liên kết thanh toán')

Mobile.tap(findTestObject('Lien ket thanh toan/Lien_ket_thanh_toan_btn_tiep_tuc'), 5)

Mobile.setText(findTestObject('Settings Cam/Luu tru Cloud/lien_ket_thanh_toan_textbox_mat_khau'), '123123', 0)

Mobile.tap(findTestObject('Settings Cam/Luu tru Cloud/lien_ket_thanh_toan_btn_xac_nhan'), 0)

Mobile.setText(findTestObject('Settings Cam/Luu tru Cloud/lien_ket_thanh_toan_nhap_otp'), '1111', 0)

Mobile.tap(findTestObject('Settings Cam/Luu tru Cloud/lien_ket_thanh_toan_textbox_sdt'), 0)

Mobile.tap(findTestObject('Settings Cam/Luu tru Cloud/lien_ket_thanh_toan_btn_xac_nhan_2'), 0)


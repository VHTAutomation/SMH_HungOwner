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

Mobile.tap(findTestObject('ObjectManHinhChinh/title_thiet_bi'), 0)

Mobile.tap(findTestObject('ObjectManHinhChinh/ObjectManThietBi/opt_thiet_bi'), 0)

Mobile.tap(findTestObject('ObjectManHinhChinh/ObjectManThietBi/ObjectManChiTietThietBi/title_tinh_nang'), 0)

Mobile.tap(findTestObject('ObjectManHinhChinh/ObjectManThietBi/ObjectManChiTietThietBi/btn_cai_dat_chi_tiet_camera'), 0)

Mobile.scrollToText('Dịch vụ camera', FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('ObjectManHinhChinh/ObjectManThietBi/ObjectManChiTietThietBi/title_dich_vu_camera'), 0)

Mobile.tap(findTestObject('ObjectManHinhChinh/ObjectManThietBi/ObjectManChiTietThietBi/opt_nhan_dien_guong_mat'), 0)

Mobile.tap(findTestObject('ObjectManHinhChinh/ObjectManThietBi/ObjectManChiTietThietBi/btn_quan_ly_guong_mat'), 0)

Mobile.tap(findTestObject('ObjectManHinhChinh/ObjectManCaNhan/ObjectManQuanLyChung/ObjectManQuanLyGuongMat/opt_guong_mat'), 
    0)

Mobile.clearText(findTestObject('ObjectManHinhChinh/ObjectManCaNhan/ObjectManQuanLyChung/ObjectManQuanLyGuongMat/txtfield_ten_guong_mat'), 
    0)

Mobile.setText(findTestObject('ObjectManHinhChinh/ObjectManCaNhan/ObjectManQuanLyChung/ObjectManQuanLyGuongMat/txtfield_ten_guong_mat'), 
    'Sua Guong Mat 4', 0)

Mobile.tap(findTestObject('ObjectManHinhChinh/ObjectManCaNhan/ObjectManQuanLyChung/ObjectManQuanLyGuongMat/btn_quay_lai_man_quan_ly_guong_mat'), 
    0)

Mobile.tap(findTestObject('ObjectManHinhChinh/ObjectManCaNhan/ObjectManQuanLyChung/ObjectManQuanLyGuongMat/btn_xac_nhan_thong_bao_sua_doi_khong_duoc_luu'), 
    0)

Mobile.closeApplication()


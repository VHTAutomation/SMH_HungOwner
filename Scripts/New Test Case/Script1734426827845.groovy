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

Mobile.scrollToText('Cảnh báo đến vị trí, rời vị trí ngay', FailureHandling.STOP_ON_FAILURE)
// Lấy kích thước màn hình thiết bị
//int screenWidth = Mobile.getDeviceWidth()

//int screenHeight = Mobile.getDeviceHeight()

// Tính toán tọa độ cho thao tác vuốt
//int startX = screenWidth / 2 // Ở giữa chiều ngang màn hình

//int startY = ((screenHeight * 0.8 // Bắt đầu ở 80% chiều cao từ trên xuống
   // ) as int)

//int endY = ((screenHeight * 0.2 // Kết thúc ở 20% chiều cao từ trên xuống
 //   ) as int)

// Thực hiện thao tác vuốt
//Mobile.swipe(startX, startY, startX, endY)


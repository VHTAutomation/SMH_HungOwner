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
import io.appium.java_client.MobileElement as MobileElement
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.android.AndroidDriver as AndroidDriver
import io.appium.java_client.android.AndroidElement as AndroidElement
import io.appium.java_client.android.nativekey.AndroidKey as AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent as KeyEvent
import io.appium.java_client.AppiumDriver

Mobile.startExistingApplication(GlobalVariable.Environment_stg, FailureHandling.STOP_ON_FAILURE)

/*MobileDriverFactory.getDriver().pressKey(new KeyEvent(AndroidKey.NOTIFICATION)) // C1: Mở thanh thông báo trên thiết bị Android'*/
// Lấy đối tượng driver hiện tại
AppiumDriver<?> driver = MobileDriverFactory.getDriver()

// Thực hiện mở thanh thông báo trên thiết bị Android
((AndroidDriver<?>) driver).openNotifications()

// Tạo TestObject để tìm icon mở nhóm thông báo
TestObject groupIcon = new TestObject('groupIcon')
groupIcon.addProperty('xpath', ConditionType.EQUALS, '//android.widget.FrameLayout[1]/android.widget.Button[1]')

// Đợi icon mở nhóm thông báo xuất hiện
Mobile.waitForElementPresent(groupIcon, 10)

// Tap vào icon để mở nhóm thông báo
' mở nhóm thông báo'
Mobile.tap(groupIcon, 0)
TestObject uudai = new TestObject()
uudai.addProperty('xpath', ConditionType.CONTAINS, "//android.widget.TextView[contains(@text,'Chức năng AI')]")

// tap vào noti
'tap vào noti ưu đãi dịch vụ'
Mobile.tap(uudai, 0)
Mobile.tap(findTestObject('ObjectThemGuongMat/btn_Trai_nghiem_mien_phi'), 0)
String cameraName = '3be642171135c7e8'

// XPath động để tìm Switch Button
TestObject switchButton = new TestObject('dynamicSwitchButton')

switchButton.addProperty('xpath', ConditionType.EQUALS, ('//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[.//android.widget.TextView[@text=\'' +cameraName) + '\']]//android.widget.Switch')

// Chạm vào Switch Button
Mobile.tap(switchButton, 10)

Mobile.tap(findTestObject('ObjectThemGuongMat/btn_kich_hoat'), 0)

Mobile.tap(findTestObject('ObjectThemGuongMat/btn_Quan_ly_GM_tren_man_kich_hoat_dich_vu_AI'), 0)

Mobile.tap(findTestObject('ObjectThemGuongMat/icon_them_guong_mat_tren_man_QLGM'), 0)

'Set tên gương mặt'
Mobile.setText(findTestObject('ObjectThemGuongMat/txtbox_nhap_ten_guong_mat'), 'Thu Giang4', 0)

'Số ảnh muốn chọn'
int numberOfImages = 3

for (int i = 1; i <= numberOfImages; i++) {
	TestObject plusButton = new TestObject('plus_button')

	plusButton.addProperty('xpath', ConditionType.EQUALS, '//androidx.recyclerview.widget.RecyclerView[1]/*[last()]/android.widget.ImageView[1]')

	'Nhấn vào dấu + để thực hiện thêm ảnh'
	Mobile.tap(plusButton, 30)

	'Chọn ảnh từ bộ sưu tập'
	Mobile.tap(findTestObject('ObjectThemGuongMat/menu_chon_anh_tu_bo_suu_tap'), 0)

	// Tạo TestObject động với XPath rút gọn
	TestObject image = new TestObject('DynamicImage' + i)

	image.addProperty('xpath', ConditionType.EQUALS, '//android.widget.GridView/android.widget.FrameLayout[' + i + ']//android.widget.ImageView')

	'Nhấn vào ảnh chọn'
	Mobile.tap(image, 30)

	'Nhấn button thêm ảnh trên màn thay đổi kích thước ảnh'
	Mobile.tap(findTestObject('ObjectThemGuongMat/btn_them_anh_tren_man_thay_doi_kich_thuoc_anh'), 30)
}

TestObject nhomguongmat = new TestObject('nhomguongmat')

nhomguongmat.addProperty('xpath', ConditionType.EQUALS, '//android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[@text=\'Người nhà\']')

// Kiểm tra xem nhóm "Người nhà" đã được chọn hay chưa
TestObject bottomsheetnhomguongmat = new TestObject('bottomsheet')

bottomsheetnhomguongmat.addProperty('xpath', ConditionType.EQUALS, '//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.TextView[@text=\'Người nhà\']')

// Kiểm tra xem nhóm "Người nhà" đã được chọn hay chưa
boolean isSelected = Mobile.verifyElementExist(nhomguongmat, 15, FailureHandling.OPTIONAL)

if (!(isSelected)) {
	// Nếu chưa chọn, thực hiện tap vào nhóm gương mặt "Người nhà"
	println('Nhóm \'Người nhà\' chưa được chọn, tiến hành tap.')

	Mobile.tap(findTestObject('ObjectThemGuongMat/icon_xem_thong_tin_nhom_GM'), 0)

	Mobile.tap(bottomsheetnhomguongmat, 30 // Nếu đã chọn, ghi log và bỏ qua thao tác
		)
} else {
	println('Nhóm \'Người nhà\' đã được chọn, bỏ qua thao tác tap.')
}

'Nhấn button thêm gương mặt trên màn thêm gương mặt'
Mobile.tap(findTestObject('ObjectThemGuongMat/btn_Them_tren_man_them_guong_mat'), 0)

TestObject groupNguoiNha = findTestObject('ObjectThemGuongMat/txt_Nhom_guong_mat_Nguoi_Nha')

TestObject face = new TestObject('face')

face.addProperty('xpath', ConditionType.EQUALS, '//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup//android.widget.TextView[@text=\'Thu Giang4\']')

// Kiểm tra sự tồn tại của nhóm "Người nhà"
if (Mobile.waitForElementPresent(groupNguoiNha, 15, FailureHandling.CONTINUE_ON_FAILURE)) {
	println('Nhóm \'Người nhà\' tồn tại.')

	// Kiểm tra sự tồn tại của "Thu Giang" trong nhóm "Người nhà"
	if (Mobile.waitForElementPresent(face, 10, FailureHandling.CONTINUE_ON_FAILURE)) {
		println('Gương mặt \'Thu Giang4\' tồn tại trong nhóm \'Người nhà\'.')
	} else {
		println('Gương mặt \'Thu Giang4\' không tồn tại trong nhóm \'Người nhà\'.')
	}
} else {
	println('Nhóm \'Người nhà\' không tồn tại.')
}

Mobile.tap(face, 0)

Mobile.verifyElementText(findTestObject('ObjectThemGuongMat/txtbox_ten_guong_mat_tren_man_thong_tin_GM'), 'Thu Giang4')

Mobile.verifyElementText(findTestObject('ObjectThemGuongMat/txt_so_luong_anh_tai_len'), ('Tải lên: ' + numberOfImages) +'/15')

Mobile.verifyElementText(nhomguongmat, 'Người nhà')

Mobile.closeApplication()



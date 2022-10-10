package BasePage_Mobile_Task;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.URL;

public class BaseClass {

     public AppiumDriver<MobileElement> driver;

    @BeforeTest
    public void Setup(){

        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, "sdk_gphone_x86");
            caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
            caps.setCapability("appPackage", "com.facebook.katana");
            caps.setCapability("appActivity", "com.facebook.katana.LoginActivity");
            caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);

            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AppiumDriver<MobileElement>(url,caps);


        }catch (Exception exp){
            System.out.println("Cause is: "+exp.getCause());
            System.out.println("Message is: "+exp.getMessage());
            System.out.println("----------------------------------------------------------------------");
            exp.printStackTrace();

        }
    }


    @AfterTest
    public void TearDown(){
        driver.closeApp();

    }
}

package Android;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCl {

WebDriver driver;

 @Test
 public void setUp() throws MalformedURLException {
  
  DesiredCapabilities capabilities = new DesiredCapabilities();  
  capabilities.setCapability("deviceName", "emulator-5554");
  capabilities.setCapability("browserName", "Android");
  capabilities.setCapability("platformVersion", "5.1.1");
  capabilities.setCapability("platformName", "Android");
  capabilities.setCapability("appPackage", "com.vaiha.LemmeShowU");
  capabilities.setCapability("appActivity", "com.vaiha.LemmeShowU.Splash");

  driver = new RemoteWebDriver(new URL("http://127.0.0.1:4722/wd/hub"), capabilities);
  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
  
  
  System.out.println("Application has been launched properly");
  
  driver.quit();
 }



}
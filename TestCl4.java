package Android;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCl4 {

	WebDriver driver;

	@BeforeTest
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
	}

	@Test(priority = 1)
	public void DenayPermissionChecking() {

		cancelAppPermission();
		driver.findElement(By.name("CANCEL")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test(priority = 2)
	public void ElementLocator() {
	
		driver.findElement(By.name("LemmeShowU"));
		System.out.println("LemmeShowU UI found properly!!");
	}

	@Test(priority = 3)
	public void ElementLocator2() {

		driver.findElement(By.name("Recording Status: "));
		//driver.findElement(arg0);
		System.out.println("Recording Status: UI found properly!!");
	}

	@Test(priority = 4)
	public void ElementLocator3() {

		driver.findElement(By.name("No screen capture in Progress"));
		// driver.findElement(arg0)
		System.out.println("No screen capture in Progress: UI found properly!!");
	}

	@After
	public void End() {
		driver.quit();
	}
	public void cancelAppPermission() {
		while (driver.findElements(By.xpath("//*[@class='android.widget.Button'][1]")).size() > 0)

		{
			driver.findElement(By.xpath("//*[@class='android.widget.Button'][1]")).click();
		}
	}
}

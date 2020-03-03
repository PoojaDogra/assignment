package workassignments;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class AddingLists {
	private WebDriver driver;
	private String baseUrl;
	JavascriptExecutor js;

	@Before
	public void setUp() throws Exception {

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\Pooja\\Downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		driver = new FirefoxDriver(capabilities);
		baseUrl = "http://todomvc.com";
		js = (JavascriptExecutor) driver;
		new HashMap<String, Object>();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void addinglist() throws Exception {
		driver.get(baseUrl + "/examples/react/#/active/examples/react/");
		driver.manage().window().setSize(new Dimension(1382, 744));
		driver.findElement(By.cssSelector(".new-todo")).sendKeys("clean");
		driver.findElement(By.cssSelector(".new-todo")).sendKeys(Keys.ENTER);
		driver.findElement(By.cssSelector(".new-todo")).sendKeys("cook");
		driver.findElement(By.cssSelector(".new-todo")).sendKeys(Keys.ENTER);
		driver.findElement(By.cssSelector(".new-todo")).sendKeys("dishwashing");
		driver.findElement(By.cssSelector(".new-todo")).sendKeys(Keys.ENTER);
		driver.findElement(By.cssSelector(".new-todo")).sendKeys("grocery shopping");
		driver.findElement(By.cssSelector(".new-todo")).sendKeys(Keys.ENTER);
		driver.findElement(By.cssSelector(".new-todo")).sendKeys("laundry");
		driver.findElement(By.cssSelector(".new-todo")).sendKeys(Keys.ENTER);
		driver.findElement(By.cssSelector(".new-todo")).sendKeys("sleep");
		driver.findElement(By.cssSelector(".new-todo")).sendKeys(Keys.ENTER);
	}
}

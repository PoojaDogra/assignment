package workassignments;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import java.net.URL;

public class UpdatinglistTest {
	private WebDriver driver;
	private String baseUrl;
	private Map<String, Object> vars;
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
		vars = new HashMap<String, Object>();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void updatinglist() throws Exception {
		driver.get(baseUrl + "/examples/react/#/active/examples/react/");

		driver.manage().window().setSize(new Dimension(1382, 744));
		driver.findElement(By.cssSelector(".new-todo")).sendKeys("clean");
		driver.findElement(By.cssSelector(".new-todo")).sendKeys(Keys.ENTER);
		//driver.findElement(By.cssSelector("li:nth-child(1) label")).click();
		//driver.findElement(By.cssSelector("li:nth-child(1) label")).click();
		driver.findElement(By.cssSelector("li:nth-child(1) label")).click();
		{
			WebElement element = driver.findElement(By.cssSelector("li:nth-child(1) label"));
			Actions builder = new Actions(driver);
			builder.doubleClick(element).perform();
		}
		driver.findElement(By.cssSelector(".editing > .edit")).sendKeys(" and wash");
		driver.findElement(By.cssSelector(".editing > .edit")).sendKeys(Keys.ENTER);
	}
}

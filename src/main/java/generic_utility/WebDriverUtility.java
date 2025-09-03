package generic_utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains reusable WebDriver utility methods such as window
 * management, waits, dropdown selections, mouse and keyboard interactions. It
 * also includes additional utilities such as alerts, scrolling, screenshot, JS
 * execution, drag-drop, sliders, and more.
 * 
 * @version 2.0
 * 
 * 
 * @author Srutiranjan Khanda
 */

public class WebDriverUtility {

	WebDriver driver;
	Actions act;
	WebDriverWait wait;

	// constructor
	public WebDriverUtility(WebDriver driver) {
		this.driver = driver;
		this.act = new Actions(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	/**
	 * Maximize the browser window
	 */
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	/**
	 * Makes The fullScreeen
	 */
	public void fullscreenWindow() {
		driver.manage().window().fullscreen();
	}

	// ============= Basic Wait ====================

	/**
	 * Applies implicit wait for load the page
	 */
	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	/**
	 * Wait explicitly until the element is clickable
	 */
	public void explicitWait(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// =======DropDown Select Method =======================

	/**
	 * Select dropDown option by index
	 */
	public void select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * Select dropDown option by value
	 */
	public void select(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	/**
	 * Select dropDown option by VisibleText
	 */
	public void select(String value, WebElement element) {
		Select sel = new Select(element);
		sel.selectByVisibleText(value);
	}

	// ============= Actions Class method =======

	// hover
	public void hover(WebElement element) {
		act.moveToElement(element).build().perform();
	}

	public void hover(int xOffset, int yOffset) {
		act.moveByOffset(xOffset, yOffset).build().perform();
	}

	public void hover(WebElement element, int xOffset, int yOffset) {
		act.moveToElement(element, xOffset, yOffset).build().perform();
	}

	// Click method
	public void click() {
		act.click().build().perform();
	}

	public void click(WebElement element) {
		act.click(element).build().perform();
	}

	// right click
	public void rightlick(WebElement element) {
		act.contextClick(element).build().perform();
	}

	public void rightlick() {
		act.contextClick().build().perform();
	}

	// double click
	public void doubleClick(WebElement element) {
		act.doubleClick(element).build().perform();
	}

	public void doubleClick() {
		act.doubleClick().build().perform();
	}

	// Click and Hold
	public void clickAndHold(WebElement element) {
		act.clickAndHold(element).build().perform();
	}

	public void clickAndHold() {
		act.clickAndHold().build().perform();
	}

	// Release
	public void release(WebElement element) {
		act.release(element).build().perform();
	}

	public void release() {
		act.release().build().perform();
	}

	// Drag And Drop
	public void dragAndDrop(WebElement draggable, WebElement dropable) {
		act.dragAndDrop(draggable, dropable).build().perform();
	}

	public void dragAndDropBy(WebElement draggable, int xOffset, int yOffset) {
		act.dragAndDropBy(draggable, xOffset, yOffset).build().perform();
	}

	// sendKeys
	public void sendKeys(WebElement element, String keys) {
		act.sendKeys(element, keys).build().perform();
	}

	public void sendKeys(String keys) {
		act.sendKeys(keys).build().perform();
	}

	// keyDown
	public void keyDown(Keys key) {
		act.keyDown(key).build().perform();
	}

	// keyUp
	public void keyUp(Keys key) {
		act.keyUp(key).build().perform();
	}

	// ========= Scroll Method ============

	/**
	 * Scroll the page to bring the element into view
	 */
	public void scrollIntoView(WebElement element, Boolean bool) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(" + bool + ");", element);
	}

	/**
	 * Scroll by Given X and Y offset
	 */
	public void scrollByOffset(int x, int y) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(" + x + "," + y + ")");
	}

	// ===========TakeScreenShot Method========
	/**
	 * Takes Screenshot and stored with given name
	 * 
	 * @throws IOException
	 */
	public void takeScreenShot(String screenshotName) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/" + screenshotName + ".png");
		FileHandler.copy(src, dest);
	}

	// ==========Alert Handling ===========
	/**
	 * Accepts alert popups
	 */
	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	/**
	 * Dismiss Alert popups
	 */
	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * Get text from alert Popups
	 */
	public void getTextAlert() {
		driver.switchTo().alert().getText();
	}

	/**
	 * Send text to alert Prompt
	 */
	public void sendKeysAlert(String text) {
		driver.switchTo().alert().sendKeys(text);
	}

	// ====== Javascript Executor Method =================
	/**
	 * Execute javascript to click an Element
	 */
	public void jsClick(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}
	
	/**
	 * Execute Javascript to set value of an element 
	 */
	public void jsSetValue(WebElement element,String value) {
		((JavascriptExecutor)driver).executeScript("arguments[0].value='"+value+"';", element);
	}
	
	/**
	 * Execute Javascript to get value of an element 
	 */
	public String jsGetvalue(WebElement element) {
		return (String) ((JavascriptExecutor)driver).executeScript("return arguments[0].value;", element);
	}
	
	/**
	 * Scroll the page down to the bottom using javascript
	 */
	public void jsScrollToBottom() {
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,document.body.scrollHeight);");
	}
	
	/**
	 * Scroll the page up to the top using javascript
	 */
	public void jsScrollToTop() {
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,0);");
	}
	
	//============Handling Window ==========================
	/**
	 * Switch to Window by title
	 */
	public void switchToWindowByTitle(String partialWindowTitle) {
		Set<String> windowHandles=driver.getWindowHandles();
		for (String i : windowHandles) {
			driver.switchTo().window(i);
			if (driver.getTitle().contains(partialWindowTitle)) {
				break;
			}
		}
		
	}
	
	/**
	 * Switch to Window by URL
	 */
	public void switchToWindowByUrl(String particularUrl) {
		Set<String> windowHandles=driver.getWindowHandles();
		for (String i : windowHandles) {
			driver.switchTo().window(i);
			if (driver.getCurrentUrl().contains(particularUrl)) {
				break;
			}
		}
	}
	
	/**
	 * Switch to the parent Window
	 */
	public void switchToParentWindow(String parentWindowHandle) {
		driver.switchTo().window(parentWindowHandle);
	}
	
	/**
	 * close all window except ParentWindow
	 */
	public void closeAllChildWindow(String parentWindow) {
		Set<String> windowHandles=driver.getWindowHandles();
		for (String i : windowHandles) {
			if (!i.equals(parentWindow)) {
				driver.switchTo().window(i);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
	}

}

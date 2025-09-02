package generic_utility;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriverUtility {

	WebDriver driver;
	Actions act;

	// constructor
	public WebDriverUtility(WebDriver driver) {
		this.driver = driver;
		this.act = new Actions(driver);
	}

	
//Actions Class method	
	
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

}

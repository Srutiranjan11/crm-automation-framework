package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgPage {

	public OrgPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "img[src='themes/softed/images/btnL3Add.gif']")
	private WebElement plusIcon;

	@FindBy(name = "accountname")
	private WebElement orgNameField;
	
	@FindBy(xpath = "//input[contains(@value,'Save')]")
	private WebElement submitBtn;

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getOrgNameField() {
		return orgNameField;
	}

	public WebElement getPlusIcon() {
		return plusIcon;
	}

}

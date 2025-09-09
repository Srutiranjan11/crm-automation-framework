package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Organizations")
	private WebElement orgLink;
	
	@FindBy(css = "img[src='themes/softed/images/user.PNG']")
	private WebElement profile;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOut;
	
	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getProfile() {
		return profile;
	}
	
	public WebElement getSignOut() {
		return signOut;
	}
	
	

}

package PageObjects ;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage  {
	WebDriver driver ;
	
	@FindBy(className="octicon octicon-mark-github")
	WebElement titleImg;
    
	@FindBy(xpath = ".//*[@id='dashboard']/div[1]/div[1]/button")
	WebElement userText;
	@FindBy(xpath=".//*[@id='your_repos']/div[1]/a")
	WebElement addRepoButton;
	
	@FindBy(xpath =".//*[@id='repo_listing']/li[5]/a")
	WebElement openRepoButton ;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String  getUserText(){
		return userText.getText();
	}
	
	public void addRepoClick(){
		addRepoButton.click();
	}
	public void openRepoClick(){
		openRepoButton.click();
	}
	
}

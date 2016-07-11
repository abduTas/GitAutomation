package PageObjects ;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import edu.nyu.cs.javagit.api.JavaGitConfiguration;
import edu.nyu.cs.javagit.api.JavaGitException;

public class AddRepo {
	WebDriver driver;
	
	@FindBy(id="repository_name")
	WebElement newRepoName ;
	
	@FindBy(xpath= ".//*[@id='new_repository']/div[4]/button")
    WebElement newRepoBtn;
    
	@FindBy(xpath="html/body/div[2]/div/a/svg")
	WebElement homepage ;
	
	public AddRepo(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setNewRepoName(String name) {
		newRepoName.sendKeys(name);
	}
 
	public String clickNewRepoBtn(){
		newRepoBtn.click();
		return "clicked";
	}
    public boolean addRepository(String name){
    	this.setNewRepoName(name);
    	System.out.println("nanm is  " + name);
    	String str = "clicked";
    	String clicked = this.clickNewRepoBtn();
    	if(str==clicked)
    	return true ;
    	else 
    		return false;
    }

	public void returnHomePage() throws JavaGitException {
		
		homepage.click();
	}	

}

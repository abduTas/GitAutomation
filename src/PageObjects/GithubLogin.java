package PageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GithubLogin  {

	WebDriver driver ;
	
    @FindBy(id="login_field")

    WebElement username;

    

    @FindBy(id="password")

    WebElement pass;
    

    @FindBy(className="auth-form-header")

    WebElement titleText;

    

    @FindBy(name="commit")

    WebElement login;
    
    public GithubLogin(WebDriver driver){
    	this.driver = driver ; 
    	PageFactory.initElements(driver, this);
    }
    
    public void  setUserName(String name){
    	username.sendKeys(name);
    }
    
    public void setPassword(String password){
    	pass.sendKeys(password);
    }
    public void clickLogin(){
    	login.click();
    }
    
	public void login(String name , String password){
		this.setUserName(name);
		this.setPassword(password);
		this.clickLogin();
	}
}

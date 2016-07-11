package setup;
import PageObjects.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class Setup {
	protected WebDriver driver ;
    protected GithubLogin gitobj ;
	protected HomePage homeobj;
	protected AddRepo addrepo;
	
@BeforeTest
	public void setup(){
	 driver = new FirefoxDriver();
	 driver.get("https://github.com/login");
 }
 
}

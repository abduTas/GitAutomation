package Tess;
import PageObjects.*;
import edu.nyu.cs.javagit.api.DotGit;
import edu.nyu.cs.javagit.api.JavaGitConfiguration;
import edu.nyu.cs.javagit.api.JavaGitException;
import setup.*;

import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class TestGitAutomation extends Setup{
	AddRepo addRepoObj;
	 OpenRepo openrepoobj;
	@Test(priority = 1)
	 public void testTitle(){
		 gitobj = new GithubLogin(driver);
		 homeobj = new HomePage(driver);
		 
		 Scanner sc = new Scanner(System.in);
		 System.out.println("enter user name for git account");
		 String  name =  sc.nextLine();
		 System.out.println("enter password ");
		  String password = sc.nextLine();
		 gitobj.login(name, password);
		 String textUser = homeobj.getUserText();
		 System.out.println(textUser);
		 Assert.assertEquals(textUser, name);
		
		 sc.close();
		 
	 }
	 @Test(priority=2)
	 public void testNumRepo() throws JavaGitException{
		 int count =0;
		 List<WebElement> li = driver.findElements(By.className("repo"));
		 System.out.println("git version" +JavaGitConfiguration.getGitVersion());
		// Create a new directory to be used as a git repository or point to an exisiting directory.
		 File repositoryDirectory = new File("/home/abdullatasleem/git");

		 //get the instance of the dotGit Object
		 DotGit dotGit = DotGit.getInstance(repositoryDirectory);

		 //Initialize the repository ,similar to git init
		 dotGit.init();
		 System.out.println("my repositories on github :");
		  for(WebElement el : li){
			  System.out.println(el.getText());
			  count++;
		  }
	   Assert.assertEquals(count,9);
	  
	   homeobj.addRepoClick();
	 }
	 @Test(priority=3)
	 public  void testWasAdded(){
		addRepoObj = new AddRepo(driver);
		boolean added = addRepoObj.addRepository("neven");
		 Assert.assertEquals(added, true);
	 }
	 
	 @Test(dependsOnMethods = {"testWasAdded"})
     public void testInsideRepo(){
		 openrepoobj = new OpenRepo(driver);
		 driver.get("https://github.com");
		 homeobj.openRepoClick();
		 openrepoobj.getFiles();
		 
	 }    
 
}

package Tess;
//package Tess;
//
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Demo {
//public static void main(String[] args) throws IOException, InterruptedException {
//	 List<String> commands = new ArrayList<String>();
//	   commands.add("/bin/bash");
//	   commands.add("-c");
//	   commands.add("git add .");       
//
//	   StringBuilder out = new StringBuilder();
//
//	   ProcessBuilder pb = new ProcessBuilder(commands);
//	   pb.redirectErrorStream(true);
//	   Process process = pb.start();
//
//
//	   //EDIT:
//	   // get Exit Status   
//	   process.waitFor();
//
//
//	   File file1=new File("/home/vikashkumar/Downloads/cm2.sh");
//       FileWriter fw1 = new FileWriter(file1);
//       PrintWriter pw1 = new PrintWriter(fw1);        
//       String cloneURL ="https://github.com/abduTas/BasicCourseTestNG.git";
//       String repositoryname = "https://github.com/abduTas/BasicCourseTestNG.git";
//       String username = "abduTas";
//       String password = "abdulla27";
//       String comment = "this  file ha been added";
//       pw1.println("#!/bin/bash");
//       pw1.println("echo \"hello !!\"");  
//       pw1.println("cd ~");
//       pw1.println("cd Downloads");
//       pw1.println("cd Github");
//       pw1.println("cd "+repositoryname);
//       pw1.println("git init");
//       pw1.println("git clone "+cloneURL);
//       pw1.println("cd "+repositoryname);
//       pw1.println("git add .");
//       pw1.println("git commit -m\""+comment+"\"");
//       pw1.println("git push https://"+username+":"+password+"@github.com/"+username+"/"+repositoryname+".git");
//       pw1.println("echo \"completed\"");
//    
//       pw1.close();
//       
//       file.setExecutable(true);
//       file1.setExecutable(true);
//       
//       File wd=new File("/home/vikashkumar/Downloads");
//       ProcessBuilder processBuilder = new ProcessBuilder("./cm1.sh");
//	    processBuilder.directory(wd);
//	    processBuilder.start();      
//	    Thread.sleep(5000);
//}
//}


import org.testng.annotations.Test;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFileChooser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;


public class AutomateGithub
{
	static String username, password, repositoryname, comment, updatetext, path;
	
	@FindBy(id="login_field")
    WebElement usernametext;
    
    @FindBy(id="password")
    WebElement passwordtext;
    
    @FindBy(className="btn-primary")
    WebElement signinbutton;
    
    @FindBy(className="btn-sm")
    WebElement newrepositorybutton;
    
    @FindBy(id="repository_name")
    WebElement repositorynametext;
    
    @FindBy(className="btn-primary")
    WebElement createrepositorybutton;
    
    @FindBy(className="js-navigation-open")
    WebElement itemlist;
    
    @FindBy(id="repository_auto_init")
    WebElement addreadmecheckbox;
    
    @FindBy(id="submit-file")
    WebElement updatebtn;
    
    @BeforeTest
	public void beforetest() throws Exception
	{
    	uploader();
		File wd=new File("/home/abdullatasleem/Downloads");
	    ProcessBuilder processBuilder1 = new ProcessBuilder("./cm2.sh");
	    processBuilder1.directory(wd);
	    
	    processBuilder1.start();  
	    Thread.sleep(5000);
	    
	    System.out.println("Your Project Uploaded");
	}
    
    @Test
	public void testOne() throws Exception 
	{
		File folder1 = new File("/home/vikashkumar/Downloads/Github");
		File[] listOfFiles1 = folder1.listFiles();
		
		File folder = new File("/home/vikashkumar/Downloads/Github/"+listOfFiles1[0].getName());
		File[] listOfFiles = folder.listFiles();
		
		WebDriver driver = new FirefoxDriver();
        driver.get("https://github.com/login");
        
        AutomateGithub page = new AutomateGithub();
    	PageFactory.initElements(driver, page);
        
        page.usernametext.sendKeys(username);
        page.passwordtext.sendKeys(password);
        page.signinbutton.click();
        driver.get("https://github.com/"+username+"/"+repositoryname);
        
        List<WebElement> ls =  driver.findElements(By.className("js-navigation-open"));
        
        driver.close();
		
		for(int i=1; i<ls.size(); i++)
		{
			Assert.assertTrue(ls.get(i).getText().equals(listOfFiles[ls.size()-i-1].getName()));  
		}
		
		System.out.println("All your files are uploaded sucessfully");
	}
    
    @Test
    public void testTwo() throws Exception
    {
    	WebDriver driver = new FirefoxDriver();
        driver.get("https://github.com/login");
        
        AutomateGithub page = new AutomateGithub();
    	PageFactory.initElements(driver, page);
            	
    	page.usernametext.sendKeys(username);
        page.passwordtext.sendKeys(password);
        page.signinbutton.click();
        driver.get("https://github.com/"+username+"/2108/edit/master/ReadMe.txt");
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//*[@id='new_blob']/div[3]/div[2]/div/textarea")).sendKeys(updatetext);
        page.updatebtn.click();

        driver.close();
        
        File file=new File("/home/vikashkumar/Downloads/cm3.sh");
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);        
      
        pw.println("#!/bin/bash");
        pw.println("echo \"hello !!\"");  
        pw.println("cd ~");
        pw.println("cd Downloads");
        pw.println("cd Github");
        pw.println("rm -rf "+repositoryname);
        pw.println("git clone https://github.com/"+username+"/"+repositoryname+".git");
        pw.println("echo \"completed\"");
        
        pw.close();
        
        file.setExecutable(true);
        
        File wd=new File("/home/vikashkumar/Downloads");
        ProcessBuilder processBuilder = new ProcessBuilder("./cm3.sh");
	    processBuilder.directory(wd);
	    
	    processBuilder.start();      
	    Thread.sleep(3000);
	    
	    BufferedReader br = new BufferedReader(new FileReader("/home/vikashkumar/Downloads/Github/"+repositoryname+"/ReadMe.txt"));
	    String line = br.readLine();
	    
	    br.close();
	    Assert.assertEquals(line,updatetext);
	    
	    System.out.println("Updation in Readme file Done Sucessfully");
    }
    
    @Test
	public void testThree() throws Exception 
	{
		WebDriver driver = new FirefoxDriver();
        driver.get("https://github.com/login");
        
        AutomateGithub page = new AutomateGithub();
    	PageFactory.initElements(driver, page);
        
        page.usernametext.sendKeys(username);
        page.passwordtext.sendKeys(password);
        page.signinbutton.click();
        driver.get("https://github.com/"+username+"/"+repositoryname);
        List<WebElement> ls = driver.findElements(By.className("message"));
		WebElement msg = ls.get(2);
		String s=msg.getText();
			
		driver.close();
		
		Assert.assertEquals(s,comment);
		
		System.out.println("Commitment of comment is done Sucessfully");
	}
    
    public static void uploader() throws Exception 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Username:");
        username = sc.nextLine();
        System.out.println("Enter Your Password:");
        password = sc.nextLine();
        System.out.println("Enter Your new Repository Name:");
        repositoryname = sc.nextLine();
        System.out.println("Enter Comment for your Repository:");
        comment = sc.nextLine();
        System.out.println("Enter Updation Text for your ReadMe.txt file:");
        updatetext = sc.nextLine();
        String cloneURL = "git@github.com:"+username+"/"+repositoryname+".git";
        sc.close();
        
        WebDriver driver = new FirefoxDriver();
        driver.get("https://github.com/login");
        
        AutomateGithub page = new AutomateGithub();
    	PageFactory.initElements(driver, page);
        
        page.usernametext.sendKeys(username);
        page.passwordtext.sendKeys(password);
        page.signinbutton.click();        
        page.newrepositorybutton.click();
        page.repositorynametext.sendKeys(repositoryname);
        page.createrepositorybutton.click();
        
        System.out.println("New Repository Created");
        
        JFileChooser fileChooser = new JFileChooser();
    	fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        Component parent = null;
		int result = fileChooser.showOpenDialog(parent);
        if (result == JFileChooser.APPROVE_OPTION) 
        {
            File selectedFile = fileChooser.getSelectedFile();
            path=selectedFile.getAbsolutePath();
        }
        path = path.replace(" ", "\\ ");
        
        driver.close();
        
    	File file=new File("/home/abdullatsleem/Downloads/cm1.sh");
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);
        
        pw.println("#!/bin/bash");
        pw.println("echo \"hello !!\"");         
        pw.println("cd ~");
        pw.println("cd Downloads");
        pw.println("mkdir Github");
        pw.println("cd Github");
        pw.println("mkdir "+repositoryname);
        pw.println("cd "+repositoryname);
        pw.println("cp -a "+path+"/. /home/vikashkumar/Downloads/Github/"+repositoryname+"/");
        pw.println("touch ReadMe.txt");
        pw.println("echo \"completed\"");
        
        pw.close();
        
        File file1=new File("/home/vikashkumar/Downloads/cm2.sh");
        FileWriter fw1 = new FileWriter(file1);
//        PrintWriter..
    }
}

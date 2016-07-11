package Tess;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class OpenRepo {
	WebDriver driver; 
	
	public OpenRepo(WebDriver driver){
		this.driver = driver ;
		PageFactory.initElements(driver, this);

	}
	public void getFiles(){
		List<WebElement> li = driver.findElements(By.className("content"));
		for(WebElement el : li){
		System.out.println(el.getText());
	}
  }
}
	

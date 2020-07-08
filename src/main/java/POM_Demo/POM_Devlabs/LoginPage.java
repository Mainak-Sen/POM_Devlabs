package POM_Demo.POM_Devlabs;

import org.openqa.selenium.By;

public class LoginPage extends Base_ServiceNow{
	//elements 
	private By usrName=By.id("user_name");
	private By pass=By.id("user_password");
	private By login=By.id("sysverb_login");
	//methods 
	public LoginPage enterUserName(String username){
		driver.switchTo().frame(0);
		driver.findElement(usrName).sendKeys(username);
		return this;
	}
	
	public LoginPage enterPassword(String pwd) {
		driver.findElement(pass).sendKeys(pwd);
		return this;
	}
	
	public DashBoardPage clickLogin() {
        driver.findElement(login).click();
		return new DashBoardPage();
	}

}

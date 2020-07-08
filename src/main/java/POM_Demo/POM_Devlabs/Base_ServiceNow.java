package POM_Demo.POM_Devlabs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;

public class Base_ServiceNow {
	
	protected static RemoteWebDriver driver;
	protected static String inc_no,latest_desc,caller,category,subcategory,contact_type,URL;
	protected static LoginPage lp;
	protected static DashBoardPage dp;
	protected static CreateIncidentPage cip;
	protected static All_Incidents_Page aip;
	private static Properties prop;
	//@BeforeMethod
	public void startApp() {	
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
	    driver .manage() .timeouts() .implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		try {
			FileInputStream fis=new FileInputStream("./util.properties");
			prop=new Properties();
			try {
				prop.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.println("IOException occured "+e.getMessage());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("File not found");
		}
		URL=prop.getProperty("URL");
		driver.get(URL);
	}

	//@AfterMethod
	public void stopApp() {
		driver.quit();
	}


}

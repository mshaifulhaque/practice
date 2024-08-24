package testCases;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	WebDriver driver;
	Properties p;
	
	
		@BeforeClass
		@Parameters("browser")
		public void setup(String br) throws IOException 
		{
			//Load config.properties data
			FileReader file=new FileReader(".//src//test//resources//config.properties");
			p=new Properties();
			p.load(file);
			
			
			if(br.equals("chrome"))
			{
				driver=new ChromeDriver();
			}
			else if(br.equals("firefox"))
			{
				driver=new FirefoxDriver();
			}
			else if(br.equals("edge"))
			{
				driver=new EdgeDriver();
			}
			else
			{
				System.out.println("invalid Browser");
			}
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			
			driver.get(p.getProperty("appURL"));
		}	
		
		@AfterClass
		public void tearDown()
		{
			driver.quit();
		}
		
		
		
	
	
	

}

package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {

	public static WebDriver driver;
	public static Properties prop;
	public static String machineName;
	public static String currentDateTime;
	
	public static WebDriver initialization() throws IOException {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date1 = new Date();
		currentDateTime = formatter.format(date1);
		 machineName = System.getProperty("user.name");
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("src\\main\\java\\library\\config");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"src\\main\\java\\library\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.edge.driver",
					"src\\main\\java\\library\\msedgedriver.exe");
			driver = new EdgeDriver();	
		}
		
		
		return driver;
		
	}
	
	
	
}

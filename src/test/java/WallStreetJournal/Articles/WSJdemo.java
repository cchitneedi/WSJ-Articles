package WallStreetJournal.Articles;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Pdf;
import org.openqa.selenium.PrintsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.print.PageSize;
import org.openqa.selenium.print.PrintOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import com.google.common.io.Files;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import resources.base;
import utility.Log;

public class WSJdemo extends base {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
//		DOMConfigurator.configure("log4j.xml");
//		initialization();
//
//		try {
//			
//		driver.get(prop.getProperty("WSJ_BUSINESSFINANCE"));
//		driver.manage().window().maximize();
//		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
//		Thread.sleep(5000);
//		// //*[contains(@class,'WSJTheme--selected-section')]
//		
//		List<WebElement> allLinksforMinorHeading=   driver.findElements(By.xpath("//h3/a"));
//		int count=0;
//		
//		for(int i=0;i<2;i++)
//		{
//			//String indURL=allLinksforMinorHeading
//			WebElement indLink=allLinksforMinorHeading.get(i);
//			
//			String k = Keys.chord(Keys.CONTROL, Keys.ENTER);
//		
//			indLink.sendKeys(k);
//			count++;
//			Thread.sleep(1000);
//		}
//		System.out.println("Total no of tabs opened is " + count);
//		Set<String> allWindows=driver.getWindowHandles();
//		Iterator<String> it=  allWindows.iterator();
//		int titleCounter=1;
//		while(it.hasNext())
//		{
//			driver.switchTo().window(it.next());
//			System.out.println(driver.getTitle());
//			Thread.sleep(5000);
//			// press Ctrl+S the Robot's way
//			Robot robot = new Robot();
//			
//			robot.keyPress(KeyEvent.VK_CONTROL);
//			robot.keyPress(KeyEvent.VK_S);
//			robot.keyRelease(KeyEvent.VK_CONTROL);
//			robot.keyRelease(KeyEvent.VK_S);
//			Thread.sleep(5000);
//			// press Enter
//			robot.keyPress(KeyEvent.VK_ENTER);
//			robot.keyRelease(KeyEvent.VK_ENTER);
//			
//			Thread.sleep(5000);
//			titleCounter++;
//		}
//      System.out.println("TitleCounter value is " + titleCounter);
//     // Assert.assertEquals(count, titleCounter);
//	
//	}
//		
//		catch(Exception ex)
//		{
//			System.out.println("Exception occured with " + ex.getLocalizedMessage());
//			
//		}
//	

	}

}

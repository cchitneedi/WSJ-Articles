package WallStreetJournal.Articles;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import resources.base;
import utility.Log;

public class wallStreet extends base {

	@Test
	public void wsa() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		DOMConfigurator.configure("log4j.xml");

		initialization();
		try {
			driver.get(prop.getProperty("WSJ_USNEWS"));
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
			Thread.sleep(5000);

			String FirstLink = driver.findElement(By.xpath("//main[@id='main']/div[1]/div[1]/div[1]/div[2]/div/h2/a"))
					.getAttribute("href");
			System.out.println(FirstLink);
			// Log.info(FirstLink);

			Log.info("WALL STREET US News Header Link: " + FirstLink);
			List<WebElement> allArticleTitles = driver
					.findElements(By.xpath("//div[starts-with(@class,'WSJTheme--list-item')]/div[2]/div[1]/h3/a"));
			int cnl = allArticleTitles.size();
			Log.info("Total U.S. NEWS articles link Count: " + cnl + " + 1");
			// Enhanced for loop
			for (WebElement option : allArticleTitles) {
				String namePrint = option.getAttribute("href");
				// System.out.println("Href value of link: " + namePrint);

				Log.info("US NEWS Links: " + namePrint);
				// Log.info(namePrint);
			}
		} catch (Exception e1) {
			Log.error("No Wall Street US NEWS Related News present for this present date");
		}
		try {
			List<WebElement> allWSArticleTitles = driver
					.findElements(By.xpath("//div[starts-with(@class,'WSJTheme--list-item')]/div[2]/div[1]/h3/a"));
			int WSin = allWSArticleTitles.size();
			Log.info("Downloaded Successfully " + WSin + " + 1 - U.S. NEWS URL's");
			Log.info(" ");
		} catch (Exception e22) {

		}

		driver.quit();
	}

}

package WallStreetJournal.Articles;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import resources.base;
import utility.Log;

public class descriptionInfo extends base {

	@Test
	public void configDetails() throws IOException {
		DOMConfigurator.configure("log4j.xml");
		initialization();
		Log.info("Test Executed By: " + machineName);
		Log.info("Test Executed Date: " + currentDateTime);
		Log.info(" ");
		FileInputStream fis = new FileInputStream("src\\main\\java\\library\\config");
		Properties prop = new Properties();
		prop.load(fis);
		String userfrm = prop.getProperty("WSJ_BUSINESSFINANCE");
		Log.info("Following are the downloaded URL's based on given InputFile");
		Log.info(" ");
		Log.info(userfrm);
		Log.info(" ");
		String WSJATW = prop.getProperty("WSJ_USNEWS");
		Log.info(WSJATW);
		Log.info(" ");
		String LALALA = prop.getProperty("WSJ_LIFEARTS");
		Log.info(LALALA);
		Log.info(" ");
		String OPIOPI = prop.getProperty("WSJ_OPINION");
		Log.info(OPIOPI);
		Log.info(" ");
		String WNWNNW = prop.getProperty("WSJ_WORLDNEWS");
		Log.info(WNWNNW);
		Log.info(" ");

		driver.quit();
	}
	
	
	@Test
	public void meth() throws IOException, InterruptedException {

		DOMConfigurator.configure("log4j.xml");
		initialization();
		driver.get(prop.getProperty("WSJ_USNEWS"));
		Thread.sleep(2000);
		List<WebElement> topics = driver
				.findElements(By.xpath("//nav[starts-with(@class,'WSJTheme--nav-container')]//div//div"));
		int countHeaders = topics.size();
		System.out.println("Total count of Topics is: " + countHeaders);
		Log.info("Total Count of Topics List is: "+countHeaders);
		int z = 1;
		for (WebElement option : topics) {
			String topicNames = option.getText();

			z++;
			if (z == 2) {
				System.out.println("Total Topics present for the current date is: ");
				System.out.println(topicNames);
				Log.info("Total Topics present for the current date is: ");
			} else {
				System.out.println(topicNames);
				Log.info(topicNames);
			}
			// Log.info("Total Topics present for the current date is: " + topicNames);
			Log.info(" ");
		}
		driver.quit();
	}
	
	
}

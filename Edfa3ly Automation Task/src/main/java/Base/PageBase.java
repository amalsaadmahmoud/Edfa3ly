package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import Utils.HighLightDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageBase {

	public static Properties config = new Properties();
	public static FileInputStream fis;
	public static WebDriver driver;

	public PageBase() {
		if (driver == null) {
			
			
			System.out.print("launch");
			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "/src/test/resources/properities/prop.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			if (config.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe");

				driver = new HighLightDriver();
				driver.get(config.getProperty("testsiteurl"));
				driver.manage().window().maximize();

			}
		}
	}

	public static void quit() {

		driver.quit();

	}

	public String getAutomatic ()
	{
		return config.getProperty("automaticProduct");
	}

	public String getProhibted ()
	{
		return config.getProperty("prohProduct");
	}

}

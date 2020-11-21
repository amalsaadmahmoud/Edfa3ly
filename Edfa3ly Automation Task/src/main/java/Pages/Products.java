package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.PageBase;

import java.util.concurrent.TimeUnit;

public class Products extends PageBase {

	private static int cartCounterBeforeAdding;
	private static int getCartCounterAfterAdding;
	WebDriverWait wait = new WebDriverWait(driver, 50);

	public void verifyAddingAutomatedProduct() throws InterruptedException {
		getCartCounterBeforeAdding();
		// Enter the product URL
		By url = By.name("url");
		wait.until(ExpectedConditions.visibilityOfElementLocated(url));
		driver.findElement(url).sendKeys(getAutomatic());
		driver.findElement(url).sendKeys(Keys.ENTER);
		// Select the size
		By select = By.name("size");
		wait.until(ExpectedConditions.visibilityOfElementLocated(select));
		boolean staleElement = true;
		while(staleElement){
			try{
				Select selectSize = new Select(driver.findElement(select));
				selectSize.selectByVisibleText("10");
				Thread.sleep(3000);


				staleElement = false;

			} catch(StaleElementReferenceException e){
				staleElement = true;
			}
		}

		// Click Add item
		By AddItemBtn = By.xpath("//input[@value='Add item']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(AddItemBtn));
		driver.findElement(AddItemBtn).click();
		getCartCounterAfterAdding();
		System.out.print(getCartCounterAfterAdding);
	}

	public void getCartCounterBeforeAdding() {
		By cartCounter = By.id("cartCounter");
		wait.until(ExpectedConditions.visibilityOfElementLocated(cartCounter));
		this.cartCounterBeforeAdding = Integer.parseInt(driver.findElement(cartCounter).getText());

	}

	public void getCartCounterAfterAdding() throws InterruptedException {

        By cartCounter = By.id("cartCounter");
		wait.until(ExpectedConditions.visibilityOfElementLocated(cartCounter));
		this.getCartCounterAfterAdding = Integer.parseInt(driver.findElement(cartCounter).getText());

	}

	public boolean compareProductscount() throws InterruptedException {
		verifyAddingAutomatedProduct();
		return (cartCounterBeforeAdding == (getCartCounterAfterAdding -1 ));
	}
	public boolean addProhibitedProduct() {


		WebDriverWait wait = new WebDriverWait(driver, 50);
		By url = By.name("url");
		wait.until(ExpectedConditions.visibilityOfElementLocated(url));
		driver.findElement(url).sendKeys(getProhibted());
		driver.findElement(url).sendKeys(Keys.ENTER);

		Boolean isNotEligibleMsgDisplayed = driver.findElement(By.xpath("//label[@ng-if='isNotEligibleForBuy()']"))
				.isDisplayed();

return isNotEligibleMsgDisplayed;
	}

}

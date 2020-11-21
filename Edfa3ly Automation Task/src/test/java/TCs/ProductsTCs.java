package TCs;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.Products;

public class ProductsTCs extends testBase {

	@Test
	public static void verifyAddingAutomatedProduct() throws InterruptedException {

		Products product = new Products();
		Assert.assertTrue(product.compareProductscount());

	}

	@Test
	public static void verifyAddingProhProduct() throws InterruptedException {

		Products product = new Products();
		Assert.assertTrue(product.addProhibitedProduct());

	}

}

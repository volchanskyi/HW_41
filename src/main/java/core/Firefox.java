package core;

import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox {

    static WebDriver driver;
    By by;
    static String[] elements = { "brandNameLink", "brandBrandName", "singlePrice", "shoppingBag", "earchField",
	    "submitProductSearch", "addToListBtn", "shippingAndReturnAccordion", "pinLink", "addToBagButton" };
    static DecimalFormat formatter = new DecimalFormat("00");
    static int k = 1;
    static int z;

    public static boolean isPresent(final By by) {
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	if (!driver.findElements(by).isEmpty())
	    return true;
	else
	    return false;
    }

    public static void main(String[] args) throws InterruptedException {
	Logger.getLogger("").setLevel(Level.OFF);

	String driverPath = "./resources/webdrivers/pc/geckodriver.exe";
	String url = "https://www.macys.com/shop/product/apple-watch-series-3-gps-cellular-42mm-space-black-stainless-steel-case-with-black-sport-band?ID=5302660&CategoryID=55285";

	if (System.getProperty("os.name").toUpperCase().contains("MAC"))
	    driverPath = "./resources/webdrivers/mac/geckodriver.sh";
	else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS"))
	    driverPath = "./resources/webdrivers/pc/geckodriver.exe";
	else
	    throw new IllegalArgumentException("Unknown OS");

	System.setProperty("webdriver.gecko.driver", driverPath);
	driver = new FirefoxDriver();
	// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get(url);

	// //*[@id='productHeaderBox']/div[1]/div/div/div/div/a
	// //*[@id='productHeaderBox']/div[1]/div/div/div/div/h1
	// //*[@id='productHeaderBox']/section[2]/div/div[1]/span

	By brandNameLink = By.xpath("//div[1]/div/div[1]/div/div/div/div/a");
	By brandBrandName = By.xpath("//div[1]/div/div[1]/div/div/div/div/h1");
	By singlePrice = By.xpath("//*[@id='productHeaderBox']/section[2]/div/div[1]/span");
	By shoppingBag = By.xpath("//*[@id='checkoutLink']");
	By searchField = By.xpath("//*[@id='globalSearchInputField']");
	By submitProductSearch = By.xpath("//*[@id='searchSubmit']");
	By addToListBtn = By.xpath("//*[@id='orderPanel5302660']/div/div[1]/div[3]/div/label");
	By shippingAndReturnAccordion = By.xpath("//*[@id='product-shipping-returns-header']");
	By pinLink = By.xpath("//*[@id='socialIcon_pi2']");
	By addToBagButton = By.xpath("//div[1]/div/section[2]/div/div[1]/span");

	printElem(brandNameLink);
	printElem(brandBrandName);
	printElem(singlePrice);
	printElem(shoppingBag);
	printElem(searchField);
	printElem(submitProductSearch);
	printElem(addToListBtn);
	printElem(shippingAndReturnAccordion);
	printElem(pinLink);
	printElem(addToBagButton);

	driver.quit();
    }

    private static void printElem(By name) {

	for (; z < 10; z++) {
	    System.out.println(formatter.format(k) + ". Element [" + elements[z] + "]: "
		    + (isPresent(name) ? "Exists" : " Not exist "));
	    k++;

	}

    }
}

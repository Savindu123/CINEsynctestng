import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestTitle {

	private WebDriver driver;

	@BeforeClass
	public void beforeMethod() {

		System.out.println("Starting Test On Chrome Browser");
		String baseUrl = "https://cinesync-v2-stg.layoutindex.dev/";
		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().window().maximize();

	}

	@Test(priority = 1)
	public void f1() {

		// Test Home page title

		String actualTitle = driver.getTitle();
		String expectedtitle = "Home";

		Assert.assertEquals(actualTitle, expectedtitle, "Home Page title is not as expected.");

		System.out.println("Home Page title is as expected");

	}

	@Test(priority = 2)
	public void f2() {

		// Test Tickets page title

		WebElement btnTicket = driver.findElement(By.xpath("//li[@class='nav-item buyTicketBtn']"));
		btnTicket.click();

		String actualTitle = driver.getTitle();
		String expectedtitle = "Buy Movie Tickets Online | YourCinema";

		Assert.assertEquals(actualTitle, expectedtitle, "Ticketing page title is not as expected.");

		System.out.println("Ticketing Page title is as expected");

	}

	@Test(priority = 3)
	public void f3() {

		// Test Login page title

		WebElement btnTicket = driver.findElement(By.xpath("//li[@class='nav-item loginBtn']"));
		btnTicket.click();

		String actualTitle = driver.getTitle();
		String expectedtitle = "YourCinema | Buy Sri Lanka Cinema & Movie Tickets Online";

		Assert.assertEquals(actualTitle, expectedtitle, "Login Page title is not as expected.");

		System.out.println("Login Page title is as expected");

	}

	@Test(priority = 4)
	public void f4() {

		// Test Login page title

		WebElement btnTicket = driver.findElement(By.xpath("//li[@class='nav-item movies ']"));
		btnTicket.click();

		String actualTitle = driver.getTitle();
		String expectedtitle = "Movie Tickets | Latest Movies | YourCinema";

		Assert.assertEquals(actualTitle, expectedtitle, "Movies Page title is not as expected.");

		System.out.println("Movies Page title is as expected");

	}

	@Test(priority = 5)
	public void f5() {

		// Test Login page title

		WebElement btnTicket = driver.findElement(By.xpath("//li[@class='nav-item events ']"));
		btnTicket.click();

		String actualTitle = driver.getTitle();
		String expectedtitle = "Events";

		Assert.assertEquals(actualTitle, expectedtitle, "Events Page title is not as expected.");

		System.out.println("Events Page title is as expected");

	}

	@Test(priority = 6)
	public void f6() {

		// Test Login page title

		WebElement btnTicket = driver.findElement(By.xpath("//li[@class='nav-item locations ']"));
		btnTicket.click();

		String actualTitle = driver.getTitle();
		String expectedtitle = "Movie Ticket Booking";

		Assert.assertEquals(actualTitle, expectedtitle, "Location Page title is not as expected.");

		System.out.println("Location Page title is as expected");

	}

	@Test(priority = 7)
	public void f7() {

		// Test Login page title

		WebElement btnTicket = driver.findElement(By.xpath("//li[@class='nav-item store ']"));
		btnTicket.click();

		String actualTitle = driver.getTitle();
		String expectedtitle = "Gift Card";

		Assert.assertEquals(actualTitle, expectedtitle, "Gift Card Page title is not as expected.");

		System.out.println("Gift Card Page title is as expected");

	}

	@Test(priority = 8)
	public void f8() {

		// Test Login page title

		WebElement btnTicket = driver.findElement(By.xpath("//li[@class='nav-item offers ']"));
		btnTicket.click();

		String actualTitle = driver.getTitle();
		String expectedtitle = "Offers";

		Assert.assertEquals(actualTitle, expectedtitle, "offers Page title is not as expected.");

		System.out.println("offers Page title is as expected");

	}

	@Test(priority = 9)
	public void f9() {

		// Test Login page title

		WebElement btnTicket = driver.findElement(By.xpath("//li[@class='nav-item about_us ']"));
		btnTicket.click();

		String actualTitle = driver.getTitle();
		String expectedtitle = "About YourCinema | Buy Cinema Tickets Online";

		Assert.assertEquals(actualTitle, expectedtitle, "About Page title is not as expected.");

		System.out.println("About Page title is as expected");

	}

	// Test login function

	@Test(priority = 10)
	public void testInvalidLogin() {
		// Enter invalid login credentials
		WebElement btnlogin = driver.findElement(By.xpath("//li[@class='nav-item loginBtn']"));
		btnlogin.click();

		driver.findElement(By.id("loginEmail")).sendKeys("an824@gmail.com");
		driver.findElement(By.id("loginPassword")).sendKeys("Asd123");
		// Click on the login button
		driver.findElement(By.xpath("//button[@class='btn btn-custom btn-pink w-100 btn-text-center']")).click();

		// Verify an error message is displayed for invalid credentials
		String actualErrorMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
		String expectedErrorMessage = "Invalid email or password";
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message not displayed for invalid login.");

		System.out.println("Error message displayed for invalid login.");
	}

	@Test(priority = 11)
	public void testValidLogin() {
		// Enter valid login credentials

		WebElement btnlogin = driver.findElement(By.xpath("//li[@class='nav-item loginBtn']"));
		btnlogin.click();

		driver.findElement(By.id("loginEmail")).sendKeys("an82334@gmail.com");
		driver.findElement(By.id("loginPassword")).sendKeys("Asd123");

		// Click on the login button
		driver.findElement(By.xpath("//button[@class='btn btn-custom btn-pink w-100 btn-text-center']")).click();

		// Verify the login was successful by checking the redirected URL
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://cinesync-v2-stg.layoutindex.dev/";
		Assert.assertEquals(actualUrl, expectedUrl, "Login was not successful.");
		System.out.println("Login was successful.");
	}

	// Test Buy ticket function

	@Test(priority = 12)
	public void testBuyticketfunction() {

		WebElement btnTicket = driver.findElement(By.xpath("//li[@class='nav-item buyTicketBtn']"));
		btnTicket.click();
		
		WebElement[] classnames = driver.findElements(By.xpath("//a[@href='https://cinesync-v2-stg.layoutindex.dev/seat-booking?showtime=ZXlYYTBzWmgzaXIrOUtjNmQ2ZUdtQT09']")).toArray(new WebElement[0]);
		
		for (WebElement classname : classnames) {
			String classname1 = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
        }
	}

	@AfterClass
	public void afterMethod() {
		System.out.println("Finished Test On Chrome Browser");
//		driver.quit();

	}

}
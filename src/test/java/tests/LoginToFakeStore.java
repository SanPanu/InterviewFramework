package tests;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class LoginToFakeStore extends BaseTest
{
	@Test()
	public void login()
	{
		By allCards =By.xpath("//div[@class='columns is-multiline']//app-menu");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(allCards));
		WebElement PomCard = driver.findElement(By.xpath("//a[normalize-space()='Page Object Model']"));
		wait.until(ExpectedConditions.elementToBeClickable(PomCard)).click();
		By fakeSotreLadingLogo = By.xpath("//h1[normalize-space()='Fake Store']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(fakeSotreLadingLogo));
		Assert.assertTrue(driver.findElement(fakeSotreLadingLogo).isDisplayed(), "fake store logo is not displayed");
		driver.findElement(By.xpath("//i[@class='fas fa-user']")).click();
		By loginPageLocator=By.xpath("//h2[@class='title']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginPageLocator));
		Assert.assertTrue(driver.findElement(loginPageLocator).isDisplayed(), "user not landed into login page");
		driver.findElement(By.xpath("//input[@placeholder='Enter Username']")).sendKeys("mor_2314");
		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("83r5^_");
		WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
		wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(fakeSotreLadingLogo));
		Assert.assertTrue(driver.findElement(fakeSotreLadingLogo).isDisplayed(), "fake store logo is not displayed");
		
	}
	
	@Test()
	public void inputCard()
	{
		By allCards =By.xpath("//div[@class='columns is-multiline']//app-menu");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(allCards));
		
		By inputCard=By.xpath("//a[normalize-space()='Edit']");
		wait.until(ExpectedConditions.elementToBeClickable(inputCard)).click();
		
		driver.findElement(By.xpath("//input[@id='fullName']")).sendKeys("sangamesh");
		
		driver.findElement(By.xpath("//input[@id='join']")).sendKeys("++Added text",Keys.TAB);
		
		String stringValue = driver.findElement(By.xpath("//input[@id='getMe']")).getAttribute("value");
		AssertJUnit.assertEquals(stringValue, "ortonikc");
		
		driver.findElement(By.xpath("//input[@id='clearMe']")).clear();
		
		WebElement disbaledField = driver.findElement(By.xpath("//input[@id='noEdit']"));
		Assert.assertFalse(disbaledField.isEnabled(), "Text field is enabled");
		
	}
	
	@Test()
	public void buttonCard()
	{
		
		By allCards =By.xpath("//div[@class='columns is-multiline']//app-menu");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(allCards));
		
		By buttonCard=By.xpath("//a[normalize-space()='Click']");
		wait.until(ExpectedConditions.elementToBeClickable(buttonCard)).click();
		
		WebElement findLocationButton = driver.findElement(By.xpath("//button[@id='position']"));
		int X = findLocationButton.getLocation().getX();
		int Y = findLocationButton.getLocation().getY();
		System.out.println(X +" "+ Y);
		
		WebElement propertyButton = driver.findElement(By.xpath("//button[@id='property']"));
		int hieghtOfButton = propertyButton.getSize().getHeight();
		int widthOfButton=propertyButton.getSize().getHeight();
		System.out.println(hieghtOfButton*widthOfButton);
		
	}
	

}

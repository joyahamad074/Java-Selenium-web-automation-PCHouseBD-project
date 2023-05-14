package com.web_automation.PChousebd;

import static org.testng.Assert.assertEquals;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class PChousebd_automation {

	@Test
	public void Login() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		
		// Navigate to the PCHouse login page
        driver.get("https://www.pchouse.com.bd/index.php?route=account/login");
        
        driver.manage().window().maximize();
        
        //Web Page Title check
        assertEquals(driver.getTitle(), "Account Login");
        
        // Find the email and password input fields and enter the values
        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"input-email\"]"));
        emailField.sendKeys("zewuma@afia.pro");
        WebElement passwordField = driver.findElement(By.id("input-password"));
        passwordField.sendKeys("11223344jJ");
        
        
        // Find and click the login button
        WebElement loginButton = driver.findElement(By.cssSelector("button[type=\"submit\"]"));
        loginButton.click();
        
        
        // Wait for the page to load
        Thread.sleep(3000);

        // Verify that the user is logged in
        if (driver.getTitle().equals("My Account")) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed.");
        }
        
     // Create an instance of JavascriptExecutor interface
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll down to the bottom of the page
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        
        WebElement subscribe = driver.findElement(By.xpath("//*[@id=\"content\"]/div[5]/ul/li/a"));
        subscribe.click();
        
        WebElement subscribe1 = driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset/div/div/label[1]/input"));
        subscribe1.click();
        
        WebElement subscribebtn = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div[2]/button"));
        subscribebtn.click();
        
        WebElement subscribetxt = driver.findElement(By.xpath("//*[@id=\"account-account\"]/div[1]"));
        String S_text = subscribetxt.getText();
        
        if(S_text.contains("Success")) {
        	System.out.println("Subscribed Successfully");
        }else {
        	System.out.println("Subscribed Failed");
        }
        
      //edit account info.
        driver.findElement(By.partialLinkText("Edit your")).click();
        driver.findElement(By.id("input-firstname")).clear();
        driver.findElement(By.id("input-firstname")).sendKeys("Joy");
        driver.findElement(By.id("input-lastname")).clear();
        driver.findElement(By.id("input-lastname")).sendKeys("Ahmed");
        driver.findElement(By.cssSelector("div[class=\"pull-right\"]>button")).click();
        
        
        //Adding Address
        driver.findElement(By.className("edit-address")).click();
        driver.findElement(By.className("btn-primary")).click(); 
        driver.findElement(By.id("input-firstname")).sendKeys("Joy"); 
        driver.findElement(By.id("input-lastname")).sendKeys("Ahmed"); 
        driver.findElement(By.id("input-company")).sendKeys("Ma it"); 
        driver.findElement(By.id("input-address-1")).sendKeys("Savar, Dhaka"); 
        driver.findElement(By.id("input-address-2")).sendKeys("N/A"); 
        driver.findElement(By.id("input-city")).sendKeys("Dhaka"); 
        driver.findElement(By.id("input-postcode")).sendKeys("1850");  
        driver.findElement(By.id("input-zone")).click();
        driver.findElement(By.cssSelector("option[value=\"322\"]")).click();
        driver.findElement(By.cssSelector("label[class=\"radio-inline\"]>input[value=\"1\"]")).click();
        driver.findElement(By.cssSelector("div[class=\"pull-right\"]>button")).click();
        
        driver.findElement(By.linkText("Account")).click();
        
        
        //Add to cart a product
        driver.findElement(By.cssSelector("a[href*=\"laptops\"]>[class=\"links-text\"]")).click();
        driver.findElement(By.linkText("Laptops")).click();
        driver.findElement(By.partialLinkText("IdeaPad C340")).click();
        driver.findElement(By.cssSelector("a[class*=\"btn-cart\"][id=\"button-cart\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#cart-total")).click();
        String cartitem = driver.findElement(By.cssSelector("span[class=\"count-badge \"]")).getText();
        Integer cartitem_int = Integer.parseInt(cartitem);
        
        String unit_price = driver.findElement(By.cssSelector(".table-responsive > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(5)")).getText();
        unit_price = unit_price.replaceAll("[^0-9]", "");
        Integer int_unit_price = Integer.parseInt(unit_price);
        
        String total_price = driver.findElement(By.cssSelector(".table-responsive > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(6)")).getText();
        total_price = total_price.replaceAll("[^0-9]", "");
        Integer int_total_price = Integer.parseInt(total_price);
        
        Integer price_mul = (cartitem_int * int_unit_price);

        //check price validation
        if(price_mul.equals(int_total_price)) {
        	
        	System.out.println("Price is ok");
        	
        }
        else {
			System.out.println("Price is not ok");
		}
        
        
        Thread.sleep(5000);
        // Close the browser
        driver.quit();
	}
}

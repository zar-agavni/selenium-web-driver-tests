package com.demo.inputforms;

import junit.framework.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleFormTest extends TestCase {

    private WebDriver driver;

    @Override
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zarag\\Downloads\\chromedriver_96\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Override
    public void tearDown() throws Exception {
        driver.quit();
    }

    public void testSingleInputField() {
        driver.get("http://demo.seleniumeasy.com/basic-first-form-demo.html");

        final WebElement userMessage = driver.findElement(By.id("user-message"));
        userMessage.sendKeys("Hello");

        driver.findElement(By.className("btn-default")).click();
        String text = driver.findElement(By.id("display")).getText();

        //Thread.sleep(15000);

        driver.quit();

        assertEquals("Hello", text);
    }

    public void testTwoInputFields() {
        driver.get("http://demo.seleniumeasy.com/basic-first-form-demo.html");
        driver.findElement(By.id("sum1")).sendKeys("5");
        driver.findElement(By.id("sum2")).sendKeys("4");
        driver.findElement(By.cssSelector("#gettotal>.btn")).click();
        String res = driver.findElement(By.id("displayvalue")).getText();
        assertEquals("9", res);
    }
}
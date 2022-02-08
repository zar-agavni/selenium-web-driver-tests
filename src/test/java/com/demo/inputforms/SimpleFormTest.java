package com.demo.inputforms;

import com.demo.ChromeTestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SimpleFormTest extends ChromeTestCase {

    public void testSingleInputField() {
        driver.get("http://demo.seleniumeasy.com/basic-first-form-demo.html");

        final WebElement userMessage = driver.findElement(By.id("user-message"));
        userMessage.sendKeys("Hello");

        driver.findElement(By.cssSelector("#get-input .btn-default")).click();
        String text = driver.findElement(By.id("display")).getText();

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
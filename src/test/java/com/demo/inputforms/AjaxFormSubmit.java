package com.demo.inputforms;

import com.demo.ChromeTestCase;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class AjaxFormSubmit extends ChromeTestCase {

    public void testAjaxForm() throws InterruptedException {
        driver.get("http://demo.seleniumeasy.com/ajax-form-submit-demo.html");
        driver.findElement(By.id("title")).sendKeys("Test");
        driver.findElement(By.cssSelector("textarea#description.form-control")).sendKeys("Test");
        driver.findElement(By.cssSelector("#btn-submit")).click();
        String beforeSubmit = driver.findElement(By.cssSelector("div#submit-control")).getText();
        assertEquals("Ajax Request is Processing!",beforeSubmit);
        TimeUnit.SECONDS.sleep(1);
        String approvingText = driver.findElement(By.cssSelector("div#submit-control")).getText();
        assertEquals("Form submited Successfully!",approvingText);
    }

    public void testIncompleteForm() {
        driver.get("http://demo.seleniumeasy.com/ajax-form-submit-demo.html");
        driver.findElement(By.cssSelector("#btn-submit")).click();
        String style = driver.findElement(By.id("title")).getAttribute("style");
        assertEquals("border: 1px solid rgb(255, 0, 0);",style);
    }
}

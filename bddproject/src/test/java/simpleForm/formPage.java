package simpleForm;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class formPage {
    WebDriver driver;

    @Given("launch the browser")
    public void launch_the_browser(){
        driver = new ChromeDriver();
        driver.get("https://v1.training-support.net/selenium/simple-form");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @When("enter the valid details")
    public void enter_the_valid_details(){
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("John");

        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Doe");

        WebElement emailId = driver.findElement(By.id("email"));
        emailId.sendKeys("john.doe@gmail.com");

        WebElement phoneNumber = driver.findElement(By.id("number"));
        phoneNumber.sendKeys("1234567809");

        WebElement text = driver.findElement(By.tagName("textarea"));
        text.sendKeys("Hello, my self John doe, i'm masai student i'm learning SDET course.");

    }

    @And("click the submit button")
    public void click_the_submit_button(){
        driver.findElement(By.xpath("//input[@value=\"submit\"]")).click();
        driver.switchTo().alert().accept();
//        driver.findElement(By.xpath("//input[@value=\"Clear\"]")).click();
    }
    @Then("close the browser")
    public void close_the_browser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}

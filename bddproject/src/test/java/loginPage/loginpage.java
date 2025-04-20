package loginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class loginpage {
    WebDriver driver;

    @Given("launch browser")
    public void launch_browser(){
        driver = new ChromeDriver();
        driver.get("https://v1.training-support.net/selenium/simple-form");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        System.out.println("Launch the browser");
    }
    @When("Enter the details")
    public void Enter_the_details(){
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("John");

        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Doe");

        WebElement emailId = driver.findElement(By.id("email"));
        emailId.sendKeys("john.doe@gmail.com");

        WebElement phoneNum = driver.findElement(By.id("number"));
        phoneNum.sendKeys("9876543210");

        WebElement textArea = driver.findElement(By.tagName("textarea"));
        textArea.sendKeys("bangolre");
        System.out.println("Enter the Valid details");
    }
    @And("Click button")
    public void Click_button() throws InterruptedException {
        driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
        System.out.println("Click the submit button");

    }

    @Then("Close browser")
    public void Close_browser(){
        driver.quit();
    }
}

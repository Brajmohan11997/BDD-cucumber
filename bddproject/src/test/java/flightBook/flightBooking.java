package flightBook;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;

public class flightBooking {
    WebDriver driver;

    @Given("user is on the booking page")
    public void user_is_on_the_booking_page() throws InterruptedException {
      driver = new ChromeDriver();
      driver.get("https://blazedemo.com/");
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Select select1 = new Select(driver.findElement(By.xpath("//select[@name=\"fromPort\"]")));
        select1.selectByVisibleText("Paris");

        Select select2 = new Select(driver.findElement(By.xpath("//select[@name=\"toPort\"]")));
        select2.selectByVisibleText("London");

        driver.findElement(By.xpath("//input[@value=\"Find Flights\"]")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("(//input[@value=\"Choose This Flight\"])[1]")).click();
        Thread.sleep(3000);

    }

    @When("user enters flight details and submits")
    public void user_enters_flight_details_and_submits() throws InterruptedException {
        WebElement name = driver.findElement(By.xpath("//input[@placeholder=\"First Last\"]"));
        name.sendKeys("John Doe");

        WebElement address = driver.findElement(By.xpath("//input[@id=\"address\"]"));
        address.sendKeys("America");

        WebElement city = driver.findElement(By.xpath("//input[@id=\"city\"]"));
        city.sendKeys("america");

        WebElement state = driver.findElement(By.xpath("//input[@id=\"state\"]"));
        state.sendKeys("america");

        Select cardType = new Select(driver.findElement(By.xpath("//select[@name=\"cardType\"]")));
        cardType.selectByVisibleText("American Express");

        WebElement cardNumber = driver.findElement(By.xpath("//input[@id=\"creditCardNumber\"]"));
        cardNumber.sendKeys("1234 4567 7897");

        driver.findElement(By.xpath("//input[@value=\"Purchase Flight\"]")).click();
        Thread.sleep(3000);

    }

    @Then("booking confirmation message is displayed")
    public void booking_confirmation_message_is_displayed() throws InterruptedException {
        String actualPage = driver.getCurrentUrl();
        String expectPage = "https://blazedemo.com/confirmation.php";

        Assert.assertEquals(actualPage, expectPage);
        System.out.println(actualPage);

        Thread.sleep(5000);
        driver.quit();

    }
}

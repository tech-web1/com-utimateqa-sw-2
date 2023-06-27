package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setup() {

        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        //click on sign link
        driver.findElement(By.xpath("//a[href='/users/sign_in']")).click();
        //verify the text welcome back
        String expectedText="Welcome Back";
        String actualText=driver.findElement(By.xpath("//h2[@class='page__heading']")).getText();
        Assert.assertEquals("Welcome Back is not displayed",expectedText,actualText);
    }
    @Test
    public void VerifyTheErrorMessage(){
        driver.findElement(By.xpath("/button[@class='button button-primary g-recaptcha']")).click();
         //Enter invalid username
        driver.findElement(By.xpath("//input[@id='user[email]']")).sendKeys("jinal@yahoo.com");
        //Enter invalid password
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("panther123");
        //click on login button
        driver.findElement(By.xpath("//button[@class='button button-primary g-recaptcha']")).click();
        String expectedMessage="Invalid email or password.";
        String actualMessage=driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
        Assert.assertEquals("Error message displayed",actualMessage,expectedMessage);

    }
}
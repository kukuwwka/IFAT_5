import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FirstTest {
    @Test
    public void checkZipCodeInput() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.xpath("//*[@type='text' and @name='zip_code']")).sendKeys("5656");
        driver.findElement(By.xpath("//*[@type='submit' and @value='Continue']")).click();
        Thread.sleep(2000); // пришлось добавить задержку, т.к. страница не успевала прогрузиться и элемент не находился

        boolean isErrorAppear = driver.findElement(By.cssSelector(".error_message")).isDisplayed();
        assertTrue(isErrorAppear, "Error message does not appear");

        String errorMsgText = driver.findElement(By.cssSelector(".error_message")).getText();
        assertEquals(errorMsgText, "Oops, error on page. ZIP code should have 5 digits");
        driver.quit();
    }


    @Test
    public void checkZipCodeFiveDigitInput() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.xpath("//*[@type='text' and @name='zip_code']")).sendKeys("56561");
        driver.findElement(By.xpath("//*[@type='submit' and @value='Continue']")).click();
        Thread.sleep(2000); // пришлось добавить задержку, т.к. страница не успевала прогрузиться и элемент не находился

        boolean isRegisterBtnExist = driver.findElement(By.cssSelector("input[type='submit'][value='Register']")).isDisplayed();
        assertTrue(isRegisterBtnExist, "Register button is not visible");

        driver.quit();
    }

    @Test
    public void FillAllFields() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.xpath("//*[@type='text' and @name='zip_code']")).sendKeys("56561");
        driver.findElement(By.xpath("//*[@type='submit' and @value='Continue']")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("input[type='text'][name='first_name']")).sendKeys("fwegweg");
        driver.findElement(By.cssSelector("input[type='text'][name='last_name']")).sendKeys("1277512g");
        driver.findElement(By.cssSelector("input[type='text'][name='email']")).sendKeys("1252352312g");
        driver.findElement(By.xpath("//input[@type='text' and @name='password1']")).sendKeys("12512g");
        driver.findElement(By.xpath("//input[@type='password' and @name='password2']")).sendKeys("12512g");
        driver.findElement(By.xpath("//input[@type='submit' and @value='Register']")).click();

        boolean isErrorOfRegist = driver.findElement(By.cssSelector(".error_message")).isDisplayed();
        assertTrue(isErrorOfRegist, "Oops, error on page. Some of your fields have invalid data or email was previously used");

        driver.quit();
    }
}

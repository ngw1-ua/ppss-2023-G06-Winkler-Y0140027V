package ejercicio2.conPO;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestLogin2 {
    WebDriver driver;
    HomePage hp;
    @BeforeEach
    public void before(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        this.hp = new HomePage(this.driver);
    }

    @AfterEach
    public void after()
    {
        driver.close();
    }
    @Test
    public void test_Login_Correct()
    {
        assertTrue(hp.getTitle().contains("Madison Island"));

        CustomerLoginPage clp = hp.GetLoginPage();

        MyAccountPage maccp = clp.LoginOK("ngwinkler-ppss@ppss.es", "#Ppss23");

        assertTrue(maccp.getTitle().contains("My Account"));

    }

    @Test
    public void test_Login_Incorrect()
    {
        //this.hp = new HomePage(this.driver);

        assertTrue(hp.getTitle().contains("Madison Island"));

        CustomerLoginPage clp = hp.GetLoginPage();

        String error = clp.LoginFail("ngwinkler-ppss@ppss.es", "Incorrect@12356");

        assertEquals("Invalid login or password.", error);
    }
}

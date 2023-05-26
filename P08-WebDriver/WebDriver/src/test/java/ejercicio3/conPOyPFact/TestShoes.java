package ejercicio3.conPOyPFact;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestShoes {
    public static Cookies cookie;
    public WebDriver driver;
    public MyAccountPage accPage;
    @BeforeAll
    public static void cookieCrumble(){
        cookie = new Cookies();
        cookie.storeCookiesToFile("ngwinkler-ppss@ppss.es", "#Ppss23");
    }
    @BeforeEach
    public void setUp(){
        ChromeOptions chromeOptions = new ChromeOptions();
        //recuperamos el valor de la propiedad chromeHeadless definida en surefire
        boolean headless = Boolean.parseBoolean(System.getProperty("chromeHeadless"));
        //el método setHeadless() cambia la configuración de Chrome a modo headless
        chromeOptions.setHeadless(headless);

        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        this.cookie.loadCookiesFromFile(driver);
        this.driver.get("http://demo-store.seleniumacademy.com/customer/account/");
        this.accPage = new MyAccountPage(driver);
    }

    @AfterEach
    public void tearDown(){
        this.driver.close();
    }

    @Test
    public void compareShoes(){
        assertTrue(accPage.getTitle().contains("My Account"));

        ShoesPage shoe = accPage.getShoesPage();

        assertTrue(shoe.getTitle().contains("Shoes - Accessories"));
        shoe.selectShoeToCompare(5);
        shoe.selectShoeToCompare(6);

        ProductComparisonPage comparisonPage = shoe.compare();

        assertTrue(comparisonPage.getTitle().contains("Products Comparison List"));

        shoe = comparisonPage.close();

        assertTrue(shoe.getTitle().contains("Shoes - Accessories"));

        String clear = shoe.clearAll();

        assertTrue(clear.contains("Are you sure you would like to remove all products from your comparison?"));

        String cleared = shoe.getClearedMessage();

        assertTrue(cleared.contains("The comparison list was cleared"));
    }
}

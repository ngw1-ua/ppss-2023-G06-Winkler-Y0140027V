package ejercicio3.conPOyPFact;

import org.openqa.selenium.*;

import java.util.Set;

public class ShoesPage {
    public WebDriver driver;
    public ShoesPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectShoeToCompare(int number) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        switch(number) {
            case 5:
                WebElement wingtipShoe = driver.findElement(By.cssSelector(".item:nth-child(5) .link-compare"));
                jse.executeScript("arguments[0].scrollIntoView();", wingtipShoe);
                wingtipShoe.click();
                break;
            case 6:
                WebElement suedeShoe = driver.findElement(By.cssSelector(".item:nth-child(6) .link-compare"));
                jse.executeScript("arguments[0].scrollIntoView();", suedeShoe);
                suedeShoe.click();
                break;
        }
    }

    public ProductComparisonPage compare(){
        //obtenemos el manejador de la ventana ShoesPage
        String myHandleId = driver.getWindowHandle();
        WebElement buttonCompare = driver.findElement(By.cssSelector(".block-content:nth-child(2) span > span"));
        //pulsamos sobre el botón para hacer la comparación
        buttonCompare.click(); //se abre una nueva ventana
        //el handleID de la nueva ventana se añade al conjunto de manejadores del navegador
        Set<String> setIds = driver.getWindowHandles();
        String[] handleIds = setIds.toArray(new String[setIds.size()]);
        System.out.println("ID 0: "+handleIds[0]); //manejador de la ventana ShoesPage
        System.out.println("ID 1: "+handleIds[1]); //manejador de la venana ProductComparisonPage

        driver.switchTo().window(handleIds[1]);
        ProductComparisonPage comparisonPage = new ProductComparisonPage(this.driver);
        comparisonPage.setMyHandleID(handleIds[1]);
        comparisonPage.setMyHandleIDFrom(handleIds[0]);

        return comparisonPage;
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public String clearAll(){
        driver.findElement(By.linkText("Clear All")).click();
        Alert alert = driver.switchTo().alert();
        String mensaje = alert.getText();
        alert.accept();
        return mensaje;
    }

    public String getClearedMessage(){
        return driver.findElement(By.cssSelector("li:nth-child(1) > span:nth-child(1)")).getText();
    }
}

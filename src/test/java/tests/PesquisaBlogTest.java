package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PesquisaBlogTest {
    private WebDriver driver = new ChromeDriver();

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\giraw\\AppData\\Local\\Programs\\Python\\Python312\\Scripts\\chromedriver.exe");
        driver.get("https://blogdoagi.com.br/");
        driver.manage().window().maximize();
        WebDriver.Timeouts timeouts = driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @Test
    public void testValidarRealizarPesquisaBlogComPalavraChave(){
        String palavraChave = "Agibank";
        driver.findElement(By.id("search-open")).click();
        driver.findElement(By.className("search-field")).sendKeys(palavraChave);
        driver.findElement(By.className("search-submit")).click();

        String resultado = driver.findElement(By.className("archive-title")).getText();
        Assert.assertEquals("Resultados da busca por: "+ palavraChave, resultado);
    }

    @Test
    public void testValidarRealizarPesquisaBlogSemPalavraChave(){
        driver.findElement(By.id("search-open")).click();
        driver.findElement(By.className("search-field")).sendKeys("Vingadores");
        driver.findElement(By.className("search-submit")).click();

        String resultado = driver.findElement(By.className("entry-title")).getText();
        Assert.assertEquals("Nenhum resultado", resultado)
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}

package ingsoftwaretp6;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class TrabajoPractico6 {
    public static void main(String[] args) {

        //Instanciamos un objeto de WebDriver
        WebDriver driver;

        //Declaramos variables en este caso URL
        String baseURL = "https://www.saucedemo.com/index.html";

        //Indicar la ubicacion del archivo chromedriver.exe en la propiedad webdriver.chrome.driver
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");

        //Abrir el navegador Chrome
        driver = new ChromeDriver();


        driver.get("https://www.saucedemo.com/");
        driver.manage().window().setSize(new Dimension(1382, 744));
        driver.findElement(By.cssSelector("*[data-test=\"username\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"username\"]")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("*[data-test=\"password\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.cssSelector(".inventory_item:nth-child(1) .btn_primary")).click();
        driver.findElement(By.cssSelector(".fa-layers-counter")).click();
        driver.findElement(By.linkText("CHECKOUT")).click();
        driver.findElement(By.cssSelector("*[data-test=\"firstName\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"firstName\"]")).sendKeys("Sobrevivientes");
        {
            WebElement element = driver.findElement(By.cssSelector("*[data-test=\"lastName\"]"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).clickAndHold().perform();
        }
        {
            WebElement element = driver.findElement(By.cssSelector("*[data-test=\"lastName\"]"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = driver.findElement(By.cssSelector("*[data-test=\"lastName\"]"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).release().perform();
        }
        driver.findElement(By.cssSelector("*[data-test=\"lastName\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"lastName\"]")).sendKeys("Del Software");
        driver.findElement(By.cssSelector("*[data-test=\"postalCode\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"postalCode\"]")).sendKeys("5500");
        driver.findElement(By.cssSelector(".btn_primary")).click();
        driver.findElement(By.linkText("FINISH")).click();
        assertThat(driver.findElement(By.cssSelector(".complete-header")).getText(), equalTo("THANK YOU FOR YOUR ORDER"));

        //Cerrar navegador
        driver.quit();
    }

}


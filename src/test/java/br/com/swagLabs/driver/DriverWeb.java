package br.com.swagLabs.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverWeb {
    public WebDriver driver;
    public String url = "https://www.saucedemo.com/";

    public WebDriver getCurrentRunningDriver() {
        return driver;
    }

    public void criarDriverWeb(String browser) throws Exception {
        if(browser.equalsIgnoreCase("chrome")){
            criarDriverChrome(url);
        }else if (browser.equalsIgnoreCase("firefox")){
            criarDriverFirefox(url);
        }else if (browser.equalsIgnoreCase("edge")){
            criarDriverEdge(url);
        }else{
            criarDriverEdge(url);
        }
    }

    public void criarDriverChrome(String url){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    public void criarDriverFirefox(String url){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    public void criarDriverEdge(String url) throws Exception {
        WebDriverManager.edgedriver().setup();

        //O Driver abaixo é do MS Edge Chromium e nao da versao anterior dele
        EdgeOptions edgeOptions = new EdgeOptions();
        driver = new EdgeDriver(edgeOptions);
        driver.manage().window().maximize();
        driver.get(url);
    }

    public void fecharDriverWeb(){
        driver.quit();
        System.out.println("Driver encerrado com sucesso!");
    }
}

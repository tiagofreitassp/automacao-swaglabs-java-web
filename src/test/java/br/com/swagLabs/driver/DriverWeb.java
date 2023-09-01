package br.com.swagLabs.driver;

import br.com.swagLabs.utils.InfraUtils;
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
            criarDriverChrome(url);
        }
    }

    public void criarDriverChrome(String url){
        String os = InfraUtils.getOsName();
        System.out.println("Sistema Operacional: "+os);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    public void criarDriverFirefox(String url){
        String os = InfraUtils.getOsName();
        System.out.println("Sistema Operacional: "+os);

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    public void criarDriverEdge(String url) throws Exception {
        String os = InfraUtils.getOsName();
        System.out.println("Sistema Operacional: "+os);

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

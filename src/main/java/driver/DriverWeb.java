package driver;

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
        if(browser.equals("chrome")){
            criarDriverChrome(url);
        }else if (browser.equals("firefox")){
            criarDriverFirefox(url);
        }else if (browser.equals("edge")){
            criarDriverEdge(url);
        }else{
            criarDriverChrome(url);
        }

        driver.manage().window().maximize();
        driver.get(url);
    }

    public void criarDriverChrome(String url){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public void criarDriverFirefox(String url){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    public void criarDriverEdge(String url) throws Exception {
        WebDriverManager.edgedriver().setup();

        //O Driver abaixo é do MS Edge Chromium e nao da versao anterior dele
        EdgeOptions edgeOptions = new EdgeOptions();
        driver = new EdgeDriver(edgeOptions);
    }

    public void fecharDriverWeb(){
        driver.quit();
        System.out.println("Driver encerrado com sucesso!");
    }
}

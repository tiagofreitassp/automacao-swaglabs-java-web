package base;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {
    public Boolean isPresent;
    public WebDriverWait wait;
    private static String nomePasta;
    private File pastaEvidencias;
    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickRadioButton(int posicao) throws InterruptedException {
        sleep(800);
        //Monta uma lista com todos os elementos de nome radio
        List<WebElement> radio = this.driver.findElements(By.name("radio"));
        //Pega a posicao 2 da lista (Equivalente a palavra Boa) e clicar nela
        radio.get(posicao).click();
    }

    public void clickCheckBox(int posicao) throws InterruptedException {
        sleep(800);
        //Monta uma lista com todos os elementos de nome checkbox
        List<WebElement> checkbox = this.driver.findElements(By.cssSelector("input[type='checkbox']"));
        //Pega a posicao 2 da lista (Equivalente a palavra Boa) e clicar nela
        checkbox.get(posicao).click();
    }

    public void clickViewBox(int posicao, By by) throws InterruptedException {
        sleep(800);
        //Monta uma lista com todos os elementos de nome svg
        List<WebElement> svg = this.driver.findElements(by);
        //Pega a posicao 2 da lista (Equivalente a palavra Boa) e clicar nela
        svg.get(posicao).click();
    }

    public void clickWithoutWait(By by) throws InterruptedException {
        waitElement(by);
        selectElement(by);
        this.driver.findElement(by).click();
    }

    public void sendKeys(By by, String texto) throws InterruptedException {
        waitElement(by);
        selectElement(by);
        this.driver.findElement(by).sendKeys(texto);
    }

    public void click(By by) throws InterruptedException {
        waitElement(by);
        selectElement(by);
        this.driver.findElement(by).click();
    }

    public void sleep(long tempo) throws InterruptedException {
        Thread.sleep(tempo);
    }

    public void validateDisplayElement(By by) throws InterruptedException {
        waitElement(by);
        selectElement(by);
    }

    public boolean IsDisplayedReturn(By by) throws Exception {
        sleep(1500);
        try {
            return driver.findElement(by).isDisplayed();
        } catch (NullPointerException | NoSuchElementException | StaleElementReferenceException ex) {
            return false;
        }
    }

    public void moveTolement(By by){
        WebElement elemento = this.driver.findElement(by);
        ((JavascriptExecutor) this.driver).executeScript("arguments[0].scrollIntoView(true);", elemento);
    }

    public void validateText(By by, String texto) throws InterruptedException {
        waitElement(by);
        selectElement(by);
        Assert.assertEquals(texto, getText(by));
    }

    public void waitUntilPageLoadComplete() {
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState=='complete'"));
    }

    public WebDriver waitFrameAndSwitch(By frame) throws InterruptedException {
        waitElement(frame);
        return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
    }

    public void switchToFrame(By by) throws InterruptedException {
        waitElement(by);
        WebElement el = this.driver.findElement(by);
        this.driver.switchTo().frame(el);
    }

    public String getText(By by) throws InterruptedException {
        waitElement(by);
        return this.driver.findElement(by).getText();
    }

    public void waitElement(By by) throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected WebElement waitAndFindElement(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void clear(By by) throws InterruptedException {
        waitElement(by);
        driver.findElement(by).sendKeys(Keys.CONTROL+"a");
        driver.findElement(by).sendKeys(Keys.DELETE);
    }

    public Object executarJS(String cmd, Object... param) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript(cmd, param);
    }

    public void scrollUp() {
        JavascriptExecutor jse1 = (JavascriptExecutor)driver;
        jse1.executeScript("window.scrollBy(0,-200)");
    }

    public void scrollDown() {
        JavascriptExecutor jse2 = (JavascriptExecutor)driver;
        jse2.executeScript("window.scrollBy(0,200)");
    }

    public void scroll(long t) {
        JavascriptExecutor jse2 = (JavascriptExecutor)driver;
        jse2.executeScript("window.scrollBy(0,"+t+")");
    }

    public void scrollDownClick(By by) throws MalformedURLException, InterruptedException {
        isPresent = driver.findElements(by).size() > 0;
        System.out.println("SIZE FORA DO WHILE:" + isPresent);
        while (isPresent == false) {
            JavascriptExecutor jse2 = (JavascriptExecutor)driver;
            jse2.executeScript("window.scrollBy(0,30)");
            System.out.println("SIZE DENTRO DO WHILE:" + isPresent);
            isPresent = driver.findElements(by).size() > 0;
        }
        click(by);
    }

    public void backBrowserPage() {
        driver.navigate().back();
    }

    public void updateBrowserPage() {
        driver.navigate().refresh();
    }

    public void openBrowserPage(String site) {
        driver.navigate().to(site);
    }

    public void openNewTabBrowser() {
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
    }

    public void changeBrowserTab(int aba) {
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(aba));
    }

    public void selectElement(By by){
        WebElement element = driver.findElement(by);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border=arguments[1]", element, "solid 4px red");
    }
}

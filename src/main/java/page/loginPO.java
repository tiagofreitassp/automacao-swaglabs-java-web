package page;

import base.BasePage;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.GeradorPDF;
import variables.LoginVar;

public class loginPO {
    public GeradorPDF geradorPDF;
    public BasePage page;
    private WebDriver driver;

    public LoginVar v = new LoginVar();

    public loginPO(WebDriver driver, Scenario cenario, String nomeTeste) {
        this.driver=driver;
        this.page = new BasePage(this.driver);
        this.geradorPDF = new GeradorPDF(this.driver,cenario, nomeTeste);
    }

    public void fecharPDF(){
        this.geradorPDF.finishPdf();
    }

    public void realizarLogin(String username, String password) throws InterruptedException {
        inserirUsernamePassword(username, password);
        clicarNoBotaoLogin();
        page.validateDisplayElement(By.xpath(v.title_Products));
        geradorPDF.evidenciaElemento("Carregando tela inicial");
    }

    public void inserirUsernamePassword(String username, String password) throws InterruptedException {
        page.sendKeys(By.id(v.input_UserName),username);
        page.sendKeys(By.id(v.input_Password),password);
        geradorPDF.evidenciaElemento("Inserir Username e Password");
    }

    public void clicarNoBotaoLogin() throws InterruptedException {
        page.click(By.id(v.button_Login));
        geradorPDF.evidenciaElemento("Clicar no botão Login");
    }

    public void validarTelaInicial() throws InterruptedException {
        page.validateDisplayElement(By.xpath(v.title_Products));
        page.validateDisplayElement(By.id(v.icon_ShoppingCart));
        page.validateDisplayElement(By.xpath(v.span_Name));

        geradorPDF.evidenciaElemento("Validar tela inicial");
    }

    public void validarMensagemDeErroNoLogin() throws InterruptedException {
        page.validateDisplayElement(By.className("error-message-container"));
        geradorPDF.evidenciaElemento("Validar mensagem de erro no login");
    }
}

package br.com.swagLabs.steps;

import br.com.swagLabs.driver.DriverWeb;
import br.com.swagLabs.pageobject.comprasPO;
import br.com.swagLabs.pageobject.loginPO;
import br.com.swagLabs.utils.GeradorPDF;
import br.com.swagLabs.variables.LoginVar;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;

public class loginSteps extends DriverWeb {
    public LoginVar v = new LoginVar();
    public loginPO loginPO;
    public comprasPO comprasPO;
    public GeradorPDF geradorPDF;

    private Scenario cenario;
    private String nomeDoCenario;

    @Before("@SwagLabs_Login")
    public void setUp(Scenario cenario) throws Exception {
        this.cenario = cenario;
        nomeDoCenario = this.cenario.getName();
        criarDriverWeb(v.edge);

        loginPO = new loginPO(getCurrentRunningDriver(),this.cenario,this.nomeDoCenario);
    }

    @After("@SwagLabs_Login")
    public void tearDown() throws Exception {
        loginPO.fecharPDF();
        fecharDriverWeb();
    }

    @Dado("que efetuei a autenticacao de usuario com {string} e {string}")
    public void queEfetueiAAutenticacaoDeUsuarioComE(String username, String password) throws InterruptedException {
        loginPO.realizarLogin(username,password);
    }

    @Entao("devo visualizar a tela inicial do Swag Labs")
    public void devoVisualizarATelaInicialDoSwagLabs() throws InterruptedException {
        loginPO.validarTelaInicial();
    }

    @Dado("que efetuei a autenticacao com {string} e senha {string}")
    public void queEfetueiAAutenticacaoComESenha(String username, String password) throws InterruptedException {
        loginPO.inserirUsernamePassword(username,password);
        loginPO.clicarNoBotaoLogin();
    }

    @Entao("devo visualizar uma mensagem de erro")
    public void devoVisualizarUmaMensagemDeErro() throws InterruptedException {
        loginPO.clicarNoBotaoLogin();
    }

    @Dado("que efetuei a autenticacao com {string} incorreto e {string}")
    public void queEfetueiAAutenticacaoComIncorretoE(String username, String password) throws InterruptedException {
        loginPO.inserirUsernamePassword(username,password);
        loginPO.clicarNoBotaoLogin();
    }
}

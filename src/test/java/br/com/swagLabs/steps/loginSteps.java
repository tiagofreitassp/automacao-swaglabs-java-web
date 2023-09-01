package br.com.swagLabs.steps;

import br.com.swagLabs.driver.DriverWeb;
import br.com.swagLabs.pageobject.loginPO;
import br.com.swagLabs.utils.GeradorPDF;
import br.com.swagLabs.variables.Variables;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;

public class loginSteps extends DriverWeb {
    public Variables v = new Variables();
    public GeradorPDF geradorPDF;
    public loginPO loginPO;

    private Scenario cenario;
    private String nomeDoCenario;

    @Before("@SwagLabs")
    public void setUp(Scenario cenario) throws Exception {
        this.cenario = cenario;
        nomeDoCenario = this.cenario.getName();
        criarDriverWeb(v.edge,v.link);
    }

    @After("@SwagLabs")
    public void tearDown() throws Exception {
        loginPO.fecharPDF();
        fecharDriverWeb();
    }

    @Dado("que efetuei a autenticacao de usuario com {string} e {string}")
    public void queEfetueiAAutenticacaoDeUsuarioComE(String username, String password) {
        loginPO = new loginPO(getCurrentRunningDriver(),this.cenario,this.nomeDoCenario);
        loginPO.realizarLogin(username,password);
    }
    @Entao("devo visualizar a tela inicial do Swag Labs")
    public void devoVisualizarATelaInicialDoSwagLabs() {
        loginPO.validarTelaInicial();
    }
}

package br.com.swagLabs.steps;

import br.com.swagLabs.driver.DriverWeb;
import br.com.swagLabs.pageobject.comprasPO;
import br.com.swagLabs.variables.LoginVar;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;

public class comprasSteps extends DriverWeb {
    public LoginVar v = new LoginVar();
    public comprasPO comprasPO;

    private Scenario cenario;
    private String nomeDoCenario;

    @Before("@SwagLabs_Compras")
    public void setUp(Scenario cenario) throws Exception {
        this.cenario = cenario;
        nomeDoCenario = this.cenario.getName();
        criarDriverWeb(v.edge);

        comprasPO = new comprasPO(getCurrentRunningDriver(),this.cenario,this.nomeDoCenario);
    }

    @After("@SwagLabs_Compras")
    public void tearDown() throws Exception {
        comprasPO.fecharPDF();
        fecharDriverWeb();
    }

    @Dado("que efetuei a autenticacao de usuario com sucesso")
    public void queEfetueiAAutenticacaoDeUsuarioComSucesso() throws InterruptedException {
        comprasPO.realizarLoginComSucesso();
    }

    @Dado("realizei a compra de um produto")
    public void realizeiACompraDeUmProduto() throws InterruptedException {
        comprasPO.realizarCompraDeProduto();
        comprasPO.RealizarPagamentoDoProduto();
    }

    @Entao("devo finalizar o pagamento")
    public void devoFinalizarOPagamento() throws InterruptedException {
        comprasPO.validarPagamentoComSucesso();
    }
}

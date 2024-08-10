package steps;

import driver.DriverWeb;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import page.comprasPO;
import variables.LoginVar;

public class comprasSteps extends DriverWeb {
    public LoginVar v = new LoginVar();
    public comprasPO comprasPO;

    private Scenario cenario;
    private String nomeDoCenario;

    @Before("@SwagLabs_Compras")
    public void setUp(Scenario cenario) throws Exception {
        this.cenario = cenario;
        nomeDoCenario = this.cenario.getName();
        criarDriverWeb(v.chrome);

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

    @Dado("realizei o pedido de um produto")
    public void realizeiOPedidoDeUmProduto() throws InterruptedException {
        comprasPO.realizeiOPedidoDeUmProduto();
    }

    @Dado("removi um produto do carrinho de compras")
    public void removiUmProdutoDoCarrinhoDeCompras() throws InterruptedException {
        comprasPO.removiUmProdutoDoCarrinhoDeCompras();
    }

    @Entao("nao devo visualizar o produto no carrinho de compras")
    public void naoDevoVisualizarOProdutoNoCarrinhoDeCompras() throws Exception {
        comprasPO.naoDevoVisualizarOProdutoNoCarrinhoDeCompras();
    }

    @Dado("cliquei num produto para ver as informações detalhadas")
    public void cliqueiNumProdutoParaVerAsInformaçõesDetalhadas() throws InterruptedException {
        comprasPO.abrirInformaçõesDoProduto();
    }

    @Entao("devo visualizar informações com imagem, nome e descrição do produto")
    public void devoVisualizarInformaçõesComImagemNomeEDescriçãoDoProduto() throws InterruptedException {
        comprasPO.validarInformacoesDoProduto();
    }

    @Dado("cliquei no menu hamburguer")
    public void cliqueiNoMenuHamburguer() throws InterruptedException {
        comprasPO.clicarNoBotaoMenu();
    }

    @Entao("devo visualizar os items")
    public void devoVisualizarOsItems() throws InterruptedException {
        comprasPO.validarItemsDoMenuHamburguer();
    }
}

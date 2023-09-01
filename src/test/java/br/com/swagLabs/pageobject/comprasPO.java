package br.com.swagLabs.pageobject;

import br.com.swagLabs.base.BasePage;
import br.com.swagLabs.utils.GeradorPDF;
import br.com.swagLabs.variables.LoginVar;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class comprasPO{
    public GeradorPDF geradorPDF;
    public BasePage page;
    private WebDriver driver;

    public LoginVar v = new LoginVar();

    public comprasPO(WebDriver driver, Scenario cenario, String nomeTeste) {
        this.driver=driver;
        this.page = new BasePage(this.driver);
        this.geradorPDF = new GeradorPDF(this.driver,cenario, nomeTeste);
    }

    public void fecharPDF(){
        this.geradorPDF.finishPdf();
    }

    public void realizarLoginComSucesso() throws InterruptedException {
        page.sendKeys(By.id(v.input_UserName),v.username);
        page.sendKeys(By.id(v.input_Password),v.password);

        geradorPDF.evidenciaElemento("Inserir Username e Password");

        page.click(By.id(v.button_Login));

        page.validateDisplayElement(By.xpath(v.title_Products));

        geradorPDF.evidenciaElemento("Carregando tela inicial");
    }

    public void realizarCompraDeProduto() throws InterruptedException {
        abrirInformaçõesDoProduto();
        clicarNoBotaoAddToCart();
        clicarNoIconeCarrinhoDeCompras();
        validarNomeDoProduto();
        validarDescricaoDoProduto();
        validarValorDoProduto();
        clicarNoBotaoCheckout();
    }

    public void abrirInformaçõesDoProduto() throws InterruptedException {
        page.click(By.id("item_4_title_link"));
        geradorPDF.evidenciaElemento("Abrir informações do Produto");
    }

    public void clicarNoBotaoAddToCart() throws InterruptedException {
        page.click(By.id("add-to-cart-sauce-labs-backpack"));
        geradorPDF.evidenciaElemento("Clicar no botão Add to cart");
    }

    public void clicarNoBotaoBackToProducts() throws InterruptedException {
        page.click(By.id("back-to-products"));
        geradorPDF.evidenciaElemento("Clicar no botão Back to products");
    }

    public void clicarNoIconeCarrinhoDeCompras() throws InterruptedException {
        page.click(By.className("shopping_cart_link"));
        geradorPDF.evidenciaElemento("Clicar no Icone Carrinho De Compras");
    }

    public void validarNomeDoProduto() throws InterruptedException {
        page.validateDisplayElement(By.id("item_4_title_link"));
        geradorPDF.evidenciaElemento("Validar nome do Produto");
    }

    public void validarDescricaoDoProduto() throws InterruptedException {
        page.validateDisplayElement(By.className("inventory_item_desc"));
        geradorPDF.evidenciaElemento("Validar descrição do Produto");
    }

    public void validarValorDoProduto() throws InterruptedException {
        page.validateDisplayElement(By.className("inventory_item_price"));
        geradorPDF.evidenciaElemento("Validar valor do Produto");
    }

    public void clicarNoBotaoCheckout() throws InterruptedException {
        page.click(By.id("checkout"));
        geradorPDF.evidenciaElemento("Clicar no botão Checkout");
    }

    public void RealizarPagamentoDoProduto() throws InterruptedException {
        inserirDadosDoComprador();
        clicarNoBotaoContinue();
        validarDadosDoPagamento();
        clicarNoBotaoFinish();
    }

    public void inserirDadosDoComprador() throws InterruptedException {
        page.validateDisplayElement(By.xpath("//span[contains(text(),'Checkout: Your Information')]"));
        page.sendKeys(By.id("first-name"), "Jim");
        page.sendKeys(By.id("last-name"), "Parsons");
        page.sendKeys(By.id("postal-code"), "06434050");
        geradorPDF.evidenciaElemento("Inserir dados do comprador");
    }

    public void clicarNoBotaoContinue() throws InterruptedException {
        page.click(By.id("continue"));
        geradorPDF.evidenciaElemento("Clicar no botão Continue");
    }

    public void validarDadosDoPagamento() throws InterruptedException {
        page.validateDisplayElement(By.xpath("//div[contains(text(),'Payment Information')]"));
        page.validateDisplayElement(By.xpath("//div[contains(text(),'Shipping Information')]"));
        page.validateDisplayElement(By.xpath("//div[contains(text(),'Price Total')]"));
        geradorPDF.evidenciaElemento("Validar dados do pagamento");
    }

    public void clicarNoBotaoFinish() throws InterruptedException {
        page.click(By.id("finish"));
        geradorPDF.evidenciaElemento("Clicar no botão Finish");
    }

    public void validarPagamentoComSucesso() throws InterruptedException {
        page.validateDisplayElement(By.xpath("//h2[contains(text(),'Thank you for your order!')]"));
        page.validateDisplayElement(By.className("complete-text"));
        page.validateDisplayElement(By.id("back-to-products"));
        geradorPDF.evidenciaElemento("Validar pagamento com sucesso");
        page.click(By.id("back-to-products"));
    }
}

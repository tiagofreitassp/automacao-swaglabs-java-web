#language: pt

@Regressivo
@SwagLabs_Compras
Funcionalidade: Realizar compras

  @ct2_01
  Cenario: Realizar compra com sucesso
    Dado que efetuei a autenticacao de usuario com sucesso
    E realizei a compra de um produto
    Entao devo finalizar o pagamento

  @ct2_02
  Cenario: Remover produto do carrinho de compras
    Dado que efetuei a autenticacao de usuario com sucesso
    E realizei o pedido de um produto
    E removi um produto do carrinho de compras
    Entao nao devo visualizar o produto no carrinho de compras

  @ct2_03
  Cenario: Validar detalhes de informações do produto
    Dado que efetuei a autenticacao de usuario com sucesso
    E cliquei num produto para ver as informações detalhadas
    Entao devo visualizar informações com imagem, nome e descrição do produto

  @ct2_04
  Cenario: Validar opções no Menu Hamburguer
    Dado que efetuei a autenticacao de usuario com sucesso
    E cliquei no menu hamburguer
    Entao devo visualizar os items

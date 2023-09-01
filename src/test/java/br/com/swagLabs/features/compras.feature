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
    E realizei a compra de um produto
    Entao devo finalizar o pagamento

#  @ct2_03
#  Cenario: Validar detalhes de informações do produto
#    Dado que efetuei a autenticacao de usuario com sucesso
#    E realizei a compra de um produto
#    Entao devo finalizar o pagamento
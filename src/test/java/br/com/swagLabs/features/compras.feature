#language: pt

@Regressivo
@SwagLabs_Compras
Funcionalidade: Realizar compras

  @ct2_01
  Cenario: Realizar compra com sucesso
    Dado que efetuei a autenticacao de usuario com sucesso
    E realizei a compra de um produto
    Entao devo finalizar o pagamento

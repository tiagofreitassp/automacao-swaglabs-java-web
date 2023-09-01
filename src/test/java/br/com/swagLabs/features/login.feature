#language: pt

@Regressivo
@SwagLabs_Login
Funcionalidade: Realizar autenticação

  @ct1_01
  Esquema do Cenario: Realizar autenticação com sucesso
    Dado que efetuei a autenticacao de usuario com "<username>" e "<password>"
    Entao devo visualizar a tela inicial do Swag Labs

    Exemplos:
      | username      | password     |
      | standard_user | secret_sauce |

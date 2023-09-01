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

  @ct1_02
  Esquema do Cenario: Realizar autenticação com senha incorreta
    Dado que efetuei a autenticacao com "<username>" e senha "<password>"
    Entao devo visualizar uma mensagem de erro

    Exemplos:
      | username      | password   |
      | standard_user | pass_error |

  @ct1_03
  Esquema do Cenario: Realizar autenticação com username incorreto
    Dado que efetuei a autenticacao com "<username>" incorreto e "<password>"
    Entao devo visualizar uma mensagem de erro

    Exemplos:
      | username   | password     |
      | user_error | secret_sauce |
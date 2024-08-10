# automacao-swaglabs-java-web
Projeto de automação web utilizando Java, Selenium, jUnit e WebDriverManager

## Registro das evidencias em formato PDF

Dentro da pasta evidencias

## Relatório de execução

Dentro da pasta evidencias/relatorio_html

## Plano de teste de automação

### Introdução
Este documento descreve o plano de testes de automação para o Swag Labs, um aplicativo web para compras.

### Objetivos
Os objetivos dos testes de automação para os Swag Labs são os seguintes:

- Para garantir que o aplicativo Swag Labs seja estável e confiável.
- Para aumentar a velocidade dos testes e reduzir o esforço manual.
- Para reduzir o custo geral dos testes.
- Para garantir que todos os itens adicionados ao carrinho serão finalizados.
- Para garantir que os preços estão corretos.

### Escopo
O escopo dos testes de automação inclui:

Teste funcional de todos os módulos.
Teste de regressão de todos os módulos.

### Ferramenta de automação
A ferramenta de automação selecionada para este projeto é o Selenium com linguagem de programação Java.

### Ambiente de teste
O ambiente de teste para testes de automação é o seguinte:

- Sistema operacional: Mac OS X 13.5.1
- Navegador: Google Chrome
- Linguagem de programação: Java
- Ambiente de Desenvolvimento Integrado: Intellij Idea

### Casos de teste
Os seguintes casos de teste serão automatizados:

- Faça login no aplicativo
- Ver detalhes do produto
- Comprar produtos

### Dados de teste
Os seguintes dados de teste serão usados para testes de automação:

- Nomes de usuário e senhas

### Execução de teste
O processo de teste de automação seguirá as etapas abaixo:

- Identifique os casos de teste a serem automatizados.
- Desenvolva scripts de automação para casos de teste identificados.
- Execute os scripts de automação.
- Analise os resultados do teste.
- Relate e rastreie defeitos, se houver.

### Riscos e mitigação
Os seguintes riscos são identificados:

- Ambiente: se os testes forem executados em ambiente de produção, pode gerar compras involuntárias, faturamentos indevidos, descasamento de estoque.
- Para mitigar esse risco, a URL base será definida na classe DriverWeb.
- Exposição de dados do usuário: para mitigar esse risco, os dados do usuário serão criados apenas para a automação dos testes.
- Mudanças nos elementos da web: isso pode levar a erros de elemento não encontrado.
- Para mitigar este risco os localizadores web serão organizados num ficheiro diferente de forma dinâmica.

### Conclusão
- O plano de testes de automação descreve a estratégia para testes de automação do aplicativo Swag Labs.
- Este plano garantirá que o aplicativo seja estável e confiável.
- O plano também reduzirá o custo geral dos testes e acelerará o processo de teste.

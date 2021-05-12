# PayGoWeb
Projeto em Java para integração de aplicações PDV com a PayGo/NTK via requisições web.

Link para a documentação da API do ControlPay da PayGo: [https://docs.controlpay.com.br](https://docs.controlpay.com.br)

Este projeto, é compilado e seu jar é utilizado no projeto DBF, como biblioteca ControlPay.
Com isso, o ERP consegue preencher os objetos referentes a requisição que é enviada para PayGo
e fazer o processamento do cartão, consulta, estorno e impressão do comprovante.

Para que essa integração funcione no ERP, é preciso fazer algumas configurações:

- Ativar a propertie processamento.pagamento.controlPay em dbf.propertie
- No caso de homologação, utilizar sandbox.controlpay.com.br e em produção controlpay.ntk.com.br, como valor da propertie controlpay.servidor.
- Plugar um pinpad na máquina que irá processar os cartões, e instalar o programa da PayGo (SetupControlPat)
  > Caso a instalação seja para homologação, ao abrir a tela de configuração do terminal, do SetupControlPat, clicar 3x com o botão direito
  em cima do nome controlpay ou paygo, e digitar DEMO no lugar de PRODUCAO. Isso vai fazer com que a cor dessa telinha mude de azul para rosa.
- Informar CNPJ da loja que irá utilizar o pinpad, ID e Senha do terminal.
  > Para homologação, temos já configurado o terminal 00, e seu id e senha estão no arquivo leia-config-test no ad01 pasta TI/PayGo, mas só será possível configurar
  em um computador, se esse terminal estiver liberado, sem vinculação com outro computador. Caso não esteja liberado, falar no [Slack](https://app.slack.com/client/T01D4GDHP63/D01TGC5D0KX)
  com o Pedro Frayman, que é quem atende a parte de homologação da PayGo e pedir para liberar o terminal 00 de homologação para uma nova ativação.
  > Para produção, se é uma loja que já está utilizando TEF, as informações de cada terminal fica em uma planilha em ad01, pasta TI/PayGo. Caso seja terminal novo
  ou um CNPJ novo, além de solicitar na REDE ou STONE ou outra adquirente, o ponto de captura, precisamos pedir na PayGo para que liberem o terminal necessário e configurem
  o [painel de controle](https://portal.controlpay.com.br/Pages/Login.aspx?ReturnUrl=%2f) deles, através dos meios de comunicação: Tel 3003-9968, Cel 11-99471-1839 (Lucas)
  ou 11-3003-9968 (Suporte).
- No banco de dados, temos que configurar a tabela caixas_lojas, informando os campos:
* TERMINAL_CONTROLPAY

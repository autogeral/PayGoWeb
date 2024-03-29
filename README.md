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
  o [painel de controle](https://portal.controlpay.com.br/Pages/Login.aspx?ReturnUrl=%2f) deles, através dos meios de comunicação: Tel 3003-9968,
  ou 11-3003-9968 (Suporte).
- No banco de dados, temos que configurar a tabela caixas_lojas, onde cada terminal tem sua configuração, mesmo que seja CNPJ iguai, informando os campos:
  1. **TERMINAL_CONTROLPAY** - é o código do terminal que sairá nos detalhes de pagamento, campo Terminal. Esse código conseguimos pegar no [painel de controle](https://portal.controlpay.com.br/Pages/Login.aspx?ReturnUrl=%2f) da PayGo, clicando no nome da empresa no canto superior direito da tela, Terminais, e clicando no terminal desejado. No canto superior esquerdo da tela, vai aparecer o Terminal ID do terminal desejado.
  2. **SENHA_ADMINISTRATIVA_CONTROLPAY** - É a senha utilizada na requisição de estorno/cancelamento de uma venda (cartão). Em homologação e em produção, estamos com a mesma senha, que pode ser encontrada tanto no banco de produção quanto no arquivo leia-config-test que fica no ad01/ti/paygo.
- Outra tabela que precisamos configurar é a lojas:
  1. **CONTROLPAY_KEY** - Chave gerada pela PayGo, que nos autoriza a utilizar o serviço. Tanto de homologação quanto de produção, a PayGo que nos informa qual é para cada CNPJ.
    Para saber sobre a key de um terminal já configurado, pode-se consultar o banco de dados de produção ou verificar no arquivo leia-config-test no ad01/ti/paygo, onde podemos encontrar o de teste também.
  2. **SENHA_CONTROLPAY** - Mesma senha que a administrativa utilizada na tabela caixas_lojas.

Para Homologação, se informamos um adquirente na requisição, podemos ter comportamentos diferentes da PayGo. Por padrão, enviamos como adquirente, a rede, e isso pode ser visto na classe ProcessamentoCartaoDialog no método adquirente(). Temos as seguintes opções e comportamentos para o ambiente de teste.
- **rede** - Só conseguimos testar com valores redondos.
- **DEMO** - Conseguimos testar com valores quebrados
- **ITI** - Carteira digital, simula o PIX e retorna um QRCode.
- Se deixarmos em branco esse valor, na tela do processamento do cartão, vai pedir para que o usuário escolha.

Sendo assim, caso precise fazer testes com valores quebrados no modo de pagamento cartão, será necessário mudar o valor do adquirente para DEMO

# Credenciar um CNPJ do zero (Adquirente)
No caso de credenciamento com a adquirente **REDE**, ligamos no 08007200060 e digita 0 para selecionar a opção de credenciamento.
Informar que já possuímos outras filiais credenciadas e esta será apenas mais uma. Podemos pedir para que copiem a configuração
da matriz, passando o CNPJ da mesma, para a atendente.

Será necessário ter as seguintes informações em mãos, para fazer o credenciamento:

- Nome, CPF e Data de Nascimento de todos os proprietários da Auto Geral, como consta na receita/contrato social.
- Endereço completo da nova unidade.
- Estimativa de faturamento dessa nova unidade.
- Precisará passar um email do responsável para que fique vinculado ao cnpj e que receberá o número lógico em até 24hrs.
- Nome fantasia da nova unidade, que será utilizada no comprovante do cartão a cada transação realizada e também no portal
da REDE para identificarmos a filial pelo nome. Ex: Auto Geral Boituva.
- Conta do banco onde a REDE possa transferir o dinheiro das transações feitas com o TEF. Se for ITAU, igual o que a matriz
ja tem, é uma conta especifica que apenas recebe o dinheiro e repassa para outra do ITAU também.
- Cnae (Código que define o ramo de atividade da empresa)
- Data de abertura do CNPJ que se deseja credenciar.

Depois de fornecer essas informações, a REDE vai passar um código de estabelecimento (é bom salvar) e, em até 24hrs, irá enviar
o número lógico gerado, para o email que foi informado no credenciamento.
Com essas informações em mãos, entrar, entrar no portal ntk da subadquirente (PayGo) e subir o pedido dos terminais.

# Subir pedido CNPJ novo para PayGo
Para subir os pedidos, é necessário ter o login e senha do [portal ntk da PayGo](https://web.ntkonline.com.br/usuario/login).
Ao acessar o portal, seguir os seguintes passos:

- Foi feito um novo documento que encontra-se na pasta Cadastro de nova loja na PayGo

- No menu procurar por Pedido/Fazer Pedido.
- Na tela que se abrir, passo 1, selecionar política.
  > Nossa política até o momento é com a REDE apenas, então selecionar a opção Política REDE.
- Ao prosseguir, no passo 2, selecionar o produto Contro Pay, que é a forma como integramos com a PayGo.
- No passo 3, selecione a quantidade de terminais que se deseja criar para o CNPJ em questão.
  > Para cada terminal, vai ser preciso selecionar mais abaixo, na tela do passo 3 ainda, qual o subproduto
  que no caso é o PayGo Dedicado Cliente Windows, e no atributo, selecionamos a opção PinPad Outros, 
  pois alugamos o pinpad direto da rede e não da controlPay. Só clicar em prosseguir para o passo 4.
- No passo 4, informar o CNPJ da nova unidade, e clicar em carregar. Somente se o CNPJ for muito novo
o sistema deles não irá encontrar nosso CNPJ e ai terá que ser feito o cadastro manualmente, na tela que vai 
aparecer depois do sistema procurar pelo CNPJ e não encontrar. Depois de informar os dados, caso não ache sozinho
continuar com os campos abaixo.
  1. Nome do comprovante e fatura, colocar Auto Geral Piedade, por exemplo. Sempre com o nome da cidade da nova loja.
  2. Endereço de instalação, colocar o endereço da loja nova e no contato, um contato técnico, ou seja, alguém do nosso TI.
  Pode ser apenas nome, email, telefone da loja e um celular que pode ser o do Tuvani. Desmarcar a opção de **usar o mesmo endereço 
  para cobrança.**
  3. Endereço de cobrança, colocar o da Matriz, pois nossa cobranças é unificada. Em contato (cobrança), colocar os dados de alguém do
  financeiro, referente ao contas a pagar. Nome, email (contas@autogeral.com.br), telefone da loja e celular, tem um número que é 
  do financeiro, pegar com a responsável.
  4. Pessoa física com poderes para representar e assinar pela empresa, colocar o mesmo contato técnico da instalação, pois a
  assinatura já foi feita no primeiro contrato e não será necessário novamente para uma Afilial.
**OBS: Contato de conciliação, Url de callback e indicado pela adquirente, deixar em branco** 
- REDE (PGWEB) Número de Filiação, colocar o número de estabelecimento, informado pela rede no ato do credenciamento via telefone.
- Ao passar para o passo 5, apenas confirmar as informações no resumo e clicar em enviar pedido. Dentro de 2 dias é para estar disponível
o acesso para instalação dos terminais no [portal da control pay](https://portal.controlpay.com.br/Pages/Login.aspx?ReturnUrl=%2f). ao acessar com o cnpj da loja nova.
- Ao receber o email de confirmação do pedido ou caso consulte no [portal ntk](https://web.ntkonline.com.br/usuario/login) e veja que o pedido foi aprovado, já será possível acessar
o [portal controlpay](https://portal.controlpay.com.br/Pages/Login.aspx?ReturnUrl=%2f) com o cnpj novo e a senha padrão que utilizamos, e configurar as seguintes informações no mesmo.
  > O email com confirmação chega no endereço que foi passado no ato do pedido, só não sabemos se é ao cadastrar email de contato técnico ou de responsável jurídico.
  Será preciso definir uma senha, ao acessar pela primeira vez através do link que for encaminhado para o email cadastrado na hora que realizamos o pedido.
- As configurações necessárias no [portal controlpay](https://portal.controlpay.com.br/Pages/Login.aspx?ReturnUrl=%2f) são as seguintes:
  1. No menu onde fica o nome da loja, procurar por Terminais, e em cada terminal clicar no editar. Neste passo vamos cadastrar uma impressora
  para isso precisamos saber se a loja vai utilizar bematech ou outra, e qual outra, e assim damos um nome pra ela e salvamos.
  Voltando na tela do terminal, selecionamos no combobox, a impressora cadastrada.
  2. Na mesma tela do terminal, caso aja a opção de configurar Interface, clicar nessa opção e habilitar: **Permitir Venda Parcelada e Aguardar TEF**. 
  3. Ainda na mesma tela, em Configurações de API, selecionar as opções: **Imprimir cupom logista e imprimir cupom cliente**. Repetir isso para os demais terminais a serem utilizados.
  4. Voltando ao menu com nome da loja, mas agora no submenu Integrações / Config., procurar pela aba Integração. Nela temos que informar a url de callback nos 2 campos que aparecem.
  Pegar a url de callback, no servidor onde nossa aplicação fica disponível.
  5. Nesta mesma tela, mas agora na aba Chaves de Integração, caso não aparece uma, clicar em Nova Chave e no campo Nome colocar ou a razão social ou o CNPJ da nova unidade. Ao salvar
  será gerada uma chave hash, que precisamos colocar no campo **CONTROLPAY_KEY** da tabela de lojas, onde a o codigo da loja seja referente a nova unidade.  
  6. Por fim, é preciso entrar em contato com o suporte da PayGo, através dos números 3003-9968 ou whats 3003-6615 e pedir ID, Senha e PCD dos terminais do CNPJ da nova loja.

**OBS: Lembrando que a chave e os IDs, Senhas e PDCs também precisam ser colocados na nossa planilha que está no servidor, onde constam as informações de cada terminal de cada loja.**
  
# Contatos Comercial PayGo
 - Raquel - 011-96634-8902
 - Erika  - 011-98268-2223

# Contato suporte técnico REDE (adquirente)
 - 08007284433 opção 2 (maquininha com fio)

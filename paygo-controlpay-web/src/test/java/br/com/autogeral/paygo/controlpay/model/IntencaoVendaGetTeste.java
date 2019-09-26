package br.com.autogeral.paygo.controlpay.model;

import br.com.autogeral.paygo.controlpay.web.WsHelper;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author kaique.mota
 */
public class IntencaoVendaGetTeste {

    private static final int INTENCAO_VENDA_ID = 73243;
    private static final int FORMA_PAGAMENTO_IDD = 25;
    private static final int FORMA_PAGAMENTO_ID = 25;
    private static final String FFORMA_PAGAMENTO_IDD = "25";
    private static final String TERMINAL_ID = "900";
    private static final String STATUS = "Pendente ,15";
    private static final boolean VENDAS_DIA = true;
    private static final String REFERENCIA = "0168";
    private static final String TOKEN = "442928";
    private static final String DATA_DATA = "17/09/2019 11:50:40.2422";
    private static final String HORA = "11:50:40";
    private static final double VALOR_ORIGINAL_PAGO = 0.0;
    private static final String VALOR_ORIGINAL_PAGO_FORMAT = "0,00";
    private static final String VALOR_ACRESCIMO_FORMAT = "0,00";
    private static final double VALOR_ACRESCIMO = 0;
    private static final String VALOR_DESCONTO_FORMAT = "0,00";
    private static final double VALOR_DESCONTO = 0;
    private static final String VALOR_FINAL_FORMAT = "3,00";
    private static final double VALOR_FINAL = 0;
    private static final String GATE_2ALL_TOKEN = null;
    private static final String URL_PAGAMENTO = null;
    private static final String FORMA_PAGAMENTO_NOME = "TEF";
    private static final String FORMA_PAGAMENTO_MODALIDADE = "Crédito";
    private static final int FLUXO_PAGAMENTO_ID = 21;
    private static final String FLUXO_PAGAMENTO_NOME = "TEF";
    private static final int TERMINAL_TERMINAL = 900;
    private static final String TERMINAL_NOME = "REAL";
    private static final int INTENCAO_VENDA_STATUS_ID = 20;
    private static final String INTENCAO_VENDA_STATUS_NOME = "Cancelado";
    private static final String CLIENTE = null;
    private static final int PEDIDO_ID = 0;
    private static final int QUANTIDADE_PARCELAS = 1;
    private static final String ADQUIRENTE = "";
    private static final int QUANTIDADEEE = 1;
    private static final String QUANTIDADE = "1";
    private static final int ORIGEM = 5;
    private static final int TIPO_PARCELAMENTO = 2;
    private static final int PAGAMENTO_EXTERNO_STATUS_ID = 15;
    private static final String PAGAMENTO_EXTERNO_STATUS_NOME = "Finalizado";
    private static final String DATA_ATUALIZACAO = "25/09/2019 17:55";
    private static final String LATITUDE = "0";
    private static final String LONGITUDE = "0";
    private static final int VENDEDOR_ID = 8149;
    private static final String VENDEDOR_NOME_RAZAO_SOCIAL = "AUTO GERAL AUTOPECAS LTDA";
    private static final String VENDEDOR_SOBRENOME = "AUTO GERAL AUTOPECAS LTDA";
    private static final String VENDEDOR_FOTO_THUMBNAIL = "https://pay2alldemo.azurewebsites.net/WebAPI/ImagensPessoas/_PessoaDefault.png";
    private static final String PARCEIRO = null;
    private static final int PAGAMENTO_EXTERNO = 10;
    private static final int PAGAMENTO_EXTERNO_TIPO = 5;
    private static final String EXTERNO_DATA_ADQUIRENTE = "24/09/2019 15:44";
    private static final String EXTERNO_DATA_ATUALIZACAO = "24/09/2019 18:44";
    private static final String CODIGO_RESPOSTA_EXEC_TRANSAC = "0";
    private static final String CODIGO_RESPOSTA_ADQUIRENTE = "000";
    private static final String EXTERNO_ID_PAGAMENTO = "";
    private static final String EXTERNO_NSU_TID = "572731";
    private static final String EXTERNO__TRN_NSU = "572731";
    private static final String EXTERNO_AUTORIZACAO = "175520";
    private static final String EXTERNO_BANDEIRA = "MASTERCARD CRÉDITO";
    private static final String EXTERNO_ID_CONFIRMACAO = "";
    private static final String EXTERNO_RESPOSTA_ADQUIRENTE = "";
    private static final int EXTERNO_TIPO_PARCELMANTO = 2;
    private static final String EXTERNO_ORDER_LIO = null;
    private static final String OPERADOR = null;
    private static final String DRAW = "";
    private static final String RECORDS_TOTAL = "null";
    private static final String RECORDS_FILTERED = "null";

    @Test
    public void serializeBody() {
        IntencaoVenda intencaoVenda = new IntencaoVenda();
        IntencaoVendaPesquisa intencaoVendaPesquisa = new IntencaoVendaPesquisa(intencaoVenda);
        intencaoVenda.setId(INTENCAO_VENDA_ID);
        intencaoVenda.setTerminalId(TERMINAL_ID);
        intencaoVenda.setReferencia(REFERENCIA);
        FormaPagamento pag = new FormaPagamento();
        pag.setFormaPagamentoId(FFORMA_PAGAMENTO_IDD);
        intencaoVenda.setFormaPagamento(pag);
        intencaoVendaPesquisa.setStatus(STATUS);
        intencaoVendaPesquisa.setVendasDia(VENDAS_DIA);

    }

    @Test
    public void serializeResponseBody() {
        IntencaoVenda iv = new IntencaoVenda();
        iv.setId(INTENCAO_VENDA_ID);
        iv.setReferencia(REFERENCIA);
        iv.setToken(TOKEN);
        iv.setData(HORA);
        iv.setHora(HORA);
        iv.setDataAtualizacao(DATA_ATUALIZACAO);
        iv.setValorOriginal(VALOR_FINAL);
        iv.setValorOriginalFormat(VALOR_FINAL_FORMAT);
        iv.setValorAcrescimo(VALOR_ACRESCIMO);
        iv.setValorAcrescimoFormat(VALOR_ACRESCIMO_FORMAT);
        iv.setValorDesconto(VALOR_DESCONTO);
        iv.setValorDescontoFormat(VALOR_DESCONTO_FORMAT);
        iv.setValorFinal(VALOR_FINAL);
        iv.setValorFinalFormat(VALOR_FINAL_FORMAT);
        iv.setQuantidade(QUANTIDADEEE);
        iv.setUrlPagamento(URL_PAGAMENTO);
        iv.setLatitude(LATITUDE);
        iv.setLongitude(LONGITUDE);
        iv.setQuantidadeParcelas(QUANTIDADE_PARCELAS);
        FormaPagamento fg = new FormaPagamento();
        fg.setId(FORMA_PAGAMENTO_ID);
        fg.setNome(FORMA_PAGAMENTO_NOME);
        fg.setModalidade(FORMA_PAGAMENTO_MODALIDADE);
        FluxoPagamento fp = new FluxoPagamento();
        fp.setId(FLUXO_PAGAMENTO_ID);
        fp.setNome(FLUXO_PAGAMENTO_NOME);
        Terminal terminal = new Terminal();
        terminal.setId(TERMINAL_TERMINAL);
        terminal.setNome(TERMINAL_NOME);
        IntencaoVendaStatus ivs = new IntencaoVendaStatus();
        ivs.setId(INTENCAO_VENDA_STATUS_ID);
        ivs.setNome(INTENCAO_VENDA_STATUS_NOME);
        iv.setCliente(CLIENTE);
        Pedido p = new Pedido();
        p.setId(PEDIDO_ID);
        p.setReferencia(REFERENCIA);
        p.setData(DATA_DATA);
        Vendedor vendedor = new Vendedor();
        vendedor.setId(VENDEDOR_ID);
        vendedor.setNomeRazaoSocial(VENDEDOR_NOME_RAZAO_SOCIAL);
        vendedor.setSobrenomeNomeFantasia(VENDEDOR_SOBRENOME);
        vendedor.setFotoThumbnail(VENDEDOR_FOTO_THUMBNAIL);
        vendedor.setParceiro(PARCEIRO);
        PagamentoExterno pagamentoExterno = new PagamentoExterno();
        pagamentoExterno.setId(PAGAMENTO_EXTERNO);
        pagamentoExterno.setTipo(PAGAMENTO_EXTERNO_TIPO);
        pagamentoExterno.setOrigem(ORIGEM);
        pagamentoExterno.setIdPagamento(EXTERNO_ID_PAGAMENTO);
        pagamentoExterno.setNsuTid(EXTERNO_NSU_TID);
        pagamentoExterno.setTrnNsu(EXTERNO__TRN_NSU);
        pagamentoExterno.setAutorizacao(EXTERNO_AUTORIZACAO);
        pagamentoExterno.setAdquirente(ADQUIRENTE);
        pagamentoExterno.setBandeira(EXTERNO_BANDEIRA);
        pagamentoExterno.setCodigoRespostaAdquirente(CODIGO_RESPOSTA_ADQUIRENTE);
        pagamentoExterno.setCodigoRespostaExecTransac(CODIGO_RESPOSTA_EXEC_TRANSAC);
        pagamentoExterno.setMensagemRespostaAdquirente(EXTERNO_RESPOSTA_ADQUIRENTE);
        pagamentoExterno.setIdConfirmacao(EXTERNO_ID_CONFIRMACAO);
        pagamentoExterno.setDataAdquirente(EXTERNO_DATA_ADQUIRENTE);
        pagamentoExterno.setDataAtualizacao(EXTERNO_DATA_ATUALIZACAO);
        pagamentoExterno.setTipoParcelamento(TIPO_PARCELAMENTO);
        pagamentoExterno.setOrderLIO(EXTERNO_ORDER_LIO);
        PagamentoExternoStatus pes = new PagamentoExternoStatus();
        pes.setId(PAGAMENTO_EXTERNO_STATUS_ID);
        pes.setNome(PAGAMENTO_EXTERNO_STATUS_NOME);
        iv.setOperador(OPERADOR);
        iv.setDraw(DRAW);
        iv.setRecordsTotal(RECORDS_TOTAL);
        iv.setRecordsFiltered(RECORDS_FILTERED);

    }

    @Test
    public void testParse() {
        String toParse = "{\n"
                + "\"intencaoVendaId\": " + INTENCAO_VENDA_ID + ",\n"
                + "    \"formaPagamentoId\": " + FORMA_PAGAMENTO_IDD + ",\n"
                + "    \"terminalId\": \"" + TERMINAL_ID + "\",\n"
                + "    \"status\": \"" + STATUS + "\",\n"
                + "    \"vendasDia\": " + VENDAS_DIA + ",\n"
                + "    \"referencia\": " + REFERENCIA + "\n"
                + "}\n"
                + "\n"
                + "";
        IntencaoVendaPesquisa intencaoVendaPesquisa = WsHelper.unmarshal(toParse, IntencaoVendaPesquisa.class);
        testParseBusca(intencaoVendaPesquisa);
    }

    @Test
    public void testParseData() {
        String toParse = "{\n"
                + "    \"data\": \"25/09/2019 17:56:31.7164\",\n"
                + "    \"intencoesVendas\": [\n"
                + "        {\n"
                + "            \"id\": " + INTENCAO_VENDA_ID + ",\n"
                + "            \"referencia\": \"" + REFERENCIA + "\",\n"
                + "            \"token\": \"" + TOKEN + "\",\n"
                + "            \"data\": \"" + DATA_DATA + "\",\n"
                + "            \"hora\": \"" + HORA + "\",\n"
                + "            \"dataAtualizacao\": \"" + DATA_ATUALIZACAO + "\",\n"
                + "            \"valorOriginal\": " + VALOR_ORIGINAL_PAGO + ",\n"
                + "            \"valorOriginalFormat\": \"" + VALOR_ORIGINAL_PAGO_FORMAT + "\",\n"
                + "            \"valorAcrescimo\": " + VALOR_ACRESCIMO + ",\n"
                + "            \"valorAcrescimoFormat\": \"" + VALOR_ACRESCIMO_FORMAT + "\",\n"
                + "            \"valorDesconto\": " + VALOR_DESCONTO + ",\n"
                + "            \"valorDescontoFormat\": \"" + VALOR_DESCONTO_FORMAT + "\",\n"
                + "            \"valorFinal\": " + VALOR_FINAL + ",\n"
                + "            \"valorFinalFormat\": \"" + VALOR_FINAL_FORMAT + "\",\n"
                + "            \"quantidade\": " + QUANTIDADE + ",\n"
                + "            \"urlPagamento\": " + URL_PAGAMENTO + ",\n"
                + "            \"latitude\": \"" + LATITUDE + "\",\n"
                + "            \"longitude\": \"" + LONGITUDE + "\",\n"
                + "            \"quantidadeParcelas\": " + QUANTIDADE_PARCELAS + ",\n"
                + "            \"formaPagamento\": {\n"
                + "                \"id\": " + FORMA_PAGAMENTO_ID + ",\n"
                + "                \"nome\": \"" + FORMA_PAGAMENTO_NOME + "\",\n"
                + "                \"modalidade\": \"" + FORMA_PAGAMENTO_MODALIDADE + "\",\n"
                + "                \"fluxoPagamento\": {\n"
                + "                    \"id\": " + FLUXO_PAGAMENTO_ID + ",\n"
                + "                    \"nome\": \"" + FLUXO_PAGAMENTO_NOME + "\"\n"
                + "                }\n"
                + "            },\n"
                + "            \"terminal\": {\n"
                + "                \"id\": " + TERMINAL_TERMINAL + ",\n"
                + "                \"nome\": \"" + TERMINAL_NOME + "\"\n"
                + "            },\n"
                + "            \"intencaoVendaStatus\": {\n"
                + "                \"id\": " + INTENCAO_VENDA_STATUS_ID + ",\n"
                + "                \"nome\": \"" + INTENCAO_VENDA_STATUS_NOME + "\"\n"
                + "            },\n"
                + "            \"cliente\": " + CLIENTE + ",\n"
                + "            \"pedido\": {\n"
                + "                \"id\": " + PEDIDO_ID + ",\n"
                + "                \"referencia\": \"" + REFERENCIA + "\",\n"
                + "                \"data\": \"" + DATA_DATA + "\"\n"
                + "            },\n"
                + "            \"vendedor\": {\n"
                + "                \"id\": " + VENDEDOR_ID + ",\n"
                + "                \"nomeRazaoSocial\": \"" + VENDEDOR_NOME_RAZAO_SOCIAL + "\",\n"
                + "                \"sobrenomeNomeFantasia\": \"" + VENDEDOR_SOBRENOME + "\",\n"
                + "                \"fotoThumbnail\": \"" + VENDEDOR_FOTO_THUMBNAIL + "\",\n"
                + "                \"parceiro\": " + PARCEIRO + "\n"
                + "            },\n"
                + "            \"pagamentosExternos\": [\n"
                + "                {\n"
                + "                    \"id\": " + PAGAMENTO_EXTERNO + ",\n"
                + "                    \"tipo\": " + PAGAMENTO_EXTERNO_TIPO + ",\n"
                + "                    \"origem\": " + ORIGEM + ",\n"
                + "                    \"idPagamento\": \"" + EXTERNO_ID_PAGAMENTO + "\",\n"
                + "                    \"nsuTid\": \"" + EXTERNO_NSU_TID + "\",\n"
                + "                    \"trnNsu\": \"" + EXTERNO__TRN_NSU + "\",\n"
                + "                    \"autorizacao\": \"" + EXTERNO_AUTORIZACAO + "\",\n"
                + "                    \"adquirente\": \"" + ADQUIRENTE + "\",\n"
                + "                    \"bandeira\": \"" + EXTERNO_BANDEIRA + "\",\n"
                + "                    \"codigoRespostaAdquirente\": \"" + CODIGO_RESPOSTA_ADQUIRENTE + "\",\n"
                + "                    \"codigoRespostaExecTransac\": \"" + CODIGO_RESPOSTA_EXEC_TRANSAC + "\",\n"
                + "                    \"mensagemRespostaAdquirente\": \"" + EXTERNO_RESPOSTA_ADQUIRENTE + "\",\n"
                + "                    \"idConfirmacao\": \"" + EXTERNO_ID_CONFIRMACAO + "\",\n"
                + "                    \"dataAdquirente\": \"" + EXTERNO_DATA_ADQUIRENTE + "\",\n"
                + "                    \"dataAtualizacao\": \"" + EXTERNO_DATA_ATUALIZACAO + "\",\n"
                + "                    \"respostaAdquirente\": \"PWINFO_DATETIME = 20190925175522\\r\\nPWINFO_AUTLOCREF = 572731\\r\\nPWINFO_OPERATION = 33\\r\\nPWINFO_CURRENCY = 986\\r\\nPWINFO_TOTAMNT = 20000\\r\\nPWINFO_AUTRESPCODE = 000\\r\\nPWINFO_RESULTMSG = APROVADA 123456\\r\\nPWINFO_AUTHSYST = CIELO\\r\\nPWINFO_AUTHCODE = 175520\\r\\nPWINFO_CARDNAME = MASTERCARD CREDITO\\r\\nPWINFO_FINTYPE = 1\\r\\nPWINFO_CNFREQ = 1\\r\\nPWINFO_INSTALLMENTS = \\r\\nPWINFO_CARDTYPE = 1\\r\\nPWINFO_CPEXECTRANSACRESP = 0\\r\\nPWINFO_SERVERPND = 0\\r\\nPWINFO_TRNNSU = 572731\\r\\nPWINFO_RCPTMERCH = \\r              PAYGO BY NTK              \\r\\n\\r\\n              MASTERCARD              \\r\\n           552289******3640           \\r\\n2 VIA-ESTABELECIMENTO       AUT=175520\\r\\n010000244470001/POS=01000237\\r\\nDOC=572731    25/09/19 17:55     ONL-C\\r\\nVENDA A CREDITO\\r\\nVALOR:                   R$     200,00\\r\\n\\r\\n    TRANSACAO AUTORIZADA COM SENHA    \\r\\n           MURILO M TUVANI            \\r\\n   A0000000041010-E421CE670542761A    \\r\\n               CREDITO                \\r\\n\\r\\n----------------------------------------\\r\\n61994 0000000131 PGREF:0000572731\\r\\nNOME FANTASIA: AUTO GERAL AUTOPECAS LTDA\\r\\nCNPJ: 05.437.537/0001-37\\r\\n\\r\\n\\r   *** AMBIENTE DE TESTES - APP02 ***   \\r\\n\\r\\n\\r\\nPWINFO_RCPTCHOLDER = \\r              PAYGO BY NTK              \\r\\n\\r\\n              MASTERCARD              \\r\\n           552289******3640           \\r\\n1 VIA-CLIENTE               AUT=175520\\r\\nDOC=572731    25/09/19 17:55     ONL-C\\r\\nVENDA A CREDITO\\r\\nVALOR:                   R$     200,00\\r\\n\\r\\n\\r\\n----------------------------------------\\r\\n61994 0000000131 PGREF:0000572731\\r\\nNOME FANTASIA: AUTO GERAL AUTOPECAS LTDA\\r\\nCNPJ: 05.437.537/0001-37\\r\\n\\r\\n\\r   *** AMBIENTE DE TESTES - APP02 ***   \\r\\n\\r\\n\\r\\nPWINFO_RCPTCHSHORT =               MASTERCARD              \\r\\n           552289******3640           \\r\\nPOS=01000237   DOC=572731   AUT=175520\\r\\nVALOR:                   R$     200,00\\r\\n\\r\\n\\r\\nPWINFO_RCPTFULL = \\r              PAYGO BY NTK              \\r\\n\\r\\n              MASTERCARD              \\r\\n           552289******3640           \\r\\n                            AUT=175520\\r\\n010000244470001/POS=01000237\\r\\nDOC=572731    25/09/19 17:55     ONL-C\\r\\nVENDA A CREDITO\\r\\nVALOR:                   R$     200,00\\r\\n\\r\\n    TRANSACAO AUTORIZADA COM SENHA    \\r\\n           MURILO M TUVANI            \\r\\n   A0000000041010-E421CE670542761A    \\r\\n               CREDITO                \\r\\n\\r\\n----------------------------------------\\r\\n61994 0000000131 PGREF:0000572731\\r\\nNOME FANTASIA: AUTO GERAL AUTOPECAS LTDA\\r\\nCNPJ: 05.437.537/0001-37\\r\\n\\r\\n\\r   *** AMBIENTE DE TESTES - APP02 ***   \\r\\n\\r\\n\\r\\nPWINFO_UNIQUEID =\",\n"
                + "                    \"comprovanteAdquirente\": \"PAYGO BY NTK               \\r\\n              MASTERCARD               \\r\\n           552289******3640            \\r\\n                            AUT=175520 \\r\\n010000244470001/POS=01000237 \\r\\nDOC=572731    25/09/19 17:55     ONL-C \\r\\nVENDA A CREDITO \\r\\nVALOR:                   R$     200,00 \\r\\n    TRANSACAO AUTORIZADA COM SENHA     \\r\\n           MURILO M TUVANI             \\r\\n   A0000000041010-E421CE670542761A     \\r\\n               CREDITO                 \\r\\n---------------------------------------- \\r\\n61994 0000000131 PGREF:0000572731 \\r\\nNOME FANTASIA: AUTO GERAL AUTOPECAS LTDA \\r\\nCNPJ: 05.437.537/0001-37 \\r\\n   *** AMBIENTE DE TESTES - APP02 ***\",\n"
                + "                    \"tipoParcelamento\": " + EXTERNO_TIPO_PARCELMANTO + ",\n"
                + "                    \"orderLIO\": " + EXTERNO_ORDER_LIO + ",\n"
                + "                    \"pagamentoExternoStatus\": {\n"
                + "                        \"id\": " + PAGAMENTO_EXTERNO_STATUS_ID + ",\n"
                + "                        \"nome\": \"" + PAGAMENTO_EXTERNO_STATUS_NOME + "\"\n"
                + "                    }\n"
                + "                }\n"
                + "            ],\n"
                + "            \"operador\": " + OPERADOR + "\n"
                + "        }\n"
                + "    ],\n"
                + "    \"draw\": \"" + DRAW + "\",\n"
                + "    \"recordsTotal\": " + RECORDS_TOTAL + ",\n"
                + "    \"recordsFiltered\": " + RECORDS_FILTERED + "\n"
                + "}";
        Data d = WsHelper.unmarshal(toParse, Data.class);
        assertNotNull(d);
        List<IntencaoVenda> intencaoVenda = d.getIntencoesVendas();
        testeParseBuscaData(intencaoVenda);
    }

    private void testeParseBuscaData(List<IntencaoVenda> intencaoVenda) {
        assertNotNull(intencaoVenda);
        assertEquals(INTENCAO_VENDA_ID, intencaoVenda.get(0).getId());
        assertEquals(REFERENCIA, intencaoVenda.get(0).getReferencia());
        assertEquals(TOKEN, intencaoVenda.get(0).getToken());
        assertEquals(HORA, intencaoVenda.get(0).getHora());
        assertEquals(DATA_ATUALIZACAO, intencaoVenda.get(0).getDataAtualizacao());
        assertEquals(VALOR_ORIGINAL_PAGO, intencaoVenda.get(0).getValorOriginal(), 0D);
        assertEquals(VALOR_ORIGINAL_PAGO_FORMAT, intencaoVenda.get(0).getValorOriginalFormat());
        assertEquals(VALOR_ACRESCIMO, intencaoVenda.get(0).getValorAcrescimo(), 0D);
        assertEquals(VALOR_ACRESCIMO_FORMAT, intencaoVenda.get(0).getValorAcrescimoFormat());
        assertEquals(VALOR_DESCONTO, intencaoVenda.get(0).getValorDesconto(), 0D);
        assertEquals(VALOR_DESCONTO_FORMAT, intencaoVenda.get(0).getValorDescontoFormat());
        assertEquals(VALOR_FINAL, intencaoVenda.get(0).getValorFinal(), 0D);
        assertEquals(VALOR_FINAL_FORMAT, intencaoVenda.get(0).getValorFinalFormat());
        assertEquals(GATE_2ALL_TOKEN, intencaoVenda.get(0).getGate2allToken());
        assertEquals(QUANTIDADE_PARCELAS, intencaoVenda.get(0).getQuantidadeParcelas());
        assertEquals(URL_PAGAMENTO, intencaoVenda.get(0).getUrlPagamento());
        assertEquals(LONGITUDE, intencaoVenda.get(0).getLongitude());
        assertEquals(LATITUDE, intencaoVenda.get(0).getLatitude());
        FormaPagamento formaPagamento = intencaoVenda.get(0).getFormaPagamento();
        assertEquals(FORMA_PAGAMENTO_ID, formaPagamento.getId());
        assertEquals(FORMA_PAGAMENTO_NOME, formaPagamento.getNome());
        assertEquals(FORMA_PAGAMENTO_MODALIDADE, formaPagamento.getModalidade());
        FluxoPagamento fluxo = intencaoVenda.get(0).getFormaPagamento().getFluxoPagamento();
        assertEquals(FLUXO_PAGAMENTO_ID, fluxo.getId());
        assertEquals(FLUXO_PAGAMENTO_NOME, fluxo.getNome());
        Terminal terminal = intencaoVenda.get(0).getTerminal();
        assertEquals(TERMINAL_TERMINAL, terminal.getId());
        assertEquals(TERMINAL_NOME, terminal.getNome());
        IntencaoVendaStatus ivs = intencaoVenda.get(0).getIntencaoVendaStatus();
        assertEquals(INTENCAO_VENDA_STATUS_ID, ivs.getId());
        assertEquals(INTENCAO_VENDA_STATUS_NOME, ivs.getNome());
        assertEquals(CLIENTE, intencaoVenda.get(0).getCliente());
        assertEquals(PEDIDO_ID, intencaoVenda.get(0).getPedido().getPedidoId());
        assertEquals(REFERENCIA, intencaoVenda.get(0).getPedido().getReferencia());
        assertEquals(DATA_DATA, intencaoVenda.get(0).getPedido().getData());
        assertEquals(VENDEDOR_ID, intencaoVenda.get(0).getVendedor().getId());
        assertEquals(VENDEDOR_NOME_RAZAO_SOCIAL, intencaoVenda.get(0).getVendedor().getNomeRazaoSocial());
        assertEquals(VENDEDOR_SOBRENOME, intencaoVenda.get(0).getVendedor().getSobrenomeNomeFantasia());
        assertEquals(VENDEDOR_FOTO_THUMBNAIL, intencaoVenda.get(0).getVendedor().getFotoThumbnail());
        assertEquals(PARCEIRO, intencaoVenda.get(0).getVendedor().getParceiro());
        PagamentoExterno pagExt = intencaoVenda.get(0).getPagamentosExternos().get(0);
        assertEquals(PAGAMENTO_EXTERNO, pagExt.getId());
        assertEquals(PAGAMENTO_EXTERNO_TIPO, pagExt.getTipo());
        assertEquals(ORIGEM, pagExt.getOrigem());
        assertEquals(EXTERNO_ID_PAGAMENTO, pagExt.getIdPagamento());
        assertEquals(EXTERNO_NSU_TID, pagExt.getNsuTid());
        assertEquals(EXTERNO__TRN_NSU, pagExt.getTrnNsu());
        assertEquals(ADQUIRENTE, pagExt.getAdquirente());
        assertEquals(EXTERNO_BANDEIRA, pagExt.getBandeira());
        assertEquals(CODIGO_RESPOSTA_ADQUIRENTE, pagExt.getCodigoRespostaAdquirente());
        assertEquals(CODIGO_RESPOSTA_EXEC_TRANSAC, pagExt.getCodigoRespostaExecTransac());
        assertEquals(EXTERNO_RESPOSTA_ADQUIRENTE, pagExt.getMensagemRespostaAdquirente());
        assertEquals(EXTERNO_ID_CONFIRMACAO, pagExt.getIdConfirmacao());
        assertEquals(EXTERNO_DATA_ADQUIRENTE, pagExt.getDataAdquirente());
        assertEquals(EXTERNO_DATA_ATUALIZACAO, pagExt.getDataAtualizacao());
        assertEquals(TIPO_PARCELAMENTO, pagExt.getTipoParcelamento());
        PagamentoExternoStatus externoStatus = intencaoVenda.get(0).getPagamentosExternos().get(0).getPagamentoExternoStatus();
        assertEquals(PAGAMENTO_EXTERNO_STATUS_ID, externoStatus.getId());
        assertEquals(PAGAMENTO_EXTERNO_STATUS_NOME, externoStatus.getNome());
    }

    private void testParseBusca(IntencaoVendaPesquisa intencaoVendaPesquisa) {
        IntencaoVenda intencao = new IntencaoVenda();
        assertEquals(INTENCAO_VENDA_ID, intencaoVendaPesquisa.getIntencaoVendaId());
        assertEquals(FORMA_PAGAMENTO_IDD, intencaoVendaPesquisa.getFormaPagamentoId());
        assertEquals(TERMINAL_ID, intencaoVendaPesquisa.getTerminalId());
        assertEquals(STATUS, intencaoVendaPesquisa.getStatus());
        assertEquals(VENDAS_DIA, intencaoVendaPesquisa.isVendasDia());
        assertEquals(REFERENCIA, intencaoVendaPesquisa.getReferencia());

    }
}

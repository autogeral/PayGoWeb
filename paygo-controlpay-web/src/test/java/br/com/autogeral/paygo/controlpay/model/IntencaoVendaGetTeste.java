package br.com.autogeral.paygo.controlpay.model;

import br.com.autogeral.paygo.controlpay.web.WsHelper;
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
    private static final String FORMA_PAGAMENTO_ID = "25";
    private static final String TERMINAL_ID = "900";
    private static final String STATUS = "Pendente ,15";
    private static final boolean VENDAS_DIA = true;
    private static final String REFERENCIA = null;

    @Test
    public void serialize() {
        IntencaoVenda intencaoVenda = new IntencaoVenda();
        IntencaoVendaPesquisa intencaoVendaPesquisa = new IntencaoVendaPesquisa(intencaoVenda);
        intencaoVenda.setId(INTENCAO_VENDA_ID);
        intencaoVenda.setTerminalId(TERMINAL_ID);
        intencaoVenda.setReferencia(REFERENCIA);
        FormaPagamento pag = new FormaPagamento();
        pag.setFormaPagamentoId(FORMA_PAGAMENTO_ID);
        intencaoVenda.setFormaPagamento(pag);
        intencaoVendaPesquisa.setStatus(STATUS);
        intencaoVendaPesquisa.setVendasDia(VENDAS_DIA);

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
                + "            \"id\": 73379,\n"
                + "            \"referencia\": \"REF 1234\",\n"
                + "            \"token\": \"881232\",\n"
                + "            \"data\": \"25/09/2019 17:54\",\n"
                + "            \"hora\": \"17:54:49\",\n"
                + "            \"dataAtualizacao\": \"25/09/2019 17:55\",\n"
                + "            \"valorOriginal\": 200.0000,\n"
                + "            \"valorOriginalFormat\": \"200,00\",\n"
                + "            \"valorAcrescimo\": 0.0000,\n"
                + "            \"valorAcrescimoFormat\": \"0,00\",\n"
                + "            \"valorDesconto\": 0.0000,\n"
                + "            \"valorDescontoFormat\": \"0,00\",\n"
                + "            \"valorFinal\": 200.0000,\n"
                + "            \"valorFinalFormat\": \"200,00\",\n"
                + "            \"quantidade\": 1,\n"
                + "            \"urlPagamento\": null,\n"
                + "            \"latitude\": \"0\",\n"
                + "            \"longitude\": \"0\",\n"
                + "            \"quantidadeParcelas\": 1,\n"
                + "            \"formaPagamento\": {\n"
                + "                \"id\": 21,\n"
                + "                \"nome\": \"TEF\",\n"
                + "                \"modalidade\": \"Crédito\",\n"
                + "                \"fluxoPagamento\": {\n"
                + "                    \"id\": 21,\n"
                + "                    \"nome\": \"TEF\"\n"
                + "                }\n"
                + "            },\n"
                + "            \"terminal\": {\n"
                + "                \"id\": 900,\n"
                + "                \"nome\": \"Terminal 03\"\n"
                + "            },\n"
                + "            \"intencaoVendaStatus\": {\n"
                + "                \"id\": 10,\n"
                + "                \"nome\": \"Creditado\"\n"
                + "            },\n"
                + "            \"cliente\": null,\n"
                + "            \"pedido\": {\n"
                + "                \"id\": 2474,\n"
                + "                \"referencia\": \"A05\",\n"
                + "                \"data\": \"2019-09-25T17:54:21\"\n"
                + "            },\n"
                + "            \"vendedor\": {\n"
                + "                \"id\": 8149,\n"
                + "                \"nomeRazaoSocial\": \"AUTO GERAL AUTOPECAS LTDA\",\n"
                + "                \"sobrenomeNomeFantasia\": \"AUTO GERAL AUTOPECAS LTDA\",\n"
                + "                \"fotoThumbnail\": \"https://pay2alldemo.azurewebsites.net/WebAPI/ImagensPessoas/_PessoaDefault.png\",\n"
                + "                \"parceiro\": null\n"
                + "            },\n"
                + "            \"pagamentosExternos\": [\n"
                + "                {\n"
                + "                    \"id\": 55637,\n"
                + "                    \"tipo\": 5,\n"
                + "                    \"origem\": 10,\n"
                + "                    \"idPagamento\": \"\",\n"
                + "                    \"nsuTid\": \"572731\",\n"
                + "                    \"trnNsu\": \"572731\",\n"
                + "                    \"autorizacao\": \"175520\",\n"
                + "                    \"adquirente\": \"CIELO\",\n"
                + "                    \"bandeira\": \"MASTERCARD CREDITO\",\n"
                + "                    \"codigoRespostaAdquirente\": \"000\",\n"
                + "                    \"codigoRespostaExecTransac\": \"0\",\n"
                + "                    \"mensagemRespostaAdquirente\": \"APROVADA 123456\",\n"
                + "                    \"idConfirmacao\": \"\",\n"
                + "                    \"dataAdquirente\": \"25/09/2019 17:55\",\n"
                + "                    \"dataAtualizacao\": \"25/09/2019 20:55\",\n"
                + "                    \"respostaAdquirente\": \"PWINFO_DATETIME = 20190925175522\\r\\nPWINFO_AUTLOCREF = 572731\\r\\nPWINFO_OPERATION = 33\\r\\nPWINFO_CURRENCY = 986\\r\\nPWINFO_TOTAMNT = 20000\\r\\nPWINFO_AUTRESPCODE = 000\\r\\nPWINFO_RESULTMSG = APROVADA 123456\\r\\nPWINFO_AUTHSYST = CIELO\\r\\nPWINFO_AUTHCODE = 175520\\r\\nPWINFO_CARDNAME = MASTERCARD CREDITO\\r\\nPWINFO_FINTYPE = 1\\r\\nPWINFO_CNFREQ = 1\\r\\nPWINFO_INSTALLMENTS = \\r\\nPWINFO_CARDTYPE = 1\\r\\nPWINFO_CPEXECTRANSACRESP = 0\\r\\nPWINFO_SERVERPND = 0\\r\\nPWINFO_TRNNSU = 572731\\r\\nPWINFO_RCPTMERCH = \\r              PAYGO BY NTK              \\r\\n\\r\\n              MASTERCARD              \\r\\n           552289******3640           \\r\\n2 VIA-ESTABELECIMENTO       AUT=175520\\r\\n010000244470001/POS=01000237\\r\\nDOC=572731    25/09/19 17:55     ONL-C\\r\\nVENDA A CREDITO\\r\\nVALOR:                   R$     200,00\\r\\n\\r\\n    TRANSACAO AUTORIZADA COM SENHA    \\r\\n           MURILO M TUVANI            \\r\\n   A0000000041010-E421CE670542761A    \\r\\n               CREDITO                \\r\\n\\r\\n----------------------------------------\\r\\n61994 0000000131 PGREF:0000572731\\r\\nNOME FANTASIA: AUTO GERAL AUTOPECAS LTDA\\r\\nCNPJ: 05.437.537/0001-37\\r\\n\\r\\n\\r   *** AMBIENTE DE TESTES - APP02 ***   \\r\\n\\r\\n\\r\\nPWINFO_RCPTCHOLDER = \\r              PAYGO BY NTK              \\r\\n\\r\\n              MASTERCARD              \\r\\n           552289******3640           \\r\\n1 VIA-CLIENTE               AUT=175520\\r\\nDOC=572731    25/09/19 17:55     ONL-C\\r\\nVENDA A CREDITO\\r\\nVALOR:                   R$     200,00\\r\\n\\r\\n\\r\\n----------------------------------------\\r\\n61994 0000000131 PGREF:0000572731\\r\\nNOME FANTASIA: AUTO GERAL AUTOPECAS LTDA\\r\\nCNPJ: 05.437.537/0001-37\\r\\n\\r\\n\\r   *** AMBIENTE DE TESTES - APP02 ***   \\r\\n\\r\\n\\r\\nPWINFO_RCPTCHSHORT =               MASTERCARD              \\r\\n           552289******3640           \\r\\nPOS=01000237   DOC=572731   AUT=175520\\r\\nVALOR:                   R$     200,00\\r\\n\\r\\n\\r\\nPWINFO_RCPTFULL = \\r              PAYGO BY NTK              \\r\\n\\r\\n              MASTERCARD              \\r\\n           552289******3640           \\r\\n                            AUT=175520\\r\\n010000244470001/POS=01000237\\r\\nDOC=572731    25/09/19 17:55     ONL-C\\r\\nVENDA A CREDITO\\r\\nVALOR:                   R$     200,00\\r\\n\\r\\n    TRANSACAO AUTORIZADA COM SENHA    \\r\\n           MURILO M TUVANI            \\r\\n   A0000000041010-E421CE670542761A    \\r\\n               CREDITO                \\r\\n\\r\\n----------------------------------------\\r\\n61994 0000000131 PGREF:0000572731\\r\\nNOME FANTASIA: AUTO GERAL AUTOPECAS LTDA\\r\\nCNPJ: 05.437.537/0001-37\\r\\n\\r\\n\\r   *** AMBIENTE DE TESTES - APP02 ***   \\r\\n\\r\\n\\r\\nPWINFO_UNIQUEID =\",\n"
                + "                    \"comprovanteAdquirente\": \"PAYGO BY NTK               \\r\\n              MASTERCARD               \\r\\n           552289******3640            \\r\\n                            AUT=175520 \\r\\n010000244470001/POS=01000237 \\r\\nDOC=572731    25/09/19 17:55     ONL-C \\r\\nVENDA A CREDITO \\r\\nVALOR:                   R$     200,00 \\r\\n    TRANSACAO AUTORIZADA COM SENHA     \\r\\n           MURILO M TUVANI             \\r\\n   A0000000041010-E421CE670542761A     \\r\\n               CREDITO                 \\r\\n---------------------------------------- \\r\\n61994 0000000131 PGREF:0000572731 \\r\\nNOME FANTASIA: AUTO GERAL AUTOPECAS LTDA \\r\\nCNPJ: 05.437.537/0001-37 \\r\\n   *** AMBIENTE DE TESTES - APP02 ***\",\n"
                + "                    \"tipoParcelamento\": 2,\n"
                + "                    \"orderLIO\": null,\n"
                + "                    \"pagamentoExternoStatus\": {\n"
                + "                        \"id\": 15,\n"
                + "                        \"nome\": \"Finalizado\"\n"
                + "                    }\n"
                + "                }\n"
                + "            ],\n"
                + "            \"operador\": null\n"
                + "        }\n"
                + "    ],\n"
                + "    \"draw\": \"\",\n"
                + "    \"recordsTotal\": null,\n"
                + "    \"recordsFiltered\": null\n"
                + "}";
    }

    private void testeParseBuscaData(IntencaoVenda intencaoVenda) {

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

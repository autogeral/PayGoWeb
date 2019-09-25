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
public class PedidoGetByFiltrosTeste {

    private static final String PESSOASID = "1";
    private static final int PEDIDO_ID = 2439;
    private static final String REFERENCIA = "REF 151";
    private static final String OBSERVACAO = null;
    private static final String DATA_DATA = "17/09/2019 11:50:40.2422";
    private static final String HORA = "11:50:40";
    private static final double VALOR = 500.00;
    private static final String VALOR_FORMAT = "900";
    private static final double VALOR_ABERTO = 300.00;
    private static final String VALOR_ABERTO_FORMAT = "300";
    private static final double VALOR_ORIGINAL_PAGO = 300.00;
    private static final String VALOR_ORIGINAL_PAGO_FORMAT = "0,00";
    private static final double VALOR_ORIGINAL_EM_PAGAMENTO = 0.0;
    private static final String VALOR_ORIGINAL_EM_PAGAMENTO_FORMAT = "0,00";
    private static final String TIPO = "Interno";
    private static final int QUANTIDADE = 1;
    private static final int QUANTIDADE_TRANSACOES = 0;
    private static final int PEDIDO_STATUS_ID = 5;
    private static final String PEDIDO_STATUS_NOME = "Pago";
    private static final int PESSOA_ID = 8149;
    private static final String NOME_RAZAO_SOCIAL = "AUTO GERAL AUTOPECAS LTDA";
    private static final String SOBRENOME_NOME_FANTASIA = "AUTO GERAL AUTOPECAS LTDA";
    private static final String CPF_CNPJ_FORMAT = "05.437.537/0001-37";
    private static final String EMAIL = "kaique.motta@autogeral.com.br";
    private static final String PRODUTO_DESCRICAO = "AAAA";
    private static final int PRODUTO_ID = 2075;
    private static final String PRODUTO_NOME = "Produto genérico";
    private static final String PRODUTO_EXIBE_NOME = "Produto ge";
    private static final int PRODUTO_QUANTIDADE = 1;
    private static final String PRODUTO_VALOR = "300.0";
    private static final String PRODUTO_VALOR_FORMAT = "300.00";
    private static final String ID_PRODUTO = "2075";
    private static final String FOTO_THUMBNAIL = "https://pay2alldemo.azurewebsites.net/WebAPI/ImagensProdutos/_ProdutoDefault.png";
    private static final int ID_INTENCAO_VENDA = 23456;
    private static final String TOKEN = "442928";
    private static final String VALOR_ACRESCIMO_FORMAT = "0,00";
    private static final double VALOR_ACRESCIMO = 0;
    private static final String VALOR_DESCONTO_FORMAT = "0,00";
    private static final double VALOR_DESCONTO = 0;
    private static final String VALOR_FINAL_FORMAT = "3,00";
    private static final double VALOR_FINAL = 0;
    private static final String GATE_2ALL_TOKEN = null;
    private static final String URL_PAGAMENTO = null;
    private static final int FORMA_PAGAMENTO_ID = 21;
    private static final String FORMA_PAGAMENTO_NOME = "TEF";
    private static final String FORMA_PAGAMENTO_MODALIDADE = "Crédito";
    private static final int FLUXO_PAGAMENTO_ID = 21;
    private static final String FLUXO_PAGAMENTO_NOME = "TEF";
    private static final int INTENCAO_VENDA_STATUS_ID = 20;
    private static final String INTENCAO_VENDA_STATUS_NOME = "Cancelado";
    private static final String CLIENTE = null;
    private static final int ITEM_PRODUTO_ID = 30747;
    private static final int QUANTIDADE_PARCELAS = 1;
    private static final int QUANTIDADEE_VENDA = 1;
    private static final int ORIGEM = 5;
    private static final int TIPO_PARCELAMENTO = 2;
    private static final int PAGAMENTO_EXTERNO_STATUS_ID = 15;
    private static final String PAGAMENTO_EXTERNO_STATUS_NOME = "Finalizado";
    private static final int PAGAMENTO_EXTERNO = 10;
    private static final int PAGAMENTO_EXTERNO_TIPO = 5;
    private static final String PAGAMENTO_EXTERNO_DATA_ADQUIRENTE = "24/09/2019 15:44";
    private static final String PAGAMENTO_EXTERNO_DATA_ATUALIZACAO = "24/09/2019 18:44";
    private static final String COMPROVANTE_ADQUIRENTE ="PAYGO BY NTK               \\r\\n              MASTERCARD               \\r\\n           552289******3640            \\r\\n                            AUT=154430 \\r\\n010000244470001/POS=01000237 \\r\\nDOC=572723    24/09/19 15:44     ONL-C \\r\\nVENDA A CREDITO \\r\\nVALOR:                   R$     200,00 \\r\\n    TRANSACAO AUTORIZADA COM SENHA     \\r\\n           MURILO M TUVANI             \\r\\n   A0000000041010-0DCEBE2B792A6D38     \\r\\n               CREDITO                 \\r\\n---------------------------------------- \\r\\n61994 0000000131 PGREF:0000572723 \\r\\nNOME FANTASIA: AUTO GERAL AUTOPECAS LTDA \\r\\nCNPJ: 05.437.537/0001-37 \\r\\n   *** AMBIENTE DE TESTES - APP02 ***";
    private static final String CODIGO_RESPOSTA_EXEC_TRANSAC ="0";
    private static final String CODIGO_RESPOSTA_ADQUIRENTE = "000";

    @Test
    public void testSerializable() {
        Pedido pedido = new Pedido();

        pedido.setPessoaIds(PESSOASID);

        String result = WsHelper.marshal(PESSOASID);
        System.out.println(result);
    }

    @Test
    public void testParse() {
        String toParse = " {\n"
                + "   \"pessoaIds\": \""+PESSOASID+"\"\n"
                + "}";
        
        Pedido ped = WsHelper.unmarshal(toParse, Pedido.class);
         testPedido(ped);
    }

    @Test
    public void testParseData() {
        String toParse = "{\n"
                + "    \"data\": \"" + DATA_DATA + "\",\n"
                + "    \"pedidos\": [\n"
                + "        {\n"
                + "            \"id\": " + PEDIDO_ID + ",\n"
                + "            \"referencia\": \"" + REFERENCIA + "\",\n"
                + "            \"obs\": " + OBSERVACAO + ",\n"
                + "            \"data\": \"" + DATA_DATA + "\",\n"
                + "            \"hora\": \"" + HORA + "\",\n"
                + "            \"valor\":" + VALOR + ",\n"
                + "            \"valorFormat\": \"" + VALOR_FORMAT + "\",\n"
                + "            \"valorAberto\": " + VALOR_ABERTO + ",\n"
                + "            \"valorAbertoFormat\": \"" + VALOR_ABERTO_FORMAT + "\",\n"
                + "            \"valorOriginalPago\": " + VALOR_ORIGINAL_PAGO + ",\n"
                + "            \"valorOriginalPagoFormat\": \"" + VALOR_ORIGINAL_PAGO_FORMAT + "\",\n"
                + "            \"valorOriginalEmPagamento\": " + VALOR_ORIGINAL_EM_PAGAMENTO + ",\n"
                + "            \"valorOriginalEmPagamentoFormat\": \"" + VALOR_ORIGINAL_EM_PAGAMENTO_FORMAT + "\",\n"
                + "            \"tipo\": \"" + TIPO + "\",\n"
                + "            \"quantidade\": " + QUANTIDADE + ",\n"
                + "            \"quantidadeTransacoes\": " + QUANTIDADE_TRANSACOES + ",\n"
                + "            \"pedidoStatus\": {\n"
                + "                \"id\": " + PEDIDO_STATUS_ID + ",\n"
                + "                \"nome\": \"" + PEDIDO_STATUS_NOME + "\"\n"
                + "            },\n"
                + "            \"pessoa\": {\n"
                + "                \"id\": " + PESSOA_ID + ",\n"
                + "                \"nomeRazaoSocial\": \"" + NOME_RAZAO_SOCIAL + "\",\n"
                + "                \"sobrenomeNomeFantasia\": \"" + SOBRENOME_NOME_FANTASIA + "\",\n"
                + "                \"cpfCnpjFormat\": \"" + CPF_CNPJ_FORMAT + "\",\n"
                + "                \"email\": \"" + EMAIL + "\"\n"
                + "            },\n"
                + "            \"produtos\": [\n"
                + "                {\n"
                + "                    \"itemProdutoId\": " + ID_PRODUTO + ",\n"
                + "                    \"id\": " + PRODUTO_ID + ",\n"
                + "                    \"nome\": \"" + PRODUTO_NOME + "\",\n"
                + "                    \"descricao\": \"" + PRODUTO_DESCRICAO + "\",\n"
                + "                    \"nomeExibe\": \"" + PRODUTO_EXIBE_NOME + "\",\n"
                + "                    \"quantidade\": " + PRODUTO_QUANTIDADE + ",\n"
                + "                    \"valor\": " + PRODUTO_VALOR + ",\n"
                + "                    \"valorFormat\": \"" + PRODUTO_VALOR_FORMAT + "\",\n"
                + "                    \"fotoThumbnail\": \"" + FOTO_THUMBNAIL + "\"\n"
                + "                }\n"
                + "            ],\n"
                + "            \"notaFiscal\": null,\n"
                + "            \"intencoesVenda\": [\n"
                + "                {\n"
                + "                    \"id\": " + ID_INTENCAO_VENDA + ",\n"
                + "                    \"token\": \"" + TOKEN + "\",\n"
                + "                    \"data\": \"" + DATA_DATA + "\",\n"
                + "                    \"hora\": \"" + HORA + "\",\n"
                + "                    \"quantidade\": " + QUANTIDADE + ",\n"
                + "                    \"valorOriginal\": " + VALOR_ORIGINAL_PAGO + ",\n"
                + "                    \"valorOriginalFormat\": \"" + VALOR_ORIGINAL_PAGO_FORMAT + "\",\n"
                + "                    \"valorAcrescimo\": " + VALOR_ACRESCIMO + ",\n"
                + "                    \"valorAcrescimoFormat\": \"" + VALOR_ACRESCIMO_FORMAT + "\",\n"
                + "                    \"valorDesconto\": " + VALOR_DESCONTO + ",\n"
                + "                    \"valorDescontoFormat\": \"" + VALOR_DESCONTO_FORMAT + "\",\n"
                + "                    \"valorFinal\": " + VALOR_FINAL + ",\n"
                + "                    \"valorFinalFormat\": \"" + VALOR_FINAL_FORMAT + "\",\n"
                + "                    \"gate2allToken\": " + GATE_2ALL_TOKEN + ",\n"
                + "                    \"quantidadeParcelas\": " + QUANTIDADE_PARCELAS + ",\n"
                + "                    \"urlPagamento\": " + URL_PAGAMENTO + ",\n"
                + "                    \"formaPagamento\": {\n"
                + "                        \"id\": " + FORMA_PAGAMENTO_ID + ",\n"
                + "                        \"nome\": \"" + FORMA_PAGAMENTO_NOME + "\",\n"
                + "                        \"modalidade\": \"" + FORMA_PAGAMENTO_MODALIDADE + "\",\n"
                + "                        \"fluxoPagamento\": {\n"
                + "                            \"id\": " + FLUXO_PAGAMENTO_ID + ",\n"
                + "                            \"nome\": \"" + FLUXO_PAGAMENTO_NOME + "\"\n"
                + "                        }\n"
                + "                    },\n"
                + "                    \"intencaoVendaStatus\": {\n"
                + "                        \"id\": " + INTENCAO_VENDA_STATUS_ID + ",\n"
                + "                        \"nome\": \"" + INTENCAO_VENDA_STATUS_NOME + "\"\n"
                + "                    },\n"
                + "                    \"pedido\": {\n"
                + "                        \"id\": " + PEDIDO_ID + ",\n"
                + "                        \"referencia\": \"" + REFERENCIA + "\",\n"
                + "                        \"pedidoStatus\": {\n"
                + "                            \"id\": " + PEDIDO_STATUS_ID + ",\n"
                + "                            \"nome\": \"" + PEDIDO_STATUS_NOME + "\"\n"
                + "                        }\n"
                + "                    },\n"
                + "                    \"cliente\": " + CLIENTE + ",\n"
                + "                    \"produtos\": [\n"
                + "                        {\n"
                + "                            \"itemProdutoId\": " + ITEM_PRODUTO_ID + ",\n"
                + "                            \"id\": " + PRODUTO_ID + ",\n"
                + "                            \"nome\": \"" + PRODUTO_NOME + "\",\n"
                + "                            \"quantidade\": " + PRODUTO_QUANTIDADE + ",\n"
                + "                            \"valor\": \"" + PRODUTO_VALOR + "\"\n"
                + "                        }\n"
                + "                    ],\n"
                + "                    \"pagamentosExternos\": [\n"
                + "                        {\n"
                + "                            \"id\": " + PAGAMENTO_EXTERNO + ",\n"
                + "                            \"tipo\": "+ PAGAMENTO_EXTERNO_TIPO + ",\n"
                + "                            \"dataAdquirente\": \""+PAGAMENTO_EXTERNO_DATA_ADQUIRENTE+"\",\n"
                + "                            \"dataAtualizacao\": \""+PAGAMENTO_EXTERNO_DATA_ATUALIZACAO+"\",\n"
                + "                            \"origem\": "+ORIGEM+",\n"
                + "                            \"tipoParcelamento\": "+TIPO_PARCELAMENTO+",\n"
                + "                            \"comprovanteAdquirente\": \""+COMPROVANTE_ADQUIRENTE+"\",\n"
                + "                            \"codigoRespostaExecTransac\": \""+CODIGO_RESPOSTA_EXEC_TRANSAC+"\",\n"
                + "                            \"codigoRespostaAdquirente\": \""+CODIGO_RESPOSTA_ADQUIRENTE+"\",\n"
                + "                            \"pagamentoExternoStatus\": {\n"
                + "                                \"id\": "+PAGAMENTO_EXTERNO_STATUS_ID+",\n"
                + "                                \"nome\": \""+PAGAMENTO_EXTERNO_STATUS_NOME+"\"\n"
                + "                            }\n"
                + "                        }\n"
                + "                    ]\n"
                + "                }\n"
                + "            ]}]}";
        Data d = WsHelper.unmarshal(toParse, Data.class);
        assertNotNull(d);
        List<Pedido> pedidos = d.getPedidos();
        testPedidosParse(pedidos);
    }

    private void testPedidosParse(List<Pedido> p) {
        Data d = new Data();
        Pedido ped = p.get(0);
        assertNotNull(ped);
        assertEquals(PEDIDO_ID, ped.getId());
        assertEquals(REFERENCIA, ped.getReferencia());
        assertEquals(OBSERVACAO, ped.getObs());
        assertEquals(DATA_DATA, ped.getData());
        assertEquals(HORA, ped.getHora());
        assertEquals(VALOR, ped.getValor(), 0D);
        assertEquals(VALOR_FORMAT, ped.getValorFormat());
        assertEquals(VALOR_ABERTO, ped.getValorAberto(), 0D);
        assertEquals(VALOR_ABERTO_FORMAT, ped.getValorAbertoFormat());
        assertEquals(VALOR_ORIGINAL_PAGO, ped.getValorOriginalPago(), 0D);
        assertEquals(VALOR_ORIGINAL_PAGO_FORMAT, ped.getValorOriginalPagoFormat());
        assertEquals(VALOR_ORIGINAL_EM_PAGAMENTO, ped.getValorOriginalEmPagamento(), 0.00);
        assertEquals(VALOR_ORIGINAL_EM_PAGAMENTO_FORMAT, ped.getValorOriginalEmPagamentoFormat());
        assertEquals(TIPO, ped.getTipo());
        assertEquals(QUANTIDADE, ped.getQuantidade());
        assertEquals(QUANTIDADE_TRANSACOES, ped.getQuantidadeTransacoes());
        assertEquals(PEDIDO_STATUS_ID, ped.getPedidoStatus().getId());
        assertEquals(PEDIDO_STATUS_NOME, ped.getPedidoStatus().getNome());
        assertEquals(PESSOA_ID, ped.getPessoa().getId());
        assertEquals(NOME_RAZAO_SOCIAL, ped.getPessoa().getNomeRazaoSocial());
        assertEquals(SOBRENOME_NOME_FANTASIA, ped.getPessoa().getSobrenomeNomeFantasia());
        assertEquals(CPF_CNPJ_FORMAT, ped.getPessoa().getCpfCnpjFormat());
        assertEquals(EMAIL, ped.getPessoa().getEmail());
        assertNotNull(ped.getProdutos());
        Produto produto = ped.getProdutos().get(0);
        assertEquals(PRODUTO_ID, ped.getProdutos().get(0).getId());
        assertEquals(PRODUTO_NOME, ped.getProdutos().get(0).getNome());
        assertEquals(PRODUTO_EXIBE_NOME, produto.getNomeExibe());
        assertEquals(PRODUTO_QUANTIDADE, produto.getQuantidade());
        assertEquals(PRODUTO_VALOR, produto.getValor());
        assertEquals(PRODUTO_VALOR_FORMAT, produto.getValorFormat());
        assertEquals(FOTO_THUMBNAIL, produto.getFotoThumbnail());
        IntencaoVenda iv = ped.getIntencoesVenda().get(0);
        assertEquals(ID_INTENCAO_VENDA, iv.getId());
        assertEquals(TOKEN, iv.getToken());
        assertEquals(DATA_DATA, iv.getData());
        assertEquals(HORA, iv.getHora());
        assertEquals(QUANTIDADEE_VENDA, iv.getQuantidade());
        assertEquals(VALOR_ORIGINAL_PAGO, iv.getValorOriginal(), 0D);
        assertEquals(VALOR_ORIGINAL_PAGO_FORMAT, iv.getValorOriginalFormat());
        assertEquals(VALOR_ACRESCIMO, iv.getValorAcrescimo(), 0D);
        assertEquals(VALOR_ACRESCIMO_FORMAT, iv.getValorAcrescimoFormat());
        assertEquals(VALOR_DESCONTO, iv.getValorDesconto(), 0D);
        assertEquals(VALOR_DESCONTO_FORMAT, iv.getValorDescontoFormat());
        assertEquals(VALOR_FINAL, iv.getValorFinal(), 0D);
        assertEquals(VALOR_FINAL_FORMAT, iv.getValorFinalFormat());
        assertEquals(GATE_2ALL_TOKEN, iv.getGate2allToken());
        assertEquals(QUANTIDADE_PARCELAS, iv.getQuantidadeParcelas());
        assertEquals(URL_PAGAMENTO, iv.getUrlPagamento());
        FormaPagamento formaPagamento = iv.getFormaPagamento();
        assertEquals(FORMA_PAGAMENTO_ID, formaPagamento.getId());
        assertEquals(FORMA_PAGAMENTO_NOME, formaPagamento.getNome());
        assertEquals(FORMA_PAGAMENTO_MODALIDADE, formaPagamento.getModalidade());
        FluxoPagamento fluxo = iv.getFormaPagamento().getFluxoPagamento();
        assertEquals(FLUXO_PAGAMENTO_ID, fluxo.getId());
        assertEquals(FLUXO_PAGAMENTO_NOME, fluxo.getNome());
        IntencaoVendaStatus ivs = ped.getIntencoesVenda().get(0).getIntencaoVendaStatus();
        assertEquals(INTENCAO_VENDA_STATUS_ID, ivs.getId());
        assertEquals(INTENCAO_VENDA_STATUS_NOME, ivs.getNome());
        assertEquals(PEDIDO_ID, ped.getId());
        assertEquals(REFERENCIA, ped.getReferencia());
        PedidoStatus pedStatus = ped.getPedidoStatus();
        assertEquals(PEDIDO_STATUS_ID, pedStatus.getId());
        assertEquals(PEDIDO_STATUS_NOME, pedStatus.getNome());
        assertEquals(CLIENTE, ped.getCliente());
        assertEquals(PRODUTO_ID, ped.getProdutos().get(0).getId());
        assertEquals(PRODUTO_NOME, ped.getProdutos().get(0).getNome());
        assertEquals(PRODUTO_EXIBE_NOME, produto.getNomeExibe());
        assertEquals(PRODUTO_QUANTIDADE, produto.getQuantidade());
        assertEquals(PRODUTO_VALOR, produto.getValor());
        PagamentoExterno pagExt =  ped.getIntencoesVenda().get(0).getPagamentosExternos().get(0);
        assertEquals(PAGAMENTO_EXTERNO, pagExt.getId());
        assertEquals(PAGAMENTO_EXTERNO_TIPO, pagExt.getTipo());
        assertEquals(PAGAMENTO_EXTERNO_DATA_ADQUIRENTE, pagExt.getDataAdquirente());
        assertEquals(PAGAMENTO_EXTERNO_DATA_ATUALIZACAO, pagExt.getDataAtualizacao());
       // assertEquals(COMPROVANTE_ADQUIRENTE, pagExt.getComprovanteAdquirente());
        assertEquals(TIPO_PARCELAMENTO, pagExt.getTipoParcelamento());
        assertEquals(CODIGO_RESPOSTA_ADQUIRENTE, pagExt.getCodigoRespostaAdquirente());
        assertEquals(CODIGO_RESPOSTA_EXEC_TRANSAC, pagExt.getCodigoRespostaExecTransac());
        PagamentoExternoStatus externoStatus = ped.getIntencoesVenda().get(0).getPagamentosExternos().get(0).getPagamentoExternoStatus();
        assertEquals(PAGAMENTO_EXTERNO_STATUS_ID, externoStatus.getId());
        assertEquals(PAGAMENTO_EXTERNO_STATUS_NOME, externoStatus.getNome());
    }

    private void testPedido(Pedido pedido) {

        assertNotNull(pedido);
        assertEquals(PESSOASID, pedido.getPessoaIds());
    }

}
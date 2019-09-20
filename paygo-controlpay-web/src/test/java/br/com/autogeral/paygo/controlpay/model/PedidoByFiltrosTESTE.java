/*
 * The MIT License
 *
 * Copyright 2019 kaique.mota.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package br.com.autogeral.paygo.controlpay.model;

import br.com.autogeral.paygo.controlpay.web.WsHelper;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author kaique.mota
 */
public class PedidoByFiltrosTESTE {

    private final static String PESSOA_IDS = "12";
    private static final int PEDIDO_ID = 2447;
    private static final String REFERENCIA = "157";
    private static final String OBSERVACAO = null;
    private static final String DATA_DATA = "17/09/2019 13:48:41.0000";
    private static final String HORA = "13:48:41";
    private static final double VALOR = 150.0000;
    private static final int PESSOA_VENDEDOR_ID = 1;
    private static final String VALOR_FORMAT = "150,00";
    private static final double VALOR_ABERTO = 0.0000;
    private static final String VALOR_ABERTO_FORMAT = "0,00";
    private static final double VALOR_ORIGINAL_PAGO = 150.0000;
    private static final String VALOR_ORIGINAL_PAGO_FORMAT = "150,00";
    private static final double VALOR_ORIGINAL_EM_PAGAMENTO = 0.0;
    private static final String VALOR_ORIGINAL_EM_PAGAMENTO_FORMAT = "0,00";
    private static final String TIPO = "Interno";
    private static final int QUANTIDADE = 1;
    private static final int QUANTIDADE_TRANSACOES = 1;

    @Test
    public void test_serialize() {

        Pedido p = new Pedido();

        p.setPessoaIds(PESSOA_IDS);
        p.setId(PEDIDO_ID);
        p.setReferencia(REFERENCIA);
        p.setObs(OBSERVACAO);
        p.setData(DATA_DATA);
        p.setHora(HORA);
        p.setValor(VALOR);
        p.setPessoaVendedorId(PESSOA_VENDEDOR_ID);
        p.setValorFormat(VALOR_FORMAT);
        p.setValor(VALOR_ABERTO);
        p.setValorAbertoFormat(VALOR_ABERTO_FORMAT);
        p.setValorOriginalPago(VALOR_ORIGINAL_PAGO);
        p.setValorOriginalPagoFormat(VALOR_ORIGINAL_PAGO_FORMAT);
        p.setValorOriginalEmPagamento(VALOR_ORIGINAL_EM_PAGAMENTO);
        p.setValorOriginalEmPagamentoFormat(VALOR_ORIGINAL_EM_PAGAMENTO_FORMAT);
        p.setTipo(TIPO);
        p.setQuantidade(QUANTIDADE);
        p.setQuantidadeTransacoes(QUANTIDADE_TRANSACOES);
    }

    @Test
    public void test_parse() {
        String toParse = " {\n"
                + "   \"pessoaIds\": \"12\"\n"
                + "}\n"
                + "";

        Pedido p = WsHelper.unmarshal(toParse, Pedido.class);
        testFiltros(p);
    }

    @Test
    public void test_parse_Data() {

        String toParse = "{\"data\":\"20/09/2019 13:52:45.7000\",\n"
                + "\"pedidos\":[{\"id\":2455,\n"
                + "\"referencia\":\"02\",\n"
                + "\"obs\":null,\n"
                + "\"data\":\"19/09/2019 14:03:43.0000\",\n"
                + "\"hora\":\"14:03:43\",\n"
                + "\"valor\":200.0000,\n"
                + "\"valorFormat\":\"200,\n"
                + "00\",\n"
                + "\"valorAberto\":200.0000,\n"
                + "\"valorAbertoFormat\":\"200,\n"
                + "00\",\n"
                + "\"valorOriginalPago\":0.0,\n"
                + "\"valorOriginalPagoFormat\":\"0,\n"
                + "00\",\n"
                + "\"valorOriginalEmPagamento\":0.0,\n"
                + "\"valorOriginalEmPagamentoFormat\":\"0,\n"
                + "00\",\n"
                + "\"tipo\":\"Interno\",\n"
                + "\"quantidade\":1,\n"
                + "\"quantidadeTransacoes\":0,\n"
                + "\"pedidoStatus\":{\"id\":5,\n"
                + "\"nome\":\"Aberto\"},\n"
                + "\"pessoa\":{\"id\":8149,\n"
                + "\"nomeRazaoSocial\":\"AUTO GERAL AUTOPECAS LTDA\",\n"
                + "\"sobrenomeNomeFantasia\":\"AUTO GERAL AUTOPECAS LTDA\",\n"
                + "\"cpfCnpjFormat\":\"05.437.537/0001-37\",\n"
                + "\"email\":\"kaique.motta@autogeral.com.br\"},\n"
                + "\"produtos\":[{\"itemProdutoId\":30955,\n"
                + "\"id\":2075,\n"
                + "\"nome\":\"Produto genérico\",\n"
                + "\"descricao\":\"Produto genérico\",\n"
                + "\"nomeExibe\":\"Produto ge\",\n"
                + "\"quantidade\":1,\n"
                + "\"valor\":200.0000,\n"
                + "\"valorFormat\":\"200,\n"
                + "00\",\n"
                + "\"fotoThumbnail\":\"https://pay2alldemo.azurewebsites.net/WebAPI/ImagensProdutos/_ProdutoDefault.png\"}],\n"
                + "\"notaFiscal\":null,\n"
                + "\"intencoesVenda\":[],\n"
                + "\"pedidoFormasPagamento\":[{\"id\":849,\n"
                + "\"quantidadeMaximaParcelas\":1,\n"
                + "\"adquirentePadrao\":\"\",\n"
                + "\"formaPagamento\":{\"id\":21,\n"
                + "\"nome\":\"TEF\",\n"
                + "\"modalidade\":\"Crédito\",\n"
                + "\"permiteParcelamento\":true,\n"
                + "\"solicitaObs\":false,\n"
                + "\"quantidadeMaximaParcelas\":12,\n"
                + "\"isentoDeTarifa\":true,\n"
                + "\"fluxoPagamento\":{\"id\":21,\n"
                + "\"nome\":\"TEF\"}}}]},\n"
                + "{\"id\":2454,\n"
                + "\"referencia\":\"01\",\n"
                + "\"obs\":null,\n"
                + "\"data\":\"19/09/2019 14:02:30.0000\",\n"
                + "\"hora\":\"14:02:30\",\n"
                + "\"valor\":200.0000,\n"
                + "\"valorFormat\":\"200,\n"
                + "00\",\n"
                + "\"valorAberto\":200.0000,\n"
                + "\"valorAbertoFormat\":\"200,\n"
                + "00\",\n"
                + "\"valorOriginalPago\":0.0,\n"
                + "\"valorOriginalPagoFormat\":\"0,\n"
                + "00\",\n"
                + "\"valorOriginalEmPagamento\":0.0,\n"
                + "\"valorOriginalEmPagamentoFormat\":\"0,\n"
                + "00\",\n"
                + "\"tipo\":\"Interno\",\n"
                + "\"quantidade\":1,\n"
                + "\"quantidadeTransacoes\":0,\n"
                + "\"pedidoStatus\":{\"id\":5,\n"
                + "\"nome\":\"Aberto\"},\n"
                + "\"pessoa\":{\"id\":8149,\n"
                + "\"nomeRazaoSocial\":\"AUTO GERAL AUTOPECAS LTDA\",\n"
                + "\"sobrenomeNomeFantasia\":\"AUTO GERAL AUTOPECAS LTDA\",\n"
                + "\"cpfCnpjFormat\":\"05.437.537/0001-37\",\n"
                + "\"email\":\"kaique.motta@autogeral.com.br\"},\n"
                + "\"produtos\":[{\"itemProdutoId\":30954,\n"
                + "\"id\":2075,\n"
                + "\"nome\":\"Produto genérico\",\n"
                + "\"descricao\":\"Produto genérico\",\n"
                + "\"nomeExibe\":\"Produto ge\",\n"
                + "\"quantidade\":1,\n"
                + "\"valor\":200.0000,\n"
                + "\"valorFormat\":\"200,\n"
                + "00\",\n"
                + "\"fotoThumbnail\":\"https://pay2alldemo.azurewebsites.net/WebAPI/ImagensProdutos/_ProdutoDefault.png\"}],\n"
                + "\"notaFiscal\":null,\n"
                + "\"intencoesVenda\":[],\n"
                + "\"pedidoFormasPagamento\":[{\"id\":848,\n"
                + "\"quantidadeMaximaParcelas\":1,\n"
                + "\"adquirentePadrao\":\"\",\n"
                + "\"formaPagamento\":{\"id\":21,\n"
                + "\"nome\":\"TEF\",\n"
                + "\"modalidade\":\"Crédito\",\n"
                + "\"permiteParcelamento\":true,\n"
                + "\"solicitaObs\":false,\n"
                + "\"quantidadeMaximaParcelas\":12,\n"
                + "\"isentoDeTarifa\":true,\n"
                + "\"fluxoPagamento\":{\"id\":21,\n"
                + "\"nome\":\"TEF\"}}}]},\n"
                + "{\"id\":2453,\n"
                + "\"referencia\":\"REF 123456\",\n"
                + "\"obs\":null,\n"
                + "\"data\":\"19/09/2019 13:56:24.0000\",\n"
                + "\"hora\":\"13:56:24\",\n"
                + "\"valor\":10.0000,\n"
                + "\"valorFormat\":\"10,\n"
                + "00\",\n"
                + "\"valorAberto\":10.0000,\n"
                + "\"valorAbertoFormat\":\"10,\n"
                + "00\",\n"
                + "\"valorOriginalPago\":0.0,\n"
                + "\"valorOriginalPagoFormat\":\"0,\n"
                + "00\",\n"
                + "\"valorOriginalEmPagamento\":0.0,\n"
                + "\"valorOriginalEmPagamentoFormat\":\"0,\n"
                + "00\",\n"
                + "\"tipo\":\"Interno\",\n"
                + "\"quantidade\":1,\n"
                + "\"quantidadeTransacoes\":0,\n"
                + "\"pedidoStatus\":{\"id\":5,\n"
                + "\"nome\":\"Aberto\"},\n"
                + "\"pessoa\":{\"id\":8149,\n"
                + "\"nomeRazaoSocial\":\"AUTO GERAL AUTOPECAS LTDA\",\n"
                + "\"sobrenomeNomeFantasia\":\"AUTO GERAL AUTOPECAS LTDA\",\n"
                + "\"cpfCnpjFormat\":\"05.437.537/0001-37\",\n"
                + "\"email\":\"kaique.motta@autogeral.com.br\"},\n"
                + "\"produtos\":[{\"itemProdutoId\":30953,\n"
                + "\"id\":2075,\n"
                + "\"nome\":\"Produto genérico\",\n"
                + "\"descricao\":\"Produto genérico\",\n"
                + "\"nomeExibe\":\"Produto ge\",\n"
                + "\"quantidade\":1,\n"
                + "\"valor\":10.0000,\n"
                + "\"valorFormat\":\"10,\n"
                + "00\",\n"
                + "\"fotoThumbnail\":\"https://pay2alldemo.azurewebsites.net/WebAPI/ImagensProdutos/_ProdutoDefault.png\"}],\n"
                + "\"notaFiscal\":null,\n"
                + "\"intencoesVenda\":[],\n"
                + "\"pedidoFormasPagamento\":[{\"id\":847,\n"
                + "\"quantidadeMaximaParcelas\":1,\n"
                + "\"adquirentePadrao\":\"\",\n"
                + "\"formaPagamento\":{\"id\":21,\n"
                + "\"nome\":\"TEF\",\n"
                + "\"modalidade\":\"Crédito\",\n"
                + "\"permiteParcelamento\":true,\n"
                + "\"solicitaObs\":false,\n"
                + "\"quantidadeMaximaParcelas\":12,\n"
                + "\"isentoDeTarifa\":true,\n"
                + "\"fluxoPagamento\":{\"id\":21,\n"
                + "\"nome\":\"TEF\"}}}]},\n"
                + "{\"id\":2452,\n"
                + "\"referencia\":\"REF 123456\",\n"
                + "\"obs\":null,\n"
                + "\"data\":\"19/09/2019 12:12:56.0000\",\n"
                + "\"hora\":\"12:12:56\",\n"
                + "\"valor\":10.0000,\n"
                + "\"valorFormat\":\"10,\n"
                + "00\",\n"
                + "\"valorAberto\":0.0000,\n"
                + "\"valorAbertoFormat\":\"0,\n"
                + "00\",\n"
                + "\"valorOriginalPago\":10.0000,\n"
                + "\"valorOriginalPagoFormat\":\"10,\n"
                + "00\",\n"
                + "\"valorOriginalEmPagamento\":0.0,\n"
                + "\"valorOriginalEmPagamentoFormat\":\"0,\n"
                + "00\",\n"
                + "\"tipo\":\"Interno\",\n"
                + "\"quantidade\":1,\n"
                + "\"quantidadeTransacoes\":2,\n"
                + "\"pedidoStatus\":{\"id\":10,\n"
                + "\"nome\":\"Pago\"},\n"
                + "\"pessoa\":{\"id\":8149,\n"
                + "\"nomeRazaoSocial\":\"AUTO GERAL AUTOPECAS LTDA\",\n"
                + "\"sobrenomeNomeFantasia\":\"AUTO GERAL AUTOPECAS LTDA\",\n"
                + "\"cpfCnpjFormat\":\"05.437.537/0001-37\",\n"
                + "\"email\":\"kaique.motta@autogeral.com.br\"},\n"
                + "\"produtos\":[{\"itemProdutoId\":30952,\n"
                + "\"id\":2075,\n"
                + "\"nome\":\"Produto genérico\",\n"
                + "\"descricao\":\"Produto genérico\",\n"
                + "\"nomeExibe\":\"Produto ge\",\n"
                + "\"quantidade\":1,\n"
                + "\"valor\":10.0000,\n"
                + "\"valorFormat\":\"10,\n"
                + "00\",\n"
                + "\"fotoThumbnail\":\"https://pay2alldemo.azurewebsites.net/WebAPI/ImagensProdutos/_ProdutoDefault.png\"}],\n"
                + "\"notaFiscal\":null,\n"
                + "\"intencoesVenda\":[{\"id\":73251,\n"
                + "\"token\":\"446636\",\n"
                + "\"data\":\"19/09/2019 15:13\",\n"
                + "\"hora\":\"15:13:16\",\n"
                + "\"quantidade\":0,\n"
                + "\"valorOriginal\":5.0000,\n"
                + "\"valorOriginalFormat\":\"5,\n"
                + "00\",\n"
                + "\"valorAcrescimo\":0.0000,\n"
                + "\"valorAcrescimoFormat\":\"0,\n"
                + "00\",\n"
                + "\"valorDesconto\":0.0000,\n"
                + "\"valorDescontoFormat\":\"0,\n"
                + "00\",\n"
                + "\"valorFinal\":5.0000,\n"
                + "\"valorFinalFormat\":\"5,\n"
                + "00\",\n"
                + "\"gate2allToken\":null,\n"
                + "\"quantidadeParcelas\":1,\n"
                + "\"urlPagamento\":null,\n"
                + "\"formaPagamento\":{\"id\":21,\n"
                + "\"nome\":\"TEF\",\n"
                + "\"modalidade\":\"Crédito\",\n"
                + "\"fluxoPagamento\":{\"id\":21,\n"
                + "\"nome\":\"TEF\"}},\n"
                + "\"intencaoVendaStatus\":{\"id\":25,\n"
                + "\"nome\":\"Pagamento Recusado\"},\n"
                + "\"pedido\":{\"id\":2452,\n"
                + "\"referencia\":\"REF 123456\",\n"
                + "\"pedidoStatus\":{\"id\":10,\n"
                + "\"nome\":\"Pago\"}},\n"
                + "\"cliente\":null,\n"
                + "\"produtos\":[],\n"
                + "\"pagamentosExternos\":[{\"id\":55483,\n"
                + "\"tipo\":5,\n"
                + "\"dataAdquirente\":null,\n"
                + "\"dataAtualizacao\":\"19/09/2019 18:13\",\n"
                + "\"origem\":10,\n"
                + "\"tipoParcelamento\":2,\n"
                + "\"comprovanteAdquirente\":null,\n"
                + "\"codigoRespostaExecTransac\":\"-2497\",\n"
                + "\"codigoRespostaAdquirente\":\"-2497\",\n"
                + "\"pagamentoExternoStatus\":{\"id\":15,\n"
                + "\"nome\":\"Finalizado\"}}]},\n"
                + "{\"id\":73252,\n"
                + "\"token\":\"844160\",\n"
                + "\"data\":\"19/09/2019 15:13\",\n"
                + "\"hora\":\"15:13:54\",\n"
                + "\"quantidade\":1,\n"
                + "\"valorOriginal\":10.0000,\n"
                + "\"valorOriginalFormat\":\"10,\n"
                + "00\",\n"
                + "\"valorAcrescimo\":0.0000,\n"
                + "\"valorAcrescimoFormat\":\"0,\n"
                + "00\",\n"
                + "\"valorDesconto\":0.0000,\n"
                + "\"valorDescontoFormat\":\"0,\n"
                + "00\",\n"
                + "\"valorFinal\":10.0000,\n"
                + "\"valorFinalFormat\":\"10,\n"
                + "00\",\n"
                + "\"gate2allToken\":null,\n"
                + "\"quantidadeParcelas\":1,\n"
                + "\"urlPagamento\":null,\n"
                + "\"formaPagamento\":{\"id\":21,\n"
                + "\"nome\":\"TEF\",\n"
                + "\"modalidade\":\"Crédito\",\n"
                + "\"fluxoPagamento\":{\"id\":21,\n"
                + "\"nome\":\"TEF\"}},\n"
                + "\"intencaoVendaStatus\":{\"id\":10,\n"
                + "\"nome\":\"Creditado\"},\n"
                + "\"pedido\":{\"id\":2452,\n"
                + "\"referencia\":\"REF 123456\",\n"
                + "\"pedidoStatus\":{\"id\":10,\n"
                + "\"nome\":\"Pago\"}},\n"
                + "\"cliente\":null,\n"
                + "\"produtos\":[{\"itemProdutoId\":30952,\n"
                + "\"id\":2075,\n"
                + "\"nome\":\"Produto genérico\",\n"
                + "\"quantidade\":1,\n"
                + "\"valor\":\"10,\n"
                + "00\"}],\n"
                + "\"pagamentosExternos\":[{\"id\":55484,\n"
                + "\"tipo\":5,\n"
                + "\"dataAdquirente\":\"19/09/2019 15:14\",\n"
                + "\"dataAtualizacao\":\"19/09/2019 18:14\",\n"
                + "\"origem\":10,\n"
                + "\"tipoParcelamento\":2,\n"
                + "\"comprovanteAdquirente\":\"PAYGO BY NTK               \\r\\n              MASTERCARD               \\r\\n           552289******3640            \\r\\n                            AUT=151415 \\r\\n010000244470001/POS=01000237 \\r\\nDOC=572689    19/09/19 15:14     ONL-C \\r\\nVENDA A CREDITO \\r\\nVALOR:                   R$      10,\n"
                + "00 \\r\\n    TRANSACAO AUTORIZADA COM SENHA     \\r\\n           MURILO M TUVANI             \\r\\n   A0000000041010-C3773EC88DD44635     \\r\\n               CREDITO                 \\r\\n---------------------------------------- \\r\\n61994 0000000131 PGREF:0000572689 \\r\\nNOME FANTASIA: AUTO GERAL AUTOPECAS LTDA \\r\\nCNPJ: 05.437.537/0001-37 \\r\\n   *** AMBIENTE DE TESTES - APP02 ***\",\n"
                + "\"codigoRespostaExecTransac\":\"0\",\n"
                + "\"codigoRespostaAdquirente\":\"000\",\n"
                + "\"pagamentoExternoStatus\":{\"id\":15,\n"
                + "\"nome\":\"Finalizado\"}}]}],\n"
                + "\"pedidoFormasPagamento\":[{\"id\":846,\n"
                + "\"quantidadeMaximaParcelas\":1,\n"
                + "\"adquirentePadrao\":\"\",\n"
                + "\"formaPagamento\":{\"id\":21,\n"
                + "\"nome\":\"TEF\",\n"
                + "\"modalidade\":\"Crédito\",\n"
                + "\"permiteParcelamento\":true,\n"
                + "\"solicitaObs\":false,\n"
                + "\"quantidadeMaximaParcelas\":12,\n"
                + "\"isentoDeTarifa\":true,\n"
                + "\"fluxoPagamento\":{\"id\":21,\n"
                + "\"nome\":\"TEF\"}}}]}]},";

        Data d = WsHelper.unmarshal(toParse, Data.class);
        assertNotNull(d);
        assertNotNull(d.getPedido());
        Pedido p = d.getPedido();
        testDataPedido(p);

    }

    private void testFiltros(Pedido p) {
        assertNotNull(p);
        assertEquals(PESSOA_IDS, p.getPessoaIds());
    }

    private void testDataPedido(Pedido p) {
        assertNotNull(p);
        assertEquals(PEDIDO_ID, p.getId());
        assertEquals(REFERENCIA, p.getReferencia());
        assertEquals(OBSERVACAO, p.getObs());
        assertEquals(DATA_DATA, p.getData());
        assertEquals(HORA, p.getHora());
        assertEquals(VALOR, p.getValor(), 0D);
        assertEquals(VALOR_FORMAT, p.getValorFormat());
        assertEquals(VALOR_ABERTO, p.getValorAberto(), 0D);
        assertEquals(VALOR_ABERTO_FORMAT, p.getValorAbertoFormat());
        assertEquals(VALOR_ORIGINAL_PAGO, p.getValorOriginalPago(), 0D);
        assertEquals(VALOR_ORIGINAL_PAGO_FORMAT, p.getValorOriginalPagoFormat());
        assertEquals(VALOR_ORIGINAL_EM_PAGAMENTO, p.getValorOriginalEmPagamento(), 0.00);
        assertEquals(VALOR_ORIGINAL_EM_PAGAMENTO_FORMAT, p.getValorOriginalEmPagamentoFormat());
        assertEquals(TIPO, p.getTipo());
        assertEquals(QUANTIDADE, p.getQuantidade());
        assertEquals(QUANTIDADE_TRANSACOES, p.getQuantidadeTransacoes());

    }
}

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

        String toParse = "";
        Data d = WsHelper.unmarshal(toParse, Data.class);
        assertNotNull(d);
        assertNotNull(d.getPedido());
        Pedido p = d.getPedido();
        testFiltrosData(p);
    }

    private void testFiltros(Pedido p) {
      assertNotNull(p);
      assertEquals(PESSOA_IDS, p.getPessoaIds());
    }

    private void testFiltrosData(Pedido p) {
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

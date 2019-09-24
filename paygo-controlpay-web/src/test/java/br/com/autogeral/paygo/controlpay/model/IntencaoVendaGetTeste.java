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

    private static final int INTENCAO_VENDA_ID = 1;
    private static final String FORMA_PAGAMENTO_ID = null;
    private static final String TERMINAL_ID = "900";
    private static final String STATUS = "Pendente ,15";
    private static final boolean VENDAS_DIA = true;
    private static final String REFERENCIA = null;

    @Test
    public void Serialize() {
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
        String toParse = "data \"{\n"
                + "    \"intencaoVendaId\\\": 23455,\n"
                + "    \"formaPagamentoId\\\": null,\n"
                + "    \"terminalId\\\": \\\"\\\",\n"
                + "    \"status\\\": \\\"Pendente,15\\\",\n"
                + "    \"vendasDia\\\": true,\n"
                + "    \"referencia\\\": null\n"
                + "}\"";

        IntencaoVendaPesquisa intencaoVendaPesquisa = WsHelper.unmarshal(toParse, IntencaoVendaPesquisa.class);

    }

    private void testParseBusca(IntencaoVendaPesquisa intencaoVendaPesquisa) {
        IntencaoVenda intencao = new IntencaoVenda();
        assertNotNull(intencaoVendaPesquisa);
        intencao.setId(INTENCAO_VENDA_ID);
     
    }
}

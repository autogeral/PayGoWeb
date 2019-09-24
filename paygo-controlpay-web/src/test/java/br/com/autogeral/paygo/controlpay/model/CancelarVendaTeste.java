package br.com.autogeral.paygo.controlpay.model;

import br.com.autogeral.paygo.controlpay.web.WsHelper;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author kaique.mota
 */
public class CancelarVendaTeste {

    private static final int ID_INTEIRDO_INTENCAO_VENDA = 23456;
    private static final String ID_INTENCAO_VENDA = "23456";
    private static final String TERMINAL = "900";
    private static final boolean AGUARDAR_TEF_INICIAR_TRANSCAO = false;
    private static final String SENHA_TECNICA = "314159";
    private static final String TOKEN = "442928";
    private static final String DATA_DATA = "17/09/2019 11:50:40.2422";
    private static final String HORA = "11:50:40";
    private static final int QUANTIDADE = 1;
    private static final double VALOR_ORIGINAL_PAGO = 0.0;
    private static final String VALOR_ORIGINAL_PAGO_FORMAT = "0,00";
    private static final String VALOR_ACRESCIMO_FORMAT = "0,00";
    private static final double VALOR_ACRESCIMO = 0;
    private static final String VALOR_DESCONTO_FORMAT = "0,00";
    private static final double VALOR_DESCONTO = 0;
    private static final String VALOR_FINAL_FORMAT = "3,00";
    private static final double VALOR_FINAL = 0;
    private static final String GATE_2ALL_TOKEN = null;
    private static final int FORMA_PAGAMENTO_ID = 21;
    private static final String FORMA_PAGAMENTO_NOME = "TEF";
    private static final String FORMA_PAGAMENTO_MODALIDADE = "Crédito";
    private static final int FLUXO_PAGAMENTO_ID = 21;
    private static final String FLUXO_PAGAMENTO_NOME = "TEF";
    private static final int INTENCAO_VENDA_STATUS_ID = 20;
    private static final String INTENCAO_VENDA_STATUS_NOME = "Cancelado";
    private static final String CLIENTE = null;
    private static final String ITEM_PRODUTO_ID = "30747";
    private static final int PRODUTO_ID = 2075;
    private static final String PRODUTO_NOME = "Produto genérico";
    private static final int  PRODUTO_QUANTIDADE = 1;
    private static final String PRODUTO_VENDA_QUANTIDADE = "1";
    private static final String PRODUTO_VALOR = "10.000";

    @Test
    public void serialize() {
        VendaCancelamento vendaCancelamento = new VendaCancelamento();
        vendaCancelamento.setIntencaoVendaId(ID_INTENCAO_VENDA);
        vendaCancelamento.setTerminalId(TERMINAL);
        vendaCancelamento.setAguardarTefIniciarTransacao(AGUARDAR_TEF_INICIAR_TRANSCAO);
        vendaCancelamento.setSenhaTecnica(SENHA_TECNICA);
        IntencaoVenda intencaoVenda = new IntencaoVenda();
        intencaoVenda.setId(ID_INTEIRDO_INTENCAO_VENDA);
        intencaoVenda.setData(DATA_DATA);
        intencaoVenda.setHora(HORA);
        intencaoVenda.setQuantidade(QUANTIDADE);
        intencaoVenda.setValorOriginal(VALOR_ORIGINAL_PAGO);
        intencaoVenda.setValorOriginalFormat(VALOR_ORIGINAL_PAGO_FORMAT);
        intencaoVenda.setValorAcrescimo(VALOR_ACRESCIMO);
        intencaoVenda.setValorAcrescimoFormat(VALOR_ACRESCIMO_FORMAT);
        intencaoVenda.setValorDesconto(VALOR_DESCONTO);
        intencaoVenda.setValorDescontoFormat(VALOR_DESCONTO_FORMAT);
        intencaoVenda.setValorFinal(VALOR_FINAL);
        intencaoVenda.setValorFinalFormat(VALOR_FINAL_FORMAT);
        intencaoVenda.setGate2allToken(GATE_2ALL_TOKEN);
        FormaPagamento formaPagamento = new FormaPagamento();
        formaPagamento.setId(FORMA_PAGAMENTO_ID);
        formaPagamento.setNome(FORMA_PAGAMENTO_NOME);
        formaPagamento.setModalidade(FORMA_PAGAMENTO_MODALIDADE);
        FluxoPagamento fluxoPagamento = new FluxoPagamento();
        fluxoPagamento.setId(FLUXO_PAGAMENTO_ID);
        fluxoPagamento.setNome(FLUXO_PAGAMENTO_NOME);
        IntencaoVendaStatus intencaoVendaStatus = new IntencaoVendaStatus();
        intencaoVendaStatus.setId(INTENCAO_VENDA_STATUS_ID);
        intencaoVendaStatus.setNome(INTENCAO_VENDA_STATUS_NOME);
        Produto produto = new Produto();
        produto.setId(PRODUTO_ID);
        produto.setNome(PRODUTO_NOME);
        produto.setQuantidade(PRODUTO_QUANTIDADE);
        produto.setValor(PRODUTO_VALOR);

    }

    @Test
    public void test_Parse() {
        String toParse = "   {\n"
                + "    \"intencaoVendaId\":" + ID_INTENCAO_VENDA + ",\n"
                + "    \"terminalId\":" + TERMINAL + ",\n"
                + "    \"aguardarTefIniciarTransacao\": "+AGUARDAR_TEF_INICIAR_TRANSCAO+",\n"
                + "    \"senhaTecnica\":" + SENHA_TECNICA + "\n"
                + "}";
        VendaCancelamento vendaCancelamento = WsHelper.unmarshal(toParse, VendaCancelamento.class
        );
        testCancelamento(vendaCancelamento);
    }

    @Test
    public void testParseData() {
        String toParse = "{\n"
                + "  \"data\": \"" + DATA_DATA + "\",\n"
                + "  \"intencaoVenda\": {\n"
                + "    \"id\": " + ID_INTENCAO_VENDA + ",\n"
                + "    \"token\": \"" + TOKEN + "\",\n"
                + "    \"data\": \"" + DATA_DATA + "\",\n"
                + "    \"hora\": \"" + HORA + "\",\n"
                + "    \"quantidade\":" + QUANTIDADE + ",\n"
                + "    \"valorOriginal\": " + VALOR_ORIGINAL_PAGO + ",\n"
                + "    \"valorOriginalFormat\": \"" + VALOR_ORIGINAL_PAGO_FORMAT + "\",\n"
                + "    \"valorAcrescimo\": " + VALOR_ACRESCIMO + ",\n"
                + "    \"valorAcrescimoFormat\": \"" + VALOR_ACRESCIMO_FORMAT + "\",\n"
                + "    \"valorDesconto\": " + VALOR_DESCONTO + ",\n"
                + "    \"valorDescontoFormat\": \"" + VALOR_DESCONTO_FORMAT + "\",\n"
                + "    \"valorFinal\": " + VALOR_FINAL + ",\n"
                + "    \"valorFinalFormat\": \"" + VALOR_FINAL_FORMAT + "\",\n"
                + "    \"gate2allToken\": " + GATE_2ALL_TOKEN + ",\n"
                + "    \"formaPagamento\": {\n"
                + "      \"id\": " + FORMA_PAGAMENTO_ID + ",\n"
                + "      \"nome\": \"" + FORMA_PAGAMENTO_NOME + "\",\n"
                + "      \"modalidade\": \"" + FORMA_PAGAMENTO_MODALIDADE + "\",\n"
                + "      \"fluxoPagamento\": {\n"
                + "        \"id\": " + FLUXO_PAGAMENTO_ID + ",\n"
                + "        \"nome\": \"" + FLUXO_PAGAMENTO_NOME + "\"\n"
                + "      }\n"
                + "    },\n"
                + "    \"intencaoVendaStatus\": {\n"
                + "      \"id\": " + INTENCAO_VENDA_STATUS_ID + ",\n"
                + "      \"nome\": \"" + INTENCAO_VENDA_STATUS_NOME + "\"\n"
                + "    },\n"
                + "    \"cliente\": " + CLIENTE + ",\n"
                + "    \"produtos\": [\n"
                + "      {\n"
                + "        \"itemProdutoId\": " + ITEM_PRODUTO_ID + ",\n"
                + "        \"id\": " + PRODUTO_ID + ",\n"
                + "        \"nome\": \"" + PRODUTO_NOME + "\",\n"
                + "        \"quantidade\": " + PRODUTO_QUANTIDADE + ",\n"
                + "        \"valor\": \"" + PRODUTO_VALOR + "\"\n"
                + "      }\n"
                + "    ]\n"
                + "  }\n"
                + "}";

        Data testar = WsHelper.unmarshal(toParse, Data.class);
        assertNotNull(testar);
        assertNotNull(testar.getIntencaoVenda());
        IntencaoVenda intencaoVenda = testar.getIntencaoVenda();
        testCancelamentoData(intencaoVenda);
    }

    private void testCancelamento(VendaCancelamento vendaCancelamento) {

        assertNotNull(vendaCancelamento);
        assertEquals(ID_INTENCAO_VENDA, vendaCancelamento.getIntencaoVendaId());
        assertEquals(TERMINAL, vendaCancelamento.getTerminalId());
        assertEquals(AGUARDAR_TEF_INICIAR_TRANSCAO, vendaCancelamento.isAguardarTefIniciarTransacao());
        assertEquals(SENHA_TECNICA, vendaCancelamento.getSenhaTecnica());
    }

    private void testCancelamentoData(IntencaoVenda intencaoVenda) {

        assertNotNull(intencaoVenda);
        assertEquals(ID_INTEIRDO_INTENCAO_VENDA, intencaoVenda.getId());
        assertEquals(TOKEN, intencaoVenda.getToken());
        assertEquals(DATA_DATA, intencaoVenda.getData());
        assertEquals(HORA, intencaoVenda.getHora());
        assertEquals(QUANTIDADE, intencaoVenda.getQuantidade());
        assertEquals(VALOR_ORIGINAL_PAGO, intencaoVenda.getValorOriginal(), 0D);
        assertEquals(VALOR_ORIGINAL_PAGO_FORMAT, intencaoVenda.getValorOriginalFormat());
        assertEquals(VALOR_ACRESCIMO, intencaoVenda.getValorAcrescimo(), 0D);
        assertEquals(VALOR_ACRESCIMO_FORMAT, intencaoVenda.getValorAcrescimoFormat());
        assertEquals(VALOR_FINAL, intencaoVenda.getValorFinal(), 0D);
        assertEquals(VALOR_FINAL_FORMAT, intencaoVenda.getValorFinalFormat());
        assertEquals(GATE_2ALL_TOKEN, intencaoVenda.getGate2allToken());
        FormaPagamento pag = intencaoVenda.getFormaPagamento();
        assertEquals(FORMA_PAGAMENTO_ID, pag.getId());
        assertEquals(FORMA_PAGAMENTO_NOME, pag.getNome());
        assertEquals(FORMA_PAGAMENTO_MODALIDADE, pag.getModalidade());
        FluxoPagamento fluxoPagamento = intencaoVenda.getFormaPagamento().getFluxoPagamento();
        assertEquals(FLUXO_PAGAMENTO_ID, fluxoPagamento.getId());
        assertEquals(FLUXO_PAGAMENTO_NOME, fluxoPagamento.getNome());
        IntencaoVendaStatus intencaoVendaStatus = intencaoVenda.getIntencaoVendaStatus();
        assertEquals(INTENCAO_VENDA_STATUS_ID, intencaoVendaStatus.getId());
        assertEquals(INTENCAO_VENDA_STATUS_NOME, intencaoVendaStatus.getNome());
        ProdutoVenda produtoVenda = intencaoVenda.getProdutos().get(0);
        assertEquals(PRODUTO_ID, produtoVenda.getId());
        assertEquals(PRODUTO_NOME, produtoVenda.getNome());
        assertEquals(PRODUTO_VENDA_QUANTIDADE, produtoVenda.getQuantidade());
        assertEquals(PRODUTO_VALOR, produtoVenda.getValor());
    }
}

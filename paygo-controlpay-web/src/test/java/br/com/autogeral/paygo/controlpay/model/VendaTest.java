package br.com.autogeral.paygo.controlpay.model;

import br.com.autogeral.paygo.controlpay.web.WsHelper;
import org.junit.Test;
import static org.junit.Assert.*;

public class VendaTest {
/*
    private static final int ID_INTENCAO_VENDA = 23456;
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
    private static final int FORMA_PAGAMENTO_ID = 21;
    private static final String FORMA_PAGAMENTO_NOME = "TEF";
    private static final String FORMA_PAGAMENTO_MODALIDADE = "Crédito";
    private static final int FLUXO_PAGAMENTO_ID = 21;
    private static final String FLUXO_PAGAMENTO_NOME = "TEF";
    private static final String TERMINAL = "900";
    private static final int TERMINAL_TERMINAL = 81;
    private static final String TERMINAL_NOME = "REAL";
    private static final int INTENCAO_VENDA_STATUS_ID = 20;
    private static final String INTENCAO_VENDA_STATUS_NOME = "Cancelado";
    private static final String CLIENTE = null;
    private static final int ITEM_PRODUTO_ID = 30747;
    private static final int PRODUTO_ID = 2075;
    private static final String PRODUTO_NOME = "Produto genérico";
    private static final int PRODUTO_QUANTIDADE = 1;
    private static final String PRODUTO_VALOR = "10.000";
    private static final String PEDIDO = null;
    private static final int PEDIDO_ID = 0;
    private static final String REFERENCIA = null;
    private static final boolean AGURDAR_TEF_INICIAR_TRANSACAO = true;
    private static final String PARCELAMENTO_ADMIN = null;
    private static final int QUANTIDADE_PARCELAS = 1;
    private static final String ADQUIRENTE = "";
    private static final boolean AGUARDAR_CLIENTE_INICIAR_IMPRESSAO = true;
    private static final int IMPRESSORA_ID = 0;
    private static final String CONTEUDO = null;
    private static final int ID = 0;
    private static final String NOME = null;
    private static final String QUANTIDADE = "1";
    private static final int QUANTIDADEE_VENDA = 1;
    private static final String VALOR = "1,00";
    private static final int PAGAMENTO_ID = 1571;
    private static final int TIPO = 5;
    private static final int ORIGEM = 5;
    private static final int TIPO_PARCELAMENTO = 2;
    private static final int PAGAMENTO_EXTERNO_STATUS_ID = 15;
    private static final String PAGAMENTO_EXTERNO_STATUS_NOME = "Finalizado";

    @Test
    public void test01_serializeVal() {
        Venda venda = new Venda();

        venda.setFormaPagamentoId(FORMA_PAGAMENTO_ID);
        venda.setTerminalId(TERMINAL);
        venda.setReferencia(REFERENCIA);
        venda.setAguardarTefIniciarTransacao(AGURDAR_TEF_INICIAR_TRANSACAO);
        venda.setParcelamentoAdmin(PARCELAMENTO_ADMIN);
        venda.setQuantidadeParcelas(QUANTIDADE_PARCELAS);
        venda.setAdquirente(ADQUIRENTE);
        ProdutoVenda produtoVenda = new ProdutoVenda();
        produtoVenda.setId(PRODUTO_ID);
        produtoVenda.setNome(NOME);
        produtoVenda.setQuantidade(QUANTIDADE);
        produtoVenda.setValor(VALOR);
        venda.setAguardarClienteIniciarImpressao(AGUARDAR_CLIENTE_INICIAR_IMPRESSAO);
        venda.setImpressoraId(IMPRESSORA_ID);
        venda.setConteudo(CONTEUDO);
        venda.setFormaPagamentoId(FORMA_PAGAMENTO_ID);
    }

    @Test
    public void test02_serialize() {
        Venda instance = new Venda();
        instance.setTerminalId(TERMINAL);
        instance.setAdquirente(ADQUIRENTE);
        instance.setFormaPagamentoId(FORMA_PAGAMENTO_ID);
        instance.setQuantidadeParcelas(QUANTIDADE_PARCELAS);
        ProdutoVenda pv = new ProdutoVenda();
        pv.setItemProdutoId(ITEM_PRODUTO_ID);
        pv.setValor(VALOR);
        pv.setQuantidade(QUANTIDADE);
        instance.getProdutosVendidos().add(pv);

        String expResult = "{\n"
                + "  \"formaPagamentoId\": " + FORMA_PAGAMENTO_ID + ",\n"
                + "  \"pedidoId\": " + PEDIDO_ID + ",\n"
                + "  \"terminalId\": \"" + TERMINAL + "\",\n"
                + "  \"referencia\": " + REFERENCIA + ",\n"
                + "  \"aguardarTefIniciarTransacao\": " + AGURDAR_TEF_INICIAR_TRANSACAO + ",\n"
                + "  \"parcelamentoAdmin\": " + PARCELAMENTO_ADMIN + ",\n"
                + "  \"quantidadeParcelas\": " + QUANTIDADE_PARCELAS + ",\n"
                + "  \"adquirente\": \"" + ADQUIRENTE + "\",\n"
                + "  \"produtosVendidos\": [\n"
                + "    {\n"
                + "      \"itemProdutoId\": " + ITEM_PRODUTO_ID + ",\n"
                + "      \"id\": " + ID + ",\n"
                + "      \"nome\": " + NOME + ",\n"
                + "      \"quantidade\": \"" + QUANTIDADE + "\",\n"
                + "      \"valor\": \"" + VALOR + "\"\n"
                + "    }\n"
                + "  ],\n"
                + "  \"aguardarClienteIniciarImpressao\": " + AGUARDAR_CLIENTE_INICIAR_IMPRESSAO + ",\n"
                + "  \"impressoraId\": " + IMPRESSORA_ID + ",\n"
                + "  \"conteudo\": " + CONTEUDO + "\n"
                + "}";

        String result = WsHelper.getGson().toJson(instance);
        System.out.println(result);
        assertEquals(expResult, result);
    }

    @Test
    public void testParse() {

        String toParse = "{\n"
                + "  \"formaPagamentoId\": " + FORMA_PAGAMENTO_ID + ",\n"
                + "  \"pedidoId\": " + PEDIDO_ID + ",\n"
                + "  \"terminalId\": \"" + TERMINAL + "\",\n"
                + "  \"referencia\": " + REFERENCIA + ",\n"
                + "  \"aguardarTefIniciarTransacao\": " + AGURDAR_TEF_INICIAR_TRANSACAO + ",\n"
                + "  \"parcelamentoAdmin\": " + PARCELAMENTO_ADMIN + ",\n"
                + "  \"quantidadeParcelas\": " + QUANTIDADE_PARCELAS + ",\n"
                + "  \"adquirente\": \"" + ADQUIRENTE + "\",\n"
                + "  \"produtosVendidos\": [\n"
                + "    {\n"
                + "      \"id\": " + ID + ",\n"
                + "      \"nome\": " + NOME + ",\n"
                + "      \"quantidade\": \"" + QUANTIDADE + "\",\n"
                + "      \"valor\": \"" + VALOR + "\"\n"
                + "    }\n"
                + "  ],\n"
                + "  \"aguardarClienteIniciarImpressao\": " + AGUARDAR_CLIENTE_INICIAR_IMPRESSAO + ",\n"
                + "  \"impressoraId\": " + IMPRESSORA_ID + ",\n"
                + "  \"conteudo\": " + CONTEUDO + "\n"
                + "}";

        Venda v = WsHelper.unmarshal(toParse, Venda.class);
        testVenda(v);
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
                + "    \"quantidade\": " + QUANTIDADE + ",\n"
                + "    \"valorOriginal\": " + VALOR_ORIGINAL_PAGO + ",\n"
                + "    \"valorOriginalFormat\": \"" + VALOR_ORIGINAL_PAGO_FORMAT + "\",\n"
                + "    \"valorAcrescimo\": " + VALOR_ACRESCIMO + ",\n"
                + "    \"valorAcrescimoFormat\": \"" + VALOR_ACRESCIMO_FORMAT + "\",\n"
                + "    \"valorDesconto\": " + VALOR_DESCONTO + ",\n"
                + "    \"valorDescontoFormat\": \"" + VALOR_DESCONTO_FORMAT + "\",\n"
                + "    \"valorFinal\": " + VALOR_FINAL + ",\n"
                + "    \"valorFinalFormat\": \"" + VALOR_FINAL_FORMAT + "\",\n"
                + "    \"gate2allToken\": " + GATE_2ALL_TOKEN + ",\n"
                + "    \"quantidadeParcelas\": " + QUANTIDADE_PARCELAS + ",\n"
                + "    \"urlPagamento\": " + URL_PAGAMENTO + ",\n"
                + "    \"formaPagamento\": {\n"
                + "      \"id\": " + FORMA_PAGAMENTO_ID + ",\n"
                + "      \"nome\": \"" + FORMA_PAGAMENTO_NOME + "\",\n"
                + "      \"modalidade\": \"" + FORMA_PAGAMENTO_MODALIDADE + "\",\n"
                + "      \"fluxoPagamento\": {\n"
                + "        \"id\": " + FLUXO_PAGAMENTO_ID + ",\n"
                + "        \"nome\": \"" + FLUXO_PAGAMENTO_NOME + "\"\n"
                + "      }\n"
                + "    },\n"
                + "    \"terminal\": {\n"
                + "      \"id\": " + TERMINAL_TERMINAL + ",\n"
                + "      \"nome\": \"" + TERMINAL_NOME + "\"\n"
                + "    },\n"
                + "    \"pagamentosExterno\": [\n"
                + "      {\n"
                + "        \"id\": " + PAGAMENTO_ID + ",\n"
                + "        \"tipo\": " + TIPO + ",\n"
                + "        \"origem\": " + ORIGEM + ",\n"
                + "        \"tipoParcelamento\": " + TIPO_PARCELAMENTO + ",\n"
                + "        \"pagamentoExternoStatus\": {\n"
                + "          \"id\": " + PAGAMENTO_EXTERNO_STATUS_ID + ",\n"
                + "          \"nome\": \"" + PAGAMENTO_EXTERNO_STATUS_NOME + "\"\n"
                + "        }\n"
                + "      }\n"
                + "    ],\n"
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
                + "    ],\n"
                + "    \"pedido\": " + PEDIDO + "\n"
                + "  }\n"
                + "}";

        Data d = WsHelper.unmarshal(toParse, Data.class);
        assertNotNull(d);
        assertNotNull(d.getIntencaoVenda());
        IntencaoVenda iv = d.getIntencaoVenda();
        testVendaParse(iv);
    }

    private void testVendaParse(IntencaoVenda iv) {
        assertNotNull(iv);
        Data d = new Data();
        assertEquals(DATA_DATA, iv.getData());
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
        Terminal terminal = iv.getTerminal();
        assertEquals(TERMINAL_TERMINAL, terminal.getId());
        assertEquals(TERMINAL_NOME, terminal.getNome());
        PagamentoExterno pagamentoExterno = iv.getPagamentosExternos().get(0);
        assertEquals(PAGAMENTO_ID, pagamentoExterno.getId());
        assertEquals(TIPO, pagamentoExterno.getTipo());
        assertEquals(ORIGEM, pagamentoExterno.getOrigem());
        assertEquals(TIPO_PARCELAMENTO, pagamentoExterno.getTipoParcelamento());
        PagamentoExternoStatus externoStatus = iv.getPagamentosExternos().get(0).getPagamentoExternoStatus();
        assertEquals(PAGAMENTO_EXTERNO_STATUS_ID, externoStatus.getId());
        assertEquals(PAGAMENTO_EXTERNO_STATUS_NOME, externoStatus.getNome());
        IntencaoVendaStatus statausVenda = iv.getIntencaoVendaStatus();
        assertEquals(INTENCAO_VENDA_STATUS_ID, statausVenda.getId());
        assertEquals(INTENCAO_VENDA_STATUS_NOME, statausVenda.getNome());
        assertEquals(CLIENTE, iv.getCliente());
        ProdutoVenda produtos = iv.getProdutos().get(0);
        assertEquals(ITEM_PRODUTO_ID, iv.getProdutos().get(0).getItemProdutoId());
        assertEquals(PRODUTO_ID, iv.getProdutos().get(0).getId());
        assertEquals(PRODUTO_NOME, produtos.getNome());
        assertEquals(QUANTIDADE, produtos.getQuantidade());
        assertEquals(PRODUTO_VALOR, produtos.getValor());
        assertEquals(PEDIDO, iv.getPedido());

    }

    private void testVenda(Venda venda) {
        ProdutoVenda produtoVenda = new ProdutoVenda();
        assertNotNull(venda);
        assertEquals(FORMA_PAGAMENTO_ID, venda.getFormaPagamentoId());
        assertEquals(TERMINAL, venda.getTerminalId());
        assertEquals(REFERENCIA, venda.getReferencia());
        assertEquals(AGURDAR_TEF_INICIAR_TRANSACAO, venda.isAguardarTefIniciarTransacao());
        assertEquals(PARCELAMENTO_ADMIN, venda.getParcelamentoAdmin());
        assertEquals(QUANTIDADE_PARCELAS, venda.getQuantidadeParcelas());
        assertEquals(ADQUIRENTE, venda.getAdquirente());
        assertEquals(ID, venda.getProdutosVendidos().get(0).getId());
        assertEquals(NOME, venda.getProdutosVendidos().get(0).getNome());
        assertEquals(QUANTIDADE, venda.getProdutosVendidos().get(0).getQuantidade());
        assertEquals(VALOR, venda.getProdutosVendidos().get(0).getValor());
        assertEquals(AGUARDAR_CLIENTE_INICIAR_IMPRESSAO, venda.isAguardarClienteIniciarImpressao());
        assertEquals(IMPRESSORA_ID, venda.getImpressoraId());
        assertEquals(CONTEUDO, venda.getConteudo());
    }
*/
}

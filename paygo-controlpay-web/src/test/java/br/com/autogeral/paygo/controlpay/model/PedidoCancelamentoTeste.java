package br.com.autogeral.paygo.controlpay.model;

import br.com.autogeral.paygo.controlpay.web.WsHelper;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author kaique.mota
 */
public class PedidoCancelamentoTeste {

    private static final int PEDIDO_ID = 2364;
    private static final String REFERENCIA = "PEDIDO10";
    private static final String OBSERVACAO = null;
    private static final String DATA_DATA = "11/09/2019 12:36:08.0000";
    private static final String HORA = "12:36:08";
    private static final double VALOR = 300.0000;
    private static final int PESSOA_VENDEDOR_ID = 1;
    private static final String VALOR_FORMAT = "300,00";
    private static final double VALOR_ABERTO = 300.0000;
    private static final String VALOR_ABERTO_FORMAT = "300,00";
    private static final double VALOR_ORIGINAL_PAGO = 0.0;
    private static final String VALOR_ORIGINAL_PAGO_FORMAT = "0,00";
    private static final double VALOR_ORIGINAL_EM_PAGAMENTO = 0.0;
    private static final String VALOR_ORIGINAL_EM_PAGAMENTO_FORMAT = "0,00";
    private static final String TIPO = "Interno";
    private static final int QUANTIDADE = 1;
    private static final int QUANTIDADE_TRANSACOES = 0;
    private static final int PEDIDO_STATUS_ID = 15;
    private static final String NOME = "Cancelado";
    private static final int PESSOA_ID = 8149;
    private static final String NOME_RAZAO_SOCIAL = "AUTO GERAL AUTOPECAS LTDA";
    private static final String SOBRENOME_NOME_FANTASIA = "AUTO GERAL AUTOPECAS LTDA";
    private static final String CPF_CNPJ_FORMAT = "05.437.537/0001-37";
    private static final String EMAIL = "kaique.motta@autogeral.com.br";
    private static final int ITEM_PRODUTO_ID = 30829;
    private static final int PRODUTO_ID = 2075;
    private static final String PRODUTO_NOME = "Produto genérico";
    private static final String PRODUTO_EXIBE_NOME = "Produto ge";
    private static final int PRODUTO_QUANTIDADE = 1;
    private static final String PRODUTO_VALOR = "300.0000";
    private static final String PRODUTO_VALOR_FORMAT = "300,00";
    private static final String FOTO_THUMBNAIL = "http://pay2alldemo.azurewebsites.net/WebAPI/ImagensProdutos/_ProdutoDefault.png";

    @Test
    public void test_serialize() {
        Pedido p = new Pedido();
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
        PedidoStatus pedidoStatus = new PedidoStatus();
        pedidoStatus.setId(PEDIDO_STATUS_ID);
        pedidoStatus.setNome(NOME);
        Pessoa pessoa = new Pessoa();
        pessoa.setId(PEDIDO_ID);
        pessoa.setNomeRazaoSocial(NOME_RAZAO_SOCIAL);
        pessoa.setSobrenomeNomeFantasia(SOBRENOME_NOME_FANTASIA);
        pessoa.setCpfCnpj(CPF_CNPJ_FORMAT);
        pessoa.setEmail(EMAIL);
        Produto produto = new Produto();
        produto.setId(PRODUTO_ID);
        produto.setNome(PRODUTO_NOME);
        produto.setNomeExibe(PRODUTO_EXIBE_NOME);
        produto.setQuantidade(PRODUTO_QUANTIDADE);
        produto.setValor(PRODUTO_VALOR);
        produto.setValorFormat(PRODUTO_VALOR_FORMAT);
        produto.setFotoThumbnail(FOTO_THUMBNAIL);

        String result = WsHelper.marshal(p);
        System.out.println(result);
    }

    @Test
    public void testParse() {

        String toParse = "2364";
    }

    @Test
    public void testParseData() {
        String toParse = " {\n"
                + "    \"data\": \"20/09/2019 14:18:01.1227\",\n"
                + "    \"pedido\": {\n"
                + "        \"id\": 2364,\n"
                + "        \"referencia\": \"PEDIDO10\",\n"
                + "        \"obs\": null,\n"
                + "        \"data\": \"11/09/2019 12:36:08.0000\",\n"
                + "        \"hora\": \"12:36:08\",\n"
                + "        \"valor\": 300.0000,\n"
                + "        \"valorFormat\": \"300,00\",\n"
                + "        \"valorAberto\": 300.0000,\n"
                + "        \"valorAbertoFormat\": \"300,00\",\n"
                + "        \"valorOriginalPago\": 0.0,\n"
                + "        \"valorOriginalPagoFormat\": \"0,00\",\n"
                + "        \"valorOriginalEmPagamento\": 0.0,\n"
                + "        \"valorOriginalEmPagamentoFormat\": \"0,00\",\n"
                + "        \"tipo\": \"Interno\",\n"
                + "        \"quantidade\": 1,\n"
                + "        \"quantidadeTransacoes\": 0,\n"
                + "        \"pedidoStatus\": {\n"
                + "            \"id\": 15,\n"
                + "            \"nome\": \"Cancelado\"\n"
                + "        },\n"
                + "        \"pessoa\": {\n"
                + "            \"id\": 8149,\n"
                + "            \"nomeRazaoSocial\": \"AUTO GERAL AUTOPECAS LTDA\",\n"
                + "            \"sobrenomeNomeFantasia\": \"AUTO GERAL AUTOPECAS LTDA\",\n"
                + "            \"cpfCnpjFormat\": \"05.437.537/0001-37\",\n"
                + "            \"email\": \"kaique.motta@autogeral.com.br\"\n"
                + "        },\n"
                + "        \"produtos\": [\n"
                + "            {\n"
                + "                \"itemProdutoId\": 30829,\n"
                + "                \"id\": 2075,\n"
                + "                \"nome\": \"Produto genérico\",\n"
                + "                \"descricao\": \"Produto genérico\",\n"
                + "                \"nomeExibe\": \"Produto ge\",\n"
                + "                \"quantidade\": 1,\n"
                + "                \"valor\": 300.0000,\n"
                + "                \"valorFormat\": \"300,00\",\n"
                + "                \"fotoThumbnail\": \"http://pay2alldemo.azurewebsites.net/WebAPI/ImagensProdutos/_ProdutoDefault.png\"\n"
                + "            }\n"
                + "        ]\n"
                + "    }\n"
                + "}";

        Data d = WsHelper.unmarshal(toParse, Data.class);
        assertNotNull(d);
        assertNotNull(d.getPedido());
        Pedido p = d.getPedido();
        testCancelamentoDataPedido(p);

    }

    private void testCancelamentoDataPedido(Pedido p) {
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
        assertEquals(PEDIDO_STATUS_ID, p.getPedidoStatus().getId());
        assertEquals(NOME, p.getPedidoStatus().getNome());
        assertEquals(PESSOA_ID, p.getPessoa().getId());
        assertEquals(NOME_RAZAO_SOCIAL, p.getPessoa().getNomeRazaoSocial());
        assertEquals(SOBRENOME_NOME_FANTASIA, p.getPessoa().getSobrenomeNomeFantasia());
        assertEquals(CPF_CNPJ_FORMAT, p.getPessoa().getCpfCnpjFormat());
        assertEquals(EMAIL, p.getPessoa().getEmail());
        assertNotNull(p.getProdutos());
        Produto produto = p.getProdutos().get(0);
        assertEquals(PRODUTO_ID, p.getProdutos().get(0).getId());
        assertEquals(PRODUTO_NOME, p.getProdutos().get(0).getNome());
        assertEquals(PRODUTO_EXIBE_NOME, produto.getNomeExibe());
        assertEquals(PRODUTO_QUANTIDADE, produto.getQuantidade());
        assertEquals(PRODUTO_VALOR, produto.getValor());
        assertEquals(PRODUTO_VALOR_FORMAT, produto.getValorFormat());
        assertEquals(FOTO_THUMBNAIL, produto.getFotoThumbnail());
    }

    private void testeParseCancelamento(Pedido p) {
        assertEquals(PEDIDO_ID, p.getId());
    }
}

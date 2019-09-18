package br.com.autogeral.paygo.controlpay.model;

import br.com.autogeral.paygo.controlpay.web.WsHelper;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author kaique.mota
 */
public class PedidoTeste {

    private static final int PEDIDO_ID = 2439;
    private static final String REFERENCIA = "REF 151";
    private static final String OBSERVACAO = null;
    private static final String DATA_DATA = "17/09/2019 11:50:40.2422";
    private static final String HORA = "11:50:40";
    private static final double VALOR = 500.00;
    private static final int PESSOA_VENDEDOR_ID = 1;
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
    private static final String NOME = "Aberto";
    private static final int PESSOA_ID = 8149;
    private static final String NOME_RAZAO_SOCIAL = "AUTO GERAL AUTOPECAS LTDA";
    private static final String SOBRENOME_NOME_FANTASIA = "AUTO GERAL AUTOPECAS LTDA";
    private static final String CPF_CNPJ_FORMAT = "05.437.537/0001-37";
    private static final String EMAIL = "kaique.motta@autogeral.com.br";
    private static final int PRODUTO_ID = 2075;
    private static final String PRODUTO_NOME = "Produto genérico";
    private static final String PRODUTO_EXIBE_NOME = "Produto ge";
    private static final int PRODUTO_QUANTIDADE = 1;
    private static final String PRODUTO_VALOR = "300.0";
    private static final String PRODUTO_VALOR_FORMAT = "300.00";
    private static final String ID_PRODUTO = "2075";
    private static final String FOTO_THUMBNAIL = "https://pay2alldemo.azurewebsites.net/WebAPI/ImagensProdutos/_ProdutoDefault.png";
    private static final int FORMA_PAGAMENTO = 21;
    private static final int QUANTIDADE_MAXIMA_PARCELAS = 3;
    private static final String ADQUIRENTE = "cielo";
    private static final double VALOR_TOTAL_PEDIDO = 300.00;
    private static final String URL = null;

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
        produto.setItemProdutoId(ID_PRODUTO);
        produto.setFotoThumbnail(FOTO_THUMBNAIL);
        FormaPagamento formaPagamento = new FormaPagamento();
        formaPagamento.setId(FORMA_PAGAMENTO);
        formaPagamento.setQuantidadeMaximaParcelas(QUANTIDADE_MAXIMA_PARCELAS);
        PedidoFormaPagamento pedidoFormaPagamento = new PedidoFormaPagamento();
        pedidoFormaPagamento.setAdquirente(ADQUIRENTE);
        p.setValorTotalPedido(VALOR_TOTAL_PEDIDO);
        p.setUrlRetorno(URL);

        String result = WsHelper.marshal(p);
        System.out.println(result);
    }

    @Test
    public void test_parse_data() {
        String toParse = "{\"data\":\"17/09/2019 14:50:40.3933\",\n"
                + "\"pedido\":{\"id\":2439,\n"
                + "\"referencia\":\"REF 151\",\n"
                + "\"obs\":null,\n"
                + "\"data\":\"17/09/2019 11:50:40.2422\",\n"
                + "\"hora\":\"11:50:40\",\n"
                + "\"valor\":500.00,\n"
                + "\"valorFormat\":\"900"
                + "\",\n"
                + "\"valorAberto\":300.00,\n"
                + "\"valorAbertoFormat\":\"300"
                + "\",\n"
                + "\"valorOriginalPago\":300.00,\n"
                + "\"valorOriginalPagoFormat\":\"0,"
                + "00\",\n"
                + "\"valorOriginalEmPagamento\":0.0,\n"
                + "\"valorOriginalEmPagamentoFormat\":\"0,00\",\n"
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
                + "\"produtos\":[{\"itemProdutoId\":30938,\n"
                + "\"id\":2075,\n"
                + "\"nome\":\"Produto genérico\",\n"
                + "\"descricao\":\"Produto genérico\",\n"
                + "\"nomeExibe\":\"Produto ge\",\n"
                + "\"quantidade\":1,\n"
                + "\"valor\":300.0,\n"
                + "\"valorFormat\":\"300."
                + "00\",\n"
                + "\"fotoThumbnail\":\"https://pay2alldemo.azurewebsites.net/WebAPI/ImagensProdutos/_ProdutoDefault.png\"}]}}";

        Data d = WsHelper.unmarshal(toParse, Data.class);
        assertNotNull(d);
        assertNotNull(d.getPedido());
        Pedido p = d.getPedido();
        testDataPedido(p);

    }

    @Test
    public void test_parse() {
        String toParse = "{\n"
                + "  \"pessoaVendedorId\": \"1\",\n"
                + "   \"terminalFisicoId\":900,\n"
                + "  \"referencia\": \"REF 151\",\n"
                + "  \"ValorTotalPedido\": \"300.00\", \n"
                + "  \"urlRetorno\": null, \n"
                + "  \"produtosPedido\": [\n"
                + "      {\n"
                + "      \"Id\": \"2075\",  \n"
                + "      \"Nome\": \"Produto genérico\", \n"
                + "      \"Valor\": \"300.0\", \n"
                + "      \"Quantidade\": \"1\"\n"
                + "      }\n"
                + "  ],\n"
                + "  \"pedidoFormasPagamento\":[\n"
                + "    {\n"
                + "      \"FormaPagamento\":{\n"
                + "        \"Id\":21\n"
                + "      },\n"
                + "      \"QuantidadeMaximaParcelas\":3,\n"
                + "      \"Adquirente\":\"cielo\"\n"
                + "    }\n"
                + "  ]\n"
                + "  }";

        Pedido p = WsHelper.unmarshal(toParse, Pedido.class);
        testPedido(p);
    }

    private void testPedido(Pedido p) {

        assertNotNull(p);

        assertEquals(PESSOA_VENDEDOR_ID, p.getPessoaVendedorId());
        assertEquals(REFERENCIA, p.getReferencia());
        assertEquals(VALOR_TOTAL_PEDIDO, p.getValorTotalPedido(), 0D);
        assertEquals(URL, p.getUrlRetorno());
        assertNotNull(p.getProdutos());

        Produto pro = p.getProdutosPedido().get(0);
        assertEquals(PRODUTO_ID, pro.getId());
        assertEquals(PRODUTO_NOME, pro.getNome());
        assertEquals(PRODUTO_VALOR, pro.getValor());
        assertEquals(PRODUTO_QUANTIDADE, pro.getQuantidade());

        PedidoFormaPagamento formaPagamento = p.getPedidoFormasPagamento().get(0);
        assertEquals(FORMA_PAGAMENTO, p.getPedidoFormasPagamento().get(0).getFormaPagamento().getId());
        assertEquals(QUANTIDADE_MAXIMA_PARCELAS, formaPagamento.getQuantidadeMaximaParcelas());
        assertEquals(ADQUIRENTE, formaPagamento.getAdquirente());

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

}

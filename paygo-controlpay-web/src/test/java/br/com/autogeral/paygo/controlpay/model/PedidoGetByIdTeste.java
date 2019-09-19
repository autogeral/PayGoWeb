package br.com.autogeral.paygo.controlpay.model;

import br.com.autogeral.paygo.controlpay.web.WsHelper;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author kaique.mota
 */
public class PedidoGetByIdTeste {

    private static final int PEDIDO_ID = 2303;
    private static final String REFERENCIA = "REF 015";
    private static final String OBSERVACAO = null;
    private static final String DATA = "05/09/2019 12:16:57.0000";
    private static final String HORA = "12:16:57";
    private static final double VALOR = 10.000;
    private static final String VALOR_FORMAT = "10,00";
    private static final double VALOR_ABERTO = 10.00;
    private static final String VALOR_ABERTO_FORMAT = "10,00";
    private static final double VALOR_ORIGINAL_PAGO = 0.0;
    private static final String VALOR_ORIGINAL_PAGO_FORMAT = "0,00";
    private static final String TIPO = "Interno";
    private static final int QUANTIDADE = 1;
    private static final int QUANTIDADE_TRANSACOES = 0;
    private static final int PEDIDO_STATUS_ID = 15;
    private static final String PEDIDO_STATUS_NOME = "Cancelado";
    private static final int PESSOA_ID = 8149;
    private static final String NOME_RAZAO_SOCIAL = "AUTO GERAL AUTOPECAS LTDA";
    private static final String SOBRENOME_NOME_FANTASIA = "AUTO GERAL AUTOPECAS LTDA";
    private static final String CNPJ_FORMAT = "05.437.537/0001-37";
    private static final String EMAIL = "kaique.motta@autogeral.com.br";
    private static final String ITEM_PRODUTO_ID = "30747";
    private static final int PRODUTO_ID = 2075;
    private static final String PRODUTO_NOME = "Produto genérico";
    private static final String PRODUTO_DESCRICAO = "Produto genérico";
    private static final String PRODUTO_NOME_EXIBE = "Produto ge";
    private static final int PRODUTO_QUANTIDADE = 1;
    private static final String PRODUTO_VALOR = "10.000";
    private static final String PRODUTO_VALOR_FORMAT = "10,00";
    private static final String PRODUTO_FOTO_THUMBNAIL = "http://pay2alldemo.azurewebsites.net/WebAPI/ImagensProdutos/_ProdutoDefault.png";
    private static final String NOTA_FISCAL = null;
    private static final int PEDIDO_FORMA_PAGAMENTO_ID = 702;
    private static final int PEDIDO_FORMA_PAGAMENTO_QUANTIDADE_MAXIMA_PARCELAS = 1;
    private static final String PEDIDO_FORMA_PAGAMENTO_ADQUIRENTE_PADRAO = "";
    private static final int FORMA_PAGAMENTO_ID = 21;
    private static final String FORMA_PAGAMENTO_NOME = "TEF";
    private static final String FORMA_PAGAMENTO_MODALIDADE = "Crédito";
    private static final boolean FORMA_PAGAMENTO_PERMITE_PARCELAMENTO = true;
    private static final boolean FORMA_PAGAMENTO_SOLICITA_OBSERVACAO = false;
    private static final int FORMA_PAGAMENTO_QUANTIADE_MAXIMA_PARCELAS = 12;
    private static final boolean FORMA_PAGAMENTO_ISENTO_DE_TARIFA = true;
    private static final int FLUXO_PAGAMENTO_ID = 21;
    private static final String FLUXO_PAGAMENTO_NOME = "TEF";

    @Test
    public void TEST_SERIALIZE() {
        Pedido p = new Pedido();
        p.setId(PEDIDO_ID);
        p.setReferencia(REFERENCIA);
        p.setObs(OBSERVACAO);
        p.setData(DATA);
        p.setHora(HORA);
        p.setValor(VALOR);
        p.setValorFormat(VALOR_FORMAT);
        p.setValor(VALOR_ABERTO);
        p.setValorAbertoFormat(VALOR_ABERTO_FORMAT);
        p.setValorOriginalPago(VALOR_ORIGINAL_PAGO);
        p.setValorOriginalPagoFormat(VALOR_ORIGINAL_PAGO_FORMAT);
        p.setTipo(TIPO);
        p.setQuantidade(QUANTIDADE);
        p.setQuantidadeTransacoes(QUANTIDADE_TRANSACOES);
        p.setNotaFiscal(NOTA_FISCAL);
        PedidoStatus pedidoStatus = new PedidoStatus();
        pedidoStatus.setId(PEDIDO_STATUS_ID);
        pedidoStatus.setNome(PEDIDO_STATUS_NOME);
        Pessoa pessoa = new Pessoa();
        pessoa.setId(PEDIDO_ID);
        pessoa.setNomeRazaoSocial(NOME_RAZAO_SOCIAL);
        pessoa.setSobrenomeNomeFantasia(SOBRENOME_NOME_FANTASIA);
        pessoa.setCpfCnpj(CNPJ_FORMAT);
        pessoa.setEmail(EMAIL);
        Produto produto = new Produto();
        produto.setId(PRODUTO_ID);
        produto.setNome(PRODUTO_NOME);
        produto.setDescricao(PRODUTO_DESCRICAO);
        produto.setNomeExibe(PRODUTO_NOME_EXIBE);
        produto.setQuantidade(PRODUTO_QUANTIDADE);
        produto.setValor(PRODUTO_VALOR);
        produto.setValorFormat(PRODUTO_VALOR_FORMAT);
        produto.setItemProdutoId(ITEM_PRODUTO_ID);
        produto.setFotoThumbnail(PRODUTO_FOTO_THUMBNAIL);
        PedidoFormaPagamento pedidoFormaPagamento = new PedidoFormaPagamento();
        pedidoFormaPagamento.setQuantidadeMaximaParcelas(PEDIDO_FORMA_PAGAMENTO_QUANTIDADE_MAXIMA_PARCELAS);
        pedidoFormaPagamento.setId(PEDIDO_FORMA_PAGAMENTO_ID);
        pedidoFormaPagamento.setAdquirente(PEDIDO_FORMA_PAGAMENTO_ADQUIRENTE_PADRAO);
        FormaPagamento formaPagamento = new FormaPagamento();
        formaPagamento.setId(FORMA_PAGAMENTO_ID);
        formaPagamento.setNome(FORMA_PAGAMENTO_NOME);
        formaPagamento.setModalidade(FORMA_PAGAMENTO_MODALIDADE);
        formaPagamento.setPermiteParcelamento(FORMA_PAGAMENTO_PERMITE_PARCELAMENTO);
        formaPagamento.setSolicitaObs(FORMA_PAGAMENTO_SOLICITA_OBSERVACAO);
        formaPagamento.setQuantidadeMaximaParcelas(FORMA_PAGAMENTO_QUANTIADE_MAXIMA_PARCELAS);
        formaPagamento.setIsentoDeTarifa(FORMA_PAGAMENTO_ISENTO_DE_TARIFA);
        FluxoPagamento fluxoPagamento = new FluxoPagamento();
        fluxoPagamento.setId(FLUXO_PAGAMENTO_ID);
        fluxoPagamento.setNome(FLUXO_PAGAMENTO_NOME);
    }

    @Test
    public void TEST_PARSE_DATA() {

        String toParse = "{\n"
                + "    \"data\": \"19/09/2019 12:17:51.1920\",\n"
                + "    \"pedido\": {\n"
                + "        \"id\": 2303,\n"
                + "        \"referencia\": \"REF 015\",\n"
                + "        \"obs\": null,\n"
                + "        \"data\": \"05/09/2019 12:16:57.0000\",\n"
                + "        \"hora\": \"12:16:57\",\n"
                + "        \"valor\": 10.0000,\n"
                + "        \"valorFormat\": \"10,00\",\n"
                + "        \"valorAberto\": 10.0000,\n"
                + "        \"valorAbertoFormat\": \"10,00\",\n"
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
                + "                \"itemProdutoId\": 30747,\n"
                + "                \"id\": 2075,\n"
                + "                \"nome\": \"Produto genérico\",\n"
                + "                \"descricao\": \"Produto genérico\",\n"
                + "                \"nomeExibe\": \"Produto ge\",\n"
                + "                \"quantidade\": 1,\n"
                + "                \"valor\": 10.000,\n"
                + "                \"valorFormat\": \"10,00\",\n"
                + "                \"fotoThumbnail\": \"http://pay2alldemo.azurewebsites.net/WebAPI/ImagensProdutos/_ProdutoDefault.png\"\n"
                + "            }\n"
                + "        ],\n"
                + "        \"notaFiscal\": null,\n"
                + "        \"intencoesVenda\": [],\n"
                + "        \"pedidoFormasPagamento\": [\n"
                + "            {\n"
                + "                \"id\": 702,\n"
                + "                \"quantidadeMaximaParcelas\": 1,\n"
                + "                \"adquirentePadrao\": \"\",\n"
                + "                \"formaPagamento\": {\n"
                + "                    \"id\": 21,\n"
                + "                    \"nome\": \"TEF\",\n"
                + "                    \"modalidade\": \"Crédito\",\n"
                + "                    \"permiteParcelamento\": true,\n"
                + "                    \"solicitaObs\": false,\n"
                + "                    \"quantidadeMaximaParcelas\": 12,\n"
                + "                    \"isentoDeTarifa\": true,\n"
                + "                    \"fluxoPagamento\": {\n"
                + "                        \"id\": 21,\n"
                + "                        \"nome\": \"TEF\"\n"
                + "                    }\n"
                + "                }\n"
                + "            }\n"
                + "        ]\n"
                + "    }\n"
                + "}";
        Data d = WsHelper.unmarshal(toParse, Data.class);
        assertNotNull(d);
        assertNotNull(d.getPedido());
        Pedido p = d.getPedido();
        TEST_DATA_PEDIDO(p);
    }

    
    private void TEST_DATA_PEDIDO(Pedido p) {
        assertNotNull(p);
        assertEquals(PEDIDO_ID, p.getId());
        assertEquals(REFERENCIA, p.getReferencia());
        assertEquals(OBSERVACAO, p.getObs());
        assertEquals(DATA, p.getData());
        assertEquals(HORA, p.getHora());
        assertEquals(VALOR, p.getValor(), 0D);
        assertEquals(VALOR_FORMAT, p.getValorFormat());
        assertEquals(VALOR_ABERTO, p.getValorAberto(), 0D);
        assertEquals(VALOR_ABERTO_FORMAT, p.getValorAbertoFormat());
        assertEquals(VALOR_ORIGINAL_PAGO, p.getValorOriginalPago(), 0D);
        assertEquals(VALOR_ORIGINAL_PAGO_FORMAT, p.getValorOriginalPagoFormat());
        assertEquals(TIPO, p.getTipo());
        assertEquals(QUANTIDADE, p.getQuantidade());
        assertEquals(QUANTIDADE_TRANSACOES, p.getQuantidadeTransacoes());
        assertEquals(PEDIDO_STATUS_ID, p.getPedidoStatus().getId());
        assertEquals(PEDIDO_STATUS_NOME, p.getPedidoStatus().getNome());
        assertEquals(PESSOA_ID, p.getPessoa().getId());
        assertEquals(NOME_RAZAO_SOCIAL, p.getPessoa().getNomeRazaoSocial());
        assertEquals(SOBRENOME_NOME_FANTASIA, p.getPessoa().getSobrenomeNomeFantasia());
        assertEquals(CNPJ_FORMAT, p.getPessoa().getCpfCnpjFormat());
        assertEquals(EMAIL, p.getPessoa().getEmail());
        assertNotNull(p.getProdutos());
        Produto produto = p.getProdutos().get(0);
        assertEquals(PRODUTO_ID, p.getProdutos().get(0).getId());
        assertEquals(PRODUTO_NOME, p.getProdutos().get(0).getNome());
        assertEquals(PRODUTO_NOME_EXIBE, produto.getNomeExibe());
        assertEquals(PRODUTO_QUANTIDADE, produto.getQuantidade());
        assertEquals(PRODUTO_VALOR, produto.getValor());
        assertEquals(PRODUTO_VALOR_FORMAT, produto.getValorFormat());
        assertEquals(PRODUTO_FOTO_THUMBNAIL, produto.getFotoThumbnail());
    }
}

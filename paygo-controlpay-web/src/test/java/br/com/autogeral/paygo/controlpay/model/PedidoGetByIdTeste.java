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
    private static final double VALOR_ORIGINAL_EM_PAGAMENTO = 0.0;
    private static final String VALOR_ORIGINAL_EM_PAGAMENTO_FORMAT = "0,00";
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
    public void testSerialize() {
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
        p.setValorOriginalEmPagamento(VALOR_ORIGINAL_EM_PAGAMENTO);
        p.setValorOriginalEmPagamentoFormat(VALOR_ORIGINAL_EM_PAGAMENTO_FORMAT);
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
    public void testParse() {
    
    }

    @Test
    public void testParseData() {

        String toParse = "{\n"
                + "    \"data\": \"" + DATA + "\",\n"
                + "    \"pedido\": {\n"
                + "        \"id\": " + PEDIDO_ID + ",\n"
                + "        \"referencia\": \"" + REFERENCIA + "\",\n"
                + "        \"obs\": " + OBSERVACAO + ",\n"
                + "        \"data\": \"" + DATA + "\",\n"
                + "        \"hora\": \"" + HORA + "\",\n"
                + "        \"valor\": " + VALOR + ",\n"
                + "        \"valorFormat\": \"" + VALOR_FORMAT + "\",\n"
                + "        \"valorAberto\": " + VALOR_ABERTO + ",\n"
                + "        \"valorAbertoFormat\": \"" + VALOR_ABERTO_FORMAT + "\",\n"
                + "        \"valorOriginalPago\": " + VALOR_ORIGINAL_PAGO + ",\n"
                + "        \"valorOriginalPagoFormat\": \"" + VALOR_ORIGINAL_PAGO_FORMAT + "\",\n"
                + "        \"valorOriginalEmPagamento\": " + VALOR_ORIGINAL_EM_PAGAMENTO + ",\n"
                + "        \"valorOriginalEmPagamentoFormat\": \"" + VALOR_ORIGINAL_EM_PAGAMENTO_FORMAT + "\",\n"
                + "        \"tipo\": \"" + TIPO + "\",\n"
                + "        \"quantidade\": " + QUANTIDADE + ",\n"
                + "        \"quantidadeTransacoes\": " + QUANTIDADE_TRANSACOES + ",\n"
                + "        \"pedidoStatus\": {\n"
                + "            \"id\": " + PEDIDO_STATUS_ID + ",\n"
                + "            \"nome\": \"" + PEDIDO_STATUS_NOME + "\"\n"
                + "        },\n"
                + "        \"pessoa\": {\n"
                + "            \"id\": " + PESSOA_ID + ",\n"
                + "            \"nomeRazaoSocial\": \"" + NOME_RAZAO_SOCIAL + "\",\n"
                + "            \"sobrenomeNomeFantasia\": \"" + SOBRENOME_NOME_FANTASIA + "\",\n"
                + "            \"cpfCnpjFormat\": \"" + CNPJ_FORMAT + "\",\n"
                + "            \"email\": \"" + EMAIL + "\"\n"
                + "        },\n"
                + "        \"produtos\": [\n"
                + "            {\n"
                + "                \"itemProdutoId\": " + ITEM_PRODUTO_ID + ",\n"
                + "                \"id\": " + PRODUTO_ID + ",\n"
                + "                \"nome\": \"" + PRODUTO_NOME + "\",\n"
                + "                \"descricao\": \"" + PRODUTO_DESCRICAO + "\",\n"
                + "                \"nomeExibe\": \"" + PRODUTO_NOME_EXIBE + "\",\n"
                + "                \"quantidade\": " + PRODUTO_QUANTIDADE + ",\n"
                + "                \"valor\": " + PRODUTO_VALOR + ",\n"
                + "                \"valorFormat\": \"" + PRODUTO_VALOR_FORMAT + "\",\n"
                + "                \"fotoThumbnail\": \"" + PRODUTO_FOTO_THUMBNAIL + "\"\n"
                + "            }\n"
                + "        ],\n"
                + "        \"notaFiscal\": " + NOTA_FISCAL + ",\n"
                + "        \"intencoesVenda\": [],\n"
                + "        \"pedidoFormasPagamento\": [\n"
                + "            {\n"
                + "                \"id\": " + PEDIDO_FORMA_PAGAMENTO_ID + ",\n"
                + "                \"quantidadeMaximaParcelas\": " + PEDIDO_FORMA_PAGAMENTO_QUANTIDADE_MAXIMA_PARCELAS + ",\n"
                + "                \"adquirentePadrao\": \"" + PEDIDO_FORMA_PAGAMENTO_ADQUIRENTE_PADRAO + "\",\n"
                + "                \"formaPagamento\": {\n"
                + "                    \"id\": " + FORMA_PAGAMENTO_ID + ",\n"
                + "                    \"nome\": \"" + FORMA_PAGAMENTO_NOME + "\",\n"
                + "                    \"modalidade\": \"" + FORMA_PAGAMENTO_MODALIDADE + "\",\n"
                + "                    \"permiteParcelamento\": " + FORMA_PAGAMENTO_PERMITE_PARCELAMENTO + ",\n"
                + "                    \"solicitaObs\": " + FORMA_PAGAMENTO_SOLICITA_OBSERVACAO + ",\n"
                + "                    \"quantidadeMaximaParcelas\": " + FORMA_PAGAMENTO_QUANTIADE_MAXIMA_PARCELAS + ",\n"
                + "                    \"isentoDeTarifa\": " + FORMA_PAGAMENTO_ISENTO_DE_TARIFA + ",\n"
                + "                    \"fluxoPagamento\": {\n"
                + "                        \"id\": " + FLUXO_PAGAMENTO_ID + ",\n"
                + "                        \"nome\": \"" + FLUXO_PAGAMENTO_NOME + "\"\n"
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
        testDataPedido(p);
    }

    private void testDataPedido(Pedido p) {
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
        assertEquals(VALOR_ORIGINAL_EM_PAGAMENTO, p.getValorOriginalEmPagamento(), 0.00);
        assertEquals(VALOR_ORIGINAL_EM_PAGAMENTO_FORMAT, p.getValorOriginalEmPagamentoFormat());
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
        assertEquals(NOTA_FISCAL, p.getNotaFiscal());
        assertEquals(PEDIDO_FORMA_PAGAMENTO_ID, p.getPedidoFormasPagamento().get(0).getId());
        assertEquals(PEDIDO_FORMA_PAGAMENTO_QUANTIDADE_MAXIMA_PARCELAS, p.getPedidoFormasPagamento().get(0).getQuantidadeMaximaParcelas());
        assertEquals(PEDIDO_FORMA_PAGAMENTO_ADQUIRENTE_PADRAO, p.getPedidoFormasPagamento().get(0).getAdquirentePadrao());
        assertEquals(FORMA_PAGAMENTO_ID, p.getPedidoFormasPagamento().get(0).getFormaPagamento().getId());
        assertEquals(FORMA_PAGAMENTO_NOME, p.getPedidoFormasPagamento().get(0).getFormaPagamento().getNome());
        assertEquals(FORMA_PAGAMENTO_MODALIDADE, p.getPedidoFormasPagamento().get(0).getFormaPagamento().getModalidade());
        assertEquals(FORMA_PAGAMENTO_PERMITE_PARCELAMENTO, p.getPedidoFormasPagamento().get(0).getFormaPagamento().isPermiteParcelamento());
        assertEquals(FORMA_PAGAMENTO_SOLICITA_OBSERVACAO, p.getPedidoFormasPagamento().get(0).getFormaPagamento().isSolicitaObs());
        assertEquals(FORMA_PAGAMENTO_QUANTIADE_MAXIMA_PARCELAS, p.getPedidoFormasPagamento().get(0).getFormaPagamento().getQuantidadeMaximaParcelas());
        assertEquals(FORMA_PAGAMENTO_ISENTO_DE_TARIFA, p.getPedidoFormasPagamento().get(0).getFormaPagamento().isIsentoDeTarifa());
        assertEquals(FLUXO_PAGAMENTO_ID, p.getPedidoFormasPagamento().get(0).getFormaPagamento().getFluxoPagamento().getId());
        assertEquals(FLUXO_PAGAMENTO_NOME, p.getPedidoFormasPagamento().get(0).getFormaPagamento().getFluxoPagamento().getNome());
    }
}

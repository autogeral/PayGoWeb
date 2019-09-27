package br.com.autogeral.paygo.controlpay.model;

import br.com.autogeral.paygo.controlpay.web.WsHelper;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author kaique.mota
 */
public class ProdutoInsertTeste {

    private static final int PRODUTO_ID = 5572;
    private static final String PRODUTO_NOME = "Produto A";
    private static final String PRODUTO_DESCRICAO = "Descrição do produto A";
    private static final boolean CONTROLE_QUALIDADE = false;
    private static final boolean SOLICITA_VALOR = true;
    private static final String PRODUTO_TIPO = "10";
    private static final int PRODUTO_STATUS_ID = 5;
    private static final String PRODUTO_STATUS_NOME = "Ativo";
    private static final String FOTO_NOME = "";
    private static final String FOTO_BASE_64 = "";
    private static final int PRODUTO_QUANTIDADE = 1;
    private static final String PRODUTO_VALOR = "300";
    private static final boolean SERVICO = true;
    private static final String FOTO_THUMBNAIL = "http://pay2alldemo.azurewebsites.net/WebAPI/ImagensProdutos/_ProdutoDefault.png";
    private static final String EAN = null;
    private static final String NCM = null;
    private static final String CFOP = null;
    private static final String EXTIPI = null;
    private static final String ORIGEM = null;
    private static final String UNIDADE_TRIBUTARIA = null;
    private static final int QUANTIDADE_TRIBUTARIA = 0;
    private static final String UNIDADE_COMERCIAL = null;
    private static final int QUANTIDADE_COMERCIAL = 0;
    private static final String INFORMACOES_COMPLEMENTARES = null;
    private static final String PRODUTO_IMPOSTO = null;

    @Test
    public void testSerialize() {
        Produto p = new Produto();
        p.setNome(PRODUTO_NOME);
        p.setDescricao(PRODUTO_DESCRICAO);
        p.setQuantidade(PRODUTO_QUANTIDADE);
        p.setControlaQuantidade(CONTROLE_QUALIDADE);
        p.setSolicitaValor(SOLICITA_VALOR);
        p.setProdutoTipo(PRODUTO_TIPO);
        ProdutoStatus ps = new ProdutoStatus();
        ps.setId(PRODUTO_STATUS_ID);
        ps.setNome(PRODUTO_STATUS_NOME);
        p.setProdutoStatus(ps);
        p.setFotoNome(FOTO_NOME);
        p.setFotBase64(FOTO_BASE_64);
        p.setServico(SERVICO);
        p.setEan(EAN);
        p.setNcm(NCM);
        p.setCfop(CFOP);
        p.setExtipi(EXTIPI);
        p.setOrigem(ORIGEM);
        p.setUnidadeTributaria(UNIDADE_TRIBUTARIA);
        p.setQuantidadeTributaria(QUANTIDADE_TRIBUTARIA);
        p.setUnidadeComercial(UNIDADE_COMERCIAL);
        p.setQuantidadeComercial(QUANTIDADE_COMERCIAL);
        p.setInformacoesComplementares(INFORMACOES_COMPLEMENTARES);
        p.setProdutoImposto(PRODUTO_IMPOSTO);

    }

    @Test
    public void testParse() {
        String toParse = "{\n"
                + "	\"nome\":\"" + PRODUTO_NOME + "\",\n"
                + "	\"descricao\":\"" + PRODUTO_DESCRICAO + "\",\n"
                + "	\"controlaQuantidade\":\"" + CONTROLE_QUALIDADE + "\",\n"
                + "	\"solicitaValor\":\"" + SOLICITA_VALOR + "\",\n"
                + "	\"produtoTipo\":\"" + PRODUTO_TIPO + "\",\n"
                + "	\"produtoStatus\":{\n"
                + "	    \"id\":\"" + PRODUTO_STATUS_ID + "\",\n"
                + "	    \"nome\":\"" + PRODUTO_STATUS_NOME + "\"\n"
                + "	},\n"
                + "	\"fotoNome\":\"" + FOTO_NOME + "\",\n"
                + "	\"fotBase64\":\"" + FOTO_BASE_64 + "\"\n"
                + "}";

        Produto p = WsHelper.unmarshal(toParse, Produto.class);
        testProdutoPadrao(p);
    }

    @Test
    public void testParseData() {
        String toParse = "{\n"
                + "  \"produto\": {\n"
                + "    \"id\": " + PRODUTO_ID + ",\n"
                + "    \"nome\": \"" + PRODUTO_NOME + "\",\n"
                + "    \"descricao\": \"" + PRODUTO_DESCRICAO + "\",\n"
                + "    \"fotoThumbnail\": \"" + FOTO_THUMBNAIL + "\",\n"
                + "    \"valor\": \"" + PRODUTO_VALOR + "\",\n"
                + "    \"solicitaValor\": " + SOLICITA_VALOR + ",\n"
                + "    \"quantidade\": " + PRODUTO_QUANTIDADE + ",\n"
                + "    \"controlaQuantidade\": " + CONTROLE_QUALIDADE + ",\n"
                + "    \"produtoTipo\": " + PRODUTO_TIPO + ",\n"
                + "    \"servico\": " + SERVICO + ",\n"
                + "    \"ean\": " + EAN + ",\n"
                + "    \"ncm\": " + NCM + ",\n"
                + "    \"cfop\": " + CFOP + ",\n"
                + "    \"extipi\": " + EXTIPI + ",\n"
                + "    \"origem\": " + ORIGEM + ",\n"
                + "    \"unidadeTributaria\": " + UNIDADE_TRIBUTARIA + ",\n"
                + "    \"quantidadeTributaria\": " + QUANTIDADE_TRIBUTARIA + ",\n"
                + "    \"unidadeComercial\": " + UNIDADE_COMERCIAL + ",\n"
                + "    \"quantidadeComercial\": " + QUANTIDADE_COMERCIAL + ",\n"
                + "    \"informacoesComplementares\": " + INFORMACOES_COMPLEMENTARES + ",\n"
                + "    \"produtoImposto\": " + PRODUTO_IMPOSTO + ",\n"
                + "    \"produtoStatus\": {\n"
                + "      \"id\": " + PRODUTO_STATUS_ID + ",\n"
                + "      \"nome\": \"" + PRODUTO_STATUS_NOME + "\"\n"
                + "    }\n"
                + "  }\n"
                + "}";
        Data d = WsHelper.unmarshal(toParse, Data.class);
        assertNotNull(d);
        assertNotNull(d.getProduto());
        Produto p = d.getProduto();
        testProdutoParse(p);
    }

    private void testProdutoParse(Produto produto) {
        assertNotNull(produto);
        assertEquals(PRODUTO_ID, produto.getId());
        assertEquals(PRODUTO_NOME, produto.getNome());
        assertEquals(PRODUTO_DESCRICAO, produto.getDescricao());
        assertEquals(PRODUTO_VALOR, produto.getValor());
        assertEquals(SOLICITA_VALOR, produto.isSolicitaValor());
        assertEquals(PRODUTO_QUANTIDADE, produto.getQuantidade());
        assertEquals(CONTROLE_QUALIDADE, produto.getControlaQuantidade());
        assertEquals(PRODUTO_TIPO, produto.getProdutoTipo());
        assertEquals(SERVICO, produto.isServico());
        assertEquals(FOTO_THUMBNAIL, produto.getFotoThumbnail());
        assertEquals(EAN, produto.getEan());
        assertEquals(NCM, produto.getNcm());
        assertEquals(CFOP, produto.getCfop());
        assertEquals(EXTIPI, produto.getExtipi());
        assertEquals(ORIGEM, produto.getOrigem());
        assertEquals(PRODUTO_IMPOSTO, produto.getProdutoImposto());
        assertEquals(PRODUTO_STATUS_ID, produto.getProdutoStatus().getId());
        assertEquals(PRODUTO_STATUS_NOME, produto.getProdutoStatus().getNome());

    }

    private void testProdutoPadrao(Produto produto) {
        assertNotNull(produto);
        assertEquals(PRODUTO_NOME, produto.getNome());
        assertEquals(CONTROLE_QUALIDADE, produto.getControlaQuantidade());
        assertEquals(SOLICITA_VALOR, produto.isSolicitaValor());
        assertEquals(PRODUTO_TIPO, produto.getProdutoTipo());
        ProdutoStatus prod = produto.getProdutoStatus();
        assertEquals(PRODUTO_STATUS_ID, prod.getId());
        assertEquals(PRODUTO_STATUS_NOME, prod.getNome());
    }
}

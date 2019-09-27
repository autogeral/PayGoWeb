package br.com.autogeral.paygo.controlpay.model;

import br.com.autogeral.paygo.controlpay.web.WsHelper;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Murilo Moraes Tuvani
 */
public class ProdutoTest {

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
    private static final String REFERENCIA = null;
    private static final String EAN = null;
    private static final int PRODUTO_CATEGORIA_ID = 1029;
    private static final String PRODUTO_CATEGORIA_STATUS_NOME = "Default";

    @Test
    public void test_serialize() {
        Produto p = new Produto();
        p.setNome(PRODUTO_NOME);
        p.setDescricao(PRODUTO_DESCRICAO);
        p.setControlaQuantidade(CONTROLE_QUALIDADE);
        p.setSolicitaValor(SOLICITA_VALOR);
        p.setProdutoTipo(PRODUTO_TIPO);
        ProdutoStatus ps = new ProdutoStatus();
        ps.setId(PRODUTO_STATUS_ID);
        ps.setNome(PRODUTO_STATUS_NOME);
        p.setProdutoStatus(ps);
        p.setFotoNome(FOTO_NOME);
        p.setFotBase64(FOTO_BASE_64);
        String result = WsHelper.marshal(p);
        System.out.println(result);
    }

    /**
     * Test of setValor method, of class Produto.
     */
    @Test
    public void test_parse() {
        String toParse = "{\n"
                + "	\"nome\":\""+PRODUTO_NOME+"\",\n"
                + "	\"descricao\":\""+PRODUTO_DESCRICAO+"\",\n"
                + "	\"controlaQuantidade\":\""+CONTROLE_QUALIDADE+"\",\n"
                + "	\"solicitaValor\":\""+SOLICITA_VALOR+"\",\n"
                + "	\"produtoTipo\":\""+PRODUTO_TIPO+"\",\n"
                + "	\"produtoStatus\":{\n"
                + "	    \"id\":\""+PRODUTO_STATUS_ID+"\",\n"
                + "	    \"nome\":\""+PRODUTO_STATUS_NOME+"\"\n"
                + "	},\n"
                + "	\"fotoNome\":\""+FOTO_NOME+"\",\n"
                + "	\"fotBase64\":\""+FOTO_BASE_64+"\"\n"
                + "}";

        Produto p = WsHelper.unmarshal(toParse, Produto.class);
        testProdutoPadrao(p);

    }

    @Test
    public void test_parse_data() {
        String toParse = "{\n"
                + "	\"produto\":{\n"
                + "		\"nome\":\""+PRODUTO_NOME+"\",\n"
                + "		\"descricao\":\""+PRODUTO_DESCRICAO+"\",\n"
                + "		\"controlaQuantidade\":\""+CONTROLE_QUALIDADE+"\",\n"
                + "		\"solicitaValor\":\""+SOLICITA_VALOR+"\",\n"
                + "		\"produtoTipo\":\""+PRODUTO_TIPO+"\",\n"
                + "		\"produtoStatus\":{\n"
                + "		    \"id\":\""+PRODUTO_STATUS_ID+"\",\n"
                + "		    \"nome\":\""+PRODUTO_STATUS_NOME+"\"\n"
                + "		},\n"
                + "		\"fotoNome\":\""+FOTO_NOME+"\",\n"
                + "		\"fotBase64 \":\""+FOTO_BASE_64+"\"\n"
                + "	}\n"
                + "}\n"
                + "";

        Data d = WsHelper.unmarshal(toParse, Data.class);
        assertNotNull(d);
        assertNotNull(d.getProduto());
        Produto p = d.getProduto();
        testProdutoPadrao(p);
    }

    @Test
    public void testParseDataReal() {
        String toParse = "{\n"
                + "    \"data\": \"26/09/2019 16:17:22.6497\",\n"
                + "    \"produtos\": [\n"
                + "        {\n"
                + "            \"id\": " + PRODUTO_ID + ",\n"
                + "            \"nome\": \"" + PRODUTO_NOME + "\",\n"
                + "            \"descricao\": \"" + PRODUTO_DESCRICAO + "\",\n"
                + "            \"valor\": \"" + PRODUTO_VALOR + "\",\n"
                + "            \"solicitaValor\": " + SOLICITA_VALOR + ",\n"
                + "            \"quantidade\": " + PRODUTO_QUANTIDADE + ",\n"
                + "            \"controlaQuantidade\": " + CONTROLE_QUALIDADE + ",\n"
                + "            \"produtoTipo\": " + PRODUTO_TIPO + ",\n"
                + "            \"servico\": " + SERVICO + ",\n"
                + "            \"fotoThumbnail\": \"" + FOTO_THUMBNAIL + "\",\n"
                + "            \"ean\": " + EAN + ",\n"
                + "            \"referencia\": " + REFERENCIA + ",\n"
                + "            \"produtoStatus\": {\n"
                + "                \"id\": " + PRODUTO_STATUS_ID + ",\n"
                + "                \"nome\": \"" + PRODUTO_STATUS_NOME + "\"\n"
                + "            },\n"
                + "            \"produtoCategoria\": {\n"
                + "                \"id\": " + PRODUTO_CATEGORIA_ID + ",\n"
                + "                \"nome\": \"" + PRODUTO_CATEGORIA_STATUS_NOME + "\"\n"
                + "            }\n"
                + "        },\n"
                + "        {\n"
                + "            \"id\": " + PRODUTO_ID + ",\n"
                + "            \"nome\": \"" + PRODUTO_NOME + "\",\n"
                + "            \"descricao\": \"" + PRODUTO_DESCRICAO + "\",\n"
                + "            \"valor\": \"" + PRODUTO_VALOR + "\",\n"
                + "            \"solicitaValor\": " + SOLICITA_VALOR + ",\n"
                + "            \"quantidade\": " + PRODUTO_QUANTIDADE + ",\n"
                + "            \"controlaQuantidade\": " + CONTROLE_QUALIDADE + ",\n"
                + "            \"produtoTipo\": " + PRODUTO_TIPO + ",\n"
                + "            \"servico\": " + SERVICO + ",\n"
                + "            \"fotoThumbnail\": \"" + FOTO_THUMBNAIL + "\",\n"
                + "            \"ean\": \"" + EAN + "\",\n"
                + "            \"referencia\": \"" + REFERENCIA + "\",\n"
                + "            \"produtoStatus\": {\n"
                + "                \"id\": " + PRODUTO_STATUS_ID + ",\n"
                + "                \"nome\": \"" + PRODUTO_STATUS_NOME + "\"\n"
                + "            },\n"
                + "            \"produtoCategoria\": {\n"
                + "                \"id\": " + PRODUTO_CATEGORIA_ID + ",\n"
                + "                \"nome\": \"" + PRODUTO_CATEGORIA_STATUS_NOME + "\"\n"
                + "            }\n"
                + "        }\n"
                + "    ]\n"
                + "}";

        Data d = WsHelper.unmarshal(toParse, Data.class);
        assertNotNull(d);
        List<Produto> produto = d.getProdutos();
        testProdutoData(produto);
    }

    private void testProdutoData(List<Produto> produto) {
        assertNotNull(produto);
        assertEquals(PRODUTO_ID, produto.get(0).getId());
        assertEquals(PRODUTO_NOME, produto.get(0).getNome());
        assertEquals(PRODUTO_DESCRICAO, produto.get(0).getDescricao());
        assertEquals(PRODUTO_VALOR, produto.get(0).getValor());
        assertEquals(SOLICITA_VALOR, produto.get(0).isSolicitaValor());
        assertEquals(PRODUTO_QUANTIDADE, produto.get(0).getQuantidade());
        assertEquals(CONTROLE_QUALIDADE, produto.get(0).getControlaQuantidade());
        assertEquals(PRODUTO_TIPO, produto.get(0).getProdutoTipo());
        assertEquals(SERVICO, produto.get(0).isServico());
        assertEquals(FOTO_THUMBNAIL, produto.get(0).getFotoThumbnail());
        assertEquals(EAN, produto.get(0).getEan());
        assertEquals(REFERENCIA, produto.get(0).getReferencia());
        assertEquals(PRODUTO_STATUS_ID, produto.get(0).getProdutoStatus().getId());
        assertEquals(PRODUTO_STATUS_NOME,produto.get(0).getProdutoStatus().getNome());
        assertEquals(PRODUTO_CATEGORIA_ID,produto.get(0).getProdutoCategoria().getId());
        assertEquals(PRODUTO_CATEGORIA_STATUS_NOME,produto.get(0).getProdutoCategoria().getNome());
    }

    private void testProdutoPadrao(Produto p) {
        assertNotNull(p);
        assertEquals(PRODUTO_NOME, p.getNome());
        assertEquals(PRODUTO_DESCRICAO, p.getDescricao());
        assertEquals(CONTROLE_QUALIDADE, p.getControlaQuantidade());
        assertEquals(SOLICITA_VALOR, p.isSolicitaValor());
        assertEquals(PRODUTO_TIPO, p.getProdutoTipo());
        assertNotNull(p.getProdutoStatus());
        ProdutoStatus ps = p.getProdutoStatus();
        assertEquals(PRODUTO_STATUS_ID, ps.getId());
        assertEquals(PRODUTO_STATUS_NOME, ps.getNome());
        assertEquals(FOTO_NOME, p.getFotoNome());
    }

}

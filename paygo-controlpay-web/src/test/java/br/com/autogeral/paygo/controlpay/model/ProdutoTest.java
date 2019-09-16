/*
 * The MIT License
 *
 * Copyright 2019 Murilo Moraes Tuvani.
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
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Murilo Moraes Tuvani
 */
public class ProdutoTest {

    
   
    private static final String PRODUTO_NOME = "Produto A";
    private static final String PRODUTO_DESCRICAO = "Descrição do produto A";
    private static final boolean CONTROLE_QUALIDADE = false;
    private static final boolean SOLICITA_VALOR = true;
    private static final String PRODUTO_TIPO = "10";
    private static final int PRODUTO_STATUS_ID = 5;
    private static final String PRODUTO_STATUS_NOME = "Ativo";
    private static final String FOTO_NOME = "";
    private static final String FOTO_BASE_64 = "";

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
                + "	\"nome\":\"Produto A\",\n"
                + "	\"descricao\":\"Descrição do produto A\",\n"
                + "	\"controlaQuantidade\":\"false\",\n"
                + "	\"solicitaValor\":\"true\",\n"
                + "	\"produtoTipo\":\"10\",\n"
                + "	\"produtoStatus\":{\n"
                + "	    \"id\":\"5\",\n"
                + "	    \"nome\":\"Ativo\"\n"
                + "	},\n"
                + "	\"fotoNome\":\"\",\n"
                + "	\"fotBase64\":\"\"\n"
                + "}";

        Produto p = WsHelper.unmarshal(toParse, Produto.class);
        testProdutoPadrao(p);

    }

    @Test
    public void test_parse_data() {
        String toParse = "{\n"
                + "	\"produto\":{\n"
                + "		\"nome\":\"Produto A\",\n"
                + "		\"descricao\":\"Descrição do produto A\",\n"
                + "		\"controlaQuantidade\":\"false\",\n"
                + "		\"solicitaValor\":\"true\",\n"
                + "		\"produtoTipo\":\"10\",\n"
                + "		\"produtoStatus\":{\n"
                + "		    \"id\":\"5\",\n"
                + "		    \"nome\":\"Ativo\"\n"
                + "		},\n"
                + "		\"fotoNome\":\"\",\n"
                + "		\"fotBase64\":\"\"\n"
                + "	}\n"
                + "}\n"
                + "";

        Data d = WsHelper.unmarshal(toParse, Data.class);
        assertNotNull(d);
        assertNotNull(d.getProduto());
        Produto p = d.getProduto();
        testProdutoPadrao(p);
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
        assertEquals(FOTO_BASE_64, p.getFotBase64());
    }

}

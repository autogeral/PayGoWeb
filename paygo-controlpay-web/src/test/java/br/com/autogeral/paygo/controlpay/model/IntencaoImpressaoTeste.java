/*
 * The MIT License
 *
 * Copyright 2019 kaique.mota.
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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author kaique.mota
 */
public class IntencaoImpressaoTeste {

    private static final int INTENCAO_IMPRESSAO_ID = 31;
    private static final String DATA = "06/02/2017";
    private static final String CONTEUDO = "";
    private static final String REFERENCIA = null;
    private static final int IMPRESSAO_ID = 15;
    private static final String NOME = "Caixa 1";
    private static final int TEMPLATE_ID = 4;
    private static final String TEMPLATE_NOME = "Elgin -i9";
    private static final int QUANTIDADE_COLUNAS = 80;
    private static final int QUANTIDADE_LINHAS_PRE = 0;
    private static final int QUANTIDADE_LINHASPOS = 2;
    private static final String COMANDO_PRE = "27;64;27;33;1";
    private static final String COMANDO_POS = null;
    private static final int IMPRESSAO_STATUS_ID = 15;
    private static final String IMPRESSAO_STATUS_NOME = "Impresso";

    @Test
    public void testSerialize() {
        IntencaoImpressao ii = new IntencaoImpressao();
        ii.setId(INTENCAO_IMPRESSAO_ID);
        ii.setData(DATA);
        ii.setConteudo(CONTEUDO);
        ii.setReferencia(REFERENCIA);
        Impressora imp = new Impressora();
        imp.setId(IMPRESSAO_ID);
        imp.setNome(NOME);
        ImpressoraTemplate it = new ImpressoraTemplate();
        it.setId(TEMPLATE_ID);
        it.setNome(TEMPLATE_NOME);
        it.setQuantidadeColunas(QUANTIDADE_COLUNAS);
        it.setQuantidadeLinhasPos(QUANTIDADE_LINHASPOS);
        it.setQuantidadeLinhasPre(QUANTIDADE_LINHAS_PRE);
        it.setComandoPre(COMANDO_PRE);
        it.setComandoPos(COMANDO_POS);
        IntencaoVendaStatus ivs = new IntencaoVendaStatus();
        ivs.setId(IMPRESSAO_STATUS_ID);
        ivs.setNome(IMPRESSAO_STATUS_NOME);

    }

    @Test
    public void testParseData() {

        String toParse = "{\n"
                + "    \"data\": \"30/09/2019 14:23:55.3942\",\n"
                + "    \"intencaoImpressao\": {\n"
                + "        \"id\": " + INTENCAO_IMPRESSAO_ID + ",\n"
                + "        \"data\": \"" + DATA + "\",\n"
                + "        \"conteudo\": \"    \\r\\n           COMPROVANTE DE TEF\\r\\n              VIA: CLIENTE\\r\\n    \\r\\n        ESTABELECIMENTO DE TESTE\\r\\n    823982346832235/03876463\\r\\n    \\r\\n    06/02/2017              19:34:40\\r\\n    REF.FISCAL:nfe-4-1\\r\\n    DOC:009391        AUTORIZ:013864\\r\\n    REF.HOST:19344005429\\r\\n    \\r\\n    DEMOCARD        ************2106\\r\\n    VENDA CREDITO A VISTA\\r\\n    VALOR FINAL: R$ 10,00\\r\\n    \\r\\n    \\r\\n           COMPROVANTE DE TEF\\r\\n          VIA: ESTABELECIMENTO\\r\\n    \\r\\n        ESTABELECIMENTO DE TESTE\\r\\n    823982346832235/03876463\\r\\n    \\r\\n    06/02/2017              19:34:40\\r\\n    REF.FISCAL:nfe-4-1\\r\\n    DOC:009391        AUTORIZ:013864\\r\\n    REF.HOST:19344005429\\r\\n    \\r\\n    DEMOCARD        ************2106\\r\\n    VENDA CREDITO A VISTA\\r\\n    VALOR FINAL: R$ 10,00\\r\\n    \\r\\n    \\r\\n    ________________________________\\r\\n       MICHELE BERGMANN MATTOSO  \\r\\n    \\r\",\n"
                + "        \"referencia\": " + REFERENCIA + ",\n"
                + "        \"impressora\": {\n"
                + "            \"id\": " + IMPRESSAO_ID + ",\n"
                + "            \"nome\": \"" + NOME + "\",\n"
                + "            \"impressoraTemplate\": {\n"
                + "                \"id\": " + TEMPLATE_ID + ",\n"
                + "                \"nome\": \"" + TEMPLATE_NOME + "\",\n"
                + "                \"quantidadeColunas\": " + QUANTIDADE_COLUNAS + ",\n"
                + "                \"quantidadeLinhasPre\": " + QUANTIDADE_LINHAS_PRE + ",\n"
                + "                \"quantidadeLinhasPos\": " + QUANTIDADE_LINHASPOS + ",\n"
                + "                \"comandoPre\": \"" + COMANDO_PRE + "\",\n"
                + "                \"comandoPos\": " + COMANDO_POS + "\n"
                + "            }\n"
                + "        },\n"
                + "        \"intencaoImpressaoStatus\": {\n"
                + "            \"id\": " + IMPRESSAO_STATUS_ID + ",\n"
                + "            \"nome\": \"" + IMPRESSAO_STATUS_NOME + "\"\n"
                + "        }\n"
                + "    }\n"
                + "}";

        Data d = WsHelper.unmarshal(toParse, Data.class);
        assertNotNull(d);
        assertNotNull(d.getIntencaoImpressao());
        IntencaoImpressao ii = d.getIntencaoImpressao();
        testParseData(ii);

    }

    private void testParseData(IntencaoImpressao ii) {
        assertNotNull(ii);

        assertEquals(INTENCAO_IMPRESSAO_ID, ii.getId());
        assertEquals(DATA, ii.getData());
        assertEquals(REFERENCIA, ii.getReferencia());
        Impressora imp = ii.getImpressora();
        assertEquals(IMPRESSAO_ID, imp.getId());
        assertEquals(NOME, imp.getNome());
        ImpressoraTemplate it = ii.getImpressora().getImpressoraTemplate();
        assertEquals(TEMPLATE_ID, it.getId());
        assertEquals(TEMPLATE_NOME, it.getNome());
        assertEquals(QUANTIDADE_COLUNAS, it.getQuantidadeColunas());
        assertEquals(QUANTIDADE_LINHAS_PRE, it.getQuantidadeLinhasPre());
        assertEquals(QUANTIDADE_LINHASPOS, it.getQuantidadeLinhasPos());
        assertEquals(COMANDO_POS, it.getComandoPos());
        assertEquals(COMANDO_PRE, it.getComandoPre());
        IntencaoImpressaoStatus iis = ii.getIntencaoImpressaoStatus();
        assertEquals(IMPRESSAO_STATUS_ID, iis.getId());
        assertEquals(IMPRESSAO_STATUS_NOME, iis.getNome());

    }

}

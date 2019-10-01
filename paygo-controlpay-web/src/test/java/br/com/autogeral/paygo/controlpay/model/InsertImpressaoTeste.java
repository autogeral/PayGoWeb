package br.com.autogeral.paygo.controlpay.model;

import br.com.autogeral.paygo.controlpay.web.WsHelper;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author kaique.mota
 */
public class InsertImpressaoTeste {

    private static final int INTENCAO_IMPRESSAO_ID = 31;
    private static final String DATA = "06/02/2017";
    private static final String CONTEUDO = "";
    private static final String REFERENCIA = "Sua referencia para consulta posterior";
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
    private static final String TERMINAL_ID = "900";
    private static final boolean AGUARDAR_INICIAR_IMPRESSAO = true;

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
    public void testParse() {

        String toParse = "{\n"
                + "   \"referencia\":\"" + REFERENCIA + "\",\n"
                + "   \"conteudo\":\"\n"
                + "<textAlignLeft>\n"
                + "Texto à esquerda\n"
                + "\n"
                + "\",\n"
                + "   \"terminalId\":" + TERMINAL_ID + ",\n"
                + "   \"aguardarClienteIniciarImpressao\": " + AGUARDAR_INICIAR_IMPRESSAO + "\n"
                + "}";
        IntencaoImpressao ii = WsHelper.unmarshal(toParse, IntencaoImpressao.class);
        testInsertParse(ii);
    }

    @Test
    public void testParseData() {

        String toParse = "{\n"
                + "    \"data\": \"30/09/2019 14:55:18.0443\",\n"
                + "    \"intencaoImpressao\": {\n"
                + "        \"id\": " + INTENCAO_IMPRESSAO_ID + ",\n"
                + "        \"data\": \"" + DATA + "\",\n"
                + "        \"conteudo\": \"\\r\\n<textAlignLeft>\\r\\nTexto à esquerda\\r\\n\\r\\n\",\n"
                + "        \"referencia\": \"" + REFERENCIA + "\",\n"
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
        testParseDataInsert(ii);
    }

    private void testInsertParse(IntencaoImpressao ii) {
        assertNotNull(ii);
        assertEquals(REFERENCIA, ii.getReferencia());
        assertEquals(TERMINAL_ID, ii.getTerminalId());
        assertEquals(AGUARDAR_INICIAR_IMPRESSAO, ii.isAguardarClienteIniciarImpressao());

    }

    private void testParseDataInsert(IntencaoImpressao ii) {

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

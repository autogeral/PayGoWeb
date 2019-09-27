package br.com.autogeral.paygo.controlpay.model;

import br.com.autogeral.paygo.controlpay.web.WsHelper;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;

/**
 *
 * @author kaique.mota
 */
public class TerminalInsertTest {

    private static final String NOME = "CAIXA 2";
    private static final String IMPRESSORA_ID = null;
    private static final int PESSOA_ID = 8149;
    private static final String NOME_RAZAO_SOCIAL = "AUTO GERAL AUTOPECAS LTDA";
    private static final String SOBRENOME_NOME_FANTASIA = "AUTO GERAL AUTOPECAS LTDA";
    private static final String CPF_CNPJ = "05437537000137";
    private static final int TERMINAL_ID = 900;
    private static final String TERMINAL_NOME = "Terminal 900";
    private static final Impressora IMPRESSORA = null;

    @Test
    public void testSerialize (){
    Terminal t = new Terminal();
    t.setNome(NOME);
    t.setId(TERMINAL_ID);
    Pessoa p = new Pessoa();
    p.setId(PESSOA_ID);
    p.setNomeRazaoSocial(NOME_RAZAO_SOCIAL);
    p.setSobrenomeNomeFantasia(SOBRENOME_NOME_FANTASIA);
    p.setCpfCnpj(CPF_CNPJ);
    
    }
    @Test
    public void testParse() {
        String toParse = "{\n"
                + "    \"nome\": \"" + NOME + "\",\n"
                + "    \"impressora\": {\n"
                + "        \"id\": " + IMPRESSORA_ID + "\n"
                + "    },\n"
                + "    \"pessoa\": {\n"
                + "      \"id\": " + PESSOA_ID + "\n"
                + "    }\n"
                + "}";
        Terminal t = WsHelper.unmarshal(toParse, Terminal.class);
        testParse(t);
    }

    @Test
    public void testParseData() {
        String toParse = "{\n"
                + "  \"data\": \"17/11/2016 17:37:49.8902\",\n"
                + "  \"terminal\": {\n"
                + "    \"id\": " + TERMINAL_ID + ",\n"
                + "    \"nome\": \"" + TERMINAL_NOME + "\",\n"
                + "    \"impressora\": " + IMPRESSORA + ",\n"
                + "    \"pessoa\": {\n"
                + "      \"id\": " + PESSOA_ID + ",\n"
                + "      \"nomeRazaoSocial\": \"" + NOME_RAZAO_SOCIAL + "\",\n"
                + "      \"sobrenomeNomeFantasia\": \"" + SOBRENOME_NOME_FANTASIA + "\",\n"
                + "      \"cpfCnpj\": \"" + CPF_CNPJ + "\"\n"
                + "    }\n"
                + "  }\n"
                + "}";
        Data d = WsHelper.unmarshal(toParse, Data.class);
        assertNotNull(d);
        assertNotNull(d.getTerminal());
        Terminal t = d.getTerminal();
        testParseData(t);
    }

    private void testParseData(Terminal t) {
        assertEquals(TERMINAL_ID, t.getId());
        assertEquals(TERMINAL_NOME, t.getNome());
        assertEquals(PESSOA_ID, t.getPessoa().getId());
        assertNull(t.getImpressora());
        assertEquals(NOME_RAZAO_SOCIAL, t.getPessoa().getNomeRazaoSocial());
        assertEquals(SOBRENOME_NOME_FANTASIA, t.getPessoa().getSobrenomeNomeFantasia());
        assertEquals(CPF_CNPJ, t.getPessoa().getCpfCnpj());
    }

    private void testParse(Terminal t) {
        assertNotNull(t);
        assertEquals(NOME, t.getNome());
        assertEquals(IMPRESSORA_ID, t.getImpressora().getId());
        assertEquals(PESSOA_ID, t.getPessoa().getId());
    }

}

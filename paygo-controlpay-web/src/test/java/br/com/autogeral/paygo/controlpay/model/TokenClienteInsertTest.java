package br.com.autogeral.paygo.controlpay.model;

import br.com.autogeral.paygo.controlpay.web.WsHelper;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author kaique.mota
 */
public class TokenClienteInsertTest {

    private static final String CLIENTE_ID = "1";
    private static final int ID = 12;
    private static final boolean PREFERENCIAL = true;
    private static final int ID_CLIENTE = 1123;
    private static final String CPF_CNPJ = "05.471.416/0001-01";
    private static final String NOME_RAZAO_SOCIAL = "Cadastro Cliente";
    private static final String EMAIL = "cliente@mailinator.com";
    private static final String TELEFONE = "4712 - 2720";
    private static final String DATA_INSERCAO = "07/07/2017 01:14";
    private static final String DATA_ATUALIZACAO = "01/10/2019";
    private static final String CARTAO_PAN = "444433******1111";
    private static final String CARTAO_VALIDADE = "00/00";
    private static final String BANDEIRA = "";
    private static final String CARTAO_TOKEN = "872bd127-0daf-4875-b872-a4a57846180a1931";
    private static final String GATE2ALLTOKEN = "213739b3-8f77-4c14-a8d7-323517997308";
    private static final int STATUS = 2;
    private static final String STATUS_DESCRICAO = "Ativo";
    private static final String URL_CAPTURAR_DADOS_CARTAO = "https://apidemo.gate2all.com.br/v1/save-card/213739b3-8f77-4c14-a8d7-323517997308";

    @Test
    public void testSerialize() {
        ClienteCartao cc = new ClienteCartao();
        cc.setClienteId(CLIENTE_ID);
        cc.setId(ID);
        cc.setPreferencial(PREFERENCIAL);
        Cliente c = new Cliente();
        c.setId(ID_CLIENTE);
        c.setCpfCnpj(CPF_CNPJ);
        c.setNomeRazaoSocial(NOME_RAZAO_SOCIAL);
        c.setEmail(EMAIL);
        c.setTelefone(TELEFONE);
        cc.setDataInsercao(DATA_INSERCAO);
        cc.setCartaoPan(CARTAO_PAN);
        cc.setCartaoValidade(CARTAO_VALIDADE);
        cc.setBandeira(BANDEIRA);
        cc.setCartaoToken(CARTAO_TOKEN);
        cc.setGate2allToken(GATE2ALLTOKEN);
        cc.setStatus(STATUS);
        cc.setStatusDescricao(STATUS_DESCRICAO);
        cc.setUrlCapturarDadosCartao(URL_CAPTURAR_DADOS_CARTAO);

    }

    @Test
    public void testParse() {

        String toParse = "{\n"
                + "	\"clienteId\":" + CLIENTE_ID + ",\n"
                + "	\"id\":" + ID + ",\n"
                + "	\"preferencial\":" + PREFERENCIAL + "\n"
                + "}\n"
                + "";
        ClienteCartao cc = WsHelper.unmarshal(toParse, ClienteCartao.class);
        testParseToken(cc);
    }

    @Test
    public void testParseData() {

        String toParse = "{\n"
                + "    \"data\": \"01/10/2019 13:36:44.7933\",\n"
                + "    \"clienteCartao\": {\n"
                + "        \"id\": " + ID + ",\n"
                + "        \"cliente\": {\n"
                + "            \"id\": " + ID + ",\n"
                + "            \"cpfCnpj\": \"" + CPF_CNPJ + "\",\n"
                + "            \"nomeRazaoSocial\": \"" + NOME_RAZAO_SOCIAL + "\",\n"
                + "            \"email\": \"" + EMAIL + "\",\n"
                + "            \"telefone\": null\n"
                + "        },\n"
                + "        \"dataAtualizacao\": \"" + DATA_ATUALIZACAO + "\",\n"
                + "        \"dataInsercao\": \"" + DATA_INSERCAO + "\",\n"
                + "        \"cartaoPan\": \"" + CARTAO_PAN + "\",\n"
                + "        \"cartaoValidade\": \"" + CARTAO_VALIDADE + "\",\n"
                + "        \"bandeira\": \"\",\n"
                + "        \"cartaoToken\": \"" + CARTAO_TOKEN + "\",\n"
                + "        \"gate2allToken\": \"" + GATE2ALLTOKEN + "\",\n"
                + "        \"status\": " + STATUS + ",\n"
                + "        \"statusDescricao\": \"" + STATUS_DESCRICAO + "\",\n"
                + "        \"urlCapturarDadosCartao\": \"" + URL_CAPTURAR_DADOS_CARTAO + "\",\n"
                + "        \"preferencial\": " + PREFERENCIAL + "\n"
                + "    }\n"
                + "}";
        Data d = WsHelper.unmarshal(toParse, Data.class);
        assertNotNull(d);
        assertNotNull(d.getClienteCartao());
        ClienteCartao cc = d.getClienteCartao();
        testeParseData(cc);
    }

    private void testeParseData(ClienteCartao cc) {
        assertNotNull(cc);
        assertEquals(ID, cc.getId());
        Cliente c = cc.getCliente();
        assertEquals(ID, c.getId());
        assertEquals(CPF_CNPJ, c.getCpfCnpj());
        assertEquals(NOME_RAZAO_SOCIAL, c.getNomeRazaoSocial());
        assertEquals(EMAIL, c.getEmail());
        assertEquals(DATA_ATUALIZACAO, cc.getDataAtualizacao());
        assertEquals(DATA_INSERCAO, cc.getDataInsercao());
        assertEquals(CARTAO_PAN, cc.getCartaoPan());
        assertEquals(CARTAO_VALIDADE, cc.getCartaoValidade());
        assertEquals(CARTAO_TOKEN, cc.getCartaoToken());
        assertEquals(GATE2ALLTOKEN, cc.getGate2allToken());
        assertEquals(STATUS, cc.getStatus());
        assertEquals(STATUS_DESCRICAO, cc.getStatusDescricao());
        assertEquals(URL_CAPTURAR_DADOS_CARTAO, cc.getUrlCapturarDadosCartao());
        assertEquals(PREFERENCIAL, cc.isPreferencial());

    }

    private void testParseToken(ClienteCartao cc) {

        assertNotNull(cc);
        assertEquals(cc, cc);
        assertEquals(CLIENTE_ID, cc.getClienteId());
        assertEquals(ID, cc.getId());
        assertEquals(PREFERENCIAL, cc.isPreferencial());

    }
}

package br.com.autogeral.paygo.controlpay.model;

import br.com.autogeral.paygo.controlpay.web.WsHelper;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author kaique.mota
 */
public class ClienteInsertTeste {

    private static final int ID = 1123;
    private static final String CPF_CNPJ = "05.471.416/0001-01";
    private static final String NOME_RAZAO_SOCIAL = "Cadastro Cliente";
    private static final String EMAIL = "cliente@mailinator.com";
    private static final String REFERENCIA = "Cliente";
    private static final boolean PESSOA_JURIDICA = true;
    private static final int PESSOA_ID = 2;
    private static final String TIPO_LOGRADOURO = "Rua";
    private static final String LOGRADOURO = "Fidêncio Ramos";
    private static final String TELEFONE = null;
    private static final String TELEFONE1 = "(22)2222-2222";
    private static final String TELEFONE2 = "(22)2222-2222";
    private static final String NUMERO = "100";
    private static final String COMPLEMENTO = "CJ-2";
    private static final String CEP = "04551-010";
    private static final String BAIRRO = "Vila olímpia";
    private static final String CIDADE = "São Paulo";
    private static final String UF = "SP";
    private static final String PESSOA_NOME_RAZAO_SOCIAL = "PayGo Pagamentos";
    private static final String PESSOA_SOBRENOME_NOME_FANTASIA = "PayGo Pagamentos";
    private static final String ENDERECO_LATITUDE = null;
    private static final String ENDERECO_LONGITUDE = null;
    private static final String ENDECO_GEO_LOCALIZACAO = null;
    private static final String CPF_CNPJ_FORMAT = "726.455.565-82";
    private static final int PESSOA_STATUS_ID = 1;
    private static final String PESSOA_STATUS_NOME = null;

    @Test
    public void testSerialize() {
        Cliente cliente = new Cliente();
        cliente.setId(ID);
        cliente.setCpfCnpj(CPF_CNPJ);
        cliente.setNomeRazaoSocial(NOME_RAZAO_SOCIAL);
        cliente.setEmail(EMAIL);
        cliente.setReferencia(REFERENCIA);
        cliente.setPessoaJuridica(PESSOA_JURIDICA);
        cliente.setPessoaId(PESSOA_ID);
        cliente.setTelefone(TELEFONE);
        Endereco endereco = new Endereco();
        endereco.setTipoLogradouro(TIPO_LOGRADOURO);
        endereco.setLogradouro(LOGRADOURO);
        endereco.setNumero(NUMERO);
        endereco.setComplemento(COMPLEMENTO);
        endereco.setCep(CEP);
        endereco.setBairro(BAIRRO);
        endereco.setCidade(CIDADE);
        endereco.setUf(UF);
        endereco.setLatitude(ENDERECO_LATITUDE);
        endereco.setLongitude(ENDERECO_LONGITUDE);
        endereco.setGeoLocalizacao(ENDECO_GEO_LOCALIZACAO);
        Pessoa pessoa = new Pessoa();
        pessoa.setNomeRazaoSocial(PESSOA_NOME_RAZAO_SOCIAL);
        pessoa.setSobrenomeNomeFantasia(PESSOA_SOBRENOME_NOME_FANTASIA);

    }

    @Test
    public void testParse() {
        String toParse = "{"
                + "  \"id\":" + ID + ",\n"
                + "  \"cpfCnpj\":\"" + CPF_CNPJ + "\",\n"
                + "  \"nomeRazaoSocial\": \"" + NOME_RAZAO_SOCIAL + "\",\n"
                + "  \"email\":\"" + EMAIL + "\",\n"
                + "  \"referencia\":\"" + REFERENCIA + "\",\n"
                + "  \"pessoaJuridica\":" + PESSOA_JURIDICA + ",\n"
                + "  \"pessoaId\":\"" + PESSOA_ID + "\",\n"
                + "  \"endereco\": {\n"
                + "            \"TipoLogradouro\" :\"" + TIPO_LOGRADOURO + "\",\n"
                + "            \"Logradouro\" :\"" + LOGRADOURO + "\",\n"
                + "            \"Numero\" :\"" + NUMERO + "\",\n"
                + "            \"Complemento\" :\"" + COMPLEMENTO + "\",\n"
                + "            \"Cep\" :\"" + CEP + "\",\n"
                + "            \"Bairro\" :\"" + BAIRRO + "\",\n"
                + "            \"Cidade\" :\"" + CIDADE + "\",\n"
                + "            \"Uf\" :\"" + UF + "\"\n"
                + "        }\n"
                + "}";

        Cliente cliente = WsHelper.unmarshal(toParse, Cliente.class);
        testeClienteParse(cliente);

    }

    @Test
    public void testPessoaData() {
        String toParse = "{\n"
                + "  \"pessoa\": {\n"
                + "    \"id\": " + ID + ",\n"
                + "    \"pessoaJuridica\": " + PESSOA_JURIDICA + ",\n"
                + "    \"nomeRazaoSocial\": \"" + NOME_RAZAO_SOCIAL + "\",\n"
                + "    \"sobrenomeNomeFantasia\": \"" + PESSOA_SOBRENOME_NOME_FANTASIA + "\",\n"
                + "    \"cpfCnpj\": \"" + CPF_CNPJ + "\",\n"
                + "    \"cpfCnpjFormat\": \"" + CPF_CNPJ_FORMAT + "\",\n"
                + "    \"email\": \"" + EMAIL + "\",\n"
                + "    \"telefone1\": \"" + TELEFONE1 + "\",\n"
                + "    \"telefone2\": \"" + TELEFONE2 + "\",\n"
                + "    \"pessoaStatus\": {\n"
                + "      \"id\": " + PESSOA_STATUS_ID + ",\n"
                + "      \"nome\": " + PESSOA_STATUS_NOME + "\n"
                + "    }\n"
                + "  }\n"
                + "}";
        Data d = WsHelper.unmarshal(toParse, Data.class);
        assertNotNull(d);
        Pessoa p = d.getPessoa();
        testPessoaParse(p);
    }

    public void testPessoaParse(Pessoa p) {
        assertNotNull(p);
        assertEquals(ID, p.getId());
        assertEquals(NOME_RAZAO_SOCIAL, p.getNomeRazaoSocial());
        assertEquals(PESSOA_SOBRENOME_NOME_FANTASIA, p.getSobrenomeNomeFantasia());
        assertEquals(CPF_CNPJ, p.getCpfCnpj());
        assertEquals(CPF_CNPJ_FORMAT, p.getCpfCnpjFormat());
        assertEquals(EMAIL, p.getEmail());
        assertEquals(TELEFONE1, p.getTelefone1());
        assertEquals(TELEFONE2, p.getTelefone2());
        assertEquals(PESSOA_STATUS_ID, p.getPessoaStatus().getId());
        assertEquals(PESSOA_STATUS_NOME, p.getPessoaStatus().getNome());

    }

    @Test
    public void testeParseData() {
        String toParse = "{\n"
                + "    \"data\": \"18/09/2019 17:03:46.0110\",\n"
                + "    \"cliente\": {\n"
                + "        \"id\": " + ID + ",\n"
                + "        \"cpfCnpj\": \"" + CPF_CNPJ + "\",\n"
                + "        \"nomeRazaoSocial\": \"" + NOME_RAZAO_SOCIAL + "\",\n"
                + "        \"email\": \"" + EMAIL + "\",\n"
                + "        \"telefone\": " + TELEFONE + ",\n"
                + "        \"referencia\": \"" + REFERENCIA + "\",\n"
                + "        \"pessoaJuridica\": " + PESSOA_JURIDICA + ",\n"
                + "        \"pessoa\": {\n"
                + "            \"id\": " + PESSOA_ID + ",\n"
                + "            \"nomeRazaoSocial\": \"" + PESSOA_NOME_RAZAO_SOCIAL + "\",\n"
                + "            \"sobrenomeNomeFantasia\": \"" + PESSOA_SOBRENOME_NOME_FANTASIA + "\"\n"
                + "        },\n"
                + "        \"endereco\": {\n"
                + "            \"tipoLogradouro\": \"" + TIPO_LOGRADOURO + "\",\n"
                + "            \"logradouro\": \"" + LOGRADOURO + "\",\n"
                + "            \"numero\": \"" + NUMERO + "\",\n"
                + "            \"complemento\": \"" + COMPLEMENTO + "\",\n"
                + "            \"cep\": \"" + CEP + "\",\n"
                + "            \"bairro\": \"" + BAIRRO + "\",\n"
                + "            \"cidade\": \"" + CIDADE + "\",\n"
                + "            \"uf\": \"" + UF + "\",\n"
                + "            \"latitude\": " + ENDERECO_LATITUDE + ",\n"
                + "            \"longitude\": " + ENDERECO_LONGITUDE + ",\n"
                + "            \"geoLocalizacao\": " + ENDECO_GEO_LOCALIZACAO + "\n"
                + "        }\n"
                + "    }\n"
                + "}";

        Data d = WsHelper.unmarshal(toParse, Data.class);
        assertNotNull(d);
        Cliente c = d.getCliente();
        tesParsetData(c);
    }

    public void testeClienteParse(Cliente c) {

        assertNotNull(c);
        assertEquals(ID, c.getId());
        assertEquals(CPF_CNPJ, c.getCpfCnpj());
        assertEquals(NOME_RAZAO_SOCIAL, c.getNomeRazaoSocial());
        assertEquals(EMAIL, c.getEmail());
        assertEquals(REFERENCIA, c.getReferencia());
        assertEquals(PESSOA_JURIDICA, c.isPessoaJuridica());
        assertEquals(PESSOA_ID, c.getPessoaId());

        assertNotNull(c.getEndereco());
        Endereco endereco = c.getEndereco();
        assertEquals(TIPO_LOGRADOURO, endereco.getTipoLogradouro());
        assertEquals(LOGRADOURO, endereco.getLogradouro());
        assertEquals(NUMERO, endereco.getNumero());
        assertEquals(COMPLEMENTO, endereco.getComplemento());
        assertEquals(CEP, endereco.getCep());
        assertEquals(BAIRRO, endereco.getBairro());
        assertEquals(CIDADE, endereco.getCidade());
        assertEquals(UF, endereco.getUf());

    }

    private void tesParsetData(Cliente c) {
        assertNotNull(c);
        assertEquals(ID, c.getId());
        assertEquals(CPF_CNPJ, c.getCpfCnpj());
        assertEquals(NOME_RAZAO_SOCIAL, c.getNomeRazaoSocial());
        assertEquals(EMAIL, c.getEmail());
        assertEquals(TELEFONE, c.getTelefone());
        assertEquals(REFERENCIA, c.getReferencia());
        assertEquals(PESSOA_JURIDICA, c.isPessoaJuridica());
        Pessoa pessoa = new Pessoa();
        assertEquals(PESSOA_ID, c.getPessoa().getId());
        assertEquals(PESSOA_NOME_RAZAO_SOCIAL, c.getPessoa().getNomeRazaoSocial());
        assertEquals(PESSOA_SOBRENOME_NOME_FANTASIA, c.getPessoa().getSobrenomeNomeFantasia());

        assertNotNull(c.getEndereco());
        Endereco endereco = c.getEndereco();
        assertEquals(TIPO_LOGRADOURO, c.getEndereco().getTipoLogradouro());
        assertEquals(LOGRADOURO, c.getEndereco().getLogradouro());
        assertEquals(NUMERO, endereco.getNumero());
        assertEquals(COMPLEMENTO, endereco.getComplemento());
        assertEquals(CEP, endereco.getCep());
        assertEquals(BAIRRO, endereco.getBairro());
        assertEquals(CIDADE, endereco.getCidade());
        assertEquals(UF, endereco.getUf());
        assertEquals(ENDERECO_LATITUDE, endereco.getLatitude());
        assertEquals(ENDERECO_LONGITUDE, endereco.getLongitude());
        assertEquals(ENDECO_GEO_LOCALIZACAO, endereco.getGeoLocalizacao());

    }
}

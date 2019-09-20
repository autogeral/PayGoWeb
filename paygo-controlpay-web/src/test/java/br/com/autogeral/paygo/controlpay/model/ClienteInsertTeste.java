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
    private static final String NUMERO = "100";
    private static final String COMPLEMENTO = "CJ-2";
    private static final String CEP = "04551-010";
    private static final String BAIRRO = "Vila olímpia";
    private static final String CIDADE = "São Paulo";
    private static final String UF = "SP";
    private static final String  PESSOA_NOME_RAZAO_SOCIAL = "PayGo Pagamentos";
    private static final String  PESSOA_SOBRENOME_NOME_FANTASIA = "PayGo Pagamentos";
    private static final String ENDERECO_LATITUDE = null;
    private static final String ENDERECO_LONGITUDE = null;
    private static final String ENDECO_GEO_LOCALIZACAO =null;
 
  

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
                + "  \"id\":1123,\n"
                + "  \"cpfCnpj\":\"05.471.416/0001-01\",\n"
                + "  \"nomeRazaoSocial\": \"Cadastro Cliente\",\n"
                + "  \"email\":\"cliente@mailinator.com\",\n"
                + "  \"referencia\":\"Cliente\",\n"
                + "  \"pessoaJuridica\":true,\n"
                + "  \"pessoaId\":\"2\",\n"
                + "  \"endereco\": {\n"
                + "            \"TipoLogradouro\" :\"Rua\",\n"
                + "            \"Logradouro\" :\"Fidêncio Ramos\",\n"
                + "            \"Numero\" :\"100\",\n"
                + "            \"Complemento\" :\"CJ-2\",\n"
                + "            \"Cep\" :\"04551-010\",\n"
                + "            \"Bairro\" :\"Vila olímpia\",\n"
                + "            \"Cidade\" :\"São Paulo\",\n"
                + "            \"Uf\" :\"SP\"\n"
                + "        }\n"
                + "}";

        Cliente cliente = WsHelper.unmarshal(toParse, Cliente.class);
        testeClienteParse(cliente);

    }

    @Test
    public void testeParseData() {
        String toParse = "{\n"
                + "    \"data\": \"18/09/2019 17:03:46.0110\",\n"
                + "    \"cliente\": {\n"
                + "        \"id\": 1123,\n"
                + "        \"cpfCnpj\": \"05.471.416/0001-01\",\n"
                + "        \"nomeRazaoSocial\": \"Cadastro Cliente\",\n"
                + "        \"email\": \"cliente@mailinator.com\",\n"
                + "        \"telefone\": null,\n"
                + "        \"referencia\": \"Cliente\",\n"
                + "        \"pessoaJuridica\": true,\n"
                + "        \"pessoa\": {\n"
                + "            \"id\": 2,\n"
                + "            \"nomeRazaoSocial\": \"PayGo Pagamentos\",\n"
                + "            \"sobrenomeNomeFantasia\": \"PayGo Pagamentos\"\n"
                + "        },\n"
                + "        \"endereco\": {\n"
                + "            \"tipoLogradouro\": \"Rua\",\n"
                + "            \"logradouro\": \"Fidêncio Ramos\",\n"
                + "            \"numero\": \"100\",\n"
                + "            \"complemento\": \"CJ-2\",\n"
                + "            \"cep\": \"04551-010\",\n"
                + "            \"bairro\": \"Vila olímpia\",\n"
                + "            \"cidade\": \"São Paulo\",\n"
                + "            \"uf\": \"SP\",\n"
                + "            \"latitude\": null,\n"
                + "            \"longitude\": null,\n"
                + "            \"geoLocalizacao\": null\n"
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
    private void tesParsetData(Cliente c){
        assertNotNull(c);
        assertEquals(ID, c.getId());
        assertEquals(CPF_CNPJ, c.getCpfCnpj());
        assertEquals(NOME_RAZAO_SOCIAL, c.getNomeRazaoSocial());
        assertEquals(EMAIL, c.getEmail());
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

    }
}

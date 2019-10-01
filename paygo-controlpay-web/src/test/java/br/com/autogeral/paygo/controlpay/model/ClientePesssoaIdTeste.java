package br.com.autogeral.paygo.controlpay.model;

import br.com.autogeral.paygo.controlpay.web.WsHelper;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author kaique.mota
 */
public class ClientePesssoaIdTeste {

    private static final int ID = 423;
    private static final String CPF_CNPJ = "773.152.840-52";
    private static final String NOME_RAZAO_SOCIAL = "Teste";
    private static final String EMAIL = "testerecorrencia@mailinator.com";
    private static final String TELEFONE = null;
    private static final String REFERENCIA = "Usuário 123";
    private static final boolean PESSOA_JURIDICA = false;
    private static final int PESSOA_ID = 1;
    private static final String TIPO_LOGRADOURO = "Rua";
    private static final String LOGRADOURO = "Fidêncio Ramos";
    private static final String NUMERO = "100";
    private static final String COMPLEMENTO = "CJ-2";
    private static final String CEP = "04551-010";
    private static final String BAIRRO = "Vila olímpia";
    private static final String CIDADE = "São Paulo";
    private static final String UF = "SP";
    private static final String PESSOA_NOME_RAZAO_SOCIAL = "2ALL";
    private static final String PESSOA_SOBRENOME_NOME_FANTASIA = "2ALL meios de pagamentos LTDA";
    private static final String ENDERECO_LATITUDE = null;
    private static final String ENDERECO_LONGITUDE = null;
    private static final String ENDECO_GEO_LOCALIZACAO = null;

    @Test
    public void testSerialize() {
        Cliente cliente = new Cliente();
        cliente.setId(ID);
        cliente.setCpfCnpj(CPF_CNPJ);
        cliente.setNomeRazaoSocial(NOME_RAZAO_SOCIAL);
        cliente.setTelefone(TELEFONE);
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
    public void testDataCliente() {
        String toParse = "{\n"
                + "    \"data\": \"20/09/2019 15:59:41.1386\",\n"
                + "    \"clientes\": [\n"
                + "        {\n"
                + "            \"id\": "+ID+",\n"
                + "            \"cpfCnpj\": \""+CPF_CNPJ+"\",\n"
                + "            \"nomeRazaoSocial\": \""+NOME_RAZAO_SOCIAL+"\",\n"
                + "            \"email\": \""+EMAIL+"\",\n"
                + "            \"telefone\": "+TELEFONE+",\n"
                + "            \"referencia\": \""+REFERENCIA+"\",\n"
                + "            \"pessoaJuridica\": "+PESSOA_JURIDICA+",\n"
                + "            \"pessoa\": {\n"
                + "                \"id\": "+PESSOA_ID+",\n"
                + "                \"nomeRazaoSocial\": \""+NOME_RAZAO_SOCIAL+"\",\n"
                + "                \"sobrenomeNomeFantasia\": \"2ALL meios de pagamentos LTDA\"\n"
                + "            },\n"
                + "            \"endereco\": null\n"
                + "        }\n"
                + "    ]\n"
                + "}";
        
        Data d = WsHelper.unmarshal(toParse, Data.class);
        assertNotNull(d);
        List<Cliente> clientes = d.getClientes();
        testeData(clientes);
    }

    private void testeData(List<Cliente>cli) {

        assertNotNull(cli);
        Cliente c = cli.get(0);
        assertEquals(ID, cli.get(0).getId());
        assertEquals(CPF_CNPJ, c.getCpfCnpj());
        assertEquals(NOME_RAZAO_SOCIAL, c.getNomeRazaoSocial());
        assertEquals(EMAIL, c.getEmail());
        assertEquals(TELEFONE, c.getTelefone());
        assertEquals(REFERENCIA, c.getReferencia());
        assertEquals(PESSOA_JURIDICA, c.isPessoaJuridica());
        Pessoa pessoa = new Pessoa();
        assertEquals(PESSOA_ID, c.getPessoa().getId());
        assertEquals(NOME_RAZAO_SOCIAL, c.getPessoa().getNomeRazaoSocial());
        assertEquals(PESSOA_SOBRENOME_NOME_FANTASIA, c.getPessoa().getSobrenomeNomeFantasia());

    }
}

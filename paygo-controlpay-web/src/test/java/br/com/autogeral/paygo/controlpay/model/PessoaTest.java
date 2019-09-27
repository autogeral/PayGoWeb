package br.com.autogeral.paygo.controlpay.model;

import br.com.autogeral.paygo.controlpay.web.WsHelper;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Murilo Moraes Tuvani
 */
public class PessoaTest {

    public static final int PESSOA_ID = 1234;
    public static final String PESSOA_JURIDICA = "true";
    public static final String NOME_RAZAO_SOCIAL = "Nome ou Razão Social";
    public static final String SOBRENOME_NOMEFANTASIA = "Sobrenome ou Nome fantasia";
    public static final String CPF_CNPJ = "12345678909";
    public static final String CPF_CNPJ_FORMATADO = "12.345.678/9012-34";
    public static final String E_MAIL = "cadastro@mailinator.com";
    public static final String TELEFONE_1 = "(11)1111-1111";
    public static final String TELEFONE_2 = "(22)2222-2222";
    public static final String URL_FOTO = "UrlDaFoto.com";
    public static final String TIPO_LOGRADOURO = "Rua";
    public static final String LOGRADOURO = "Nome da rua";
    public static final String NUMERO = "111";
    public static final String COMPLEMENTO = "apto 11";
    public static final String CEP = "00000-000";
    public static final String BAIRRO = "Nome do bairro";
    public static final String CIDADE = "Cidade";
    public static final String UF = "SP";
    public static final String FOTO_NOME = "Nome da foto";
    public static final String FOTO_BASE_64 = "UrlDaFotoBase64";
    public static final int PESSOA_STATUS_ID = 1;
    public static final String PESSOA_STATUS_NOME = null;

    @Test
    public void test_serialize() {
        Pessoa p = new Pessoa();
        p.setId(1234);
        p.setPessoaJuridica(PESSOA_JURIDICA);
        p.setNomeRazaoSocial(NOME_RAZAO_SOCIAL);
        p.setSobrenomeNomeFantasia(SOBRENOME_NOMEFANTASIA);
        p.setCpfCnpj(CPF_CNPJ);
        p.setEmail(E_MAIL);
        p.setTelefone1(TELEFONE_1);
        p.setTelefone2(TELEFONE_2);
        p.setFoto(URL_FOTO);

        Endereco e = new Endereco();
        e.setTipoLogradouro(TIPO_LOGRADOURO);
        e.setLogradouro(LOGRADOURO);
        e.setNumero(NUMERO);
        e.setComplemento(COMPLEMENTO);
        e.setCep(CEP);
        e.setBairro(BAIRRO);
        e.setCidade(CIDADE);
        e.setUf(UF);

        p.setEndereco(e);

        p.setFotoNome(FOTO_NOME);
        p.setFotoBase64(FOTO_BASE_64);

        String result = WsHelper.marshal(p);
        System.out.println(result);

    }

    @Test
    public void test_parse_data() {
        String toParse = "{\n"
                + "    \"pessoa\":{\n"
                + "        \"Id\": \"" + PESSOA_ID + "\",\n"
                + "        \"PessoaJuridica\": \"" + PESSOA_JURIDICA + "\",\n"
                + "        \"NomeRazaoSocial\": \"" + NOME_RAZAO_SOCIAL + "\",\n"
                + "        \"SobrenomeNomeFantasia\": \"" + SOBRENOME_NOMEFANTASIA + "\",\n"
                + "        \"CpfCnpj\": \"" + CPF_CNPJ + "\",\n"
                + "        \"Email\": \"" + E_MAIL + "\",\n"
                + "        \"Telefone1\": \"" + TELEFONE_1 + "\",\n"
                + "        \"Telefone2\": \"" + TELEFONE_2 + "\",\n"
                + "        \"Foto\": \"" + URL_FOTO + "\",\n"
                + "        \"Endereco\": {\n"
                + "            \"TipoLogradouro\" :\"" + TIPO_LOGRADOURO + "\",\n"
                + "            \"Logradouro\" :\"" + LOGRADOURO + "\",\n"
                + "            \"Numero\" :\"" + NUMERO + "\",\n"
                + "            \"Complemento\" :\"" + COMPLEMENTO + "\",\n"
                + "            \"Cep\" :\"" + CEP + "\",\n"
                + "            \"Bairro\" :\"" + BAIRRO + "\",\n"
                + "            \"Cidade\" :\"" + CIDADE + "\",\n"
                + "            \"Uf\" :\"" + UF + "\"\n"
                + "        },\n"
                + "        \"fotoNome\":\"" + FOTO_NOME + "\",\n"
                + "        \"fotoBase64\":\"" + FOTO_BASE_64 + "\"\n"
                + "    }\n"
                + "}   ";

        Data d = WsHelper.unmarshal(toParse, Data.class);
        assertNotNull(d);
        assertNotNull(d.getPessoa());
        Pessoa p = d.getPessoa();
        testeParsePessoaPadrao(p);

    }

    @Test
    public void testParsePessoa() {
        String toParse = "{\n"
                + "  \"pessoa\": {\n"
                + "    \"id\": " + PESSOA_ID + ",\n"
                + "    \"pessoaJuridica\": " + PESSOA_JURIDICA + ",\n"
                + "    \"nomeRazaoSocial\": \"" + NOME_RAZAO_SOCIAL + "\",\n"
                + "    \"sobrenomeNomeFantasia\": \"" + SOBRENOME_NOMEFANTASIA + "\",\n"
                + "    \"cpfCnpj\": \"" + CPF_CNPJ + "\",\n"
                + "    \"cpfCnpjFormat\": \"" + CPF_CNPJ_FORMATADO + "\",\n"
                + "    \"email\": \"" + E_MAIL + "\",\n"
                + "    \"telefone1\": \"" + TELEFONE_1 + "\",\n"
                + "    \"telefone2\": \"" + TELEFONE_2 + "\",\n"
                + "    \"pessoaStatus\": {\n"
                + "      \"id\": " + PESSOA_STATUS_ID + ",\n"
                + "      \"nome\": " + PESSOA_STATUS_NOME + "\n"
                + "    }\n"
                + "  }\n"
                + "}";
        Data d = WsHelper.unmarshal(toParse, Data.class);
        assertNotNull(d);
        assertNotNull(d.getPessoa());
        Pessoa p = d.getPessoa();
        testPessoa(p);
    }

    @Test
    public void test_parse() {
        String toParse = "{\n"
                + "  \"Id\": \"" + PESSOA_ID + "\",\n"
                + "  \"PessoaJuridica\": \"" + PESSOA_JURIDICA + "\",\n"
                + "  \"NomeRazaoSocial\": \"" + NOME_RAZAO_SOCIAL + "\",\n"
                + "  \"SobrenomeNomeFantasia\": \"" + SOBRENOME_NOMEFANTASIA + "\",\n"
                + "  \"CpfCnpj\": \"" + CPF_CNPJ + "\",\n"
                + "  \"Email\": \"" + E_MAIL + "\",\n"
                + "  \"Telefone1\": \"" + TELEFONE_1 + "\",\n"
                + "  \"Telefone2\": \"" + TELEFONE_2 + "\",\n"
                + "  \"Foto\": \"" + URL_FOTO + "\",\n"
                + "  \"Endereco\": {\n"
                + "       \"TipoLogradouro\" :\"" + TIPO_LOGRADOURO + "\",\n"
                + "       \"Logradouro\" :\"" + LOGRADOURO + "\",\n"
                + "       \"Numero\" :\"" + NUMERO + "\",\n"
                + "       \"Complemento\" :\"" + COMPLEMENTO + "\",\n"
                + "       \"Cep\" :\"" + CEP + "\",\n"
                + "       \"Bairro\" :\"" + BAIRRO + "\",\n"
                + "       \"Cidade\" :\"" + CIDADE + "\",\n"
                + "       \"Uf\" :\"" + UF + "\"\n"
                + "  },\n"
                + "  \"FotoNome\":\"" + FOTO_NOME + "\",\n"
                + "  \"FotoBase64\":\"" + FOTO_BASE_64 + "\"\n"
                + "}";

        Pessoa p = WsHelper.unmarshal(toParse, Pessoa.class);
        testeParsePessoaPadrao(p);
    }

    private void testeParsePessoaPadrao(Pessoa p) {
        assertNotNull(p);
        assertEquals(PESSOA_ID, p.getId());
        assertEquals(PESSOA_JURIDICA, p.getPessoaJuridica());
        assertEquals(NOME_RAZAO_SOCIAL, p.getNomeRazaoSocial());
        assertEquals(SOBRENOME_NOMEFANTASIA, p.getSobrenomeNomeFantasia());
        assertEquals(CPF_CNPJ, p.getCpfCnpj());
        assertEquals(E_MAIL, p.getEmail());
        assertEquals(TELEFONE_1, p.getTelefone1());
        assertEquals(TELEFONE_2, p.getTelefone2());
        assertEquals(URL_FOTO, p.getFoto());
        assertNotNull(p.getEndereco());
        Endereco e = p.getEndereco();
        assertEquals(TIPO_LOGRADOURO, e.getTipoLogradouro());
        assertEquals(LOGRADOURO, e.getLogradouro());
        assertEquals(NUMERO, e.getNumero());
        assertEquals(COMPLEMENTO, e.getComplemento());
        assertEquals(CEP, e.getCep());
        assertEquals(BAIRRO, e.getBairro());
        assertEquals(CIDADE, e.getCidade());
        assertEquals(UF, e.getUf());
        assertEquals(FOTO_NOME, p.getFotoNome());
        assertEquals(FOTO_BASE_64, p.getFotoBase64());

    }

    private void testPessoa(Pessoa p) {
        assertNotNull(p);
        assertEquals(PESSOA_ID, p.getId());
        assertEquals(PESSOA_JURIDICA, p.getPessoaJuridica());
        assertEquals(NOME_RAZAO_SOCIAL, p.getNomeRazaoSocial());
        assertEquals(SOBRENOME_NOMEFANTASIA, p.getSobrenomeNomeFantasia());
        assertEquals(CPF_CNPJ, p.getCpfCnpj());
        assertEquals(E_MAIL, p.getEmail());
        assertEquals(TELEFONE_1, p.getTelefone1());
        assertEquals(TELEFONE_2, p.getTelefone2());
        assertEquals(PESSOA_STATUS_ID, p.getPessoaStatus().getId());
        assertEquals(PESSOA_STATUS_NOME, p.getPessoaStatus().getNome());

    }

}

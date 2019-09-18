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
                + "        \"Id\": \"1234\",\n"
                + "        \"PessoaJuridica\": \"true\",\n"
                + "        \"NomeRazaoSocial\": \"Nome ou Razão Social\",\n"
                + "        \"SobrenomeNomeFantasia\": \"Sobrenome ou Nome fantasia\",\n"
                + "        \"CpfCnpj\": \"12345678909\",\n"
                + "        \"Email\": \"cadastro@mailinator.com\",\n"
                + "        \"Telefone1\": \"(11)1111-1111\",\n"
                + "        \"Telefone2\": \"(22)2222-2222\",\n"
                + "        \"Foto\": \"UrlDaFoto.com\",\n"
                + "        \"Endereco\": {\n"
                + "            \"TipoLogradouro\" :\"Rua\",\n"
                + "            \"Logradouro\" :\"Nome da rua\",\n"
                + "            \"Numero\" :\"111\",\n"
                + "            \"Complemento\" :\"apto 11\",\n"
                + "            \"Cep\" :\"00000-000\",\n"
                + "            \"Bairro\" :\"Nome do bairro\",\n"
                + "            \"Cidade\" :\"Cidade\",\n"
                + "            \"Uf\" :\"SP\"\n"
                + "        },\n"
                + "        \"fotoNome\":\"Nome da foto\",\n"
                + "        \"fotoBase64\":\"UrlDaFotoBase64\"\n"
                + "    }\n"
                + "}   ";

        Data d = WsHelper.unmarshal(toParse, Data.class);
        assertNotNull(d);
        assertNotNull(d.getPessoa());
        Pessoa p = d.getPessoa();
        testeParsePessoaPadrao(p);

    }

    @Test
    public void test_parse() {
        String toParse = "{\n"
                + "  \"Id\": \"" + PESSOA_ID + "\",\n"
                + "  \"PessoaJuridica\": \"true\",\n"
                + "  \"NomeRazaoSocial\": \"Nome ou Razão Social\",\n"
                + "  \"SobrenomeNomeFantasia\": \"Sobrenome ou Nome fantasia\",\n"
                + "  \"CpfCnpj\": \"" + CPF_CNPJ + "\",\n"
                + "  \"Email\": \"cadastro@mailinator.com\",\n"
                + "  \"Telefone1\": \"(11)1111-1111\",\n"
                + "  \"Telefone2\": \"(22)2222-2222\",\n"
                + "  \"Foto\": \"UrlDaFoto.com\",\n"
                + "  \"Endereco\": {\n"
                + "       \"TipoLogradouro\" :\"Rua\",\n"
                + "       \"Logradouro\" :\"Nome da rua\",\n"
                + "       \"Numero\" :\"111\",\n"
                + "       \"Complemento\" :\"apto 11\",\n"
                + "       \"Cep\" :\"00000-000\",\n"
                + "       \"Bairro\" :\"Nome do bairro\",\n"
                + "       \"Cidade\" :\"Cidade\",\n"
                + "       \"Uf\" :\"SP\"\n"
                + "  },\n"
                + "  \"FotoNome\":\"Nome da foto\",\n"
                + "  \"FotoBase64\":\"UrlDaFotoBase64\"\n"
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

}

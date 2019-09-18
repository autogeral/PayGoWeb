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

    private static final int ID = 1;
    private static final String CPF_CNPJ = "12345678909";
    private static final String NOME_RAZAO_SOCIAL = "Cadastro Cliente";
    private static final String EMAIL = "cliente@mailinator.com";
    private static final String REFERENCIA = "Cliente";
    private static final boolean PESSOA_JURIDICA = true;
    private static final int PESSOA_ID = 1;
    private static final String TIPO_LOGRADOURO = "Rua";
    private static final String LOGRADOURO = "Fidêncio Ramos";
    private static final String NUMERO = "100";
    private static final String COMPLENTO = "CJ-2";
    private static final String CEP = "04551-010";
    private static final String BAIRRO = "VILA OLIMPIA";
    private static final String CIDADE = "São Paulo";
    private static final String UF = "SP";

    @Test
    public void testSerialize() {
        Cliente cliente = new Cliente();
        cliente.setId(ID);
        cliente.setCpfcnpj(CPF_CNPJ);
        cliente.setNomeRazaoSocial(NOME_RAZAO_SOCIAL);
        cliente.setNomeRazaoSocial(NOME_RAZAO_SOCIAL);
        cliente.setEmail(EMAIL);
        cliente.setReferencia(REFERENCIA);
        cliente.setPessoaJurica(PESSOA_JURIDICA);
        cliente.setPessoaJurica(PESSOA_JURIDICA);
        cliente.setPessoaId(PESSOA_ID);
        Endereco endereco = new Endereco();
        endereco.setTipoLogradouro(TIPO_LOGRADOURO);
        endereco.setLogradouro(LOGRADOURO);
        endereco.setNumero(NUMERO);
        endereco.setComplemento(COMPLENTO);
        endereco.setCep(CEP);
        endereco.setBairro(BAIRRO);
        endereco.setCidade(CIDADE);
        endereco.setUf(UF);

    }

    @Test
    public void testParse() {
        String toParse = "{\n"
                + "  \"id\":1,\n"
                + "  \"cpfCnpj\":\"12345678909\",\n"
                + "  \"nomeRazaoSocial\": \"Cadastro Cliente\",\n"
                + "  \"email\":\"cliente@mailinator.com\",\n"
                + "  \"referencia\":\"cliente\",\n"
                + "  \"pessoaJuridica\":true,\n"
                + "  \"pessoaId\":\"\",\n"
                + "  \"endereco\": {\n"
                + "            \"TipoLogradouro\" :\"Rua\",\n"
                + "            \"Logradouro\" :\"Fidêncio Ramos\",\n"
                + "            \"Numero\" :\"100\",\n"
                + "            \"Complemento\" :\"CJ 2\",\n"
                + "            \"Cep\" :\"04551-010\",\n"
                + "            \"Bairro\" :\"Vila olímpia\",\n"
                + "            \"Cidade\" :\"São Paulo\",\n"
                + "            \"Uf\" :\"SP\"\n"
                + "        }\n"
                + "}";

        Cliente cliente = WsHelper.unmarshal(toParse, Cliente.class);
        testeClienteParse(cliente);

    }

    public void testeClienteParse(Cliente c) {

        assertNotNull(c);
        assertEquals(ID, c.getId());
        assertEquals(CEP, c.getCpfcnpj());
        assertEquals(NOME_RAZAO_SOCIAL, c.getNomeRazaoSocial());
        assertEquals(EMAIL, c.getEmail());
        assertEquals(REFERENCIA, c.getReferencia());
        assertEquals(PESSOA_JURIDICA, c.isPessoaJurica());
        assertEquals(PESSOA_ID, c.getPessoaId());

        assertNotNull(c.getCliente());
        Endereco endereco = c.getEndereco();
        assertEquals(TIPO_LOGRADOURO, endereco.getTipoLogradouro());
        assertEquals(LOGRADOURO, endereco.getLogradouro());
        assertEquals(NUMERO, endereco.getNumero());
        assertEquals(COMPLENTO, endereco.getComplemento());
        assertEquals(CEP, endereco.getCep());
        assertEquals(BAIRRO, endereco.getBairro());
        assertEquals(CIDADE, endereco.getCidade());
        assertEquals(UF, endereco.getUf());

    }
}

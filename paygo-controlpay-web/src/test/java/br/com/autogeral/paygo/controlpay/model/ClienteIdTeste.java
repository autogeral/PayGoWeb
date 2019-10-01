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
public class ClienteIdTeste {

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
    private static final String LATITUDE = null;
    private static final String LONGITUDE = null;
    private static final String GEO_LOCALIZACAO = null;

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
    public void testParseData() {

        String toParse = "{\n"
                + "    \"data\": \"23/09/2019 13:34:48.7986\",\n"
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
                + "            \"latitude\": " + LATITUDE + ",\n"
                + "            \"longitude\": " + LONGITUDE + ",\n"
                + "            \"geoLocalizacao\": " + GEO_LOCALIZACAO + "\n"
                + "        }\n"
                + "    }\n"
                + "}";
        Data d = WsHelper.unmarshal(toParse, Data.class);
        assertNotNull(d);
        assertNotNull(d.getCliente());
        Cliente c = d.getCliente();
        testParseDataId(c);
    }

    private void testParseDataId(Cliente c) {

        assertNotNull(c);
        assertEquals(ID, c.getId());
        assertEquals(NOME_RAZAO_SOCIAL, c.getNomeRazaoSocial());
        assertEquals(CPF_CNPJ, c.getCpfCnpj());
        assertEquals(EMAIL, c.getEmail());
        assertEquals(TELEFONE, c.getTelefone());
        assertEquals(REFERENCIA, c.getReferencia());
        assertEquals(PESSOA_JURIDICA, c.isPessoaJuridica());
        Pessoa p = c.getPessoa();
        assertEquals(PESSOA_ID, p.getId());
        assertEquals(PESSOA_NOME_RAZAO_SOCIAL, p.getNomeRazaoSocial());
        assertEquals(PESSOA_SOBRENOME_NOME_FANTASIA, p.getSobrenomeNomeFantasia());
        Endereco e = c.getEndereco();
        assertEquals(TIPO_LOGRADOURO, e.getTipoLogradouro());
        assertEquals(LOGRADOURO, e.getLogradouro());
        assertEquals(NUMERO, e.getNumero());
        assertEquals(COMPLEMENTO, e.getComplemento());
        assertEquals(CEP, e.getCep());
        assertEquals(BAIRRO, e.getBairro());
        assertEquals(CIDADE, e.getCidade());
        assertEquals(UF, e.getUf());
        assertEquals(LATITUDE, e.getLatitude());
        assertEquals(LONGITUDE, e.getLongitude());
        assertEquals(GEO_LOCALIZACAO, e.getGeoLocalizacao());

    }
}

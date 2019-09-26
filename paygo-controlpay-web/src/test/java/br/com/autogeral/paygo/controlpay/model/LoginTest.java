/*
 * The MIT License
 *
 * Copyright 2019 Murilo Moraes Tuvani.
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
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Murilo Moraes Tuvani
 */
public class LoginTest {

    private static final String KEY = "qkXlNrmb1LADuF5ObyspYtmyt1dSu5vJaSdIMKd4eeUxFsIzTYn6VByDG629i3DrV%2bfQ2YQ4Z7KBYSvYZ%2fFw7lp%2b2xAwecK49PPxLETb5Tw%3d";
    private static final int ID = 8149;
    private static final String PESSOAJURIDICA = "true";
    private static final String NOME_RAZAO_SOCIAL = "AUTO GERAL AUTOPECAS LTDA";
    private static final String SOBRENOME_FANTASIA = "AUTO GERAL AUTOPECAS LTDA";
    private static final String CPF_CNPJ = "05437537000137";
    private static final String CPF_CNPJ_FORMAT = "05.437.537/0001-37";
    private static final String PESSOA_STATUS_NOME = "Ativo Vendedor";
    private static final String FOTO_THUMBNAIL = "http://pay2alldemo.azurewebsites.net/WebAPI/ImagensPessoas/_PessoaDefault.png";
    private static final String EMAIL = "kaique.motta@hotmai.com";
    private static final int PESSOA_STATUS_ID = 2;
    private static final String OPERADOR = null;
    private static final String ANDROID_VERSAOAPP = "3.3.1";
    private static final String IOS_VERSAOAPP = "3.2";
    private static final String APP = null;
    private static final String SENHA = "1234";

    /**
     * Test of getCpfCnpj method, of class Login.
     */
    @Test
    public void serialize() {
        Pessoa  p = new Pessoa();
        p.setKey(KEY);
        p.setId(ID);
        Login login = new Login();
        login.setCpfCnpj(CPF_CNPJ);
        login.setSenha(SENHA);
        p.setPessoaJuridica(PESSOAJURIDICA);
        p.setSobrenomeNomeFantasia(SOBRENOME_FANTASIA);
        p.setCpfCnpj(CPF_CNPJ);
        p.setCpfCnpjFormat(CPF_CNPJ_FORMAT);
        PessoaStatus status = new PessoaStatus();
        status.setId(PESSOA_STATUS_ID);
        status.setNome(PESSOA_STATUS_NOME);
        Data d = new Data();
        d.setOperador(OPERADOR);
        d.setApp(APP);
        Android android = new Android();
        android.setVersaoApp(ANDROID_VERSAOAPP);
        IOS ios = new IOS();
        ios.setVersaoApp(IOS_VERSAOAPP);
        
    }

    @Test
    public void test_serialize() {
        System.out.println("test_serialize");
        Login instance = new Login();
        instance.setCpfCnpj("" + CPF_CNPJ + "");
        instance.setSenha("" + SENHA + "");

        String result = WsHelper.marshal(instance);
        String expResult = "{\n"
                + "  \"cpfCnpj\": \"" + CPF_CNPJ + "\",\n"
                + "  \"senha\": \"" + SENHA + "\"\n"
                + "}";
        assertEquals(expResult, result);
    }

    @Test
    public void testParseData() {
        String toParse = "{\n"
                + "    \"data\": \"26/09/2019 15:22:46.6394\",\n"
                + "    \"pessoa\": {\n"
                + "        \"key\": \"" + KEY + "\",\n"
                + "        \"id\": " + ID + ",\n"
                + "        \"pessoaJuridica\": " + PESSOAJURIDICA + ",\n"
                + "        \"nomeRazaoSocial\": \"" + NOME_RAZAO_SOCIAL + "\",\n"
                + "        \"sobrenomeNomeFantasia\": \"" + SOBRENOME_FANTASIA + "\",\n"
                + "        \"cpfCnpj\": \"" + CPF_CNPJ + "\",\n"
                + "        \"cpfCnpjFormat\": \"" + CPF_CNPJ_FORMAT + "\",\n"
                + "        \"email\": \"" + EMAIL + "\",\n"
                + "        \"fotoThumbnail\": \"" + FOTO_THUMBNAIL + "\",\n"
                + "        \"pessoaStatus\": {\n"
                + "            \"id\": " + PESSOA_STATUS_ID + ",\n"
                + "            \"nome\": \"" + PESSOA_STATUS_NOME + "\"\n"
                + "        }\n"
                + "    },\n"
                + "    \"operador\": " + OPERADOR + ",\n"
                + "    \"android\": {\n"
                + "        \"versaoApp\": \"" + ANDROID_VERSAOAPP + "\"\n"
                + "    },\n"
                + "    \"ios\": {\n"
                + "        \"versaoApp\": \"" + IOS_VERSAOAPP + "\"\n"
                + "    },\n"
                + "    \"app\": " + APP + "\n"
                + "}";
        Data d = WsHelper.unmarshal(toParse, Data.class);
        assertNotNull(d);
        Pessoa p = d.getPessoa();
        testeParse(d);
    }

    private void testeParse(Data d) {
        assertNotNull(d);
        Pessoa p = d.getPessoa();
        assertEquals(KEY, p.getKey());
        assertEquals(ID, p.getId());
        assertEquals(PESSOAJURIDICA, p.getPessoaJuridica());
        assertEquals(NOME_RAZAO_SOCIAL, p.getNomeRazaoSocial());
        assertEquals(SOBRENOME_FANTASIA, p.getSobrenomeNomeFantasia());
        assertEquals(CPF_CNPJ, p.getCpfCnpj());
        assertEquals(CPF_CNPJ_FORMAT, p.getCpfCnpjFormat());
        assertEquals(EMAIL, p.getEmail());
        assertEquals(FOTO_THUMBNAIL, p.getFotoThumbnail());
        assertEquals(PESSOA_STATUS_ID, p.getPessoaStatus().getId());
        assertEquals(PESSOA_STATUS_NOME, p.getPessoaStatus().getNome());
        assertEquals(OPERADOR, d.getOperador());
        assertEquals(ANDROID_VERSAOAPP, d.getAndroid().getVersaoApp());
        assertEquals(IOS_VERSAOAPP, d.getIos().getVersaoApp());
        assertEquals(APP, d.getApp());

    }

}

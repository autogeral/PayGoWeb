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

public class TerminalTest {

    public class LoginResultadoTest {

       
/*
        @Test
        public void testSomeMethod() {
            String toParse = "{\"data\":\"" + DATA
                    + "\",\n"
                    + "\"pessoa\":{\"key\":\"" + HASH + "\",\n"
                    + "          \"id\":" + ID + ",\n"
                    + "          \"pessoaJuridica\":" + PESSOA_JURIDICA + ",\n"
                    + "          \"nomeRazaoSocial\":\"" + EMPRESA_NOME + "\",\n"
                    + "          \"sobrenomeNomeFantasia\":\"" + NOME_FANTASIA + "\",\n"
                    + "          \"cpfCnpj\":\"" + CNPJ + "\",\n"
                    + "          \"cpfCnpjFormat\":\"" + CNPJ_FORMATADO + "\",\n"
                    + "          \"email\":\"" + E_MAIL + "\",\n"
                    + "          \"fotoThumbnail\":\"" + FOTO_THUNBNAIL + "\",\n"
                    + "          \"pessoaStatus\":{\"id\":" + PESSOA_STATUS_ID + ",\n"
                    + "		                  \"nome\":\"" + PESSOA_STATUS_NOME + "\"}\n"
                    + "         },\n"
                    + "\"operador\":null,\n"
                    + "\"android\":{\"versaoApp\":\"" + APP_VERSAO_ANDROID + "\"},\n"
                    + "\"ios\":{\"versaoApp\":\"" + APP_VERSAO_IOS + "\"},\n"
                    + "\"app\":null}";
            LoginResultado d = WsHelper.unmarshal(toParse, LoginResultado.class);
            assertNotNull(d);
            assertNotNull(d.getPessoa());
            LoginPessoa p = d.getPessoa();
            testeParsePessoaPadrao(p);
            assertNotNull(d.getAndroid());
            assertEquals(APP_VERSAO_ANDROID, d.getAndroid().getVersaoApp());
            assertNotNull(d.getIos());
            assertEquals(APP_VERSAO_IOS, d.getIos().getVersaoApp());

        }

        private void testeParsePessoaPadrao(LoginPessoa p) {
            assertEquals(HASH, p.getKey());
            assertEquals(ID, p.getId());
            assertEquals(PESSOA_JURIDICA, p.isPessoaJuridica());
            assertEquals(EMPRESA_NOME, p.getNomeRazaoSocial());
            assertEquals(NOME_FANTASIA, p.getSobrenomeNomeFantasia());
            assertEquals(CNPJ, p.getCpfCnpj());
            assertEquals(CNPJ_FORMATADO, p.getCpfCnpjFormat());
            assertNotNull(p.getPessoaStatus());
            PessoaStatus status = p.getPessoaStatus();
            assertEquals(PESSOA_STATUS_ID, status.getId());
            assertEquals(PESSOA_STATUS_NOME, status.getNome());
        }
*/
    }
    
}

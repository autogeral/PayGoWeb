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
package br.com.autogeral.paygo.controlpay.web.operacional;

import br.com.autogeral.paygo.controlpay.model.Login;
import br.com.autogeral.paygo.controlpay.model.LoginResultado;
import br.com.autogeral.paygo.controlpay.web.ControlPayConfig;
import br.com.autogeral.paygo.controlpay.web.WsHelper;
import java.io.IOException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;

/**
 * 03/06/2019 13:42:22
 *
 * @author Murilo Moraes Tuvani
 */
public class LoginLogin  {

    private static final String PATH = "webapi/Login/Login/";
    private ControlPayConfig config;

    public LoginLogin(ControlPayConfig config) {
        this.config = config;
    }

    public LoginResultado autenticar() throws IOException {
        Login l = new Login();
        l.setCpfCnpj(config.getCpfCnpj());
        l.setSenha(config.getSenha());
        String json = WsHelper.getGson().toJson(l);
        RequestEntity requestEntity = new StringRequestEntity(
                json,
                "application/json",
                "UTF-8");

        PostMethod method = new PostMethod(getPath());
        method.addRequestHeader("Content-Type", "application/json");
        method.setRequestEntity(requestEntity);
        HttpClient client = new HttpClient();
        int result = client.executeMethod(method);

        System.out.println("Códiog HTTP : " + result);

        WsHelper.printHeaders(method);
        json = method.getResponseBodyAsString();
        System.out.println(json);
        LoginResultado data = WsHelper.unmarshal(json, LoginResultado.class);
        data.setHttpStatus(result);

        return data;
    }

    private String getPath() {
        String servidor = config.getServidor();
        if (!servidor.startsWith("http")) {
            servidor = "https://" + servidor;
        }
        if (!servidor.endsWith("/")) {
            servidor += "/";
        }
        return servidor + PATH;
    }

  
}

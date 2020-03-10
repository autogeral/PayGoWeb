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
package br.com.autogeral.paygo.controlpay.web.tokenizacao;

import br.com.autogeral.paygo.controlpay.model.ClienteCartao;
import br.com.autogeral.paygo.controlpay.model.DataToken;
import br.com.autogeral.paygo.controlpay.web.ControlPayConfig;
import br.com.autogeral.paygo.controlpay.web.WsHelper;
import java.io.IOException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;

/**
 *
 * @author kaique.mota
 */
public class ClienteCartaoById {

    private static final String PATH = "webapi/ClienteCartao/GetByClienteId?key=";
    private ControlPayConfig config;

    /**
     * API para consultar os cartões cadastrados para um cliente
     *
     * @return
     */
    public ClienteCartaoById(ControlPayConfig config) {
        this.config = config;
    }

    private String getPath(int clienteId) {
        String servidor = config.getServidor();
        if (!servidor.startsWith("http")) {
            servidor = "https://" + servidor;
        }
        if (!servidor.endsWith("/")) {
            servidor += "/";
        }
        return servidor + PATH + config.getKey() + "&clienteId=" + clienteId;
    }

    public DataToken consulta(ClienteCartao cc) throws IOException {
        int clienteId = cc.getCliente().getId();

        String json = WsHelper.getGson().toJson(cc);
        RequestEntity requestEntity = new StringRequestEntity(
                json,
                "application/json",
                "UTF-8");

        PostMethod method = new PostMethod(getPath(clienteId));
        method.addRequestHeader("Content-Type", "application/json");
        method.setRequestEntity(requestEntity);
        HttpClient client = new HttpClient();
        int result = client.executeMethod(method);

        String responseBody = method.getResponseBodyAsString();
        System.out.println(responseBody);
        DataToken data = WsHelper.unmarshal(responseBody, DataToken.class);

        data.setHttpStatus(result);
        return data;

    }
}

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
package br.com.autogeral.paygo.controlpay.web.pedido;

import br.com.autogeral.paygo.controlpay.model.Data;
import br.com.autogeral.paygo.controlpay.model.Pedido;
import br.com.autogeral.paygo.controlpay.web.ControlPayConfig;
import br.com.autogeral.paygo.controlpay.web.PermitAllCookiesSpec;
import br.com.autogeral.paygo.controlpay.web.WsHelper;
import java.io.IOException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;

/**
 *
 * @author kaique.mota
 */
public class PedidoCancelar {

    private static final String PATH = "/webapi/Pedido/Cancelar?key=";
    private ControlPayConfig config;

    /**
     * Retorna dados do pedido que foi Cancelado.
     *
     * @return
     */
    public PedidoCancelar(ControlPayConfig config) {

        this.config = config;
    }

    private String getPath(int pedidoId) {
        String servidor = config.getServidor();
        if (!servidor.startsWith("http")) {
            servidor = "https://" + servidor;
        }
        if (!servidor.endsWith("/")) {
            servidor += "/";
        }
        return servidor + PATH + config.getKey() + "&pedidoId=" + pedidoId;
    }

    public Data cancelar(Pedido p) throws IOException {

        int pedidoId = p.getPedidoId();
        GetMethod method = new GetMethod(getPath(pedidoId));
        method.addRequestHeader("Content-Type", "application/json");
        method.addRequestHeader("User-Agent", "Erpj/1.0");
        HttpClient client = new HttpClient();

        CookiePolicy.registerCookieSpec("PermitAllCookiesSpec", PermitAllCookiesSpec.class); 
        client.getParams().setCookiePolicy("PermitAllCookiesSpec");
        int result = client.executeMethod(method);

        WsHelper.printHeaders(method);
        String json = method.getResponseBodyAsString();
        System.out.println(json);
        Data data = WsHelper.unmarshal(json, Data.class);
        data.setHttpStatus(result);

        return data;
    }

}

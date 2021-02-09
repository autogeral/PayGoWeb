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
package br.com.autogeral.paygo.controlpay.impressao;

import br.com.autogeral.paygo.controlpay.model.Data;
import br.com.autogeral.paygo.controlpay.model.IntencaoImpressao;
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
public class IntencaoImpressaoId {

    private static final String PATH = "webapi/intencaoImpressao/GetById?key=";

    /**
     * API para consulta do status de uma impressão.
     *
     * Deve ser usada caso o callback (enviado ao término do trabalho de
     * impressão) não tenha sido recebido.
     *
     * @return
     */
    private String getPath(int numIntencao, ControlPayConfig config) {
      
        String servidor = config.getServidor();
        if (!servidor.startsWith("http")) {
            servidor = "https://" + servidor;
        }
        if (!servidor.endsWith("/")) {
            servidor += "/";
        }
        return servidor + PATH + config.getKey() + "&intencaoImpressaoId=" + numIntencao;
    }

    public Data imprimi(IntencaoImpressao intencaoImpressao, ControlPayConfig config) throws IOException {

        int numIntencao = intencaoImpressao.getIntencaoImpressao();
        GetMethod method = new GetMethod(getPath(numIntencao,config));
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

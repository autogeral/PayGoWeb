/*
 * The MIT License
 *
 * Copyright 2019 Murilo de Moraes Tuvani.
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

package br.com.autogeral.paygo.controlpay.web.transacional;

import br.com.autogeral.paygo.controlpay.model.Venda;
import br.com.autogeral.paygo.controlpay.web.ControlPayConfig;
import br.com.autogeral.paygo.controlpay.model.VendaVenderResultado;
import br.com.autogeral.paygo.controlpay.web.WsHelper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;

/**
 * 23/05/2019 17:56:32
 * @author Murilo de Moraes Tuvani
 */
public class VendaVender {
    
    private static final String PATH = "webapi/Venda/Vender/?key=";
    
    /**
     * Retorna a URL compra para o envio da requisição
     * para o endpoint de transacao de venda
     * @return 
     */
    private String getPath() {
        ControlPayConfig config = ControlPayConfig.getConfig();
        String servidor = config.getServidor();
        if (!servidor.startsWith("http")) {
            servidor = "https://" + servidor;
        }
        if (!servidor.endsWith("/")) {
            servidor += "/";
        }
        return servidor + PATH + config.getKey();
    }
    
    public VendaVenderResultado vender(Venda venda) throws IOException {
        venda.setTerminalId(ControlPayConfig.getConfig().getTerminal());
        
        String json = WsHelper.getGson().toJson(venda);
        RequestEntity requestEntity = new StringRequestEntity(
                json,
                "application/json",
                "UTF-8");
        
        PostMethod method = new PostMethod(getPath());
        method.addRequestHeader("Content-Type", "application/json");
        method.setRequestEntity(requestEntity);
        HttpClient client = new HttpClient();
        int result = client.executeMethod(method);
        
        VendaVenderResultado r = new VendaVenderResultado();
        r.setHttpStatus(result);
        
//        if (result == 200) {
            ByteArrayOutputStream baos = WsHelper.getResponseBody(method);
            String responseBody = baos.toString();
            System.out.println(responseBody);
//        }
        return r;
    }
    
}

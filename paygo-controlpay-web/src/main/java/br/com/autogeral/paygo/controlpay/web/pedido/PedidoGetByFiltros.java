package br.com.autogeral.paygo.controlpay.web.pedido;

import br.com.autogeral.paygo.controlpay.model.Data;
import br.com.autogeral.paygo.controlpay.model.Pedido;
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
public class PedidoGetByFiltros {

    private static final String PATH = "/webapi/Pedido/GetByFiltros?key=";
    private ControlPayConfig config;

    public PedidoGetByFiltros(ControlPayConfig config) {
        this.config = config;
    }

    private String getPath() {
        String servidor = config.getServidor();
        if (!servidor.startsWith("http")) {
            servidor = "https://" + servidor;
        }
        if (!servidor.endsWith("/")) {
            servidor += "/";
        }
        return servidor + PATH + config.getKey();
    }

    public Data get(Pedido p) throws IOException {

        String json = WsHelper.getGson().toJson(p);
        RequestEntity requestEntity = new StringRequestEntity(
                json,
                "application/json",
                "UTF-8");

        PostMethod method = new PostMethod(getPath());
        method.addRequestHeader("Content-Type", "application/json");
        method.setRequestEntity(requestEntity);
        HttpClient client = new HttpClient();
        int result = client.executeMethod(method);

        String responseBody = method.getResponseBodyAsString();
        System.out.println(responseBody);
        Data data = WsHelper.unmarshal(responseBody, Data.class);
        data.setHttpStatus(result);
        return data;
    }

}


package br.com.autogeral.paygo.controlpay.web.operacional;

import br.com.autogeral.paygo.controlpay.model.Data;
import br.com.autogeral.paygo.controlpay.model.Pessoa;
import br.com.autogeral.paygo.controlpay.web.ControlPayConfig;
import br.com.autogeral.paygo.controlpay.web.WsHelper;
import java.io.IOException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;

/**
 *
 *
 * @author kaique.mota
 */
/**
 * Para realizar transações nesta plataforma é necessário atrelar produtos às
 * vendas. Através desta API podemos consultar os produtos cadastrados ao
 * usuário. Por padrão, no momento da criação do usuário, cadastramos um produto
 * com nome genérico, com valor em aberto e sem controle de estoque
 *
 * @return
 */
public class ProdutoGetByPessoaId {

    private static final String PATH = "webapi/Produto/GetByPessoaId?key=";

    private String getPath(int pessoaId) {
        ControlPayConfig config = ControlPayConfig.getConfig();
        String servidor = config.getServidor();
        if (!servidor.startsWith("http")) {
            servidor = "https://" + servidor;
        }
        if (!servidor.endsWith("/")) {
            servidor += "/";
        }
        return servidor + PATH + config.getKey() + "&pessoaId=" + pessoaId;
    }

    public Data consulta(Pessoa pessoa) throws IOException {
        int pessoaId = pessoa.getId();

        String json = WsHelper.getGson().toJson(pessoaId);
        RequestEntity requestEntity = new StringRequestEntity(
                json,
                "application/json",
                "UTF-8");

        PostMethod method = new PostMethod(getPath(pessoaId));
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

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

import br.com.autogeral.paygo.controlpay.model.Data;
import br.com.autogeral.paygo.controlpay.model.Pessoa;
import br.com.autogeral.paygo.controlpay.web.ControlPayConfig;
import br.com.autogeral.paygo.controlpay.web.WsHelper;
import java.io.IOException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

/**
 *
 *
 * @kaique.mota
 */
/**
 * Esta API consulta as formas de pagamento disponíveis pela plataforma Control
 * Pay. O ID da forma de pagamento deverá ser enviado no instante de realizar
 * uma venda. Exemplos de formas de pagamento: TEF Crédito, TEF Débito,
 * e-Commerce, etc. As mais comuns são: 21-TEF Crédito 22-TEF Débito 23-TEF
 * Voucher 24-TEF Outros (Nada é enviado e o operador do caixa informará de
 * acordo com as opções que o adquirente disponibilizar) 51-Cartão de crédito
 * digitado (URL do gateways de pagamento é devolvdido para redirecionar o
 * usuário)
 *
 * @return
 */
public class FormaPagamentoGetByPessoaId {

    private static final String PATH = "/webapi/FormaPagamento/GetByPessoaId?key=";
    private ControlPayConfig config;

    public FormaPagamentoGetByPessoaId(ControlPayConfig config) {
        this.config = config;
    }

    private String getPath(int pessoaId) {
        String servidor = config.getServidor();
        if (!servidor.startsWith("http")) {
            servidor = "https://" + servidor;
        }
        if (!servidor.endsWith("/")) {
            servidor += "/";
        }
        return servidor + PATH + config.getKey() + "&pessoaId=" + pessoaId;
    }

    public Data pesquisa(Pessoa pessoa) throws IOException {

        int pessoaId = pessoa.getId();
        GetMethod method = new GetMethod(getPath(pessoaId));
        method.addRequestHeader("Content-Type", "application/json");
        HttpClient client = new HttpClient();

        int result = client.executeMethod(method);

        WsHelper.printHeaders(method);
        String json = method.getResponseBodyAsString();
        System.out.println(json);
        Data data = WsHelper.unmarshal(json, Data.class);
        data.setHttpStatus(result);

        return data;
    }
}

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
package br.com.autogeral.paygo.controlpay.web;

import br.com.autogeral.paygo.controlpay.model.Cliente;
import br.com.autogeral.paygo.controlpay.model.ClienteCartao;
import br.com.autogeral.paygo.controlpay.model.DataToken;
import br.com.autogeral.paygo.controlpay.web.tokenizacao.ClienteCartaoById;
import java.io.IOException;

/**
 *
 * @author kaique.mota
 */
public class ConsutarCartaoId {

    public static void main(String[] args) throws IOException {
        ClienteCartaoById clienteCartaoById = new ClienteCartaoById();
        ClienteCartao cc = new ClienteCartao();
        Cliente cliente = new Cliente();
        cliente.setId(1);
        cc.setCliente(cliente);

        DataToken consulta = clienteCartaoById.consulta(cc);
    }

}

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

import br.com.autogeral.paygo.controlpay.web.transacional.PedidoInsertVenda;
import br.com.autogeral.paygo.controlpay.model.Data;
import br.com.autogeral.paygo.controlpay.model.FormaPagamento;
import br.com.autogeral.paygo.controlpay.model.Produto;
import br.com.autogeral.paygo.controlpay.model.IntencaoVenda;
import br.com.autogeral.paygo.controlpay.model.IntencaoVendaPesquisa;
import br.com.autogeral.paygo.controlpay.model.LoginResultado;
import br.com.autogeral.paygo.controlpay.model.Pedido;
import br.com.autogeral.paygo.controlpay.model.PedidoFormaPagamento;
import br.com.autogeral.paygo.controlpay.web.operacional.LoginLogin;
import br.com.autogeral.paygo.controlpay.web.operacional.TerminalGetByPessoaId;
import br.com.autogeral.paygo.controlpay.web.transacional.IntencaoVendaGet;
import java.io.IOException;

/**
 *
 * @author kaique.mota
 */
public class InserirPedido {

    public static void main(String[] args) throws IOException {

        Pedido p = new Pedido();
        Produto pr = new Produto();

        PedidoInsertVenda piv = new PedidoInsertVenda();

        p.setPessoaVendedorId(1);
        p.setReferencia("REF 020");
        p.setValorTotalPedido(10);

        Produto produto = new Produto();
        produto.setId(2075);
        produto.setNome("TESTE");
        produto.setQuantidade(1);
        produto.setValor(10);
        p.getProdutosPedido().add(produto);

        FormaPagamento formaPagamento = new FormaPagamento();
        PedidoFormaPagamento pfg = new PedidoFormaPagamento();
        formaPagamento.setId(21);
        pfg.setFormaPagamento(formaPagamento);
        pfg.setQuantidadeMaximaParcelas(1);
        pfg.setAdquirente("cielo");

        p.getPedidoFormasPagamento().add(pfg);
        //       p.setPedidoFormasPagamento(Arrays.asList(pfg));

        Data ped = piv.inserirPedido(p);
    }

}

package br.com.autogeral.paygo.controlpay.web;

import br.com.autogeral.paygo.controlpay.web.transacional.PedidoInsertVenda;
import br.com.autogeral.paygo.controlpay.model.Data;
import br.com.autogeral.paygo.controlpay.model.FormaPagamento;
import br.com.autogeral.paygo.controlpay.model.Produto;
import br.com.autogeral.paygo.controlpay.model.Pedido;
import br.com.autogeral.paygo.controlpay.model.PedidoFormaPagamento;
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
        p.setReferencia("a05");
        p.setValorTotalPedido(200);

        Produto produto = new Produto();
        produto.setId(2075);
        produto.setNome("TESTE");
        produto.setQuantidade(1);
        produto.setValor("200");
        p.getProdutosPedido().add(produto);

        FormaPagamento formaPagamento = new FormaPagamento();
        PedidoFormaPagamento pfg = new PedidoFormaPagamento();
        formaPagamento.setId(21);
        pfg.setFormaPagamento(formaPagamento);
        pfg.setQuantidadeMaximaParcelas(1);
        pfg.setAdquirente("cielo");
        p.getPedidoFormasPagamento().add(pfg);
        Data ped = piv.inserirPedido(p);
        //       p.setPedidoFormasPagamento(Arrays.asList(pfg));

//       Data data = new Data();
        //  data.getPedidoInsertVenda().add(ped);
    }

}

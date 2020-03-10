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
        String key = "tgy8LUCZhHpwwKtEyB5t%2bAmWo9ayJrBLaHC4qUWSUkdDX%2fy35tDDoko8rasNz6QrPDvXPtZH4a4RRU1uyd4C0Z96NaqOu%2bjNh%2fxTr%2f6A%2fJQ%3d";
        String terminal = "900";
        String cpfCnpj = "05437537000137";
        String senha = "autogeral";
        String servidor = "pay2alldemo.azurewebsites.net";
        String senhaTecnica = "314159";
        ControlPayConfig config = new ControlPayConfig(key, servidor, terminal, cpfCnpj, senha, senhaTecnica);

        Pedido p = new Pedido();
        Produto pr = new Produto();

        PedidoInsertVenda piv = new PedidoInsertVenda(config);

        p.setReferencia("1016490");
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

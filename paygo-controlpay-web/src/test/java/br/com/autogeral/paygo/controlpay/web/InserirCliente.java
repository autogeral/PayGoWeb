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
import br.com.autogeral.paygo.controlpay.model.Data;
import br.com.autogeral.paygo.controlpay.model.Endereco;
import br.com.autogeral.paygo.controlpay.web.cliente.ClienteInsert;
import java.io.IOException;

/**
 *
 * @author kaique.mota
 */
public class InserirCliente {

    public static void main(String[] args) throws IOException {
        String key = "tgy8LUCZhHpwwKtEyB5t%2bAmWo9ayJrBLaHC4qUWSUkdDX%2fy35tDDoko8rasNz6QrPDvXPtZH4a4RRU1uyd4C0Z96NaqOu%2bjNh%2fxTr%2f6A%2fJQ%3d";
        String terminal = "900";
        String cpfCnpj = "05437537000137";
        String senha = "autogeral";
        String servidor = "pay2alldemo.azurewebsites.net";
        String senhaTecnica = "314159";
        ControlPayConfig config = new ControlPayConfig(key, servidor, terminal, cpfCnpj, senha, senhaTecnica);

        Cliente c = new Cliente();
        Endereco end = new Endereco();
        ClienteInsert ci = new ClienteInsert(config);

        c.setId(3);
        c.setCpfCnpj("05437537000137");
        c.setNomeRazaoSocial("Cadastrode Cliente");
        c.setEmail("kaique.motta@hotmail.com");
        c.setReferencia("Cliente");
        c.setPessoaJuridica(false);
        c.setPessoaId(1);

        c.setEndereco(end);
        end.setTipoLogradouro("Rua");
        end.setLogradouro("Manoel Lessa");
        end.setNumero("100");
        end.setComplemento("Casa 2");
        end.setCep("18131-418");
        end.setBairro("Vila Nova");
        end.setCidade("São Roque");
        end.setUf("SP");

        Data ins = ci.insert(c);

        /*    pfg.setFormaPagamento(formaPagamento);
        pfg.setQuantidadeMaximaParcelas(1);
        pfg.setAdquirente("cielo");

        p.getPedidoFormasPagamento().add(pfg);
        //       p.setPedidoFormasPagamento(Arrays.asList(pfg));

        Data ped = piv.inserirPedido(p);
    }
         */
    }

}

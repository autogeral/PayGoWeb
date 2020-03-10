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

import br.com.autogeral.paygo.controlpay.model.Data;
import br.com.autogeral.paygo.controlpay.model.Pedido;
import br.com.autogeral.paygo.controlpay.web.pedido.PedidoGetById;
import java.io.IOException;

/**
 *
 * @author kaique.mota
 */
public class PesquisaPedidoEspecifico {

    public static void main(String[] args) throws IOException {
        String key = "tgy8LUCZhHpwwKtEyB5t%2bAmWo9ayJrBLaHC4qUWSUkdDX%2fy35tDDoko8rasNz6QrPDvXPtZH4a4RRU1uyd4C0Z96NaqOu%2bjNh%2fxTr%2f6A%2fJQ%3d";
        String terminal = "900";
        String cpfCnpj = "05437537000137";
        String senha = "autogeral";
        String servidor = "pay2alldemo.azurewebsites.net";
        String senhaTecnica = "314159";
        ControlPayConfig config = new ControlPayConfig(key, servidor, terminal, cpfCnpj, senha, senhaTecnica);

        PedidoGetById pgbi = new PedidoGetById(config);
        Pedido pedido = new Pedido();

        pedido.setPedidoId(3273);

        Data ped = pgbi.execute(pedido);
        System.out.println("");
    }
}

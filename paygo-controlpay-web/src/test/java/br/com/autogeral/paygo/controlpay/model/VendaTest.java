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
package br.com.autogeral.paygo.controlpay.model;

import br.com.autogeral.paygo.controlpay.web.WsHelper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Murilo Moraes Tuvani
 */
public class VendaTest {
    
    @Test
    public void test01_serialize() {
        Venda instance = new Venda();
        instance.setAdquirente("");
        instance.setFormaPagamentoId(21);
        instance.setQuantidadeParcelas(1);

        ProdutoVenda pv = new ProdutoVenda();
        pv.setValor(1);
        pv.setQuantidade(1);
        instance.getProdutosVendidos().add(pv);
        
        String a =         "{\"formaPagamentoId\":21,\"terminalId\":null,\"referencia\":null,\"aguardarTefIniciarTransacao\":true,\"parcelamentoAdmin\":null,\"quantidadeParcelas\":1,\"adquirente\":\"\",\"produtosVendidos\":[{\"produtoItemId\":0,\"Id\":0,\"nome\":null,\"quantidade\":1.0,\"valor\":1.0}]}" ;
        String expResult = "{\"formaPagamentoId\":21,\"terminalId\":null,\"referencia\":null,\"aguardarTefIniciarTransacao\":true,\"parcelamentoAdmin\":null,\"quantidadeParcelas\":1,\"adquirente\":\"\",\"produtosVendidos\":[{\"Id\":\"\",\"Valor\":\"1.00\",\"Quantidade\":\"1\"}]}";
        String result = WsHelper.getGson().toJson(instance);
        System.out.println(result);
        assertEquals(expResult, result);
    }

}

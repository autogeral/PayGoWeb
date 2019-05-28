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
public class VendaVOTest {

    private static Gson gson;
    
    public VendaVOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        gson = new GsonBuilder()
                .serializeNulls()
                .setDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
                .create();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Test
    public void test01_parseSimples() {
        VendaVO instance = new VendaVO();
        instance.setTerminalId(999);
        instance.setReferencia("VENDA123456789");
        instance.setAdquirente("ABC");
        instance.setFormaPagamentoId(100);
        instance.setQuantidadeParcelas(1);
        instance.setValorTotalVendido(1234567.89d);
        String expResult = "{\"formaPagamentoId\":100,\"terminalId\":999,\"referencia\":\"VENDA123456789\",\"aguardarTefIniciarTransacao\":false,\"parcelamentoAdmin\":null,\"quantidadeParcelas\":1,\"adquirente\":\"ABC\",\"valorTotalVendido\":1234567.89}";
        String result = gson.toJson(instance);
        System.out.println(result);
        assertEquals(expResult, result);
    }

}

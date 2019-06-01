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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class VendaVenderResultadoVOTest {
    
    public VendaVenderResultadoVOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void test_serializacao() throws ParseException {
        System.out.println("serializacao");
        VendaVenderResultadoVO vv = new VendaVenderResultadoVO();
        Date data = (new SimpleDateFormat("HH:mm:ss dd/MM/yyyy")).parse("19:30:25 26/11/1980");
        vv.setData(data);
        IntecaoVendaVO iv = new IntecaoVendaVO();
        vv.setIntencaoVenda(iv);
        
        
        String result = WsHelper.marshal(vv);
        
        String expResult = "{}";
        assertEquals(expResult, result);
    }
    
    @Test
    public void test_deserializacao() {
        String response = "{\n"
                + "  \"data\": \"17/11/2016 17:40:37.9417\",\n"
                + "  \"intencaoVenda\": {\n"
                + "    \"id\": 23451,\n"
                + "    \"token\": \"243564\",\n"
                + "    \"data\": \"17/11/2016 17:40:21.0000\",\n"
                + "    \"hora\": \"17:40:21\",\n"
                + "    \"quantidade\": 1,\n"
                + "    \"valorOriginal\": 1,\n"
                + "    \"valorOriginalFormat\": \"1,00\",\n"
                + "    \"valorAcrescimo\": 0,\n"
                + "    \"valorAcrescimoFormat\": \"0,00\",\n"
                + "    \"valorDesconto\": 0,\n"
                + "    \"valorDescontoFormat\": \"0,00\",\n"
                + "    \"valorFinal\": 1,\n"
                + "    \"valorFinalFormat\": \"1,00\",\n"
                + "    \"gate2allToken\": null,\n"
                + "    \"quantidadeParcelas\": 1,\n"
                + "    \"urlPagamento\": null,\n"
                + "    \"formaPagamento\": {\n"
                + "      \"id\": 21,\n"
                + "      \"nome\": \"TEF\",\n"
                + "      \"modalidade\": \"Crédito\",\n"
                + "      \"fluxoPagamento\": {\n"
                + "        \"id\": 21,\n"
                + "        \"nome\": \"TEF\"\n"
                + "      }\n"
                + "    },\n"
                + "    \"terminal\": {\n"
                + "      \"id\": 81,\n"
                + "      \"nome\": \"CAIXA 01\"\n"
                + "    },\n"
                + "    \"pagamentosExterno\": [\n"
                + "      {\n"
                + "        \"id\": 1571,\n"
                + "        \"tipo\": 5,\n"
                + "        \"origem\": 5,\n"
                + "        \"tipoParcelamento\": 2,\n"
                + "        \"pagamentoExternoStatus\": {\n"
                + "          \"id\": 15,\n"
                + "          \"nome\": \"Finalizado\"\n"
                + "        }\n"
                + "      }\n"
                + "    ],\n"
                + "    \"intencaoVendaStatus\": {\n"
                + "      \"id\": 15,\n"
                + "      \"nome\": \"Expirado\"\n"
                + "    },\n"
                + "    \"cliente\": null,\n"
                + "    \"produtos\": [\n"
                + "      {\n"
                + "        \"itemProdutoId\": 13626,\n"
                + "        \"id\": 2,\n"
                + "        \"nome\": \"Refeição\",\n"
                + "        \"quantidade\": 1,\n"
                + "        \"valor\": \"1,00\"\n"
                + "      }\n"
                + "    ],\n"
                + "    \"pedido\": null\n"
                + "  }\n"
                + "}";
        VendaVenderResultadoVO vv = WsHelper.unmarshal(response, VendaVenderResultadoVO.class);
    }

}

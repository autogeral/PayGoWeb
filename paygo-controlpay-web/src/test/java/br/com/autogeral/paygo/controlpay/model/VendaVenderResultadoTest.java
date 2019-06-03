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
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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
public class VendaVenderResultadoTest {
    
    public VendaVenderResultadoTest() {
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
        VendaVenderResultado vv = new VendaVenderResultado();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSSS");
        NumberFormat decimalFormat = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
        decimalFormat.setMinimumFractionDigits(2);
        decimalFormat.setMaximumFractionDigits(2);
        
        Date data = sdf.parse("17/11/2016 17:40:37.9417");
        vv.setData(data);
        IntencaoVenda iv = new IntencaoVenda();
        vv.setIntencaoVenda(iv);
        iv.setId(68240);
        iv.setReferencia("Venda1234");
        iv.setToken("855002");
        
        data = sdf.parse("30/05/2019 16:51:05.0000");
        iv.setData(data);
        iv.setHora(data);
        
        double valor = 1d;
        iv.setValorOriginal(valor);
        iv.setValorDescontoFormat(decimalFormat.format(valor));
        
        iv.setValorFinal(valor);
        iv.setValorFinalFormat(decimalFormat.format(valor));

        valor = 0;
        iv.setValorAcrescimo(valor);
        iv.setValorAcrescimoFormat(decimalFormat.format(valor));

        iv.setValorDesconto(valor);
        iv.setValorDescontoFormat(decimalFormat.format(valor));
        
        iv.setQuantidadeParcelas(1);
        FormaPagamento fp = new FormaPagamento();
        fp.setId(22);
        fp.setNome("TEF");
        fp.setModalidade("Débito");
        
        FluxoPagamento fxp = new FluxoPagamento();
        fxp.setId(21);
        fxp.setNome("TEF");
        fp.setFluxoPagamento(fxp);
        iv.setFormaPagamento(fp);
        
        Terminal terminal = new Terminal();
        terminal.setId(868);
        terminal.setNome("Terminal 01");
        iv.setTerminal(terminal);
        
        PagamentoExterno pe = new PagamentoExterno();
        pe.setId(49946);
        pe.setTipo(5);
        pe.setOrigem(5);
        pe.setTipoParcelamento(2);
        PagamentoExternoStatus peStatus = new PagamentoExternoStatus();
        peStatus.setId(10);
        peStatus.setNome("Em Operação");
        pe.setPagamentoExternoStatus(peStatus);
        
        List<PagamentoExterno> pes = new ArrayList<>();
        pes.add(pe);
        iv.setPagamentosExternos(pes);
        
        IntencaoVendaStatus ivs = new IntencaoVendaStatus();
        ivs.setId(6);
        ivs.setNome("Em Pagamento");
        iv.setIntencaoVendaStatus(ivs);
        
        String result = WsHelper.marshal(vv);
        System.out.println(result);
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
        VendaVenderResultado vv = WsHelper.unmarshal(response, VendaVenderResultado.class);
        Date dataRequiscao = vv.getData();
        Calendar cal = Calendar.getInstance();
        cal.setTime(dataRequiscao);
        assertEquals(2016, cal.get(Calendar.YEAR));
        assertEquals(Calendar.NOVEMBER, cal.get(Calendar.MONTH));
        assertEquals(17, cal.get(Calendar.DAY_OF_MONTH));
        
        assertNotNull(vv.getIntencaoVenda());
    }

}

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
package br.com.autogeral.paygo.controlpay.web;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Date;
import java.util.Locale;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Murilo Moraes Tuvani
 */
public class WsHelperTest {
    
    public WsHelperTest() {
    }
    
    /**
     * Test of marshal method, of class WsHelper.
     */
    @Test
    public void test_marshal_datetime() throws ParseException {
        System.out.println("marshal_datetime");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSSS");
        NumberFormat decimalFormat = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
        decimalFormat.setMinimumFractionDigits(2);
        decimalFormat.setMaximumFractionDigits(2);
        Date data = sdf.parse("17/11/2016 17:40:37.9417");
        
        String descricao = "Uma nnova canção, Já!";
        LocalDate localDate = LocalDate.of(2016, Month.NOVEMBER, 17);
        LocalTime localTime = LocalTime.of(17, 40, 37, 9417);
        
        UmaClasseAleatoria uca = new UmaClasseAleatoria();
        uca.setShortId(12);
        uca.setLongId(121L);
        uca.setDataHora(data);
        uca.setData(localDate);
        uca.setHora(localTime);
        uca.setDescricao(descricao);
        uca.setValor(12345.6789);
        
        
        String expResult = "{}";
        String result = WsHelper.marshal(uca);
        System.out.println(result);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of unmarshal method, of class WsHelper.
     */
    @Test
    public void testUnmarshal() {
        System.out.println("unmarshal");
        Object expResult = null;
    }
    
    public class UmaClasseAleatoria {
        private Long longId;
        private int shortId;
        private String descricao;
        private Date dataHora;
        private LocalDate data;
        private LocalTime hora;
        private double  valor;

        public Long getLongId() {
            return longId;
        }

        public void setLongId(Long longId) {
            this.longId = longId;
        }

        public int getShortId() {
            return shortId;
        }

        public void setShortId(int shortId) {
            this.shortId = shortId;
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public Date getDataHora() {
            return dataHora;
        }

        public void setDataHora(Date dataHora) {
            this.dataHora = dataHora;
        }

        public LocalDate getData() {
            return data;
        }

        public void setData(LocalDate data) {
            this.data = data;
        }

        public LocalTime getHora() {
            return hora;
        }

        public void setHora(LocalTime hora) {
            this.hora = hora;
        }

        public double getValor() {
            return valor;
        }

        public void setValor(double valor) {
            this.valor = valor;
        }
        
        
    }
}

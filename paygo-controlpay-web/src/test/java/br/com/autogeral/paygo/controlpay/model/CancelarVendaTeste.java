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
package br.com.autogeral.paygo.controlpay.model;

import br.com.autogeral.paygo.controlpay.web.ControlPayConfig;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author kaique.mota
 */
public class CancelarVendaTeste {

    private static final int ID_INTENCAO_VENDA = 23456;
    private static final String TERMINAL = "";
    private static final boolean AGUARDAR_TEF_INICIAR_TRANSCAO = false;
    private static final String SENHA_TECNICA = "314159";

    @Test
    public void serialize() {
        IntencaoVenda intencaoVenda = new IntencaoVenda();
        Venda venda = new Venda();
        intencaoVenda.setId(ID_INTENCAO_VENDA);
        intencaoVenda.setTerminalId(ID_INTENCAO_VENDA);
        venda.setAguardarTefIniciarTransacao(AGUARDAR_TEF_INICIAR_TRANSCAO);
        IntencaoVendaPesquisa ivp = new IntencaoVendaPesquisa(intencaoVenda);
        ivp.setSenhaTecnica(ControlPayConfig.getConfig().getSenhaTecnica());

    }

    public void test_Parse() {
        String toParse = "  data \"{\n"
                + "    \"intencaoVendaId\\\":\\\"23456\\\",\n"
                + "    \"terminalId\\\": \\\"\\\",\n"
                + "    \"aguardarTefIniciarTransacao\\\": false,\n"
                + "    \"senhaTecnica\\\": \\\"314159\\\"\n"
                + "}\"";
    }

    private void testCancelamento(IntencaoVenda intencaoVenda) {
        assertNotNull(intencaoVenda);
        
        assertEquals(ID_INTENCAO_VENDA, intencaoVenda.getId());
        assertEquals(TERMINAL, intencaoVenda.getTerminal());
        Venda venda = new Venda();
        assertEquals(AGUARDAR_TEF_INICIAR_TRANSCAO,venda.isAguardarTefIniciarTransacao());
        IntencaoVendaPesquisa ivp = new IntencaoVendaPesquisa(intencaoVenda);
        assertEquals(SENHA_TECNICA, ivp.getSenhaTecnica());
    }
}

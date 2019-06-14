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

import br.com.autogeral.paygo.controlpay.model.Data;
import br.com.autogeral.paygo.controlpay.model.IntencaoVenda;
import br.com.autogeral.paygo.controlpay.model.IntencaoVendaPesquisa;
import br.com.autogeral.paygo.controlpay.model.LoginResultado;
import br.com.autogeral.paygo.controlpay.model.Venda;
import br.com.autogeral.paygo.controlpay.web.operacional.LoginLogin;
import br.com.autogeral.paygo.controlpay.web.operacional.TerminalGetByPessoaId;
import br.com.autogeral.paygo.controlpay.web.transacional.IntencaoVendaGet;
import br.com.autogeral.paygo.controlpay.web.transacional.VendaVender;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 07/06/2019 22:12:24
 * @author Murilo Moraes Tuvani
 */
public class RoteiroHomologacao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            LoginLogin ll = new LoginLogin();
            LoginResultado loginData = ll.autenticar();
            TerminalGetByPessoaId lgb = new TerminalGetByPessoaId();
            Data terminais = lgb.execute(loginData);

            System.out.println("Status HTTP : " + terminais.getHttpStatus());
            if (terminais.getHttpStatus() == 200 && !terminais.getTerminais().isEmpty()) {
                int terminalId = terminais.getTerminais().get(0).getId();
                Venda venda = new Venda();
                venda.setTerminalId(Integer.toString(terminalId));
                venda.setAdquirente("REDE");
                venda.setFormaPagamentoId(21);
                venda.setQuantidadeParcelas(2);
                venda.setValorTotalVendido(40d);
                VendaVender vv = new VendaVender();
                Data vendaData = vv.vender(venda);
                
                if (vendaData != null && vendaData.getIntencaoVenda() != null) {
                    IntencaoVenda iv = vendaData.getIntencaoVenda();
                    IntencaoVendaGet ivg = new IntencaoVendaGet();
                    IntencaoVendaPesquisa ivp = new IntencaoVendaPesquisa(iv);
                    vendaData = ivg.get(ivp);
                }
            }
            
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(RoteiroHomologacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

}

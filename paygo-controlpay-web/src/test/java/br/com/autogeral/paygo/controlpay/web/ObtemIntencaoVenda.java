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
import br.com.autogeral.paygo.controlpay.model.PagamentoExterno;
import br.com.autogeral.paygo.controlpay.web.transacional.IntencaoVendaGet;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 13/06/2019 23:19:24
 * @author Murilo Moraes Tuvani
 */
public class ObtemIntencaoVenda {
    
    public static void main(String[] args) {
        try {
            IntencaoVenda iv = new IntencaoVenda();
            iv.setId(72228);
            IntencaoVendaGet ivg = new IntencaoVendaGet();
            IntencaoVendaPesquisa ivp = new IntencaoVendaPesquisa(iv);
            Data data = ivg.get(ivp);
                
            
               System.out.println(""+data.getData());
               System.out.println("fICOU ATNES DA DATA");
               System.out.println(""+data.getIntencoesVendas());
                
            if (data.getIntencoesVendas() != null) {
                for (IntencaoVenda ivl : data.getIntencoesVendas()) {
                    if (ivl.getPagamentosExternos() != null) {
                        System.out.println("Printa externo"+ivl.getPagamentosExternos());
                        
                        for (PagamentoExterno pe : ivl.getPagamentosExternos()) {
                            String comprovante = pe.getComprovanteAdquirente();
                            System.out.println(comprovante);
                        }
                    }
                }
            } else {
                System.out.println("Nenhum intencao de venda encontrada");
            }
        } catch (IOException ex) {
            Logger.getLogger(ObtemIntencaoVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
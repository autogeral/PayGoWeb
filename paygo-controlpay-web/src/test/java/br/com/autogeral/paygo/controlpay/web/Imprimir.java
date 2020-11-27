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

import br.com.autogeral.paygo.controlpay.impressao.ImprimeComprovanteCancelamentoIntencaoVenda;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintException;

/**
 *
 * @author kaique.mota
 */
public class Imprimir {

    public static void main(String[] args) throws IOException {
    	 String key = "Iquz3TZ7n7U%2bja8y7qi40Koj%2fEV6UYWBU%2beSxyev1w0EoTvQIc8t2MHR%2bMOLXcvJPyC3HliQMvs8ZNPp4xCMZEtm%2fZGXate9%2fh%2ffkf5pXniC9uELSYOQ4nnz%2fbw1u%2fpx";
         String terminal = "88";
         String cpfCnpj = "05437537000307";
         String senha = "autogeral";
         String servidor = "controlpay.ntk.com.br";
         String senhaTecnica = "314159";
            ControlPayConfig config = new ControlPayConfig(key, servidor, terminal, cpfCnpj, senha, senhaTecnica);
            
        ImprimeComprovanteCancelamentoIntencaoVenda ImprimeComprovante = new ImprimeComprovanteCancelamentoIntencaoVenda(config);
        try {
            ImprimeComprovante.prrenche(81462) ;
        } catch (PrintException ex) {
            Logger.getLogger(Imprimir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

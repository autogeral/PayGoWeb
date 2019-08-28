package br.com.autogeral.paygo.controlpay.web;

import br.com.autogeral.paygo.controlpay.web.transacional.VendaCancelarVenda;
import br.com.autogeral.paygo.controlpay.model.Data;
import br.com.autogeral.paygo.controlpay.model.IntencaoVenda;
import br.com.autogeral.paygo.controlpay.model.IntencaoVendaPesquisa;
import br.com.autogeral.paygo.controlpay.model.PagamentoExterno;
import br.com.autogeral.paygo.controlpay.web.transacional.IntencaoVendaGet;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kaique.mota
 */
public class CancelamentoVenda {

    public static void main(String[] args) {

        try {

            VendaCancelarVenda cl = new VendaCancelarVenda();
            IntencaoVenda iv = new IntencaoVenda();
            iv.setId(72219);
            IntencaoVendaGet ivg = new IntencaoVendaGet();
            IntencaoVendaPesquisa ivp = new IntencaoVendaPesquisa(iv);
            Data data = cl.canc(ivp);

        } catch (IOException ex) {
            Logger.getLogger(ObtemIntencaoVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

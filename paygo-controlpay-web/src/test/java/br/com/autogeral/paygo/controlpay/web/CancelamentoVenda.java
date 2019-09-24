package br.com.autogeral.paygo.controlpay.web;
import br.com.autogeral.paygo.controlpay.model.Data;
import br.com.autogeral.paygo.controlpay.web.transacional.VendaCancelarVenda;
import br.com.autogeral.paygo.controlpay.model.IntencaoVenda;
import br.com.autogeral.paygo.controlpay.model.VendaCancelamento;
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
            VendaCancelamento cancelamento = new VendaCancelamento();
            
            cancelamento.setIntencaoVendaId("73343");
            cancelamento.setAguardarTefIniciarTransacao(true);
            cancelamento.setSenhaTecnica(ControlPayConfig.getConfig().getSenhaTecnica());
            cancelamento.setTerminalId("900");

            Data cancelar = cl.canc(cancelamento);

        } catch (IOException ex) {
            Logger.getLogger(ObtemIntencaoVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

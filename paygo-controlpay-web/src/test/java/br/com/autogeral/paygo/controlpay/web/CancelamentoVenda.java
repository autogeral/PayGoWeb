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
            String key ="tgy8LUCZhHpwwKtEyB5t%2bAmWo9ayJrBLaHC4qUWSUkdDX%2fy35tDDoko8rasNz6QrPDvXPtZH4a4RRU1uyd4C0Z96NaqOu%2bjNh%2fxTr%2f6A%2fJQ%3d";
            String terminal = "900";
            String cpfCnpj = "05437537000137";
            String senha = "autogeral";
            String servidor = "pay2alldemo.azurewebsites.net";
            String senhaTecnica= "314159";
            ControlPayConfig config = new ControlPayConfig(key, servidor, terminal, cpfCnpj, senha, senhaTecnica);
            
            VendaCancelarVenda cl = new VendaCancelarVenda(config);
            IntencaoVenda iv = new IntencaoVenda();
            VendaCancelamento cancelamento = new VendaCancelamento();
            
            cancelamento.setIntencaoVendaId("73509");
            cancelamento.setAguardarTefIniciarTransacao(true);
            cancelamento.setSenhaTecnica(config.getSenhaTecnica());
            cancelamento.setTerminalId("900");

            Data cancelar = cl.canc(cancelamento);

        } catch (IOException ex) {
            Logger.getLogger(ObtemIntencaoVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

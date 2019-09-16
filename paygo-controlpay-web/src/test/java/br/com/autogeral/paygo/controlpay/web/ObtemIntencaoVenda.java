
package br.com.autogeral.paygo.controlpay.web;

import br.com.autogeral.paygo.controlpay.model.Data;
import br.com.autogeral.paygo.controlpay.model.IntencaoVenda;
import br.com.autogeral.paygo.controlpay.model.IntencaoVendaPesquisa;
import br.com.autogeral.paygo.controlpay.model.PagamentoExterno;
import br.com.autogeral.paygo.controlpay.web.transacional.IntencaoVendaGet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 13/06/2019 23:19:24
 *
 * @author Murilo Moraes Tuvani
 */
public class ObtemIntencaoVenda {

    public static void main(String[] args) {
        try {
            IntencaoVenda iv = new IntencaoVenda();
            iv.setId(73131);
            IntencaoVendaGet ivg = new IntencaoVendaGet();
            IntencaoVendaPesquisa ivp = new IntencaoVendaPesquisa(iv);
            Data data = ivg.get(ivp);
            List<String> listaComprovantes = new ArrayList<>();

            data.getIntencoesVendas().stream().forEach(intencaoVenda -> {
                intencaoVenda.getPagamentosExternos().stream().forEach(pagamento -> listaComprovantes.add(pagamento.getComprovanteAdquirente()
                ));
            });
            
            System.out.println(listaComprovantes);

            System.out.println("" + data.getData());
            System.out.println("fICOU ATNES DA DATA");
            System.out.println("" + data.getIntencoesVendas());

            if (data.getIntencoesVendas() != null) {
                for (IntencaoVenda ivl : data.getIntencoesVendas()) {
                    if (ivl.getPagamentosExternos() != null) {
                        System.out.println("Printa externo" + ivl.getPagamentosExternos());

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

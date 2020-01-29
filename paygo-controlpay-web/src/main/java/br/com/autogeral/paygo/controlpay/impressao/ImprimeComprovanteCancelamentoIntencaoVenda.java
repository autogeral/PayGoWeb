/*
 * The MIT License
 *
 * Copyright 2020 kaique.mota.
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
package br.com.autogeral.paygo.controlpay.impressao;

import br.com.autogeral.paygo.controlpay.model.Data;
import br.com.autogeral.paygo.controlpay.model.IntencaoVenda;
import br.com.autogeral.paygo.controlpay.model.IntencaoVendaPesquisa;
import br.com.autogeral.paygo.controlpay.model.PagamentoExterno;
import br.com.autogeral.paygo.controlpay.web.transacional.IntencaoVendaGet;
import java.awt.print.PrinterJob;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.SimpleDoc;

/**
 *
 * @author kaique.mota
 */
public class ImprimeComprovanteCancelamentoIntencaoVenda {

    private void imprimir(PrintService service, String conteudo) {
        InputStream stream = new ByteArrayInputStream(conteudo.getBytes());
        DocPrintJob dpj = service.createPrintJob();
        DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
        Doc doc = new SimpleDoc(stream, flavor, null);
        try {
            dpj.print(doc, null);
        } catch (PrintException ex) {
            Logger.getLogger(ImprimeComprovante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void acionarGuilhotina() {
        javax.print.PrintService services[] = PrinterJob.lookupPrintServices();
        String impressora = System.getProperty("compra.print.termica.impressoraNome", "MP-4200 TH");
        for (javax.print.PrintService service : services) {
            if (impressora.equals(service.getName())) {
                PrintService printer = service;
                try {
                    DocPrintJob dpj = printer.createPrintJob();
                    InputStream stream = new ByteArrayInputStream(("\n\n\n\n" + (char) 27 + (char) 109 + "\n").getBytes());
                    DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
                    Doc doc = new SimpleDoc(stream, flavor, null);
                    dpj.print(doc, null);
                } catch (PrintException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void prrenche(int numIntencaoVenda) throws PrintException, IOException {
        ImprimeComprovante ti = new ImprimeComprovante();
        PrintService services[] = PrinterJob.lookupPrintServices();
        for (PrintService service : services) {
            System.out.println("Printer service name : " + service.getName());
            if (service.getName().startsWith("MP-")) {

                intencaoVendaa = new IntencaoVenda();
                intencaoVendaa.setId(numIntencaoVenda);
                vendaPesquisa = new IntencaoVendaPesquisa(intencaoVendaa);
                intencaoFiltro = new IntencaoVendaGet();
                Data data = intencaoFiltro.get(vendaPesquisa);

             List<String> listaComprovantesCancelados = new ArrayList<>();

                for (IntencaoVenda i : data.getIntencoesVendas()) {
                    if (i.getIntencaoVendaStatus().getId() == 20) {
                        listaComprovantesCancelados.add(i.getPagamentosExternos().get(1).getComprovanteAdquirente());
                    }
                }
                System.out.println(listaComprovantesCancelados);
                System.out.println("Printando os itens : ");
                Optional<String> opString = listaComprovantesCancelados.stream().filter(c -> c.isEmpty()).findAny();

                if (opString.isPresent()) {
                    listaComprovantesCancelados.remove(opString.get());
                }
                listaComprovantesCancelados.stream().forEach(c -> {
                    ti.imprimir(service, c);
                    ti.acionarGuilhotina();
                });
                System.out.println("Printando a lista : ");
                System.out.println(listaComprovantesCancelados);
            }
        }
    }
    private IntencaoVenda intencaoVendaa;
    private IntencaoVendaPesquisa vendaPesquisa;
    private IntencaoVendaGet intencaoFiltro;

}

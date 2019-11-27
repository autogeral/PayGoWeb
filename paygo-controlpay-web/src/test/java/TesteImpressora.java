
import java.awt.print.PrinterJob;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.SimpleDoc;
import br.com.autogeral.paygo.controlpay.model.Data;
import br.com.autogeral.paygo.controlpay.model.IntencaoVenda;
import br.com.autogeral.paygo.controlpay.model.IntencaoVendaPesquisa;
import br.com.autogeral.paygo.controlpay.web.transacional.IntencaoVendaGet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

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
/**
 *
 * @author kaique.mota
 */
public class TesteImpressora {

    private void imprimir(PrintService service, String conteudo) {
        InputStream stream = new ByteArrayInputStream(conteudo.getBytes());
        DocPrintJob dpj = service.createPrintJob();
        DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
        Doc doc = new SimpleDoc(stream, flavor, null);
        try {
            dpj.print(doc, null);
        } catch (PrintException ex) {
            Logger.getLogger(TesteImpressora.class.getName()).log(Level.SEVERE, null, ex);
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

    public void prrenche(int intencaoVendaId )throws PrintException, IOException {
        TesteImpressora ti = new TesteImpressora();
        PrintService services[] = PrinterJob.lookupPrintServices();
        for (PrintService service : services) {
            System.out.println("Printer service name : " + service.getName());
            if (service.getName().startsWith("MP-")) {

                IntencaoVenda iv = new IntencaoVenda();
                iv.setId(intencaoVendaId);
                IntencaoVendaGet ivg = new IntencaoVendaGet();
                IntencaoVendaPesquisa ivp = new IntencaoVendaPesquisa(iv);
                Data data = ivg.get(ivp);

                List<String> listaComprovantes = new ArrayList<>();

                data.getIntencoesVendas().stream().forEach(intencaoVenda -> {
                    intencaoVenda.getPagamentosExternos().stream().forEach(pagamento -> listaComprovantes.add(pagamento.getComprovanteAdquirente()
                    ));
                });
                System.out.println("Printando os itens : ");

                Optional<String> opString = listaComprovantes.stream().filter(c -> c.isEmpty()).findAny();

                if (opString.isPresent()) {
                    listaComprovantes.remove(opString.get());
                }

                listaComprovantes.stream().forEach(c -> {
                    ti.imprimir(service, c);
                    ti.acionarGuilhotina();
                });

                System.out.println("Printando a lista : ");
                System.out.println(listaComprovantes);
//                byte[] bytes = convertObjectToByteArray(listaComprovantes);
            }
        }

//    public static byte[] convertObjectToByteArray(Object object) {
//        byte[] bytes = null;
//        try {
//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
//            objectOutputStream.writeObject(object);
//            objectOutputStream.flush();
//            objectOutputStream.close();
//            byteArrayOutputStream.close();
//            bytes = byteArrayOutputStream.toByteArray();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return bytes;
//    }
    }
}

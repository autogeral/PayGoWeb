
import java.awt.print.PrinterJob;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.SimpleDoc;
import br.com.autogeral.paygo.controlpay.model.AuxiliarTeste;
import br.com.autogeral.paygo.controlpay.model.Data;
import br.com.autogeral.paygo.controlpay.model.IntencaoVenda;
import br.com.autogeral.paygo.controlpay.model.IntencaoVendaPesquisa;
import br.com.autogeral.paygo.controlpay.web.transacional.IntencaoVendaGet;
import br.com.autogeral.paygo.controlpay.impressao.IntencaoImpressao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    public static void main(String[] args) throws PrintException, IOException {

        PrintService services[] = PrinterJob.lookupPrintServices();
        for (PrintService service : services) {
            System.out.println("Printer service name : " + service.getName());
            if (service.getName().startsWith("MP-")) {
                DocPrintJob dpj = service.createPrintJob();

                
             
             AuxiliarTeste aux = new AuxiliarTeste();
             IntencaoVenda iv = new IntencaoVenda();
            iv.setId(72293);
            IntencaoVendaGet ivg = new IntencaoVendaGet();
            IntencaoVendaPesquisa ivp = new IntencaoVendaPesquisa(iv);
            Data data = ivg.get(ivp);
          
            
                   List<String> listaComprovantes = new ArrayList<>();

                        data.getIntencoesVendas().stream().forEach(intencaoVenda -> {
                            intencaoVenda.getPagamentosExternos().stream().forEach(pagamento -> listaComprovantes.add(pagamento.getComprovanteAdquirente()
                            ));
                        });
                        System.out.println(listaComprovantes);
                InputStream stream = new ByteArrayInputStream(
                        ("   \n"
                                + "              MASTERCARD               \n"
                                + "           55220 89******3640            \n"
                                + "                            AUT=134424 \n"
                                + "010000244470001/POS=01000119 \n"
                                + "DOC=530537    28/08/19 13:44     ONL-C \n"
                                + "VENDA A CREDITO \n"
                                + "VALOR:                   R$      30,00 \n"
                                + "    TRANSACAO AUTORIZADA COM SENHA     \n"
                                + "           MURILO M TUVANI             \n"
                                + "   A0000000041010-3663E4C609AF1DF2     \n"
                                + "              MASTERCARD               \n"
                                + "---------------------------------------- \n"
                                + "61853 0000000033 PGREF:0000530537 \n"
                                + "NOME FANTASIA: AUTO GERAL AUTOPECAS LTDA \n"
                                + "CNPJ: 05.437.537/0001-37 \n"
                                + "   *** AMBIENTE DE TESTES - APP02 ***\n\n\n\n" + (char) 27 + (char) 109 + "\n").getBytes());
                DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
                Doc doc = new SimpleDoc(stream, flavor, null);
                dpj.print(doc, null);

            }
        }

    }

}

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
package br.com.autogeral.paygo.controlpay.impressao;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.NumberFormat;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.JobName;
import javax.print.attribute.standard.MediaPrintableArea;
import javax.print.attribute.standard.OrientationRequested;

/**
 *
 * @author kaique.mota
 */
public class VendaPrint implements Printable {

    private static final NumberFormat LOJA_FORMAT = NumberFormat.getIntegerInstance();
    private static final NumberFormat CODIGO_FORMAT = NumberFormat.getIntegerInstance();
    private boolean imprimirVenda = true;

    private static int linha = 0;

    static {
        LOJA_FORMAT.setMinimumIntegerDigits(2);
        LOJA_FORMAT.setMaximumIntegerDigits(2);
        CODIGO_FORMAT.setMinimumIntegerDigits(2);
    }

    private boolean isImprimirVenda() {
        return imprimirVenda;
    }

    private void pulaLinha() {
        linha += 6;
    }

    ;

    @Override
    public int print(Graphics g, PageFormat pageFormat, int pageIndex) throws PrinterException {

        linha = 5;

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        System.out.println(System.getProperty("os.nome").toLowerCase());
        boolean osWindows = (System.getProperty("os.name").toLowerCase().contains("Windows"));

        if (isImprimirVenda()) {
            g2d.setFont(new java.awt.Font("Sans", (osWindows ? java.awt.Font.BOLD : java.awt.Font.PLAIN), 7));

        }

        return 0;
    }

    public void execute() {
        String job = System.getProperty("venda.impressao.job");
        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
        aset.add(OrientationRequested.PORTRAIT);
        aset.add(new Copies(1));
        aset.add(new JobName(job, null));

        PrinterJob pj = PrinterJob.getPrinterJob();
        PageFormat pf = pj.defaultPage();
        Paper paper = new Paper();

        double margin = 1;
        paper.setImageableArea(margin, margin, paper.getWidth() - margin * 2, paper.getHeight() - margin * 2);
        paper.setImageableArea(0, 0, 208, 900);
        pf.setPaper(paper);
        MediaPrintableArea mpa = new MediaPrintableArea(0, 0, 80, 1000, MediaPrintableArea.MM);
        aset.add(mpa);
        pj.setPrintable(this);
        javax.print.PrintService services[] = PrinterJob.lookupPrintServices();
       
        //o nome MP-4200 TH - COMPRA, tem que ser assim para quem tiver mais de        
        //uma impressora (a do SAT e a de pedidos) do mesmo modelo, pois só assim
        //o sistema acharia a impressora
        String impressora = System.getProperty("venda.print.termica.impressoraNome", "MP-4200 TH");
        boolean achouImpressora = false;
        for (javax.print.PrintService service : services) {
            if (impressora.equals(service.getName())) {
                try {
                    achouImpressora = true;
                    pj.setPrintService(service);
                    pj.print(aset);
                } catch (PrinterException ex) {
                    ex.printStackTrace(System.err);
                }
            }
        }
        if (!achouImpressora) {
                   System.out.println("Não encontrou uma impressora instalada nesta máquina com o nome: " + impressora); 
        }
    }


}

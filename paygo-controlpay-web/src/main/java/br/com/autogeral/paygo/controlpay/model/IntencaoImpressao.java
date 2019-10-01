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
package br.com.autogeral.paygo.controlpay.model;

/**
 *
 * @author kaique.mota
 */
public class IntencaoImpressao {

    private int id;
    private String data;
    private int intencaoImpressao;
    private String referencia;
    private String conteudo;
    private int impressoraId;
    private String terminalId;
    private boolean aguardarClienteIniciarImpressao = true;
    private Impressora impressora;
    private IntencaoImpressaoStatus intencaoImpressaoStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getIntencaoImpressao() {
        return intencaoImpressao;
    }

    public void setIntencaoImpressao(int intencaoImpressao) {
        this.intencaoImpressao = intencaoImpressao;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public int getImpressoraId() {
        return impressoraId;
    }

    public void setImpressoraId(int impressoraId) {
        this.impressoraId = impressoraId;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public boolean isAguardarClienteIniciarImpressao() {
        return aguardarClienteIniciarImpressao;
    }

    public void setAguardarClienteIniciarImpressao(boolean aguardarClienteIniciarImpressao) {
        this.aguardarClienteIniciarImpressao = aguardarClienteIniciarImpressao;
    }

    public Impressora getImpressora() {
        return impressora;
    }

    public void setImpressora(Impressora impressora) {
        this.impressora = impressora;
    }

    public IntencaoImpressaoStatus getIntencaoImpressaoStatus() {
        return intencaoImpressaoStatus;
    }

    public void setIntencaoImpressaoStatus(IntencaoImpressaoStatus intencaoImpressaoStatus) {
        this.intencaoImpressaoStatus = intencaoImpressaoStatus;
    }

}

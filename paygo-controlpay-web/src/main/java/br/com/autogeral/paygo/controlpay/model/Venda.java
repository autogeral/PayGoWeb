/*
 * The MIT License
 *
 * Copyright 2019 Murilo de Moraes Tuvani.
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

import java.util.ArrayList;
import java.util.List;

/**
 * 23/05/2019 18:02:54
 * @author Murilo de Moraes Tuvani
 */
public class Venda {
    
    private int formaPagamentoId;
    private String terminalId;
    private String referencia;
    private boolean aguardarTefIniciarTransacao = true;
    private String parcelamentoAdmin;
    private int quantidadeParcelas;
    private String adquirente;
    private double valorTotalVendido;
    private List<ProdutoVenda> produtosVendidos = new ArrayList<>();
    private boolean aguardarClienteIniciarImpressao = true;
    private int impressoraId ;
    private String conteudo ;

    
    public String getConteudo() {
        return conteudo;
    }
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
    public int getFormaPagamentoId() {
        return formaPagamentoId;
    }
    public boolean isAguardarClienteIniciarImpressao() {
        return aguardarClienteIniciarImpressao;
    }
    public void setAguardarClienteIniciarImpressao(boolean aguardarClienteIniciarImpressao) {
        this.aguardarClienteIniciarImpressao = aguardarClienteIniciarImpressao;
    }
    public void setFormaPagamentoId(int formaPagamentoId) {
        this.formaPagamentoId = formaPagamentoId;
    }
    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public boolean isAguardarTefIniciarTransacao() {
        return aguardarTefIniciarTransacao;
    }

    public void setAguardarTefIniciarTransacao(boolean aguardarTefIniciarTransacao) {
        this.aguardarTefIniciarTransacao = aguardarTefIniciarTransacao;
    }

    public String getParcelamentoAdmin() {
        return parcelamentoAdmin;
    }

    public void setParcelamentoAdmin(String parcelamentoAdmin) {
        this.parcelamentoAdmin = parcelamentoAdmin;
    }

    public int getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(int quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    public String getAdquirente() {
        return adquirente;
    }

    public void setAdquirente(String adquirente) {
        this.adquirente = adquirente;
    }

    public double getValorTotalVendido() {
        return valorTotalVendido;
    }

    public void setValorTotalVendido(double valorTotalVendido) {
        this.valorTotalVendido = valorTotalVendido;
    }

    public List<ProdutoVenda> getProdutosVendidos() {
        return produtosVendidos;
    }

    public void setProdutosVendidos(List<ProdutoVenda> produtosVendidos) {
        this.produtosVendidos = produtosVendidos;
    }
      public int getImpressoraId() {
        return impressoraId;
    }

    public void setImpressoraId(int impressoraId) {
        this.impressoraId = impressoraId;
    }
    
    
}

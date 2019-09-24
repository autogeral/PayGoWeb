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

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * 28/05/2019 09:21:15
 *
 * @author Murilo de Moraes Tuvani
 */
public class IntencaoVenda {

    private int id;
    private String referencia;
    private String token;
    private String data;
    private String hora;
    private String dataAtualizacao;
    private int quantidade;
    private String latitude;
    private String longitude;
    private double valorOriginal;
    private String valorOriginalFormat;
    private double valorAcrescimo;
    private String valorAcrescimoFormat;
    private double valorDesconto;
    private String valorDescontoFormat;
    private double valorFinal;
    private String valorFinalFormat;
    private String gate2allToken;
    private int quantidadeParcelas;
    private String operador;
    private String urlPagamento;
    private FormaPagamento formaPagamento;
    private Terminal terminal;
    private String terminalId;
    private Pedido pedido;
    @SerializedName(value = "pagamentosExternos", alternate = {"pagamentosExterno"})
    private List<PagamentoExterno> pagamentosExternos;
    private IntencaoVendaStatus intencaoVendaStatus;
    private String cliente;
    private Vendedor vendedor;
    private List<ProdutoVenda> produtos;
    private String recordsTotal;
    private String recordsFiltered;
    private String draw;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDraw() {
        return draw;
    }

    public void setDraw(String draw) {
        this.draw = draw;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public String getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(String dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public double getValorOriginal() {
        return valorOriginal;
    }

    public void setValorOriginal(double valorOriginal) {
        this.valorOriginal = valorOriginal;
    }

    public String getValorOriginalFormat() {
        return valorOriginalFormat;
    }

    public void setValorOriginalFormat(String valorOriginalFormat) {
        this.valorOriginalFormat = valorOriginalFormat;
    }

    public double getValorAcrescimo() {
        return valorAcrescimo;
    }

    public void setValorAcrescimo(double valorAcrescimo) {
        this.valorAcrescimo = valorAcrescimo;
    }

    public String getValorAcrescimoFormat() {
        return valorAcrescimoFormat;
    }

    public void setValorAcrescimoFormat(String valorAcrescimoFormat) {
        this.valorAcrescimoFormat = valorAcrescimoFormat;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public String getValorDescontoFormat() {
        return valorDescontoFormat;
    }

    public void setValorDescontoFormat(String valorDescontoFormat) {
        this.valorDescontoFormat = valorDescontoFormat;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public String getValorFinalFormat() {
        return valorFinalFormat;
    }

    public void setValorFinalFormat(String valorFinalFormat) {
        this.valorFinalFormat = valorFinalFormat;
    }

    public String getGate2allToken() {
        return gate2allToken;
    }

    public void setGate2allToken(String gate2allToken) {
        this.gate2allToken = gate2allToken;
    }

    public int getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(int quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    public String getUrlPagamento() {
        return urlPagamento;
    }

    public void setUrlPagamento(String urlPagamento) {
        this.urlPagamento = urlPagamento;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public List<PagamentoExterno> getPagamentosExternos() {
        return pagamentosExternos;
    }

    public void setPagamentosExternos(List<PagamentoExterno> pagamentosExternos) {
        this.pagamentosExternos = pagamentosExternos;
    }

    public IntencaoVendaStatus getIntencaoVendaStatus() {
        return intencaoVendaStatus;
    }

    public void setIntencaoVendaStatus(IntencaoVendaStatus intencaoVendaStatus) {
        this.intencaoVendaStatus = intencaoVendaStatus;
    }

    public List<ProdutoVenda> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoVenda> produtos) {
        this.produtos = produtos;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public String getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(String recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public String getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(String recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

}

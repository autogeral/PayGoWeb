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

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kaique.mota
 */
public class Pedido {

    private int id;
    private String pessoaIds;
    private String referencia;
    private String obs;
    private String data;
    private String hora;
    private String tipo;
    private double valor;
    private String valorFormat;
    private double valorAberto;
    private String valorAbertoFormat;
    private double valorOriginalPago;
    private String valorOriginalPagoFormat;
    private double valorOriginalEmPagamento;
    private String valorOriginalEmPagamentoFormat;
    private String interno;
    private int quantidade;
    private int quantidadeTransacoes;
    @SerializedName(value = "pedidoStatus", alternate = {"PedidoStatus"})
    private PedidoStatus pedidoStatus;
    private Pessoa pessoa;
    private List<Produto> produtos = new ArrayList<>();
    private List<Produto> produtosPedido = new ArrayList<>();
    private int pessoaVendedorId;
    @SerializedName(value = "valorTotalPedido", alternate = {"ValorTotalPedido"})
    private double valorTotalPedido;
    private String urlRetorno;
    private PedidoFormaPagamento pedidoFormaPagamento;
    private List<PedidoFormaPagamento> pedidoFormasPagamento = new ArrayList<>();
    private transient int httpStatus;
    private String notaFiscal;

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPessoaIds() {
        return pessoaIds;
    }

    public void setPessoaIds(String pessoaIds) {
        this.pessoaIds = pessoaIds;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getValorFormat() {
        return valorFormat;
    }

    public void setValorFormat(String valorFormat) {
        this.valorFormat = valorFormat;
    }

    public double getValorAberto() {
        return valorAberto;
    }

    public void setValorAberto(double valorAberto) {
        this.valorAberto = valorAberto;
    }

    public String getValorAbertoFormat() {
        return valorAbertoFormat;
    }

    public void setValorAbertoFormat(String valorAbertoFormat) {
        this.valorAbertoFormat = valorAbertoFormat;
    }

    public double getValorOriginalPago() {
        return valorOriginalPago;
    }

    public void setValorOriginalPago(double valorOriginalPago) {
        this.valorOriginalPago = valorOriginalPago;
    }

    public String getValorOriginalPagoFormat() {
        return valorOriginalPagoFormat;
    }

    public void setValorOriginalPagoFormat(String valorOriginalPagoFormat) {
        this.valorOriginalPagoFormat = valorOriginalPagoFormat;
    }

    public double getValorOriginalEmPagamento() {
        return valorOriginalEmPagamento;
    }

    public void setValorOriginalEmPagamento(double valorOriginalEmPagamento) {
        this.valorOriginalEmPagamento = valorOriginalEmPagamento;
    }

    public String getValorOriginalEmPagamentoFormat() {
        return valorOriginalEmPagamentoFormat;
    }

    public void setValorOriginalEmPagamentoFormat(String valorOriginalEmPagamentoFormat) {
        this.valorOriginalEmPagamentoFormat = valorOriginalEmPagamentoFormat;
    }

    public String getInterno() {
        return interno;
    }

    public void setInterno(String interno) {
        this.interno = interno;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantidadeTransacoes() {
        return quantidadeTransacoes;
    }

    public void setQuantidadeTransacoes(int quantidadeTransacoes) {
        this.quantidadeTransacoes = quantidadeTransacoes;
    }

    public PedidoStatus getPedidoStatus() {
        return pedidoStatus;
    }

    public void setPedidoStatus(PedidoStatus pedidoStatus) {
        this.pedidoStatus = pedidoStatus;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    /*
    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
     */
    public List<Produto> getProdutosPedido() {
        return produtosPedido;
    }

    public void setProdutosPedido(List<Produto> produtosPedido) {
        this.produtosPedido = produtosPedido;
    }

    public int getPessoaVendedorId() {
        return pessoaVendedorId;
    }

    public void setPessoaVendedorId(int pessoaVendedorId) {
        this.pessoaVendedorId = pessoaVendedorId;
    }

    public double getValorTotalPedido() {
        return valorTotalPedido;
    }

    public void setValorTotalPedido(double valorTotalPedido) {
        this.valorTotalPedido = valorTotalPedido;
    }

    public String getUrlRetorno() {
        return urlRetorno;
    }

    public void setUrlRetorno(String urlRetorno) {
        this.urlRetorno = urlRetorno;
    }

    public PedidoFormaPagamento getPedidoFormaPagamento() {
        return pedidoFormaPagamento;
    }

    public void setPedidoFormaPagamento(PedidoFormaPagamento pedidoFormaPagamento) {
        this.pedidoFormaPagamento = pedidoFormaPagamento;
    }

    public List<PedidoFormaPagamento> getPedidoFormasPagamento() {
        return pedidoFormasPagamento;
    }

    public void setPedidoFormasPagamento(List<PedidoFormaPagamento> pedidoFormasPagamento) {
        this.pedidoFormasPagamento = pedidoFormasPagamento;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(String notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

}

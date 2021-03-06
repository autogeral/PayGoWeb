/*
 * The MIT License
 *
 * Copyright 2019 Murilo Moraes Tuvani.
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

import java.time.LocalDateTime;
import java.util.List;

/**
 * Uma classe apenas para colocar outros dados dentro</br>
 * para satisfazer a API</br> 03/06/2019 18:33:17
 *
 * @author Murilo Moraes Tuvani
 */
public class Data {

    private int id;
    private transient int httpStatus;
    private LocalDateTime data;
    private String message;
    private IntencaoVenda intencaoVenda;
    private Pessoa pessoa;
    private Produto produto;
    private PagamentoExterno pagamentoExterno;
    private Pedido pedido;
    private ClienteCartao clienteCartao;
    private Cliente cliente;
    private IntencaoImpressao intencaoImpressao;
    private Terminal terminal;
    private List<Terminal> terminais;
    private List<IntencaoVenda> intencoesVendas;
    private List<Produto> produtos;
    private List<Pedido> pedidos;
    private List<Cliente> clientes;
    private List<FormaPagamento> formasPagamento;
    private Android android;
    private IOS ios;
    private String app;
    private String operador;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public IntencaoVenda getIntencaoVenda() {
        return intencaoVenda;
    }

    public void setIntencaoVenda(IntencaoVenda intencaoVenda) {
        this.intencaoVenda = intencaoVenda;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public PagamentoExterno getPagamentoExterno() {
        return pagamentoExterno;
    }

    public void setPagamentoExterno(PagamentoExterno pagamentoExterno) {
        this.pagamentoExterno = pagamentoExterno;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

    public ClienteCartao getClienteCartao() {
        return clienteCartao;
    }

    public void setClienteCartao(ClienteCartao clienteCartao) {
        this.clienteCartao = clienteCartao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public IntencaoImpressao getIntencaoImpressao() {
        return intencaoImpressao;
    }

    public void setIntencaoImpressao(IntencaoImpressao intencaoImpressao) {
        this.intencaoImpressao = intencaoImpressao;
    }

    public List<Terminal> getTerminais() {
        return terminais;
    }

    public void setTerminais(List<Terminal> terminais) {
        this.terminais = terminais;
    }

    public List<IntencaoVenda> getIntencoesVendas() {
        return intencoesVendas;
    }

    public void setIntencoesVendas(List<IntencaoVenda> intencoesVendas) {
        this.intencoesVendas = intencoesVendas;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<FormaPagamento> getFormasPagamento() {
        return formasPagamento;
    }

    public void setFormasPagamento(List<FormaPagamento> formasPagamento) {
        this.formasPagamento = formasPagamento;
    }

    public Android getAndroid() {
        return android;
    }

    public void setAndroid(Android android) {
        this.android = android;
    }

    public IOS getIos() {
        return ios;
    }

    public void setIos(IOS ios) {
        this.ios = ios;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

}

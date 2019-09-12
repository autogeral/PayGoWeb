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
public class ClienteCartao {

    private int id;
    private boolean preferencial;
    private Cliente cliente;
    private String dataAtualizacao;
    private String dataInsercao;
    private String cartaoPan;
    private String cartaoValidade;
    private String bandeira;
    private String cartaoToken;
    private String gate2allToken;
    private int status;
    private String statusDescricao;
    private String urlCapturarDadosCartao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPreferencial() {
        return preferencial;
    }

    public void setPreferencial(boolean preferencial) {
        this.preferencial = preferencial;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(String dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public String getDataInsercao() {
        return dataInsercao;
    }

    public void setDataInsercao(String dataInsercao) {
        this.dataInsercao = dataInsercao;
    }

    public String getCartaoPan() {
        return cartaoPan;
    }

    public void setCartaoPan(String cartaoPan) {
        this.cartaoPan = cartaoPan;
    }

    public String getCartaoValidade() {
        return cartaoValidade;
    }

    public void setCartaoValidade(String cartaoValidade) {
        this.cartaoValidade = cartaoValidade;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getCartaoToken() {
        return cartaoToken;
    }

    public void setCartaoToken(String cartaoToken) {
        this.cartaoToken = cartaoToken;
    }

    public String getGate2allToken() {
        return gate2allToken;
    }

    public void setGate2allToken(String gate2allToken) {
        this.gate2allToken = gate2allToken;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusDescricao() {
        return statusDescricao;
    }

    public void setStatusDescricao(String statusDescricao) {
        this.statusDescricao = statusDescricao;
    }

    public String getUrlCapturarDadosCartao() {
        return urlCapturarDadosCartao;
    }

    public void setUrlCapturarDadosCartao(String urlCapturarDadosCartao) {
        this.urlCapturarDadosCartao = urlCapturarDadosCartao;
    }

}

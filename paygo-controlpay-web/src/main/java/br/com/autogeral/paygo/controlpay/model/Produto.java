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

/**
 * 02/06/2019 21:48:13
 *
 * @author Murilo Moraes Tuvani
 */
public class Produto {

    private String nome;
    private String descricao;
    private String controlaQuantidade;
    private String solicitaValor;
    private String produtoTipo;
    private ProdutoStatus produtoStatus;
    private String fotoNome;
    private String fotBase64;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getControlaQuantidade() {
        return controlaQuantidade;
    }

    public void setControlaQuantidade(String controlaQuantidade) {
        this.controlaQuantidade = controlaQuantidade;
    }

    public String getSolicitaValor() {
        return solicitaValor;
    }

    public void setSolicitaValor(String solicitaValor) {
        this.solicitaValor = solicitaValor;
    }

    public String getProdutoTipo() {
        return produtoTipo;
    }

    public void setProdutoTipo(String produtoTipo) {
        this.produtoTipo = produtoTipo;
    }

    public ProdutoStatus getProdutoStatus() {
        return produtoStatus;
    }

    public void setProdutoStatus(ProdutoStatus produtoStatus) {
        this.produtoStatus = produtoStatus;
    }

    public String getFotoNome() {
        return fotoNome;
    }

    public void setFotoNome(String fotoNome) {
        this.fotoNome = fotoNome;
    }

    public String getFotBase64() {
        return fotBase64;
    }

    public void setFotBase64(String fotBase64) {
        this.fotBase64 = fotBase64;
    }

    @Override
    public String toString() {
        return "Produto{nome=" + nome + ", descricao=" + descricao + ", controlaQuantidade=" + controlaQuantidade + ", solicitaValor=" + solicitaValor + ", produtoTipo=" + produtoTipo + ", fotoNome=" + fotoNome + ", fotBase64=" + fotBase64 + '}';
    }
    
    

}

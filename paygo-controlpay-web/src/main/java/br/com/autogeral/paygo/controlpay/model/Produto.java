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

    private int id;
    transient private String nome;
    transient private String descricao;
    transient private String controlaQuantidade;
    private int valor;
    transient private String produtoTipo;
    transient private ProdutoStatus produtoStatus;
    transient private String fotoNome;
    transient private String fotBase64;
    private int quantidade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

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

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
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
        return "Produto{" + "id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", controlaQuantidade=" + controlaQuantidade + ", valor=" + valor + ", produtoTipo=" + produtoTipo + ", produtoStatus=" + produtoStatus + ", fotoNome=" + fotoNome + ", fotBase64=" + fotBase64 + ", quantidade=" + quantidade + '}';
    }

    

}

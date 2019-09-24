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

import com.google.gson.annotations.SerializedName;

/**
 * 03/06/2019 15:38:05
 *
 * @author Murilo Moraes Tuvani
 */
public class ProdutoVenda {

    
    @SerializedName(value ="itemProdutoId",alternate = {"ItemProdutoId"})
    private  int itemProdutoId;
    @SerializedName(value = "id", alternate = {"Id"})
    private int id;
    private String nome;
    @SerializedName(value = "quantidade", alternate = {"Quantidade", "Qtd"})
    private String quantidade;
    @SerializedName(value = "valor", alternate = {"Valor"})
    private String valor;

    public int getItemProdutoId() {
        return itemProdutoId;
    }

    public void setItemProdutoId(int itemProdutoId) {
        this.itemProdutoId = itemProdutoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Valor esta como String para ser tratado no padro brasileiro</br>
     *
     * @return
     */
    public String getValor() {
        return valor;
    }

    /**
     * Valor esta como String para ser tratado no padro brasileiro</br>
     *
     * @param valor
     */
    public void setValor(String valor) {
        this.valor = valor;
    }

}

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
public class ImpressoraTemplate {

    private int id;
    private String nome;
    private int quantidadeColunas;
    private int quantidadeLinhasPre;
    private int quantidadeLinhasPos;
    private String comandoPre;
    private String comandoPos;
    private IntencaoImpressaoStatus intencaoImpressaoStatus;

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

    public int getQuantidadeColunas() {
        return quantidadeColunas;
    }

    public void setQuantidadeColunas(int quantidadeColunas) {
        this.quantidadeColunas = quantidadeColunas;
    }

    public int getQuantidadeLinhasPre() {
        return quantidadeLinhasPre;
    }

    public void setQuantidadeLinhasPre(int quantidadeLinhasPre) {
        this.quantidadeLinhasPre = quantidadeLinhasPre;
    }

    public int getQuantidadeLinhasPos() {
        return quantidadeLinhasPos;
    }

    public void setQuantidadeLinhasPos(int quantidadeLinhasPos) {
        this.quantidadeLinhasPos = quantidadeLinhasPos;
    }

    public String getComandoPre() {
        return comandoPre;
    }

    public void setComandoPre(String comandoPre) {
        this.comandoPre = comandoPre;
    }

    public String getComandoPos() {
        return comandoPos;
    }

    public void setComandoPos(String comandoPos) {
        this.comandoPos = comandoPos;
    }

    public IntencaoImpressaoStatus getIntencaoImpressaoStatus() {
        return intencaoImpressaoStatus;
    }

    public void setIntencaoImpressaoStatus(IntencaoImpressaoStatus intencaoImpressaoStatus) {
        this.intencaoImpressaoStatus = intencaoImpressaoStatus;
    }

}

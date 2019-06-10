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
 * 10/06/2019 08:35:11
 * @author Murilo Moraes Tuvani
 */
public class TerminalFisico {

    private int id;
    private String nome;
    private String instalacaoId;
    private LoginPessoa pessoa;

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

    public String getInstalacaoId() {
        return instalacaoId;
    }

    public void setInstalacaoId(String instalacaoId) {
        this.instalacaoId = instalacaoId;
    }

    public LoginPessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(LoginPessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public String toString() {
        return "TerminalFisico{id=" + id + ", nome=" + nome + ", instalacaoId=" + instalacaoId + ", pessoa=" + pessoa + '}';
    }
    
}

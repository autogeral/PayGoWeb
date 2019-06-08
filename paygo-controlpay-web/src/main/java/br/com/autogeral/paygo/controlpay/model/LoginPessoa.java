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
 * 07/06/2019 08:39:00
 *
 * @author Murilo Moraes Tuvani
 */
public class LoginPessoa {

    private String key;
    private int id;
    private boolean pessoaJuridica;
    private String nomeRazaoSocial;
    private String sobrenomeNomeFantasia;
    private String cpfCnpj;
    private String cpfCnpjFormat;
    private String email;
    private String fotoThumbnail;
    private PessoaStatus pessoaStatus;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(boolean pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }

    public String getNomeRazaoSocial() {
        return nomeRazaoSocial;
    }

    public void setNomeRazaoSocial(String nomeRazaoSocial) {
        this.nomeRazaoSocial = nomeRazaoSocial;
    }

    public String getSobrenomeNomeFantasia() {
        return sobrenomeNomeFantasia;
    }

    public void setSobrenomeNomeFantasia(String sobrenomeNomeFantasia) {
        this.sobrenomeNomeFantasia = sobrenomeNomeFantasia;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getCpfCnpjFormat() {
        return cpfCnpjFormat;
    }

    public void setCpfCnpjFormat(String cpfCnpjFormat) {
        this.cpfCnpjFormat = cpfCnpjFormat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFotoThumbnail() {
        return fotoThumbnail;
    }

    public void setFotoThumbnail(String fotoThumbnail) {
        this.fotoThumbnail = fotoThumbnail;
    }

    public PessoaStatus getPessoaStatus() {
        return pessoaStatus;
    }

    public void setPessoaStatus(PessoaStatus pessoaStatus) {
        this.pessoaStatus = pessoaStatus;
    }

    @Override
    public String toString() {
        return "LoginPessoa{key=" + key + ", id=" + id + ", pessoaJuridica=" + pessoaJuridica + ", nomeRazaoSocial=" + nomeRazaoSocial + ", sobrenomeNomeFantasia=" + sobrenomeNomeFantasia + ", cpfCnpj=" + cpfCnpj + ", cpfCnpjFormat=" + cpfCnpjFormat + ", email=" + email + ", fotoThumbnail=" + fotoThumbnail + ", pessoaStatus=" + pessoaStatus + '}';
    }
}

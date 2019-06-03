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
 * 03/06/2019 15:34:45
 *
 * @author Murilo Moraes Tuvani
 */
public class Pessoa {

    private String Id;
    private String PessoaJuridica;
    private String NomeRazaoSocial;
    private String SobrenomeNomeFantasia;
    private String CpfCnpj;
    private String Email;
    private String Telefone1;
    private String Telefone2;
    private String Foto;
    private String fotoNome;
    private String fotoBase64;
    private Endereco Endereco;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getPessoaJuridica() {
        return PessoaJuridica;
    }

    public void setPessoaJuridica(String PessoaJuridica) {
        this.PessoaJuridica = PessoaJuridica;
    }

    public String getNomeRazaoSocial() {
        return NomeRazaoSocial;
    }

    public void setNomeRazaoSocial(String NomeRazaoSocial) {
        this.NomeRazaoSocial = NomeRazaoSocial;
    }

    public String getSobrenomeNomeFantasia() {
        return SobrenomeNomeFantasia;
    }

    public void setSobrenomeNomeFantasia(String SobrenomeNomeFantasia) {
        this.SobrenomeNomeFantasia = SobrenomeNomeFantasia;
    }

    public String getCpfCnpj() {
        return CpfCnpj;
    }

    public void setCpfCnpj(String CpfCnpj) {
        this.CpfCnpj = CpfCnpj;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getTelefone1() {
        return Telefone1;
    }

    public void setTelefone1(String Telefone1) {
        this.Telefone1 = Telefone1;
    }

    public String getTelefone2() {
        return Telefone2;
    }

    public void setTelefone2(String Telefone2) {
        this.Telefone2 = Telefone2;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String Foto) {
        this.Foto = Foto;
    }

    public String getFotoNome() {
        return fotoNome;
    }

    public void setFotoNome(String fotoNome) {
        this.fotoNome = fotoNome;
    }

    public String getFotoBase64() {
        return fotoBase64;
    }

    public void setFotoBase64(String fotoBase64) {
        this.fotoBase64 = fotoBase64;
    }

    public Endereco getEndereco() {
        return Endereco;
    }

    public void setEndereco(Endereco Endereco) {
        this.Endereco = Endereco;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "Id=" + Id + ", PessoaJuridica=" + PessoaJuridica + ", NomeRazaoSocial=" + NomeRazaoSocial + ", SobrenomeNomeFantasia=" + SobrenomeNomeFantasia + ", CpfCnpj=" + CpfCnpj + ", Email=" + Email + ", Telefone1=" + Telefone1 + ", Telefone2=" + Telefone2 + ", Foto=" + Foto + ", fotoNome=" + fotoNome + ", fotoBase64=" + fotoBase64 + ", Endereco=" + Endereco + '}';
    }
    
}

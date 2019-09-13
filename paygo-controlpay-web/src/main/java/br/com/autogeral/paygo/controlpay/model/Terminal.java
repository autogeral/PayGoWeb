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

import java.util.List;

/**
 * 02/06/2019 21:32:46
 *
 * @author Murilo Moraes Tuvani
 */
public class Terminal {

    private int id;
    private String nome;
    private boolean solicitarReferencia;
    private boolean solicitarCliente;
    private boolean solicitarOperador;
    private String identificadorTef;
    private String rastrearIntervalo;
    private boolean permiteVendaParcelada;
    private String parcelamentoPadrao;
    private boolean permiteDesconto;
    private boolean permiteAcrescimo;
    private boolean aguardaTef;
    private boolean habilitarPDV;
    private boolean vendaPorValor;
    private boolean vendaPorProduto;
    private boolean habilitarPedidos;
    private boolean impressaoAutomatica;
    private boolean imprimirProdutos;
    private boolean imprimirCupomLojista;
    private boolean imprimirCupomCliente;
    private Impressora impressora;
    private LoginPessoa pessoa;
    private TerminalFisico terminalFisico;
    private List <TerminalParametro> terminalParametros;

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

    public boolean isSolicitarReferencia() {
        return solicitarReferencia;
    }

    public void setSolicitarReferencia(boolean solicitarReferencia) {
        this.solicitarReferencia = solicitarReferencia;
    }

    public boolean isSolicitarCliente() {
        return solicitarCliente;
    }

    public void setSolicitarCliente(boolean solicitarCliente) {
        this.solicitarCliente = solicitarCliente;
    }

    public boolean isSolicitarOperador() {
        return solicitarOperador;
    }

    public void setSolicitarOperador(boolean solicitarOperador) {
        this.solicitarOperador = solicitarOperador;
    }

    public String getIdentificadorTef() {
        return identificadorTef;
    }

    public void setIdentificadorTef(String identificadorTef) {
        this.identificadorTef = identificadorTef;
    }

    public String getRastrearIntervalo() {
        return rastrearIntervalo;
    }

    public void setRastrearIntervalo(String rastrearIntervalo) {
        this.rastrearIntervalo = rastrearIntervalo;
    }

    public boolean isPermiteVendaParcelada() {
        return permiteVendaParcelada;
    }

    public void setPermiteVendaParcelada(boolean permiteVendaParcelada) {
        this.permiteVendaParcelada = permiteVendaParcelada;
    }

    public String getParcelamentoPadrao() {
        return parcelamentoPadrao;
    }

    public void setParcelamentoPadrao(String parcelamentoPadrao) {
        this.parcelamentoPadrao = parcelamentoPadrao;
    }

    public boolean isPermiteDesconto() {
        return permiteDesconto;
    }

    public void setPermiteDesconto(boolean permiteDesconto) {
        this.permiteDesconto = permiteDesconto;
    }

    public boolean isPermiteAcrescimo() {
        return permiteAcrescimo;
    }

    public void setPermiteAcrescimo(boolean permiteAcrescimo) {
        this.permiteAcrescimo = permiteAcrescimo;
    }

    public boolean isAguardaTef() {
        return aguardaTef;
    }

    public void setAguardaTef(boolean aguardaTef) {
        this.aguardaTef = aguardaTef;
    }

    public boolean isHabilitarPDV() {
        return habilitarPDV;
    }

    public void setHabilitarPDV(boolean habilitarPDV) {
        this.habilitarPDV = habilitarPDV;
    }

    public boolean isVendaPorValor() {
        return vendaPorValor;
    }

    public void setVendaPorValor(boolean vendaPorValor) {
        this.vendaPorValor = vendaPorValor;
    }

    public boolean isVendaPorProduto() {
        return vendaPorProduto;
    }

    public void setVendaPorProduto(boolean vendaPorProduto) {
        this.vendaPorProduto = vendaPorProduto;
    }

    public boolean isHabilitarPedidos() {
        return habilitarPedidos;
    }

    public void setHabilitarPedidos(boolean habilitarPedidos) {
        this.habilitarPedidos = habilitarPedidos;
    }

    public boolean isImpressaoAutomatica() {
        return impressaoAutomatica;
    }

    public void setImpressaoAutomatica(boolean impressaoAutomatica) {
        this.impressaoAutomatica = impressaoAutomatica;
    }

    public boolean isImprimirProdutos() {
        return imprimirProdutos;
    }

    public void setImprimirProdutos(boolean imprimirProdutos) {
        this.imprimirProdutos = imprimirProdutos;
    }

    public boolean isImprimirCupomLojista() {
        return imprimirCupomLojista;
    }

    public void setImprimirCupomLojista(boolean imprimirCupomLojista) {
        this.imprimirCupomLojista = imprimirCupomLojista;
    }

    public boolean isImprimirCupomCliente() {
        return imprimirCupomCliente;
    }

    public void setImprimirCupomCliente(boolean imprimirCupomCliente) {
        this.imprimirCupomCliente = imprimirCupomCliente;
    }

    public Impressora getImpressora() {
        return impressora;
    }

    public void setImpressora(Impressora impressora) {
        this.impressora = impressora;
    }

    public LoginPessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(LoginPessoa pessoa) {
        this.pessoa = pessoa;
    }

    public TerminalFisico getTerminalFisico() {
        return terminalFisico;
    }

    public void setTerminalFisico(TerminalFisico terminalFisico) {
        this.terminalFisico = terminalFisico;
    }

    public List<TerminalParametro> getTerminalParametros() {
        return terminalParametros;
    }

    public void setTerminalParametros(List<TerminalParametro> terminalParametros) {
        this.terminalParametros = terminalParametros;
    }
    

    @Override
    public String toString() {
        return "terminal: {\"id\": " + id + ", \"nome\":" + nome + '}';
    }

}

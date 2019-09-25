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
 * 02/06/2019 21:34:37
 *
 * @author Murilo Moraes Tuvani
 */
public class PagamentoExterno {

    private int id;
    private String idPagamento;
    private String nsuTid;
    private String trnNsu;
    private String autorizacao;
    private String adquirente;
    private String bandeira;
    private String codigoRespostaAdquirente;
    private String codigoRespostaExecTransac;
    private String mensagemRespostaAdquirente;
    private String idConfirmacao;
    private String dataAdquirente;
    
    private String dataAtualizacao;
    private String respostaAdquirente;
    private String nome ;
    private Pessoa pessoa;
    private Terminal terminal;
    private int terminalId;
    private int tipo;
    private int origem;
    private int tipoParcelamento;
    private String comprovanteAdquirente;
    private PagamentoExternoStatus pagamentoExternoStatus;
    private String senhaTecnica;
    private String orderLIO;

    public String getOrderLIO() {
        return orderLIO;
    }

    public void setOrderLIO(String orderLIO) {
        this.orderLIO = orderLIO;
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

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

    public String getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(String idPagamento) {
        this.idPagamento = idPagamento;
    }

    public int getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(int terminalId) {
        this.terminalId = terminalId;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getOrigem() {
        return origem;
    }

    public void setOrigem(int origem) {
        this.origem = origem;
    }

    public int getTipoParcelamento() {
        return tipoParcelamento;
    }

    public void setTipoParcelamento(int tipoParcelamento) {
        this.tipoParcelamento = tipoParcelamento;
    }

    public PagamentoExternoStatus getPagamentoExternoStatus() {
        return pagamentoExternoStatus;
    }

    public void setPagamentoExternoStatus(PagamentoExternoStatus pagamentoExternoStatus) {
        this.pagamentoExternoStatus = pagamentoExternoStatus;
    }

    public String getRespostaAdquirente() {
        return respostaAdquirente;
    }

    public void setRespostaAdquirente(String respostaAdquirente) {
        this.respostaAdquirente = respostaAdquirente;
    }

    public String getMensagemRespostaAdquirente() {
        return mensagemRespostaAdquirente;
    }

    public void setMensagemRespostaAdquirente(String mensagemRespostaAdquirente) {
        this.mensagemRespostaAdquirente = mensagemRespostaAdquirente;
    }

    public String getComprovanteAdquirente() {
        return comprovanteAdquirente;
    }

    public void setComprovanteAdquirente(String comprovanteAdquirente) {
        this.comprovanteAdquirente = comprovanteAdquirente;
    }

    public String getSenhaTecnica() {
        return senhaTecnica;
    }

    public void setSenhaTecnica(String senhaTecnica) {
        this.senhaTecnica = senhaTecnica;
    }

    public String getNsuTid() {
        return nsuTid;
    }

    public void setNsuTid(String nsuTid) {
        this.nsuTid = nsuTid;
    }

    public String getTrnNsu() {
        return trnNsu;
    }

    public void setTrnNsu(String trnNsu) {
        this.trnNsu = trnNsu;
    }

    public String getAutorizacao() {
        return autorizacao;
    }

    public void setAutorizacao(String autorizacao) {
        this.autorizacao = autorizacao;
    }

    public String getAdquirente() {
        return adquirente;
    }

    public void setAdquirente(String adquirente) {
        this.adquirente = adquirente;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getCodigoRespostaAdquirente() {
        return codigoRespostaAdquirente;
    }

    public void setCodigoRespostaAdquirente(String codigoRespostaAdquirente) {
        this.codigoRespostaAdquirente = codigoRespostaAdquirente;
    }

    public String getCodigoRespostaExecTransac() {
        return codigoRespostaExecTransac;
    }

    public void setCodigoRespostaExecTransac(String codigoRespostaExecTransac) {
        this.codigoRespostaExecTransac = codigoRespostaExecTransac;
    }

    public String getIdConfirmacao() {
        return idConfirmacao;
    }

    public void setIdConfirmacao(String idConfirmacao) {
        this.idConfirmacao = idConfirmacao;
    }

    public String getDataAdquirente() {
        return dataAdquirente;
    }

    public void setDataAdquirente(String dataAdquirente) {
        this.dataAdquirente = dataAdquirente;
    }

    public String getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(String dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    @Override
    public String toString() {
        return "PagamentoExterno{" + "id=" + id + ", nsuTid=" + nsuTid + ", trnNsu=" + trnNsu + ", autorizacao=" + autorizacao + ", adquirente=" + adquirente + ", bandeira=" + bandeira + ", codigoRespostaAdquirente=" + codigoRespostaAdquirente + ", codigoRespostaExecTransac=" + codigoRespostaExecTransac + ", mensagemRespostaAdquirente=" + mensagemRespostaAdquirente + ", idConfirmacao=" + idConfirmacao + ", dataAdquirente=" + dataAdquirente + ", dataAtualizacao=" + dataAtualizacao + ", respostaAdquirente=" + respostaAdquirente + ", terminalId=" + terminalId + ", tipo=" + tipo + ", origem=" + origem + ", tipoParcelamento=" + tipoParcelamento + ", comprovanteAdquirente=" + comprovanteAdquirente + ", pagamentoExternoStatus=" + pagamentoExternoStatus + ", senhaTecnica=" + senhaTecnica + '}';
    }

    
}

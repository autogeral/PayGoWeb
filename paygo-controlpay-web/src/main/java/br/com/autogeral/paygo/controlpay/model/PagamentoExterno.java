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
 * @author Murilo Moraes Tuvani
 */
public class PagamentoExterno {

    private int id;
    private int tipo;
    private int origem;
    private int tipoParcelamento;
    private PagamentoExternoStatus pagamentoExternoStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "pagamentoExterno: {id=" + id + ", tipo=" + tipo + ", origem=" + origem + ", tipoParcelamento=" + tipoParcelamento + ", pagamentoExternoStatus=" + pagamentoExternoStatus + '}';
    }
    
}

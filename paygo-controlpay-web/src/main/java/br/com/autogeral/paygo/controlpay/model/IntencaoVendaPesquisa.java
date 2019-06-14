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
 * 13/06/2019 23:10:53
 * @author Murilo Moraes Tuvani
 */
public class IntencaoVendaPesquisa {

    private final int intencaoVendaId;
    private final int formaPagamentoId;
    private final String referencia;
    
    public IntencaoVendaPesquisa(IntencaoVenda iv) {
        this.intencaoVendaId = iv.getId();
        this.formaPagamentoId = (iv.getFormaPagamento() != null && iv.getFormaPagamento().getId() > 0 ? iv.getFormaPagamento().getId() : 0);
        this.referencia = (iv.getReferencia() != null ? iv.getReferencia() : null);
    }

    public int getIntencaoVendaId() {
        return intencaoVendaId;
    }

    public int getFormaPagamentoId() {
        return formaPagamentoId;
    }

    public String getReferencia() {
        return referencia;
    }

}

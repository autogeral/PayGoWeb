/*
 * The MIT License
 *
 * Copyright 2019 Murilo de Moraes Tuvani.
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

import java.util.Date;

/**
 * 28/05/2019 09:21:15
 * @author Murilo de Moraes Tuvani
 */
public class IntecaoVendaVO {
    
    private int id;
    private String token;
    private Date data;
    private Date hora;
    private int quantidade;
    private double valorOriginal;
    private String valorOriginalFormat;
    private double valorDesconto;
    private String valorDescontoFormat;
    private double valorFinal;
    private String valorFinalFormat;
    private String gate2allToken;
    private int quantidadeParcelas;
    private String urlPagamento;
    private FormaPagamento formaPagamento;

}

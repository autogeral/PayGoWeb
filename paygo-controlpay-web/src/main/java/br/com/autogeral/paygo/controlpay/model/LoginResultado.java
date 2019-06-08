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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 07/06/2019 08:37:14
 * @author Murilo Moraes Tuvani
 */
public class LoginResultado {
    
    private LocalDateTime data;
    private LoginPessoa pessoa;
    private String operador;
    private AplicacaoVersao android;
    private AplicacaoVersao ios;
    private AplicacaoVersao app;

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public LoginPessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(LoginPessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public AplicacaoVersao getAndroid() {
        return android;
    }

    public void setAndroid(AplicacaoVersao android) {
        this.android = android;
    }

    public AplicacaoVersao getIos() {
        return ios;
    }

    public void setIos(AplicacaoVersao ios) {
        this.ios = ios;
    }

    public AplicacaoVersao getApp() {
        return app;
    }

    public void setApp(AplicacaoVersao app) {
        this.app = app;
    }

    @Override
    public String toString() {
        return "LoginResultado{" + "data=" + data.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + ", pessoa=" + pessoa + ", operador=" + operador + ", android=" + android + ", ios=" + ios + ", app=" + app + '}';
    }
}

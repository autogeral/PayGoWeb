/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.autogeral.paygo.controlpay.web;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.cookie.CookieSpecBase;
import org.apache.commons.httpclient.cookie.MalformedCookieException;

/**
 * Apenas para satisfazer a ADVERTENCIA: Cookie recused
 * https://codesharing.wordpress.com/2011/07/04/httpclient-3-1-custom-cookie-policy/
 * @author murilo.lima
 */
public class PermitAllCookiesSpec extends CookieSpecBase {

    @Override
    public void validate(String host, int port, String path, boolean secure, final Cookie cookie) throws MalformedCookieException {
    }
}

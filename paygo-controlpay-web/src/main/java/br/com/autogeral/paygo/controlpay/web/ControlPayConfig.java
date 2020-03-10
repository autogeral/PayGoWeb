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
package br.com.autogeral.paygo.controlpay.web;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * 25/05/2019 10:30:19
 *
 * @author Murilo Moraes Tuvani
 */
public class ControlPayConfig {

    private static ControlPayConfig config;
    private String key;
    private String servidor;
    private String terminal;
    private String cpfCnpj;
    private String senha;
    private String senhaTecnica;

    public ControlPayConfig(String key, String servidor, String terminal, String cpfCnpj, String senha, String senhaTecnica) {
        this.key = key;
        this.servidor = servidor;
        this.terminal = terminal;
        this.cpfCnpj = cpfCnpj;
        this.senha = senha;
        this.senhaTecnica = senhaTecnica;
    }

    public ControlPayConfig getConfig(ControlPayConfig config) {

        if (config == null) {
            ControlPayConfig configa = new ControlPayConfig(this.key, this.servidor, this.terminal, this.cpfCnpj, this.senha, this.senhaTecnica);
            this.config = configa;
            this.config.load();
        }
        return this.config = config;
    }

    private void load() {
        String configFile = System.getProperty("controlPay.config", "controlPay.properties");
        File file = new File(configFile);
        if (!file.exists()) {
            System.out.println("Arquivo de configuração não existe : " + file.getAbsolutePath());
        } else {
            Properties prop = new Properties();
            try (FileReader reader = new FileReader(file)) {
                prop.load(reader);
                config.key = prop.getProperty("key");
                config.servidor = prop.getProperty("servidor");
                config.terminal = prop.getProperty("terminal");
                config.cpfCnpj = prop.getProperty("cpfCnpj");
                config.senha = prop.getProperty("senha");
                config.senhaTecnica = prop.getProperty("senhaTecnica");
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }

    /**
     * Chave do estabelecimento fornecedido pela PayGo / ControlPay
     *
     * @return
     */
    public String getKey() {
        return key;
    }

    public void setKey(String newKey) {
        this.key = newKey;
    }

    /**
     * O servidor para o qual deve-se enviar as requisições O retorno deve
     * compor a URL sem a parte do cominho
     *
     * @return
     */
    public String getServidor() {
        return servidor;
    }

    /**
     * Numero do terminal fornecedido pela PayGo / ControlPay
     *
     * @return
     */
    public String getTerminal() {
        return terminal;
    }

    /**
     * Número do CPF ou CNPJ para autenticacao no web service</br>
     * Para uso em LoginLogin</br>
     *
     * @return
     */
    public String getCpfCnpj() {
        return cpfCnpj;
    }

    /**
     * Senha para autenticacao no web service</br>
     * Para uso em LoginLogin</br>
     *
     * @return
     */
    public String getSenha() {
        return senha;
    }

    public String getSenhaTecnica() {
        return senhaTecnica;
    }

    public void setSenhaTecnica(String senhaTecnica) {
        this.senhaTecnica = senhaTecnica;
    }

}

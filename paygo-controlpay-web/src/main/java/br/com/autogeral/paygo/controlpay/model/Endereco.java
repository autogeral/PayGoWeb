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

import com.google.gson.annotations.SerializedName;

/**
 * 03/06/2019 15:53:01
 * @author Murilo Moraes Tuvani
 */
public class Endereco {

    @SerializedName (value = "tipoLogradouro",alternate = {"TipoLogradouro"})
    private String tipoLogradouro;
    @SerializedName (value = "logradouro",alternate = {"Logradouro"})
    private String logradouro;
    @SerializedName(value = "numero",alternate = {"Numero"})
    private String numero;
    @SerializedName(value= "complemento",alternate = {"Complemento"})
    private String complemento;
    @SerializedName(value = "cep",alternate = {"Cep"})
    private String cep;
    @SerializedName(value = "bairro",alternate = {"Bairro"})
    private String bairro;
    @SerializedName (value = "cidade",alternate = {"Cidade"})
    private String cidade;
    @SerializedName(value = "uf",alternate = {"Uf"})
    private String uf;
    @SerializedName(value ="latitude",alternate = {"Latitude"})
    private String latitude;
    @SerializedName(value ="longitude",alternate = {"Longitude"})
    private String longitude;
    @SerializedName(value = "geoLocalizacao",alternate = {"GeoLocalizacao"})
    private String geoLocalizacao;

    public String getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(String tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getGeoLocalizacao() {
        return geoLocalizacao;
    }

    public void setGeoLocalizacao(String geoLocalizacao) {
        this.geoLocalizacao = geoLocalizacao;
    }
    

   
    
    
}

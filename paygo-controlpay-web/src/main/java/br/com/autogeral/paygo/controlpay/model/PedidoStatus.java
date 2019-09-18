package br.com.autogeral.paygo.controlpay.model;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author kaique.mota
 */
public class PedidoStatus {

    @SerializedName(value = "id", alternate = "Id")
    private int id;
    private String nome;

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



}

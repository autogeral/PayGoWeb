package br.com.autogeral.paygo.controlpay.model;

import com.google.gson.annotations.SerializedName;

/**
 * 02/06/2019 21:48:13
 *
 * @author Murilo Moraes Tuvani
 */
public class Produto {

    @SerializedName(value = "itemProdutoId", alternate = {"ItemProdutoId"})
    private String itemProdutoId;
    @SerializedName(value = "id", alternate = {"Id"})
    private int id;
    @SerializedName(value = "nome", alternate = {"Nome"})
    private String nome;
    private String descricao;
    private String nomeExibe;
    @SerializedName(value = "quantidade", alternate = {"Quantidade"})
    private int quantidade;
    @SerializedName(value = "valor", alternate = {"Valor"})
    private String valor;
    private boolean solicitaValor;
    private String valorFormat;
    private boolean controlaQuantidade;
    private String fotoThumbnail;
    private String produtoTipo;
    private String ean;
    private String ncm;
    private String cfop;
    private String extipi;
    private String origem;
    private String unidadeTributaria;
    private int quantidadeTributaria;
    private String unidadeComercial;
    private int quantidadeComercial;
    private String informacoesComplementares;
    private String produtoImposto;
    private ProdutoStatus produtoStatus;
    private String fotoNome;
    private String fotBase64;
    private String referencia;
    private boolean servico;
    private ProdutoCategoria produtoCategoria;

    public String getItemProdutoId() {
        return itemProdutoId;
    }

    public void setItemProdutoId(String itemProdutoId) {
        this.itemProdutoId = itemProdutoId;
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

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public boolean isSolicitaValor() {
        return solicitaValor;
    }

    public void setSolicitaValor(boolean solicitaValor) {
        this.solicitaValor = solicitaValor;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isControlaQuantidade() {
        return controlaQuantidade;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getCfop() {
        return cfop;
    }

    public void setCfop(String cfop) {
        this.cfop = cfop;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public String getExtipi() {
        return extipi;
    }

    public void setExtipi(String extipi) {
        this.extipi = extipi;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getUnidadeTributaria() {
        return unidadeTributaria;
    }

    public void setUnidadeTributaria(String unidadeTributaria) {
        this.unidadeTributaria = unidadeTributaria;
    }

    public int getQuantidadeTributaria() {
        return quantidadeTributaria;
    }

    public void setQuantidadeTributaria(int quantidadeTributaria) {
        this.quantidadeTributaria = quantidadeTributaria;
    }

    public String getUnidadeComercial() {
        return unidadeComercial;
    }

    public void setUnidadeComercial(String unidadeComercial) {
        this.unidadeComercial = unidadeComercial;
    }

    public int getQuantidadeComercial() {
        return quantidadeComercial;
    }

    public void setQuantidadeComercial(int quantidadeComercial) {
        this.quantidadeComercial = quantidadeComercial;
    }

    public String getInformacoesComplementares() {
        return informacoesComplementares;
    }

    public void setInformacoesComplementares(String informacoesComplementares) {
        this.informacoesComplementares = informacoesComplementares;
    }

    public String getProdutoImposto() {
        return produtoImposto;
    }

    public void setProdutoImposto(String produtoImposto) {
        this.produtoImposto = produtoImposto;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNomeExibe() {
        return nomeExibe;
    }

    public void setNomeExibe(String nomeExibe) {
        this.nomeExibe = nomeExibe;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getValorFormat() {
        return valorFormat;
    }

    public void setValorFormat(String valorFormat) {
        this.valorFormat = valorFormat;
    }

    public boolean getControlaQuantidade() {
        return controlaQuantidade;
    }

    public void setControlaQuantidade(boolean controlaQuantidade) {
        this.controlaQuantidade = controlaQuantidade;
    }

    public String getFotoThumbnail() {
        return fotoThumbnail;
    }

    public void setFotoThumbnail(String fotoThumbnail) {
        this.fotoThumbnail = fotoThumbnail;
    }

    public String getProdutoTipo() {
        return produtoTipo;
    }

    public void setProdutoTipo(String produtoTipo) {
        this.produtoTipo = produtoTipo;
    }

    public ProdutoStatus getProdutoStatus() {
        return produtoStatus;
    }

    public void setProdutoStatus(ProdutoStatus produtoStatus) {
        this.produtoStatus = produtoStatus;
    }

    public String getFotoNome() {
        return fotoNome;
    }

    public void setFotoNome(String fotoNome) {
        this.fotoNome = fotoNome;
    }

    public String getFotBase64() {
        return fotBase64;
    }

    public void setFotBase64(String fotBase64) {
        this.fotBase64 = fotBase64;
    }

    public ProdutoCategoria getProdutoCategoria() {
        return produtoCategoria;
    }

    public void setProdutoCategoria(ProdutoCategoria produtoCategoria) {
        this.produtoCategoria = produtoCategoria;
    }

    public boolean isServico() {
        return servico;
    }

    public void setServico(boolean servico) {
        this.servico = servico;
    }

    @Override
    public String toString() {
        return "Produto{" + "itemProdutoId=" + itemProdutoId + ", id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", nomeExibe=" + nomeExibe + ", quantidade=" + quantidade + ", valor=" + valor + ", valorFormat=" + valorFormat + ", controlaQuantidade=" + controlaQuantidade + ", fotoThumbnail=" + fotoThumbnail + ", produtoTipo=" + produtoTipo + ", produtoStatus=" + produtoStatus + ", fotoNome=" + fotoNome + ", fotBase64=" + fotBase64 + '}';
    }

}

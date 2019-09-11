package br.com.autogeral.paygo.controlpay.model;

/**
 * 02/06/2019 21:48:13
 *
 * @author Murilo Moraes Tuvani
 */
public class Produto {

    private String itemProdutoId;
    private int id;
    private String nome;
    private String descricao;
    private String nomeExibe;
    private int quantidade;
    private double valor;
    private String valorFormat;
    private boolean controlaQuantidade;
    private String fotoThumbnail;
    private String produtoTipo;
    private ProdutoStatus produtoStatus;
    private String fotoNome;
    private String fotBase64;

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

    public String getDescricao() {
        return descricao;
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
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

    @Override
    public String toString() {
        return "Produto{" + "itemProdutoId=" + itemProdutoId + ", id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", nomeExibe=" + nomeExibe + ", quantidade=" + quantidade + ", valor=" + valor + ", valorFormat=" + valorFormat + ", controlaQuantidade=" + controlaQuantidade + ", fotoThumbnail=" + fotoThumbnail + ", produtoTipo=" + produtoTipo + ", produtoStatus=" + produtoStatus + ", fotoNome=" + fotoNome + ", fotBase64=" + fotBase64 + '}';
    }

}

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
    private String valor;
    private boolean solicitaValor;
    private String valorFormat;
    private boolean controlaQuantidade;
    private String fotoThumbnail;
    private String produtoTipo;
    private String  ean;
    private ProdutoStatus produtoStatus;
    private String fotoNome;
    private String fotBase64;
    private String referencia;
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

    @Override
    public String toString() {
        return "Produto{" + "itemProdutoId=" + itemProdutoId + ", id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", nomeExibe=" + nomeExibe + ", quantidade=" + quantidade + ", valor=" + valor + ", valorFormat=" + valorFormat + ", controlaQuantidade=" + controlaQuantidade + ", fotoThumbnail=" + fotoThumbnail + ", produtoTipo=" + produtoTipo + ", produtoStatus=" + produtoStatus + ", fotoNome=" + fotoNome + ", fotBase64=" + fotBase64 + '}';
    }

}

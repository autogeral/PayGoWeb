
package br.com.autogeral.paygo.controlpay.model;

/**
 *
 * @author kaique.mota
 */
public class Vendedor {
    
    private int id;
    private String nomeRazaoSocial;
    private String sobrenomeNomeFantasia;
    private String fotoThumbnail;
    private String parceiro;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeRazaoSocial() {
        return nomeRazaoSocial;
    }

    public void setNomeRazaoSocial(String nomeRazaoSocial) {
        this.nomeRazaoSocial = nomeRazaoSocial;
    }

    public String getSobrenomeNomeFantasia() {
        return sobrenomeNomeFantasia;
    }

    public void setSobrenomeNomeFantasia(String sobrenomeNomeFantasia) {
        this.sobrenomeNomeFantasia = sobrenomeNomeFantasia;
    }

    public String getFotoThumbnail() {
        return fotoThumbnail;
    }

    public void setFotoThumbnail(String fotoThumbnail) {
        this.fotoThumbnail = fotoThumbnail;
    }

    public String getParceiro() {
        return parceiro;
    }

    public void setParceiro(String parceiro) {
        this.parceiro = parceiro;
    }
    
    
}

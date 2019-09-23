package br.com.autogeral.paygo.controlpay.model;

/**
 *
 * @author kaique.mota
 */
public class VendaCancelamento {

    private String intencaoVendaId;
    private String terminalId;
    private boolean aguardarTefIniciarTransacao;
    private String senhaTecnica;

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getIntencaoVendaId() {
        return intencaoVendaId;
    }

    public void setIntencaoVendaId(String intencaoVendaId) {
        this.intencaoVendaId = intencaoVendaId;
    }

    public boolean isAguardarTefIniciarTransacao() {
        return aguardarTefIniciarTransacao;
    }

    public void setAguardarTefIniciarTransacao(boolean aguardarTefIniciarTransacao) {
        this.aguardarTefIniciarTransacao = aguardarTefIniciarTransacao;
    }

    public String getSenhaTecnica() {
        return senhaTecnica;
    }

    public void setSenhaTecnica(String senhaTecnica) {
        this.senhaTecnica = senhaTecnica;
    }

}

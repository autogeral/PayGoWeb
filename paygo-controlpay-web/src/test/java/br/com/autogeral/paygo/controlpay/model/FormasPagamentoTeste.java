package br.com.autogeral.paygo.controlpay.model;

import br.com.autogeral.paygo.controlpay.web.WsHelper;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author kaique.mota
 */
public class FormasPagamentoTeste {
    
    private static final int ID = 1;
    private static final String NOME = "PAY2all";
    private static final String MODALIDADE = "Gerar Token";
    private static final boolean PERMITE_PARCELAMENTO = false;
    private static final boolean SOLICITA_OBS = false;
    private static final int QUANTIDADE_MAXIMA_PARCELAS = 1;
    private static final boolean ISENTO_DE_TARIFA = false;
    private static final int FLUXO_ID = 1;
    private static final String FLUXO_NOME = "PAY2all Token";
    
    @Test
    public void testSerialize() {
        FormaPagamento fp = new FormaPagamento();
        fp.setId(ID);
        fp.setNome(NOME);
        fp.setModalidade(MODALIDADE);
        fp.setPermiteParcelamento(PERMITE_PARCELAMENTO);
        fp.setSolicitaObs(SOLICITA_OBS);
        fp.setQuantidadeMaximaParcelas(QUANTIDADE_MAXIMA_PARCELAS);
        fp.setIsentoDeTarifa(ISENTO_DE_TARIFA);
        FluxoPagamento fluxo = new FluxoPagamento();
        fluxo.setId(FLUXO_ID);
        fluxo.setNome(FLUXO_NOME);
    }
    
    @Test
    public void testParseData() {
        String toParse = "{\n"
                + "  \"data\": \"01/01/2017 00:00:00.0000\",\n"
                + "  \"formasPagamento\": [\n"
                + "    {\n"
                + "      \"id\": " + ID + ",\n"
                + "      \"nome\": \"" + NOME + "\",\n"
                + "      \"modalidade\": \"" + MODALIDADE + "\",\n"
                + "      \"permiteParcelamento\": " + PERMITE_PARCELAMENTO + ",\n"
                + "      \"solicitaObs\": " + SOLICITA_OBS + ",\n"
                + "      \"quantidadeMaximaParcelas\": " + QUANTIDADE_MAXIMA_PARCELAS + ",\n"
                + "      \"isentoDeTarifa\": " + ISENTO_DE_TARIFA + ",\n"
                + "      \"fluxoPagamento\": {\n"
                + "        \"id\": " + FLUXO_ID + ",\n"
                + "        \"nome\": \"" + FLUXO_NOME + "\"\n"
                + "      }\n"
                + "    },\n"
                + "    {\n"
                + "      \"id\": " + ID + ",\n"
                + "      \"nome\": \"" + NOME + "\",\n"
                + "      \"modalidade\": \"" + MODALIDADE + "\",\n"
                + "      \"permiteParcelamento\": " + PERMITE_PARCELAMENTO + ",\n"
                + "      \"solicitaObs\": " + SOLICITA_OBS + ",\n"
                + "      \"quantidadeMaximaParcelas\": " + QUANTIDADE_MAXIMA_PARCELAS + ",\n"
                + "      \"isentoDeTarifa\": " + ISENTO_DE_TARIFA + ",\n"
                + "      \"fluxoPagamento\": {\n"
                + "        \"id\": " + FLUXO_ID + ",\n"
                + "        \"nome\": \"" + FLUXO_NOME + "\"\n"
                + "      }\n"
                + "    },\n"
                + "    {\n"
                + "      \"id\": 11,\n"
                + "      \"nome\": \"POS\",\n"
                + "      \"modalidade\": \"Crédito\",\n"
                + "      \"permiteParcelamento\": false,\n"
                + "      \"solicitaObs\": false,\n"
                + "      \"quantidadeMaximaParcelas\": 1,\n"
                + "      \"isentoDeTarifa\": true,\n"
                + "      \"fluxoPagamento\": {\n"
                + "        \"id\": 11,\n"
                + "        \"nome\": \"Pagamento Sem Confirmação\"\n"
                + "      }\n"
                + "    },\n"
                + "    {\n"
                + "      \"id\": 12,\n"
                + "      \"nome\": \"POS\",\n"
                + "      \"modalidade\": \"Débito\",\n"
                + "      \"permiteParcelamento\": false,\n"
                + "      \"solicitaObs\": false,\n"
                + "      \"quantidadeMaximaParcelas\": 1,\n"
                + "      \"isentoDeTarifa\": true,\n"
                + "      \"fluxoPagamento\": {\n"
                + "        \"id\": 11,\n"
                + "        \"nome\": \"Pagamento Sem Confirmação\"\n"
                + "      }\n"
                + "    },\n"
                + "    {\n"
                + "      \"id\": 13,\n"
                + "      \"nome\": \"POS\",\n"
                + "      \"modalidade\": \"Voucher\",\n"
                + "      \"permiteParcelamento\": false,\n"
                + "      \"solicitaObs\": false,\n"
                + "      \"quantidadeMaximaParcelas\": 1,\n"
                + "      \"isentoDeTarifa\": true,\n"
                + "      \"fluxoPagamento\": {\n"
                + "        \"id\": 11,\n"
                + "        \"nome\": \"Pagamento Sem Confirmação\"\n"
                + "      }\n"
                + "    },\n"
                + "    {\n"
                + "      \"id\": 41,\n"
                + "      \"nome\": \"Dinheiro\",\n"
                + "      \"modalidade\": \"\",\n"
                + "      \"permiteParcelamento\": false,\n"
                + "      \"solicitaObs\": false,\n"
                + "      \"quantidadeMaximaParcelas\": 1,\n"
                + "      \"isentoDeTarifa\": true,\n"
                + "      \"fluxoPagamento\": {\n"
                + "        \"id\": 11,\n"
                + "        \"nome\": \"Pagamento Sem Confirmação\"\n"
                + "      }\n"
                + "    },\n"
                + "    {\n"
                + "      \"id\": 21,\n"
                + "      \"nome\": \"TEF\",\n"
                + "      \"modalidade\": \"Crédito\",\n"
                + "      \"permiteParcelamento\": true,\n"
                + "      \"solicitaObs\": false,\n"
                + "      \"quantidadeMaximaParcelas\": 12,\n"
                + "      \"isentoDeTarifa\": true,\n"
                + "      \"fluxoPagamento\": {\n"
                + "        \"id\": 21,\n"
                + "        \"nome\": \"TEF\"\n"
                + "      }\n"
                + "    },\n"
                + "    {\n"
                + "      \"id\": 22,\n"
                + "      \"nome\": \"TEF\",\n"
                + "      \"modalidade\": \"Débito\",\n"
                + "      \"permiteParcelamento\": false,\n"
                + "      \"solicitaObs\": false,\n"
                + "      \"quantidadeMaximaParcelas\": 1,\n"
                + "      \"isentoDeTarifa\": true,\n"
                + "      \"fluxoPagamento\": {\n"
                + "        \"id\": 21,\n"
                + "        \"nome\": \"TEF\"\n"
                + "      }\n"
                + "    },\n"
                + "    {\n"
                + "      \"id\": 23,\n"
                + "      \"nome\": \"TEF\",\n"
                + "      \"modalidade\": \"Voucher\",\n"
                + "      \"permiteParcelamento\": false,\n"
                + "      \"solicitaObs\": false,\n"
                + "      \"quantidadeMaximaParcelas\": 1,\n"
                + "      \"isentoDeTarifa\": true,\n"
                + "      \"fluxoPagamento\": {\n"
                + "        \"id\": 21,\n"
                + "        \"nome\": \"TEF\"\n"
                + "      }\n"
                + "    },\n"
                + "    {\n"
                + "      \"id\": 24,\n"
                + "      \"nome\": \"TEF\",\n"
                + "      \"modalidade\": \"Outros\",\n"
                + "      \"permiteParcelamento\": true,\n"
                + "      \"solicitaObs\": false,\n"
                + "      \"quantidadeMaximaParcelas\": 12,\n"
                + "      \"isentoDeTarifa\": true,\n"
                + "      \"fluxoPagamento\": {\n"
                + "        \"id\": 21,\n"
                + "        \"nome\": \"TEF\"\n"
                + "      }\n"
                + "    },\n"
                + "    {\n"
                + "      \"id\": 32,\n"
                + "      \"nome\": \"TEF\",\n"
                + "      \"modalidade\": \"Crédito*\",\n"
                + "      \"permiteParcelamento\": true,\n"
                + "      \"solicitaObs\": false,\n"
                + "      \"quantidadeMaximaParcelas\": 3,\n"
                + "      \"isentoDeTarifa\": false,\n"
                + "      \"fluxoPagamento\": {\n"
                + "        \"id\": 21,\n"
                + "        \"nome\": \"TEF\"\n"
                + "      }\n"
                + "    },\n"
                + "    {\n"
                + "      \"id\": 33,\n"
                + "      \"nome\": \"TEF\",\n"
                + "      \"modalidade\": \"Débito*\",\n"
                + "      \"permiteParcelamento\": false,\n"
                + "      \"solicitaObs\": false,\n"
                + "      \"quantidadeMaximaParcelas\": 1,\n"
                + "      \"isentoDeTarifa\": false,\n"
                + "      \"fluxoPagamento\": {\n"
                + "        \"id\": 21,\n"
                + "        \"nome\": \"TEF\"\n"
                + "      }\n"
                + "    },\n"
                + "    {\n"
                + "      \"id\": 51,\n"
                + "      \"nome\": \"Cartão de crédito digitado\",\n"
                + "      \"modalidade\": \"\",\n"
                + "      \"permiteParcelamento\": true,\n"
                + "      \"solicitaObs\": false,\n"
                + "      \"quantidadeMaximaParcelas\": 12,\n"
                + "      \"isentoDeTarifa\": true,\n"
                + "      \"fluxoPagamento\": {\n"
                + "        \"id\": 31,\n"
                + "        \"nome\": \"Gateway Crédito\"\n"
                + "      }\n"
                + "    },\n"
                + "    {\n"
                + "      \"id\": 52,\n"
                + "      \"nome\": \"Cartão de débito digitado\",\n"
                + "      \"modalidade\": \"\",\n"
                + "      \"permiteParcelamento\": false,\n"
                + "      \"solicitaObs\": false,\n"
                + "      \"quantidadeMaximaParcelas\": 1,\n"
                + "      \"isentoDeTarifa\": true,\n"
                + "      \"fluxoPagamento\": {\n"
                + "        \"id\": 32,\n"
                + "        \"nome\": \"Gateway Débido\"\n"
                + "      }\n"
                + "    },\n"
                + "    {\n"
                + "      \"id\": 53,\n"
                + "      \"nome\": \"Boleto\",\n"
                + "      \"modalidade\": \"\",\n"
                + "      \"permiteParcelamento\": false,\n"
                + "      \"solicitaObs\": false,\n"
                + "      \"quantidadeMaximaParcelas\": 1,\n"
                + "      \"isentoDeTarifa\": true,\n"
                + "      \"fluxoPagamento\": {\n"
                + "        \"id\": 33,\n"
                + "        \"nome\": \"Gateway Boleto\"\n"
                + "      }\n"
                + "    }\n"
                + "  ]\n"
                + "}";
        
        Data d = WsHelper.unmarshal(toParse, Data.class);
        assertNotNull(d);
        List<FormaPagamento> formaPagamento = d.getFormasPagamento();
        testeParseData(formaPagamento);
    }
    
    private void testeParseData(List<FormaPagamento> fp) {
        assertNotNull(fp);
        assertEquals(ID, fp.get(0).getId());
        assertEquals(NOME, fp.get(0).getNome());
        assertEquals(MODALIDADE, fp.get(0).getModalidade());
        assertEquals(PERMITE_PARCELAMENTO, fp.get(0).isPermiteParcelamento());
        assertEquals(SOLICITA_OBS, fp.get(0).isSolicitaObs());
        assertEquals(QUANTIDADE_MAXIMA_PARCELAS, fp.get(0).getQuantidadeMaximaParcelas());
        assertEquals(ISENTO_DE_TARIFA, fp.get(0).isIsentoDeTarifa());
        assertEquals(FLUXO_ID, fp.get(0).getFluxoPagamento().getId());
        assertEquals(FLUXO_NOME, fp.get(0).getFluxoPagamento().getNome());
    }
}

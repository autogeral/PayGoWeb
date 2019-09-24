package br.com.autogeral.paygo.controlpay.model;

import br.com.autogeral.paygo.controlpay.web.WsHelper;
import java.time.LocalDateTime;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author kaique.mota
 */
public class PagamentoExternoTeste {

    private static final String TERMINALID = "123";
    private static final int PAGAMENTO_EXTERNO_ID = 122321;
    private static final int PAGAMENTO_EXTERNO_TIPO = 15;
    private static final int PAGAMENTO_EXTERNO_ORIGEM = 1;
    private static final int PAGAMENTO_EXTERNO_STATUS_ID = 10;
    private static final String PAGAMENTO_EXTERNO_STATUS_NOME = "EM OPERACAO";
    private static final int PESSOA_ID = 10;
    private static final String NOME_RAZAO_SOCIAL = "AUTO GERAL AUTOPECAS LTDA";
    private static final String SOBRENOME_NOME_FANTASIA = "AUTO GERAL AUTOPECAS LTDA";
    private static final int TERMINAL_ID = 81;
    private static final String NOME = "CAIXA 01";
    private static final String DATA = "17/11/2016 18:32:10.8603";

    @Test
    public void test_Serialize() {
        Data d = new Data();
        PagamentoExterno pagamentoExterno = new PagamentoExterno();
        d.setData(LocalDateTime.MAX);
        pagamentoExterno.setTerminalId(TERMINAL_ID);
        pagamentoExterno.setId(PAGAMENTO_EXTERNO_ID);
        pagamentoExterno.setTipo(PAGAMENTO_EXTERNO_TIPO);
        pagamentoExterno.setOrigem(PAGAMENTO_EXTERNO_ORIGEM);
        PagamentoExternoStatus status = new PagamentoExternoStatus();
        status.setId(PAGAMENTO_EXTERNO_STATUS_ID);
        status.setNome(PAGAMENTO_EXTERNO_STATUS_NOME);
        Pessoa pessoa = new Pessoa();
        pessoa.setId(PESSOA_ID);
        pessoa.setNomeRazaoSocial(NOME_RAZAO_SOCIAL);
        pessoa.setSobrenomeNomeFantasia(SOBRENOME_NOME_FANTASIA);
        Terminal terminal = new Terminal();
        terminal.setId(TERMINAL_ID);
        terminal.setNome(NOME);
    }

    @Test
    public void test_Parse() {
        String toParse = "{\n"
                + "  \"data\": \"" + DATA + "\",\n"
                + "  \"pagamentoExterno\": {\n"
                + "    \"id\": " + PAGAMENTO_EXTERNO_ID + ",\n"
                + "    \"tipo\": " + PAGAMENTO_EXTERNO_TIPO + ",\n"
                + "    \"origem\": " + PAGAMENTO_EXTERNO_TIPO + ",\n"
                + "    \"pagamentoExternoStatus\": {\n"
                + "      \"id\": " + PAGAMENTO_EXTERNO_STATUS_ID + ",\n"
                + "      \"nome\": \"" + PAGAMENTO_EXTERNO_STATUS_NOME + "\"\n"
                + "    },\n"
                + "    \"pessoa\": {\n"
                + "      \"id\": " + PESSOA_ID + ",\n"
                + "      \"nomeRazaoSocial\": \"" + NOME_RAZAO_SOCIAL + "\",\n"
                + "      \"sobrenomeNomeFantasia\": \"" + SOBRENOME_NOME_FANTASIA + "\"\n"
                + "    },\n"
                + "    \"terminal\": {\n"
                + "      \"id\": " + TERMINAL_ID + ",\n"
                + "      \"nome\": \"" + TERMINALID + "\"\n"
                + "    }\n"
                + "  }";

        PagamentoExterno pag = WsHelper.unmarshal(toParse, PagamentoExterno.class);
        testParsePagamento(pag);
    }

    private void  testParsePagamento(PagamentoExterno pagamento){
        assertNotNull(pagamento);
        Data d = new Data();
        assertEquals(DATA, d.getData());
        assertEquals(PAGAMENTO_EXTERNO_ID, pagamento.getId());
        assertEquals(PAGAMENTO_EXTERNO_TIPO, pagamento.getTipo());

        
    }
}

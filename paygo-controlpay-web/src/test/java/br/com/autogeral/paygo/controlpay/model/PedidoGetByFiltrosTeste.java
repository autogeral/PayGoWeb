package br.com.autogeral.paygo.controlpay.model;


import br.com.autogeral.paygo.controlpay.model.Pessoa;
import br.com.autogeral.paygo.controlpay.web.WsHelper;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author kaique.mota
 */
public class PedidoGetByFiltrosTeste {

    private static final int pessoaIds = 1;

    @Test
    public void test_serializable() {
        Pessoa pessoa = new Pessoa();

        pessoa.setId(pessoaIds);

        String result = WsHelper.marshal(pessoa);
        System.out.println(result);
    }

    public void test_parse() {
        String toParse = " {\n"
                + "   \"pessoaIds\": \"12\"\n"
                + "}";
    }

    private void testPedido(Pessoa pessoa) {

        assertNotNull(pessoa);

        assertEquals(pessoaIds, pessoa.getId());
    }

}

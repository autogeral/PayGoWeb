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

import br.com.autogeral.paygo.controlpay.web.WsHelper;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Murilo Moraes Tuvani
 */
public class DataTest {

    public DataTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    public static final String DATA_HORA_RESPOSTA = "07/06/2019 22:40:30.2242";
    public static final int TERMINAL_000_ID = 1;
    public static final String TERMINAL_000_NOME = "Terminal 00";
    public static final boolean TERMINAL_000_SOLICITAR_REFENCIA = false;
    public static final boolean TERMINAL_000_SOLICITAR_CLIENTE = false;
    public static final boolean TERMINAL_000_SOLICITAR_OPERADOR = false;
    public static final String TERMINAL_000_IDENTIFICADOR_TEF = "01234567000123";
    public static final String TERMINAL_000_RASTREAR_INTERVALO = "";
    public static final boolean TERMINAL_000_PERMITE_VENDA_PARCELADA = true;
    public static final String TERMINAL_000_PARCELAMENTO_PADRAO = "loja";
    public static final boolean TERMINAL_000_PERMITE_DESCONTO = false;
    public static final boolean TERMINAL_000_PERMITE_ACRESCIMO = false;
    public static final boolean TERMINAL_000_AGUARDAR_TEF = true;
    public static final boolean TERMINAL_000_HABILITAR_PDV = true;
    public static final boolean TERMINAL_000_VENDA_POR_VALOR = true;
    public static final boolean TERMINAL_000_VENDA_POR_PRODUTO = false;
    public static final boolean TERMINAL_000_HABILITAR_PEDIDOS = false;
    public static final boolean TERMINAL_000_IMPRESSAO_AUTOMATICA = false;
    public static final boolean TERMINAL_000_IMPRIMIR_PRODUTOS = false;
    public static final boolean TERMINAL_000_IMPRIMIR_CUPOM_LOJISTA = false;
    public static final boolean TERMINAL_000_IPMRIMIR_CUPOM_CLIENTE = false;

    public static final int TERMINAL_000_FISICO_ID = 999;
    public static final String TERMINAL_000_FISICO_INSTALACAO_ID = "654321";
    
    public static final int TERMINAL_001_ID = 100;
    public static final String TERMINAL_001_NOME = "Terminal 01";
    public static final boolean TERMINAL_001_SOLICITAR_REFENCIA = false;
    public static final boolean TERMINAL_001_SOLICITAR_CLIENTE = false;
    public static final boolean TERMINAL_001_SOLICITAR_OPERADOR = false;
    public static final String TERMINAL_001_IDENTIFICADOR_TEF = "01234567001123";
    public static final String TERMINAL_001_RASTREAR_INTERVALO = "";
    public static final boolean TERMINAL_001_PERMITE_VENDA_PARCELADA = true;
    public static final String TERMINAL_001_PARCELAMENTO_PADRAO = "loja";
    public static final boolean TERMINAL_001_PERMITE_DESCONTO = false;
    public static final boolean TERMINAL_001_PERMITE_ACRESCIMO = false;
    public static final boolean TERMINAL_001_AGUARDAR_TEF = true;
    public static final boolean TERMINAL_001_HABILITAR_PDV = true;
    public static final boolean TERMINAL_001_VENDA_POR_VALOR = true;
    public static final boolean TERMINAL_001_VENDA_POR_PRODUTO = false;
    public static final boolean TERMINAL_001_HABILITAR_PEDIDOS = false;
    public static final boolean TERMINAL_001_IMPRESSAO_AUTOMATICA = false;
    public static final boolean TERMINAL_001_IMPRIMIR_PRODUTOS = false;
    public static final boolean TERMINAL_001_IMPRIMIR_CUPOM_LOJISTA = false;
    public static final boolean TERMINAL_001_IPMRIMIR_CUPOM_CLIENTE = false;

    public static final int TERMINAL_001_FISICO_ID = 998;
    public static final String TERMINAL_001_FISICO_INSTALACAO_ID = "654322";

    /**
     * Test of getHttpStatus method, of class Data.
     */
    @Test
    public void test_parse_getTerminalByPessoaId() {
        String toParse = "{\n"
                + "    \"data\": \"" + DATA_HORA_RESPOSTA + "\",\n"
                + "    \"terminais\": [\n"
                + "        {\n"
                + "            \"id\": " + TERMINAL_000_ID + ",\n"
                + "            \"nome\": \"" + TERMINAL_000_NOME + "\",\n"
                + "            \"solicitarReferencia\": " + TERMINAL_000_SOLICITAR_REFENCIA + ",\n"
                + "            \"solicitarCliente\": " + TERMINAL_000_SOLICITAR_CLIENTE + ",\n"
                + "            \"solicitarOperador\": " + TERMINAL_000_SOLICITAR_OPERADOR + ",\n"
                + "            \"identificadorTef\": \"" + TERMINAL_000_IDENTIFICADOR_TEF + "\",\n"
                + "            \"rastrearIntervalo\": \"" + TERMINAL_000_RASTREAR_INTERVALO + "\",\n"
                + "            \"permiteVendaParcelada\": " + TERMINAL_000_PERMITE_VENDA_PARCELADA + ",\n"
                + "            \"parcelamentoPadrao\": \"" + TERMINAL_000_PARCELAMENTO_PADRAO + "\",\n"
                + "            \"permiteDesconto\": " + TERMINAL_000_PERMITE_DESCONTO + ",\n"
                + "            \"permiteAcrescimo\": " + TERMINAL_000_PERMITE_ACRESCIMO + ",\n"
                + "            \"aguardaTef\": " + TERMINAL_000_AGUARDAR_TEF + ",\n"
                + "            \"habilitarPDV\": " + TERMINAL_000_HABILITAR_PDV + ",\n"
                + "            \"vendaPorValor\": " + TERMINAL_000_VENDA_POR_VALOR + ",\n"
                + "            \"vendaPorProduto\": " + TERMINAL_000_VENDA_POR_PRODUTO + ",\n"
                + "            \"habilitarPedidos\": " + TERMINAL_000_HABILITAR_PEDIDOS + ",\n"
                + "            \"impressaoAutomatica\": " + TERMINAL_000_IMPRESSAO_AUTOMATICA + ",\n"
                + "            \"imprimirProdutos\": " + TERMINAL_000_IMPRIMIR_PRODUTOS + ",\n"
                + "            \"imprimirCupomLojista\": " + TERMINAL_000_IMPRIMIR_CUPOM_LOJISTA + ",\n"
                + "            \"imprimirCupomCliente\": " + TERMINAL_000_IPMRIMIR_CUPOM_CLIENTE + ",\n"
                + "            \"impressora\": null,\n"
                + "            \"pessoa\": {\n"
                + "                \"id\": " + PessoaTest.PESSOA_ID + ",\n"
                + "                \"nomeRazaoSocial\": \"" + PessoaTest.NOME_RAZAO_SOCIAL + "\",\n"
                + "                \"sobrenomeNomeFantasia\": \"" + PessoaTest.SOBRENOME_NOMEFANTASIA + "\",\n"
                + "                \"pessoaJuridica\": " + PessoaTest.PESSOA_JURIDICA + ",\n"
                + "                \"cpfCnpj\": \"" + PessoaTest.CPF_CNPJ + "\",\n"
                + "                \"cpfCnpjFormat\": \"" + PessoaTest.CPF_CNPJ + "\",\n"
                + "                \"email\": \"" + PessoaTest.E_MAIL + "\",\n"
                + "                \"pessoaStatus\": {\n"
                + "                    \"id\": 2,\n"
                + "                    \"nome\": \"Ativo Vendedor\"\n"
                + "                }\n"
                + "            },\n"
                + "            \"terminalFisico\": {\n"
                + "                \"id\": " + TERMINAL_000_FISICO_ID + ",\n"
                + "                \"nome\": \"" + TERMINAL_000_NOME + "\",\n"
                + "                \"instalacaoId\": \"" + TERMINAL_000_FISICO_INSTALACAO_ID + "\",\n"
                + "                \"pessoa\": {\n"
                + "                    \"id\": " + PessoaTest.PESSOA_ID + ",\n"
                + "                    \"nomeRazaoSocial\": \"" + PessoaTest.NOME_RAZAO_SOCIAL + "\",\n"
                + "                    \"sobrenomeNomeFantasia\": \"" + PessoaTest.SOBRENOME_NOMEFANTASIA + "\",\n"
                + "                    \"cpfCnpj\": \"" + PessoaTest.CPF_CNPJ + "\"\n"
                + "                }\n"
                + "            },\n"
                + "            \"terminalParametros\": [\n"
                + "                {\n"
                + "                    \"id\": 12276,\n"
                + "                    \"valor\": \"true\",\n"
                + "                    \"parametro\": {\n"
                + "                        \"id\": 80,\n"
                + "                        \"nome\": \"permiteVendaParcelada\",\n"
                + "                        \"descricao\": \"Parâmetro para o vendedor configurar se permite ou não venda parcelada\",\n"
                + "                        \"valor\": null\n"
                + "                    }\n"
                + "                },\n"
                + "                {\n"
                + "                    \"id\": 12277,\n"
                + "                    \"valor\": \"loja\",\n"
                + "                    \"parametro\": {\n"
                + "                        \"id\": 41,\n"
                + "                        \"nome\": \"parcelamentopadrao\",\n"
                + "                        \"descricao\": \"Parâmetro para o vendedor configurar forma de Parcelamento padão\",\n"
                + "                        \"valor\": null\n"
                + "                    }\n"
                + "                },\n"
                + "                {\n"
                + "                    \"id\": 12278,\n"
                + "                    \"valor\": \"false\",\n"
                + "                    \"parametro\": {\n"
                + "                        \"id\": 42,\n"
                + "                        \"nome\": \"permiteDesconto\",\n"
                + "                        \"descricao\": \"Parâmetro para o vendedor configurar se permite ou não venda com desconto\",\n"
                + "                        \"valor\": null\n"
                + "                    }\n"
                + "                },\n"
                + "                {\n"
                + "                    \"id\": 12279,\n"
                + "                    \"valor\": \"false\",\n"
                + "                    \"parametro\": {\n"
                + "                        \"id\": 43,\n"
                + "                        \"nome\": \"permiteAcrescimo\",\n"
                + "                        \"descricao\": \"Parâmetro para o vendedor configurar se permite ou não venda com acréscimo\",\n"
                + "                        \"valor\": null\n"
                + "                    }\n"
                + "                },\n"
                + "                {\n"
                + "                    \"id\": 12280,\n"
                + "                    \"valor\": \"true\",\n"
                + "                    \"parametro\": {\n"
                + "                        \"id\": 44,\n"
                + "                        \"nome\": \"AguardaTef\",\n"
                + "                        \"descricao\": \"Parâmetro para o vendedor configurar se o PDV vai aguardar o TEF iniciar a transação\",\n"
                + "                        \"valor\": null\n"
                + "                    }\n"
                + "                },\n"
                + "                {\n"
                + "                    \"id\": 12281,\n"
                + "                    \"valor\": \"true\",\n"
                + "                    \"parametro\": {\n"
                + "                        \"id\": 64,\n"
                + "                        \"nome\": \"VendaPorValor\",\n"
                + "                        \"descricao\": \"Habilita Venda por valor na tela Vender\",\n"
                + "                        \"valor\": null\n"
                + "                    }\n"
                + "                },\n"
                + "                {\n"
                + "                    \"id\": 12282,\n"
                + "                    \"valor\": \"false\",\n"
                + "                    \"parametro\": {\n"
                + "                        \"id\": 78,\n"
                + "                        \"nome\": \"VendaPorProduto\",\n"
                + "                        \"descricao\": \"Habilita Venda por produto na tela Vender\",\n"
                + "                        \"valor\": null\n"
                + "                    }\n"
                + "                },\n"
                + "                {\n"
                + "                    \"id\": 12283,\n"
                + "                    \"valor\": \"false\",\n"
                + "                    \"parametro\": {\n"
                + "                        \"id\": 79,\n"
                + "                        \"nome\": \"HabilitarPedidos\",\n"
                + "                        \"descricao\": \"Habilita pedidos na tela Vender\",\n"
                + "                        \"valor\": null\n"
                + "                    }\n"
                + "                },\n"
                + "                {\n"
                + "                    \"id\": 12284,\n"
                + "                    \"valor\": \"true\",\n"
                + "                    \"parametro\": {\n"
                + "                        \"id\": 63,\n"
                + "                        \"nome\": \"HabilitarPDV\",\n"
                + "                        \"descricao\": \"Habilita PDV na tela vender\",\n"
                + "                        \"valor\": null\n"
                + "                    }\n"
                + "                },\n"
                + "                {\n"
                + "                    \"id\": 12285,\n"
                + "                    \"valor\": \"\",\n"
                + "                    \"parametro\": {\n"
                + "                        \"id\": 67,\n"
                + "                        \"nome\": \"RastrearIntervalo\",\n"
                + "                        \"descricao\": \"Tempo de Rastreamento do terminal\",\n"
                + "                        \"valor\": null\n"
                + "                    }\n"
                + "                },\n"
                + "                {\n"
                + "                    \"id\": 12286,\n"
                + "                    \"valor\": \"false\",\n"
                + "                    \"parametro\": {\n"
                + "                        \"id\": 68,\n"
                + "                        \"nome\": \"SolicitarReferencia\",\n"
                + "                        \"descricao\": \"Solicitar referencia na venda\",\n"
                + "                        \"valor\": null\n"
                + "                    }\n"
                + "                },\n"
                + "                {\n"
                + "                    \"id\": 12287,\n"
                + "                    \"valor\": \"false\",\n"
                + "                    \"parametro\": {\n"
                + "                        \"id\": 81,\n"
                + "                        \"nome\": \"SolicitarOperador\",\n"
                + "                        \"descricao\": \"Solicitar operador na venda\",\n"
                + "                        \"valor\": null\n"
                + "                    }\n"
                + "                },\n"
                + "                {\n"
                + "                    \"id\": 12288,\n"
                + "                    \"valor\": \"false\",\n"
                + "                    \"parametro\": {\n"
                + "                        \"id\": 75,\n"
                + "                        \"nome\": \"imprimirProdutos\",\n"
                + "                        \"descricao\": \"Imprimir lista de produtos de uma Intenção de venda ou Pedido\",\n"
                + "                        \"valor\": null\n"
                + "                    }\n"
                + "                },\n"
                + "                {\n"
                + "                    \"id\": 12289,\n"
                + "                    \"valor\": \"false\",\n"
                + "                    \"parametro\": {\n"
                + "                        \"id\": 76,\n"
                + "                        \"nome\": \"imprimirCupomLojista\",\n"
                + "                        \"descricao\": \"Imprimir cupom via do Lojista\",\n"
                + "                        \"valor\": null\n"
                + "                    }\n"
                + "                },\n"
                + "                {\n"
                + "                    \"id\": 12290,\n"
                + "                    \"valor\": \"false\",\n"
                + "                    \"parametro\": {\n"
                + "                        \"id\": 77,\n"
                + "                        \"nome\": \"imprimirCupomCliente\",\n"
                + "                        \"descricao\": \"Imprimir cupom via do Cliente\",\n"
                + "                        \"valor\": null\n"
                + "                    }\n"
                + "                },\n"
                + "                {\n"
                + "                    \"id\": 12291,\n"
                + "                    \"valor\": \"false\",\n"
                + "                    \"parametro\": {\n"
                + "                        \"id\": 69,\n"
                + "                        \"nome\": \"ImpressaoAutomatica\",\n"
                + "                        \"descricao\": \"ImpressaoAutomatica\",\n"
                + "                        \"valor\": null\n"
                + "                    }\n"
                + "                },\n"
                + "                {\n"
                + "                    \"id\": 12292,\n"
                + "                    \"valor\": \"false\",\n"
                + "                    \"parametro\": {\n"
                + "                        \"id\": 70,\n"
                + "                        \"nome\": \"SolicitarCliente\",\n"
                + "                        \"descricao\": \"Solicita cliente na venda\",\n"
                + "                        \"valor\": null\n"
                + "                    }\n"
                + "                },\n"
                + "                {\n"
                + "                    \"id\": 12293,\n"
                + "                    \"valor\": \"05471416000101\",\n"
                + "                    \"parametro\": {\n"
                + "                        \"id\": 66,\n"
                + "                        \"nome\": \"IdentificadorTef\",\n"
                + "                        \"descricao\": \"Identificador Tef\",\n"
                + "                        \"valor\": null\n"
                + "                    }\n"
                + "                }\n"
                + "            ]\n"
                + "        },\n"
                + "        {\n"
                + "            \"id\": " + TERMINAL_001_ID + ",\n"
                + "            \"nome\": \"" + TERMINAL_001_NOME + "\",\n"
                + "            \"solicitarReferencia\": " + TERMINAL_001_SOLICITAR_REFENCIA + ",\n"
                + "            \"solicitarCliente\": " + TERMINAL_001_SOLICITAR_CLIENTE + ",\n"
                + "            \"solicitarOperador\": " + TERMINAL_001_SOLICITAR_OPERADOR + ",\n"
                + "            \"identificadorTef\": \"" + TERMINAL_001_IDENTIFICADOR_TEF + "\",\n"
                + "            \"rastrearIntervalo\": \"" + TERMINAL_001_RASTREAR_INTERVALO + "\",\n"
                + "            \"permiteVendaParcelada\": " + TERMINAL_001_PERMITE_VENDA_PARCELADA + ",\n"
                + "            \"parcelamentoPadrao\": \"" + TERMINAL_001_PARCELAMENTO_PADRAO + "\",\n"
                + "            \"permiteDesconto\": " + TERMINAL_001_PERMITE_DESCONTO + ",\n"
                + "            \"permiteAcrescimo\": " + TERMINAL_001_PERMITE_ACRESCIMO + ",\n"
                + "            \"aguardaTef\": " + TERMINAL_001_AGUARDAR_TEF + ",\n"
                + "            \"habilitarPDV\": " + TERMINAL_001_HABILITAR_PDV + ",\n"
                + "            \"vendaPorValor\": " + TERMINAL_001_VENDA_POR_VALOR + ",\n"
                + "            \"vendaPorProduto\": " + TERMINAL_001_VENDA_POR_PRODUTO + ",\n"
                + "            \"habilitarPedidos\": " + TERMINAL_001_HABILITAR_PEDIDOS + ",\n"
                + "            \"impressaoAutomatica\": " + TERMINAL_001_IMPRESSAO_AUTOMATICA + ",\n"
                + "            \"imprimirProdutos\": " + TERMINAL_001_IMPRIMIR_PRODUTOS + ",\n"
                + "            \"imprimirCupomLojista\": " + TERMINAL_001_IMPRIMIR_CUPOM_LOJISTA + ",\n"
                + "            \"imprimirCupomCliente\": " + TERMINAL_001_IPMRIMIR_CUPOM_CLIENTE + ",\n"
                + "            \"impressora\": null,\n"
                + "            \"pessoa\": {\n"
                + "                \"id\": " + PessoaTest.PESSOA_ID + ",\n"
                + "                \"nomeRazaoSocial\": \"" + PessoaTest.NOME_RAZAO_SOCIAL + "\",\n"
                + "                \"sobrenomeNomeFantasia\": \"" + PessoaTest.SOBRENOME_NOMEFANTASIA + "\",\n"
                + "                \"pessoaJuridica\": " + PessoaTest.PESSOA_JURIDICA + ",\n"
                + "                \"cpfCnpj\": \"" + PessoaTest.CPF_CNPJ + "\",\n"
                + "                \"cpfCnpjFormat\": \"" + PessoaTest.CPF_CNPJ + "\",\n"
                + "                \"email\": \"" + PessoaTest.E_MAIL + "\",\n"
                + "                \"pessoaStatus\": {\n"
                + "                    \"id\": 2,\n"
                + "                    \"nome\": \"Ativo Vendedor\"\n"
                + "                }\n"
                + "            },\n"
                + "            \"terminalFisico\": {\n"
                + "                \"id\": " + TERMINAL_001_FISICO_ID + ",\n"
                + "                \"nome\": \"" + TERMINAL_001_NOME + "\",\n"
                + "                \"instalacaoId\": \"" + TERMINAL_001_FISICO_INSTALACAO_ID + "\",\n"
                + "                \"pessoa\": {\n"
                + "                    \"id\": " + PessoaTest.PESSOA_ID + ",\n"
                + "                    \"nomeRazaoSocial\": \"" + PessoaTest.NOME_RAZAO_SOCIAL + "\",\n"
                + "                    \"sobrenomeNomeFantasia\": \"" + PessoaTest.SOBRENOME_NOMEFANTASIA + "\",\n"
                + "                    \"cpfCnpj\": \"" + PessoaTest.CPF_CNPJ + "\"\n"
                + "                }\n"
                + "            },\n"
                + "            \"terminalParametros\": [\n"
                + "                {\n"
                + "                    \"id\": 12520,\n"
                + "                    \"valor\": \"true\",\n"
                + "                    \"parametro\": {\n"
                + "                        \"id\": 80,\n"
                + "                        \"nome\": \"permiteVendaParcelada\",\n"
                + "                        \"descricao\": \"Parâmetro para o vendedor configurar se permite ou não venda parcelada\",\n"
                + "                        \"valor\": null\n"
                + "                    }\n"
                + "                },\n"
                + "                {\n"
                + "                    \"id\": 12521,\n"
                + "                    \"valor\": \"loja\",\n"
                + "                    \"parametro\": {\n"
                + "                        \"id\": 41,\n"
                + "                        \"nome\": \"parcelamentopadrao\",\n"
                + "                        \"descricao\": \"Parâmetro para o vendedor configurar forma de Parcelamento padão\",\n"
                + "                        \"valor\": null\n"
                + "                    }\n"
                + "                },\n"
                + "                {\n"
                + "                    \"id\": 12522,\n"
                + "                    \"valor\": \"false\",\n"
                + "                    \"parametro\": {\n"
                + "                        \"id\": 42,\n"
                + "                        \"nome\": \"permiteDesconto\",\n"
                + "                        \"descricao\": \"Parâmetro para o vendedor configurar se permite ou não venda com desconto\",\n"
                + "                        \"valor\": null\n"
                + "                    }\n"
                + "                },\n"
                + "                {\n"
                + "                    \"id\": 12523,\n"
                + "                    \"valor\": \"false\",\n"
                + "                    \"parametro\": {\n"
                + "                        \"id\": 43,\n"
                + "                        \"nome\": \"permiteAcrescimo\",\n"
                + "                        \"descricao\": \"Parâmetro para o vendedor configurar se permite ou não venda com acréscimo\",\n"
                + "                        \"valor\": null\n"
                + "                    }\n"
                + "                },\n"
                + "                {\n"
                + "                    \"id\": 12524,\n"
                + "                    \"valor\": \"true\",\n"
                + "                    \"parametro\": {\n"
                + "                        \"id\": 44,\n"
                + "                        \"nome\": \"AguardaTef\",\n"
                + "                        \"descricao\": \"Parâmetro para o vendedor configurar se o PDV vai aguardar o TEF iniciar a transação\",\n"
                + "                        \"valor\": null\n"
                + "                    }\n"
                + "                },\n"
                + "                {\n"
                + "                    \"id\": 12525,\n"
                + "                    \"valor\": \"true\",\n"
                + "                    \"parametro\": {\n"
                + "                        \"id\": 64,\n"
                + "                        \"nome\": \"VendaPorValor\",\n"
                + "                        \"descricao\": \"Habilita Venda por valor na tela Vender\",\n"
                + "                        \"valor\": null\n"
                + "                    }\n"
                + "                },\n"
                + "                {\n"
                + "                    \"id\": 12526,\n"
                + "                    \"valor\": \"false\",\n"
                + "                    \"parametro\": {\n"
                + "                        \"id\": 78,\n"
                + "                        \"nome\": \"VendaPorProduto\",\n"
                + "                        \"descricao\": \"Habilita Venda por produto na tela Vender\",\n"
                + "                        \"valor\": null\n"
                + "                    }\n"
                + "                },\n"
                + "                {\n"
                + "                    \"id\": 12527,\n"
                + "                    \"valor\": \"false\",\n"
                + "                    \"parametro\": {\n"
                + "                        \"id\": 79,\n"
                + "                        \"nome\": \"HabilitarPedidos\",\n"
                + "                        \"descricao\": \"Habilita pedidos na tela Vender\",\n"
                + "                        \"valor\": null\n"
                + "                    }\n"
                + "                },\n"
                + "                {\n"
                + "                    \"id\": 12528,\n"
                + "                    \"valor\": \"true\",\n"
                + "                    \"parametro\": {\n"
                + "                        \"id\": 63,\n"
                + "                        \"nome\": \"HabilitarPDV\",\n"
                + "                        \"descricao\": \"Habilita PDV na tela vender\",\n"
                + "                        \"valor\": null\n"
                + "                    }\n"
                + "                },\n"
                + "                {\n"
                + "                    \"id\": 12529,\n"
                + "                    \"valor\": \"05471416000101\",\n"
                + "                    \"parametro\": {\n"
                + "                        \"id\": 66,\n"
                + "                        \"nome\": \"IdentificadorTef\",\n"
                + "                        \"descricao\": \"Identificador Tef\",\n"
                + "                        \"valor\": null\n"
                + "                    }\n"
                + "                },\n"
                + "                {\n"
                + "                    \"id\": 12530,\n"
                + "                    \"valor\": \"\",\n"
                + "                    \"parametro\": {\n"
                + "                        \"id\": 67,\n"
                + "                        \"nome\": \"RastrearIntervalo\",\n"
                + "                        \"descricao\": \"Tempo de Rastreamento do terminal\",\n"
                + "                        \"valor\": null\n"
                + "                    }\n"
                + "                },\n"
                + "                {\n"
                + "                    \"id\": 12531,\n"
                + "                    \"valor\": \"false\",\n"
                + "                    \"parametro\": {\n"
                + "                        \"id\": 68,\n"
                + "                        \"nome\": \"SolicitarReferencia\",\n"
                + "                        \"descricao\": \"Solicitar referencia na venda\",\n"
                + "                        \"valor\": null\n"
                + "                    }\n"
                + "                },\n"
                + "                {\n"
                + "                    \"id\": 12532,\n"
                + "                    \"valor\": \"false\",\n"
                + "                    \"parametro\": {\n"
                + "                        \"id\": 81,\n"
                + "                        \"nome\": \"SolicitarOperador\",\n"
                + "                        \"descricao\": \"Solicitar operador na venda\",\n"
                + "                        \"valor\": null\n"
                + "                    }\n"
                + "                },\n"
                + "                {\n"
                + "                    \"id\": 12533,\n"
                + "                    \"valor\": \"false\",\n"
                + "                    \"parametro\": {\n"
                + "                        \"id\": 75,\n"
                + "                        \"nome\": \"imprimirProdutos\",\n"
                + "                        \"descricao\": \"Imprimir lista de produtos de uma Intenção de venda ou Pedido\",\n"
                + "                        \"valor\": null\n"
                + "                    }\n"
                + "                },\n"
                + "                {\n"
                + "                    \"id\": 12534,\n"
                + "                    \"valor\": \"false\",\n"
                + "                    \"parametro\": {\n"
                + "                        \"id\": 76,\n"
                + "                        \"nome\": \"imprimirCupomLojista\",\n"
                + "                        \"descricao\": \"Imprimir cupom via do Lojista\",\n"
                + "                        \"valor\": null\n"
                + "                    }\n"
                + "                },\n"
                + "                {\n"
                + "                    \"id\": 12535,\n"
                + "                    \"valor\": \"false\",\n"
                + "                    \"parametro\": {\n"
                + "                        \"id\": 77,\n"
                + "                        \"nome\": \"imprimirCupomCliente\",\n"
                + "                        \"descricao\": \"Imprimir cupom via do Cliente\",\n"
                + "                        \"valor\": null\n"
                + "                    }\n"
                + "                },\n"
                + "                {\n"
                + "                    \"id\": 12536,\n"
                + "                    \"valor\": \"false\",\n"
                + "                    \"parametro\": {\n"
                + "                        \"id\": 69,\n"
                + "                        \"nome\": \"ImpressaoAutomatica\",\n"
                + "                        \"descricao\": \"ImpressaoAutomatica\",\n"
                + "                        \"valor\": null\n"
                + "                    }\n"
                + "                },\n"
                + "                {\n"
                + "                    \"id\": 12537,\n"
                + "                    \"valor\": \"false\",\n"
                + "                    \"parametro\": {\n"
                + "                        \"id\": 70,\n"
                + "                        \"nome\": \"SolicitarCliente\",\n"
                + "                        \"descricao\": \"Solicita cliente na venda\",\n"
                + "                        \"valor\": null\n"
                + "                    }\n"
                + "                }\n"
                + "            ]\n"
                + "        }\n"
                + "    ]\n"
                + "}";

        Data d = WsHelper.unmarshal(toParse, Data.class);
        assertNotNull(d);
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSSS");
        LocalDateTime localTime = LocalDateTime.from(formater.parse(DATA_HORA_RESPOSTA));
        assertEquals(localTime, d.getData());
        assertNotNull(d.getTerminais());
        assertEquals(2, d.getTerminais().size());

        Terminal t0 = d.getTerminais().get(0);
        assertEquals(TERMINAL_000_ID, t0.getId());
        assertEquals(TERMINAL_000_NOME, t0.getNome());
        assertEquals(TERMINAL_000_SOLICITAR_REFENCIA, t0.isSolicitarReferencia());
        assertEquals(TERMINAL_000_SOLICITAR_CLIENTE, t0.isSolicitarCliente());
        assertEquals(TERMINAL_000_SOLICITAR_OPERADOR, t0.isSolicitarOperador());
        assertEquals(TERMINAL_000_IDENTIFICADOR_TEF, t0.getIdentificadorTef());
        assertEquals(TERMINAL_000_RASTREAR_INTERVALO, t0.getRastrearIntervalo());
        assertEquals(TERMINAL_000_PERMITE_VENDA_PARCELADA, t0.isPermiteVendaParcelada());
        assertEquals(TERMINAL_000_PARCELAMENTO_PADRAO, t0.getParcelamentoPadrao());
        assertEquals(TERMINAL_000_PERMITE_DESCONTO, t0.isPermiteDesconto());
        assertEquals(TERMINAL_000_PERMITE_ACRESCIMO, t0.isPermiteAcrescimo());
        assertEquals(TERMINAL_000_AGUARDAR_TEF, t0.isAguardaTef());
        assertEquals(TERMINAL_000_HABILITAR_PDV, t0.isHabilitarPDV());
        assertEquals(TERMINAL_000_VENDA_POR_VALOR, t0.isVendaPorValor());
        assertEquals(TERMINAL_000_VENDA_POR_PRODUTO, t0.isVendaPorProduto());
        assertEquals(TERMINAL_000_HABILITAR_PEDIDOS, t0.isHabilitarPedidos());
        assertEquals(TERMINAL_000_IMPRESSAO_AUTOMATICA, t0.isImpressaoAutomatica());
        assertEquals(TERMINAL_000_IMPRIMIR_PRODUTOS, t0.isImprimirProdutos());
        assertEquals(TERMINAL_000_IMPRIMIR_CUPOM_LOJISTA, t0.isImprimirCupomLojista());
        assertEquals(TERMINAL_000_IPMRIMIR_CUPOM_CLIENTE, t0.isImprimirCupomCliente());

        assertNull(t0.getImpressora());

        assertNotNull(t0.getPessoa());
        LoginPessoa p = t0.getPessoa();
        assertEquals(Integer.parseInt(PessoaTest.PESSOA_ID), p.getId());
        assertEquals(PessoaTest.NOME_RAZAO_SOCIAL, p.getNomeRazaoSocial());
        assertEquals(PessoaTest.SOBRENOME_NOMEFANTASIA, p.getSobrenomeNomeFantasia());
        assertEquals(PessoaTest.CPF_CNPJ, p.getCpfCnpj());
//        assertEquals(PessoaTest.CPF_CNPJ_FORMATADO, p.getCpfCnpj);

        assertNotNull(t0.getTerminalFisico());

        TerminalFisico tf = t0.getTerminalFisico();
        assertEquals(TERMINAL_000_FISICO_ID, tf.getId());
        assertEquals(TERMINAL_000_FISICO_INSTALACAO_ID, tf.getInstalacaoId());

        assertNotNull(tf.getPessoa());
        LoginPessoa pessoaTf = tf.getPessoa();
        assertEquals(Integer.parseInt(PessoaTest.PESSOA_ID), pessoaTf.getId());
        assertEquals(PessoaTest.NOME_RAZAO_SOCIAL, pessoaTf.getNomeRazaoSocial());
        assertEquals(PessoaTest.SOBRENOME_NOMEFANTASIA, pessoaTf.getSobrenomeNomeFantasia());
        assertEquals(PessoaTest.CPF_CNPJ, pessoaTf.getCpfCnpj());
        
        Terminal t1 = d.getTerminais().get(1);
        assertEquals(TERMINAL_001_ID, t1.getId());
        assertEquals(TERMINAL_001_NOME, t1.getNome());
        assertEquals(TERMINAL_001_SOLICITAR_REFENCIA, t1.isSolicitarReferencia());
        assertEquals(TERMINAL_001_SOLICITAR_CLIENTE, t1.isSolicitarCliente());
        assertEquals(TERMINAL_001_SOLICITAR_OPERADOR, t1.isSolicitarOperador());
        assertEquals(TERMINAL_001_IDENTIFICADOR_TEF, t1.getIdentificadorTef());
        assertEquals(TERMINAL_001_RASTREAR_INTERVALO, t1.getRastrearIntervalo());
        assertEquals(TERMINAL_001_PERMITE_VENDA_PARCELADA, t1.isPermiteVendaParcelada());
        assertEquals(TERMINAL_001_PARCELAMENTO_PADRAO, t1.getParcelamentoPadrao());
        assertEquals(TERMINAL_001_PERMITE_DESCONTO, t1.isPermiteDesconto());
        assertEquals(TERMINAL_001_PERMITE_ACRESCIMO, t1.isPermiteAcrescimo());
        assertEquals(TERMINAL_001_AGUARDAR_TEF, t1.isAguardaTef());
        assertEquals(TERMINAL_001_HABILITAR_PDV, t1.isHabilitarPDV());
        assertEquals(TERMINAL_001_VENDA_POR_VALOR, t1.isVendaPorValor());
        assertEquals(TERMINAL_001_VENDA_POR_PRODUTO, t1.isVendaPorProduto());
        assertEquals(TERMINAL_001_HABILITAR_PEDIDOS, t1.isHabilitarPedidos());
        assertEquals(TERMINAL_001_IMPRESSAO_AUTOMATICA, t1.isImpressaoAutomatica());
        assertEquals(TERMINAL_001_IMPRIMIR_PRODUTOS, t1.isImprimirProdutos());
        assertEquals(TERMINAL_001_IMPRIMIR_CUPOM_LOJISTA, t1.isImprimirCupomLojista());
        assertEquals(TERMINAL_001_IPMRIMIR_CUPOM_CLIENTE, t1.isImprimirCupomCliente());

        assertNull(t1.getImpressora());

        assertNotNull(t1.getPessoa());
        p = t1.getPessoa();
        assertEquals(Integer.parseInt(PessoaTest.PESSOA_ID), p.getId());
        assertEquals(PessoaTest.NOME_RAZAO_SOCIAL, p.getNomeRazaoSocial());
        assertEquals(PessoaTest.SOBRENOME_NOMEFANTASIA, p.getSobrenomeNomeFantasia());
        assertEquals(PessoaTest.CPF_CNPJ, p.getCpfCnpj());
//        assertEquals(PessoaTest.CPF_CNPJ_FORMATADO, p.getCpfCnpj);

        assertNotNull(t1.getTerminalFisico());

        tf = t1.getTerminalFisico();
        assertEquals(TERMINAL_001_FISICO_ID, tf.getId());
        assertEquals(TERMINAL_001_FISICO_INSTALACAO_ID, tf.getInstalacaoId());

        assertNotNull(tf.getPessoa());
        pessoaTf = tf.getPessoa();
        assertEquals(Integer.parseInt(PessoaTest.PESSOA_ID), pessoaTf.getId());
        assertEquals(PessoaTest.NOME_RAZAO_SOCIAL, pessoaTf.getNomeRazaoSocial());
        assertEquals(PessoaTest.SOBRENOME_NOMEFANTASIA, pessoaTf.getSobrenomeNomeFantasia());
        assertEquals(PessoaTest.CPF_CNPJ, pessoaTf.getCpfCnpj());

    }
}

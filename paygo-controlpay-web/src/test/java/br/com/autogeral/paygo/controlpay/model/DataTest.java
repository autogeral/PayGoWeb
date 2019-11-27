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
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Murilo Moraes Tuvani
 */
public class DataTest {

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
    
  /*
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
//        assertEquals(Integer.parseInt(PessoaTest.PESSOA_ID), p.getId());
        assertEquals(PessoaTest.NOME_RAZAO_SOCIAL, p.getNomeRazaoSocial());
        assertEquals(PessoaTest.SOBRENOME_NOMEFANTASIA, p.getSobrenomeNomeFantasia());
        assertEquals(PessoaTest.CPF_CNPJ, p.getCpfCnpj());
        assertEquals(PessoaTest.CPF_CNPJ_FORMATADO, p.getCpfCnpj());

        assertNotNull(t0.getTerminalFisico());

        TerminalFisico tf = t0.getTerminalFisico();
        assertEquals(TERMINAL_000_FISICO_ID, tf.getId());
        assertEquals(TERMINAL_000_FISICO_INSTALACAO_ID, tf.getInstalacaoId());

        assertNotNull(tf.getPessoa());
        LoginPessoa pessoaTf = tf.getPessoa();
//        assertEquals(Integer.parseInt(PessoaTest.PESSOA_ID), pessoaTf.getId());
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
//       assertEquals(Integer.parseInt(PessoaTest.PESSOA_ID), p.getId());
        assertEquals(PessoaTest.NOME_RAZAO_SOCIAL, p.getNomeRazaoSocial());
        assertEquals(PessoaTest.SOBRENOME_NOMEFANTASIA, p.getSobrenomeNomeFantasia());
        assertEquals(PessoaTest.CPF_CNPJ, p.getCpfCnpj());
        assertEquals(PessoaTest.CPF_CNPJ_FORMATADO, p.getCpfCnpj());

        assertNotNull(t1.getTerminalFisico());

        tf = t1.getTerminalFisico();
        assertEquals(TERMINAL_001_FISICO_ID, tf.getId());
        assertEquals(TERMINAL_001_FISICO_INSTALACAO_ID, tf.getInstalacaoId());

        assertNotNull(tf.getPessoa());
        pessoaTf = tf.getPessoa();
//        assertEquals(Integer.parseInt(PessoaTest.PESSOA_ID), pessoaTf.getId());
        assertEquals(PessoaTest.NOME_RAZAO_SOCIAL, pessoaTf.getNomeRazaoSocial());
        assertEquals(PessoaTest.SOBRENOME_NOMEFANTASIA, pessoaTf.getSobrenomeNomeFantasia());
        assertEquals(PessoaTest.CPF_CNPJ, pessoaTf.getCpfCnpj());
    }
    */
//    @Test
    public void test_serializacao() throws ParseException {
        System.out.println("serializacao");
        Data vv = new Data();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSSS");
        NumberFormat decimalFormat = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
        decimalFormat.setMinimumFractionDigits(2);
        decimalFormat.setMaximumFractionDigits(2);
        
//        Date data = sdf.parse("17/11/2016 17:40:37.9417");
////      vv.setData(data);
        IntencaoVenda iv = new IntencaoVenda();
        vv.setIntencaoVenda(iv);
        iv.setId(68240);
        iv.setReferencia("Venda1234");
        iv.setToken("855002");
        
//        data = sdf.parse("30/05/2019 16:51:05.0000");
        LocalDateTime data = LocalDateTime.of(2019, Month.MAY, 30, 16, 51, 5);
      //  iv.setData(data);
        LocalTime hora = LocalTime.of(16, 51, 5);
       // iv.setHora(hora);
        
        double valor = 1d;
        iv.setValorOriginal(valor);
        iv.setValorDescontoFormat(decimalFormat.format(valor));
        
        iv.setValorFinal(valor);
        iv.setValorFinalFormat(decimalFormat.format(valor));

        valor = 0;
        iv.setValorAcrescimo(valor);
        iv.setValorAcrescimoFormat(decimalFormat.format(valor));

        iv.setValorDesconto(valor);
        iv.setValorDescontoFormat(decimalFormat.format(valor));
        
        iv.setQuantidadeParcelas(1);
        FormaPagamento fp = new FormaPagamento();
        fp.setId(22);
//        fp.setNome("TEF");
//        fp.setModalidade("Débito");
        
        FluxoPagamento fxp = new FluxoPagamento();
        fxp.setId(21);
        fxp.setNome("TEF");
//        fp.setFluxoPagamento(fxp);
        iv.setFormaPagamento(fp);
        
        Terminal terminal = new Terminal();
        terminal.setId(868);
        terminal.setNome("Terminal 01");
        iv.setTerminal(terminal);
        
        PagamentoExterno pe = new PagamentoExterno();
        pe.setId(49946);
        pe.setTipo(5);
        pe.setOrigem(5);
        pe.setTipoParcelamento(2);
        PagamentoExternoStatus peStatus = new PagamentoExternoStatus();
        peStatus.setId(10);
        peStatus.setNome("Em Operação");
        pe.setPagamentoExternoStatus(peStatus);
        
        List<PagamentoExterno> pes = new ArrayList<>();
        pes.add(pe);
        iv.setPagamentosExternos(pes);
        
        IntencaoVendaStatus ivs = new IntencaoVendaStatus();
        ivs.setId(6);
        ivs.setNome("Em Pagamento");
        iv.setIntencaoVendaStatus(ivs);
        
        String result = WsHelper.marshal(vv);
        System.out.println(result);
        String expResult = "{}";
        assertEquals(expResult, result);
    }
    
    @Test
    public void test_parse_data_intencao_venda() {
        String PARSE_DATA_INTENCAO_VENDA_DATA_REQUEST = "17/11/2016 17:40:37.9417";
        String PARSE_DATA_INTENCAO_VENDA_ID = "23451";
        String PARSE_DATA_INTENCAO_VENDA_TOKEN = "243564";
        String PARSE_DATA_INTENCAO_VENDA_DATA = "17/11/2016 17:40:21.0000";
        String PARSE_DATA_INTENCAO_VENDA_HORA = "17:40:21";
        String PARSE_DATA_INTENCAO_VENDA_DATA_QUANTIDADE = "1";
        String PARSE_DATA_INTENCAO_VENDA_DATA_VALOR_ORIGINAL = "1";
        String PARSE_DATA_INTENCAO_VENDA_DATA_VALOR_ORIGINAL_FORMAT = "1,00";
        String PARSE_DATA_INTENCAO_VENDA_DATA_VALOR_FINAL = "1";
        String PARSE_DATA_INTENCAO_VENDA_DATA_FORMA_PAGAMENTO_ID = "21";
        String PARSE_DATA_INTENCAO_VENDA_DATA_FORMA_PAGAMENTO_NOME = "TEF";
        String PARSE_DATA_INTENCAO_VENDA_DATA_FORMA_PAGAMENTO_MODALIDADE = "Crédito";
        int PARSE_DATA_INTENCAO_VENDA_DATA_FORMA_PAGAMENTO_FLUXO_ID = 21;
        String PARSE_DATA_INTENCAO_VENDA_DATA_FORMA_PAGAMENTO_FLUXO_NOME = "TEF";
        int PARSE_DATA_INTENCAO_VENDA_PRODUTOS_ITEM_PRODUTO_ID = 13626;
        int PARSE_DATA_INTENCAO_VENDA_PRODUTOS_ID = 2;
        String PARSE_DATA_INTENCAO_VENDA_PRODUTOS_NOME = "Refeição";
        String PARSE_DATA_INTENCAO_VENDA_PRODUTOS_QUANTIDADE = "1";
        String PARSE_DATA_INTENCAO_VENDA_PRODUTOS_VALOR = "1,00";
        
        String response = "{\n"
                + "  \"data\": \"" + PARSE_DATA_INTENCAO_VENDA_DATA_REQUEST + "\",\n"
                + "  \"intencaoVenda\": {\n"
                + "    \"id\": " + PARSE_DATA_INTENCAO_VENDA_ID + ",\n"
                + "    \"token\": \"" + PARSE_DATA_INTENCAO_VENDA_TOKEN + "\",\n"
                + "    \"data\": \"" + PARSE_DATA_INTENCAO_VENDA_DATA + "\",\n"
                + "    \"hora\": \"" + PARSE_DATA_INTENCAO_VENDA_HORA + "\",\n"
                + "    \"quantidade\": " + PARSE_DATA_INTENCAO_VENDA_DATA_QUANTIDADE + ",\n"
                + "    \"valorOriginal\": " + PARSE_DATA_INTENCAO_VENDA_DATA_VALOR_ORIGINAL + ",\n"
                + "    \"valorOriginalFormat\": \"" + PARSE_DATA_INTENCAO_VENDA_DATA_VALOR_ORIGINAL_FORMAT + "\",\n"
                + "    \"valorAcrescimo\": 0,\n"
                + "    \"valorAcrescimoFormat\": \"0,00\",\n"
                + "    \"valorDesconto\": 0,\n"
                + "    \"valorDescontoFormat\": \"0,00\",\n"
                + "    \"valorFinal\": " + PARSE_DATA_INTENCAO_VENDA_DATA_VALOR_FINAL + ",\n"
                + "    \"valorFinalFormat\": \"1,00\",\n"
                + "    \"gate2allToken\": null,\n"
                + "    \"quantidadeParcelas\": 1,\n"
                + "    \"urlPagamento\": null,\n"
                + "    \"formaPagamento\": {\n"
                + "      \"id\": " + PARSE_DATA_INTENCAO_VENDA_DATA_FORMA_PAGAMENTO_ID + ",\n"
                + "      \"nome\": \"" + PARSE_DATA_INTENCAO_VENDA_DATA_FORMA_PAGAMENTO_NOME + "\",\n"
                + "      \"modalidade\": \"" + PARSE_DATA_INTENCAO_VENDA_DATA_FORMA_PAGAMENTO_MODALIDADE + "\",\n"
                + "      \"fluxoPagamento\": {\n"
                + "        \"id\": " + PARSE_DATA_INTENCAO_VENDA_DATA_FORMA_PAGAMENTO_FLUXO_ID + ",\n"
                + "        \"nome\": \"" + PARSE_DATA_INTENCAO_VENDA_DATA_FORMA_PAGAMENTO_FLUXO_NOME + "\"\n"
                + "      }\n"
                + "    },\n"
                + "    \"terminal\": {\n"
                + "      \"id\": 81,\n"
                + "      \"nome\": \"CAIXA 01\"\n"
                + "    },\n"
                + "    \"pagamentosExterno\": [\n"
                + "      {\n"
                + "        \"id\": 1571,\n"
                + "        \"tipo\": 5,\n"
                + "        \"origem\": 5,\n"
                + "        \"tipoParcelamento\": 2,\n"
                + "        \"pagamentoExternoStatus\": {\n"
                + "          \"id\": 15,\n"
                + "          \"nome\": \"Finalizado\"\n"
                + "        }\n"
                + "      }\n"
                + "    ],\n"
                + "    \"intencaoVendaStatus\": {\n"
                + "      \"id\": 15,\n"
                + "      \"nome\": \"Expirado\"\n"
                + "    },\n"
                + "    \"cliente\": null,\n"
                + "    \"produtos\": [\n"
                + "      {\n"
                + "        \"itemProdutoId\": " + PARSE_DATA_INTENCAO_VENDA_PRODUTOS_ITEM_PRODUTO_ID + ",\n"
                + "        \"id\": " + PARSE_DATA_INTENCAO_VENDA_PRODUTOS_ID + ",\n"
                + "        \"nome\": \"" + PARSE_DATA_INTENCAO_VENDA_PRODUTOS_NOME + "\",\n"
                + "        \"quantidade\": " + PARSE_DATA_INTENCAO_VENDA_PRODUTOS_QUANTIDADE + ",\n"
                + "        \"valor\": \"" + PARSE_DATA_INTENCAO_VENDA_PRODUTOS_VALOR + "\"\n"
                + "      }\n"
                + "    ],\n"
                + "    \"pedido\": null\n"
                + "  }\n"
                + "}";
        
        Data vv = WsHelper.unmarshal(response, Data.class);
        LocalDateTime dataRequiscao = vv.getData();
        assertNotNull(vv.getIntencaoVenda());
        
        assertNotNull(vv.getIntencaoVenda().getFormaPagamento());
//        assertEquals(PARSE_DATA_INTENCAO_VENDA_DATA_FORMA_PAGAMENTO_NOME, vv.getIntencaoVenda().getFormaPagamento().getNome());
//        assertEquals(PARSE_DATA_INTENCAO_VENDA_DATA_FORMA_PAGAMENTO_MODALIDADE, vv.getIntencaoVenda().getFormaPagamento().getModalidade());
        
//        assertNotNull(vv.getIntencaoVenda().getFormaPagamento().getFluxoPagamento());
//        assertEquals(PARSE_DATA_INTENCAO_VENDA_DATA_FORMA_PAGAMENTO_FLUXO_ID, vv.getIntencaoVenda().getFormaPagamento().getFluxoPagamento().getId());
//        assertEquals(PARSE_DATA_INTENCAO_VENDA_DATA_FORMA_PAGAMENTO_FLUXO_NOME, vv.getIntencaoVenda().getFormaPagamento().getFluxoPagamento().getNome());
        
        assertNotNull(vv.getIntencaoVenda().getProdutos());
        assertTrue(vv.getIntencaoVenda().getProdutos().size() == 1);
//        assertEquals(PARSE_DATA_INTENCAO_VENDA_PRODUTOS_ITEM_PRODUTO_ID, vv.getIntencaoVenda().getProdutos().get(0).getProdutoItemId());
        ProdutoVenda vp = vv.getIntencaoVenda().getProdutos().get(0);
        assertEquals(PARSE_DATA_INTENCAO_VENDA_PRODUTOS_ID, vp.getId());
        assertEquals(PARSE_DATA_INTENCAO_VENDA_PRODUTOS_NOME, vp.getNome());
        assertEquals(PARSE_DATA_INTENCAO_VENDA_PRODUTOS_QUANTIDADE, vp.getQuantidade());
        assertEquals(PARSE_DATA_INTENCAO_VENDA_PRODUTOS_VALOR, vp.getValor());
    }
    
    @Test
    public void test_intencoesVendasParse() {
        String response = "{\"data\":\"30/06/2019 16:14:05.0688\",\"intencoesVendas\":[{\"id\":68926,\"referencia\":\"\",\"token\":\"978605\",\"data\":\"13/06/2019 23:01\",\"hora\":\"23:01:58\",\"dataAtualizacao\":\"13/06/2019 23:02\",\"valorOriginal\":40.0000,\"valorOriginalFormat\":\"40,00\",\"valorAcrescimo\":0.0000,\"valorAcrescimoFormat\":\"0,00\",\"valorDesconto\":0.0000,\"valorDescontoFormat\":\"0,00\",\"valorFinal\":40.0000,\"valorFinalFormat\":\"40,00\",\"quantidade\":0,\"urlPagamento\":null,\"latitude\":\"0\",\"longitude\":\"0\",\"quantidadeParcelas\":2,\"formaPagamento\":{\"id\":21,\"nome\":\"TEF\",\"modalidade\":\"Crédito\",\"fluxoPagamento\":{\"id\":21,\"nome\":\"TEF\"}},\"terminal\":{\"id\":868,\"nome\":\"Terminal 01\"},\"intencaoVendaStatus\":{\"id\":10,\"nome\":\"Creditado\"},\"cliente\":null,\"pedido\":null,\"vendedor\":{\"id\":8149,\"nomeRazaoSocial\":\"AUTO GERAL AUTOPECAS LTDA\",\"sobrenomeNomeFantasia\":\"AUTO GERAL AUTOPECAS LTDA\",\"fotoThumbnail\":\"https://pay2alldemo.azurewebsites.net/WebAPI/ImagensPessoas/_PessoaDefault.png\",\"parceiro\":null},\"pagamentosExternos\":[{\"id\":50715,\"tipo\":5,\"origem\":10,\"nsuTid\":\"10941\",\"trnNsu\":\"966658\",\"autorizacao\":\"094787\",\"adquirente\":\"REDE\",\"bandeira\":\"VISA\",\"codigoRespostaAdquirente\":\"00\",\"codigoRespostaExecTransac\":\"0\",\"mensagemRespostaAdquirente\":\"TRANSACAO AUTORIZADA\",\"idConfirmacao\":\"\",\"dataAdquirente\":\"13/06/2019 23:02\",\"dataAtualizacao\":\"14/06/2019 02:02\",\"respostaAdquirente\":\"PWINFO_DATETIME = 20190613230251\\r\\nPWINFO_AUTLOCREF = 10941\\r\\nPWINFO_OPERATION = 33\\r\\nPWINFO_CURRENCY = 986\\r\\nPWINFO_TOTAMNT = 4000\\r\\nPWINFO_AUTRESPCODE = 00\\r\\nPWINFO_RESULTMSG = TRANSACAO AUTORIZADA\\r\\nPWINFO_AUTHSYST = REDE\\r\\nPWINFO_AUTHCODE = 094787\\r\\nPWINFO_CARDNAME = VISA        \\r\\nPWINFO_FINTYPE = 4\\r\\nPWINFO_CNFREQ = 1\\r\\nPWINFO_INSTALLMENTS = 2\\r\\nPWINFO_CARDTYPE = 1\\r\\nPWINFO_CPEXECTRANSACRESP = 0\\r\\nPWINFO_SERVERPND = 0\\r\\nPWINFO_TRNNSU = 966658\\r\\nPWINFO_RCPTMERCH = \\r             PAYGO BY NTK             \\r\\n         Via Estabelecimento          \\r\\n              REDE       \\r\\n\\r\\nBAR DA MARIA  \\r\\n50.713.076/0001-32              \\r\\n\\r\\nCOMPR:000010941  VALOR 000000004000\\r\\n\\r\\nESTAB:          13/06/2019-110252 \\r\\nTERM:00003097\\r\\nCARTAO: ************8592            \\r\\nAUTORIZACAO: 094787\\r\\n\\r\\nTRANSACAO AUTORIZADA MEDIANTE  \\r\\n   USO DE SENHA PESSOAL        \\r\\n\\r\\n\\r\\n--------------------------------------\\r\\n60905 0000000001 PGREF:0000966658\\r\\nNOME FANTASIA: AUTO GERAL AUTOPECAS\\rLTDA\\r\\nCNPJ: 05.437.537/0001-37\\r\\n\\r   *** AMBIENTE DE TESTES - APP02 ***   \\r\\n\\r\\n\\r\\nPWINFO_RCPTCHOLDER = \\r             PAYGO BY NTK             \\r\\n             Via Cliente              \\r\\n              REDE       \\r\\n\\r\\nBAR DA MARIA  \\r\\n50.713.076/0001-32              \\r\\n\\r\\nCOMPR:000010941  VALOR 000000004000\\r\\n\\r\\nESTAB:          13/06/2019-110252 \\r\\nTERM:00003097\\r\\nCARTAO: ************8592            \\r\\nAUTORIZACAO: 094787\\r\\n\\r\\nTRANSACAO AUTORIZADA MEDIANTE  \\r\\n   USO DE SENHA PESSOAL        \\r\\n\\r\\n\\r\\n--------------------------------------\\r\\n60905 0000000001 PGREF:0000966658\\r\\nNOME FANTASIA: AUTO GERAL AUTOPECAS\\rLTDA\\r\\nCNPJ: 05.437.537/0001-37\\r\\n\\r   *** AMBIENTE DE TESTES - APP02 ***   \\r\\n\\r\\n\\r\\nPWINFO_RCPTCHSHORT = \\r\\nPWINFO_RCPTFULL = \\r             PAYGO BY NTK             \\r\\n             Via Completa             \\r\\n              REDE       \\r\\n\\r\\nBAR DA MARIA  \\r\\n50.713.076/0001-32              \\r\\n\\r\\nCOMPR:000010941  VALOR 000000004000\\r\\n\\r\\nESTAB:          13/06/2019-110252 \\r\\nTERM:00003097\\r\\nCARTAO: ************8592            \\r\\nAUTORIZACAO: 094787\\r\\n\\r\\nTRANSACAO AUTORIZADA MEDIANTE  \\r\\n   USO DE SENHA PESSOAL        \\r\\n\\r\\n\\r\\n--------------------------------------\\r\\n60905 0000000001 PGREF:0000966658\\r\\nNOME FANTASIA: AUTO GERAL AUTOPECAS\\rLTDA\\r\\nCNPJ: 05.437.537/0001-37\\r\\n\\r   *** AMBIENTE DE TESTES - APP02 ***   \\r\\n\\r\\n\\r\\nPWINFO_CARDNAMESTD =\",\"comprovanteAdquirente\":\"PAYGO BY NTK              \\r\\n             Via Completa              \\r\\n              REDE        \\r\\nBAR DA MARIA   \\r\\n50.713.076/0001-32               \\r\\nCOMPR:000010941  VALOR 000000004000 \\r\\nESTAB:          13/06/2019-110252  \\r\\nTERM:00003097 \\r\\nCARTAO: ************8592             \\r\\nAUTORIZACAO: 094787 \\r\\nTRANSACAO AUTORIZADA MEDIANTE   \\r\\n   USO DE SENHA PESSOAL         \\r\\n-------------------------------------- \\r\\n60905 0000000001 PGREF:0000966658 \\r\\nNOME FANTASIA: AUTO GERAL AUTOPECAS \\r\\nLTDA \\r\\nCNPJ: 05.437.537/0001-37 \\r\\n   *** AMBIENTE DE TESTES - APP02 ***\",\"tipoParcelamento\":2,\"orderLIO\":null,\"pagamentoExternoStatus\":{\"id\":15,\"nome\":\"Finalizado\"}}],\"operador\":null}],\"draw\":\"\",\"recordsTotal\":null,\"recordsFiltered\":null}";
        Data vv = WsHelper.unmarshal(response, Data.class);
        assertNotNull(vv.getData());
        assertNotNull(vv.getIntencoesVendas());

        if (vv.getIntencoesVendas() != null) {
            System.out.println("Intencoes de vendas : " + vv.getIntencoesVendas().size());
        }
        
    }
    
    
    
}

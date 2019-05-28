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
package br.com.autogeral.paygo.controlpay.web;

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
public class ControlPayConfigTest {
    
    public ControlPayConfigTest() {
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

    /**
     * Test of getConfig method, of class ControlPayConfig.
     */
    @Test
    public void testGetConfig() {
        System.out.println("getConfig");
        ControlPayConfig result = ControlPayConfig.getConfig();
        assertNotNull(result);
    }

    /**
     * Test of getKey method, of class ControlPayConfig.
     */
    @Test
    public void testGetKey() {
        System.out.println("getKey");
        ControlPayConfig instance = ControlPayConfig.getConfig();
        assertNotNull(instance);
        String result = instance.getKey();
        assertNotNull(result);
    }

    /**
     * Test of getServidor method, of class ControlPayConfig.
     */
    @Test
    public void testGetServidor() {
        System.out.println("getServidor");
        ControlPayConfig instance = ControlPayConfig.getConfig();
        assertNotNull(instance);
        String result = instance.getServidor();
        assertNotNull(result);
        assertTrue(result.contains("azurewebsites.net"));
    }

    /**
     * Test of getTerminal method, of class ControlPayConfig.
     */
    @Test
    public void testGetTerminal() {
        System.out.println("getTerminal");
        ControlPayConfig instance = ControlPayConfig.getConfig();
        assertNotNull(instance);
        String result = instance.getTerminal();
        assertNotNull(result);
        assertTrue(result.length() == 3);
    }
    
}

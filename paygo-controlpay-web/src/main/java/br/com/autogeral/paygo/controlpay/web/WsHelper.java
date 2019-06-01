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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.httpclient.HttpMethod;

/**
 * 27/05/2019 22:26:21
 * @author Murilo Moraes Tuvani
 */
public class WsHelper {

    private static Gson gson = null;
    
    public static ByteArrayOutputStream getResponseBody(HttpMethod method) throws IOException {
        InputStream input = method.getResponseBodyAsStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        BufferedInputStream bis = new BufferedInputStream(input);
        int aByte;
        while ((aByte = bis.read()) != -1) {
            baos.write(aByte);
        }
        baos.flush();
        baos.close();
        bis.close();
        return baos;
    }
    
    public static String marshal(Object object) {
        String json = getGson().toJson(object);
        return json;
    }
    
    public static <T> T unmarshal(String json, Class<T> aClass) {
        T object = getGson().fromJson(json, aClass);
        return object;
    }

    public static Gson getGson() {
        if (gson == null) {
            gson = new GsonBuilder()
                    .serializeNulls()
                    .setDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
                    .create();
        }
        return gson;
    }

}

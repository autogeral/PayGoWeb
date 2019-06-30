/*
 * The MIT License
 *
 * Copyright 2019 murilotuvani.
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

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

/**
 * 30/06/2019 16:23:22
 * @author murilotuvani
 */
public class IntencaoVendaAdapter  implements JsonDeserializer<IntencaoVenda> {
        //, JsonSerializer<IntencaoVenda> {

    @Override
    public IntencaoVenda deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        IntencaoVenda iv = new IntencaoVenda();
        JsonObject ivo = json.getAsJsonObject();
        if (!ivo.isJsonNull()) {
            iv.setId(ivo.get("id").isJsonNull() ? 0 : ivo.get("id").getAsInt());
        }
        return iv;
    }

}

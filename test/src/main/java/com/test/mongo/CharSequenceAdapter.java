package com.test.mongo;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class CharSequenceAdapter implements JsonSerializer<CharSequence>, JsonDeserializer<CharSequence> {

    public CharSequence deserialize(JsonElement jsonElem, Type typeOfT, JsonDeserializationContext context)
        throws JsonParseException {
        return jsonElem.getAsString();
    }

    public JsonElement serialize(CharSequence jsonElem, Type typeOfSrc, JsonSerializationContext context) {
        return context.serialize(jsonElem.toString());
    }
}
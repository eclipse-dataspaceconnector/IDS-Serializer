package de.fraunhofer.iais.eis.ids.jsonld;


import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;


public class JsonLDSerializerModifier extends BeanSerializerModifier {

    private Usage usage;

    public JsonLDSerializerModifier(Usage usage) {
        this.usage = usage;
    }

    @Override
    public JsonSerializer<?> modifySerializer(SerializationConfig config, BeanDescription beanDesc, JsonSerializer<?> serializer) {
        if(serializer instanceof  BeanSerializerBase) {
            return new JsonLDSerializer((BeanSerializerBase) serializer, usage);
        } else {
            return serializer;
        }
    }
}

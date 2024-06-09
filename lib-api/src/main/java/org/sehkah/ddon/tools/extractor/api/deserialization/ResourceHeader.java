package org.sehkah.ddon.tools.extractor.api.deserialization;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ResourceHeader {
    DDONPrimitiveDataType magicStringSize();

    DDONPrimitiveDataType magicNumberSize();
}

package org.sehkah.doon.tools.extractor.lib.logic.serialization;

import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;

public class MetaInformationIntrospector extends JacksonAnnotationIntrospector {
    public final boolean shouldSerializeMetaInformation;

    public MetaInformationIntrospector(boolean shouldSerializeMetaInformation) {
        this.shouldSerializeMetaInformation = shouldSerializeMetaInformation;
    }

    @Override
    public boolean hasIgnoreMarker(AnnotatedMember m) {
        return m.getAnnotation(MetaInformation.class) != null && !shouldSerializeMetaInformation;
    }
}

package org.sehkah.ddon.tools.extractor.lib.logic.serialization;

import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;

public class MetaInformationIntrospector extends JacksonAnnotationIntrospector {
    @Override
    public boolean hasIgnoreMarker(AnnotatedMember m) {
        return m.getAnnotation(MetaInformation.class) != null;
    }
}

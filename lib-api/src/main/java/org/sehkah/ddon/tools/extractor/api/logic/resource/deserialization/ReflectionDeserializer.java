package org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization;

import lombok.SneakyThrows;
import org.sehkah.ddon.tools.extractor.api.deserialization.ArrayDataType;
import org.sehkah.ddon.tools.extractor.api.deserialization.DataType;
import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.entity.Resource;
import org.sehkah.ddon.tools.extractor.api.error.FileParsingIncompleteException;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.nio.file.Path;

/**
 * TODO Experimental deserializer which should reduce boilerplate at the cost of performance, tested successfully with QMI
 */
public class ReflectionDeserializer<T extends Resource> implements ClientResourceDeserializer<T> {
    private final Class<T> resourceClass;

    public ReflectionDeserializer(Class<T> resourceClass) {
        this.resourceClass = resourceClass;
    }

    @SneakyThrows
    private static <T> T parseEntity(Class<T> clazz, BufferReader bufferReader) {
        T entity = clazz.getConstructor().newInstance();
//        for (Annotation declaredAnnotation : clazz.getDeclaredAnnotations()) {
//            if (declaredAnnotation instanceof ResourceHeader resourceHeader) {
//                switch(resourceHeader.magicNumberSize()) {
//                    case u16 -> bufferReader.readUnsignedShort();
//                    case u32 -> bufferReader.readUnsignedInteger();
//                }
//            }
//        }
        for (Field field : clazz.getDeclaredFields()) {
            for (Annotation declaredAnnotation : field.getDeclaredAnnotations()) {
                if (declaredAnnotation instanceof DataType dataType) {
                    switch (dataType.size()) {
                        case u8 -> {
                            var value = bufferReader.readUnsignedByte();
                            field.set(entity, value);
                        }
                        case u16 -> {
                            var value = bufferReader.readUnsignedShort();
                            field.set(entity, value);
                        }
                        case u32 -> {
                            var value = bufferReader.readUnsignedInteger();
                            field.set(entity, value);
                        }
                        case u64 -> {
                            var value = bufferReader.readUnsignedLong();
                            field.set(entity, value);
                        }
                        case s8 -> {
                            var value = bufferReader.readSignedByte();
                            field.set(entity, value);
                        }
                        case s16 -> {
                            var value = bufferReader.readSignedShort();
                            field.set(entity, value);
                        }
                        case s32 -> {
                            var value = bufferReader.readSignedInteger();
                            field.set(entity, value);
                        }
                        case f32 -> {
                            var value = bufferReader.readFloat();
                            field.set(entity, value);
                        }
                        case bool -> {
                            var value = bufferReader.readBoolean();
                            field.set(entity, value);
                        }
                        case vector3f -> {
                            var value = bufferReader.readVector3f();
                            field.set(entity, value);
                        }
                    }
                }
                if (declaredAnnotation instanceof ArrayDataType resourceArrayDataType) {
                    switch (resourceArrayDataType.size()) {
                        case u16 ->
                                bufferReader.readArray(BufferReader::readUnsignedShort, b -> parseEntity((Class<T>) ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0], b));
                        case u32 ->
                                bufferReader.readArray(BufferReader::readUnsignedInteger, b -> parseEntity((Class<T>) ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0], b));
                    }
                }
            }
        }
        return entity;
    }

    @Override
    public T deserialize(Path filePath, ClientResourceFile<T> clientResourceFile, BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        FileHeader fileHeader = FileHeaderDeserializer.parseClientResourceFile(bufferReader, clientResourceFile.getFileHeader());
        T result = parseEntity(resourceClass, bufferReader);
        if (bufferReader.hasRemaining()) {
            throw new FileParsingIncompleteException(filePath, fileHeader, bufferReader.getRemainingCount(), bufferReader.getLimit());
        }
        result.setFileSize(bufferReader.getLimit());
        result.setFileHeader(fileHeader);
        return result;
    }
}

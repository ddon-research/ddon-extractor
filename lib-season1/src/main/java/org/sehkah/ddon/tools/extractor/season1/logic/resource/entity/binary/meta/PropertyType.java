package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.binary.meta;

import java.util.Arrays;

public enum PropertyType {
    TYPE_UNDEFINED(0x0),
    TYPE_CLASS(0x1),
    TYPE_CLASSREF(0x2),
    TYPE_BOOL(0x3),
    TYPE_U8(0x4),
    TYPE_U16(0x5),
    TYPE_U32(0x6),
    TYPE_U64(0x7),
    TYPE_S8(0x8),
    TYPE_S16(0x9),
    TYPE_S32(0xA),
    TYPE_S64(0xB),
    TYPE_F32(0xC),
    TYPE_F64(0xD),
    TYPE_STRING(0xE),
    TYPE_COLOR(0xF),
    TYPE_POINT(0x10),
    TYPE_SIZE(0x11),
    TYPE_RECT(0x12),
    TYPE_MATRIX(0x13),
    TYPE_VECTOR3(0x14),
    TYPE_VECTOR4(0x15),
    TYPE_QUATERNION(0x16),
    TYPE_PROPERTY(0x17),
    TYPE_EVENT(0x18),
    TYPE_GROUP(0x19),
    TYPE_PAGE_BEGIN(0x1A),
    TYPE_PAGE_END(0x1B),
    TYPE_EVENT32(0x1C),
    TYPE_ARRAY(0x1D),
    TYPE_PROPERTYLIST(0x1E),
    TYPE_GROUP_END(0x1F),
    TYPE_CSTRING(0x20),
    TYPE_TIME(0x21),
    TYPE_FLOAT2(0x22),
    TYPE_FLOAT3(0x23),
    TYPE_FLOAT4(0x24),
    TYPE_FLOAT3x3(0x25),
    TYPE_FLOAT4x3(0x26),
    TYPE_FLOAT4x4(0x27),
    TYPE_EASECURVE(0x28),
    TYPE_LINE(0x29),
    TYPE_LINESEGMENT(0x2A),
    TYPE_RAY(0x2B),
    TYPE_PLANE(0x2C),
    TYPE_SPHERE(0x2D),
    TYPE_CAPSULE(0x2E),
    TYPE_AABB(0x2F),
    TYPE_OBB(0x30),
    TYPE_CYLINDER(0x31),
    TYPE_TRIANGLE(0x32),
    TYPE_CONE(0x33),
    TYPE_TORUS(0x34),
    TYPE_ELLIPSOID(0x35),
    TYPE_RANGE(0x36),
    TYPE_RANGEF(0x37),
    TYPE_RANGEU16(0x38),
    TYPE_HERMITECURVE(0x39),
    TYPE_ENUMLIST(0x3A),
    TYPE_FLOAT3x4(0x3B),
    TYPE_LINESEGMENT4(0x3C),
    TYPE_AABB4(0x3D),
    TYPE_OSCILLATOR(0x3E),
    TYPE_VARIABLE(0x3F),
    TYPE_VECTOR2(0x40),
    TYPE_MATRIX33(0x41),
    TYPE_RECT3D_XZ(0x42),
    TYPE_RECT3D(0x43),
    TYPE_RECT3D_COLLISION(0x44),
    TYPE_PLANE_XZ(0x45),
    TYPE_RAY_Y(0x46),
    TYPE_POINTF(0x47),
    TYPE_SIZEF(0x48),
    TYPE_RECTF(0x49),
    TYPE_EVENT64(0x4A),
    TYPE_ENUM_RESOURCE_QUALITY(0x106),
    TYPE_CUSTOM(0x80);

    public final long value;

    PropertyType(long value) {
        this.value = value;
    }

    public static PropertyType of(long value) {
        return Arrays.stream(PropertyType.values()).filter(eventParamEventFlag -> eventParamEventFlag.value == value).findFirst().orElse(null);
    }
}
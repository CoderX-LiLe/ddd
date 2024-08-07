package com.freetime.ddd.orm.repository.dto;

import com.baomidou.mybatisplus.core.toolkit.support.SFunction;

public class UpdateField<T> {

    private final SFunction<T, ?> fieldAccessor;
    private final Object value;

    public UpdateField(SFunction<T, ?> fieldAccessor, Object value) {
        this.fieldAccessor = fieldAccessor;
        this.value = value;
    }

    public SFunction<T, ?> getFieldAccessor() {
        return fieldAccessor;
    }

    public Object getValue() {
        return value;
    }
}

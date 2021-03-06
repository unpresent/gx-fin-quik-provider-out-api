package ru.gx.fin.gate.quik.provider.internal;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.gx.core.data.AbstractDataPackage;

public abstract class QuikStandardDataPackage<T extends QuikStandardDataObject> extends AbstractDataPackage<T> {
    /**
     * Общее количество записей в Quik-е
     */
    @SuppressWarnings("unused")
    @JsonProperty
    public long allCount;

    @SuppressWarnings("unused")
    public T getObject(int index) {
        return super.get(index);
    }

    public QuikStandardDataPackage() {
        super();
    }
}

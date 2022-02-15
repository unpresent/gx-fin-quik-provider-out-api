package ru.gx.fin.gate.quik.provider.keyextractors;

import org.jetbrains.annotations.NotNull;
import ru.gx.core.data.DataObjectKeyExtractor;
import ru.gx.fin.gate.quik.provider.out.QuikOrder;

@SuppressWarnings("unused")
public class QuikOrderKeyExtractor implements DataObjectKeyExtractor<QuikOrder> {
    @Override
    public Object extractKey(@NotNull QuikOrder dataObject) {
        return dataObject.getId();
    }
}

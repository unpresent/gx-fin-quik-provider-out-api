package ru.gx.fin.gate.quik.provider.keyextractors;

import org.jetbrains.annotations.NotNull;
import ru.gx.core.data.DataObjectKeyExtractor;
import ru.gx.fin.gate.quik.provider.out.QuikAllTrade;

@SuppressWarnings("unused")
public class QuikAllTradeKeyExtractor implements DataObjectKeyExtractor<QuikAllTrade> {
    @Override
    public Object extractKey(@NotNull QuikAllTrade dataObject) {
        return dataObject.getId();
    }
}

package ru.gx.fin.gate.quik.provider.keyextractors;

import org.jetbrains.annotations.NotNull;
import ru.gx.core.data.DataObjectKeyExtractor;
import ru.gx.fin.gate.quik.provider.out.QuikDeal;
import ru.gx.fin.gate.quik.provider.out.QuikOrder;

@SuppressWarnings("unused")
public class QuikDealKeyExtractor implements DataObjectKeyExtractor<QuikDeal> {
    @Override
    public Object extractKey(@NotNull QuikDeal dataObject) {
        return dataObject.getId();
    }
}

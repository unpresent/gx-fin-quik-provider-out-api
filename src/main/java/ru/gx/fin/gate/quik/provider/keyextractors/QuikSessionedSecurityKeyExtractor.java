package ru.gx.fin.gate.quik.provider.keyextractors;

import org.jetbrains.annotations.NotNull;
import ru.gx.core.data.DataObjectKeyExtractor;
import ru.gx.fin.gate.quik.provider.out.QuikDeal;
import ru.gx.fin.gate.quik.provider.out.QuikSessionedSecurity;

@SuppressWarnings("unused")
public class QuikSessionedSecurityKeyExtractor implements DataObjectKeyExtractor<QuikSessionedSecurity> {
    @Override
    public Object extractKey(@NotNull QuikSessionedSecurity dataObject) {
        return dataObject.getId();
    }
}

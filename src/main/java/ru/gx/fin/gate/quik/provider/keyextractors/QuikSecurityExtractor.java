package ru.gx.fin.gate.quik.provider.keyextractors;

import org.jetbrains.annotations.NotNull;
import ru.gx.core.data.DataObjectKeyExtractor;
import ru.gx.fin.gate.quik.provider.out.QuikSecurity;

@SuppressWarnings("unused")
public class QuikSecurityExtractor implements DataObjectKeyExtractor<QuikSecurity> {
    @Override
    public Object extractKey(@NotNull QuikSecurity dataObject) {
        return dataObject.getId();
    }
}

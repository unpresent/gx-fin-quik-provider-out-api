package ru.gx.fin.gate.quik.provider.memdata;

import org.jetbrains.annotations.NotNull;
import ru.gx.core.data.AbstractMemoryRepository;
import ru.gx.fin.gate.quik.provider.out.QuikSecuritiesPackage;
import ru.gx.fin.gate.quik.provider.out.QuikSecurity;

public class QuikSecuritiesMemoryRepository extends AbstractMemoryRepository<QuikSecurity, QuikSecuritiesPackage> {
    @Override
    @NotNull
    public Object extractKey(@NotNull final QuikSecurity quikSecurity) {
        return quikSecurity.getId();
    }

    public static class IdResolver extends AbstractIdResolver<QuikSecuritiesMemoryRepository> {
    }
}

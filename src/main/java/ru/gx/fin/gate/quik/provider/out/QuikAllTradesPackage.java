package ru.gx.fin.gate.quik.provider.out;

import lombok.ToString;
import ru.gx.fin.gate.quik.provider.internal.QuikStandardDataPackage;

@ToString(callSuper = true)
public class QuikAllTradesPackage extends QuikStandardDataPackage<QuikAllTrade> {
    @SuppressWarnings("unused")
    public QuikAllTradesPackage() {
        super();
    }
}


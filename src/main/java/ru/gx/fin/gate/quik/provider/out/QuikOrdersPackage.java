package ru.gx.fin.gate.quik.provider.out;

import lombok.ToString;
import ru.gx.fin.gate.quik.provider.internal.QuikStandardDataPackage;

@SuppressWarnings("unused")
@ToString(callSuper = true)
public class QuikOrdersPackage extends QuikStandardDataPackage<QuikOrder> {
    public QuikOrdersPackage() {
        super();
    }
}

package ru.gx.fin.gate.quik.provider.internal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.gx.core.data.AbstractDataObject;
import ru.gx.core.utils.StringUtils;

@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString
public abstract class QuikStandardDataObject extends AbstractDataObject {
    /**
     * Номер записи по порядку
     */
    @JsonProperty
    private final int rowIndex;

    protected QuikStandardDataObject(int rowIndex) {
        super();
        this.rowIndex = rowIndex;
    }

    @NotNull
    public static String extractExchangeCode(@Nullable final String sourceExchangeCode, @NotNull final String sourceClassCode) {
        // Определяем код площадки
        var result = sourceExchangeCode;
        if (result == null || StringUtils.isNull(result, "").equals("")) {
            final var clsCode3 = sourceClassCode.substring(0, Math.min(sourceClassCode.length(), 3));
            result = clsCode3.equals("SPB") ? "SPB" : "MICEX";
        }
        return result;
    }
}

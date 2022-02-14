package ru.gx.fin.gate.quik.provider.out;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.gx.fin.gate.quik.provider.internal.QuikStandardDataObject;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Инструмент
 */
@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true, of = "id")
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuikSecurity extends QuikStandardDataObject {
    @NotNull
    private final String id;

    /**
     * Дата актуализации (т.е. дата, когда данная запись была опубликована.
     * Для отслеживания устаревших записей.
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate actualDate;

    /**
     * Код инструмента
     */
    @NotNull
    private final String code;

    /**
     * Наименование инструмента
     */
    @Nullable
    private final String name;

    /**
     * Короткое наименование инструмента
     */
    @Nullable
    private final String shortName;

    /**
     * Код класса инструментов
     */
    @NotNull
    private final String classCode;

    /**
     * Наименование класса инструментов
     */
    @Nullable
    private final String className;

    /**
     * Номинал
     */
    @Nullable
    private final BigDecimal faceValue;

    /**
     * Валюта номинала
     */
    @Nullable
    private final String faceUnit;

    /**
     * Точность (количество значащих цифр после запятой)
     */
    private final int scale;

    /**
     * Дата погашения
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Nullable
    private final LocalDate maturityDate;

    /**
     * Размер лота
     */
    @Nullable
    private final BigDecimal lotSize;

    /**
     * ISIN
     */
    @Nullable
    private final String isinCode;

    /**
     * Валюта котировок и сделок с этим инструментом.
     */
    @Nullable
    private final String currencyId;

    /**
     * Минимальный шаг цены
     */
    @Nullable
    private final BigDecimal minPriceStep;

    @JsonCreator
    public QuikSecurity(
            @JsonProperty("rowIndex") final int rowIndex,
            @JsonProperty("actualDate") @NotNull LocalDate actualDate,
            @JsonProperty("code") @NotNull String code,
            @JsonProperty("name") @Nullable String name,
            @JsonProperty("shortName") @Nullable String shortName,
            @JsonProperty("classCode") @NotNull String classCode,
            @JsonProperty("className") @Nullable String className,
            @JsonProperty("faceValue") @Nullable BigDecimal faceValue,
            @JsonProperty("faceUnit") @Nullable String faceUnit,
            @JsonProperty("scale") int scale,
            @JsonProperty("maturityDate") @Nullable LocalDate maturityDate,
            @JsonProperty("lotSize") @Nullable BigDecimal lotSize,
            @JsonProperty("isinCode") @Nullable String isinCode,
            @JsonProperty("currencyId") @Nullable String currencyId,
            @JsonProperty("minPriceStep") @Nullable BigDecimal minPriceStep
    ) {
        super(rowIndex);
        this.actualDate = actualDate;
        this.code = code;
        this.name = name;
        this.shortName = shortName;
        this.classCode = classCode;
        this.className = className;
        this.faceValue = faceValue;
        this.faceUnit = faceUnit;
        this.scale = scale;
        this.maturityDate = maturityDate;
        this.lotSize = lotSize;
        this.isinCode = isinCode;
        this.currencyId = currencyId;
        this.minPriceStep = minPriceStep;
        // Устанавливаем this.id!
        this.id = calcId();
    }

    /**
     * Вычисление идентификатора инструмента.
     */
    protected String calcId() {
        return this.code + ":" + this.classCode;
    }
}

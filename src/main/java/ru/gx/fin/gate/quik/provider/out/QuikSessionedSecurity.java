package ru.gx.fin.gate.quik.provider.out;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class QuikSessionedSecurity extends QuikStandardDataObject {
    @NotNull
    private final String id;

    /**
     * Текущая сессия
     */
    @NotNull
    private final String sessionId;

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
     * Минимальный шаг цены
     */
    @Nullable
    private final BigDecimal minPriceStep;

    public QuikSessionedSecurity(
            final int rowIndex,
            @NotNull String sessionId,
            @NotNull String code,
            @Nullable String name,
            @Nullable String shortName,
            @NotNull String classCode,
            @Nullable String className,
            @Nullable BigDecimal faceValue,
            @Nullable String faceUnit,
            int scale,
            @Nullable LocalDate maturityDate,
            @Nullable BigDecimal lotSize,
            @Nullable String isinCode,
            @Nullable BigDecimal minPriceStep
    ) {
        super(rowIndex);
        this.sessionId = sessionId;
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
        this.minPriceStep = minPriceStep;
        // Устанавливаем this.id!
        this.id = calcId();
    }

    /**
     * Вычисление идентификатора инструмента.
     */
    protected String calcId() {
        return this.sessionId + ":" + this.code + ":" + this.classCode;
    }
}

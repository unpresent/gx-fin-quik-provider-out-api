package ru.gx.fin.gate.quik.provider.out;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;
import ru.gx.fin.gate.quik.provider.internal.QuikStandardDataObject;

import java.math.BigDecimal;

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
     * Код инструмента
     */
    @NotNull
    private final String code;

    /**
     * Наименование инструмента
     */
    private final String name;

    /**
     * Короткое наименование инструмента
     */
    private final String shortName;

    /**
     * Код класса инструментов
     */
    @NotNull
    private final String classCode;

    /**
     * Наименование класса инструментов
     */
    private final String className;

    /**
     * Номинал
     */
    private final BigDecimal faceValue;

    /**
     * Валюта номинала
     */
    private final String faceUnit;

    /**
     * Точность (количество значащих цифр после запятой)
     */
    private final int scale;

    /**
     * Дата погашения
     */
    private final long maturityDate;

    /**
     * Размер лота
     */
    private final BigDecimal lotSize;

    /**
     * ISIN
     */
    private final String isinCode;

    /**
     * Минимальный шаг цены
     */
    private final BigDecimal minPriceStep;

    public QuikSecurity(
            final int rowIndex,
            @NotNull String code,
            String name,
            String shortName,
            @NotNull String classCode,
            String className,
            BigDecimal faceValue,
            String faceUnit,
            int scale,
            long maturityDate,
            BigDecimal lotSize,
            String isinCode,
            BigDecimal minPriceStep
    ) {
        super(rowIndex);
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
        return this.code + ":" + this.classCode;
    }
}

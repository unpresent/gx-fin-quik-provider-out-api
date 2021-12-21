package ru.gx.fin.gate.quik.provider.out;

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
import java.time.LocalDateTime;

/**
 * Обезличенная сделка
 */
@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true, of = "id")
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuikAllTrade extends QuikStandardDataObject {
    /**
     * Идентификатор сделки - составной ключ = {@link #exchangeCode} + ":" + {@link #tradeNum}.
     */
    @NotNull
    private final String id;

    /**
     * Код биржи в торговой системе
     */
    @NotNull
    private final String exchangeCode;

    /**
     * Номер сделки в торговой системе
     */
    @NotNull
    private final String tradeNum;

    /**
     * Направление сделки (Покупка / Продажа)
     */
    @Nullable
    private final QuikDealDirection direction;

    /**
     * Дата и время
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @NotNull
    private final LocalDateTime tradeDateTime;

    /**
     * Код класса
     */
    @NotNull
    private final String classCode;

    /**
     * Код бумаги заявки
     */
    @Nullable
    private final String secCode;

    /**
     * Цена
     */
    @Nullable
    private final BigDecimal price;

    /**
     * Количество бумаг в последней сделке в лотах
     */
    @Nullable
    private final BigDecimal quantity;

    /**
     * Объем в денежных средствах
     */
    @Nullable
    private final BigDecimal value;

    /**
     * Накопленный купонный доход
     */
    @Nullable
    private final BigDecimal accruedInterest;

    /**
     * Доходность
     */
    @Nullable
    private final BigDecimal yield;

    /**
     * Код расчетов
     */
    @Nullable
    private final String settleCode;

    /**
     * Ставка РЕПО (%)
     */
    @Nullable
    private final BigDecimal repoRate;

    /**
     * Сумма РЕПО
     */
    @Nullable
    private final BigDecimal repoValue;

    /**
     * Объем выкупа РЕПО
     */
    @Nullable
    private final BigDecimal repo2Value;

    /**
     * Срок РЕПО в днях
     */
    private final int repoTerm;

    /**
     * Период торговой сессии. Возможные значения:
     * «0» – Открытие;
     * «1» – Нормальный;
     * «2» – Закрытие
     */
    private final short period;

    /**
     * Открытый интерес
     */
    private final int openInterest;

    public QuikAllTrade(
            @JsonProperty("rowIndex") final int rowIndex,
            @JsonProperty("exchangeCode") @Nullable final String exchangeCode,
            @JsonProperty("tradeNum") @NotNull final String tradeNum,
            @JsonProperty("direction") @Nullable final QuikDealDirection direction,
            @JsonProperty("tradeDateTime") @NotNull final LocalDateTime tradeDateTime,
            @JsonProperty("classCode") @NotNull final String classCode,
            @JsonProperty("secCode") @Nullable final String secCode,
            @JsonProperty("price") @Nullable final BigDecimal price,
            @JsonProperty("quantity") @Nullable final BigDecimal quantity,
            @JsonProperty("value") @Nullable final BigDecimal value,
            @JsonProperty("accruedInterest") @Nullable final BigDecimal accruedInterest,
            @JsonProperty("yield") @Nullable final BigDecimal yield,
            @JsonProperty("settleCode") @Nullable final String settleCode,
            @JsonProperty("repoRate") @Nullable final BigDecimal repoRate,
            @JsonProperty("repoValue") @Nullable final BigDecimal repoValue,
            @JsonProperty("repo2Value") @Nullable final BigDecimal repo2Value,
            @JsonProperty("repoTerm") final int repoTerm,
            @JsonProperty("period") final short period,
            @JsonProperty("openInterest") final int openInterest
    ) {
        super(rowIndex);
        this.exchangeCode = extractExchangeCode(exchangeCode, classCode);
        this.tradeNum = tradeNum;
        this.direction = direction;
        this.tradeDateTime = tradeDateTime;
        this.classCode = classCode;
        this.secCode = secCode;
        this.price = price;
        this.quantity = quantity;
        this.value = value;
        this.accruedInterest = accruedInterest;
        this.yield = yield;
        this.settleCode = settleCode;
        this.repoRate = repoRate;
        this.repoValue = repoValue;
        this.repo2Value = repo2Value;
        this.repoTerm = repoTerm;
        this.period = period;
        this.openInterest = openInterest;
        // Устанавливаем this.id!
        this.id = calcId();
    }

    /**
     * Вычисление идентификатора сделки.
     */
    @NotNull
    protected String calcId() {
        return this.exchangeCode + ":" + this.tradeNum;
    }
}

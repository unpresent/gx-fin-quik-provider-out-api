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
import java.time.LocalDateTime;

/**
 * Заявка
 */
@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true, of = "id")
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuikOrder extends QuikStandardDataObject {

    /**
     * Идентификатор сделки - составной ключ = {@link #exchangeCode} + ":" + {@link #orderNum}.
     */
    @NotNull
    private final String id;

    /**
     * Код биржи в торговой системе
     */
    @NotNull
    private final String exchangeCode;

    /**
     * Номер заявки в торговой системе
     */
    @NotNull
    private final String orderNum;

    /**
     * Направление поручения
     */
    private final QuikDealDirection direction;

    /**
     * Комментарий, обычно: <код клиента>/<номер поручения>
     */
    private final String brokerRef;

    /**
     * Идентификатор трейдера
     */
    private final String userId;

    /**
     * Идентификатор фирмы
     */
    private final String firmId;

    /**
     * Торговый счет
     */
    private final String account;

    /**
     * Цена
     */
    private final BigDecimal price;

    /**
     * Количество в лотах
     */
    private final BigDecimal quantity;

    /**
     * Остаток
     */
    private final BigDecimal balance;

    /**
     * Объем в денежных средствах
     */
    private final BigDecimal value;

    /**
     * Накопленный купонный доход
     */
    private final BigDecimal accruedInterest;

    /**
     * Доходность
     */
    private final BigDecimal yield;

    /**
     * Идентификатор транзакции
     */
    private final long transactionId;

    /**
     * Код клиента
     */
    private final String clientCode;

    /**
     * Цена выкупа
     */
    private final BigDecimal price2;

    /**
     * Код расчетов
     */
    private final String settleCode;

    /**
     * Идентификатор пользователя
     */
    private final long uid;

    /**
     * Идентификатор пользователя, снявшего заявку
     */
    private final long canceledUid;

    /**
     * Время активации
     */
    private final long activationTime;

    /**
     * Номер заявки в торговой системе
     */
    private final long linkedOrder;

    /**
     * Дата окончания срока действия заявки
     */
    private final long expiry;

    /**
     * Код бумаги заявки
     */
    private final String secCode;

    /**
     * Код класса заявки
     */
    @NotNull
    private final String classCode;

    /**
     * Дата и время
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private final LocalDateTime tradeDateTime;

    /**
     * Дата и время снятия заявки
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private final LocalDateTime withdrawDateTime;

    /**
     * Идентификатор расчетного счета/кода в клиринговой организации.
     */
    private final String bankAccountId;

    /**
     * Способ указания объема заявки. Возможные значения:
     * «0» – по количеству,
     * «1» – по объему
     */
    private final byte valueEntryType;

    /**
     * Срок РЕПО, в календарных днях
     */
    private final int repoTerm;

    /**
     * Сумма РЕПО на текущую дату. Отображается с точностью 2 знака
     */
    private final BigDecimal repoValue;

    /**
     * Объём сделки выкупа РЕПО. Отображается с точностью 2 знака
     */
    private final BigDecimal repo2Value;

    /**
     * Остаток суммы РЕПО за вычетом суммы привлеченных
     * или предоставленных по сделке РЕПО денежных средств в неисполненной части заявки,
     * по состоянию на текущую дату.
     * Отображается с точностью 2 знака
     */
    private final BigDecimal repoValueBalance;

    /**
     * Начальный дисконт, в %
     */
    private final BigDecimal startDiscount;

    /**
     * Причина отклонения заявки брокером
     */
    private final String rejectReason;

    /**
     * Битовое поле для получения специфических параметров с западных площадок
     */
    private final int extOrderFlags;

    /**
     * Минимально допустимое количество, которое можно указать в заявке по данному инструменту.
     * Если имеет значение «0», значит ограничение по количеству не задано
     */
    private final BigDecimal minQuantity;

    /**
     * Тип исполнения заявки. Если имеет значение «0», значит значение не задано
     */
    private final int execType;

    /**
     * Поле для получения параметров по западным площадкам. Если имеет значение «0», значит значение не задано
     */
    private final int sideQualifier;

    /**
     * Поле для получения параметров по западным площадкам. Если имеет значение «0», значит значение не задано
     */
    private final int accountType;

    /**
     * Поле для получения параметров по западным площадкам. Если имеет значение «0», значит значение не задано
     */
    private final BigDecimal capacity;

    /**
     * Поле для получения параметров по западным площадкам. Если имеет значение «0», значит значение не задано
     */
    private final byte passiveOnlyOrder;

    /**
     * Видимое количество. Параметр айсберг-заявок, для обычных заявок выводится значение: «0»
     */
    private final BigDecimal visible;

    @JsonCreator
    public QuikOrder(
            @JsonProperty("rowIndex") final int rowIndex,
            @JsonProperty("exchangeCode") @Nullable String exchangeCode,
            @JsonProperty("orderNum") @NotNull String orderNum,
            @JsonProperty("direction") QuikDealDirection direction,
            @JsonProperty("brokerRef") String brokerRef,
            @JsonProperty("userId") String userId,
            @JsonProperty("firmId") String firmId,
            @JsonProperty("account") String account,
            @JsonProperty("price") BigDecimal price,
            @JsonProperty("quantity") BigDecimal quantity,
            @JsonProperty("balance") BigDecimal balance,
            @JsonProperty("value") BigDecimal value,
            @JsonProperty("accruedInterest") BigDecimal accruedInterest,
            @JsonProperty("yield") BigDecimal yield,
            @JsonProperty("transactionId") long transactionId,
            @JsonProperty("clientCode") String clientCode,
            @JsonProperty("price2") BigDecimal price2,
            @JsonProperty("settleCode") String settleCode,
            @JsonProperty("uid") long uid,
            @JsonProperty("canceledUid") long canceledUid,
            @JsonProperty("activationTime") long activationTime,
            @JsonProperty("linkedOrder") long linkedOrder,
            @JsonProperty("expiry") long expiry,
            @JsonProperty("secCode") String secCode,
            @JsonProperty("classCode") @NotNull String classCode,
            @JsonProperty("tradeDateTime") LocalDateTime tradeDateTime,
            @JsonProperty("withdrawDateTime") LocalDateTime withdrawDateTime,
            @JsonProperty("bankAccountId") String bankAccountId,
            @JsonProperty("valueEntryType") byte valueEntryType,
            @JsonProperty("repoTerm") int repoTerm,
            @JsonProperty("repoValue") BigDecimal repoValue,
            @JsonProperty("repo2Value") BigDecimal repo2Value,
            @JsonProperty("repoValueBalance") BigDecimal repoValueBalance,
            @JsonProperty("startDiscount") BigDecimal startDiscount,
            @JsonProperty("rejectReason") String rejectReason,
            @JsonProperty("extOrderFlags") int extOrderFlags,
            @JsonProperty("minQuantity") BigDecimal minQuantity,
            @JsonProperty("execType") int execType,
            @JsonProperty("sideQualifier") int sideQualifier,
            @JsonProperty("accountType") int accountType,
            @JsonProperty("capacity") BigDecimal capacity,
            @JsonProperty("passiveOnlyOrder") byte passiveOnlyOrder,
            @JsonProperty("visible") BigDecimal visible
    ) {
        super(rowIndex);
        this.exchangeCode = extractExchangeCode(exchangeCode, classCode);
        this.orderNum = orderNum;
        this.direction = direction;
        this.brokerRef = brokerRef;
        this.userId = userId;
        this.firmId = firmId;
        this.account = account;
        this.price = price;
        this.quantity = quantity;
        this.balance = balance;
        this.value = value;
        this.accruedInterest = accruedInterest;
        this.yield = yield;
        this.transactionId = transactionId;
        this.clientCode = clientCode;
        this.price2 = price2;
        this.settleCode = settleCode;
        this.uid = uid;
        this.canceledUid = canceledUid;
        this.activationTime = activationTime;
        this.linkedOrder = linkedOrder;
        this.expiry = expiry;
        this.secCode = secCode;
        this.classCode = classCode;
        this.tradeDateTime = tradeDateTime;
        this.withdrawDateTime = withdrawDateTime;
        this.bankAccountId = bankAccountId;
        this.valueEntryType = valueEntryType;
        this.repoTerm = repoTerm;
        this.repoValue = repoValue;
        this.repo2Value = repo2Value;
        this.repoValueBalance = repoValueBalance;
        this.startDiscount = startDiscount;
        this.rejectReason = rejectReason;
        this.extOrderFlags = extOrderFlags;
        this.minQuantity = minQuantity;
        this.execType = execType;
        this.sideQualifier = sideQualifier;
        this.accountType = accountType;
        this.capacity = capacity;
        this.passiveOnlyOrder = passiveOnlyOrder;
        this.visible = visible;
        // Устанавливаем this.id!
        this.id = calcId();
    }

    /**
     * Вычисление идентификатора сделки.
     */
    protected String calcId() {
        return this.exchangeCode + ":" + this.orderNum;
    }
}

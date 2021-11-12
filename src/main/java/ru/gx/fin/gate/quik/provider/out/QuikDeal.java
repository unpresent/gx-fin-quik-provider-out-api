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
import java.time.LocalDateTime;

/**
 * Сделка
 */
@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true, of = "id")
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuikDeal extends QuikStandardDataObject {

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
     * Номер заявки в торговой системе
     */
    private final String orderNum;

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
     * Идентификатор пользователя, снявшего заявку
     */
    private final long canceledUid;

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
     * Код расчетов
     */
    private final String settleCode;

    /**
     * Код фирмы партнера
     */
    private final String cpFirmId;

    /**
     * Направление сделки
     */
    private final QuikDealDirection direction;

    /**
     * Цена выкупа
     */
    private final BigDecimal price2;

    /**
     * Ставка РЕПО (%)
     */
    private final BigDecimal repoRate;

    /**
     * Код клиента
     */
    private final String clientCode;

    /**
     * Доход (%) на дату выкупа
     */
    private final BigDecimal accrued2;

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
     * Начальный дисконт (%)
     */
    private final BigDecimal startDiscount;

    /**
     * Нижний дисконт (%)
     */
    private final BigDecimal lowerDiscount;

    /**
     * Верхний дисконт (%)
     */
    private final BigDecimal upperDiscount;

    /**
     * Блокировка обеспечения («Да»/«Нет»)
     */
    private final BigDecimal blockSecurities;

    /**
     * Клиринговая комиссия (ММВБ)
     */
    private final BigDecimal clearingComission;

    /**
     * Комиссия Фондовой биржи (ММВБ)
     */
    private final BigDecimal exchangeComission;

    /**
     * Комиссия Технического центра (ММВБ)
     */
    private final BigDecimal techCenterComission;

    /**
     * Дата расчетов
     */
    private final int settleDate;

    /**
     * Валюта расчетов
     */
    private final String settleCurrency;

    /**
     * Валюта
     */
    private final String tradeCurrency;

    /**
     * Идентификатор рабочей станции
     */
    private final long stationId;

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
    @JsonFormat(pattern = "yyy-MM-dd HH:mm:ss.SSS")
    private final LocalDateTime tradeDateTime;

    /**
     * Идентификатор расчетного счета/кода в клиринговой организации
     */
    private final String bankAccountId;

    /**
     * Комиссия брокера. Отображается с точностью до 2 двух знаков. Поле зарезервировано для будущего использования
     */
    private final BigDecimal brokerComission;

    /**
     * Номер витринной сделки в Торговой Системе для сделок РЕПО с ЦК и SWAP
     */
    private final long linkedTrade;

    /**
     * Период торговой сессии. Возможные значения:
     * «0» – Открытие;
     * «1» – Нормальный;
     * «2» – Закрытие
     */
    private final short period;

    /**
     * Идентификатор транзакции
     */
    private final long transactionId;

    /**
     * Тип сделки. Возможные значения:
     * <p>
     * «1» – Обычная;
     * «2» – Адресная;
     * «3» – Первичное размещение;
     * «4» – Перевод денег/бумаг;
     * «5» – Адресная сделка первой части РЕПО;
     * «6» – Расчетная по операции своп;
     * «7» – Расчетная по внебиржевой операции своп;
     * «8» – Расчетная сделка бивалютной корзины;
     * «9» – Расчетная внебиржевая сделка бивалютной корзины;
     * «10» – Сделка по операции РЕПО с ЦК;
     * «11» – Первая часть сделки по операции РЕПО с ЦК;
     * «12» – Вторая часть сделки по операции РЕПО с ЦК;
     * «13» – Адресная сделка по операции РЕПО с ЦК;
     * «14» – Первая часть адресной сделки по операции РЕПО с ЦК;
     * «15» – Вторая часть адресной сделки по операции РЕПО с ЦК;
     * «16» – Техническая сделка по возврату активов РЕПО с ЦК;
     * «17» – Сделка по спреду между фьючерсами разных сроков на один актив;
     * «18» – Техническая сделка первой части от спреда между фьючерсами;
     * «19» – Техническая сделка второй части от спреда между фьючерсами;
     * «20» – Адресная сделка первой части РЕПО с корзиной;
     * «21» – Адресная сделка второй части РЕПО с корзиной;
     * «22» – Перенос позиций срочного рынка
     */
    private final short kind;

    /**
     * Идентификатор счета в НКЦ (расчетный код)
     */
    private final String clearingBankAccountId;

    /**
     * Дата и время снятия сделки
     */
    @JsonFormat(pattern = "yyy-MM-dd HH:mm:ss.SSS")
    private final LocalDateTime canceledDateTime;

    /**
     * Идентификатор фирмы - участника клиринга
     */
    private final String clearingFirmId;

    /**
     * Дополнительная информация по сделке, передаваемая торговой системой
     */
    private final String systemRef;

    /**
     * Идентификатор пользователя
     */
    private final long uid;

    public QuikDeal(
            final int rowIndex,
            final @Nullable String exchangeCode,
            final @NotNull String tradeNum,
            final String orderNum,
            final String brokerRef,
            final String userId,
            final String firmId,
            final long canceledUid,
            final String account,
            final BigDecimal price,
            final BigDecimal quantity,
            final BigDecimal value,
            final BigDecimal accruedInterest,
            final BigDecimal yield,
            final String settleCode,
            final String cpFirmId,
            final QuikDealDirection direction,
            final BigDecimal price2,
            final BigDecimal repoRate,
            final String clientCode,
            final BigDecimal accrued2,
            final int repoTerm,
            final BigDecimal repoValue,
            final BigDecimal repo2Value,
            final BigDecimal startDiscount,
            final BigDecimal lowerDiscount,
            final BigDecimal upperDiscount,
            final BigDecimal blockSecurities,
            final BigDecimal clearingComission,
            final BigDecimal exchangeComission,
            final BigDecimal techCenterComission,
            final int settleDate,
            final String settleCurrency,
            final String tradeCurrency,
            final long stationId,
            final String secCode,
            final @NotNull String classCode,
            final LocalDateTime tradeDateTime,
            final String bankAccountId,
            final BigDecimal brokerComission,
            final long linkedTrade,
            final short period,
            final long transactionId,
            final short kind,
            final String clearingBankAccountId,
            final LocalDateTime canceledDateTime,
            final String clearingFirmId,
            final String systemRef,
            final long uid
    ) {
        super(rowIndex);
        this.exchangeCode = extractExchangeCode(exchangeCode, classCode);
        this.tradeNum = tradeNum;
        this.orderNum = orderNum;
        this.brokerRef = brokerRef;
        this.userId = userId;
        this.firmId = firmId;
        this.canceledUid = canceledUid;
        this.account = account;
        this.price = price;
        this.quantity = quantity;
        this.value = value;
        this.accruedInterest = accruedInterest;
        this.yield = yield;
        this.settleCode = settleCode;
        this.cpFirmId = cpFirmId;
        this.direction = direction;
        this.price2 = price2;
        this.repoRate = repoRate;
        this.clientCode = clientCode;
        this.accrued2 = accrued2;
        this.repoTerm = repoTerm;
        this.repoValue = repoValue;
        this.repo2Value = repo2Value;
        this.startDiscount = startDiscount;
        this.lowerDiscount = lowerDiscount;
        this.upperDiscount = upperDiscount;
        this.blockSecurities = blockSecurities;
        this.clearingComission = clearingComission;
        this.exchangeComission = exchangeComission;
        this.techCenterComission = techCenterComission;
        this.settleDate = settleDate;
        this.settleCurrency = settleCurrency;
        this.tradeCurrency = tradeCurrency;
        this.stationId = stationId;
        this.secCode = secCode;
        this.classCode = classCode;
        this.tradeDateTime = tradeDateTime;
        this.bankAccountId = bankAccountId;
        this.brokerComission = brokerComission;
        this.linkedTrade = linkedTrade;
        this.period = period;
        this.transactionId = transactionId;
        this.kind = kind;
        this.clearingBankAccountId = clearingBankAccountId;
        this.canceledDateTime = canceledDateTime;
        this.clearingFirmId = clearingFirmId;
        this.systemRef = systemRef;
        this.uid = uid;
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

package ru.gx.fin.gate.quik.provider.out;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;
import ru.gx.core.data.AbstractDataObject;

import java.time.LocalTime;

@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true, of = "sessionId")
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuikSessionState extends AbstractDataObject {
    /**
     * Открыто ли соединение Quik с сервером
     */
    private final boolean isConnected;

    /**
     * Текущая сессия
     */
    @NotNull
    private final String sessionId;

    /**
     * Текущее время на сервере
     */
    private final LocalTime serverTime;

    /**
     * Время открытия соединения с Сервером
     */
    private final LocalTime connectionTime;

    /**
     * Версия Quik-а
     */
    private final String version;

    /**
     * Connection ?
     */
    private final String connection;

    /**
     * ip_address ?
     */
    private final String ipAddress;

    /**
     * ip_port ?
     */
    private final String ipPort;

    /**
     * ip_comment ?
     */
    private final String ipComment;

    public QuikSessionState(
            boolean isConnected, @NotNull String sessionId, LocalTime serverTime, LocalTime connectionTime, String version, String connection, String ipAddress, String ipPort, String ipComment
    ) {
        this.isConnected = isConnected;
        this.sessionId = sessionId;
        this.serverTime = serverTime;
        this.connectionTime = connectionTime;
        this.version = version;
        this.connection = connection;
        this.ipAddress = ipAddress;
        this.ipPort = ipPort;
        this.ipComment = ipComment;
    }

}

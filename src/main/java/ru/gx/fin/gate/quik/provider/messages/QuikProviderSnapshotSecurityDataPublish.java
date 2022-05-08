package ru.gx.fin.gate.quik.provider.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.gx.core.messaging.*;
import ru.gx.fin.gate.quik.provider.config.QuikProviderMessageTypes;
import ru.gx.fin.gate.quik.provider.out.QuikSecurity;

import javax.activation.UnsupportedDataTypeException;
import java.util.Arrays;

@SuppressWarnings("unused")
@ToString(callSuper = true)
public class QuikProviderSnapshotSecurityDataPublish
        extends AbstractMessage<QuikProviderSnapshotSecurityDataPublish.QuikProviderSnapshotSecurityDataPublishBody> {
    public static final int V1 = 1;
    public static final int[] SUPPORTED_VERSIONS = {V1};

    private static boolean initialized = false;

    public static void staticInit() {
        if (initialized) {
            return;
        }
        initialized = true;
        Arrays.stream(SUPPORTED_VERSIONS).forEach(version ->
                MessageTypesRegistrator.registerType(
                        MessageKind.DataPublish,
                        QuikProviderMessageTypes.Snapshots.SECURITY,
                        version,
                        QuikProviderSnapshotSecurityDataPublish.class,
                        QuikProviderSnapshotSecurityDataPublishBody.class
                )
        );
    }

    @JsonCreator
    public QuikProviderSnapshotSecurityDataPublish(
            @JsonProperty("header") @NotNull final MessageHeader header,
            @JsonProperty("body") @NotNull final QuikProviderSnapshotSecurityDataPublish.QuikProviderSnapshotSecurityDataPublishBody body,
            @JsonProperty("correlation") final @Nullable MessageCorrelation correlation
    ) {
        super(header, body, correlation);
    }

    public static class QuikProviderSnapshotSecurityDataPublishBody extends AbstractMessageBodyDataObject<QuikSecurity> {
        @JsonCreator
        public QuikProviderSnapshotSecurityDataPublishBody(
                @JsonProperty("dataObject") @NotNull final QuikSecurity dataObject
        ) throws UnsupportedDataTypeException {
            super(dataObject);
        }
    }
}

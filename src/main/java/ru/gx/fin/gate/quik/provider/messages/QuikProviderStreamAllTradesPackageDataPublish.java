package ru.gx.fin.gate.quik.provider.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.gx.core.messaging.*;
import ru.gx.fin.gate.quik.provider.config.QuikProviderMessageTypes;
import ru.gx.fin.gate.quik.provider.out.QuikAllTradesPackage;

import javax.activation.UnsupportedDataTypeException;
import java.util.Arrays;

@SuppressWarnings("unused")
@ToString(callSuper = true)
public class QuikProviderStreamAllTradesPackageDataPublish
        extends AbstractMessage<QuikProviderStreamAllTradesPackageDataPublish.QuikProviderStreamAllTradesPackageDataPublishBody> {
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
                        QuikProviderMessageTypes.Streams.ALL_TRADES,
                        version,
                        QuikProviderStreamAllTradesPackageDataPublish.class,
                        QuikProviderStreamAllTradesPackageDataPublishBody.class
                )
        );
    }

    @JsonCreator
    public QuikProviderStreamAllTradesPackageDataPublish(
            @JsonProperty("header") @NotNull final MessageHeader header,
            @JsonProperty("body") @NotNull final QuikProviderStreamAllTradesPackageDataPublish.QuikProviderStreamAllTradesPackageDataPublishBody body,
            @JsonProperty("correlation") final @Nullable MessageCorrelation correlation
    ) {
        super(header, body, correlation);
    }

    public static class QuikProviderStreamAllTradesPackageDataPublishBody extends AbstractMessageBodyDataPackage<QuikAllTradesPackage> {
        @JsonCreator
        public QuikProviderStreamAllTradesPackageDataPublishBody(
                @JsonProperty("dataPackage") @NotNull final QuikAllTradesPackage dataPackage
        ) throws UnsupportedDataTypeException {
            super(dataPackage);
        }
    }
}

package ru.gx.fin.gate.quik.provider.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.gx.core.messaging.*;
import ru.gx.fin.gate.quik.provider.config.QuikProviderMessageTypes;
import ru.gx.fin.gate.quik.provider.out.QuikSessionedSecuritiesPackage;

import javax.activation.UnsupportedDataTypeException;
import java.util.Arrays;

@SuppressWarnings("unused")
@ToString(callSuper = true)
public class QuikProviderStreamSecuritiesPackageDataPublish
        extends AbstractMessage<QuikProviderStreamSecuritiesPackageDataPublish.QuikProviderStreamSecuritiesPackageDataPublishBody> {
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
                        QuikProviderMessageTypes.Streams.SECURITIES,
                        version,
                        QuikProviderStreamSecuritiesPackageDataPublish.class,
                        QuikProviderStreamSecuritiesPackageDataPublish.QuikProviderStreamSecuritiesPackageDataPublishBody.class
                )
        );
    }

    @JsonCreator
    public QuikProviderStreamSecuritiesPackageDataPublish(
            @JsonProperty("header") @NotNull final MessageHeader header,
            @JsonProperty("body") @NotNull final QuikProviderStreamSecuritiesPackageDataPublish.QuikProviderStreamSecuritiesPackageDataPublishBody body,
            @JsonProperty("correlation") final @Nullable MessageCorrelation correlation
    ) {
        super(header, body, correlation);
    }

    public static class QuikProviderStreamSecuritiesPackageDataPublishBody extends AbstractMessageBodyDataPackage<QuikSessionedSecuritiesPackage> {
        @JsonCreator
        public QuikProviderStreamSecuritiesPackageDataPublishBody(
                @JsonProperty("dataPackage") @NotNull final QuikSessionedSecuritiesPackage dataPackage
        ) throws UnsupportedDataTypeException {
            super(dataPackage);
        }
    }
}

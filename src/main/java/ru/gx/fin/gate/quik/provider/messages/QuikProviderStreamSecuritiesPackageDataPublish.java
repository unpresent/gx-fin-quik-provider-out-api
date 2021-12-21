package ru.gx.fin.gate.quik.provider.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.gx.core.messaging.*;
import ru.gx.fin.gate.quik.provider.config.QuikProviderMessageTypes;
import ru.gx.fin.gate.quik.provider.out.QuikOrdersPackage;
import ru.gx.fin.gate.quik.provider.out.QuikSecuritiesPackage;
import ru.gx.fin.gate.quik.provider.out.QuikSessionedSecuritiesPackage;

import java.util.Arrays;

@SuppressWarnings("unused")
public class QuikProviderStreamSecuritiesPackageDataPublish
        extends AbstractDataPublish<QuikProviderStreamSecuritiesPackageDataPublish.QuikProviderStreamSecuritiesPackageDataPublishBody> {
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
            @JsonProperty("header") @NotNull final DataPublishHeader header,
            @JsonProperty("body") @NotNull final QuikProviderStreamSecuritiesPackageDataPublish.QuikProviderStreamSecuritiesPackageDataPublishBody body,
            @JsonProperty("correlation") final @Nullable MessageCorrelation correlation
    ) {
        super(header, body, correlation);
    }

    public static class QuikProviderStreamSecuritiesPackageDataPublishBody extends AbstractMessageBodyDataPackage<QuikSessionedSecuritiesPackage> {
        @JsonCreator
        public QuikProviderStreamSecuritiesPackageDataPublishBody(
                @JsonProperty("dataPackage") @NotNull final QuikSessionedSecuritiesPackage dataPackage
        ) {
            super(dataPackage);
        }
    }
}

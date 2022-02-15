package ru.gx.fin.gate.quik.provider.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.gx.core.messaging.*;
import ru.gx.fin.gate.quik.provider.config.QuikProviderMessageTypes;
import ru.gx.fin.gate.quik.provider.out.QuikOrdersPackage;

import java.util.Arrays;

@SuppressWarnings("unused")
@ToString(callSuper = true)
public class QuikProviderStreamOrdersPackageDataPublish
        extends AbstractMessage<QuikProviderStreamOrdersPackageDataPublish.QuikProviderStreamOrdersPackageDataPublishBody> {
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
                        QuikProviderMessageTypes.Streams.ORDERS,
                        version,
                        QuikProviderStreamOrdersPackageDataPublish.class,
                        QuikProviderStreamOrdersPackageDataPublish.QuikProviderStreamOrdersPackageDataPublishBody.class
                )
        );
    }

    @JsonCreator
    public QuikProviderStreamOrdersPackageDataPublish(
            @JsonProperty("header") @NotNull final StandardMessageHeader header,
            @JsonProperty("body") @NotNull final QuikProviderStreamOrdersPackageDataPublish.QuikProviderStreamOrdersPackageDataPublishBody body,
            @JsonProperty("correlation") final @Nullable MessageCorrelation correlation
    ) {
        super(header, body, correlation);
    }

    public static class QuikProviderStreamOrdersPackageDataPublishBody extends AbstractMessageBodyDataPackage<QuikOrdersPackage> {
        @JsonCreator
        public QuikProviderStreamOrdersPackageDataPublishBody(
                @JsonProperty("dataPackage") @NotNull final QuikOrdersPackage dataPackage
        ) {
            super(dataPackage);
        }
    }
}

package ru.gx.fin.gate.quik.provider.channels;

import ru.gx.core.channels.AbstractChannelApiDescriptor;
import ru.gx.core.channels.SerializeMode;
import ru.gx.core.messaging.MessageKind;
import ru.gx.fin.gate.quik.provider.config.QuikProviderChannelNames;
import ru.gx.fin.gate.quik.provider.config.QuikProviderMessageTypes;
import ru.gx.fin.gate.quik.provider.messages.QuikProviderStreamAllTradesPackageDataPublish;

@SuppressWarnings("unused")
public class QuikProviderStreamAllTradesPackageDataPublishChannelApiV1
        extends AbstractChannelApiDescriptor<QuikProviderStreamAllTradesPackageDataPublish> {

    public QuikProviderStreamAllTradesPackageDataPublishChannelApiV1() {
        super(
                QuikProviderChannelNames.Streams.ALL_TRADES_V1,
                SerializeMode.JsonString,
                QuikProviderStreamAllTradesPackageDataPublish.class,
                MessageKind.DataPublish,
                QuikProviderMessageTypes.Streams.ALL_TRADES,
                QuikProviderStreamAllTradesPackageDataPublish.V1
        );
    }
}

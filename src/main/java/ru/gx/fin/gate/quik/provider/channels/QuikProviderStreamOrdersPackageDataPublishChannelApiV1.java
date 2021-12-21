package ru.gx.fin.gate.quik.provider.channels;

import ru.gx.core.channels.AbstractChannelApiDescriptor;
import ru.gx.core.channels.SerializeMode;
import ru.gx.core.messaging.MessageKind;
import ru.gx.fin.gate.quik.provider.config.QuikProviderChannelNames;
import ru.gx.fin.gate.quik.provider.config.QuikProviderMessageTypes;
import ru.gx.fin.gate.quik.provider.messages.QuikProviderStreamOrdersPackageDataPublish;

@SuppressWarnings("unused")
public class QuikProviderStreamOrdersPackageDataPublishChannelApiV1
        extends AbstractChannelApiDescriptor<QuikProviderStreamOrdersPackageDataPublish> {

    public QuikProviderStreamOrdersPackageDataPublishChannelApiV1() {
        super(
                QuikProviderChannelNames.Streams.ORDERS_V1,
                SerializeMode.JsonString,
                QuikProviderStreamOrdersPackageDataPublish.class,
                MessageKind.DataPublish,
                QuikProviderMessageTypes.Streams.ORDERS,
                QuikProviderStreamOrdersPackageDataPublish.V1
        );
    }
}

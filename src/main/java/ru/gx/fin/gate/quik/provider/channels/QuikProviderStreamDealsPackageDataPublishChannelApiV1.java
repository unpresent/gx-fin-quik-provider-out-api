package ru.gx.fin.gate.quik.provider.channels;

import ru.gx.core.channels.AbstractChannelApiDescriptor;
import ru.gx.core.channels.SerializeMode;
import ru.gx.core.messaging.MessageKind;
import ru.gx.fin.gate.quik.provider.config.QuikProviderChannelNames;
import ru.gx.fin.gate.quik.provider.config.QuikProviderMessageTypes;
import ru.gx.fin.gate.quik.provider.messages.QuikProviderStreamDealsPackageDataPublish;

@SuppressWarnings("unused")
public class QuikProviderStreamDealsPackageDataPublishChannelApiV1
        extends AbstractChannelApiDescriptor<QuikProviderStreamDealsPackageDataPublish> {

    public QuikProviderStreamDealsPackageDataPublishChannelApiV1() {
        super(
                QuikProviderChannelNames.Streams.DEALS_V1,
                SerializeMode.JsonString,
                QuikProviderStreamDealsPackageDataPublish.class,
                MessageKind.DataPublish,
                QuikProviderMessageTypes.Streams.DEALS,
                QuikProviderStreamDealsPackageDataPublish.V1
        );
    }
}

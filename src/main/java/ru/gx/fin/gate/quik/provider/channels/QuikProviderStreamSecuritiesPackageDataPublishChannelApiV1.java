package ru.gx.fin.gate.quik.provider.channels;

import ru.gx.core.channels.AbstractChannelApiDescriptor;
import ru.gx.core.channels.SerializeMode;
import ru.gx.core.messaging.MessageKind;
import ru.gx.fin.gate.quik.provider.config.QuikProviderChannelNames;
import ru.gx.fin.gate.quik.provider.config.QuikProviderMessageTypes;
import ru.gx.fin.gate.quik.provider.messages.QuikProviderStreamSecuritiesPackageDataPublish;

@SuppressWarnings("unused")
public class QuikProviderStreamSecuritiesPackageDataPublishChannelApiV1
        extends AbstractChannelApiDescriptor<QuikProviderStreamSecuritiesPackageDataPublish> {

    public QuikProviderStreamSecuritiesPackageDataPublishChannelApiV1() {
        super(
                QuikProviderChannelNames.Streams.SECURITIES_V1,
                SerializeMode.JsonString,
                QuikProviderStreamSecuritiesPackageDataPublish.class,
                MessageKind.DataPublish,
                QuikProviderMessageTypes.Streams.SECURITIES,
                QuikProviderStreamSecuritiesPackageDataPublish.V1
        );
    }
}

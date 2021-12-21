package ru.gx.fin.gate.quik.provider.channels;

import ru.gx.core.channels.AbstractChannelApiDescriptor;
import ru.gx.core.channels.SerializeMode;
import ru.gx.core.messaging.MessageKind;
import ru.gx.fin.gate.quik.provider.config.QuikProviderChannelNames;
import ru.gx.fin.gate.quik.provider.config.QuikProviderMessageTypes;
import ru.gx.fin.gate.quik.provider.messages.QuikProviderSnapshotSecurityDataPublish;

@SuppressWarnings("unused")
public class QuikProviderSnapshotSecurityDataPublishChannelApiV1
        extends AbstractChannelApiDescriptor<QuikProviderSnapshotSecurityDataPublish> {

    public QuikProviderSnapshotSecurityDataPublishChannelApiV1() {
        super(
                QuikProviderChannelNames.Snapshots.SECURITIES_V1,
                SerializeMode.JsonString,
                QuikProviderSnapshotSecurityDataPublish.class,
                MessageKind.DataPublish,
                QuikProviderMessageTypes.Snapshots.SECURITY,
                QuikProviderSnapshotSecurityDataPublish.V1
        );
    }
}

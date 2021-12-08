package ru.gx.fin.gate.quik.provider.events;

import org.jetbrains.annotations.NotNull;
import ru.gx.core.channels.ChannelDescriptor;
import ru.gx.core.events.AbstractDataEvent;

@SuppressWarnings("unused")
public class LoadedQuikProviderStreamAllTradesEvent extends AbstractDataEvent {
    public LoadedQuikProviderStreamAllTradesEvent(@NotNull final Object source, @NotNull final ChannelDescriptor channelDescriptor) {
        super(source, channelDescriptor);
    }
}

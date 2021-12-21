package ru.gx.fin.gate.quik.provider.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@ConfigurationProperties(prefix = "service")
@Getter
@Setter
public class ConfigurationPropertiesService {

    @NestedConfigurationProperty
    public ChannelsApi channelsApi;

    @Getter
    @Setter
    public static class ChannelsApi {
        @NestedConfigurationProperty
        public QuikProviderStreams quikProviderStreams;

        @NestedConfigurationProperty
        public QuikProviderSnapshots quikProviderSnapshots;
    }

    @Getter
    @Setter
    public static class QuikProviderStreams {
        @NestedConfigurationProperty
        public Enabled securitiesV1;

        @NestedConfigurationProperty
        public Enabled ordersV1;

        @NestedConfigurationProperty
        public Enabled dealsV1;

        @NestedConfigurationProperty
        public Enabled allTradesV1;
    }

    @Getter
    @Setter
    public static class QuikProviderSnapshots {
        @NestedConfigurationProperty
        public Enabled securitiesV1;
    }

    @Getter
    @Setter
    public static class Enabled {
        public boolean enabled = true;
    }
}

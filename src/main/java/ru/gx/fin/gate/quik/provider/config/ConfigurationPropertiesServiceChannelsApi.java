package ru.gx.fin.gate.quik.provider.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@ConfigurationProperties(prefix = "service.channels-api")
@Getter
@Setter
public class ConfigurationPropertiesServiceChannelsApi {

    @NestedConfigurationProperty
    public Streams quikProviderStreams;

    @NestedConfigurationProperty
    public Snapshots quikProviderSnapshots;

    @Getter
    @Setter
    public static class Streams {
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
    public static class Snapshots {
        @NestedConfigurationProperty
        public Enabled securitiesV1;
    }

    @Getter
    @Setter
    public static class Enabled {
        public boolean enabled = true;
    }
}

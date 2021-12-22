package ru.gx.fin.gate.quik.provider.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.gx.fin.gate.quik.provider.channels.*;
import ru.gx.fin.gate.quik.provider.messages.*;

@Configuration
@EnableConfigurationProperties({ConfigurationPropertiesServiceChannelsApi.class})
public class CommonAutoConfiguration {
    private static final String DOT_ENABLED = ".enabled";

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(value = "service.channels-api." + QuikProviderChannelNames.Snapshots.SECURITIES_V1 + DOT_ENABLED, havingValue = "true")
    public QuikProviderSnapshotSecurityDataPublishChannelApiV1 quikProviderSnapshotSecuritiesPackageDataPublishChannelApiV1() {
        QuikProviderSnapshotSecurityDataPublish.staticInit();
        return new QuikProviderSnapshotSecurityDataPublishChannelApiV1();
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(value = "service.channels-api." + QuikProviderChannelNames.Streams.SECURITIES_V1 + DOT_ENABLED, havingValue = "true")
    public QuikProviderStreamSecuritiesPackageDataPublishChannelApiV1 quikProviderStreamSecuritiesPackageDataPublishChannelApiV1() {
        QuikProviderStreamSecuritiesPackageDataPublish.staticInit();
        return new QuikProviderStreamSecuritiesPackageDataPublishChannelApiV1();
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(value = "service.channels-api." + QuikProviderChannelNames.Streams.ALL_TRADES_V1 + DOT_ENABLED, havingValue = "true")
    public QuikProviderStreamAllTradesPackageDataPublishChannelApiV1 quikProviderStreamAllTradesPackageDataPublishChannelApiV1() {
        QuikProviderStreamAllTradesPackageDataPublish.staticInit();
        return new QuikProviderStreamAllTradesPackageDataPublishChannelApiV1();
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(value = "service.channels-api." + QuikProviderChannelNames.Streams.DEALS_V1 + DOT_ENABLED, havingValue = "true")
    public QuikProviderStreamDealsPackageDataPublishChannelApiV1 quikProviderStreamDealsPackageDataPublishChannelApiV1() {
        QuikProviderStreamDealsPackageDataPublish.staticInit();
        return new QuikProviderStreamDealsPackageDataPublishChannelApiV1();
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(value = "service.channels-api." + QuikProviderChannelNames.Streams.ORDERS_V1 + DOT_ENABLED, havingValue = "true")
    public QuikProviderStreamOrdersPackageDataPublishChannelApiV1 quikProviderStreamOrdersPackageDataPublishChannelApiV1() {
        QuikProviderStreamOrdersPackageDataPublish.staticInit();
        return new QuikProviderStreamOrdersPackageDataPublishChannelApiV1();
    }
}

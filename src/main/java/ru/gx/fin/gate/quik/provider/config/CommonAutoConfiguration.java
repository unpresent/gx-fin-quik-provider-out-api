package ru.gx.fin.gate.quik.provider.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.gx.fin.gate.quik.provider.memdata.QuikSecuritiesMemoryRepository;

@Configuration
@EnableConfigurationProperties({ConfigurationPropertiesServiceMemData.class})
public class CommonAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(value = "service.mem-data.quik.securities.enabled", havingValue = "true")
    public QuikSecuritiesMemoryRepository instrumentTypesMemoryRepository() {
        return new QuikSecuritiesMemoryRepository();
    }
}

package ru.gx.fin.gate.quik.provider.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import ru.gx.core.events.DataEvent;

import java.util.ArrayList;
import java.util.List;

@ConfigurationProperties(prefix = "service.mem-data.quik")
@Getter
@Setter
public class ConfigurationPropertiesServiceMemData {
    @NestedConfigurationProperty
    private MemoryRepository securities;

    @Getter
    @Setter
    public static class MemoryRepository {
        public boolean enabled = true;
    }
}

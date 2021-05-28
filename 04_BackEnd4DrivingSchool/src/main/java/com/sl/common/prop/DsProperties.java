package com.sl.common.prop;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("ds")
@Component
@Data
public class DsProperties {
    private Cfg cfg;

    @Data
    public static class Cfg {
        private String[] corsOrigins;
    }
}


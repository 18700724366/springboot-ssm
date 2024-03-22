package xian.woniuxy.config.exception;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "upload")
@Data
public class UploadProperties {
    public String dir;
    public String url;
}

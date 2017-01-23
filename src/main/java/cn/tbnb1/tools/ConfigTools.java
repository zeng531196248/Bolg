package cn.tbnb1.tools;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class ConfigTools {
    @Value("${web.upload-path}")
    private String uploadPath;

    public String getUploadPath() {
        return getUploadPath("");
    }

    public String getUploadPath(String basePath) {
        File f = new File(uploadPath+basePath);
        if(!f.exists()) {f.mkdirs();}
        return f.getAbsolutePath();
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }
}

package com.example.demo.tayma.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;

/*
bind the properties defined in the application.properties file to a POJO class.
 */
@ConfigurationProperties(prefix = "file")
public class StorageProperties {

    /**
     * Folder location for storing files
     */
    private String uploadDir;

    public String getUploadDir() {
        return uploadDir;
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }
}

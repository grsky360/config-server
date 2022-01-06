package ilio.config.config;

import ilio.config.model.enums.ValueType;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FileConfiguration {

    private static final String MASTER_KEY_CONFIG = "master-key.json";
    private static final String DATA_CONFIG_NAME = "data";

    @ConfigProperty(name = "config.file-base", defaultValue = "./config")
    String fileBase;

    public String getFileBase() {
        return fileBase;
    }

    public String resolve(String... paths) {
        return (getFileBase() + "/" + String.join("/", paths)).replaceAll("/+", "/").replaceAll("/$", "");
    }

    public String resolveMasterKeyConfig() {
        return resolve(MASTER_KEY_CONFIG);
    }

    public String resolveConfigData(String masterKey, ValueType valueType) {
        return resolve(masterKey, DATA_CONFIG_NAME + "." + valueType.name());
    }

}

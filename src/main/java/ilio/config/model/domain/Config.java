package ilio.config.model.domain;

import ilio.config.model.enums.ValueType;
import lombok.Data;

@Data
public class Config {
    private String masterKey;
    private String key;
    private byte[] value;
    private ValueType valueType;
    private boolean active;
}

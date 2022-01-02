package ilio.config.repository.file;

import com.fasterxml.jackson.databind.ObjectMapper;
import ilio.config.config.FileConfiguration;

import javax.inject.Inject;

abstract class FileRepository {

    @Inject
    protected FileConfiguration fileConfiguration;

    protected ObjectMapper json = new ObjectMapper();
}

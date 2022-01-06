package ilio.config.repository.file;

import com.fasterxml.jackson.databind.ObjectMapper;
import ilio.config.config.FileConfiguration;

import javax.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static java.nio.file.StandardOpenOption.*;

abstract class FileRepository {

    @Inject
    protected FileConfiguration fileConfiguration;

    protected ObjectMapper json = new ObjectMapper();

    protected byte[] read(File file) throws IOException {
        return Files.readAllBytes(file.toPath());
    }

    protected void write(File file, byte[] body) throws IOException {
        var path = file.toPath();
        var parent = path.getParent();
        if (!Files.exists(parent))
            Files.createDirectories(parent);

        Files.write(path, body, WRITE, CREATE, TRUNCATE_EXISTING);
    }
}

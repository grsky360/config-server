package ilio.config.repository.file;

import ilio.config.model.domain.MasterKey;
import ilio.config.repository.MasterKeyRepository;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;

import javax.enterprise.context.ApplicationScoped;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@ApplicationScoped
public class MasterFileKeyRepository extends FileRepository implements MasterKeyRepository {

    @Override
    public List<MasterKey> findAll() {
        return parseAll();
    }

    @Override
    public MasterKey findById(String id) {
        return parseAll().stream().filter(it ->
            StringUtils.equals(it.getMasterKey(), id)
        ).findFirst().orElse(null);
    }

    private List<MasterKey> parseAll() {
        String path = fileConfiguration.resolveMasterKeyConfig();
        try {
            return json.readerForListOf(MasterKey.class).readValue(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}

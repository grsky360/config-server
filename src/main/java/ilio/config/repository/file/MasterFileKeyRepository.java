package ilio.config.repository.file;

import ilio.config.model.domain.MasterKey;
import ilio.config.repository.MasterKeyRepository;
import org.apache.commons.lang3.StringUtils;

import javax.enterprise.context.ApplicationScoped;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

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

    @Override
    public void save(MasterKey entity) {
        var list = parseAll();
        var map = list.stream().collect(Collectors.toMap(MasterKey::getMasterKey, Function.identity()));
        map.put(entity.getMasterKey(), entity);
        String path = fileConfiguration.resolveMasterKeyConfig();

        try {
            write(new File(path), json.writer().writeValueAsBytes(map.values()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<MasterKey> parseAll() {
        String path = fileConfiguration.resolveMasterKeyConfig();
        try {
            return json.readerForListOf(MasterKey.class).readValue(read(new File(path)));
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}

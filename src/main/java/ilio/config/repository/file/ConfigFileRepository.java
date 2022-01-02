package ilio.config.repository.file;

import ilio.config.model.domain.Config;
import ilio.config.repository.ConfigRepository;
import io.smallrye.mutiny.tuples.Tuple2;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ConfigFileRepository extends FileRepository implements ConfigRepository {

    @Override
    public List<Config> findAll() {
        return null;
    }

    @Override
    public Config findById(Tuple2<String, String> objects) {
        return null;
    }
}

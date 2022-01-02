package ilio.config.repository;

import ilio.config.model.domain.Config;
import io.smallrye.mutiny.tuples.Tuple2;

public interface ConfigRepository extends Repository<Config, Tuple2<String, String>> {
}

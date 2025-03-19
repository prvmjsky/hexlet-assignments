package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
// BEGIN

// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.TRUNCATE_EXISTING);
    }

    // BEGIN
    @Test
    public void fileKVTest() {
        var storage = new FileKV(filepath.toString(), Map.of("key", "value"));
        assertThat(storage.get("key", "default")).isEqualTo("value");
        assertThat(storage.get("value", "default")).isEqualTo("default");

        storage.set("key3", "value3");
        storage.set("key", "10");
        assertThat(storage.get("key3", "default")).isEqualTo("value3");
        assertThat(storage.get("key", "default")).isEqualTo("10");

        storage.unset("key");
        assertThat(storage.get("key", "def")).isEqualTo("def");

        assertThat(storage.toMap()).isEqualTo(Map.of("key3", "value3"));
    }
    // END
}

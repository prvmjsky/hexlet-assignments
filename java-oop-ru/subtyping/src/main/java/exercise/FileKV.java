package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    private String storagePath;

    public FileKV(String storagePath, Map<String, String> storage) {
        this.storagePath = storagePath;
        Utils.writeFile(storagePath, Utils.serialize(storage));
    }

    @Override
    public void set(String key, String value) {
        var map = this.toMap();
        map.put(key, value);
        Utils.writeFile(storagePath, Utils.serialize(map));
    }

    @Override
    public void unset(String key) {
        var map = this.toMap();
        map.remove(key);
        Utils.writeFile(storagePath, Utils.serialize(map));
    }

    @Override
    public String get(String key, String defaultValue) {
        return toMap().getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        var content = Utils.readFile(storagePath);
        return Utils.deserialize(content);
    }
}
// END

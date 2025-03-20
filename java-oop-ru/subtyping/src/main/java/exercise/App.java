package exercise;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage kvs) {
        var storageCopy = kvs.toMap();
        storageCopy.forEach((k, v) -> {
            kvs.set(v, k);
            kvs.unset(k);
        });
    }
}
// END

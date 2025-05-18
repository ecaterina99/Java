package lib;

import java.util.HashMap;
import java.util.Map;

public class DependencyContainer {
        private Map<Class<?>, Object> instances = new HashMap<>();

        public <T> void register(Class<T> type, T instance) {
            instances.put(type, instance);
        }

        @SuppressWarnings("unchecked")
        public <T> T resolve(Class<T> type) {
            return (T) instances.get(type);
        }
}

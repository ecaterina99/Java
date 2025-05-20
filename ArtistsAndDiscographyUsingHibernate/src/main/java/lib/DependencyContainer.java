package lib;

import java.util.HashMap;
import java.util.Map;

public class DependencyContainer {
    /**
     * A simple dependency injection container that allows
     * registering and resolving class instances by type.
     */
        private Map<Class<?>, Object> instances = new HashMap<>();

        public <T> void register(Class<T> type, T instance) {
            instances.put(type, instance);
        }

        @SuppressWarnings("unchecked")
        public <T> T resolve(Class<T> type) {
            return (T) instances.get(type);
        }
    }


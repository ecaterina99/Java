package lib;

import controller.AlbumController;
import controller.ArtistController;
import repository.AlbumRepository;
import repository.ArtistRepository;
import service.AlbumService;
import service.ArtistService;

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

    //Registers all necessary components (repositories, services, controllers) with the dependency container.
    public static DependencyContainer configureDependencies() {
        DependencyContainer container = new DependencyContainer();

        container.register(ArtistRepository.class, new ArtistRepository());
        container.register(AlbumRepository.class, new AlbumRepository());

        container.register(ArtistService.class, new ArtistService(
                container.resolve(ArtistRepository.class)
        ));

        container.register(AlbumService.class, new AlbumService(
                container.resolve(AlbumRepository.class),
                container.resolve(ArtistRepository.class)
        ));

        container.register(ArtistController.class, new ArtistController(
                container.resolve(ArtistService.class)
        ));
        container.register(AlbumController.class, new AlbumController(
                container.resolve(AlbumService.class)
        ));
        return container;
    }
    }


package ft.training.by.validator;

import ft.training.by.bean.Entity;
import ft.training.by.bean.User;

import java.util.HashMap;
import java.util.Map;

public final class ValidationFactory {
    private ValidationFactory() {
    }

    private static Map<Class<? extends Entity>, Validator> repository = new HashMap<>();

    static {
        repository.put(User.class, new UserValidator());
    }

    public static <T extends Entity> Validator<T> createValidator(Class<T> entity) {
        return repository.get(entity);
    }
}

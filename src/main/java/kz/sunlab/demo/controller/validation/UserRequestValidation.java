package kz.sunlab.demo.controller.validation;

import kz.sunlab.demo.dto.UserRequest;

import java.util.function.Function;
import java.util.function.Predicate;

public interface UserRequestValidation extends Function<UserRequest, ValidationResult> {
    static UserRequestValidation nameIsNotEmpty() {
        return holds(user -> !user.getName().trim().isEmpty(), "Name is empty.");
    }

    static UserRequestValidation eMailContainsAtSign() {
        return holds(user -> user.getEmail().contains("@"), "Missing @-sign in E-Mail.");
    }

    static UserRequestValidation holds(Predicate<UserRequest> p, String message){
        return user -> p.test(user) ? ValidationResult.valid() : ValidationResult.invalid(message);
    }

    default UserRequestValidation and(UserRequestValidation other) {
        return user -> {
            final ValidationResult result = this.apply(user);
            return result.isValid() ? other.apply(user) : result;
        };
    }
}

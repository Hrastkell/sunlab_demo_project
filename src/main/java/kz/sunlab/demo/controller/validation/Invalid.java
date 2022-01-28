package kz.sunlab.demo.controller.validation;

import java.util.Objects;
import java.util.Optional;

public class Invalid implements ValidationResult {

    private final String reason;

    Invalid(String reason) {
        this.reason = reason;
    }

    public boolean isValid() {
        return false;
    }

    public Optional<String> getReason() {
        return Optional.of(reason);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invalid invalid = (Invalid) o;
        return Objects.equals(reason, invalid.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reason);
    }

    @Override
    public String toString() {
        return "Invalid[" +
                "reason='" + reason + '\'' +
                ']';
    }
}

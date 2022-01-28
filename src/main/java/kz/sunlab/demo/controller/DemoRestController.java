package kz.sunlab.demo.controller;

import kz.sunlab.demo.controller.validation.UserRequestValidation;
import kz.sunlab.demo.controller.validation.ValidationResult;
import kz.sunlab.demo.dto.ApplyResponse;
import kz.sunlab.demo.dto.UserRequest;
import kz.sunlab.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static kz.sunlab.demo.controller.validation.UserRequestValidation.eMailContainsAtSign;
import static kz.sunlab.demo.controller.validation.UserRequestValidation.nameIsNotEmpty;

@RestController("/demo")
@RequiredArgsConstructor
public class DemoRestController {
    private static final String BASE_REASON = "wrong input";

    private final UserService userService;

    @PostMapping("/user/apply")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ApplyResponse> userApply(UserRequest request) {
        UserRequestValidation validation = nameIsNotEmpty().and(eMailContainsAtSign());
        ValidationResult validationResult = validation.apply(request);
        if (!validationResult.isValid()) {
            String reason = validationResult.getReason().isPresent() ? validationResult.getReason().get() : BASE_REASON;
            return new ResponseEntity<>(new ApplyResponse(reason), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(userService.saveUser(request.toUser()), HttpStatus.OK);
    }
}

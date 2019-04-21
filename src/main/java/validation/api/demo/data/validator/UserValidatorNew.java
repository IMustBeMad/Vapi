package validation.api.demo.data.validator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import validation.api.demo.data.common.User;
import validation.api.demo.data.service.UserService;
import validation.api.demo.validation.Validation;

import static validation.api.demo.validation.domain.number.LongConditions.*;

@Slf4j
@Service
public class UserValidatorNew {

    @Autowired
    private UserService userService;

    public void verifyUserNew(Long userId, Long orderClientId) {
        if (userId == null) {
            log.debug("Current user is null, nothing to verify");

            return;
        }

        Validation.verifyIf(userService.getOne(userId))
                  .log("Validating user with id [{}]", userId)
                  .isNotNull("User not found")
                  .inspecting(
                          this::getClientId,
                          id -> Validation.verifyIf(id)
                                          .isAnyOf(isGte(1L), isEqualTo(orderClientId), "invalid user")
                  )
                  .failFast();
    }

    private Long getClientId(User user) {
        return user.getClient().getId();
    }
}
package com.ivvysoft.shop.model.dto;

import com.ivvysoft.shop.annotation.EmailValidatorConstraint;
import com.ivvysoft.shop.annotation.FieldsValueMatch;
import javax.validation.constraints.NotNull;
import lombok.Data;

@FieldsValueMatch.List({
        @FieldsValueMatch(
                field = "password",
                fieldMatch = "verifyPassword",
                message = "Passwords do not match!"
        )
})
@Data
public class ClientDtoRequest {
    @NotNull
    @EmailValidatorConstraint
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String confirmPassword;
}

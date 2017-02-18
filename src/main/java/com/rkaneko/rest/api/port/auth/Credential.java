package com.rkaneko.rest.api.port.auth;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Setter
@Getter
public class Credential {
    @NotNull
    @NotEmpty
    private String user;
    @NotNull
    @NotEmpty
    private String password;
}

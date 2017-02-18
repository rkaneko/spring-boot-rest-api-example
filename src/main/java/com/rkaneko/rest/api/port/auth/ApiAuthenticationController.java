package com.rkaneko.rest.api.port.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path =  "/api/auth")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ApiAuthenticationController {
    private static final String ATTRIBUTE_USER_KEY = "user";
    private final AuthenticationManager authenticationManager;

    @RequestMapping(method = RequestMethod.POST)
    public User login(@Validated @RequestBody Credential credential, HttpSession httpSession) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(credential.getUser(), credential.getPassword());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        User user = new User(credential.getUser(), httpSession.getId(), true);
        httpSession.setAttribute(ATTRIBUTE_USER_KEY, user);
        return user;
    }

    @RequestMapping(method = RequestMethod.GET)
    public User session(HttpSession session) {
        return (User) session.getAttribute(ATTRIBUTE_USER_KEY);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public Map<String, String> logout(HttpSession session) {
        session.invalidate();
        Map<String, String> ret = new HashMap<>();
        ret.put("success", String.valueOf(true));
        return ret;
    }
}

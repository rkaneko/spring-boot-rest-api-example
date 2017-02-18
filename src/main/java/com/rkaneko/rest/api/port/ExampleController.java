package com.rkaneko.rest.api.port;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
    @RequestMapping(path = "/api/example", method = RequestMethod.POST)
    public ExampleOutputForm run(@Validated @RequestBody ExampleInputForm inputForm) {
        return new ExampleOutputForm(inputForm.getName());
    }

    @NoArgsConstructor
    @Setter
    @Getter
    private static class ExampleInputForm {
        private Long id;
        private String name;
    }

    @AllArgsConstructor
    @Getter
    private static class ExampleOutputForm {
        private String name;
    }
}

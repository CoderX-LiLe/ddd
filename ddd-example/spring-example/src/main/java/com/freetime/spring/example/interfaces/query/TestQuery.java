package com.freetime.spring.example.interfaces.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class TestQuery implements Serializable {

    @NotBlank(message = "testString不能为空")
    @Size(min = 5, message = "testString长度")
    private String testString;
}

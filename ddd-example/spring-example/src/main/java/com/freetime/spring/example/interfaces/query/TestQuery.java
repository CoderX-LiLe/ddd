package com.freetime.spring.example.interfaces.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestQuery implements Serializable {

    @NotBlank(message = "测试字符串不能为空")
    private String testString;
}

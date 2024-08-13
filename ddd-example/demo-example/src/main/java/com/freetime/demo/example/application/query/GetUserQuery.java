package com.freetime.demo.example.application.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetUserQuery implements Serializable {

    @NonNull
    private Long userId;
}

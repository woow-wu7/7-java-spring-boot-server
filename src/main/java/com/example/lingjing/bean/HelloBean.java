package com.example.lingjing.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// @Data是lombok的注解
// @Data会自动生成 @Getter @Setter @ToString @EqualsAndHashCode @RequiredArgsConstructor

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HelloBean {
    public String name;
    public Integer age;
}

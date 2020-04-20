package com.demo.blog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springcat.dragonli.jfinal.controller.JsonBeanValidate;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BlogPara implements JsonBeanValidate {

    private String code;

    @Range(min=1,message="4001")
    private int id;

    @Length(min = 1,max = 10,message="4002")
    private String title;

    @NotBlank(message="4003")
    private String content;


}

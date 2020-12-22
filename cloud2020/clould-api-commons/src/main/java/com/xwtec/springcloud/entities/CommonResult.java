package com.xwtec.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //注解在类上, 为类提供读写属性, 此外还提供了 equals()、hashCode()、toString() 方法
@AllArgsConstructor//注解在类上；为类提供一个全参的构造方法
@NoArgsConstructor//注解在类上；为类提供一个无参的构造方法
public class CommonResult<T> {


    private Integer code;

    private String message;

    private  T      data;

    public CommonResult(Integer code,String message){
        this(code,message,null);
    }

}

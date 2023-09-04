package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private Integer code;// 1-success response; 0-failed
    private String msg; //Response msg;
    private Object data; //Response data

    //Successfully response - Post, Put, Delete
    public static Result success(){
        return new Result(1, "success", null);
    }

    //Successfully response - Select
    public static Result success(Object data){
        return new Result(1, "success", data);
    }

    //Response failed
    public static Result error(String msg){
        return new Result(0, msg, null);
    }
}

// The process of development
/*
* 1 - Look up the web pages' prototype and then determine the requirements
* 2 - Read the API documents, usually written by product managers or backend engineers
* 3 - Analysis the plan and ideas of developments
* 4 - API's developments
* 5 - API's testings
* 6 - Coordinate the front ends and back ends (Using Nginx)
* */

package com.example.lab.aop.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Target;


@Target(ElementType.METHOD)
public @interface ExecutionTime {
}
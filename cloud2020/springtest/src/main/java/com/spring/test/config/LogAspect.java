package com.spring.test.config;

import com.atguigu.springcloud.common.common.CommonResult;
import com.atguigu.springcloud.common.constants.ResultConstants;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Description: 切面测试
 * @Copyright: Copyright (c) 2021  ALL RIGHTS RESERVED.
 * @Company:
 * @Author: gjf
 * @CreateDate: 2021/7/16 14:19
 * @UpdateDate: 2021/7/16 14:19
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */

@Component
@Aspect
public class LogAspect {

    private final String POINT_CUT = "execution (public * com.spring.test.controller..*.*(..))";


    @Pointcut(POINT_CUT)
    public void pointCut(){}


    /**
     * 切点方法之前执行
     * @param joinPoint
     */
    @Before(value = "pointCut()")
    public void before(JoinPoint joinPoint){
        System.out.println("@Before通知执行");
    }


    /**
     * 切点方法之后执行
     * @param joinPoint
     */
    @After(value = POINT_CUT)
    public void doAfterAdvice(JoinPoint joinPoint){
        System.out.println("After通知执行");
    }





    /**
     * 切点方法返回后执行
     * 如果第一个参数为JoinPoint，则第二个参数为返回值的信息
     * 如果第一个参数不为JoinPoint，则第一个参数为returning中对应的参数
     * returning：限定了只有目标方法返回值与通知方法参数类型匹配时才能执行后置返回通知，否则不执行，
     * 参数为Object类型将匹配任何目标返回值
     * @param joinPoint
     * @param result
     */
    @AfterReturning(value = POINT_CUT,returning = "result")
    public void doAfterReturningAdvice(JoinPoint joinPoint,Object result){
        System.out.println("AfterReturning通知执行");
    }


    /**
     * 切点方法抛异常执行
     * 定义一个名字，该名字用于匹配通知实现方法的一个参数名，当目标方法抛出异常返回后，将把目标方法抛出的异常传给通知方法；
     * throwing:限定了只有目标方法抛出的异常与通知方法相应参数异常类型时才能执行后置异常通知，否则不执行，
     * 对于throwing对应的通知方法参数为Throwable类型将匹配任何异常。
     * @param joinPoint
     * @param exception
     */
    @AfterThrowing(value = POINT_CUT,throwing = "exception")
    public void doAfterThrowingAdvice(JoinPoint joinPoint,Exception exception){
        System.out.println("AfterThrowing通知执行");
        if(exception instanceof NullPointerException){
            System.out.println("NullPointerException!");
        } else {
            System.out.println(exception.getMessage());
        }

    }





    /**
     * 环绕通知：
     * Spring AOP的环绕通知会影响到AfterThrowing通知的运行,不要同时使用
     * 环绕通知非常强大，可以决定目标方法是否执行，什么时候执行，执行时是否需要替换方法参数，执行完毕是否需要替换返回值。
     * 环绕通知第一个参数必须是org.aspectj.lang.ProceedingJoinPoint类型
     * @param proceedingJoinPoint
     * @return
     */
    @Around(value = POINT_CUT)
    public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("@Around环绕通知开始执行");
        Object obj = null;
        try {
            obj = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            System.out.println("@Around环绕通知结束执行");
            System.out.println(throwable.getMessage());
            return new CommonResult<>(ResultConstants.ResultCode.DEFAULT_ERROR_CODE, "查询异常");
//            throw throwable;
        }
        System.out.println("@Around环绕通知结束执行");
        return obj;
    }



}

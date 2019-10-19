package com.anbaotong.aspect;

import com.anbaotong.bean.BaseBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: lijian
 * @create: 2019-10-19
 **/
@Aspect
@Component
@Slf4j
public class PaginationAspect {

    @Value("${pageHelper.page}")
    private int page;

    @Value("${pageHelper.pageSize}")
    private int size;



    @Pointcut("@annotation(Paginate)")
    public void paginate(){}

    //@Before在目标方法之前切入；切入点表达式（指定在哪个方法切入）
    @Around("paginate()")
    public Object startPage(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        // 1.获取到当前方法的方法签名, 判断返回类型是否是List, 如果是则执行分页逻辑


            // 2.获取参数page, size, 或者访问application.properties, 读取分页默认参数
            Object[] args = proceedingJoinPoint.getArgs();
            Signature signature = proceedingJoinPoint.getSignature();
            MethodSignature methodSignature = (MethodSignature) signature;
            Arrays.stream(args).forEach(parameter -> {
                if (parameter instanceof BaseBean) {
                    this.page = ((BaseBean) parameter).getCurrentPage();
                    this.size = ((BaseBean) parameter).getPageSize();
                }

            });

            // 3.输出page, size,
            // PageHelper.startPage(page, size);
            System.out.println("方法签名： " + proceedingJoinPoint.getSignature());
            System.out.println("参数列表： " + Arrays.asList(proceedingJoinPoint.getArgs()));
            PageHelper.startPage(page, size);
        Object object = proceedingJoinPoint.proceed();
        log.info("方法[{}]执行结束.",signature.getName());

        if(object instanceof List) {
            List objList = (List) object;
            PageInfo pageInfo = new PageInfo<>(objList);
            return pageInfo;
        }
        return object;
        }
}

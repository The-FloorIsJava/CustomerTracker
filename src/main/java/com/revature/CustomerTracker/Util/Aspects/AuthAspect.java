package com.revature.CustomerTracker.Util.Aspects;


import com.revature.CustomerTracker.Util.Exceptions.UnauthorizedException;
import com.revature.CustomerTracker.Util.Interface.Secured;
import com.revature.CustomerTracker.Util.Tokens.JWTUtility;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.Method;

@Aspect
@Component
public class AuthAspect {

    private final JWTUtility jwtUtility;

    @Autowired
    public AuthAspect(JWTUtility jwtUtility) {
        this.jwtUtility = jwtUtility;
    }

    @Around("@annotation(com.revature.CustomerTracker.Util.Interface.Secured)")
    public Object securedEndpoint(ProceedingJoinPoint pjp) throws Throwable {
        Method method = ((MethodSignature) pjp.getSignature()).getMethod();
        Secured annotation = method.getAnnotation(Secured.class);

        String token = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getHeader("Authorization");
        if (!jwtUtility.isTokenValid(token)) throw new UnauthorizedException("No token found");

        System.out.println(jwtUtility.extractTokenDetails(token).getTier().equals("PLATNIUM"));

        if (annotation.isPlatnium() && !jwtUtility.extractTokenDetails(token).getTier().toString().equals("PLATNIUM")) {
            throw new UnauthorizedException("Token user does not have Platnium membership and therefore does not have acces to this endpoint");
        }

        return pjp.proceed();
    }

}

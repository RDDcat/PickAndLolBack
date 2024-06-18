package com.pickandlol.pickandlol.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import java.time.LocalTime;

@Aspect
@Component
public class TimeRestrictedAspect {

    @Before("@annotation(TimeRestricted)")
    public void checkTimeRestriction() throws Throwable {
        LocalTime now = LocalTime.now();
        LocalTime start = LocalTime.of(17, 0);
        LocalTime end = LocalTime.of(22, 0);

        if (now.isBefore(start) || now.isAfter(end)) {
            throw new RuntimeException("This method cannot be accessed between "+start+" and "+ end+" "+ now);
        }
    }
}

package com.eddielaio.shorturlsystem.limiter;
import com.google.common.util.concurrent.RateLimiter;
import org.springframework.stereotype.Component;

@Component
public class myRateLimiter {
    public final RateLimiter rateLimiter = RateLimiter.create(10);
}

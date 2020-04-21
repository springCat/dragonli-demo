package com.demo.blog;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import org.springcat.dragonli.client.Recover;
import org.springcat.dragonli.client.Rpc;

import java.time.Duration;
import java.util.Map;


@Rpc("jfinalDemo")
public interface BlogService {

    BlogPara json(BlogPara blogPara);


    BlogPara json(BlogPara blogPara, Map<String,Object> header);


}

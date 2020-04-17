package com.demo.blog;
import org.springcat.dragonli.client.Rpc;

@Rpc("jfinalDemo")
public interface BlogService {
    BlogPara json(BlogPara blogPara);
}

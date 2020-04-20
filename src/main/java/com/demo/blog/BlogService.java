package com.demo.blog;

import org.springcat.dragonli.client.Rpc;
import java.util.Map;

@Rpc("jfinalDemo")
public interface BlogService {

    BlogPara json(BlogPara blogPara);

    BlogPara json(BlogPara blogPara, Map<String,Object> header);


}

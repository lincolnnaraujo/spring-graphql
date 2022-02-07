package br.com.pocs.springgraphql.springgraphql.graphimpl;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class QueryGraphQL implements GraphQLQueryResolver {

    public String hello(){
        return "Hello World, GraphQL!";
    }

    public int soma(int a, int b){
        return a + b;
    }

}

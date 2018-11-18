package com.mabuonomo.springbootauthupdated;

import com.mabuonomo.springbootauthupdated.bike.BikeResolver;
import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import io.leangen.graphql.GraphQLSchemaGenerator;
import io.leangen.graphql.metadata.strategy.query.AnnotatedResolverBuilder;
import io.leangen.graphql.metadata.strategy.value.jackson.JacksonValueMapperFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import com.mabuonomo.springbootauthupdated.car.CarResolver;

import java.util.Map;

@RestController
public class GraphQLController {

        private final GraphQL graphQL;

        public GraphQLController(CarResolver carResolver, BikeResolver bikeResolver) {
                GraphQLSchema schema = new GraphQLSchemaGenerator().withResolverBuilders(
                                // Resolve by annotations
                                new AnnotatedResolverBuilder())

                                // resolvers
                                .withOperationsFromSingleton(carResolver).withOperationsFromSingleton(bikeResolver)

                                .withValueMapperFactory(new JacksonValueMapperFactory()).generate();
                graphQL = GraphQL.newGraphQL(schema).build();
        }

        @PostMapping(value = "/graphql", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
        @ResponseBody
        public Map<String, Object> graphql(@RequestBody Map<String, String> request, HttpServletRequest raw) {
                ExecutionResult executionResult = graphQL
                                .execute(ExecutionInput.newExecutionInput().query(request.get("query"))
                                                .operationName(request.get("operationName")).context(raw).build());
                return executionResult.toSpecification();
        }
}

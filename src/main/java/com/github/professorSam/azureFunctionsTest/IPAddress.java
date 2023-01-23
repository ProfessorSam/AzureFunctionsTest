package com.github.professorSam.azureFunctionsTest;

import java.util.*;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;

public class IPAddress {
    @FunctionName("IPAddress")
    public HttpResponseMessage run(
            @HttpTrigger(
                    name = "req", methods = {HttpMethod.GET},
                    authLevel = AuthorizationLevel.ANONYMOUS)
            HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {
        context.getLogger().info("Java HTTP trigger processed a request.");

        String host = request.getHeaders().getOrDefault("X-Forwarded-For", "unkown");
        return request.createResponseBuilder(HttpStatus.OK).body("Your ip address is " + host).build();
    }
}

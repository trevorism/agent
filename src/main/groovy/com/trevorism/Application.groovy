package com.trevorism

import com.trevorism.agent.AgentRunner
import com.trevorism.agent.SimpleAgent
import groovy.transform.CompileStatic
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Contact
import io.swagger.v3.oas.annotations.info.Info

@OpenAPIDefinition(
        info = @Info(
                title = "App",
                version = "0.0.1",
                description = "API",
                contact = @Contact(url = "https://trevorism.com", name = "Trevor Brooks", email = "tbrooks@trevorism.com")
        )
)
@CompileStatic
class Application {
    static void main(String[] args) {
        //Micronaut.run(Application, args)

        new AgentRunner(new SimpleAgent("First")).run()
    }
}

package com.mtg.resourcehandler;

import com.mtg.exception.ResourceNotFoundException;
import com.mtg.model.ClaimEntity;



import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.model.rest.RestParamType;

import org.springframework.stereotype.Component;



@Component

public class ControllerResource extends RouteBuilder {




    @Override
    public void configure() throws Exception {
        restConfiguration()
                .component("servlet")
                .bindingMode(RestBindingMode.json)
              .dataFormatProperty("prettyPrint", "true").contextPath("/rest")
                .apiContextPath("/api-doc").apiContextRouteId("#name#")
                .apiProperty("api.title", "User API").apiProperty("api.version", "1.0")
                .apiProperty("cors", "true");


        onException(ResourceNotFoundException.class)
                .handled(true)
                .to("bean:ClaimResourceExceptionHandlerService?method=handleResourceException");


        rest("api/claim").description("User REST service")
                .consumes("application/json")
                .produces("application/json")

                .get().description("Find all Claims ").outType(ClaimEntity[].class)
                .responseMessage().code(200).message("All Claims successfully returned").endResponseMessage()
                .route()
                .to("bean:claimService?method=getAllListOfClaim")
                .endRest()

                .get("/{id}").description("Find Claim  by ID")
                .outType(ClaimEntity.class)
                .param().name("id").type(RestParamType.path).description("The ID of the Cliams").dataType("Long").endParam()
                .responseMessage().code(200).message("Claim successfully returned").endResponseMessage()
                .route()
                .to("bean:claimService?method=getById(${header.id})")
                .endRest()

                .post().description("Create a Claims").type(ClaimEntity.class)
                .param().name("body").type(RestParamType.body).description("The Claims  to create").endParam()
                .responseMessage().code(204).message("Claim successfully created").endResponseMessage()
                .to("bean:claimService?method=Save")

                .put("/{id}").description("Update Claims").type(ClaimEntity.class)
                .param().name("id").type(RestParamType.path).description("The ID of the Claims to update").dataType("Long").endParam()
                .param().name("body").type(RestParamType.body).description("The   Claim  to update").endParam()
                .responseMessage().code(204).message("Cliam successfully updated").endResponseMessage()
                .to("bean:claimService?method=updateClaim")

                .delete("/{id}").description("Delete Claims by ID")
                .outType(ClaimEntity.class)
                .param().name("id").type(RestParamType.path).description("The ID of the Claims ").dataType("Long").endParam()
                .responseMessage().code(200).message("Claims  successfully deleted").endResponseMessage()
                .to("bean:claimService?method=delete(${header.id})");




    }

}
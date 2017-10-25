/**
 *  @Author: Z003CUHM
 *  @Date: Dec. 08, 2016
 *
 *  Copyright (C) Siemens AG 2016
 *  All Rights Reserved
 *
 *  This software is furnished under a corporate license for use on a
 *  cloud system and cannot be copied to other system.
 *
 *  This software is the confidential and proprietary information of Siemens CT
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the license
 *  agreement you entered into with Siemens CT.
 *
 */

package com.siemens.scic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName SwaggerDocumentationConfig.java
 *
 * Swagger configuration.
 *
 * <b><pre>
 * Copyright (C) Siemens AG 2016
 * All Rights Reserved
 * </pre></b>
 *
 * @Author Z003CUHM
 * @Date Dec. 08, 2016
 * @Version
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-27T08:23:07.014Z")

@EnableSwagger2
@Configuration
public class SwaggerDocumentationConfig {

    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SCIC Competence center: Order service.")
                .description("Provide order related API(s) for Competence center.")
                .license("")
                .licenseUrl("")
                .termsOfServiceUrl("")
                .version("0.0.1")
                .contact(new Contact("","", ""))
                .build();
    }

    @Bean
    public Docket customImplementation(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.siemens.scic"))
                .build()
                .directModelSubstitute(org.joda.time.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(org.joda.time.DateTime.class, java.util.Date.class)
                .apiInfo(apiInfo());
    }

}

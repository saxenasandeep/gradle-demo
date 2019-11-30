package sanrockzz.gradledemo.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger Config
 *
 * @author : Sanjeev Saxena
 *
 * @Date : Jan 14, 2018
 * @since : 1.0
 */

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build();
    }

    @SuppressWarnings("unchecked")
    private ApiInfo apiInfo() {
        return new ApiInfo("Tagging Service APIs", "Service to list all tagging related APIs", "1.0", "",
                new Contact("Sanjeev Saxena", "https://www.linkedin.com/in/sanjeevkumar-saxena-84421b45/",
                        "sanrocks123@gmail.com"),
                "Copyrights (c), 2019. Sanrockzz Ltd. All Rights Reserved", "https://github.com/sanrocks123",
                Collections.EMPTY_LIST);
    }
}
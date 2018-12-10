/**
 * <h1>SwaggerConfiguration</h1>
 * The SwaggerConfiguration is used  for configaration framework swagger
 * 
 */
package dk.viabill.productorders.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author victor.zaitev
 * @version 1.0
 * @since 2018-12-09
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    /**
     *
     * @return
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaData());
    }

    /**
     *
     * @return
     */
    private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "Spring Boot REST API",
                "Spring Boot REST API for Product Orders",
                "1.0",
                "Terms of service",
                new Contact("Zaitev Victor", "", "victor.zaitev@gmail.com"),
                "ViaBill team",
                "http://www.viabill.dk/");
        return apiInfo;
    }
}

/**
 * <h1>ProductOrdersApplication</h1>
 * The ProductOrdersApplication program implements main method
 * 
 */
package dk.viabill.productorders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 *
 * @author victor.zaitev
 * @version 1.0
 * @since 2018-12-09
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ProductOrdersApplication extends SpringBootServletInitializer {

    /**
     * 
     * @param application
     * @return 
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ProductOrdersApplication.class);
    }

    /**
     * this is the main method
     * @param args 
     */
    public static void main(String[] args) {
        SpringApplication.run(ProductOrdersApplication.class, args);
    }
}

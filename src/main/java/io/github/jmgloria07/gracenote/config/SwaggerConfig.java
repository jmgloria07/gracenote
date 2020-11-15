package io.github.jmgloria07.gracenote.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import io.github.jmgloria07.gracenote.util.GracenoteConstants;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(SpringDataRestConfiguration.class)
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage(GracenoteConstants.GRACENOTE_PACKAGE))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo(
			      "Gracenote API Documentation",
			      "A journal of your gratitudes!",
			      "1.0",
			      null,
			      new Contact("@kohi_pudding", "https://www.pudding.coffee", "pudding@pudding.coffee"),
			      "GNU GPLv3",
			      "https://www.gnu.org/licenses/gpl-3.0.en.html",
			      Collections.emptyList());
	}
}

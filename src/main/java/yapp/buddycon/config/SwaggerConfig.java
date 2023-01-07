package yapp.buddycon.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityScheme.In;
import io.swagger.v3.oas.models.security.SecurityScheme.Type;
import java.util.Arrays;
import org.springdoc.core.SpringDocUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import yapp.buddycon.web.member.auth.AuthMember;

@Configuration
public class SwaggerConfig {

  static {
    SpringDocUtils.getConfig()
        .addRequestWrapperToIgnore(AuthMember.class);
  }

  @Bean
  public OpenAPI openAPI() {
    Info info = new Info()
        .version("v1.0.0")
        .title("Buddycon")
        .description("Buddycon API Docs");

    SecurityScheme securityScheme = new SecurityScheme()
        .type(Type.HTTP).scheme("bearer").bearerFormat("JWT")
        .in(In.HEADER).name("Authorization");
    SecurityRequirement securityRequirement = new SecurityRequirement().addList("bearerAuth");

    return new OpenAPI()
        .components(new Components().addSecuritySchemes("bearerAuth", securityScheme))
        .info(info)
        .security(Arrays.asList(securityRequirement));
  }

}

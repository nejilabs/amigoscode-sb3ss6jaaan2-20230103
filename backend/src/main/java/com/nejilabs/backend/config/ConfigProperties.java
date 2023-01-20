/* 
* This wasn't in the course but of my own cuz they placed the secret key for the JWT Service directly on code. 
* They did say however for security, you can keep the secret key in your application properties / yml file.
* So this is my attempt to do that, storing the value from my .env file which is included in the .gitignore file.
* Then the application.yml will retrieve those keys from the .env file.
* Then this ConfigProperties class will retrieve those configs from the application.yml for use in configuration.
* 
* Tried out solutions from here:
* https://stackoverflow.com/questions/30528255/how-to-access-a-value-defined-in-the-application-properties-file-in-spring-boot
*/

// ATTEMPT#1:
// package com.nejilabs.backend.config;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.PropertySource;
// import org.springframework.core.env.Environment;
// import org.springframework.stereotype.Component;

// @Component
// @PropertySource("classpath:application.yml")
// public class ConfigProperties {
//   @Autowired
//   private Environment environment;

//   public String getConfigValue(String configValue) {
//     return environment.getProperty(configValue);
//   }
// }

// ATTEMPT#2:
// package com.nejilabs.backend.config;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// @Configuration
// public class ConfigProperties {
//   @Value("${jwt.service.secret-key}")
//   private String jwtServiceSecretKey;

//   @Bean
//   public String getJwtServiceSecretKey() {
//     return jwtServiceSecretKey;
//   }
// }

// ATTEMPT#3:
package com.nejilabs.backend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigProperties {
  @Value("${jwt.service.secret-key}")
  private static String jwtServiceSecretKey;

  private static final String SECRET_KEY = jwtServiceSecretKey;

  @Bean
  public String getJwtServiceSecretKey() {
    return SECRET_KEY;
  }
}

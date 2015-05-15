package makasprzak.so.camel.producer.testing;

import org.apache.camel.spring.javaconfig.CamelConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnnotationConfigApp extends CamelConfiguration {
   public static void main(String[] args) {
      ApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfigApp.class);
      SimpleProducer simpleProducer = context.getBean(SimpleProducer.class);
      simpleProducer.send("Hello World!");
   }

   @Bean
   public SimpleProducer simpleProducer() {
      return new SimpleProducer();
   }

}

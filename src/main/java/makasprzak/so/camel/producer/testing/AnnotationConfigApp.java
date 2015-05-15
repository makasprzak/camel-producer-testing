package makasprzak.so.camel.producer.testing;

import org.apache.camel.CamelContext;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnnotationConfigApp {
   public static void main(String[] args) {
      ApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfigApp.class);
      SimpleProducer simpleProducer = context.getBean(SimpleProducer.class);
      simpleProducer.send("Hello World!");
   }

   @Autowired
   private ApplicationContext ctx;

   @Bean
   public SimpleProducer simpleProducer() {
      return new SimpleProducer();
   }

   @Bean
   public CamelContext camelContext() throws Exception {
      CamelContext camelContext = new SpringCamelContext(ctx);
      camelContext.start();
      return camelContext;
   }
}

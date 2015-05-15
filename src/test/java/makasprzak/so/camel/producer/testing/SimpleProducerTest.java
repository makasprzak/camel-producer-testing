package makasprzak.so.camel.producer.testing;

import org.apache.camel.EndpointInject;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.spring.javaconfig.CamelConfiguration;
import org.apache.camel.test.spring.CamelSpringDelegatingTestContextLoader;
import org.apache.camel.test.spring.CamelSpringJUnit4ClassRunner;
import org.apache.camel.test.spring.MockEndpointsAndSkip;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

@MockEndpointsAndSkip("activemq:queue:simple")
@RunWith(CamelSpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SimpleProducerTest.TestConfig.class, loader = CamelSpringDelegatingTestContextLoader.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class SimpleProducerTest {

   @Autowired
   private SimpleProducer simpleProducer;

   @EndpointInject(uri = "mock:activemq:queue:simple")
   private MockEndpoint queue;

   @Test
   public void test() throws Exception {
      queue.expectedBodiesReceived("Hello World!");
      simpleProducer.send("Hello World!");
      queue.assertIsSatisfied();
   }

   @Configuration
   public static class TestConfig extends CamelConfiguration {

      @Bean
      public SimpleProducer simpleProducer() {
         return new SimpleProducer();
      }
   }
}
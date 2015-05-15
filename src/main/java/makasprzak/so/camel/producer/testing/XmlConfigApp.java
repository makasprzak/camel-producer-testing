package makasprzak.so.camel.producer.testing;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class XmlConfigApp {
   public static void main(String[] args) {
      ApplicationContext context = new GenericXmlApplicationContext("context.xml");
      SimpleProducer simpleProducer = context.getBean(SimpleProducer.class);
      simpleProducer.send("Hello World!");
   }
}

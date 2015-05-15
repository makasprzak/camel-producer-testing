package makasprzak.so.camel.producer.testing;

import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;

public class SimpleProducer {

   @Produce(uri = "activemq:queue:simple")
   private ProducerTemplate activeMqProducer;

   public void send(String message) {
      activeMqProducer.sendBody(message);
   }
}

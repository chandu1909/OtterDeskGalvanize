package com.galvanize.assessment.rabbit.reciever;

import com.galvanize.assessment.rabbit.config.RabbitConfiguration;
import com.galvanize.assessment.rabbit.model.BluePrint;
import com.galvanize.assessment.rabbit.producer.Sender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class Consumer {

    private static final Logger logger = LoggerFactory.getLogger(Sender.class.getName());

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(RabbitConfiguration.class);
        AmqpTemplate amqpTemplate = context.getBean(AmqpTemplate.class);

        BluePrint recievedBluePrint = (BluePrint) amqpTemplate.receiveAndConvert();
        logger.info("Recieved sheet from the rabbitMQ***********");
        logger.info(recievedBluePrint.getBlueprintId().toString(), " \n "+recievedBluePrint.getCurrentProcessingPhase()," \n "+recievedBluePrint.getFileLocation());

    }
}

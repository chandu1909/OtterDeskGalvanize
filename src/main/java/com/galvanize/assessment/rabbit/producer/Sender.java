package com.galvanize.assessment.rabbit.producer;

import com.galvanize.assessment.rabbit.config.RabbitConfiguration;
import com.galvanize.assessment.rabbit.model.BluePrint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.UUID;

public class Sender {

    @Autowired
    static BluePrint bluePrint;

    private static final Logger logger = LoggerFactory.getLogger(Sender.class.getName());

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(RabbitConfiguration.class);
        AmqpTemplate amqpTemplate = context.getBean(AmqpTemplate.class);

        //hard coding values to the entity
        bluePrint.setBlueprintId(UUID.randomUUID());
        bluePrint.setCurrentProcessingPhase("pdf_to_image");
        bluePrint.setFileLocation("https://s3.us-east-2.amazonaws.com/someco.com/uploads/pdfs/74efe087-7949-46db-8a8d-ee06776eb2b0.pdf");
        bluePrint.setTime("1544404634");

        //sending them to rabbitMQ

        amqpTemplate.convertAndSend(bluePrint);
        logger.info("A new sheet has been added to the RabbitMQ...!!! ");

    }
}

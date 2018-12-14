package com.galvanize.assessment.rabbit;

import com.galvanize.assessment.rabbit.config.RabbitConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class RabbitApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitApplication.class, args);

		ApplicationContext context = new AnnotationConfigApplicationContext(RabbitConfiguration.class);
		AmqpAdmin amqpAdmin = context.getBean(AmqpAdmin.class);
		Queue workerQueue = new Queue("pdf.worker.queue");

		amqpAdmin.declareQueue(workerQueue);

	}

}


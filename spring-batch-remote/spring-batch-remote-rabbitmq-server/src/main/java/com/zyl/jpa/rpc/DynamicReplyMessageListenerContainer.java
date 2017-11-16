package com.zyl.jpa.rpc;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;

public class DynamicReplyMessageListenerContainer extends
		SimpleMessageListenerContainer {
	@Override
	protected void doInitialize() throws Exception {
		super.doInitialize();
		Object listener = getMessageListener();
		if (listener instanceof RabbitTemplate) {
			RabbitTemplate template = (RabbitTemplate) listener;
			Queue queue = getRabbitAdmin().declareQueue();
			template.setReplyQueue(queue);
			setQueues(queue);
		}
	}
}

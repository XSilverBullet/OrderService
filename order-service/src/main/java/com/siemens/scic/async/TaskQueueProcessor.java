package com.siemens.scic.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class TaskQueueProcessor {
	@Autowired
	private TaskQueue erpTaskQueue;
	@Autowired
	private TaskQueue mesTaskQueue;
	@Autowired
	private TaskQueue wccTaskQueue;

	@Scheduled(fixedRate = 10)
	public void process() {
		erpTaskQueue.pollAndExecute();
		mesTaskQueue.pollAndExecute();
		wccTaskQueue.pollAndExecute();
	}

}

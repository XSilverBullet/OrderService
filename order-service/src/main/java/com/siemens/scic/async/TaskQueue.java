package com.siemens.scic.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentLinkedQueue;

public class TaskQueue {
	
	private static final Logger logger = LoggerFactory.getLogger(TaskQueue.class);
	
	private ConcurrentLinkedQueue<QueueTask> queue = null;

	public TaskQueue() {
		this.queue = new ConcurrentLinkedQueue<>();
	}

	public void addTask (QueueTask task) {
		if (task == null) {
			return;
		}

		logger.debug("CmsTaskQueue.add: " + task.getClass().getName());
		queue.add(task);
		logger.debug("CmsTaskQueue.size: " + queue.size());
	}
	
	public QueueTask pollTask() {
        QueueTask task = queue.poll();
		if (task == null) {
			return null;
		}

        logger.debug("CmsTaskQueue.poll: " + task.getClass().getName());
        logger.debug("CmsTaskQueue.size: " + queue.size());

        return task;
    }

    public void pollAndExecute () {
        QueueTask task = pollTask();
        if (task != null) {
            logger.debug("CmsTaskQueue.Execute: " + task.getClass().getName());
            task.onTask();
        }
    }

}

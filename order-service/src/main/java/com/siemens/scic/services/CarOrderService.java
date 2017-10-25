package com.siemens.scic.services;

import com.siemens.scic.async.QueueTask;
import com.siemens.scic.async.TaskQueue;
import com.siemens.scic.config.SpringContainerFactory;
import com.siemens.scic.model.basis.OrderState;
import com.siemens.scic.model.CarOrder;
import com.siemens.scic.repository.CarOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Simon.Lau on 16-Dec-16.
 */
@Service
public class CarOrderService {
    @Autowired
    private CarOrderRepository carOrderRepository;

    public CarOrder addOrder (CarOrder carOrder) {
        CarOrder _carOrder = carOrderRepository.save(carOrder);
        TaskQueue erpTaskQueue = SpringContainerFactory.getBean("erpTaskQueue", TaskQueue.class);
        erpTaskQueue.addTask(new ErpQueueTask(carOrder));
        return _carOrder;
    }

    public CarOrder findOrderById (String id) {
        return carOrderRepository.findOne(id);
    }

    public List<CarOrder> findAllOrders () {
        return carOrderRepository.findAll();
    }

    class ErpQueueTask implements QueueTask {
        private CarOrder order;

        public ErpQueueTask (CarOrder order) {
            this.order = order;
        }

        @Override
        public void onTask() {
            TaskQueue mesTaskQueue = SpringContainerFactory.getBean("mesTaskQueue", TaskQueue.class);
            CarOrderRepository carOrderRepository = SpringContainerFactory.getBean(CarOrderRepository.class);
            try {
                this.order.setState(OrderState.ERP.getValue());
                carOrderRepository.save(this.order);
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            mesTaskQueue.addTask(new MesQueueTask(this.order));
        }
    }

    class MesQueueTask implements QueueTask {
        private CarOrder order;

        public MesQueueTask (CarOrder order) {
            this.order = order;
        }

        @Override
        public void onTask() {
            TaskQueue wccTaskQueue = SpringContainerFactory.getBean("wccTaskQueue", TaskQueue.class);
            CarOrderRepository carOrderRepository = SpringContainerFactory.getBean(CarOrderRepository.class);
            try {
                this.order.setState(OrderState.MES.getValue());
                carOrderRepository.save(this.order);
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            wccTaskQueue.addTask(new WccQueueTask(this.order));
        }
    }

    class WccQueueTask implements QueueTask {
        private CarOrder order;

        public WccQueueTask (CarOrder order) {
            this.order = order;
        }

        @Override
        public void onTask() {
            TaskQueue wccTaskQueue = SpringContainerFactory.getBean("wccTaskQueue", TaskQueue.class);
            CarOrderRepository carOrderRepository = SpringContainerFactory.getBean(CarOrderRepository.class);
            try {
                this.order.setState(OrderState.WCC.getValue());
                carOrderRepository.save(this.order);
                Thread.sleep(10000);
                this.order.setState(OrderState.DONE.getValue());
                carOrderRepository.save(this.order);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

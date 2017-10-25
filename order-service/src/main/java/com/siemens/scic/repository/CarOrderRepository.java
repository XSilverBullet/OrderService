package com.siemens.scic.repository;

import com.siemens.scic.model.CarOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Simon.Lau on 16-Dec-16.
 */
@Repository
public interface CarOrderRepository extends JpaRepository <CarOrder, String> {

}

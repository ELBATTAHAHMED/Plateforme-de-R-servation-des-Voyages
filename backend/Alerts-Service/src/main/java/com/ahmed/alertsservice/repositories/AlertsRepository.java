package com.ahmed.alertsservice.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ahmed.alertsservice.models.Alerts;
@Repository
public interface AlertsRepository extends JpaRepository <Alerts , Long>{

}

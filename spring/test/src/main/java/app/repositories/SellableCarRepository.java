package app.repositories;

import app.domain.vehicle.SellableCar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellableCarRepository extends JpaRepository<SellableCar,Long> {
}

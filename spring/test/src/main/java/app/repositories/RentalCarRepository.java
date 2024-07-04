package app.repositories;

import app.domain.vehicle.RentalCar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalCarRepository extends JpaRepository<RentalCar,Long> {
}

package app.repositories;

import app.domain.vehicle.RentalBicycle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalBicycleRepository extends JpaRepository<RentalBicycle,Long> {
}

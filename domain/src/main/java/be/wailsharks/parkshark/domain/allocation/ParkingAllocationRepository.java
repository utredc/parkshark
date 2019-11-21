package be.wailsharks.parkshark.domain.allocation;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ParkingAllocationRepository extends CrudRepository<ParkingAllocation, Long> {
    List<ParkingAllocation> findByStatusIs(Status status);
}

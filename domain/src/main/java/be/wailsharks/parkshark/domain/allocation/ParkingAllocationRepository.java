package be.wailsharks.parkshark.domain.allocation;

import be.wailsharks.parkshark.domain.members.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ParkingAllocationRepository extends CrudRepository<ParkingAllocation, Long> {
    List<ParkingAllocation> findByStatusIs(Status status);

    List<ParkingAllocation> findByMemberAndStatusIs(Member member, Status status);
}

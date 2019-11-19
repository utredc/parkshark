//package be.wailsharks.parkshark.api.allocation;
//
//import be.wailsharks.parkshark.api.allocation.dto.ParkingAllocationDto;
//import be.wailsharks.parkshark.api.allocation.dto.StartParkingAllocationDto;
//import be.wailsharks.parkshark.domain.allocation.ParkingAllocation;
//
//public class ParkingAllocationMapper {
//
//    public static ParkingAllocation mapToDomain(StartParkingAllocationDto startParkingAllocationDto) {
//        return new ParkingAllocation(
//                startParkingAllocationDto.member,
//                startParkingAllocationDto.licensePlate,
//                startParkingAllocationDto.parkingLot
//        );
//    }
//
//    public static ParkingAllocationDto mapToDto(ParkingAllocation parkingAllocation) {
//        return new ParkingAllocationDto()
//                .setId(parkingAllocation.getId())
//                .setMemberId(parkingAllocation.getMember().getId())
//                .setLicensePlateNumber(parkingAllocation.getLicensePlate().getPlateNumber())
//                .setParkingLotId(parkingAllocation.getParkingLot().getId())
//                .setStartTime(parkingAllocation.getStartTime().toString());
//    }
//}

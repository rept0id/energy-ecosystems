package gr.simplecode.energyecosystems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EnergyEcosystemsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnergyEcosystemsApplication.class, args);
	}

	@PostMapping("/add-share-request")
	public ResponseEntity<String> createShareRequest(@RequestBody ShareRequestDTO requestDTO) {
		User requester = userRepository.findById(requestDTO.getRequesterId()).orElse(null);
		VirtualNeighborhood neighborhood = neighborhoodRepository.findById(requestDTO.getVirtualNeighborhoodId()).orElse(null);

		if (requester != null && neighborhood != null) {
		    ShareRequest shareRequest = new ShareRequest();
		    shareRequest.setRequester(requester);
		    shareRequest.setVirtualNeighborhood(neighborhood);
		    shareRequest.setRequestedCapacityInKWh(requestDTO.getRequestedCapacityInKWh());
		    shareRequest.setStatus("Pending");

		    shareRequestRepository.save(shareRequest);

		    return ResponseEntity.ok("Share request created successfully.");
		} else {
		    return ResponseEntity.badRequest().body("Invalid user or virtual neighborhood ID.");
		}
	}


}

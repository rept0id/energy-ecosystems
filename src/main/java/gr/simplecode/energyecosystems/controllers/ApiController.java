package gr.simplecode.energyecosystems.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import gr.simplecode.energyecosystems.models.*;
import gr.simplecode.energyecosystems.services.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private EnergyEcosystemService energyEcosystemService;
    
    @Autowired
    private VirtualNeighborhoodService virtualNeighborhoodService;
    
    @Autowired
    private StorageCapacityService storageCapacityService;
    
    @Autowired
    private ShareRequestService shareRequestService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/energy-ecosystems")
    public ResponseEntity<List<EnergyEcosystem>> getAllEnergyEcosystems() {
        List<EnergyEcosystem> ecosystems = energyEcosystemService.getAllEnergyEcosystems();
        return ResponseEntity.ok(ecosystems);
    }

    @GetMapping("/virtual-neighborhoods")
    public ResponseEntity<List<VirtualNeighborhood>> getAllVirtualNeighborhoods() {
        List<VirtualNeighborhood> neighborhoods = virtualNeighborhoodService.getAllVirtualNeighborhoods();
        return ResponseEntity.ok(neighborhoods);
    }

    @GetMapping("/storage-capacities")
    public ResponseEntity<List<StorageCapacity>> getAllStorageCapacities() {
        List<StorageCapacity> capacities = storageCapacityService.getAllStorageCapacities();
        return ResponseEntity.ok(capacities);
    }

    @GetMapping("/share-requests")
    public ResponseEntity<List<ShareRequest>> getAllShareRequests() {
        List<ShareRequest> requests = shareRequestService.getAllShareRequests();
        return ResponseEntity.ok(requests);
    }

    @PostMapping("/add-share-requests")
    public ResponseEntity<String> createShareRequest(@RequestBody ShareRequestDTO requestDTO) {
        // Validate and create share request using ShareRequestService
        // Return appropriate response
    }
    
    // Add other controller methods for CRUD operations, e.g., updateUser, createEnergyEcosystem, etc.
}


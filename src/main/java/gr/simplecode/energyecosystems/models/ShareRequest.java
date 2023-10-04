package gr.simplecode.energyecosystems.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ShareRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "requester_id")
    private User requester;
    
    @ManyToOne
    @JoinColumn(name = "virtual_neighborhood_id")
    private VirtualNeighborhood virtualNeighborhood;
    
    private double requestedCapacityInKWh;
    private String status; // Use an enum for status
    
    private LocalDateTime requestCreationTime;
    private LocalDateTime requestUpdateTime;
    
    // Getters and setters, constructors
}


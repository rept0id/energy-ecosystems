package gr.simplecode.energyecosystems.models;

import javax.persistence.*;

@Entity
public class StorageCapacity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private double capacityInKWh;
    private double availableCapacityInKWh;
    
    @ManyToOne
    @JoinColumn(name = "virtual_neighborhood_id")
    private VirtualNeighborhood virtualNeighborhood;
    
    // Getters and setters, constructors
}


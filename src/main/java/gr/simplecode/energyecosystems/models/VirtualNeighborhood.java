package gr.simplecode.energyecosystems;

import javax.persistence.*;

@Entity
public class VirtualNeighborhood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "energy_ecosystem_id")
    private EnergyEcosystem energyEcosystem;
    
    // Getters and setters, constructors
}


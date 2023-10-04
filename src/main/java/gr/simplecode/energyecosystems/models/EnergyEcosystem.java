package gr.simplecode.energyecosystems.models;

import javax.persistence.*;

@Entity
public class EnergyEcosystem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String location;
    private String description;
    
    // Getters and setters, constructors
}


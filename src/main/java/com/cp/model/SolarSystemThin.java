package com.cp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="SolarSystem")
@JsonPropertyOrder({"id","solarName", "currentPlanet", "sphere"})
public class SolarSystemThin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column
    private String solarName;
    //@Column
//    @Convert(converter = JpaConverterJson.class)
//    @Column(columnDefinition = "json")
    @OneToMany(mappedBy = "ss", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Planet> sphere;
//    @Column
//    @Convert(converter = JpaConverterJson.class)
//    @Column(columnDefinition = "json")
    private String currentPlanet;//name



    public Planet getPlanet(int index){
        return  this.sphere.get(index);
    }
    public Planet getPlanet(String name){
        for(Planet t : sphere){
            if (t.getName().toLowerCase().contentEquals(name)){
                return t;
            }
        }
        return null;
    }


}

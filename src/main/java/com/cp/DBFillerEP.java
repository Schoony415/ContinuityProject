package com.cp;


import com.cp.dao.*;
import com.cp.model.Planet;
import com.cp.model.SolarSystemThin;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cp.model.CrewMember;
import com.cp.model.SpaceShip;
//import com.cp.controller.CrewMemberController;
//import com.cp.controller.SpaceShipController;
import com.cp.dao.SpaceShipRepository;
import com.cp.dao.CrewMemberRepository;

import java.util.ArrayList;

//names from : http://www.babynames.it/top100/1/year-1993.html
//ships from https://en.wikipedia.org/wiki/Atlanta-class_cruiser
//for adding test datta to a db
@RestController
//@CrossOrigin("http://localhost:3000")
public class DBFillerEP {
    private final CrewMemberRepository cmrepository;
    private final SpaceShipRepository ssrepository;
    private final SolarSystemRepository solarrepository;
    private final PlanetRepository planetrepoitory;


    public DBFillerEP(CrewMemberRepository repositoryA,
                      SpaceShipRepository repositoryB,
                      SolarSystemRepository repositoryC,
                      PlanetRepository repoitoryD) {
        this.cmrepository = repositoryA;
        this.ssrepository = repositoryB;
        this.solarrepository = repositoryC;
        this.planetrepoitory = repoitoryD;
    }

    @GetMapping("/test/fill")
    public String testfill(){
        CrewMember[] cmlist = new CrewMember[10];
        cmlist[0] = new CrewMember("Michael", 100f, "Red");
        cmlist[1] = new CrewMember("Jessica", 95f, "Blue");
        cmlist[2] = new CrewMember("Christopher", 89f, "Red");
        cmlist[3] = new CrewMember("Ashley", 100f, "Yellow");
        cmlist[4] = new CrewMember("Matthew", 95f, "Red");
        cmlist[5] = new CrewMember("Sarah", 100f, "Red");
        cmlist[6] = new CrewMember("Joshua", 87f, "Blue");
        cmlist[7] = new CrewMember("Samantha", 98f, "Red");
        cmlist[8] = new CrewMember("Tyler", 88f, "Blue");
        cmlist[9] = new CrewMember("Emily", 93f, "Green");

        SpaceShip[] sslist = new SpaceShip[5];
        sslist[0] = new SpaceShip("Atlanta");
        sslist[1] = new SpaceShip("Juneau");
        sslist[2] = new SpaceShip("San Diego");
        sslist[3] = new SpaceShip("San Juan");
        sslist[4] = new SpaceShip("Oakland");

        SolarSystemThin[] solarList = new SolarSystemThin[2];
        ArrayList<Planet> planetlistA = new ArrayList<>();
        planetlistA.add(new Planet("OI", 500));
        planetlistA.add(new Planet("OII", 1000));
        planetlistA.add(new Planet("OIII", 1500));

        solarList[0] = new SolarSystemThin(0,"Orion", planetlistA, "OI");
//        solarList[0] = new SolarSystemThin(0,"Orion", planetlistA, planetlistA.get(0));

        ArrayList<Planet> planetlistB = new ArrayList<>();
        planetlistB.add(new Planet("CI", 500));
        planetlistB.add(new Planet("CII", 1000));
        planetlistB.add(new Planet("CIII", 1500));

        solarList[1] = new SolarSystemThin(0, "Centari", planetlistB, "CI");
//        solarList[1] = new SolarSystemThin(0, "Centari", planetlistB, planetlistB.get(0));


        for(CrewMember cm : cmlist){
            //CrewMemberController.savecm(cm);
            this.cmrepository.save(cm);
        }
        for(SpaceShip ss : sslist){
            //SpaceShipController.saveship(ss);
            this.ssrepository.save(ss);
        }

        for(SolarSystemThin solar : solarList){
            var temp = this.solarrepository.save(solar);
            for(Planet p : solar.getSphere()){
                System.out.println("pulled planet"+p+p.getId()+p.getSs());
//                p.setId(temp.getId());
                p.setSs(temp);
                this.planetrepoitory.save(p);
            }
        }
        System.out.println("Test Data Added");
        return "It's done.";
    }




}

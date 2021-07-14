package eu.noelvaes.housekeeping;

import eu.noelvaes.housekeeping.services.*;
import org.springframework.context.annotation.*;

@Configuration
public class AppConfig {

    //create Beans for all cleaningtools and cleaningserviceImpl, instantiate them in the Bean-method
    //example: CleaningTool broom() is method that returns a new Broom every time it's called, and is added to the container because its a Bean
    //all beans will be added into the "container"


    @Bean
    @Scope("prototype")
    //each Bean has a name through which you can call it, standard is same name as the method
    //so method "broom()" will make sure that the Bean is also called "broom"
    // can give a different name by adding (name="anotherName") behind the @Bean
    // can give multiple names in form of array: (name = {"name1", "name2", "name3"}), can be used as aliasses
    //each name needs to be unique
    public CleaningTool broom(){
        System.out.println("Created new broom");
        return new Broom();
    }

    @Bean
    @Scope("prototype")
    //can also use @Description("...") to add a descriptive String to a certain Bean
    public CleaningTool sponge(){
        System.out.println("Created new sponge");
        return new Sponge();
    }

    @Bean
    @Scope("prototype")
    //standard scope of Bean is singleton. only one instance available, every instance will be the same
    //other option is @Scope("prototype"), can keep instantiating new Beans of this type
    public CleaningTool vacuum(){
        System.out.println("Created new vacuum");
        return new VacuumCleaner();
    }

    @Bean
    @Scope(value = "prototype", proxyMode = ScopedProxyMode.INTERFACES)
    public CleaningTool duster(){
        System.out.println("Created new duster");
        return new DisposableDuster();
    }

    @Lazy
    @Bean(name = "jill1")
    public CleaningService jill(){
        System.out.println("Created jill");
        CleaningServiceImpl cs = new CleaningServiceImpl();
        cs.setCleaningTool(broom());
        return cs;
    }

    @Lazy
    @Bean(name = "jane1")
    public CleaningService jane(){
        CleaningServiceImpl cs = new CleaningServiceImpl();
        cs.setCleaningTool(sponge());
        System.out.println("Created jane");
        return cs;
    }

    @Lazy
    @Bean(name = "bob1")
    public CleaningService bob(){
        CleaningServiceImpl cs = new CleaningServiceImpl();
        System.out.println("Created bob");
        cs.setCleaningTool(vacuum());
        return cs;
    }

    @Lazy
    @Bean
    @Primary
    //Primary needed in case of multiple Beans, where you only need one (see domesticService below)
    public CleaningService jef(){
        CleaningServiceImpl cs = new CleaningServiceImpl();
        System.out.println("Created jef");
        cs.setCleaningTool(duster());
        return cs;
    }




    @Bean
    @Scope("prototype")
    public GardeningTool mower(){
        return new LawnMower();
    }

    @Lazy
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public GardeningService scott(GardeningTool tool){
        System.out.println("created scott");
        GardeningServiceImpl gs = new GardeningServiceImpl();
        gs.setGardeningTool(tool);
        return gs;
    }

    @Bean(name = "domesticService")
    public DomesticService cleaner(CleaningService cs, GardeningService gs){
        DomesticServiceImpl ds = new DomesticServiceImpl();
        ds.setCleaningService(cs);
        ds.setGardeningService(gs);
        return ds;
    }


}

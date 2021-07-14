package eu.noelvaes.housekeeping;

import eu.noelvaes.housekeeping.services.*;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HouseApp {

    public static void main(String[] args) {

        try(ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class)){
            System.out.println("Container initialized");
            DomesticService service = ctx.getBean("domesticService", DomesticService.class);
            service.runHouseHold();
        }
    }


//    public static void main(String[] args) {
//
//        //tell the HouseApp to start using Beans by instantiating ConfigurableApp... interface
//        //this is our CONTAINER, containing all our Beans
//        // BUT there are four kinds of implementations for that interface: 3 with XML, 1 with JAVA
//        //XML has no code completion, no syntax controle before runtime, nog coupling with javadoc, etc
//        //that's why we use the AnnotationConfigApplicationContext
//        //still needs to define where our Beans are, in what container, in this case the AppConfig.class
//
//        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//
//        //create new worker (CleaningService) called jill
//        //call the Bean named "jill", using the Config... from above, named ctx
//        // => ctx.getBean(...); will search in the AppConfig.class, was defined above
//        // => gets the Bean named jill from that AppConfig, and says that the jill Bean is from the CleaningService class
//        //what it looks like in the AppConfig:
//        //          @Bean
//        //          public CleaningService jill(){....}
//        CleaningService jill = ctx.getBean("jill1", CleaningService.class);
//        CleaningService bob = ctx.getBean("bob1", CleaningService.class);
//        CleaningService jane = ctx.getBean("jane1", CleaningService.class);
//        CleaningService jef = ctx.getBean("jef", CleaningService.class);
//        GardeningService scott = ctx.getBean("scott", GardeningService.class);
//
//        //tell "CleaningService jill" from above to start clean();
//        jill.clean();
//        bob.clean();
//        jane.clean();
//        jef.clean();
//        jef.clean();
//        scott.garden();
//
//
//
//        //still need to CLOSE THE ConfigurableApp... called ctx
//        ctx.close();
//
//
//    }

}



// BEFORE BEANS:
//
//    //instantiate the tools that can be used by the workers
//
//    CleaningTool broom = new Broom();
//    CleaningTool vacuum = new VacuumCleaner();
//    CleaningTool sponge = new Sponge();
//
//    //create new workers from the CSImpl, give them a name (jane, jill, bob)
//    //tell the worker what tool to use: setCleaningTool(...)
//
//    CleaningServiceImpl jill = new CleaningServiceImpl();
//        jill.setCleaningTool(broom);
//                CleaningServiceImpl bob = new CleaningServiceImpl();
//                bob.setCleaningTool(vacuum);
//                CleaningServiceImpl jane = new CleaningServiceImpl();
//                jane.setCleaningTool(sponge);
//
//                //tell the workers to clean()
//                //clean will do clean() from CleaningService, which is overridden in CleaningServiceImpl, where a sout "cleaning" and a sout from the tool is added when overriding
//
//                jill.clean();
//                bob.clean();
//                jane.clean();

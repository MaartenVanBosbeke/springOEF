package eu.noelvaes.housekeeping.services;

public class Broom implements CleaningTool{

    public void doCleanJob() {  //doCleanJob comes from Cleaningtool (implemented), here overridden, adding the sout "scrub scrub"
        System.out.println("Scrub scrub");
    }
}

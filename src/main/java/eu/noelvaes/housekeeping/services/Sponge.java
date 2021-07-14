package eu.noelvaes.housekeeping.services;

public class Sponge implements CleaningTool{

    public void doCleanJob(){  //doCleanJob comes from Cleanintool (implemented), here overridden, adding the sout "splish splash"
        System.out.println("Splish splash");
    }
}

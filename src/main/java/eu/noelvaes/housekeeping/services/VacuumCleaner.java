package eu.noelvaes.housekeeping.services;

public class VacuumCleaner implements CleaningTool{

    @Override
    public void doCleanJob(){ //doCleanJob comes from Cleanintool (implemented), here overridden, adding the sout "zuuu"
        System.out.println("zuuuuuu");
    }

}

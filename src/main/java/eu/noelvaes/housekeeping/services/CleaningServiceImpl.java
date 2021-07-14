package eu.noelvaes.housekeeping.services;

public class CleaningServiceImpl implements CleaningService { //used for our workers

    private CleaningTool tool; //link the CSImpl to the Cleaningtool, so it can use the doCleanJob() from the CleaningTool

    public void setCleaningTool(CleaningTool tool) { //allows you to say which worker uses which tool (worker.set(broom), worker.set(sponge), worker.set(vacuum), ...)
        this.tool = tool;
    }

    public void clean(){ //allows you to tell the worker to clean() (worker.clean()), override by adding the sout "cleaning the house"
        // and also adds the doCleanJob() from the CleaningTool() defined by this.tool for that worker (so worker.set(broom) will act like broom.doCleanJob() kind of
        System.out.println("Cleaning the house");
        tool.doCleanJob();
    }

}

package eu.noelvaes.housekeeping.services;

public class DomesticServiceImpl implements DomesticService{




    private CleaningService cleaningService;
    private GardeningService gardeningService;



    public void runHouseHold() {
        cleaningService.clean();
        gardeningService.garden();
    }

    public void setCleaningService(CleaningService cleaningService){
        this.cleaningService = cleaningService;
    }

    public void setGardeningService(GardeningService gardeningService){
        this.gardeningService = gardeningService;
    }



}

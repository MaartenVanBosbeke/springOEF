package eu.noelvaes.housekeeping.services;

public class GardeningServiceImpl implements GardeningService{
    private GardeningTool tool;

    public void setGardeningTool(GardeningTool tool){
        this.tool = tool;
    }

    public void garden(){
        System.out.println("working in garden");
        tool.doGardenJob();
    }

    public void init(){
        System.out.println("GardeningService preparing for work");
    }

    public void destroy(){
        System.out.println("GardeningService cleaning up");
    }
}

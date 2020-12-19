package lab03;
import  lab03.fileReader.FileReader;
import  lab03.handler.Handler;
import  java.io.IOException;
public class Application {
    public  static  void  main(String[]  args)  throws  IOException{
        FileReader  fileReader  =  new FileReader("C:\\Users\\Dell\\IdeaProjects\\lab03\\5.bin");
        Handler  handler  =  new  Handler(fileReader.readAsIntegers());
        System.out.println("Hello it is labwork 3 by Vladyslav Zhovnir");
        System.out.println("Dynamic  range:  "  +  handler.getDynamicRange());
        System.out.println("Signal  energy:  "  +  handler.getSignalEnergy());
        System.out.println("Average  signal  power:  "  +  handler.getAverageSignalPower()); System.out.println("Average  signal  value:  "  +
                handler.getAverageSignalValues());
        System.out.println("Dispersion  of  signal  values  :  "  +
                handler.getSignalValuesDispersion());
        System.out.println("Correlation  interval:  "  +
                handler.getCorrelationInterval());
    }
}



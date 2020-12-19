

package  lab03.handler;

import  java.util.Collections; import  java.util.List;
import  java.util.stream.IntStream;

public  class  Handler  {
    private  List<Integer>  signals;
    private  double  dynamicRange;
    private  double  signalEnergy;
    private  double  averageSignalPower;
    private  double  averageSignalValue;
    private  double  signalValuesDispersion;
    private  double  correlationInterval;

    public  Handler(List<Integer>  signals)  {
        this.signals  =  signals;

        calcDynamicRange();
        calcSignalEnergy();
        calcAverageSignalPower();
        calcAverageSignalPower();
        calcAverageSignalValue();
        calcSignalValuesDispersion();
        calcCorrelationInterval();
    }

    private  void  calcDynamicRange()  {
        dynamicRange  =  Collections.max(signals)  -  Collections.min(signals);
    }

    private  void  calcSignalEnergy()  {
        double  sum  =  0;

        for  (Integer  sign:  signals)  {
            sum  +=  (sign  *  sign);
        }

        signalEnergy  =  sum;
    }

    private  void  calcAverageSignalPower()  {
        averageSignalPower  =  signalEnergy  /  signals.size();
    }

    private  void  calcAverageSignalValue()  {
        double  sum  =  0;
        for  (Integer  sign:  signals)  { sum  +=  sign;
        }

        averageSignalValue  =  sum  /  signals.size();
    }

    private  void  calcSignalValuesDispersion()  { double  sum  =  0;
        double  difference;

        for  (Integer  sign  :  signals)  {
            difference  =  sign  -  averageSignalValue; sum  +=  difference  *  difference;
        }

        signalValuesDispersion  =  sum  /  signals.size();
    }

    private  double  calcSignalAutocorrelation(int  interval)  {
        int  positiveInterval  =  Math.abs(interval);

        return  IntStream.range(0,  signals.size()  -  positiveInterval)
                .mapToDouble(index  ->  (signals.get(index  +  positiveInterval)
                        -  averageSignalValue)  *  (signals.get(index)  -
                        averageSignalValue))
                .map(value  ->  value  /  (signals.size()  -  positiveInterval)).sum();
    }

    private  void  calcCorrelationInterval()  { double  sum;
        double  correlation  =  0;

        for  (Integer  sign:	signals)  {
            correlation  +=  calcSignalAutocorrelation(signals.indexOf(sign));
        }
        sum  =  correlation  /  calcSignalAutocorrelation(signals.get(0));
        correlationInterval  =  sum;
    }

    public  double  getDynamicRange()  {
        return  dynamicRange;
    }

    public  double  getSignalEnergy()  {
        return  signalEnergy;
    }

    public  double  getAverageSignalPower()  {
        return  averageSignalPower;
    }

    public  double  getAverageSignalValues()  {
        return  averageSignalValue;
    }

    public  double  getSignalValuesDispersion()  {
        return  signalValuesDispersion;
    }
    public  double  getCorrelationInterval()  {
        return  correlationInterval;
    }
}




package by.javacourse.se.homework2.task3;

public class DataBufferFiveElements {

    private final double[] arrayData = new double[5];
    private  int counter = 0;

    public void setValueOfDataBuffer (double data) {
        for (int i = (arrayData.length-1); i > 0; i--) {
            arrayData[i] = arrayData[i-1];
        }
        arrayData[0]= data;
        if (counter<arrayData.length){
            counter++;
        }
    }

    public double getAverageValueOfDataBuffer() {
        double averageValue=0;
        for (double value : arrayData) {
            averageValue += value;
        }
        averageValue = averageValue /counter;
        return averageValue;
    }
}

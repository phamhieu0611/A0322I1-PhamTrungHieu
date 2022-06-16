package oop.bai_tap.stopWatch;

public class StopWatch {
    private long startTime;
    private long endTime;

    public StopWatch(){
        this.startTime = System.currentTimeMillis();
    }
    public long start(){
        return this.startTime = System.currentTimeMillis();
    }
    public long stop(){
        return this.endTime = System.currentTimeMillis();
    }
    public long getElapsedTime(){
        return System.currentTimeMillis() - this.startTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }
}

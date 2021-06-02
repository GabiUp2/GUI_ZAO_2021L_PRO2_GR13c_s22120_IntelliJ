package GameAntyPlague;

import java.time.LocalDate;
import java.util.List;

public class TimeGenerator implements ControlsTime, Runnable, ThisThingIsObservedAKASubject {

    private boolean active = true;
    private boolean pause = false;
    private int dayCount = 0;
    private int milisecondsPerDayCount = 2000;

    private List<ThisThingObservesAKAObserver> observers;


    //TODO: Move starting date to settings
    private LocalDate startDate = LocalDate.of(2020, 2, 15);

    public TimeGenerator(){

    }

    //TODO: move time for day ticks to settings
    public void setSpeedToSlow(){
        milisecondsPerDayCount = 2000;
    }

    public void setSpeedToNormal(){
        milisecondsPerDayCount = 1000;
    }

    public void setSpeedToFast(){
        milisecondsPerDayCount = 500;
    }

    @Override
    public LocalDate getCurrentDate() {
        return startDate.plusDays(dayCount);
    }

    @Override
    public void run() {

        while (active){
            while(!isPaused()){
                try {
                    wait(milisecondsPerDayCount);
                    dayCount++;
                    System.out.println("Day Tick! Current Day: " + this.getCurrentDate());
                    Notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public boolean isPaused() {
        return pause;
    }

    public void pause() {
        this.pause = true;
    }

    public void unpause(){
        this.pause = false;
    }

    @Override
    public String toString() {
        return "TimeGenerator{" +
                "pause=" + pause +
                ", dayCount=" + dayCount +
                ", milisecondsPerDayCount=" + milisecondsPerDayCount +
                ", startDate=" + startDate +
                '}';
    }

    @Override
    public void Attach(ThisThingObservesAKAObserver observer) {
        observers.add(observer);
    }

    @Override
    public void Detach(ThisThingObservesAKAObserver observer) {
        observers.remove(observer);
    }

    @Override
    public Object GetState() {
        return getCurrentDate();
    }

    @Override
    public void Notify() {
        for (ThisThingObservesAKAObserver observer : observers){
            observer.Update();
        }
    }

    public void SetState(int year, int month, int day) {
        startDate = LocalDate.of(year, month, day);
    }

}

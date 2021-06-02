package GameAntyPlague;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public class TimeTasksManager implements UsesThreadsManager, ThisThingObservesAKAObserver, ThisThingIsObservedAKASubject{
    static final String thread_category = "time";
    private List<ThisThingObservesAKAObserver> observers;
    private ThreadsManager threadsManager;
    private HashMap<String, Object> timeManagementSettings;
    private TimeGenerator timeGenerator;
    private Thread timeThread;
    private LocalDate lastDate;


    public TimeTasksManager(ThreadsManager threadsManager, HashMap<String, Object> timeManagementSettings){
        this.threadsManager = threadsManager;
        this.timeManagementSettings = timeManagementSettings;

        this.timeGenerator = new TimeGenerator();
        timeGenerator.Attach(this);
        this.timeThread = threadsManager.generateNewThread(getThreadsCategory(), timeGenerator);
        this.timeThread.start();
        System.out.println("This is the time thread name: " + timeThread.getName());

    }

    @Override
    public void Update() {
        System.out.println("TimeTaskManager was called by TimeGenerator!");
        this.lastDate = timeGenerator.getCurrentDate();
    }

    @Override
    public String getThreadsCategory() {
        //TODO: Is there a way to read in class name directly into function? Like "__name__" in Python?
        return TimeTasksManager.thread_category;
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
        return null;
    }

    @Override
    public void Notify() {
        for (ThisThingObservesAKAObserver observer : observers){
            observer.Update();
        }
    }
}

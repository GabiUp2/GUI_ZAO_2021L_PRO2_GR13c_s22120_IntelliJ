package GameAntyPlague;

import java.util.HashMap;

public class ThreadsManager {

    HashMap<String, MyThreadFactory> factories_by_category = new HashMap<>();

    public ThreadsManager(){

    }

    public Thread generateNewThread(String threads_category, Runnable runnable){
        MyThreadFactory _factory;

        if (!MyThreadFactory.existing_threads_categories.contains(threads_category)) {
            factories_by_category.put(threads_category, new MyThreadFactory(threads_category));
        }
        _factory = factories_by_category.get(threads_category);

        return _factory.newThread(runnable);
    }

}

package GameAntyPlague;

import java.util.ArrayList;
import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {

    static ArrayList<String> existing_threads_categories;

    private String category_of_threads;

    private int count_of_threads_generated_by_this_factory = 0;

    public int getCountOfThreadsGeneratedByThisFactory() {
        return count_of_threads_generated_by_this_factory;
    }

    public String getCategoryOfThreads() {
        return category_of_threads;
    }

    public void setCategoryOfThreads(String category_of_threads) {
        if (!existing_threads_categories.contains(category_of_threads)) {
            MyThreadFactory.existing_threads_categories.add(category_of_threads);
            this.category_of_threads = category_of_threads;
        }
    }

    public String getExisitngCategoriesOfThreads(){
        return MyThreadFactory.existing_threads_categories.toString();
    }

    public MyThreadFactory(String category_of_threads){
        setCategoryOfThreads(category_of_threads);
    }

    @Override
    public Thread newThread(Runnable runnable_class) {
        count_of_threads_generated_by_this_factory++;
        Thread _thread = new Thread(runnable_class);
        _thread.setName(this.category_of_threads + "-thread-"+this.count_of_threads_generated_by_this_factory);
        System.out.println("New thread generated: " + _thread.getName());
        return _thread;
    }

    @Override
    public String toString() {
        return "MyThreadFactory{" +
                "category_of_threads='" + category_of_threads + '\'' +
                ", count_of_threads_generated_by_this_factory=" + count_of_threads_generated_by_this_factory +
                '}';
    }
}

package GameAntyPlague;

import java.util.Objects;

public interface ThisThingIsObservedAKASubject {

    void Attach(ThisThingObservesAKAObserver observer);
    void Detach(ThisThingObservesAKAObserver observer);
    Object GetState();
    void Notify();

}

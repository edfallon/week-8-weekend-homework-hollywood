import models.Actor;
import models.Studio;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class StudioTest {

    Studio studio1;
    Actor actor1;

    @Before
    public void before(){
        studio1 = new Studio("Creative Pictures", 1000000.00);
        actor1 = new Actor("Harry", 10000.00);
    }

    @Test
    public void canPayActorActorsMoneyGoesUP() {
        studio1.payPerson(actor1, 10000.00);
        assertEquals(20000.00, actor1.getMoney(), 0.01);
    }

    @Test
    public void canPayActorStudioBudgetGoesDown() {
        studio1.payPerson(actor1, 10000.00);
        assertEquals(990000.00, studio1.getBudget(), 0.01);
    }
}

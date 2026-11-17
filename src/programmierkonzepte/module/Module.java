package programmierkonzepte.module;

// import de.kvbw.dummy.Dummy;
import de.kvbw.helper.ConsoleHelper;
import global.Workable;

public class Module implements Workable {
    @Override
    public boolean isActive() {
        return false;
    }

    public void testConsole() {
        int z1 = ConsoleHelper.getInstance().readInteger("Zahl",0,120);
        System.out.println(z1);
//        System.out.println(Dummy.getZahl());
    }
    @Override
    public void doWork() {

            testConsole();

    }
}

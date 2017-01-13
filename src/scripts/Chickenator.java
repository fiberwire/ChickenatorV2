package scripts;

import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Script.Manifest(name = "Chickenator", description = "Kills chickens")

public class Chickenator extends PollingScript<ClientContext> {
    List<Task> tasks = new ArrayList<Task>();

    @Override
    public void poll() {
        for (Task task : tasks) {
            if (task.activate()) {
                task.execute();
            }
        }
    }

    @Override
    public void start() {

        tasks.addAll(Arrays.asList(
                new WalkToChicken(ctx),
                new Gate(ctx),
                new AttackChicken(ctx),
                new Loot(ctx),
                new WalkToBank(ctx),
                new Bank(ctx)
        ));
    }
}

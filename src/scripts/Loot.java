package scripts;

import com.sun.media.jfxmedia.logging.Logger;
import org.powerbot.script.PollingScript;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GroundItem;
import org.powerbot.script.rt6.GroundItems;

public class Loot extends Task<ClientContext> {
    public Loot(ClientContext ctx) {
        super(ctx);
    }

    int feather = 314;
    int bones = 526;
    int eggs = 1944;
    int cornucopia = 14537;

    @Override
    public boolean activate() {
        return ctx.groundItems.select().id(feather).isEmpty()
                || ctx.groundItems.select().id(bones).isEmpty();
    }

    @Override
    public void execute() {
        ctx.groundItems.select().id(feather).poll().interact("pick up");
        ctx.groundItems.select().id(bones).poll().interact("pick up");
        /*
        WalkToBank bank = new WalkToBank(ctx);
        bank.execute();
        */

    }
}

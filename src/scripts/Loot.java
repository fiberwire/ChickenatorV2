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

    @Override
    public boolean activate() {
        return !ctx.groundItems.select(9).id(feather, bones).isEmpty() // Activate if we have items to be picking up
                && ctx.backpack.select().count() < 28
                && ctx.players.local().animation() == -1
                && !ctx.players.local().inMotion();
    }

    @Override
    public void execute() {
        for (GroundItem i : ctx.groundItems) {
            i.interact("Take", i.name()); // We supply the Item Name as the option to prevent it grabbing the wrong thing
        }
    }
}

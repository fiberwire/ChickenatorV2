package scripts;

import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.TilePath;

public class WalkToBank extends Task<ClientContext> {
    public WalkToBank(ClientContext ctx) {
        super(ctx);
        pathToBank = new TilePath(ctx, PATH);
    }
    public static final Tile[] PATH = {
            new Tile(3206, 3282, 0),  //In front of pen
            new Tile(3213, 3278, 0),
            new Tile(3215, 3269, 0),
            new Tile(3214, 3257, 0)  //Near bank chest
    };


    private TilePath pathToBank;

    @Override
    public boolean activate() {
        return ctx.backpack.select().count() >= 28
                && ctx.players.local().animation() == -1;
    }

    @Override
    public void execute() {
        pathToBank.traverse();
    }
}

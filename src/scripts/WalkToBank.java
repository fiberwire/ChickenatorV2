package scripts;

import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.TilePath;

public class WalkToBank extends Task<ClientContext> {
    public WalkToBank(ClientContext ctx) {
        super(ctx);
        pathToBank = new TilePath(ctx, PATH);
        pathToChicken = new TilePath(ctx, PATH).reverse();
    }
    public static final Tile[] PATH = {
            new Tile(3207, 3285, 0),  //In Pen
            new Tile(3213, 3278, 0),
            new Tile(3216, 3268, 0),
            new Tile(3216, 3261, 0)  //Near bank chest
    };


    private TilePath pathToBank, pathToChicken;

    @Override
    public boolean activate() {
        return ctx.backpack.select().count() == 28
                && ctx.players.local().inMotion();
    }

    @Override
    public void execute() {
        pathToBank.traverse();
    }
}

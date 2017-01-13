package scripts;

import org.powerbot.script.Area;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.TilePath;

public class WalkToChicken extends Task<ClientContext> {
    public WalkToChicken(ClientContext ctx) {
        super(ctx);
        pathToChicken = new TilePath(ctx, PATH).reverse();
    }
    public static final Tile[] PATH = {
            new Tile(3206, 3282, 0),  //In front of pen
            new Tile(3213, 3278, 0),
            new Tile(3215, 3269, 0),
            new Tile(3214, 3257, 0)  //Near bank chest
    };


    private TilePath pathToChicken;

    @Override
    public boolean activate() {
        return ctx.backpack.select().count() == 0
                || !ctx.players.local().WithinArea(new Area());
    }

    @Override
    public void execute() {
        pathToChicken.traverse();
    }
}

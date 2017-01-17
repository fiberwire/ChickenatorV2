package scripts;

import org.powerbot.script.Area;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.TilePath;

public class WalkToChicken extends Task<ClientContext> {
    public WalkToChicken(ClientContext ctx) {
        super(ctx);
        penArea = new Area(AttackChicken.nw, AttackChicken.se);
        pathToChicken = new TilePath(ctx, PATH).reverse();
    }

    public static final Tile[] PATH = {
            new Tile(3206, 3282, 0),  // In front of pen
            new Tile(3213, 3278, 0),
            new Tile(3215, 3269, 0),
            new Tile(3214, 3257, 0),  // Near bank chest
            new Tile(3231, 3228, 0),  // Near Lodestone
            new Tile(3227, 3234, 0),
            new Tile(3221, 3238, 0),
            new Tile(3219, 3263, 0),
            new Tile(3217, 3262, 0) // In front of bank area

    };

    Area penArea;
    private TilePath pathToChicken;

    @Override
    public boolean activate() {
        return ctx.backpack.select().count() == 0
                && !penArea.contains(ctx.players.local());
    }

    @Override
    public void execute() {
        pathToChicken.traverse();
    }
}

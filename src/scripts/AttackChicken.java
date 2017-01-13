package scripts;

import org.powerbot.script.Area;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.Actor;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;
import org.powerbot.script.rt6.Npc;

public class AttackChicken extends Task<ClientContext> {
    public AttackChicken(ClientContext ctx) {
        super(ctx);
        area = new Area(nw, se);
    }

    //corners
    public static Tile nw = new Tile(3204, 3287, 0);
    public static Tile se = new Tile(3210, 3279, 0);

    int[] chickenID = new int[]{1017, 41};
    Npc chicken;
    Area area;

    @Override
    public boolean activate() {
        return
                !ctx.npcs.within(area).id(chickenID).isEmpty()
                        && ctx.backpack.select().count() < 28
                        && ctx.players.local().animation() == -1;
    }

    @Override
    public void execute() {
        Npc chicken = ctx.npcs.id(chickenID).nearest().poll();
        chicken.interact("Attack");
    }
}

package scripts;

import org.powerbot.script.Area;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.Actor;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;
import org.powerbot.script.rt6.Npc;

public class Gate extends Task<ClientContext> {
    public Gate(ClientContext ctx) {
        super(ctx);
    }

    Tile nw = AttackChicken.nw;
    Tile se = AttackChicken.se;
    private int[] gateID = new int[]{45206, 45208};

    @Override
    public boolean activate() {
        return !ctx.objects.select().within(new Area(nw, se)).id(gateID).isEmpty()
                && ctx.players.local().animation() == -1;
    }

    @Override
    public void execute() {
        GameObject gate = ctx.objects.nearest().poll();
        if (gate.inViewport()) {
            gate.interact("Open");
        } else {
            ctx.movement.step(gate);
        }
    }
}
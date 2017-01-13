package scripts;

import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;
import org.powerbot.script.rt6.Item;

public class Bank extends Task<ClientContext> {
    public Bank(ClientContext ctx) {
        super(ctx);
    }
    private int chestID = 79036;
    GameObject chest = ctx.objects.id(chestID).nearest().poll();


    @Override
    public boolean activate() {
        return !ctx.bank.opened()
                && ctx.backpack.select().count() > 0;
    }

    @Override
    public void execute() {
        if (ctx.backpack.select().count() != 0) {
            ctx.bank.open();
            ctx.bank.depositInventory();
            ctx.bank.close();
        }
    }
}
    /*public void execute() {
        ctx.bank.open();
        for (Item i : ctx.backpack.select().id(526)) {
            i.interact("Deposit-All");
        }
    }
    */



package scripts;

import com.sun.xml.internal.ws.api.policy.PolicyResolver;
import org.powerbot.script.ClientAccessor;
import org.powerbot.script.ClientContext;

abstract class Task<C extends ClientContext> extends ClientAccessor<C> {
    public Task(C ctx) {
        super(ctx);
    }

    public abstract boolean activate();

    public abstract void execute();

}
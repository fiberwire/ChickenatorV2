package scripts

import com.sun.xml.internal.ws.api.policy.PolicyResolver
import org.powerbot.script.ClientAccessor
import org.powerbot.script.ClientContext

abstract class Task<C : ClientContext<*>>(ctx: C) : ClientAccessor<C>(ctx) {

    abstract fun activate(): Boolean

    abstract fun execute()
}
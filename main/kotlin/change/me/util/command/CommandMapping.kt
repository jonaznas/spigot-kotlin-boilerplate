package change.me.util.command

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class CommandMapping(val cmd: String)

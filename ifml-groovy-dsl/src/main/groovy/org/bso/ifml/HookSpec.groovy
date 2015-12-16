package org.bso.ifml


@groovy.transform.ToString(includeNames = true)
class HookSpec {
    String type
    String actionId
    Closure closure
}

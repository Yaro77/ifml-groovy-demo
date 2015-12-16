package org.bso.ifml

import groovy.transform.CompileStatic

@groovy.transform.ToString(includeNames = true)
class StoryRuntime {
    def globals = [:]
    def methods = [:]

    void showMessage(String message) {
      println message.stripMargin()
    }
    
    void goToLoc(String locationId) {
      println "${this.class.name}: Going to '$locationId'"
    }
    

    def propertyMissing(String name) {
      println "${this.class.name}: Resolving property $name (get)"
      if (!(name in globals))
          throw new MissingPropertyException("name")
      globals[name]
    }
    
    def propertyMissing(String name, value) {
      println "${this.class.name}: Resolving property $name (set)"
      globals[name] = value
    }
    
    def methodMissing(String name, args) {

      println "${this.class.name}: Resolving method $name"
        
        if (args.size() == 1 && (args[0] instanceof Closure)) {
            methods[name] = args[0]
        } else if (args.size == 0) {
            methods[name].call()
        }
    }

}

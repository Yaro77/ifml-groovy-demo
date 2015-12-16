
package org.bso.ifml

import java.nio.file.*

public class TestApp {
  public static void main(String[] args) {

    if (args.size() != 1) {
      printUsage()
      return
    }

    def scriptLoader = new StoryScriptLoader()
    def narrator = new Narrator(scriptLoader)

    def path = Paths.get(args[0]);

    narrator.runStory(path.toFile().toURI().toURL())


  }


  static void printUsage() {
    println "Usage testapp <story-script-file>"
    println "story-script-file: Groovy story script"
  }
}
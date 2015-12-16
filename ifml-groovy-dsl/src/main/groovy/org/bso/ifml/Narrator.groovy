package org.bso.ifml


import org.codehaus.groovy.control.CompilerConfiguration

class Narrator {

  final StoryScriptLoader scriptLoader

  Narrator(StoryScriptLoader scriptLoader) {
    assert scriptLoader != null
    this.scriptLoader = scriptLoader
  }

  void runStory(URL storyUrl) {
    def storyRuntime = new StoryRuntime()
    def storyText = scriptLoader.load(storyUrl);

    def compilerConfig = new CompilerConfiguration()
    compilerConfig.scriptBaseClass = StoryScript.class.name

    def shell = new GroovyShell(this.class.classLoader, new Binding(), compilerConfig)
    def script = shell.parse(storyText)
    script.run()
    println "exit"
  }
}
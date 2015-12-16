package org.bso.ifml



abstract class StoryScript extends Script {

  //StoryRuntime storyRuntime
  final StoryRuntime storyRuntime = new StoryRuntime()
  StorySpec storySpec

  void story(Closure storyConfiguration) {
    def storySpec = new StorySpec(storyRuntime)
    storyConfiguration.delegate = storySpec
    storyConfiguration.resolveStrategy = Closure.DELEGATE_ONLY
    storyConfiguration(storySpec)
    this.storySpec = storySpec
  }
}
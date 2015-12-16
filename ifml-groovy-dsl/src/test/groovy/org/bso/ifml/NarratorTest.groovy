package org.bso.ifml


import spock.lang.Specification


class NarratorTest extends Specification {

  def test() {
    given:
    def loader = new StoryScriptLoader()
    def narrator = new Narrator(loader)
    def storyUrl = this.class.classLoader.getResource("ruslan.groovy")

    when:
    narrator.runStory(storyUrl)

    then:
    true
  }

}
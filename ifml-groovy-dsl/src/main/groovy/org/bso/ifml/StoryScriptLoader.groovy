package org.bso.ifml



class StoryScriptLoader {
  final String DEFAULT_ENCODING = "UTF-8"
  
  String load(URL storyResource) {
    storyResource.getText(DEFAULT_ENCODING)
  }
}
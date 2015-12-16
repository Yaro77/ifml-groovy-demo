package org.bso.ifml


class LocationCollectionSpec {
    StorySpec storySpec
    StoryRuntime storyRuntime
    
    LocationCollectionSpec(StorySpec storySpec, StoryRuntime storyRuntime) {
        assert storySpec != null
        assert storyRuntime != null
        this.storySpec = storySpec
        this.storyRuntime = storyRuntime
    }

    void location(String id, Closure locationConfiguration) {
        def locationSpec = new LocationSpec(storyRuntime)
        locationSpec.id = id
        locationConfiguration.delegate = locationSpec
        locationConfiguration.resolveStrategy = Closure.DELEGATE_ONLY
        locationConfiguration(locationSpec)
        this.storySpec.locations << locationSpec
    }
}
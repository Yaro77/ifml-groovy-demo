package org.bso.ifml

@groovy.transform.ToString(includeNames = true)
class StorySpec {
    String storyStartLocation
    String storyStartProcedure
    
    @Delegate StoryRuntime storyRuntime
    def locations = []
    
    StorySpec(StoryRuntime storyRuntime) {
        assert storyRuntime != null
        this.storyRuntime = storyRuntime
    }
    
    void startLocation(String locationId) {
        this.storyStartLocation = locationId
    }
    
    void startProcedure(String procedure) {
        this.storyStartProcedure = procedure
    }
    
    void locations(Closure locationCollectionConfiguration) {
        def locationCollectionSpec = new LocationCollectionSpec(this, storyRuntime)
        locationCollectionConfiguration.delegate = locationCollectionSpec
        locationCollectionConfiguration.resolveStrategy = Closure.DELEGATE_ONLY
        locationCollectionConfiguration(locationCollectionSpec)
    }
}
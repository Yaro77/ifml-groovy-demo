package org.bso.ifml


@groovy.transform.ToString(includeNames = true)
class LocationSpec {
    String locationName
    String id
    String locationDescription
    String northLocation
    String southLocation
    String westLocation
    String eastLocation
    def hooks = []
    
    @Delegate final StoryRuntime storyRuntime
    
    LocationSpec(StoryRuntime storyRuntime) {
        assert storyRuntime != null
        this.storyRuntime = storyRuntime
    }

    void name(String name) {
        this.locationName = name
    }
    
    void description(String descr) {
        this.locationDescription = descr.stripMargin()
    }
    
    void north(String locationId) {
        this.northLocation = locationId
    }
    
    void south(String locationId) {
        this.southLocation = locationId
    }
    
    void west(String locationId) {
        this.westLocation = locationId
    }
    
    void east(String locationId) {
        this.eastLocation = locationId
    }
    
    void hooks(Closure hooksCollectionConfiguration) {
        def hooksCollectionSpec = new HooksCollectionSpec(this, storyRuntime)
        hooksCollectionConfiguration.delegate = hooksCollectionSpec
        hooksCollectionConfiguration.resolveStrategy = Closure.DELEGATE_ONLY
        hooksCollectionConfiguration(hooksCollectionSpec)
    }
}
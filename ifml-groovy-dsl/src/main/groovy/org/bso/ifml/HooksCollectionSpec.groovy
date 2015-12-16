package org.bso.ifml

class HooksCollectionSpec {

    final LocationSpec locationSpec
    @Delegate final StoryRuntime storyRuntime

    HooksCollectionSpec(LocationSpec locationSpec, StoryRuntime storyRuntime) {
        assert storyRuntime != null
        assert locationSpec != null
        this.storyRuntime = storyRuntime
        this.locationSpec = locationSpec
    }
    
    void registerHook(HookSpec hookSpec) {
        this.locationSpec.hooks << hookSpec
    }

    void instead(String actionId, Closure action) {
        def hookSpec = new HookSpec(type: "instead", actionId: actionId, closure: action)
        registerHook(hookSpec)
    }
}
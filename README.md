Latest version: [![](https://jitpack.io/v/boclips/events.svg)](https://jitpack.io/#boclips/event-bus)

# Compiling

**Enable Lombok**
1. Make sure you have the Lombok plugin for IntelliJ installed.
2. In `Preferences`, select `Build, Execution, Deployment`, then `Compiler`, then `Annotation Processors`.
3. Check the box for `Enable annotation processing`.
4. Hit `Apply` and `Ok`!

# Running tests
* Make sure to issue `direnv allow` in the terminal in order for an `.env` file with PubSub secret to be created.
* Check that the `envfile` IntelliJ plugin is installed.
* In the `Edit configurations` modal, check `Enable env file` and add the `.env` file to the list.

# Usage

**Set up jitpack:**
Add the repository, as described [here](https://jitpack.io/#boclips/event-bus)

**In build.gradle**:
```
dependencies {
  implementation("com.github.boclips:event-bus:<version>")

  testImplementation("org.springframework.cloud:spring-cloud-stream-test-support")
}
```

**Add annotation**:
```kotlin
@EnableBoclipsEvents
class MySpringBootApp
```

**Publishing events**:
```kotlin
@Autowired lateinit var eventBus: EventBus

val analysedVideo: AnalysedVideo = AnalysedVideo.builder().build()
eventBus.publish(videoToAnalyse) 
```

**Listening to events**:
```kotlin
@BoclipsEventListener
fun onVideoAnalysed(analysedVideo: AnalysedVideo) {
}
```

**Testing**:
The `event-bus` provides a fake which can be used for integration tests.

In your testing configuration, use `SynchronousFakeEventBus` which provides helper methods to inspect what is happening on the event bus.

For example:

```
eventBus.getEventOfType(VideoUpdated.class)
```

This will return the event of type VideoUpdated.

## Note
All Events ([see](src/main/java/com/boclips/event-bus/events)) are defined in this library, 
so that they can be shared among all services.

When adding a new topic, the name should:

- represent an event that has happened, e.g. video-indexed, rather than an intention, e.g. analyse-video
- conform to the noun-verbed convention, e.g. video-indexed, rather than indexed-video
- be the same name as the type of payload passing through it

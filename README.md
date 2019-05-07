Latest version: [![](https://jitpack.io/v/boclips/events.svg)](https://jitpack.io/#knowledgemotion/events)

# Usage

**Set up jitpack:**
Add the repository, as described [here](https://jitpack.io/#boclips/events)

**In build.gradle**:
```
implementation("org.springframework.cloud:spring-cloud-gcp-starter-pubsub")
implementation("org.springframework.cloud:spring-cloud-gcp-pubsub-stream-binder")
implementation("com.github.boclips:events:<version>")

testImplementation("org.springframework.cloud:spring-cloud-stream-test-support")
```

**Add annotation**:
```kotlin
@EnableBoclipsEvents(appName = "your-app-name")
class MySpringBootApp
```
`your-app-name` will be used as a subscription suffix.


**Publishing events**:
```kotlin
@Autowired lateinit var topics: Topics

val analysedVideo: AnalysedVideo = AnalysedVideo.builder().build()
topics.videosToAnalyse().send(MessageBuilder.withPayload(videoToAnalyse).build()) 
```

**Listening to events**:
```kotlin
@StreamListener(Subscriptions.ANALYSED_VIDEOS)
fun onVideoAnalysed(analysedVideo: AnalysedVideo) {
}
```

## Note
All Topics and Events ([see](src/main/java/com/boclips/events/types)) 
are defined in this library, so that they can be shared among all services.


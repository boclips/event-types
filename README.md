Latest version: [![](https://jitpack.io/v/boclips/events.svg)](https://jitpack.io/#knowledgemotion/events)

# Usage

**Set up jitpack:**
Add the repository, as described [here](https://jitpack.io/#boclips/events)

**In build.gradle**:
```
ext {
  set('springCloudVersion', 'Greenwich.SR1')
}

dependencies {
  implementation("org.springframework.cloud:spring-cloud-gcp-starter-pubsub")
  implementation("org.springframework.cloud:spring-cloud-gcp-pubsub-stream-binder")
  implementation("com.github.boclips:events:<version>")

  testImplementation("org.springframework.cloud:spring-cloud-stream-test-support")
}
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

**Testing**:
Add this to `application-test.yml` in order to run tests without access to PubSub:
```yml
spring:
  cloud:
    gcp:
      pubsub:
        enabled: false
```
With PubSub disabled, the app can still send and receive messages during test runs
because Spring instantiates all the necessary channels. A `MessageCollector` bean
can be autowired in tests and used for checking what messages have been sent to topics:
```kotlin
val message = messageCollector.forChannel(topics.analysedVideos()).poll()
assertThat(message.payload.toString()).contains("1234")
```

Testing event listeners is possible using channels available via the `Subscriptions` bean:
```kotlin
subscriptions.analysedVideos().send(MessageBuilder.withPayload(analysedVideo).build())
```

In order to avoid test pollution, it's a good practice to clear all topic channels
before each test:
```kotlin
messageCollector.forChannel(topics.analysedVideos()).clear()
```

## Note
All Topics and Events ([see](src/main/java/com/boclips/events/types)) 
are defined in this library, so that they can be shared among all services.

When adding a new topic, the name should:

- represent an event that has happened, e.g. video-indexed, rather than an intention, e.g. analyse-video
- conform to the noun-verbed convention, e.g. video-indexed, rather than indexed-video
- be the same name as the type of payload passing through it

